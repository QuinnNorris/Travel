package com.nyeong.service;

import com.nyeong.entity.Participants;
import com.nyeong.entity.Plan;
import com.nyeong.entity.Plat;
import com.nyeong.mapper.ParticipantsMapper;
import com.nyeong.mapper.PlanMapper;
import com.nyeong.mapper.PlatMapper;
import com.nyeong.util.BaseJson;
import com.nyeong.util.ConfigeUtil;
import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Title: PlanService
 * Description: 业务处理 计划
 *
 * @Author: quanningzhen
 * @Date: 2018/4/15 下午11:26
 * @Version: 1.0
 **/

@Service
public class PlanService extends BaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlanService.class);

    @Autowired
    private PlanMapper planMapper;

    @Autowired
    private ParticipantsMapper participantsMapper;

    @Autowired
    private PlatMapper platMapper;


    /**
     * 根据用户找出所有使用中计划
     * errorCode - 0000(成功)/1001(未找到);
     * object - List - Plan - plans;
     *
     * @param userId
     * @return
     */
    public BaseJson getPlansByUserId(Integer userId) {

        BaseJson baseJson = new BaseJson();

        if (getUserMsg(userId).getErrorCode().equals("1001"))
            return baseJson;

        Participants participants = new Participants();
        participants.setParticipantID(userId);
        participants.setIsDelete(ConfigeUtil.NOT_DELETE);

        baseJson.setObject(participantsMapper.getPlanIDByuserID(participants));
        List<Participants> participantsList = (List<Participants>) baseJson.getObject();

        if (participantsList == null || (participantsList.isEmpty()))
            return baseJson.setObject(new ArrayList<Plan>()).setErrorCode("0000");

        List<Integer> planIds = (List<Integer>) CollectionUtils.collect(
                participantsList, new Transformer() {
                    public Object transform(Object object) {
                        Integer planId = null;
                        try {
                            planId = ((Participants) object).getPlanID();
                        } catch (Exception e) {
                            LOGGER.error("planIds build error", e);
                        }
                        return planId;
                    }
                });

        List<Plan> plans = planMapper.getByPlanIds(planIds);
        return baseJson.setObject(plans).setErrorCode("0000");
    }

    /**
     * 根据用户添加计划与地图(只添加计划，不打点)
     * errorCode - 0000(成功)/1001(未找到);
     * object - null;
     *
     * @param userId
     * @return
     */
    public BaseJson addPlanByUserId(Integer userId, Plan plan, Plat plat) {

        BaseJson baseJson = new BaseJson();
        if (getUserMsg(userId).getErrorCode().equals("1001"))
            return baseJson;

        plan.setIsdelete(ConfigeUtil.NOT_DELETE);
        plan.setAddTime(new Date());
        planMapper.insert(plan);

        plat.setIsdelete(ConfigeUtil.NOT_DELETE);
        plat.setAddTime(new Date());
        platMapper.insert(plat);

        return baseJson.setErrorCode("0000");
    }

    /**
     * 根据用户修改计划与地图(只添加计划，不打点)
     * errorCode - 0000(成功)/1001(未找到);
     * object - null;
     *
     * @param userId
     * @return
     */
    public BaseJson updatePlanByUserId(Integer userId, Plan plan, Plat plat) {

        BaseJson baseJson = new BaseJson();
        if (getUserMsg(userId).getErrorCode().equals("1001"))
            return baseJson;

        plan.setUpdateTime(new Date());
        planMapper.update(plan);

        plan.setUpdateTime(new Date());
        platMapper.update(plan);

        return baseJson.setErrorCode("0000");
    }

    public BaseJson getRouterByID(Integer id) {
        BaseJson baseJson = new BaseJson();
        List routeList = planMapper.getAllRouteByPlanID(id);

        return baseJson;
    }

}
