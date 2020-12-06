package com.detective.stone.awakening.company.dao;

import com.detective.stone.awakening.company.model.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.detective.stone.awakening.company.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限  Mapper 接口
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
@Mapper
public interface PermissionMapper extends CommonMapper<Permission> {

  void truncate();
}
