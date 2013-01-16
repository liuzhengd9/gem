package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.ProductImageDao;
import com.liuzheng.gem.model.ProductImage;
import com.liuzheng.gem.service.ProductImageService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "productImageService")
@Transactional
public class ProductImageServiceImpl extends BaseServiceImpl<ProductImage, Integer, ProductImageDao> implements ProductImageService {

	@Resource(name = "productImageDao", type = ProductImageDao.class)
	private ProductImageDao productImageDao;

	@Override
	public ProductImageDao getDao() {

		return productImageDao;
	}

}
