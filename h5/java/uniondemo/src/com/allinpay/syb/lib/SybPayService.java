package com.allinpay.syb.lib;

import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public class SybPayService {
    /**
     * 统一支付
     *
     * @param trxamt
     * @param reqsn
     * @param body
     * @param remark
     * @param notify_url
     * @throws Exception
     */
    public void pay(long trxamt, String reqsn, String body, String remark, String notify_url) throws Exception {
        //        HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL + "/pay");
        //        http.init();
        StringBuilder sb = new StringBuilder();
        TreeMap<String, String> params = new TreeMap<>();
        // 商户号
        params.put("cusid", SybConstants.SYB_CUSID);
        // 应用ID
        params.put("appid", SybConstants.SYB_APPID);
        // 版本号
        params.put("version", "12");
        // 交易金额(分)
        params.put("trxamt", String.valueOf(trxamt));
        // 商户交易单号
        params.put("reqsn", reqsn);
        // 字符编码
        params.put("charset", "utf-8");
        // 交易结果通知地址()
        params.put("returl", "http://baidu.com");
        // 回调地址(页面跳转同步通知页面路径/交易完成后，平台会按照此地址将用户的交易结果页面重定向到商户网站。
        // 同时该参数为返回商户按钮的指向链接，如果商户不传递该参数，则返回按钮指向为空页面。)
        params.put("notify_url", notify_url);
        // 订单标题
        params.put("body", body);
        // 备注
        params.put("remark", remark);
        // 随机字符(订单号码支持数字、英文字母、_、-、*、+、#，其他字符不建议使用)
        params.put("randomstr", SybUtil.getValidatecode(8));
        // 签名(MD5签名/RSA(SHA1WithRSA)签名逻辑/生成随机数算法)
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

    /**
     * 统一取消
     *
     * @param trxamt
     * @param reqsn
     * @param oldtrxid
     * @param oldreqsn
     * @return
     * @throws Exception
     */
    public Map<String, String> cancel(long trxamt, String reqsn, String oldtrxid, String oldreqsn) throws Exception {
        HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL + "/cancel");
        http.init();
        TreeMap<String, String> params = new TreeMap<String, String>();
        // 商户号
        params.put("cusid", SybConstants.SYB_CUSID);
        // 应用ID
        params.put("appid", SybConstants.SYB_APPID);
        // 版本号
        params.put("version", "11");
        // 交易金额(分)
        params.put("trxamt", String.valueOf(trxamt));
        // 商户交易单号
        params.put("reqsn", reqsn);
        // 原交易单号
        params.put("oldtrxid", oldtrxid);
        // 原交易流水
        params.put("oldreqsn", oldreqsn);
        // 随机字符串
        params.put("randomstr", SybUtil.getValidatecode(8));
        // 签名(MD5签名/RSA(SHA1WithRSA)签名逻辑/生成随机数算法)
        params.put("sign", SybUtil.sign(params, SybConstants.SYB_APPKEY));
        byte[] bys = http.postParams(params, true);
        String result = new String(bys, "UTF-8");
        return handleResult(result);

    }

    /**
     * 统一退款
     *
     * @param trxamt
     * @param reqsn
     * @param oldtrxid
     * @param oldreqsn
     * @return
     * @throws Exception
     */
    public Map<String, String> refund(long trxamt, String reqsn, String oldtrxid, String oldreqsn) throws Exception {
        HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL + "/refund");
        http.init();
        TreeMap<String, String> params = new TreeMap<String, String>();
        // 商户号
        params.put("cusid", SybConstants.SYB_CUSID);
        // APPID
        params.put("appid", SybConstants.SYB_APPID);
        // 版本号
        params.put("version", "11");
        // 交易金额(分)
        params.put("trxamt", String.valueOf(trxamt));
        // 商户交易单号
        params.put("reqsn", reqsn);
        // 原交易单号
        params.put("oldreqsn", oldreqsn);
        // 原交易流水
        params.put("oldtrxid", oldtrxid);
        // 随机字符
        params.put("randomstr", SybUtil.getValidatecode(8));
        // 签名(MD5签名/RSA(SHA1WithRSA)签名逻辑/生成随机数算法)
        params.put("sign", SybUtil.sign(params, SybConstants.SYB_APPKEY));
        byte[] bys = http.postParams(params, true);
        String result = new String(bys, "UTF-8");
        return handleResult(result);
    }

    /**
     * 统一查询
     *
     * @param reqsn
     * @param trxid
     * @return
     * @throws Exception
     */
    public Map<String, String> query(String reqsn, String trxid) throws Exception {
        HttpConnectionUtil http = new HttpConnectionUtil(SybConstants.SYB_APIURL + "/query");
        http.init();
        TreeMap<String, String> params = new TreeMap<String, String>();
        // 商户号
        params.put("cusid", SybConstants.SYB_CUSID);
        // 应用ID
        params.put("appid", SybConstants.SYB_APPID);
        // 版本号
        params.put("version", "11");
        // 商户交易单号
        params.put("reqsn", reqsn);
        // 平台交易流水(支付的收银宝平台流水)
        params.put("trxid", trxid);
        // 随机字符
        params.put("randomstr", SybUtil.getValidatecode(8));
        // 签名(MD5签名/RSA(SHA1WithRSA)签名逻辑/生成随机数算法)
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
