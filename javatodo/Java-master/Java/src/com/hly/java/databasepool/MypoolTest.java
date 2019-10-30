package com.hly.java.databasepool;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/17
 */
public class MypoolTest {

    //拿到连接池对象
    private static MyPoolImpl myPool = PoolManager.getInstance();

    public synchronized static void selectData() throws SQLException {
        PooledConnection connection = myPool.getConnection();
        ResultSet rs = connection.queryBySql("SELECT * FROM users");
        System.out.println("线程名称:"+Thread.currentThread().getName());

        while (rs.next()){
            System.out.print(rs.getString("uid")+"\t\t");
            System.out.print(rs.getString("uname")+"\t\t");
            System.out.println();
        }
        rs.close();
        connection.close();

    }

    public static void main(String[] args){

        for(int i=0;i<1500;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        selectData();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}