package com.hly.java.databasepool;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/17
 */
public interface MyPool {
    //对外提供链接管道
    PooledConnection getConnection();

    //对内创建连接
    void createConnection(int count);
}