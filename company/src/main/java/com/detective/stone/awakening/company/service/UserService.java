package com.detective.stone.awakening.company.service;

import com.detective.stone.awakening.company.input.UserInput;
import com.detective.stone.awakening.company.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户 用户 服务类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-11-24
 */
public interface UserService extends IService<User> {

  String insert(UserInput input);

  User getUserByUsername(String username);

  Set<String> getPermissionsByUserId(Integer id);
}
