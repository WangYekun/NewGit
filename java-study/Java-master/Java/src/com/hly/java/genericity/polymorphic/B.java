package com.hly.java.genericity.polymorphic;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class B extends A{
    public String show(B obj){
        return "B - B";
    }

    public String show(A obj){
        return "B - A";
    }
}
