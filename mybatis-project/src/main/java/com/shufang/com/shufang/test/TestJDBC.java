package com.shufang.com.shufang.test;

import java.sql.*;

public class TestJDBC {

    public static void main(String[] args) throws Exception {


        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello", "root", "888888");


        /**
         * 方式1,可以设置自动生成的主键,这是jdbc的原生功能，mybatis也进行了封装
         */
        PreparedStatement preparedStatement = conn.prepareStatement("select * from hello.user where id = ?", 1);

        preparedStatement.setInt(1, 1001);

        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        generatedKeys.next();

        int id = generatedKeys.getInt(1);


        /**
         * 方式2
         */
        Statement statement = conn.createStatement();

        statement.executeUpdate("select * from hello.user where id = 1001 and name = '张三'");

        conn.close();

    }
}
