package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.OrderDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Order;

@Repository(value = "orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order, Integer> implements OrderDao {

	@Override
	public Class<Order> getPersistenceClass() {

		return Order.class;
	}

}
