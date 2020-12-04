package com.detective.stone.awakening.company.controller;


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

}
