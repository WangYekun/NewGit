package com.hly.java.java8.interface8;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/19
 * @QQ :1136513099
 * @desc :
 */
public interface IInterface {

    //定义普通关键字方法
    default void query(){
        System.out.println("默认方法");
    }

    //定义静态方法
    static void save(){
        System.out.println("静态方法");
    }

    //不能定义非static,default 方法


}
