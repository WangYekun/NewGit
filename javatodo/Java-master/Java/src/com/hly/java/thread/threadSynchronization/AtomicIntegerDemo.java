package com.hly.java.thread.threadSynchronization;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/25
 * @QQ :1136513099
 * @desc :AtomicInteger 并发包保证原子性
 */
public class AtomicIntegerDemo extends Thread {
    //private volatile static int count = 0;
    //AtomicInteger则通过一种线程安全的加减操作接口，底层是有volatile修饰的变量作为共享变量。
    private static AtomicInteger count = new AtomicInteger(0);//保证原子性

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            ///count++;
            count.incrementAndGet();
        }
        System.out.println(getId()+":"+count.get());
    }
    public static void main(String[] args){
            AtomicIntegerDemo threadDemoList [] = new AtomicIntegerDemo[10];
            for(int i=0;i<10;i++){
                threadDemoList[i] = new AtomicIntegerDemo();
            }
            for(int i=0;i<threadDemoList.length;i++){
                threadDemoList[i].start();
            }
    }
}
