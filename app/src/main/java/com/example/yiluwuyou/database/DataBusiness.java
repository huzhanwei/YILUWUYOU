package com.example.yiluwuyou.database;

import com.example.yiluwuyou.entity.ShopEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBusiness {
    String driver = "com.mysql.jdbc.Driver";//MySQL 驱动
    String url = "jdbc:mysql://120.79.236.194:3306/yiluwuyou?user=root&password=hu@6339392";//MYSQL数据库连接Url
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String sql="select * from business;";
    //ShopEntity shopEntity;
    String string;
    ArrayList<ShopEntity> list=new ArrayList<ShopEntity>();



    public  ArrayList<ShopEntity> login1() {
        int i=0;

        try {
            Class.forName(driver);//获取MYSQL驱动
            connection = DriverManager.getConnection(url);//获取连接
            statement = connection.createStatement();//获取数据库的对象
            resultSet=statement.executeQuery(sql);

            if(resultSet!=null){
                while(resultSet.next()){
                    //string=resultSet.getString("business_account");
                    String s=resultSet.getString(2);
                    //shopEntity.setAccount(s);
                    String s1=resultSet.getString(3);
                    //shopEntity.setPassword(s1);
                    String s2=resultSet.getString(4);
                    //shopEntity.setName(s2);
                    ShopEntity shopEntity=new ShopEntity(s,s1,s2);
                    list.add(shopEntity);
                }
            }

                connection.close();
                statement.close();
                resultSet.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        ShopEntity[] shopEntities=new ShopEntity[list.size()];
//        for(int i=0;i<list.size();i++) {
//            shopEntities[i] = list.get(i);
//        }
        return list;
    }
}
