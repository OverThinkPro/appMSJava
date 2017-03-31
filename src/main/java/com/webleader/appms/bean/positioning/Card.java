package com.webleader.appms.bean.positioning;

import java.util.Date;

public class Card {
    private String cardId;

    private String cardStatus;

    private String opName;

    private Date opTime;

    private Double batteryV;

    private Long staffName;

    private String staffId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus == null ? null : cardStatus.trim();
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName == null ? null : opName.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public Double getBatteryV() {
        return batteryV;
    }

    public void setBatteryV(Double batteryV) {
        this.batteryV = batteryV;
    }

    public Long getStaffName() {
        return staffName;
    }

    public void setStaffName(Long staffName) {
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }
}