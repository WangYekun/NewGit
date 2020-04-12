package com.company.test.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 21:54
 * @description 测试hashMap
 */
public class Test {
    public static void main(String[] args) {

        Map<String, Double> map = new HashMap<String, Double>(16);
        map.put("1", 0.1);
        map.put("2", 0.1);
        map.put("3", 0.1);
        map.put("4", 0.1);
        map.put("5", 0.1);
        map.put("6", 0.1);
        map.put("7", 0.1);
    }
}
