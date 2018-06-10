package com.nyeong.service;

import com.nyeong.entity.UserInfo;
import com.nyeong.enums.UserStatus;
import com.nyeong.mapper.UserInfoMapper;
import com.nyeong.util.BaseJson;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private UserInfoMapper userInfoMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    /**
     * 根据用户ID获取用户信息
     *
     * errorCode - 0000(成功)/1001(未找到);
     * object - User;
     *
     * @return
     */
    public BaseJson getUserMsg(int id) {
        BaseJson baseJson = new BaseJson().setObject(userInfoMapper.getOne(id));
        LOGGER.info("find BY selectUserByuserID, id ->" + id);
        if (baseJson.getObject() == null)
            return baseJson.setErrorCode("1001");
        return baseJson.setErrorCode("0000");
    }

    /**
     * 注册用户
     *
     * errorCode - 0000(成功)/1002(用户名已被他人注册)/1003(此手机号已注册);
     * object - id;
     *
     * @param userName 用户名
     * @param password 密码
     * @param phone    手机号
     * @return
     */
    public BaseJson signUpUserMsg(String userName, String password, String phone) {

        BaseJson baseJson = new BaseJson();

        baseJson.setObject(userInfoMapper.getOneByUserName(userName));
        if (baseJson.getObject() != null)
            return baseJson.setObject(null).setErrorCode("1002");

        baseJson.setObject(userInfoMapper.getOneByPhone(phone));
        if (baseJson.getObject() != null)
            return baseJson.setObject(null).setErrorCode("1003");

        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(phone);
        userInfo.setPassword(password);
        userInfo.setUserName(userName);
        userInfo.setUserStatus(UserStatus.NORMAL);

        int id = userInfoMapper.insert(userInfo);

        return baseJson.setObject(id).setErrorCode("0000");

    }



}
