package com.detective.stone.awakening.company.dao;

import com.detective.stone.awakening.company.model.Organization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.detective.stone.awakening.company.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 组织架构 Mapper 接口
 * </p>
 *
 * @author Detective Stone
 * @since 2020-11-24
 */
@Mapper
public interface OrganizationMapper extends CommonMapper<Organization> {

}
