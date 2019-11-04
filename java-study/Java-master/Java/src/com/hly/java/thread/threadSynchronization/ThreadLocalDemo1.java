package com.hly.java.thread.threadSynchronization;
/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/25
 * @QQ :1136513099
 * @desc :ThreadLocal;为每一个线程提供一个局部变量
 */
public class ThreadLocalDemo1 implements Runnable {
    private int count =0;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        protected Integer initialValue() {
            return 0;
        }
    };

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            count=threadLocal.get()+1;
            threadLocal.set(count);
            System.out.println(Thread.currentThread().getName()+",count:"+count);
        }
    }

    public static void main(String[] args){

        ThreadLocalDemo1 threadLocalDemo1 = new ThreadLocalDemo1();
       Thread t1 = new Thread(threadLocalDemo1);
       Thread t2 = new Thread(threadLocalDemo1);
       Thread t3 = new Thread(threadLocalDemo1);
       t1.start();
       t2.start();
       t3.start();
    }
}
