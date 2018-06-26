package com.nyeong.entity;

import com.nyeong.enums.PlanType;
import com.nyeong.enums.Transportation;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Title: Plan
 * @Description: plan旅游计划表的实例
 * @Author: Felix
 * @Date: 5/31/2018 17:55
 * @Version: 1.0
 **/

public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;

    private int planID;

    private String planName;

    private PlanType planType;

    private Transportation defaultTransportation;

    private boolean isDelete = false;

    public Plan() {
    }

    public Plan(String planName, PlanType planType, Transportation defaultTransportation, boolean isDelete) {
        this.planName = planName;
        this.planType = planType;
        this.defaultTransportation = defaultTransportation;
        this.isDelete = isDelete;
    }

    public Plan(int planID, String planName, PlanType planType, Transportation defaultTransportation, boolean isDelete) {
        this.planID = planID;
        this.planName = planName;
        this.planType = planType;
        this.defaultTransportation = defaultTransportation;
        this.isDelete = isDelete;
    }
}
