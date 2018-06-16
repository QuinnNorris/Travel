package com.nyeong.entity;

import com.nyeong.enums.ParticipantAuthorizationType;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: Participants
 * @Description: Participants旅游计划参与表的实例
 * @Author: Felix
 * @Date: 5/31/2018 18:07
 * @Version: 1.0
 **/

public class Participants implements Serializable {

    private static final long serialVersionUID = 1L;

    private int planID;

    private int participantID;

    private ParticipantAuthorizationType participantAuthorizationType;

    private int isDelete = 0;

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Participants() {
    }

    public Participants(int planID, int participantID, ParticipantAuthorizationType participantAuthorizationType) {
        this.planID = planID;
        this.participantID = participantID;
        this.participantAuthorizationType = participantAuthorizationType;
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

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    public ParticipantAuthorizationType getParticipantAuthorizationType() {
        return participantAuthorizationType;
    }

    public void setParticipantAuthorizationType(ParticipantAuthorizationType participantAuthorizationType) {
        this.participantAuthorizationType = participantAuthorizationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return getPlanID() == that.getPlanID() &&
                getParticipantID() == that.getParticipantID() &&
                getParticipantAuthorizationType() == that.getParticipantAuthorizationType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlanID(), getParticipantID(), getParticipantAuthorizationType());
    }

    @Override
    public String toString() {
        return "Participants{" +
                "planID=" + planID +
                ", participantID=" + participantID +
                ", participantAuthorizationType=" + participantAuthorizationType +
                '}';
    }
}
