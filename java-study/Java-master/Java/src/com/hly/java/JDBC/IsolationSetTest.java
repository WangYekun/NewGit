package com.hly.java.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/31
 */
public class IsolationSetTest {

    public static void main(String[] args) {
        setIsolation();
    }

    public static void setIsolation() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();

            //读未提交
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            int transaction_read_uncommitted = conn.getTransactionIsolation();
            System.out.println("读未提交："+transaction_read_uncommitted);

            //读已提交
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            int transaction_read_committed = conn.getTransactionIsolation();
            System.out.println("读已提交："+transaction_read_committed);

            //可重复读
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            int transaction_repeatable_read = conn.getTransactionIsolation();
            System.out.println("可重复读："+transaction_repeatable_read);

            //可串行化
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            int transaction_serializable = conn.getTransactionIsolation();
            System.out.println("可串行化："+transaction_serializable);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
    }


}
