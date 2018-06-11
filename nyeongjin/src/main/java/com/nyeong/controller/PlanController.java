package com.nyeong.controller;

import com.nyeong.service.PlanService;
import com.nyeong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanController {
    @Autowired
    private PlanService planService;


}
