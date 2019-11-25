package com.hly.java.lock.lock3.demo1;

public class Demo2 {

    private int count = 10;
    public void test(){
        //synchronized(this)锁定的是当前类的实例,这里锁定的是Demo2类的实例
        synchronized (this) {
            while (count > 0) {
                count--;
                System.out.println(Thread.currentThread().getName() + " count = " + count);
            }
        }
    }
    public static void main(String[] args){
        Demo2 demo2 = new Demo2();
        new Thread(()->demo2.test(),"t1").start();
        new Thread(()->demo2.test(),"t2").start();
    }
}
