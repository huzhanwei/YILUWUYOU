package com.example.yiluwuyou.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    String driver = "com.mysql.jdbc.Driver";//MySQL 驱动
    String url = "jdbc:mysql://120.79.236.194:3306/yiluwuyou?user=root&password=hu@6339392";//MYSQL数据库连接Url
    Connection connection = null;
    Statement statement = null;

    public Database() {
        try {
            Class.forName(driver);//获取MYSQL驱动
            connection = DriverManager.getConnection(url);//获取连接
            statement = connection.createStatement();//获取数据库的对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
