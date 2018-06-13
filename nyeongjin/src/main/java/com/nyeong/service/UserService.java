package com.nyeong.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
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
public class UserService extends BaseService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    /**
     * 根据用户ID获取用户信息
     * errorCode - 0000(成功)/1001(未找到);
     * object - UserInfo;
     *
     * @return
     */
    public BaseJson getUserMsg(int id) {

        BaseJson baseJson = new BaseJson().setObject(userInfoMapper.getOne(id));

        if (baseJson.getObject() == null)
            return baseJson.setErrorCode("1001");

        return baseJson.setErrorCode("0000");
    }

    /**
     * 注册用户
     * errorCode - 0000(成功)/1002(用户名已被他人注册)/1003(此手机号已注册);
     * object - Integer - id;
     *
     * @param userName
     * @param password
     * @param phone
     * @return
     */
    public BaseJson signUpUserMsg(String userName, String password, String phone) {

        BaseJson baseJson = new BaseJson();

        baseJson.setObject(userInfoMapper.getOneByUserName(userName));
        if (baseJson.getObject() != null)
            return baseJson.setObject(null).setErrorCode("1002");

        //用户名不能为某个手机号码
        baseJson.setObject(userInfoMapper.getOneByUserName(phone));
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

    /**
     * 登录用户
     * errorCode - 0000(成功)/1004(用户名或密码错误);
     * object - UserInfo;
     *
     * @param account
     * @param password
     * @return
     */
    public BaseJson userLogin(String account, String password) {

        BaseJson baseJson = new BaseJson();

        baseJson.setObject(userInfoMapper.getOneByUserNameAndPassword(account, password));
        if (baseJson.getObject() != null)
            return baseJson.setErrorCode("0000");

        baseJson.setObject(userInfoMapper.getOneByPhoneAndPassword(account, password));
        if (baseJson.getObject() != null)
            return baseJson.setErrorCode("0000");

        return baseJson.setErrorCode("1004");
    }

    /**
     * 更新密码
     * errorCode - 0000(成功)/1005(旧密码错误);
     * object - null;
     *
     * @param userID
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public BaseJson updateUserPassword(int userID, String oldPassword, String newPassword) {

        BaseJson baseJson = new BaseJson();

        baseJson.setObject(userInfoMapper.getOneByUserIDAndPassword(userID, oldPassword));
        if (baseJson.getObject() == null)
            return baseJson.setErrorCode("1005");

        userInfoMapper.updatePassword(userID, newPassword);

        return baseJson.setObject(null).setErrorCode("0000");
    }

    /**
     * 验证手机号
     * errorCode - 0000(成功)/1006(发送失败);
     * object - String - validateCode(验证码);
     *
     * @param phone
     * @return
     */
    public BaseJson validatePhone(String phone) {

        BaseJson baseJson = new BaseJson();

        String validateCode = (int) (Math.random() * 10000) + "";
        if (validateCode.length() < 4)
            for (int i = 0; i < 4 - validateCode.length(); i++)
                validateCode = "0" + validateCode;
        baseJson.setObject(validateCode);

        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";
        final String accessKeyId = "LTAIsFHjJXTp7q8J";
        final String accessKeySecret = "bJVaXVAzgCOYPE3nYZ7f5ZaAhWvdC4";
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e) {
            e.printStackTrace();
        }

        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        request.setPhoneNumbers(phone);
        request.setSignName("Tripin");
        request.setTemplateCode("SMS_126345224");
        request.setTemplateParam("{\"code\":\"" + validateCode + "\"}");
        request.setOutId("yourOutId");
        SendSmsResponse sendSmsResponse = null;

        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }

        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) baseJson.setErrorCode("0000");
        else baseJson.setErrorCode("1006");
        return baseJson;
    }

    /**
     * 绑定邮箱
     * errorCode - 0000(成功)/1001(未找到);
     * object - null;
     *
     * @param userId
     * @param email
     * @return
     */
    public BaseJson setUserEmail(int userId, String email) {

        BaseJson baseJson = getUserMsg(userId);

        if (baseJson.getErrorCode().equals("1001"))
            return baseJson;

        userInfoMapper.updateEmailByUserId(userId, email);

        return baseJson.setErrorCode("0000");
    }

}
