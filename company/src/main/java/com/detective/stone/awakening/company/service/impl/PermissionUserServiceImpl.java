package com.detective.stone.awakening.company.service.impl;

import com.detective.stone.awakening.company.model.PermissionUser;
import com.detective.stone.awakening.company.dao.PermissionUserMapper;
import com.detective.stone.awakening.company.service.PermissionUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限用户关联表  服务实现类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
@Service
public class PermissionUserServiceImpl extends ServiceImpl<PermissionUserMapper, PermissionUser> implements
    PermissionUserService {

}
