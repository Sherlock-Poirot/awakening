package com.detective.stone.oauth2server.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping("/getCurrentUser")
  public Object getCurrentUser(Authentication authentication) {
    return authentication.getPrincipal();
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

  @RequestMapping("/hello2")
  public String hello2(String str) {
    return "hello";
  }

}
