package com.allinpay.com.demo;

import java.util.Map;
import java.util.TreeMap;

import com.allinpay.com.demo.common.AppConstants;
import com.allinpay.com.demo.common.FuncUtil;

public class Test {
    public static String url = "https://vsp.allinpay.com/apiweb";//����

    //public static String url = "http://113.108.182.3:10080/apiweb";//����
    public static void main(String[] args) throws Exception {
        query();
    }

    //���ײ�ѯ
    public static void query() throws Exception {
        HttpConnectionUtil http = new HttpConnectionUtil(url + "/tranx/queryorder");
        http.init();
        TreeMap<String, String> params = new TreeMap<String, String>();

        params.put("cusid", AppConstants.CUSID);
        params.put("appid", AppConstants.APPID);
        params.put("version", "11");
        //		params.put("trxdate", "0329");//
        //		params.put("orderid", "1490754282058");//orderidΪ������ϵͳ�Ķ����ţ�����ʹ��trxid��ѯ
        params.put("trxid", "171343370");//���뽻�׵�ͨ������ID-��trxid��trxid��orderid������ͬʱΪ��
        //		params.put("termno", "");//�ɿ�
        params.put("resendnotify", "0");//0���ط�֪ͨ��1�ط�֪ͨ
        params.put("randomstr", System.currentTimeMillis() + "");
        params.put("sign", sign(params));
        byte[] bys = http.postParams(params, true);
        String result = new String(bys, "UTF-8");
        System.out.println("ret:" + result);
        Map<String, String> map = handleResult(result);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static String sign(TreeMap<String, String> params) {
        params.put("key", AppConstants.APPKEY);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
        String sign = new Md5().computeDigest(sb.toString().getBytes()).toUpperCase();
        params.remove("key");
        System.out.println(sign);
        return sign;
    }

    public static Map<String, String> handleResult(String result) throws Exception {
        Map map = JsonUtil.json2Obj(result, Map.class);
        if (map == null) {
            throw new Exception("�������ݴ���");
        }
        if ("SUCCESS".equals(map.get("retcode"))) {
            TreeMap tmap = new TreeMap();
            tmap.putAll(map);
            String sign = tmap.remove("sign").toString();
            String sign1 = sign(tmap);
            if (sign1.equals(sign)) {
                return map;
            } else {
                throw new Exception("��֤ǩ��ʧ��");
            }

        } else {
            throw new Exception(map.get("retmsg").toString());
        }
    }
}