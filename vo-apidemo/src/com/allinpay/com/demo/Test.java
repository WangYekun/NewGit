package com.allinpay.com.demo;

import com.allinpay.com.demo.common.AppConstants;
import com.allinpay.com.demo.common.FuncUtil;
import com.allinpay.com.demo.common.HttpConnectionUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    // 生产
    public static String url = "https://vsp.allinpay.com/apiweb";

    // 测试
    //    public static String url = "http://113.108.182.3:10080/apiweb";
    public static void main(String[] args) throws Exception {
        query();
    }

    //���ײ�ѯ
    public static void query() throws Exception {
        HttpConnectionUtil http = new HttpConnectionUtil(url + "/tranx/queryorder");
        http.init();
        TreeMap<String, String> params = new TreeMap<String, String>();

        // 商户号
        params.put("cusid", AppConstants.CUSID);
        // 应用ID
        params.put("appid", AppConstants.APPID);
        // 终端类型
        params.put("trxcode", AppConstants.TRXCODE_QUERYORDER);
        // 字符编码
        params.put("charset", AppConstants.CHARSET);
        // 版本号
        params.put("version", "12");
        // 交易时间
        //        params.put("trxdate", System.currentTimeMillis() + "_");//
        // 交易时间
        params.put("timestamp", "0329");//
        // 订单号
        params.put("orderid", "1490754282058");//orderid为第三方系统的订单号，优先使用trxid查询
        //        params.put("termid","");
        //        params.put("bizseq","");
        //        params.put("trxreserve","");
        //        params.put("trxid", "171343370");//填入交易的通联交易ID-》trxid，trxid与orderid不可以同时为空
        //        params.put("termno", "");//可空
        // 0不重发通知，1重发通知
        params.put("resendnotify", "0");
        // 随机字符串(时间搓格式)
        params.put("randomstr", System.currentTimeMillis() + "");
        // 验签方式
        params.put("sign", sign(params));
        byte[] bys = http.postParams(params, true);
        String result = new String(bys, "UTF-8");
        System.out.println("ret:" + result);
        Map<String, String> map = handleResult(result);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * md5
     *
     * @param b
     * @return
     */
    public static String md5(byte[] b) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            StringBuffer outStrBuf = new StringBuffer(32);
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i] & 0xFF;
                if (v < 16) {
                    outStrBuf.append('0');
                }
                outStrBuf.append(Integer.toString(v, 16).toLowerCase());
            }
            return outStrBuf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new String(b);
        }
    }

    /**
     * 签名
     *
     * @param params
     * @return
     * @throws Exception
     */
    public static String sign(TreeMap<String, String> params) throws Exception {
        if (params.containsKey("sign"))//签名明文组装不包含sign字段
        {
            params.remove("sign");
        }
        params.put("key", AppConstants.APPKEY);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null && entry.getValue().length() > 0) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sign = md5(sb.toString().getBytes("UTF-8"));//记得是md5编码的加签
        params.remove("key");
        return sign;
    }

    public static Map<String, String> handleResult(String result) throws Exception {
        Map map = FuncUtil.json2Obj(result, Map.class);
        if (map == null) {
            throw new Exception("返回数据错误");
        }
        if ("SUCCESS".equals(map.get("retcode"))) {
            TreeMap tmap = new TreeMap();
            tmap.putAll(map);
            String sign = tmap.remove("sign").toString();
            String sign1 = sign(tmap);
            if (sign1.equals(sign)) {
                return map;
            } else {
                throw new Exception("验证签名失败");
            }

        } else {
            throw new Exception(map.get("retmsg").toString());
        }
    }
}