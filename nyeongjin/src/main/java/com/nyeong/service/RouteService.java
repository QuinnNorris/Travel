package com.nyeong.service;

import com.nyeong.entity.Route;
import com.nyeong.mapper.RouteMapper;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RouteService {

    @Autowired
    private RouteMapper routeMapper;

    public RouteService(RouteMapper routeMapper) {
        this.routeMapper = routeMapper;
    }

    @Transactional
    public BaseJson addRoute(Route route) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

    @Transactional
    public BaseJson deleteById(Integer id) {
        BaseJson baseJson = new BaseJson();

        return baseJson;
    }

    @Transactional
    public BaseJson update(Route route) {
        BaseJson baseJson = new BaseJson();
        return baseJson;
    }

    @Transactional
    public BaseJson getRouteByRouteID(Integer id) {
        BaseJson baseJson = new BaseJson();
        return baseJson;
    }

    @Transactional
    public BaseJson getPinsByRouteID(Integer id) {
        BaseJson baseJson = new BaseJson();
        return baseJson;
    }


}
