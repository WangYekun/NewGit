package com.hly.java.thread.threadBasic;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/22
 * @desc: 匿名内部类创建线程
 */
public class ThreadDemo3 {

    public static void main(String[] args){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("thread1:"+i+" ");
                }
            }
        });
        t1.start();
    }
}
