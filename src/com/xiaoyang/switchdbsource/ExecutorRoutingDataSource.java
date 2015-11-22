package com.xiaoyang.switchdbsource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.xiaoyang.controller.interceptor.LoginHandlerInterceptor;

public class ExecutorRoutingDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return LoginHandlerInterceptor.determineCurrentDataSource();
	}

}
