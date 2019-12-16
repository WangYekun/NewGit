package service;

import bean.QueryRsp;

import java.util.Map;

public interface AppService {
    /**
     * 订单查询
     *
     * @param params
     * @return
     */
    public QueryRsp queryOrder(Map params);
}
