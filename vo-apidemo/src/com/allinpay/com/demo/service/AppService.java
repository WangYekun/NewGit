package com.allinpay.com.demo.service;

import java.util.Map;

import com.allinpay.com.demo.bean.QueryRsp;

public interface AppService {
	/**
	 * 订单查询
	 * @param params
	 * @return
	 */
	public QueryRsp queryOrder(Map params);
}
