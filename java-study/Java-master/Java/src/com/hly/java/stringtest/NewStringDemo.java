package com.hly.java.stringtest;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/18
 */
public class NewStringDemo {

    public static void main(String[] args){

        String s1 = new String("sirius");
        String s2 = new String("sirius");
        System.out.println("s3==s4："+(s1==s2));//false

        String s3 = "hly";
        //创建1个对象
        String s4 = new String("hly");

        //创建2个对象
        String s5 = new String("hly");
        String s6 = "hly";

        String s7 = new String("AA")+new String("BB");
        System.out.println("s7==s7.intern:"+(s7==s7.intern()));//true

    }
}
