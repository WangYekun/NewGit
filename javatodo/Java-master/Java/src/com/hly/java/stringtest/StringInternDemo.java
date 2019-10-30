package com.hly.java.stringtest;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/18
 */
public class StringInternDemo {

    public static void main(String[] args){
        String s1=new String("ab") + new String("c");
        s1.intern();
        System.out.println(s1==s1.intern());
        String  s2=new String("abc");//true
        System.out.println(s1==s2);//false
        s2.intern();//不起作用，s2还是原来的
        System.out.println(s1==s2);//false
        String s3="abc";
        System.out.println(s1==s3);//true
        String s4="ab";
        String s5="ab"+"c";
        System.out.println(s1==s5);//true

    }
}
//https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html
//https://blog.csdn.net/u013366617/article/details/83618361