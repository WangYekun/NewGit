package wang.utils.json;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @description JSON字符串转化工具
 * @date 2020/1/9 19:52
 */
public class JsonUtil {

    private static ObjectMapper objectMapper;

    private static String toJson(Object object) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, Object> mapParam = new HashMap<>(16);
        mapParam.put("1", "1");
        mapParam.put("2", "2");
        mapParam.put("3", "3");
        mapParam.put("4", "4");
        mapParam.put("5", "5");
        String mapToStrFormat = toJson(mapParam);
        JSONObject strToJson = JSONObject.parseObject(mapToStrFormat);
        System.out.println("strToJson.getString(\"1\") = " + strToJson.getString("1"));
        System.out.println("mapParam.get(\"1\") = " + mapParam.get("1"));
    }
}
