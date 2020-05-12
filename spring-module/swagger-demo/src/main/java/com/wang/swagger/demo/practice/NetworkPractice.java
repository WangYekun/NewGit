package com.wang.swagger.demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/10 22:00
 * @description 博客和网咯代码练习
 */
public class NetworkPractice {

    /**
     * TODO 可以看出 entrySet 的性能比 keySet 的性能高出了一倍之多，尽量使用 entrySet  来实现 Map 集合的遍历
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
//         1. (迭代器EntrySet)
//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap<>(16);
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, String> entry = iterator.next();
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }

//        2.迭代器 KeySet
//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap<>(16);
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        Iterator<Integer> iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            Integer key = iterator.next();
//            System.out.println(key);
//            System.out.println(map.get(key));
//        }

//        3.ForEach EntrySet 这个效率最高
//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap<>(16);
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }

//        4.ForEach KeySet
//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap<>(16);
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        for (Integer key : map.keySet()) {
//            System.out.println(key);
//            System.out.println(map.get(key));
//        }

//        5.Lambda
//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap<>(16);
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        map.forEach((key, value) -> {
//            System.out.println(key);
//            System.out.println(value);
//        });

//        6.Streams API 单线程
//        // 创建并赋值 HashMap
//        Map<Integer, String> map = new HashMap<>(16);
//        map.put(1, "Java");
//        map.put(2, "JDK");
//        map.put(3, "Spring Framework");
//        map.put(4, "MyBatis framework");
//        map.put(5, "Java中文社群");
//        // 遍历
//        map.entrySet().stream().forEach((entry) -> {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        });

        //7.Streams API 多线程
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap<>(16);
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        // 遍历
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
