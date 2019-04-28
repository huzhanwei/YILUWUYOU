package com.example.yiluwuyou.entity;

import java.io.Serializable;

public class ShopEntity implements Serializable {
    private String account="无";
    private String password="无";
    private String name="无";

    public ShopEntity(String account,String password, String name){
        this.account=account;
        this.password=password;
        this.name=name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
