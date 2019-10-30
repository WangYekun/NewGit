package com.hly.java.databasepool;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/17
 */
public class PoolManager {

    //静态内部类的加载不需要依附外部类，在使用时才加载。不过在加载静态内部类的过程中也会加载外部类
    private static class createPool{
        //创建连接池对象
        private static MyPoolImpl myPoolImpl = new MyPoolImpl();
    }
    //内部类单例模式
    //仿照类加载器加载类的互斥性表现完美解决线程安全问题

    public static MyPoolImpl getInstance(){
        return createPool.myPoolImpl;
    }
}