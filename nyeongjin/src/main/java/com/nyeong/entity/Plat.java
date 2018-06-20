package com.nyeong.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: Plat
 * @Description: 地图表的实例
 * @Author: Felix
 * @Date: 5/31/2018 18:15
 * @Version: 1.0
 **/

public class Plat  implements Serializable {

    private static final long serialVersionUID = 1L;

    private int mapID;

    private double centerLatitude;

    private double centerLongitude;

    private boolean mapIsAbroad;

    private int mapZoom;


    private boolean isDelete = false;

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Plat() {
    }

    public Plat(int mapID, double centerLatitude, double centerLongitude, boolean mapIsAbroad, int mapZoom) {
        this.mapID = mapID;
        this.centerLatitude = centerLatitude;
        this.centerLongitude = centerLongitude;
        this.mapIsAbroad = mapIsAbroad;
        this.mapZoom = mapZoom;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public double getCenterLatitude() {
        return centerLatitude;
    }

    public void setCenterLatitude(double centerLatitude) {
        this.centerLatitude = centerLatitude;
    }

    public double getCenterLongitude() {
        return centerLongitude;
    }

    public void setCenterLongitude(double centerLongitude) {
        this.centerLongitude = centerLongitude;
    }

    public boolean isMapIsAbroad() {
        return mapIsAbroad;
    }

    public void setMapIsAbroad(boolean mapIsAbroad) {
        this.mapIsAbroad = mapIsAbroad;
    }

    public int getMapZoom() {
        return mapZoom;
    }

    public void setMapZoom(int mapZoom) {
        this.mapZoom = mapZoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return getMapID() == plat.getMapID() &&
                Double.compare(plat.getCenterLatitude(), getCenterLatitude()) == 0 &&
                Double.compare(plat.getCenterLongitude(), getCenterLongitude()) == 0 &&
                isMapIsAbroad() == plat.isMapIsAbroad() &&
                getMapZoom() == plat.getMapZoom();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMapID(), getCenterLatitude(), getCenterLongitude(), isMapIsAbroad(), getMapZoom());
    }

    @Override
    public String toString() {
        return "Plat{" +
                "mapID=" + mapID +
                ", centerLatitude=" + centerLatitude +
                ", centerLongitude=" + centerLongitude +
                ", mapIsAbroad=" + mapIsAbroad +
                ", mapZoom=" + mapZoom +
                '}';
    }
}
