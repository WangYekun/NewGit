package com.allinpay.syb.test;

import com.allinpay.syb.lib.SybPayService;

import java.util.Map;


public class ApiTestV2 {
    public static void main(String[] args) throws Exception {
        testPay();
//        testCancel();
//        testRefund();
//        testQuery();
    }

    public static void testQuery() throws Exception {
        SybPayService service = new SybPayService();
        Map<String, String> map = service.query("", "103276577");
        print(map);
    }

    public static void testRefund() throws Exception {
        SybPayService service = new SybPayService();
        String reqsn = String.valueOf(System.currentTimeMillis());
        Map<String, String> map = service.refund(1, reqsn, "", "20160712167578.2547");
        print(map);
    }

    public static void testCancel() throws Exception {
        SybPayService service = new SybPayService();
        String reqsn = String.valueOf(System.currentTimeMillis());
        Map<String, String> map = service.cancel(1, reqsn, "103759586", "");
        print(map);
    }

    public static void testPay() throws Exception {
        SybPayService service = new SybPayService();
        String reqsn = String.valueOf(System.currentTimeMillis());
        service.pay(1, reqsn, "", "标题", "备注");

    }

    public static void print(Map<String, String> map) {
        System.out.println("返回数据如下:");
        if (map != null) {
            for (String key : map.keySet()) {
                System.out.println(key + ";" + map.get(key));
            }
        }
    }

}
