package com.hly.java.thread.threadBasic;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/22
 * @QQ :1136513099
 * @desc :常用API
 */
public class ThreadDemo4 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            //getId()获得线程Id
            System.out.println("Thread:"+getId()+" "+i);
        }
    }

    public static void main(String[] args){
        //getName()获得线程名字 g
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i <2 ; i++) {
            ThreadDemo4 t1 = new ThreadDemo4();
            t1.start();
        }
    }
}
