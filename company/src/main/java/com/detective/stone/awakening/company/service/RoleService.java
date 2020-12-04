package com.detective.stone.awakening.company.service;

import com.detective.stone.awakening.company.input.RoleInput;
import com.detective.stone.awakening.company.input.RoleUserInput;
import com.detective.stone.awakening.company.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 角色  服务类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
public interface RoleService extends IService<Role> {

  PageInfo<Role> rolePages(Integer pageNum, Integer pageSize, String name);

  String insert(RoleInput input);

  String grantRole(RoleUserInput input);
}
