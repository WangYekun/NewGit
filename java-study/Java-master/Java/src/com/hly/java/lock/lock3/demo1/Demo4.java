package com.hly.java.lock.lock3.demo1;

public class Demo4 {
    private static int count = 10;
    //synchronize关键字修饰静态方法锁定的是类的.class文件
    //静态方法中synchronize锁定代码块，锁定的对象不能是类的实例，只能是类的.class文件。
    public synchronized static void test(){
        while (count>0) {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
    public static void test2(){
        synchronized (Demo4.class){//这里不能替换成this
            while (count>0) {
                count--;
                System.out.println(Thread.currentThread().getName() + " count = " + count);
            }
        }
    }
    public static void main(String[] args){
        Demo4 demo4 = new Demo4();
        new Thread(()->demo4.test2(),"t1").start();
        new Thread(()->demo4.test2(),"t2").start();
    }
}
