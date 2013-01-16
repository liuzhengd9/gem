package com.liuzheng.gem.web.adapter;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;

public class TimeoutCallableProcessingInterceptor extends CallableProcessingInterceptorAdapter {

	private final Logger logger = Logger.getLogger(getClass());

	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {

		logger.info("timeout");
		return "welcome";
	}

}
