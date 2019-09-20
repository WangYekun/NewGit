package cn.uneed.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/9/20 10:08
 */
public class OneToMore {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>(16);
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        map.put("oneToMore", list);
        // 得到key
        List<String> results = map.get("oneToMore");
        // 输出key
        System.out.println("######################## 集合方式存在 ##############################");
        System.out.println("key = " + results);
        System.out.println("######################## 循环方式存在 ##############################");
        for (Object key : results) {
            System.out.println("key = " + key);
        }

    }
}
