package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.OrderDao;
import com.liuzheng.gem.model.Order;
import com.liuzheng.gem.service.OrderService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "orderService")
@Transactional
public class OrderServiceImpl extends BaseServiceImpl<Order, Integer, OrderDao> implements OrderService {

	@Resource(name = "orderDao", type = OrderDao.class)
	private OrderDao orderDao;

	@Override
	public OrderDao getDao() {

		return orderDao;
	}

}
