package com.detective.stone.awakening.company.service;

import com.detective.stone.awakening.company.dto.OrganizationTreeDTO;
import com.detective.stone.awakening.company.input.OrganizationInput;
import com.detective.stone.awakening.company.model.Organization;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * <p>
 * 组织架构 服务类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-11-24
 */
public interface OrganizationService extends IService<Organization> {

  List<OrganizationTreeDTO> getTree();

  PageInfo<Organization> getOrganizations(Integer parentId, Integer pageNum, Integer pageSize);

  Organization getDetail(Integer id);

  String insert(OrganizationInput input);

  String update(OrganizationInput input);

  String delete(List<Integer> ids);
}
