package com.hly.java.packagingType;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/11
 */

//常量
public class Constant {

    public static void main(String[] args){
        int maxInt = Integer.MAX_VALUE;//2^31-1
        int minInt =Integer.MIN_VALUE;//-2^31
        int intsize = Integer.SIZE;

        System.out.println("最大值："+maxInt);
        System.out.println("最小值："+minInt);
        System.out.println("int类型的二进制位数："+intsize);
    }
}
