package com.detective.stone.awakening.company.controller;

import com.detective.stone.awakening.company.common.RestResult;
import com.detective.stone.awakening.company.input.LoginInput;
import com.detective.stone.awakening.company.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {

  public static final String LOGIN_PATCH = "/sign/login";

  public static final String LOGOUT_PATCH = "/sign/logout";

  @Autowired
  private SignService signService;

  @PostMapping(LOGIN_PATCH)
  public RestResult login(@RequestBody LoginInput input) {
    return RestResult.success(signService.login(input));
  }

  @PostMapping(LOGOUT_PATCH)
  public RestResult logout() {
    signService.logout();
    return RestResult.success();
  }
}
