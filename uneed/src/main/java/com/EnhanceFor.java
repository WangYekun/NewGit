package com;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/9/23 15:40
 */
public class EnhanceFor {
    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        System.out.println("########################## print list's values ########################");
        for (String type : stringList){
            System.out.println(type);
        }
    }
}
