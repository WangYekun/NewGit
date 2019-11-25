package com.hly.java.thread.threadSynchronization;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/24
 * @QQ :1136513099
 * @desc : 多个线程共享同一个全局变量，受到其他线程干扰，导致数据有问题，这种现象叫做线程安全问题。
 */
public class ThreadDemo1 implements Runnable{
    private int count =100;

    @Override
    public void run() {
        while (count>0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    public void sale(){
        if(count>0) {
            System.out.println(Thread.currentThread().getName() + "出售第" + (100 - count + 1) + "张票");
            count--;
        }
    }

    public static void main(String[] args){
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        new Thread(threadDemo1,"窗口1").start();
        new Thread(threadDemo1,"窗口2").start();
    }
}
