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
        paramMap.put("city", "北京");

        String result = HttpUtil.post("https://www.baidu.com", paramMap);
        String result2 = HttpUtil.get("https://www.baidu.com", paramMap);

        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
    }
}
