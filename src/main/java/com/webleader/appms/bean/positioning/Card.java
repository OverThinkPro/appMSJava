package com.webleader.appms.bean.positioning;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @className Card
 * @description 人员佩戴卡信息
 * @author ding
 * @date 2017年3月31日 下午3:01:47
 * @version 1.0.0
 */
/**
 * @className Card
 * @description 修改字段staffName的类型Long为String
 * @author HaoShaSha
 * @date 2017年4月15日 下午10:47:47
 * @version 1.0.0
 */
public class Card {
	private String cardId;// 定位卡ID

	private String cardStatus;// 定位卡状态

	private String opName;// 发卡人员

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date opTime;// 发卡时间

	private Double batteryV;// 定位卡电量

	private String staffName;// 员工姓名

	private String staffId;// 员工ID
	
	private String unitName; //部门名称

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

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId == null ? null : staffId.trim();
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardStatus=" + cardStatus + ", opName=" + opName + ", opTime=" + opTime
				+ ", batteryV=" + batteryV + ", staffName=" + staffName + ", staffId=" + staffId + ", unitName="
				+ unitName + "]";
	}

}