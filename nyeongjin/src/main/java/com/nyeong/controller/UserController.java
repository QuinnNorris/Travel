package com.nyeong.controller;
import com.nyeong.annotation.Logged;
import com.nyeong.service.UserService;
import com.nyeong.util.BaseJson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Title:  UserController
 * Description: 接收请求并处理 用户
 *
 * @Author: quanningzhen
 * @Date: 2018/4/16 上午10:54
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //根据 uid 获得用户信息
    @Logged({"id"})
    @GetMapping("/info")
    public BaseJson getUserMeg(@RequestParam("id") int id) {
        BaseJson baseJson =  userService.getUserMsg( id );
        return baseJson;
    }
    //注册用户
    @Logged({"userName", "password", "phone"})
    @PostMapping("/register")
    public BaseJson userRegister(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("phone") String phone) {
        return userService.signUpUserMsg( userName, password, phone );
    }

    //验证码
    @GetMapping("/register/code")
    public BaseJson getVerifyCode(@RequestParam("phone") String phone) {
        return userService.validatePhone( phone );
    }

    //用户登录
    @Logged({"account", "password"})
    @PostMapping("/login")
    public BaseJson userLogin(@RequestParam("account") String account, @RequestParam("password") String password) {
        return userService.userLogin( account, password );
    }

    @Logged({"userID", "newPassword", "oldPassword"})
    @PostMapping("/update/password")
    public BaseJson updateUserPassword(@RequestParam("id") int userID,
                                       @RequestParam("oldPassword") String oldPassword,
                                       @RequestParam("newPassword") String newPassword) {
        return userService.updateUserPassword( userID, oldPassword, newPassword );
    }
    //更新密码
    @PostMapping("/updata/email")
    public BaseJson updateUserPassword(@RequestParam("id") int userId, @RequestParam("email") String email) {
        return userService.setUserEmail( userId, email );
    }

}