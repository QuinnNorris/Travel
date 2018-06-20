package com.nyeong.service;

import com.nyeong.entity.Participants;
import com.nyeong.entity.UserInfo;
import com.nyeong.mapper.ParticipantMapper;
import com.nyeong.mapper.UserInfoMapper;
import com.nyeong.util.BaseJson;
import com.nyeong.util.ConfigeUtil;
import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParticipantService extends BaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantService.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ParticipantMapper participantMapper;

    /**
     * 根据 planId, ParticipantID 查找此参与者的具体信息
     * errorCode - 0000(成功)/1001(未找到);
     * object - Participant - participant;
     *
     * @param planId
     * @param participantID
     * @return
     */
    public BaseJson getParticipantByPId(Integer planId, Integer participantID) {

        BaseJson baseJson = new BaseJson();
        if (getPlanMsg(planId).getErrorCode().equals("1001"))
            return baseJson;

        Participants participants = new Participants();
        participants.setPlanID(planId);
        participants.setParticipantID(participantID);
        participants.setIsDelete(ConfigeUtil.NOT_DELETE);

        participants = participantMapper.getByPlanIdAndParticipantId(participants);

        return baseJson.setObject(participants).setErrorCode("0000");
    }

    /**
     * 根据 planId 查找此计划所有的参与者
     * errorCode - 0000(成功)/1001(未找到);
     * object - List - User - users;
     *
     * @param planId
     * @return
     */
    public BaseJson getParticipantsByPId(Integer planId) {

        BaseJson baseJson = new BaseJson();
        if (getPlanMsg(planId).getErrorCode().equals("1001"))
            return baseJson;

        Participants participants = new Participants();
        participants.setPlanID(planId);
        participants.setIsDelete(ConfigeUtil.NOT_DELETE);

        List<Participants> participantsList = participantMapper.getByPlanId(participants);

        List<UserInfo> users = (List<UserInfo>) CollectionUtils.collect(
                participantsList, new Transformer() {
                    public Object transform(Object object) {
                        UserInfo userInfo = null;
                        try {
                            userInfo = userInfoMapper.getOne(((Participants) object).getParticipantID());
                        } catch (Exception e) {
                            LOGGER.error("planIds build error", e);
                        }
                        return userInfo;
                    }
                });

        return baseJson.setObject(users).setErrorCode("0000");
    }

    /**
     * 增加参与者情况
     * errorCode - 0000(成功);
     * object - null;
     *
     * @param participants
     * @return
     */
    public BaseJson addParticipants(Participants participants) {

        participants.setIsDelete(ConfigeUtil.NOT_DELETE);
        participantMapper.insert(participants);

        return new BaseJson("0000");
    }

    /**
     * 更新参与者情况
     * errorCode - 0000(成功);
     * object - null;
     *
     * @param participants
     * @return
     */
    public BaseJson updateParticipants(Participants participants) {

        participantMapper.updateParticipants(participants);

        return new BaseJson("0000");
    }

}
