package com.nyeong.controller;
import com.nyeong.annotation.Logged;
import com.nyeong.entity.Participants;
import com.nyeong.entity.Plan;
import com.nyeong.service.ParticipantService;
import com.nyeong.util.BaseJson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/joins")
public class ParticipantsController {
    @Autowired
    private ParticipantService participantService;
    //todo 如何直接根据 plan 实体进行操作
    //根据 planId, ParticipantID 查找此参与者的具体信息
    @Logged({"planId", "participantID"})
    @GetMapping("/query")
    public BaseJson getParticipantByPId(@RequestParam Integer planId, @RequestParam Integer participantID) {
        BaseJson baseJson = participantService.getParticipantByPId( planId, participantID );
        return baseJson;
    }
    //根据 planId 查找此计划所有的参与者
    @Logged({"planId"})
    @GetMapping("/query/users")
    public BaseJson getParticipantsByPId(@RequestParam Integer planId) {
        BaseJson baseJson = participantService.getParticipantsByPId( planId );
        return baseJson;
    }
    //增加参与者
    @PostMapping("/add")
    public BaseJson addParticipants(Participants participants) {
        BaseJson baseJson = participantService.addParticipants( participants );
        return baseJson;
    }
    // 根据 planID 和 userID 删除参与者
    //todo service 未实现
//    @PostMapping("/delete")
//    public BaseJson deleteById(Integer planID, Integer userID) {
//        BaseJson baseJson = new BaseJson();
//        return baseJson;
//    }

    //更新参与者
    @RequestMapping("/update")
    public BaseJson update(Participants participants) {
        BaseJson baseJson = participantService.updateParticipants( participants );
        return baseJson;
    }
}