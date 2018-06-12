package com.nyeong.controller;

import com.nyeong.service.PlanService;
import com.nyeong.service.UserService;
import com.nyeong.util.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;


    @GetMapping
    public BaseJson getPlanByID(@RequestParam("planID") Integer planID) {
        return new BaseJson();
    }


}
