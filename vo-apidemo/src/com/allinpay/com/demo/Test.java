package com.allinpay.com.demo;

import com.allinpay.com.demo.common.AppConstants;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static String url = "https://vsp.allinpay.com/apiweb";//生产
    //public static String url = "http://113.108.182.3:10080/apiweb";//测试
    public static void main(String[] args) throws Exception {
        query();
    }

    //交易查询
    public static void query() throws Exception{
        HttpConnectionUtil http = HttpConnectionUtil(url+"/tranx/queryorder");
        http.init();
        TreeMap<String,String> params = new TreeMap<String,String>();

        params.put("cusid", AppConstants.CUSID);
        params.put("appid", AppConstants.APPID);
        params.put("version", "11");
        //		params.put("trxdate", "0329");//
        //		params.put("orderid", "1490754282058");//orderid为第三方系统的订单号，优先使用trxid查询
        params.put("trxid", "171343370");//填入交易的通联交易ID-》trxid，trxid与orderid不可以同时为空
        //		params.put("termno", "");//可控
        params.put("resendnotify", "0");//0不重发通知，1重发通知
        params.put("randomstr", System.currentTimeMillis()+"");
        params.put("sign", sign(params));
        byte[] bys = http.postParams(params, true);
        String result = new String(bys, StandardCharsets.UTF_8);
        System.out.println("ret:"+result);
        Map<String,String> map = handleResult(result);
        for(Map.Entry<String, String> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    public static String sign(TreeMap<String,String> params){
        params.put("key", AppConstants.APPKEY);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry:params.entrySet()){
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
        String sign = new Md5().computeDigest(sb.toString().getBytes()).toUpperCase();
        params.remove("key");
        System.out.println(sign);
        return sign;
    }

    public static Map<String,String> handleResult(String result) throws Exception{
        Map map = JsonUtil.json2Obj(result, Map.class);
        if(map == null){
            throw new Exception("返回数据错误");
        }
        if("SUCCESS".equals(map.get("retcode"))){
            TreeMap tmap = new TreeMap();
            tmap.putAll(map);
            String sign = tmap.remove("sign").toString();
            String sign1 = sign(tmap);
            if(sign1.equals(sign)){
                return map;
            }else{
                throw new Exception("验证签名失败");
            }

        }else{
            throw new Exception(map.get("retmsg").toString());
        }
    }
}