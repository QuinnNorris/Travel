package com.nyeong.service;

import com.nyeong.mapper.UserMapper;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Title: UserService
 * Description: 业务处理 用户
 *
 * @Author: quanningzhen
 * @Date: 2018/4/15 下午11:26
 * @Version: 1.0
 **/

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger("com.service.UserService");

    @Transactional
    public String getUserMessage(){
        logger.info("in getUserMessage.");
        return userMapper.getOne(1).toString();
    }

}
