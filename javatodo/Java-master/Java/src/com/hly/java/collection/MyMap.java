package com.hly.java.collection;

import java.util.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class MyMap {

    public static void main(String[] args){

        Map<String,String> map = new HashMap<>();
        map.put("1","hly");
        map.put("2","abc");
        System.err.println("key集合中的元素：");
        Set<String> set = map.keySet();//Map集合中所有key对象的集合
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.err.println(it.next());
        }
        System.err.println("value集合中的元素：");
        Collection<String>  collection= map.values();
        it = collection.iterator();
        while (it.hasNext()){
            System.err.println(it.next());
        }
    }
}
