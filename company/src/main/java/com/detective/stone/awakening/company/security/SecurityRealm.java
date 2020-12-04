package com.detective.stone.awakening.company.security;

import com.detective.stone.awakening.company.model.User;
import com.detective.stone.awakening.company.service.PermissionService;
import com.detective.stone.awakening.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class SecurityRealm extends AuthorizingRealm {

  @Autowired
  private UserService userService;

  /**
   * authorization[ˌɔːθəraɪˈzeɪʃn] 用户授权方法 principalCollection 认证通过后的用户信息和AuthenticationInfo相互对应，多realm认证时返回的可能是哥集合
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    User user = (User) principalCollection.getPrimaryPrincipal();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    log.info("userId:{}", user.getId());
    // 添加权限
    info.addStringPermissions(userService.getPermissionsByUserId(user.getId()));
    return info;
  }

  /**
   * authentication[ɔːˌθentɪˈkeɪʃn] 用户认证方法
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    // 获取登录者的账户名
    String username = (String) token.getPrincipal();
    // 查询改账户是否存在
    User user = userService.getUserByUsername(username);
    if (user == null) {
      throw new UnknownAccountException("该账号不存在");
    }
    //盐值
    ByteSource salt = ByteSource.Util.bytes(user.getUsername());
    return new SimpleAuthenticationInfo(user, user.getPassword(), salt, getName());
  }
}
