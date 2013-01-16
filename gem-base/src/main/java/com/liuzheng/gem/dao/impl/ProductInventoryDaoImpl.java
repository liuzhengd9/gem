package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.ProductInventoryDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.ProductInventory;

@Repository(value = "productInventoryDao")
public class ProductInventoryDaoImpl extends BaseDaoImpl<ProductInventory, Integer> implements ProductInventoryDao {

	@Override
	public Class<ProductInventory> getPersistenceClass() {

		return ProductInventory.class;
	}

}
