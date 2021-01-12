package com.detective.stone.awakening.company.controller;

import com.detective.stone.awakening.company.common.RestResult;
import com.detective.stone.awakening.company.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("/hello")
  public RestResult hello() {
    return RestResult.success("hello world!");
  }
}
