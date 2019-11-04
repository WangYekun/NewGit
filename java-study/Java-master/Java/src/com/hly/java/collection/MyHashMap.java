package com.hly.java.collection;


import java.util.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
//http://www.importnew.com/28263.html
public class MyHashMap {
    public static void main(String[] args){

        //HashMap,只有一位数时有序
        Map<String,String> map = new HashMap<>();
        map.put("12","a");
        
        map.put("34","c");
        map.put("26","b");
        map.put("43","d");
        System.err.println("HashMap实现无序Map集合：");
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String id = it.next();
            String name = map.get(id);
            System.err.println(id+" "+name);
        }
        //TreeMap
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.putAll(map);
        Iterator<String> it2 = treeMap.keySet().iterator();
        System.err.println("TreeMap实现键对象升序Map集合:");
        while (it2.hasNext()){
            String id = it2.next();
            String name = treeMap.get(id);
            System.err.println(id+" "+name);
        }
    }
}
