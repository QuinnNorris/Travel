package com.nyeong.controller;

import com.nyeong.entity.Pin;
import com.nyeong.service.PinService;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pin")
public class PinController {

    @Autowired
    private PinService pinService;

    public PinController(PinService pinService) {
        this.pinService = pinService;
    }

    //增删改查
    //根据 pid 获取详细计划
    @GetMapping("query")
    public BaseJson getpinByID(@RequestParam("pinID") Integer pinID) {
        return new BaseJson();
    }


    @PostMapping("/add")
    public BaseJson add(pin pin) {
        return pinService.addpin( pin );
    }

    @PostMapping("/delete")
    public BaseJson delete(@RequestParam Integer id) {
        return pinService.deleteById( id );

    }

    @PostMapping("/update")
    public BaseJson update(pin pin) {
        return pinService.update( pin );
    }

    @GetMapping("query/routes")
    public BaseJson getRoutesByID(@RequestParam("pinID") Integer pinID) {
        return new BaseJson();
    }


    @GetMapping("/pins")
    public BaseJson getPinsBypinID(@RequestParam("pinid") Integer pinID) {
        return pinService.getPinsBypinID( pinID );
    }
}
