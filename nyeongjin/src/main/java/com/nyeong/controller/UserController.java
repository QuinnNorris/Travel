package com.nyeong.controller;

import com.nyeong.annotation.Logged;
import com.nyeong.service.UserService;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:  UserController
 * Description: 接收请求并处理 用户
 *
 * @Author: quanningzhen
 * @Date: 2018/4/16 上午10:54
 * @Version: 1.0
 **/

//todo 修改返回结果，不能返回密码，重新组装
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //根据 uid 获得用户信息
    @Logged({"id"})
    @GetMapping("/user")
    public BaseJson getUserMeg(@RequestParam("id") int id) {
        return userService.getUserMsg( id );
    }

    //注册用户
    @Logged({"userName", "password", "phone"})
    @PostMapping("/register")
    public BaseJson userRegister(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("phone") String phone) {
        return userService.signUpUserMsg( userName, password, phone );
    }


    //下面 todo


    //用户登录
    @Logged({"account", "password"})
    @PostMapping("/login")
    public BaseJson userLogin(@RequestParam("account") String account, @RequestParam("password") String password) {
        return userService.userLogin( account, password );
    }


    //现在的逻辑不需要加 user
//    @Logged({ "userID"})
//    @PostMapping("/logout")
//    public BaseJson userLogout( @RequestParam("userID") int userID) {
//        Token token = new Token( tokenString, userID );
//        userService.userLogout( token );
//        return BaseJson.success();
//    }


    //todo 省事的话可以不做这个。。
//    @Logged({ "userID"})
//    @GetMapping("/info")
//    public BaseJson getMyUserInfo( @RequestParam("userID") int userID) {
//        Token token = new Token( tokenString, userID );
//        MyUserInfo myUserInfo = userService.getMyUserInfo( token );
//        return BaseJson.success( myUserInfo );
//    }


    @Logged({"userID", "newPassword", "oldPassword"})
    @PostMapping("/update/password")
    public BaseJson updateUserPassword(@RequestParam("userID") int userID,
                                       @RequestParam("oldPassword") String oldPassword,
                                       @RequestParam("newPassword") String newPassword) {

        return userService.updateUserPassword( userID, oldPassword, newPassword );
    }


}