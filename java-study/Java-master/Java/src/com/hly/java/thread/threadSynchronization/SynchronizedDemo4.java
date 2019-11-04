package com.hly.java.thread.threadSynchronization;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/25
 * @QQ :1136513099
 * @desc : 线程死锁,同步中嵌套同步
 */
public class SynchronizedDemo4 implements Runnable{
    private static int count =100;
    boolean flag = true;
    Object obj = new Object();
    @Override
    public void run() {
        if(flag){
            while (true){
                synchronized (obj){//。class才能实现同步
                    sale();
                }
            }
        }else{
            while (true){
                sale();
            }
        }
    }

    public synchronized void sale(){
        synchronized (obj) {
            if (count > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "出售第" + (100 - count + 1) + "张票");
                count--;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo4 threadDemo4 = new SynchronizedDemo4();
        new Thread(threadDemo4,"窗口1").start();
        Thread.sleep(50);
        threadDemo4.flag=false;
        new Thread(threadDemo4,"窗口2").start();
    }
}
