package com.hly.java.JDBC.JDBCTransactionIsolation;

import com.hly.java.JDBC.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/25
 */

//不可重复读
public class UnrepeatableRead {

    public static void main(String[] args) throws SQLException {
        Thread thread3 = new Thread3();
        thread3.start();
        Thread thread4 = new Thread4();
        thread4.start();
    }
}

// InsertThread线程模拟在一个事务中进行插入数据、回滚操作。
class Thread3 extends Thread {
    Connection conn = null;

    public Thread3() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void run() {
        try {
            conn.setAutoCommit(false);
            String sql = "update employee set name = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Mike-1");
            ps.setInt(2, 1);
            ps.executeUpdate();

            Thread.sleep(1000);

            conn.commit();

            System.out.println("线程3提交了！");
        } catch (SQLException | InterruptedException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}

// ReadThread线程模拟在一个事务中2次读取数据。
class Thread4 extends Thread {
    Connection conn = null;

    public Thread4() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void run() {
        try {
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            conn.setAutoCommit(false);

            String sql = "select * from employee";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            System.out.println("在一个事务中，线程4第1次读取线程3更新但未提交的数据");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id=" + id + ";name=" + name);
            }
            // 第一次读取结束后，线程2休眠
            Thread.sleep(3000);
            // 此时进行thread1提交事务，线程2再次查询线程1提交后的数据
            System.out.println("在一个事务中，线程4第2次读取线程3提交的数据");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id=" + id + ";name=" + name);
            }

            conn.commit();

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }








}
