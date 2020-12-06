package com.detective.stone.awakening.company.controller;


import com.detective.stone.awakening.company.annotation.Authority;
import com.detective.stone.awakening.company.common.RestResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.detective.stone.awakening.company.service.MenuService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单  前端控制器
 * </p>
 *
 * @author Detective Stone Create time 2020-12-03
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

  @Autowired
  private MenuService menuService;

  @GetMapping("/tree")
  @Authority(menuId = 2)
  public RestResult getMenuTree() {
    return RestResult.success(menuService.getMenuTree());
  }

}
