package com.hly.java.databasepool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/17
 */
public class MyPoolImpl implements MyPool {

    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;
    //管道数量
    private static int initCount = 5;
    private static int stepSize = 10;
    //连接池最大数量
    private static int poolMaxSize = 150;
    //
    private static Vector<PooledConnection> pooledConnections = new Vector<>();

    public MyPoolImpl() {
        init();
    }

    private void init() {
        InputStream inputStream = MyPoolImpl.class.getResourceAsStream("/jdbcPool.properties");
        Properties pro = new Properties();

        try {
            pro.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = pro.getProperty("jdbcDriver");
        url = pro.getProperty("jdbcUrl");
        user = pro.getProperty("username");
        password = pro.getProperty("password");
        if (Integer.valueOf(pro.getProperty("initCount")) > 0) {
            initCount = Integer.valueOf(pro.getProperty("initCount"));
        } else if (Integer.valueOf(pro.getProperty("stepSize")) > 0) {
            stepSize = Integer.valueOf(pro.getProperty("stepSize"));
        } else if (Integer.valueOf(pro.getProperty("poolMaxSize")) > 0) {
            poolMaxSize = Integer.valueOf(pro.getProperty("poolMaxSize"));
        }

        try {
            Driver dbDriver = (Driver) Class.forName(driver).newInstance();
            DriverManager.registerDriver(dbDriver);
            createConnection(initCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取管道
    @Override
    public PooledConnection getConnection() {
        if (pooledConnections.size() == 0) {
            System.err.println("获取数据库连接管道失败!!!没有任何管道");
            createConnection(initCount);
        }
        PooledConnection connection = getRealConnection();
        //管道被其他线程占用,判断为空，不断创建，while不会死锁
        while (connection == null) {
            createConnection(stepSize);
            connection = getRealConnection();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    //获取真实有效的管道，管道未被占用，管道没有失效超时
    private synchronized PooledConnection getRealConnection() {
        for (PooledConnection conn : pooledConnections) {
            //没有被占用
            if (!conn.isBusy()) {
                //进一步判断没有被占用的管道的有效性
                Connection connection = conn.getConnection();
                try {
                    //对数据库发送sql命令，在规定时间2000内收到回应为true
                    if (connection.isValid(2000)) {
                        connection = DriverManager.getConnection(url, user, password);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //设为繁忙，其他线程不会抢夺
                conn.setBusy(true);
                return conn;
            }
        }
        //都是繁忙的
        return null;
    }

    //创建管道
    @Override
    public void createConnection(int count) {
        if (pooledConnections.size() + count <= poolMaxSize) {
            for (int i = 0; i < count; i++) {
                try {
                    Connection connection = DriverManager.getConnection(url, user, password);
                    PooledConnection pooledConnection = new PooledConnection(false, connection);
                    pooledConnections.add(pooledConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("创建失败!!!");
        }
    }
}