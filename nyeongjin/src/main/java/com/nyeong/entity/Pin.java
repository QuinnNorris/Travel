package com.nyeong.entity;

import com.nyeong.enums.PinStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    private boolean isDelete;

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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pin pin = (Pin) o;
        return pinID == pin.pinID &&
                planID == pin.planID &&
                Double.compare( pin.pinLatitude, pinLatitude ) == 0 &&
                Double.compare( pin.pinLongitude, pinLongitude ) == 0 &&
                Objects.equals( pinTitle, pin.pinTitle ) &&
                Objects.equals( pinArrival, pin.pinArrival ) &&
                Objects.equals( pinDeparture, pin.pinDeparture ) &&
                pinStatus == pin.pinStatus &&
                Objects.equals( pinNotes, pin.pinNotes );
    }

    @Override
    public int hashCode() {

        return Objects.hash( pinID, planID, pinLatitude, pinLongitude, pinTitle, pinArrival, pinDeparture, pinStatus, pinNotes );
    }
}
