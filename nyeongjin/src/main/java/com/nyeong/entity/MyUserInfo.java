package com.nyeong.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: MyUserInfo
 * @Description: myUserInfo视图的实例
 * @Author: Felix
 * @Date: 6/2/2018 16:42
 * @Version: 1.0
 **/

public class MyUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private int userID;

    private String userName;

    private String phone;

    @JsonProperty("mail")
    private String email;

    private String nickName;

    //0代表没有 delete
    private int isDelete = 0;

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public MyUserInfo() {
    }

    public MyUserInfo(int userID, String userName, String phone, String email, String nickName) {
        this.userID = userID;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.nickName = nickName;
    }

    public MyUserInfo(String userName, String phone, String email, String nickName) {
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.nickName = nickName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyUserInfo that = (MyUserInfo) o;
        return getUserID() == that.getUserID() &&
                Objects.equals(getUserName(), that.getUserName()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getNickName(), that.getNickName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserID(), getUserName(), getPhone(), getEmail(), getNickName());
    }


}

