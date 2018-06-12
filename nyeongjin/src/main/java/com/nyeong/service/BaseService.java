package com.nyeong.service;

import com.nyeong.mapper.PlanMapper;
import com.nyeong.mapper.UserInfoMapper;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title:  BaseService
 * Description:
 *
 * @Author: Gwon NyeongJin
 * @Date: 2018/6/12 下午1:33
 * @Version: 1.0
 **/

@Service
public class BaseService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PlanMapper planMapper;

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
     * 根据计划ID获取计划信息
     * errorCode - 0000(成功)/1001(未找到);
     * object - Plan;
     *
     * @param id
     * @return
     */
    public BaseJson getPlanMsg(int id) {

        BaseJson baseJson = new BaseJson().setObject(planMapper.getPlanByID(id));

        if (baseJson.getObject() == null)
            return baseJson.setErrorCode("1001");

        return baseJson.setErrorCode("0000");
    }

}
