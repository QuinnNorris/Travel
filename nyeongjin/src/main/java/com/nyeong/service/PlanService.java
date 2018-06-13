package com.nyeong.service;

<<<<<<< HEAD
import com.nyeong.annotation.Logged;
import com.nyeong.entity.Plan;
import com.nyeong.entity.Route;
import com.nyeong.enums.ErrorCode;
=======
import com.nyeong.entity.Participants;
import com.nyeong.entity.Plan;
import com.nyeong.entity.Plat;
import com.nyeong.mapper.ParticipantsMapper;
<<<<<<< HEAD
>>>>>>> parent of d829abc... 10
=======
>>>>>>> parent of d829abc... 10
import com.nyeong.mapper.PlanMapper;
import com.nyeong.util.BaseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanService {

    private static final Logger LOGGER = LoggerFactory.getLogger( PlanService.class );

<<<<<<< HEAD
<<<<<<< HEAD
    @Autowired
    private final PlanMapper planMapper;
=======
>>>>>>> parent of d829abc... 10

    public PlanService(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }
=======
>>>>>>> parent of d829abc... 10

    @Logged({"planID"})
    @Transactional
    public BaseJson getPlanById(Integer planID) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

    @Logged({"id"})
    @Transactional
    public BaseJson getRoutesByID(Integer id) {
        BaseJson baseJson = new BaseJson();
        List routeList = planMapper.getAllRouteByPlanID( id );

        return baseJson;
    }


    @Transactional
    public BaseJson addPlan(Plan plan) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @Transactional
    public BaseJson deleteById(Integer id) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

    @Transactional
    public BaseJson update(Plan plan) {
        BaseJson baseJson = new BaseJson();
        return baseJson;
    }

    @Transactional
    public BaseJson getPinsByPlanID(Integer id) {
=======
=======
>>>>>>> parent of d829abc... 10
    public BaseJson getRoutesByID(Integer id) {
>>>>>>> parent of d829abc... 10
        BaseJson baseJson = new BaseJson();
        return baseJson;
    }

}
