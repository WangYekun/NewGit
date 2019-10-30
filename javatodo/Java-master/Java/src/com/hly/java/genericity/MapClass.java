package com.hly.java.genericity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */

//使用集合类声明容器的元素
public class MapClass<K,V> {

    //K,V代表容器中的键值和键值对应的具体值
    public Map<K,V> m = new HashMap<K,V>();
    public void put(K k,V v){
        m.put(k,v);
    }

    //根据键名获取键值
    public V get(K k){
        return m.get(k);
    }

    public static void main(String[] args){

        MapClass<Integer,String> mc = new MapClass<Integer, String>();
        for(int i=0;i<5;i++){
            mc.put(i,String.valueOf(i));
        }

        for(int i=0;i<mc.m.size();i++){
            System.out.println(mc.get(i));
        }
    }





}
