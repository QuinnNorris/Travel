package com.nyeong.entity;

import com.nyeong.enums.PinStatus;

import javax.print.attribute.standard.PrinterURI;
import java.io.Serializable;
import java.sql.Timestamp;
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

    public Pin(int pinID, int planID, double pinLatitude, double pinLongitude, String pinTitle, Date pinArrival, Date pinDeparture, PinStatus pinStatus, String pinNotes) {
        this.pinID = pinID;
        this.planID = planID;
        this.pinLatitude = pinLatitude;
        this.pinLongitude = pinLongitude;
        this.pinTitle = pinTitle;
        this.pinArrival = pinArrival;
        this.pinDeparture = pinDeparture;
        this.pinStatus = pinStatus;
        this.pinNotes = pinNotes;
    }

    private int planID;

    private double pinLatitude;

    private double pinLongitude;

    private String pinTitle;

    private Date pinArrival;

    private Date pinDeparture;

    public Pin(){

    }

    public Pin(int planID){
        this.planID=planID;
    }

    public Pin(int pinID,int planID){
        this.pinID=pinID;
        this.planID=planID;
    }

    public Pin( int planID, double pinLatitude, double pinLongitude, String pinTitle, Date pinArrival, Date pinDeparture, PinStatus pinStatus, String pinNotes) {
        this.planID = planID;
        this.pinLatitude = pinLatitude;
        this.pinLongitude = pinLongitude;
        this.pinTitle = pinTitle;
        this.pinArrival = pinArrival;
        this.pinDeparture = pinDeparture;
        this.pinStatus = pinStatus;
        this.pinNotes = pinNotes;
    }

    public Pin(int pinID, int planID, double pinLatitude, double pinLongitude, String pinTitle, Date pinArrival, Date pinDeparture, PinStatus pinStatus, String pinNotes, boolean isDelete) {
        this.pinID = pinID;
        this.planID = planID;
        this.pinLatitude = pinLatitude;
        this.pinLongitude = pinLongitude;
        this.pinTitle = pinTitle;
        this.pinArrival = pinArrival;
        this.pinDeparture = pinDeparture;
        this.pinStatus = pinStatus;
        this.pinNotes = pinNotes;
        this.isDelete = isDelete;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    private PinStatus pinStatus;

    private String pinNotes;

    private Date addTime;
    private Date updateTime;


    private boolean isDelete = false;

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

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
