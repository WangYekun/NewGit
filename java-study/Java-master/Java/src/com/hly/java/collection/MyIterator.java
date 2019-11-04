package com.hly.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/5
 */
public class MyIterator {

    public static void main(String[] args){

        /**
         * 通过迭代器遍历集合
         */
        Collection<String> list = new ArrayList<>();
        list.add("h");
        list.add("l");
        list.add("y");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){//判断是否有下一个元素
            System.out.println(it.next());//获取集合中的元素，next()方法返回Object
        }
    }
}
