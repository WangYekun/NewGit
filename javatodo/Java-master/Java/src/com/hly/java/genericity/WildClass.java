package com.hly.java.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class WildClass{

    //要求List<Object>作为参数
    /*public static void printList(List<Object> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }*/
    public static void printList(List<?> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args){

        List<Object> list1 = new ArrayList<Object>();
        list1.add(new Integer(30));
        WildClass.printList(list1);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(new Integer(20));
        WildClass.printList(list2);//错误，不是List<Object>,修改为？后正确

    }
}
