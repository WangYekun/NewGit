package com.hly.java.stringtest;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/18
 */
public class StringDemo {

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abc";

        System.out.println("s1==s2："+(s1==s2));//true

        String s3 = "EEFF";
        String s4 = "EE"+"FF";
        System.out.println("s3==s4:"+(s3==s4));//true


        String s6 = "CC"+new String("DD");
        String s5 = "CCDD";
        System.out.println("s5==s6:"+(s5==s6));//false
        System.out.println("s5==s6.intern:"+(s5==s6.intern()));//true
        System.out.println("s6==s6.intern:"+(s6==s6.intern()));//false

        String s7 = "NN"+new String("MM");
        System.out.println("s7==s.intern:"+(s7==s7.intern()));//true

    }
}
