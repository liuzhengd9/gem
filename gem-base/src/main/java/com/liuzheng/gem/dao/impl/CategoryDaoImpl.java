package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.CategoryDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Category;

@Repository(value = "categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category, Integer> implements CategoryDao {

	@Override
	public Class<Category> getPersistenceClass() {

		return Category.class;
	}

}
