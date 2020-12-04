package com.detective.stone.awakening.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.detective.stone.awakening.company.input.RoleInput;
import com.detective.stone.awakening.company.input.RoleUserInput;
import com.detective.stone.awakening.company.model.Role;
import com.detective.stone.awakening.company.dao.RoleMapper;
import com.detective.stone.awakening.company.model.RoleUser;
import com.detective.stone.awakening.company.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.detective.stone.awakening.company.service.RoleUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色  服务实现类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

  @Autowired
  private RoleMapper roleMapper;

  @Autowired
  private RoleUserService roleUserService;

  @Override
  public PageInfo<Role> rolePages(Integer pageNum, Integer pageSize, String name) {
    QueryWrapper<Role> wrapper = new QueryWrapper<>();
    wrapper.like("name", name);
    return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> roleMapper.selectList(wrapper));
  }

  @Override
  public String insert(RoleInput input) {
    Role role = new Role();
    BeanUtils.copyProperties(input, role);
    save(role);
    return "操作成功";
  }

  @Override
  public String grantRole(RoleUserInput input) {
    List<RoleUser> roleUsers = new ArrayList<>(input.getUserIds().size());
    for (Integer userId : input.getUserIds()) {
      RoleUser model = new RoleUser();
      model.setUserId(userId);
      model.setRoleId(input.getRoleId());
      roleUsers.add(model);
    }
    roleUserService.saveBatch(roleUsers);
    return "操作成功";
  }
}
