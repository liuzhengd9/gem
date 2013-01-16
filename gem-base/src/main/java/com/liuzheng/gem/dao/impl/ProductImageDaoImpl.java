package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.ProductImageDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.ProductImage;

@Repository(value = "productImageDao")
public class ProductImageDaoImpl extends BaseDaoImpl<ProductImage, Integer> implements ProductImageDao {

	@Override
	public Class<ProductImage> getPersistenceClass() {

		return ProductImage.class;
	}

}
