package com.hly.java.thread.threadBasic;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/22
 * @desc: 实现Runnable接口创建线程
 */
public class ThreadDemo2 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("thread1:"+i+" ");
        }
    }

    public static void main(String[] args){
        ThreadDemo2 t1 = new ThreadDemo2();
        new Thread(t1).start();
    }
}
