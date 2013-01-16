package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.CategoryDao;
import com.liuzheng.gem.model.Category;
import com.liuzheng.gem.service.CategoryService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "categoryService")
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category, Integer, CategoryDao> implements CategoryService {

	@Resource(name = "categoryDao", type = CategoryDao.class)
	private CategoryDao categoryDao;

	@Override
	public CategoryDao getDao() {

		return categoryDao;
	}

}
