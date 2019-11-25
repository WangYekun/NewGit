package com.hly.java.thread.threadBasic;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/22
 * @desc: 继承Thread创建1线程
 */

public class ThreadDemo1 extends Thread {


    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("thread1:"+i+" ");
        }
    }

    public static void main(String[] args){
        ThreadDemo1 t1 = new ThreadDemo1();
        t1.start();
    }
}
