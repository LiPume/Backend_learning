package com.itheima;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url,username,password);
        //3.获取SQL语句执行对象
        Statement statement = connection.createStatement();
        //4.执行SQL
        int i = statement.executeUpdate("update user set age = 100 where id = 1");
        System.out.println("SQL执行完影响记录数："+i);
        //5.释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1234";

        Connection conn = DriverManager.getConnection(url,username,password);
        // 预编译SQL
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
        // 设置参数
        pstmt.setString(1, "daqiao"); // 第一个问号对应的参数
        pstmt.setString(2, "123456"); // 第二个问号对应的参数
        // 执行查询，返回结果集
        ResultSet rs = pstmt.executeQuery();
        // 处理结果集
        while (rs.next()) {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getInt("age")
            );

            System.out.println(user);
        }
        // 关闭资源
        rs.close();
        pstmt.close();
        conn.close();
    }
}


