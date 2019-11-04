package com.hly.java.lock.lock3.demo1;

public class Demo3 {

    private int count = 10;

    //直接加在方法声明上，相当于是synchronized(this)
    public synchronized void test(){
        while (count>0) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args){
        Demo3 demo3 = new Demo3();
        new Thread(()->demo3.test(),"t1").start();
        new Thread(()->demo3.test(),"t2").start();
    }
}
