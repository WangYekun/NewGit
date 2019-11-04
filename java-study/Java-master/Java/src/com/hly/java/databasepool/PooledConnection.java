package com.hly.java.databasepool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/17
 * 自定义连接数据库管道对象的bean
 */
public class PooledConnection {

    //表示繁忙的标志，复用的标志，线程安全
    //解决线程被占用问题，解决线程使用该管道完成任务后的释放标志
    private boolean isBusy = false;
    //数据库连接管道
    private Connection connection;

    //标志管道是否被占用
    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    //释放为管道复用
    public void close() {
        this.isBusy = false;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public PooledConnection(boolean isBusy, Connection connection) {
        this.isBusy = isBusy;
        this.connection = connection;
    }

    //给自定义管道一个操作数据库的数据功能
    public ResultSet queryBySql(String sql) {
        Statement sm = null;
        ResultSet rs = null;
        try {
            sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
