package com.webleader.appms.bean.setting;

import java.util.Date;

public class PowerSupply {
    private String powerSupplyId;

    private String powerSupplyMode;

    private Date powerSupplyStart;

    private String readerId;

    public String getPowerSupplyId() {
        return powerSupplyId;
    }

    public void setPowerSupplyId(String powerSupplyId) {
        this.powerSupplyId = powerSupplyId == null ? null : powerSupplyId.trim();
    }

    public String getPowerSupplyMode() {
        return powerSupplyMode;
    }

    public void setPowerSupplyMode(String powerSupplyMode) {
        this.powerSupplyMode = powerSupplyMode == null ? null : powerSupplyMode.trim();
    }

    public Date getPowerSupplyStart() {
        return powerSupplyStart;
    }

    public void setPowerSupplyStart(Date powerSupplyStart) {
        this.powerSupplyStart = powerSupplyStart;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId == null ? null : readerId.trim();
    }
}