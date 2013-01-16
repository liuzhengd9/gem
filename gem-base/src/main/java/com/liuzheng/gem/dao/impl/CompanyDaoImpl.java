package com.liuzheng.gem.dao.impl;

import org.springframework.stereotype.Repository;

import com.liuzheng.gem.dao.CompanyDao;
import com.liuzheng.gem.dao.base.BaseDaoImpl;
import com.liuzheng.gem.model.Company;

@Repository(value = "companyDao")
public class CompanyDaoImpl extends BaseDaoImpl<Company, Integer> implements CompanyDao {

	@Override
	public Class<Company> getPersistenceClass() {

		return Company.class;
	}

}
