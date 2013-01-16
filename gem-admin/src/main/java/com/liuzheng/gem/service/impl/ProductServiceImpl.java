package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.ProductDao;
import com.liuzheng.gem.model.Product;
import com.liuzheng.gem.service.ProductService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "productService")
@Transactional
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer, ProductDao> implements ProductService {

	@Resource(name = "productDao", type = ProductDao.class)
	private ProductDao productDao;

	@Override
	public ProductDao getDao() {

		return productDao;
	}

}
