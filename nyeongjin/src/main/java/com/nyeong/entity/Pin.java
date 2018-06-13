package com.nyeong.entity;

import com.nyeong.enums.PinStatus;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: Pin
 * @Description: Pin表的实例
 * @Author: Felix
 * @Date: 5/31/2018 18:22
 * @Version: 1.0
 **/

public class Pin implements Serializable {

    private static final long serialVersionUID = 1L;

    private int pinID;

    private int planID;

    private double pinLatitude;

    private double pinLongitude;

    private String pinTitle;

    private Date pinArrival;

    private Date pinDeparture;

    private PinStatus pinStatus;

    private String pinNotes;

    public int getPinID() {
        return pinID;
    }

    public void setPinID(int pinID) {
        this.pinID = pinID;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public double getPinLatitude() {
        return pinLatitude;
    }

    public void setPinLatitude(double pinLatitude) {
        this.pinLatitude = pinLatitude;
    }

    public double getPinLongitude() {
        return pinLongitude;
    }

    public void setPinLongitude(double pinLongitude) {
        this.pinLongitude = pinLongitude;
    }

    public String getPinTitle() {
        return pinTitle;
    }

    public void setPinTitle(String pinTitle) {
        this.pinTitle = pinTitle;
    }

    public Date getPinArrival() {
        return pinArrival;
    }

    public void setPinArrival(Date pinArrival) {
        this.pinArrival = pinArrival;
    }

    public Date getPinDeparture() {
        return pinDeparture;
    }

    public void setPinDeparture(Date pinDeparture) {
        this.pinDeparture = pinDeparture;
    }

    public PinStatus getPinStatus() {
        return pinStatus;
    }

    public void setPinStatus(PinStatus pinStatus) {
        this.pinStatus = pinStatus;
    }

    public String getPinNotes() {
        return pinNotes;
    }

    public void setPinNotes(String pinNotes) {
        this.pinNotes = pinNotes;
    }
}
