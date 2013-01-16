package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.ProductInventoryDao;
import com.liuzheng.gem.model.ProductInventory;
import com.liuzheng.gem.service.ProductInventoryService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "productInventoryService")
@Transactional
public class ProductInventoryServiceImpl extends BaseServiceImpl<ProductInventory, Integer, ProductInventoryDao> implements ProductInventoryService {

	@Resource(name = "productInventoryDao", type = ProductInventoryDao.class)
	private ProductInventoryDao productInventoryDao;

	@Override
	public ProductInventoryDao getDao() {

		return productInventoryDao;
	}

}
