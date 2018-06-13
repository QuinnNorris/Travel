package com.nyeong.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nyeong.enums.UserStatus;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: UserInfo
 * @Description: UserInfo表的实例
 * @Author: Felix
 * @Date: 5/31/2018 16:31
 * @Version: 1.0
 **/

public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private int userID;

    private String userName;

    @JsonIgnore
    private String password;

    private String phone;

    @JsonProperty("mail")
    private String email;

    private UserStatus userStatus;

    public UserInfo() {

    }

    public UserInfo(int userID, String userName, String password, String phone, String email, UserStatus userStatus, String nickName) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userStatus = userStatus;
    }

    public UserInfo(String userName, String password, String phone, String email, UserStatus userStatus, String nickName) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userStatus = userStatus;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return getUserID() == userInfo.getUserID() &&
                Objects.equals(getUserName(), userInfo.getUserName()) &&
                Objects.equals(getPassword(), userInfo.getPassword()) &&
                Objects.equals(getPhone(), userInfo.getPhone()) &&
                Objects.equals(getEmail(), userInfo.getEmail()) &&
                getUserStatus() == userInfo.getUserStatus();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserID(), getUserName(), getPassword(), getPhone(), getEmail(), getUserStatus());
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
