package com.hly.java.thread.threadBasic;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/22
 * @QQ :1136513099
 * @desc :守护线程与非守护线程
 */
public class ThreadDemo5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程:" + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadDemo5 t1 = new ThreadDemo5();
        //设为守护线程，和主线程一起销毁
        t1.setDaemon(true);
        t1.start();
        //在主线程调用子线程的join,等待子线程执行完后，再执行主线程
        t1.join();
        for (int i = 0; i <10 ; i++) {
            System.out.println("主线程:"+i);
            Thread.sleep(300);
        }
        System.out.println("主线程结束");
    }
}
