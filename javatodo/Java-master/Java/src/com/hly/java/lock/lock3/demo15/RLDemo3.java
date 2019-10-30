package com.hly.java.lock.lock3.demo15;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class RLDemo3 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(()->{
            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted1!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            boolean locked = false;
            try {
//                lock.lock();
                //使用lockInterruptibly来锁定可以对Interrupt方法作出响应
                lock.lockInterruptibly();
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
                locked = true;
            } catch (InterruptedException e) {
                System.out.println("interrupted2!");
            } finally {
                if (locked){
                    lock.unlock();
                }
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //解阻塞，并抛出 interrupted 异常
        t1.interrupt();
        t2.interrupt();
    }
}
