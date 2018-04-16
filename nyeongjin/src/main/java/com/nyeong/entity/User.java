package com.nyeong.entity;

/**
 * Title:  User
 * Description: 数据库表实例化 user
 *
 * @Author: quanningzhen
 * @Date: 2018/4/16 上午11:16
 * @Version: 1.0
 **/

public class User {

    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String password;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userName " + this.id + ", pasword " + this.username + "sex " + this.password;
    }
}