package com.webleader.appms.bean.positioning;

/**
 * @className Region
 * @description 井下区域定义
 * @author ding
 * @date 2017年3月31日 下午3:14:53
 * @version 1.0.0
 */
public class Region {
	private String regionId;// 区域ID

	private String regionName;// 区域名称

	private String regionType;// 区域类型

	private Integer regionMaxPeople;// 区域限制人数（-1表示无限制）

	private String description;// 区域介绍

	private Object geoPolygon;// 区域定义，几何坐标

	private String remark;// 备注

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

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + ", regionType=" + regionType
				+ ", regionMaxPeople=" + regionMaxPeople + ", description=" + description + ", geoPolygon=" + geoPolygon
				+ ", remark=" + remark + "]";
	}
}