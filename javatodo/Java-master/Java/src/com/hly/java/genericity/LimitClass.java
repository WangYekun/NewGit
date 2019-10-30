package com.hly.java.genericity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class LimitClass<T extends List> {//限制泛型的类型
    public static void main(String[] args){

        //可以实例化已经实现List接口的类
        LimitClass<ArrayList> l1 = new LimitClass<ArrayList>();
        LimitClass<LinkedList> l2 = new LimitClass<LinkedList>();
        LimitClass<List> l3 = new LimitClass<List>();
        //HashMap没有实现List接口，错误语法
        //LimitClass<HashMap> l3 = new LimitClass<HashMap>();

        LimitClass<? extends List>a =null;


    }
}
