package com.hly.java.thread.threadSynchronization;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/24
 * @QQ :1136513099
 * @desc : 同步函数，使用this锁
 */
public class SynchronizedDemo2 implements Runnable{
    private int count =100;
    boolean flag = true;
   Object obj = new Object();
    @Override
    public void run() {

        if(flag){
            while (count>0){
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               synchronized (this){//this所才能实现同步,obj不行
                   if (count > 0) {
                       System.out.println(Thread.currentThread().getName() + "出售第" + (100 - count + 1) + "张票");
                       count--;
                   }
               }
            }
        }else{

            while (count>0){
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sale();
            }
        }
    }

    public synchronized void sale(){
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "出售第" + (100 - count + 1) + "张票");
                count--;
            }
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo2 threadDemo3 = new SynchronizedDemo2();
        new Thread(threadDemo3,"窗口1").start();
        Thread.sleep(40);
        threadDemo3.flag=false;
        new Thread(threadDemo3,"窗口2").start();
    }
}
