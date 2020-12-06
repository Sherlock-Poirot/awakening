package com.detective.stone.awakening.company.service;

import com.detective.stone.awakening.company.dto.MenuTreeDTO;
import com.detective.stone.awakening.company.model.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 * 菜单  服务类
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
public interface MenuService extends IService<Menu> {

  List<MenuTreeDTO> getMenuTree();
}
