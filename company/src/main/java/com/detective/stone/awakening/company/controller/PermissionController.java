package com.detective.stone.awakening.company.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.detective.stone.awakening.company.service.PermissionService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 权限  前端控制器
 * </p>
 *
 * @author Detective Stone Create time 2020-12-03
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

  @Autowired
  private PermissionService permissionService;
}
