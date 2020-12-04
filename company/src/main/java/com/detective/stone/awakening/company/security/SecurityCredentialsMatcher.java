package com.detective.stone.awakening.company.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 自定义密码匹配器
 */
public class SecurityCredentialsMatcher implements CredentialsMatcher {

  @Override
  public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
    UsernamePasswordToken utoken = (UsernamePasswordToken) token;
    //获得用户输入的密码 明文
    String inPassword = new String(utoken.getPassword());
    //获得数据库中的密码
    String dbPassword = (String) info.getCredentials();
    // 对明文加密
    ByteSource credentialsSalt = ByteSource.Util.bytes(utoken.getUsername());
    inPassword = new SimpleHash("MD5", inPassword, credentialsSalt, 1024).toHex();
    //进行密码的比对
    if (!inPassword.equals(dbPassword)) {
      throw new IncorrectCredentialsException("用户不存在或密码错误");
    }
    return true;
  }
}
