package com.allinpay.syb.lib;

import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public class SybPayService {
    public void pay(long trxamt, String reqsn, String body, String remark, String notify_url) throws Exception {
        //		HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL+"/pay");
        //		http.init();
        StringBuilder sb = new StringBuilder();
        TreeMap<String, String> params = new TreeMap<>();
        params.put("cusid", SybConstants.SYB_CUSID);
        params.put("appid", SybConstants.SYB_APPID);
        params.put("version", "12");
        params.put("trxamt", String.valueOf(trxamt));
        params.put("reqsn", reqsn);
        params.put("charset", "utf-8");
        params.put("returl", "http://baidu.com");
        params.put("notify_url", notify_url);
        params.put("body", body);
        params.put("remark", remark);
        params.put("randomstr", SybUtil.getValidatecode(8));
        params.put("sign", SybUtil.sign(params, SybConstants.SYB_APPKEY));
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append("&");
        }
        System.out.println("https://test.allinpaygd.com/apiweb/h5unionpay/unionorder?" + sb.substring(0, sb.length() - 1));
        //		byte[] bys = http.postParams(params, true);
        //		String result = new String(bys,"UTF-8");
        //		Map<String,String> map = handleResult(result);
        //		return map;

    }

    public Map<String, String> cancel(long trxamt, String reqsn, String oldtrxid, String oldreqsn) throws Exception {
        HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL + "/cancel");
        http.init();
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("cusid", SybConstants.SYB_CUSID);
        params.put("appid", SybConstants.SYB_APPID);
        params.put("version", "11");
        params.put("trxamt", String.valueOf(trxamt));
        params.put("reqsn", reqsn);
        params.put("oldtrxid", oldtrxid);
        params.put("oldreqsn", oldreqsn);
        params.put("randomstr", SybUtil.getValidatecode(8));
        params.put("sign", SybUtil.sign(params, SybConstants.SYB_APPKEY));
        byte[] bys = http.postParams(params, true);
        String result = new String(bys, "UTF-8");
        return handleResult(result);
    }

    public Map<String, String> refund(long trxamt, String reqsn, String oldtrxid, String oldreqsn) throws Exception {
        HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL + "/refund");
        http.init();
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("cusid", SybConstants.SYB_CUSID);
        params.put("appid", SybConstants.SYB_APPID);
        params.put("version", "11");
        params.put("trxamt", String.valueOf(trxamt));
        params.put("reqsn", reqsn);
        params.put("oldreqsn", oldreqsn);
        params.put("oldtrxid", oldtrxid);
        params.put("randomstr", SybUtil.getValidatecode(8));
        params.put("sign", SybUtil.sign(params, SybConstants.SYB_APPKEY));
        byte[] bys = http.postParams(params, true);
        String result = new String(bys, "UTF-8");
        return handleResult(result);
    }

    public Map<String, String> query(String reqsn, String trxid) throws Exception {
        HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL + "/query");
        http.init();
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("cusid", SybConstants.SYB_CUSID);
        params.put("appid", SybConstants.SYB_APPID);
        params.put("version", "11");
        params.put("reqsn", reqsn);
        params.put("trxid", trxid);
        params.put("randomstr", SybUtil.getValidatecode(8));
        params.put("sign", SybUtil.sign(params, SybConstants.SYB_APPKEY));
        byte[] bys = http.postParams(params, true);
        String result = new String(bys, "UTF-8");
        return handleResult(result);
    }


    public static Map<String, String> handleResult(String result) throws Exception {
        Map map = SybUtil.json2Obj(result, Map.class);
        if (map == null) {
            throw new Exception("返回数据错误");
        }
        if ("SUCCESS".equals(map.get("retcode"))) {
            TreeMap tmap = new TreeMap();
            tmap.putAll(map);
            String sign = tmap.remove("sign").toString();
            String sign1 = SybUtil.sign(tmap, SybConstants.SYB_APPKEY);
            if (sign1.toLowerCase().equals(sign.toLowerCase())) {
                return map;
            } else {
                throw new Exception("验证签名失败");
            }

        } else {
            throw new Exception(map.get("retmsg").toString());
        }
    }


}
