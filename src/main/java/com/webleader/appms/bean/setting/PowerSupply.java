package com.webleader.appms.bean.setting;

import java.util.Date;

/**
 * @className PowerSupply
 * @description 分站供电方式历史信息
 * @author ding
 * @date 2017年3月31日 下午3:31:55
 * @version 1.0.0
 */
public class PowerSupply {
	private String powerSupplyId;// 供电ID

	private String powerSupplyMode;// 供电方式

	private Date powerSupplyStart;// 供电开始时间

	private String readerId;// 分站ID

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

	@Override
	public String toString() {
		return "PowerSupply [powerSupplyId=" + powerSupplyId + ", powerSupplyMode=" + powerSupplyMode
				+ ", powerSupplyStart=" + powerSupplyStart + ", readerId=" + readerId + "]";
	}

}