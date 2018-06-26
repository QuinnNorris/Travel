package com.nyeong.entity;

import com.nyeong.enums.PlanType;
import com.nyeong.enums.Transportation;


import java.io.Serializable;
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

    private Date planCreatedDate;

    private Date planModifiedDate;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    private Transportation defaultTransportation;

    private boolean isDelete = false;

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Plan() {
    }

    public Plan(String planName) {
        this.planName = planName;
    }

    public Plan(String planName, PlanType planType, Date planCreatedDate, Date planModifiedDate, Transportation defaultTransportation) {
        this.planName = planName;
        this.planType = planType;
        this.planCreatedDate = planCreatedDate;
        this.planModifiedDate = planModifiedDate;
        this.defaultTransportation = defaultTransportation;
    }

    public Plan(int planID, String planName, PlanType planType, Date planCreatedDate, Date planModifiedDate, Transportation defaultTransportation) {
        this.planID = planID;
        this.planName = planName;
        this.planType = planType;
        this.planCreatedDate = planCreatedDate;
        this.planModifiedDate = planModifiedDate;
        this.defaultTransportation = defaultTransportation;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }

    public Date getPlanCreatedDate() {
        return planCreatedDate;
    }

    public void setPlanCreatedDate(Date planCreatedDate) {
        this.planCreatedDate = planCreatedDate;
    }

    public Date getPlanModifiedDate() {
        return planModifiedDate;
    }

    public void setPlanModifiedDate(Date planModifiedDate) {
        this.planModifiedDate = planModifiedDate;
    }

    public Transportation getDefaultTransportation() {
        return defaultTransportation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan that = (Plan) o;
        return getPlanID() == that.getPlanID() &&
                Objects.equals(getPlanName(), that.getPlanName()) &&
                getPlanType() == that.getPlanType() &&
                Objects.equals(getPlanCreatedDate(), that.getPlanCreatedDate()) &&
                Objects.equals(getPlanModifiedDate(), that.getPlanModifiedDate()) &&
                getDefaultTransportation() == that.getDefaultTransportation();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlanID(), getPlanName(), getPlanType(), getPlanCreatedDate(), getPlanModifiedDate(), getDefaultTransportation());
    }

    public void setDefaultTransportation(Transportation defaultTransportation) {
        this.defaultTransportation = defaultTransportation;

    }

    @Override
    public String toString() {
        return "Plan{" +
                "planID=" + planID +
                ", planName='" + planName + '\'' +
                ", planType=" + planType +
                ", planCreatedDate=" + planCreatedDate +
                ", planModifiedDate=" + planModifiedDate +
                ", defaultTransportation=" + defaultTransportation +
                '}';
    }
}
