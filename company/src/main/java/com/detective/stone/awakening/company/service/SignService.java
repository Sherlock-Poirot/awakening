package com.detective.stone.awakening.company.service;

import com.detective.stone.awakening.company.common.RestResult;
import com.detective.stone.awakening.company.input.LoginInput;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Service;

@Service
public class SignService {

  public String login(LoginInput input) {
    // TODO
    UsernamePasswordToken token = new UsernamePasswordToken(input.getUsername(), input.getPassword());
    SecurityUtils.getSubject().login(token);
    return "操作成功";
  }

  public void logout() {
    SecurityUtils.getSubject().logout();
  }
}
