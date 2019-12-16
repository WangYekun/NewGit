package demo.service;

import demo.bean.QueryRsp;

import java.util.Map;

public interface AppService {
    /**
     * 订单查询
     *
     * @param params
     * @return
     */
    QueryRsp queryOrder(Map params);
}
