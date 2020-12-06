package com.detective.stone.awakening.company.service;

import com.detective.stone.awakening.company.model.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Collection;

/**
 * <p>
 * 权限  服务类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
public interface PermissionService extends IService<Permission> {

  void truncate();

}
