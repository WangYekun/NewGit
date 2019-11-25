package com.hly.java.test;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/20
 */
public class Test {

    public int math(){
        int a =1 ;
        int b =2 ;
        int c = (a+b)*10;
        return c;
    }

    public static void main(String[] args){
      Test t1 = new Test();
      int math = t1.math();
    }
}
