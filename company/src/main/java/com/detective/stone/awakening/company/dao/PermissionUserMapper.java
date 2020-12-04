package com.detective.stone.awakening.company.dao;

import com.detective.stone.awakening.company.model.PermissionUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.detective.stone.awakening.company.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限用户关联表  Mapper 接口
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
@Mapper
public interface PermissionUserMapper extends CommonMapper<PermissionUser> {

}
