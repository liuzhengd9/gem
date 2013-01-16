package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.OrderDetailDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.OrderDetail;

@Repository(value = "orderDetailDao")
public class OrderDetailDaoImpl extends BaseDaoImpl<OrderDetail, Integer> implements OrderDetailDao {

	@Override
	public Class<OrderDetail> getPersistenceClass() {

		return OrderDetail.class;
	}

}
