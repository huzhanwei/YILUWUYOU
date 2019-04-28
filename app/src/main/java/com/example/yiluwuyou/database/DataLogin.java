package com.example.yiluwuyou.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataLogin {
    String driver = "com.mysql.jdbc.Driver";//MySQL 驱动
    String url = "jdbc:mysql://120.79.236.194:3306/yiluwuyou?user=root&password=hu@6339392";//MYSQL数据库连接Url
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String sql;
    String password,list_password;
    boolean aBoolean=false;

    public DataLogin(String account,String password){
        this.password=password;
        this.sql = "select user_password from user_list where  user_account='"+account+"'";
    }

   public boolean login() {
       try {
           Class.forName(driver);//获取MYSQL驱动
           connection = DriverManager.getConnection(url);//获取连接
           statement = connection.createStatement();//获取数据库的对象
           resultSet=statement.executeQuery(sql);
           if(resultSet!=null){
               while(resultSet.next()){
                   list_password=resultSet.getString("user_password");
               }
               if(password.equals(list_password)){
                   aBoolean=true;
               }else {
                   aBoolean=false;
               }
           }else {
               aBoolean=false;
           }
           connection.close();
           statement.close();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return aBoolean;
   }
}
