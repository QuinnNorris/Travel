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
        return pinService.getPinsByPinID( pinID );
    }

    @PostMapping("/add")
    public BaseJson add(Pin pin) {
        return pinService.addPin( pin );
    }

    @PostMapping("/delete")
    public BaseJson delete(@RequestParam Integer id) {
        return pinService.deleteById( id );

    }

    @PostMapping("/update")
    public BaseJson update(Pin pin) {
        return pinService.update( pin );
    }

}
