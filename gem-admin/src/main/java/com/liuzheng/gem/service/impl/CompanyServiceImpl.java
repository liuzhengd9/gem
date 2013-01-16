package com.liuzheng.gem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuzheng.gem.dao.CompanyDao;
import com.liuzheng.gem.model.Company;
import com.liuzheng.gem.service.CompanyService;
import com.liuzheng.gem.service.base.BaseServiceImpl;

@Service(value = "companyService")
@Transactional
public class CompanyServiceImpl extends BaseServiceImpl<Company, Integer, CompanyDao> implements CompanyService {

	@Resource(name = "companyDao", type = CompanyDao.class)
	private CompanyDao companyDao;

	@Override
	public CompanyDao getDao() {

		return companyDao;
	}

}
