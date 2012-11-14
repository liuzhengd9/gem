package com.liuzheng.gem.service;

import java.util.List;

import com.liuzheng.gem.dao.MenuDao;
import com.liuzheng.gem.model.Menu;
import com.liuzheng.gem.service.base.BaseService;

public interface MenuService extends BaseService<Menu, Integer, MenuDao> {

	public List<Menu> findAll();

	public void drag(int sourceId, int targetId);
}
