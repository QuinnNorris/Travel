package com.nyeong.service;

import com.nyeong.annotation.Logged;
import com.nyeong.entity.Plan;
import com.nyeong.entity.Route;
import com.nyeong.enums.ErrorCode;
import com.nyeong.mapper.PlanMapper;
import com.nyeong.util.BaseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PlanService {

    private static final Logger LOGGER = LoggerFactory.getLogger( PlanService.class );

    @Autowired
    private final PlanMapper planMapper;

    public PlanService(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    @Logged({"planID"})
    @Transactional
    public BaseJson getPlanById(Integer planID) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

    @Logged({"id"})
    @Transactional
    public BaseJson getRouterByID(Integer id) {
        BaseJson baseJson = new BaseJson();
        List routeList = planMapper.getAllRouteByPlanID( id );

        return baseJson;
    }

}
