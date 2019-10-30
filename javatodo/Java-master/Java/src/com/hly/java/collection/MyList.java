package com.hly.java.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/5
 */
public class MyList {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("h");
        list.add("l");
        list.add("y");
        int i = (int)(Math.random()*list.size());
        System.out.println("i:"+list.get(i));
        list.remove(2);
        for(String j:list){
            System.err.println(j);
        }
    }
}
