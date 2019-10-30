package com.hly.java.thread.threadSynchronization;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :019/5/4
 * @QQ :1136513099
 * @desc : 同步代码块synchronized
 */
public class SynchronizedDemo1 implements Runnable{
    private int count =100;
    Object obj = new Object();

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
        synchronized (obj) {//object可以是this,任何类型
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "出售第" + (100 - count + 1) + "张票");
                count--;
            }
        }
    }

    public static void main(String[] args){
        SynchronizedDemo1 threadDemo1 = new SynchronizedDemo1();
        new Thread(threadDemo1,"窗口1").start();
        new Thread(threadDemo1,"窗口").start();
    }
}
