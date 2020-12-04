package com.detective.stone.awakening.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.detective.stone.awakening.company.input.UserInput;
import com.detective.stone.awakening.company.model.MenuUser;
import com.detective.stone.awakening.company.model.OrgUser;
import com.detective.stone.awakening.company.model.Permission;
import com.detective.stone.awakening.company.model.PermissionRole;
import com.detective.stone.awakening.company.model.PermissionUser;
import com.detective.stone.awakening.company.model.RoleUser;
import com.detective.stone.awakening.company.model.User;
import com.detective.stone.awakening.company.dao.UserMapper;
import com.detective.stone.awakening.company.service.MenuUserService;
import com.detective.stone.awakening.company.service.OrgUserService;
import com.detective.stone.awakening.company.service.PermissionRoleService;
import com.detective.stone.awakening.company.service.PermissionService;
import com.detective.stone.awakening.company.service.PermissionUserService;
import com.detective.stone.awakening.company.service.RoleUserService;
import com.detective.stone.awakening.company.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户 用户 服务实现类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-11-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private OrgUserService orgUserService;

  @Autowired
  private MenuUserService menuUserService;

  @Autowired
  private RoleUserService roleUserService;

  @Autowired
  private PermissionUserService permissionUserService;

  @Autowired
  private PermissionRoleService permissionRoleService;

  @Autowired
  private PermissionService permissionService;

  @Transactional
  @Override
  public String insert(UserInput input) {
    User user = new User();
    BeanUtils.copyProperties(input, user);
    ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
    String defaultPwd = new SimpleHash("MD5", "123456", credentialsSalt, 1024).toHex();
    user.setPassword(defaultPwd);
    userMapper.insert(user);
    orgUserService.save(
        OrgUser.builder().organizationId(input.getOrganizationId()).position(input.getPosition()).userId(user.getId()).build());
    return "操作成功";
  }

  @Override
  public User getUserByUsername(String username) {
    return userMapper.searchOne("username", username);
  }

  @Override
  public Set<String> getPermissionsByUserId(Integer userId) {
    List<Permission> permissions = new ArrayList<>();

    // 获取所有的get请求权限
    QueryWrapper<MenuUser> menuUserQueryWrapper = new QueryWrapper<>();
    menuUserQueryWrapper.eq("user_id", userId);
    List<Integer> menuIds = menuUserService.list(menuUserQueryWrapper).stream().map(MenuUser::getMenuId)
        .collect(Collectors.toList());
    if (!menuIds.isEmpty()) {
      QueryWrapper<Permission> permissionQueryWrapper = new QueryWrapper<>();
      permissionQueryWrapper.in("menu_id", menuIds).eq("get_request", true);
      permissions.addAll(permissionService.list(permissionQueryWrapper));
    }
    // 获取所有直接 和间接（授予角色）的权限
    QueryWrapper<PermissionUser> permissionUserQueryWrapper = new QueryWrapper<>();
    List<Integer> permissionIds = permissionUserService.list(permissionUserQueryWrapper).stream()
        .map(PermissionUser::getPermissionId).collect(
            Collectors.toList());
    QueryWrapper<RoleUser> roleUserQueryWrapper = new QueryWrapper<>();
    roleUserQueryWrapper.eq("user_id", userId);
    List<Integer> roleIds = roleUserService.list(roleUserQueryWrapper).stream().map(RoleUser::getRoleId)
        .collect(Collectors.toList());
    if (!roleIds.isEmpty()) {
      QueryWrapper<PermissionRole> permissionRoleQueryWrapper = new QueryWrapper<>();
      permissionRoleQueryWrapper.in("role_id", roleIds);
      permissionIds
          .addAll(permissionRoleService.list(permissionRoleQueryWrapper).stream().map(PermissionRole::getPermissionId).collect(
              Collectors.toList()));
    }
    if (!permissionIds.isEmpty()) {
      permissions.addAll(permissionService.listByIds(permissionIds));
    }
    return permissions.stream().map(Permission::getName).collect(Collectors.toSet());
  }
}
