package wang.utils.http;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

/**
 * HttpUtil网络工具类
 *
 * @author WangYekun
 */
public class HtUtils {

    public static void main(String[] args) {
        HashMap<String, Object> paramMap = new HashMap<>(16);
//        paramMap.put("city", "北京");
        paramMap.put("x-qys-accesstoken", "INblkBaTJq");
        paramMap.put("x-qys-timestamp", "0");
        paramMap.put("x-qys-signature", "be46397bdf7c78b9ec6eeb216f4af2e5");
        paramMap.put("Content-Type", "application/json");

//        String result = HttpUtil.post("https://www.baidu.com", paramMap);
//        String result2 = HttpUtil.get("https://www.baidu.com", paramMap);
        String result3 = HttpUtil.get("http://10.10.199.129:9082/template/list",paramMap);
        System.out.println("result3 = " + result3);
//        System.out.println("result2 = " + result2);
//        System.out.println("result3 = " + result2);
    }
}
