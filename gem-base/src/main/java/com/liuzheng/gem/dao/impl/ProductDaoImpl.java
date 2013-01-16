package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.ProductDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Product;

@Repository(value = "productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product, Integer> implements ProductDao {

	@Override
	public Class<Product> getPersistenceClass() {

		return Product.class;
	}

}
