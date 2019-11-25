package org.apache.ibatis;




import com.mysql.jdbc.Driver;

import java.sql.*;


/**
 * @author :hly
 * @date :2019/9/28
 * github :https://github.com/huangliangyun
 * desc :
 */
public class Test {


  static {
    try {
      Class.forName(Driver.class.getName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws SQLException {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8", "root", "roof");
    PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
    preparedStatement.setInt(1, 1);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()){
      String columnName1 = resultSet.getMetaData().getColumnName(1);
      String columnName2 = resultSet.getMetaData().getColumnName(2);
      String columnName3 = resultSet.getMetaData().getColumnName(3);
      System.out.println(columnName1+":"+resultSet.getString(1));
      System.out.println(columnName2+":"+resultSet.getString(2));
      System.out.println(columnName3+":"+resultSet.getString(3));
    }
    resultSet.close();
    preparedStatement.close();
    connection.close();
  }
}
