package com.webleader.appms.bean.positioning;

public class Region {
    private String regionId;

    private String regionName;

    private String regionType;

    private Integer regionMaxPeople;

    private String description;

    private Object geoPolygon;

    private String remark;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType == null ? null : regionType.trim();
    }

    public Integer getRegionMaxPeople() {
        return regionMaxPeople;
    }

    public void setRegionMaxPeople(Integer regionMaxPeople) {
        this.regionMaxPeople = regionMaxPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Object getGeoPolygon() {
        return geoPolygon;
    }

    public void setGeoPolygon(Object geoPolygon) {
        this.geoPolygon = geoPolygon;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}