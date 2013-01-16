package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.OrderDetailDao;
import com.liuzheng.gem.model.OrderDetail;
import com.liuzheng.gem.service.OrderDetailService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "orderDetailService")
@Transactional
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, Integer, OrderDetailDao> implements OrderDetailService {

	@Resource(name = "orderDetailDao", type = OrderDetailDao.class)
	private OrderDetailDao orderDetailDao;

	@Override
	public OrderDetailDao getDao() {

		return orderDetailDao;
	}

}
