package com.hly.java.exception;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/9
 */

//自定义异常
public class MyException extends Exception {

    public MyException(String ErrorMessage){
        super(ErrorMessage);//父类的构造方法
    }
}
