package com.nyeong.controller;

import com.nyeong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:  UserController
 * Description: 接收请求并处理 用户
 *
 * @Author: quanningzhen
 * @Date: 2018/4/16 上午10:54
 * @Version: 1.0
 **/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUserMeg() {
        return userService.getUserMessage();
    }

}