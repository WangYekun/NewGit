package com.hly.java.thread.threadSynchronization;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/25
 * @QQ :1136513099
 * @desc :volatile 保证线程可见性
 */
public class VolatileDemo extends Thread {
    private volatile boolean flag = true;//不添加volatile flag将不会被及时刷新

    @Override
    public void run() {
        System.out.println("子线程开始");
        while (flag){

        }
        System.out.println("子线程结束");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo threadDemo = new VolatileDemo();
        threadDemo.start();
        //制造延迟，主内存不会立马刷新到子线程的本地内幕才能
        Thread.sleep(1000);
        //主线程修改了共享的全局变量为false,先改本地内存，在刷新到主内存中去
        threadDemo.setFlag(false);
        System.out.println("flag已经修改为false");
        System.out.println(threadDemo.flag);
    }

}
