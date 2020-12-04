package com.detective.stone.awakening.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.detective.stone.awakening.company.dto.OrganizationTreeDTO;
import com.detective.stone.awakening.company.input.OrganizationInput;
import com.detective.stone.awakening.company.model.OrgUser;
import com.detective.stone.awakening.company.model.Organization;
import com.detective.stone.awakening.company.dao.OrganizationMapper;
import com.detective.stone.awakening.company.service.OrgUserService;
import com.detective.stone.awakening.company.service.OrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 组织架构 服务实现类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-11-24
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

  @Autowired
  private OrganizationMapper organizationMapper;

  @Autowired
  private OrgUserService orgUserService;

  @Override
  public List<OrganizationTreeDTO> getTree() {
    QueryWrapper<Organization> wrapper = new QueryWrapper<>();
    List<Organization> organizations = organizationMapper.selectList(wrapper);
    return setChildren(0, organizations, organizations.iterator());
  }

  @Override
  public PageInfo<Organization> getOrganizations(Integer parentId, Integer pageNum, Integer pageSize) {
    QueryWrapper<Organization> wrapper = new QueryWrapper<>();
    wrapper.eq("parent_id", parentId).or().eq("id", parentId);
    return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> organizationMapper.selectList(wrapper));
  }

  @Override
  public Organization getDetail(Integer id) {
    return organizationMapper.selectById(id);
  }

  @Override
  public String insert(OrganizationInput input) {
    Organization organization = new Organization();
    BeanUtils.copyProperties(input, organization);
    organizationMapper.insert(organization);
    return "操作成功";
  }

  @Override
  public String update(OrganizationInput input) {
    Organization organization = new Organization();
    BeanUtils.copyProperties(input, organization);
    organizationMapper.updateById(organization);
    return "操作成功";
  }

  @Transactional
  @Override
  public String delete(List<Integer> ids) {
    QueryWrapper<OrgUser> orgUserQueryWrapper = new QueryWrapper<>();
    orgUserQueryWrapper.in("organization_id", ids);
    List<OrgUser> orgUsers = orgUserService.list(orgUserQueryWrapper);
    if (!orgUsers.isEmpty()) {
      // TODO 抛出异常
    }
    orgUserService.removeByIds(orgUsers.stream().map(OrgUser::getId).collect(Collectors.toList()));
    removeByIds(ids);
    return "操作成功";
  }

  private List<OrganizationTreeDTO> setChildren(Integer parentId, List<Organization> organizations,
      Iterator<Organization> iterator) {
    List<OrganizationTreeDTO> list = new ArrayList<>();
    while (iterator.hasNext()) {
      Organization organization = iterator.next();
      if (parentId.equals(organization.getParentId())) {
        OrganizationTreeDTO dto = OrganizationTreeDTO.builder().id(organization.getId())
            .name(organization.getName()).parentId(parentId).serial(organization.getSerial()).build();
        dto.setChildren(new ArrayList<>());
        list.add(dto);
        iterator.remove();
      }
    }
    for (OrganizationTreeDTO dto : list) {
      iterator = organizations.iterator();
      dto.setChildren(setChildren(dto.getId(), organizations, iterator));
    }
    return list;
  }
}
