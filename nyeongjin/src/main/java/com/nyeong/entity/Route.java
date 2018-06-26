package com.nyeong.entity;

import com.nyeong.enums.Transportation;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: Route
 * @Description: Route路线表的实例
 * @Author: Felix
 * @Date: 5/31/2018 18:38
 * @Version: 1.0
 **/

public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    private int routeID;

    private int planID;

    private int origin;

    private int destination;

    private Transportation routeTransportation;

    private int routeTime;

    private boolean routeIsChosen;

    private boolean isDelete = false;

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Route() {
    }

    public Route(int planID){
        this.planID=planID;
    }

    public Route(int routeID, int planID, int origin, int destination, Transportation routeTransportation, int routeTime, boolean routeIsChosen, boolean isDelete) {
        this.routeID = routeID;
        this.planID = planID;
        this.origin = origin;
        this.destination = destination;
        this.routeTransportation = routeTransportation;
        this.routeTime = routeTime;
        this.routeIsChosen = routeIsChosen;
        this.isDelete = isDelete;
    }

    public Route(int routeID, int planID, int origin, int destination, Transportation routeTransportation, int routeTime, boolean routeIsChosen) {
        this.routeID = routeID;
        this.planID = planID;
        this.origin = origin;
        this.destination = destination;
        this.routeTransportation = routeTransportation;
        this.routeTime = routeTime;
        this.routeIsChosen = routeIsChosen;
    }

    public Route(int planID, int origin, int destination, Transportation routeTransportation, int routeTime, boolean routeIsChosen, boolean isDelete) {
        this.planID = planID;
        this.origin = origin;
        this.destination = destination;
        this.routeTransportation = routeTransportation;
        this.routeTime = routeTime;
        this.routeIsChosen = routeIsChosen;
        this.isDelete = isDelete;
    }

    public Route(int planID, int origin, int destination, Transportation routeTransportation, int routeTime, boolean routeIsChosen) {
        this.planID = planID;
        this.origin = origin;
        this.destination = destination;
        this.routeTransportation = routeTransportation;
        this.routeTime = routeTime;
        this.routeIsChosen = routeIsChosen;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public Transportation getRouteTransportation() {
        return routeTransportation;
    }

    public void setRouteTransportation(Transportation routeTransportation) {
        this.routeTransportation = routeTransportation;
    }

    public int getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(int routeTime) {
        this.routeTime = routeTime;
    }

    public boolean isRouteIsChosen() {
        return routeIsChosen;
    }

    public void setRouteIsChosen(boolean routeIsChosen) {
        this.routeIsChosen = routeIsChosen;
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
        Route route = (Route) o;
        return getRouteID() == route.getRouteID() &&
                getPlanID() == route.getPlanID() &&
                getOrigin() == route.getOrigin() &&
                getDestination() == route.getDestination() &&
                getRouteTime() == route.getRouteTime() &&
                isRouteIsChosen() == route.isRouteIsChosen() &&
                isDelete() == route.isDelete() &&
                getRouteTransportation() == route.getRouteTransportation();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRouteID(), getPlanID(), getOrigin(), getDestination(), getRouteTransportation(), getRouteTime(), isRouteIsChosen(), isDelete());
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeID=" + routeID +
                ", planID=" + planID +
                ", origin=" + origin +
                ", destination=" + destination +
                ", routeTransportation=" + routeTransportation +
                ", routeTime=" + routeTime +
                ", routeIsChosen=" + routeIsChosen +
                ", isDelete=" + isDelete +
                '}';
    }
}
