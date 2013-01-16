package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.RelationManagerMenuDao;
import com.liuzheng.gem.model.RelationManagerMenu;
import com.liuzheng.gem.service.RelationManagerMenuService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "relationManagerMenuService")
@Transactional
public class RelationManagerMenuServiceImpl extends BaseServiceImpl<RelationManagerMenu, Integer, RelationManagerMenuDao> implements RelationManagerMenuService {

	@Resource(name = "relationManagerMenuDao", type = RelationManagerMenuDao.class)
	private RelationManagerMenuDao relationManagerMenuDao;

	@Override
	public RelationManagerMenuDao getDao() {

		return relationManagerMenuDao;
	}

}
