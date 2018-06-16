package com.nyeong.controller;
import com.nyeong.entity.Route;
import com.nyeong.service.PlatRouteService;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private PlatRouteService platRouteService;
    public RouteController(PlatRouteService platRouteService) {
        this.platRouteService = platRouteService;
    }

    //增删改查
    //根据 routeID 获取路线
//    @GetMapping("query")
//    public BaseJson getrouteByID(@RequestParam("routeID") Integer routeID) {
//        return platRouteService.getRouteByRouteID( routeID );
//    }
//    //  根据 routeID 获取路线的两个 pin
//    @GetMapping("query/pins")
//    public BaseJson getpinsByID(@RequestParam("routeID") Integer routeID) {
//        return platRouteService.getPinsByRouteID( routeID );
//    }

    //根据 plan id 获得所有 routes
    @GetMapping("query/routes")
    public BaseJson getRoutesByPlanId(@RequestParam("planId") Integer planId) {
        return platRouteService.getRoutesByPlanId( planId );
    }

    @PostMapping("/add")
    public BaseJson add(Route route) {
        return platRouteService.addRoute( route );
    }
//    @PostMapping("/delete")
//    public BaseJson delete(@RequestParam Integer id) {
//        return platRouteService.deleteById( id );
//    }
    @PostMapping("/update")
    public BaseJson update(Route route) {
        return platRouteService.updateRoute( route );
    }
}
