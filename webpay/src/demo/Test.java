package demo;

import demo.common.AppConstants;
import demo.common.FuncUtil;
import demo.common.HttpConnectionUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    /**
     * 生产
     */
    public static String url = "https://vsp.allinpay.com/apiweb";

    /**
     * 测试
     */
    //        public static String url = "http://113.108.182.3:10080/apiweb";
    public static void main(String[] args) throws Exception {
        query();

    }

    /**
     * 查询订单
     *
     * @throws Exception
     */
    public static void query() throws Exception {
        HttpConnectionUtil http = new HttpConnectionUtil(url + "/tranx/queryorder");
        http.init();
        TreeMap<String, String> params = new TreeMap<>();
        // 应用ID
        params.put("appid", AppConstants.APPID);
        // 业务流水号(如订单号，保单号，缴费编号等)
        //        params.put("bizseq", "1576484927748");
        // 商户号
        params.put("cusid", AppConstants.CUSID);
        // md5key
        params.put("key", AppConstants.APPKEY);
        // 随机字符串(时间搓格式)
        params.put("randomstr", FuncUtil.getRandcode(8));
        // termid
        //        params.put("termid", "https://syb.allinpay.com/apiweb/h5unionpay/unionorder?appid=00013002&body=%E8%AE%A2%E5%8D%95%E6%B5%8B%E8%AF%95&charset=utf-8&cusid=110588072991996&notify_url=remark&randomstr=94040212&remark=title&reqsn=1576484927748&returl=http%3A%2F%2Fbaidu.com&sign=0ac7b7fe076ef31cba4db6b5fd235a29&trxamt=1&version=12");//
        // 交易时间
        params.put("timestamp", FuncUtil.formatTime(new Date(), "yyyyMMddHHmmss"));
        // 终端类型
        params.put("trxcode", AppConstants.TRXCODE_QUERYORDER);
        // 测试号
        params.put("trxreserve", "###05#");
        // 交易时间
        params.put("version", "12");
        // 字符编码
        params.put("charset", AppConstants.CHARSET);
        // 版本号
        params.put("trxdate", FuncUtil.formatTime(new Date(), "MMdd"));
        // 交易时间
        // 订单号/orderid为第三方系统的订单号，优先使用trxid查询
        params.put("orderid", String.valueOf(System.currentTimeMillis()));
        //填入交易的通联交易ID-》trxid，trxid与orderid不可以同时为空
        //        params.put("trxid", AppConstants.END_NUM);
        params.put("termno", AppConstants.END_NUM);
        // 0不重发通知，1重发通知
        params.put("resendnotify", "0");
        // 验签方式
        params.put("sign", sign(params));
        byte[] bys = http.postParams(params, true);
        String result = new String(bys, StandardCharsets.UTF_8);
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
        // 签名明文组装不包含sign字段
        if (params.containsKey("sign")) {
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
        // 记得是md5编码的加签
        String sign = md5(sb.toString().getBytes("UTF-8"));
        params.remove("key");
        return sign;
    }

    /**
     * 处理结果
     *
     * @param result
     * @return
     * @throws Exception
     */
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