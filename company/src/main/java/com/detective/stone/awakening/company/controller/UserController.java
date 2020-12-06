package com.detective.stone.awakening.company.controller;


import com.detective.stone.awakening.company.annotation.Authority;
import com.detective.stone.awakening.company.common.RestResult;
import com.detective.stone.awakening.company.input.UserInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.detective.stone.awakening.company.service.UserService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 用户 前端控制器
 * </p>
 *
 * @author Detective Stone Create time 2020-11-24
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("insert")
  @Authority(menuId = 5, display = "新增用户")
  public RestResult insert(@RequestBody UserInput input) {
    return RestResult.success(userService.insert(input));
  }
}
