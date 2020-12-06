package com.detective.stone.awakening.company.controller;


import com.detective.stone.awakening.company.annotation.Authority;
import com.detective.stone.awakening.company.common.RestResult;
import com.detective.stone.awakening.company.input.OrganizationInput;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.detective.stone.awakening.company.service.OrganizationService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 组织架构 前端控制器
 * </p>
 *
 * @author Detective Stone Create time 2020-11-24
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {

  @Autowired
  private OrganizationService organizationService;

  @GetMapping("/tree")
  @Authority(menuId = 1)
  public RestResult getTree() {
    return RestResult.success(organizationService.getTree());
  }

  @GetMapping("/list")
  @Authority(menuId = 1)
  public RestResult list(@RequestParam Integer parentId, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
    return RestResult.success(organizationService.getOrganizations(parentId, pageNum, pageSize));
  }

  @GetMapping("/detail")
  @Authority(menuId = 1)
  public RestResult getDetail(@RequestParam Integer id) {
    return RestResult.success(organizationService.getDetail(id));
  }

  @PostMapping("/insert")
  @Authority(menuId = 1, display = "新增组织机构")
  public RestResult insert(@RequestBody OrganizationInput input) {
    return RestResult.success(organizationService.insert(input));
  }

  @PostMapping("/update")
  @Authority(menuId = 1, display = "更行组织机构")
  public RestResult update(@RequestBody OrganizationInput input) {
    return RestResult.success(organizationService.update(input));
  }

  @PostMapping("/delete")
  @Authority(menuId = 1, display = "删除组织机构")
  public RestResult delete(@RequestBody List<Integer> ids) {
    return RestResult.success(organizationService.delete(ids));
  }
}
