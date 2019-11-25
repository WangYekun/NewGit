package com.hly.java.packagingType;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/11
 */
public class MyInteger {

    public static void main(String[] args){

        String str[] = {"1","22","33"};
        int sum =0;
        for(int i=0;i<str.length;i++){
            int j = Integer.parseInt(str[i]);
            sum+=j;
        }
        System.out.println("sum:"+sum);
    }
}
