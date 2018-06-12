package com.nyeong.service;

import com.nyeong.annotation.Logged;
import com.nyeong.entity.Participants;
import com.nyeong.mapper.ParticipantMapper;
import com.nyeong.util.BaseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ParticipantService {
    private static final Logger LOGGER = LoggerFactory.getLogger( ParticipantService.class );

    @Autowired
    private final ParticipantMapper participantMapper;

    public ParticipantService(ParticipantMapper participantMapper) {
        this.participantMapper = participantMapper;
    }

    //根据 planId, ParticipantID 查找此参与者的具体信息
    @Logged({"planId", "participantID"})
    @Transactional
    public BaseJson getParticipantByPId(Integer planId, Integer participantID) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }


    //根据 planId 查找此计划所有的参与者
    @Logged({"planId"})
    @Transactional
    public BaseJson getParticipantsByPId(Integer planId) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }


    //增加参与者
    @Transactional
    public BaseJson addParticipants(Participants participants) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

    // 根据 planID 和 userID 删除参与者
    @Transactional
    public BaseJson deleteById(Integer planID, Integer userID) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

    //更新参与者
    @Transactional
    public BaseJson update(Participants participants) {
        BaseJson baseJson = new BaseJson();
        return baseJson;
    }


}
