package com.nyeong.controller;


import com.nyeong.entity.Plat;
import com.nyeong.service.PlatRouteService;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plat")
public class PlatController {

    @Autowired
    private PlatRouteService platRouteService;

    public PlatController(PlatRouteService platRouteService) {
        this.platRouteService = platRouteService;
    }

    @GetMapping("/query")
    public BaseJson getPlatByMapId(@RequestParam("mapId") Integer mapId) {

        BaseJson baseJson = platRouteService.getPlatByMapId( mapId );
        return baseJson;
    }

    @PostMapping("/add")
    public BaseJson addPlat(Plat plat) {

        BaseJson baseJson = platRouteService.addPlat( plat );

        return baseJson;
    }

    @PostMapping("/update")
    public BaseJson updatePlat(Plat plat) {

        BaseJson baseJson = platRouteService.updatePlat( plat );
        return baseJson;

    }


}
