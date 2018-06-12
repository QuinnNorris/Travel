package com.nyeong.controller;

import com.nyeong.entity.Route;
import com.nyeong.service.RouteService;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    
    //增删改查
    //根据 routeID 获取路线
    @GetMapping("query")
    public BaseJson getrouteByID(@RequestParam("routeID") Integer routeID) {
        return routeService.getRouteByRouteID( routeID );
    }

    //  根据 routeID 获取路线的两个 pin
    @GetMapping("query/pins")
    public BaseJson getpinsByID(@RequestParam("routeID") Integer routeID) {
        return routeService.getPinsByRouteID( routeID );
    }


    @PostMapping("/add")
    public BaseJson add(Route route) {
        return routeService.addRoute( route );
    }

    @PostMapping("/delete")
    public BaseJson delete(@RequestParam Integer id) {
        return routeService.deleteById( id );

    }

    @PostMapping("/update")
    public BaseJson update(Route route) {
        return routeService.update( route );
    }

}
