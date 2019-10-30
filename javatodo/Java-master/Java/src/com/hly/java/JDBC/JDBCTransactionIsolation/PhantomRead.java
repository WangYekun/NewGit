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
public class PhantomRead {

    public static void main(String[] args) throws SQLException {
        Thread thread5 = new Thread5();
        thread5.start();
        Thread thread6 = new Thread6();
        thread6.start();
    }
}

// 线程1模拟在一个事务中进行插入数据、提交事务操作。
class Thread5 extends Thread {
    Connection conn = null;

    public Thread5() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void run() {
        try {
            conn.setAutoCommit(false);
            String sql = "insert into employee(id,name) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 4);
            ps.setString(2, "Tom");
            ps.executeUpdate();

            Thread.sleep(1000);

            conn.commit();

            System.out.println("线程5的事务A提交了！");
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
class Thread6 extends Thread {
    Connection conn = null;

    public Thread6() throws SQLException {
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
            System.out.println("在一个事务B1中，线程6读取线程5插入但未提交的数据");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id=" + id + ";name=" + name);
            }
            // 第一次读取结束后，线程2休眠
            Thread.sleep(2000);

            conn.commit();
            System.out.println("线程6的事务B1提交了！");

            conn.setAutoCommit(true);
            // 此时进行thread1提交事务，线程2再次查询线程1提交后的数据
            System.out.println("在线程6另一个事务中B2，线程6读取线程5提交事务A后的数据，会出现多出的幻影行");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id=" + id + ";name=" + name);
            }

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
