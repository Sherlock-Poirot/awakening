package com.detective.stone.awakening.company.controller;


import com.detective.stone.awakening.company.annotation.Authority;
import com.detective.stone.awakening.company.common.RestResult;
import com.detective.stone.awakening.company.input.RoleInput;
import com.detective.stone.awakening.company.input.RoleUserInput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.detective.stone.awakening.company.service.RoleService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色  前端控制器
 * </p>
 *
 * @author Detective Stone Create time 2020-12-03
 */
@RestController
@RequestMapping("/role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping("/page")
  @Authority(menuId = 4)
  public RestResult getRolePages(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
      @RequestParam(required = false) String name) {
    return RestResult.success(roleService.rolePages(pageNum, pageSize, name));
  }

  @PostMapping("/insert")
  @Authority(menuId = 4, display = "新增角色")
  public RestResult insertRole(@RequestBody RoleInput input) {
    return RestResult.success(roleService.insert(input));
  }

  @PostMapping("/grantRole")
  @Authority(menuId = 4, display = "授予角色")
  public RestResult grantRole(@RequestBody RoleUserInput input) {
    return RestResult.success(roleService.grantRole(input));
  }
}
