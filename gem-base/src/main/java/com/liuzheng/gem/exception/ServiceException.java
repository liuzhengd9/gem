package com.liuzheng.gem.exception;

import org.springframework.dao.DataAccessException;

public class ServiceException extends DataAccessException {

	private static final long serialVersionUID = -8822235527717555950L;

	public ServiceException(String msg) {

		super(msg);
	}
}
