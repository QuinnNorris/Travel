package com.nyeong.service;

import com.nyeong.entity.Plat;
import com.nyeong.entity.Route;
import com.nyeong.mapper.PlatMapper;
import com.nyeong.mapper.RouteMapper;
import com.nyeong.util.BaseJson;
import com.nyeong.util.ConfigUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:  PlatRouteService
 * Description:
 *
 * @Author: Gwon NyeongJin
 * @Date: 2018/6/13 下午8:43
 * @Version: 1.0
 **/

@Service
public class PlatRouteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlatRouteService.class);

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private PlatMapper platMapper;

    /**
     * 根据地图id查找plat
     * errorCode - 0000(成功)/1001(未找到);
     * object - Plat - plat;
     *
     * @param mapId
     * @return
     */
    public BaseJson getPlatByMapId(Integer mapId) {

        BaseJson baseJson = new BaseJson();

        Plat plat = new Plat();
        plat.setMapID(mapId);
        plat.setIsDelete(ConfigUtil.NOT_DELETE);

        plat = platMapper.getByMapId(plat);
        return baseJson.setObject(plat).setErrorCode("0000");
    }

    /**
     * 添加地图数据并返回主键mapId
     * errorCode - 0000(成功);
     * object - int - mapId;
     *
     * @param plat
     * @return
     */
    public BaseJson addPlat(Plat plat) {

        BaseJson baseJson = new BaseJson();

        int mapId = platMapper.insert(plat);

        return baseJson.setObject(mapId).setErrorCode("0000");
    }

    /**
     * 更新地图信息
     * errorCode - 0000(成功);
     * object - null;
     *
     * @param plat
     * @return
     */
    public BaseJson updatePlat(Plat plat) {

        BaseJson baseJson = new BaseJson();

        platMapper.update(plat);

        return baseJson.setErrorCode("0000");

    }

    /**
     * 根据起始和终止点坐标查询路线
     * errorCode - 0000(成功);
     * object - Route - route;
     *
     * @param pinBegId
     * @param pinEndId
     * @return
     */
    //todo what's this
    public BaseJson getRouteByPinBegIdAndPinEndId(Integer pinBegId, Integer pinEndId) {

        BaseJson baseJson = new BaseJson();

        Route route = new Route();
        route.setOrigin(pinBegId);
        route.setDestination(pinEndId);
        route.setIsDelete(ConfigUtil.NOT_DELETE);

        route = routeMapper.getRouteByOriginAndDestination(route);
        return baseJson.setObject(route).setErrorCode("0000");
    }

    /**
     * 根据计划id查找路线
     * errorCode - 0000(成功);
     * object - List - Route - routes;
     *
     * @param planId
     * @return
     */
    public BaseJson getRoutesByPlanId(Integer planId) {

        BaseJson baseJson = new BaseJson();

        Route route = new Route();
        route.setPlanID(planId);
        route.setIsDelete(ConfigUtil.NOT_DELETE);

        List<Route> routes = routeMapper.getRoutesByPlanId(route);
        return baseJson.setObject(routes).setErrorCode("0000");
    }

    /**
     * 添加路线数据
     * errorCode - 0000(成功);
     * object - null;
     *
     * @param route
     * @return
     */
    public BaseJson addRoute(Route route) {

        BaseJson baseJson = new BaseJson();

        routeMapper.insert(route);

        return baseJson.setErrorCode("0000");
    }

    /**
     * 更新路线信息
     * errorCode - 0000(成功);
     * object - null;
     *
     * @param route
     * @return
     */
    public BaseJson updateRoute(Route route) {

        BaseJson baseJson = new BaseJson();

        routeMapper.updateByRouteId(route);

        return baseJson.setErrorCode("0000");

    }

}
