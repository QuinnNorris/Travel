package com.nyeong.entity;

import com.tripin.application.enums.PinStatus;

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
}
