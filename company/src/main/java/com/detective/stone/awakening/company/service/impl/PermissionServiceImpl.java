package com.detective.stone.awakening.company.service.impl;

import com.detective.stone.awakening.company.model.Permission;
import com.detective.stone.awakening.company.dao.PermissionMapper;
import com.detective.stone.awakening.company.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限  服务实现类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

  @Autowired
  private PermissionMapper permissionMapper;

  @Override
  public void truncate() {
    permissionMapper.truncate();
  }
}
