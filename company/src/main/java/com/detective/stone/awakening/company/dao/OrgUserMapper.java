package com.detective.stone.awakening.company.dao;

import com.detective.stone.awakening.company.model.OrgUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.detective.stone.awakening.company.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 组织机构用户关联表 组织机构用户关联表 Mapper 接口
 * </p>
 *
 * @author Detective Stone
 * @since 2020-11-24
 */
@Mapper
public interface OrgUserMapper extends CommonMapper<OrgUser> {

}
