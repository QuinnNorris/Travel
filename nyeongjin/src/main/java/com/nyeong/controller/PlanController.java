package com.nyeong.controller;

import com.nyeong.entity.Plan;
import com.nyeong.service.PlanPinService;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanPinService planService;


    //todo 如何直接根据 plan 实体进行操作

    //根据 pid 获取详细计划
    @GetMapping("query")
    public BaseJson getPlanByID(@RequestParam("planID") Integer planID) {
        return new BaseJson();
    }


    @PostMapping("/add")
    public BaseJson add(Plan plan) {
        return planService.addPlan( plan );
    }

    @PostMapping("/delete")
    public BaseJson delete(@RequestParam Integer id) {
        return planService.deleteById( id );

    }

    @PostMapping("/update")
    public BaseJson update(Plan plan) {
        return planService.update( plan );
    }

    @GetMapping("query/routes")
    public BaseJson getRoutesByID(@RequestParam("planID") Integer planID) {
        return new BaseJson();
    }


    @GetMapping("/pins")
    public BaseJson getPinsByPlanID(@RequestParam("planid") Integer planID) {
        return planService.getPinsByPlanID( planID );
    }


}
