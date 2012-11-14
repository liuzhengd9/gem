package com.liuzheng.gem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.MenuDao;
import com.liuzheng.gem.model.Menu;
import com.liuzheng.gem.service.MenuService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "menuService")
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu, Integer, MenuDao> implements MenuService {

	@Resource(name = "menuDao", type = MenuDao.class)
	private MenuDao menuDao;

	@Override
	public MenuDao getDao() {

		return menuDao;
	}

	@Override
	public List<Menu> findAll() {

		return super.find("from Menu m where m.parentId is null order by m.text asc");
	}

	@Override
	public void drag(int sourceId, int targetId) {

		Menu menu = super.get(sourceId);
		menu.setParentId(targetId == 0 ? null : targetId);
		super.saveOrUpdate(menu);
	}

}
