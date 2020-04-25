package com.wang.swagger.demo.practice;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/24 23:47
 * @description Map和List练习
 */
public class MapAndListPractice {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(16);
        // 增
        map.put("1", LocalDateTime.now());
        map.put("2", "这是第二个map值");
        map.put("3", "这是第三个map值");
        System.out.println("map = " + map);
        Map<String, Object> mapAll = new HashMap<>(16);
        mapAll.putAll(map);
        System.out.println("mapAll = " + mapAll);
        // 判断map中的value值是否存在(查)==>F/T
        System.out.println(map.containsValue("string"));

        Set<String> entries = map.keySet();
        for (String entry : entries) {
            System.out.println(map.get(entry));
        }
        // 删
        System.out.println(map.remove("1"));
        // TODO 上面是map还没写完

        List<String> list = new ArrayList<>(16);
        // 增
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("5");
        System.out.println("<<====list====>>" + list);
        // 根据下标取出list中的值(查)
        System.out.println(list.get(0));
        // 删
        System.out.println("<====list.remove(0)=>>>>>>" + list.remove(0));
        // 长度
        System.out.println("<====list.size()====>" + list.size());
        // for循环输出/增强for输出/迭代器输出
        System.out.println("int i = 0; i < list.size(); i++");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("String s : list");
        for (String s : list) {
            System.out.println("s = " + s);
        }

        System.out.println("iterator.hasNext()");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator = " + iterator.next());
        }
        // TODO 上面是list还没写完(三有产品重复/索引/无序) h无序 t有序

        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("1");
        treeSet.add("1");
        treeSet.add("3");
        hashSet.add("10");
        hashSet.add("8");
        System.out.println("treeSet = " + treeSet);
        System.out.println("hashSet = " + hashSet);
        // TODO 上面是set还没写完(三无重复/索引/无序)

        System.out.println("new ArrayList<>().add(100) = " + new ArrayList<>().add(100));
        System.out.println("new LinkedList<>().add(100) = " + new LinkedList<>().add(100));
        System.out.println("new Vector<>().add(100) = " + new Vector<>().add(100));
        // TODO 上面三个的区别 V11b√ A1.2半倍× 删除元素从下到上

        List<Integer> objectArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objectArrayList.add(i + 1);
        }
        System.out.println(objectArrayList);
        Collections.shuffle(objectArrayList);
        Collections.sort(objectArrayList);
        Map<String, Object> stringObjectHashMap = new HashMap<>(16);
        stringObjectHashMap.put("1", 1);
        stringObjectHashMap.put("2", 2);
        stringObjectHashMap.put("3", 3);
        stringObjectHashMap.put("4", 4);
        List<Map<String, Object>> listMap = new ArrayList<>();
        listMap.add(stringObjectHashMap);
        for (Map<String, Object> objectMap : listMap) {
            System.out.println(" <<<<<<<<=>>>>>>>> " + objectMap.get("1"));
            System.out.println(" <<<<<<<<=>>>>>>>> " + objectMap);
        }
    }
}
