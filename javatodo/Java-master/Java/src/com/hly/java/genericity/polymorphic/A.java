package com.hly.java.genericity.polymorphic;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class A {
    public String show(D obj){
        return "A - D";
    }

    public String show(A obj){
        return "A - A";
    }

}
