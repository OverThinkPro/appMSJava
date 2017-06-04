package com.webleader.appms.bean.staff;

import java.sql.Date;

/**
 * @className DutyDate
 * @description 一个班次，每一天的排班
 * @author ding
 * @date 2017年5月10日 上午9:50:24
 * @version 1.0.0
 */
public class DutyDate {
	private String dId; //逻辑主键
	
	private String dutyId; //班次ID
	
	private Date workDate; //工作日期
	
	private String chargePerson; //负责人

	public String getdId() {
		return dId;
	}

	public void setdId(String dId) {
		this.dId = dId;
	}

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getChargePerson() {
		return chargePerson;
	}

	public void setChargePerson(String chargePerson) {
		this.chargePerson = chargePerson;
	}

	@Override
	public String toString() {
		return "DutyDate [dId=" + dId + ", dutyId=" + dutyId + ", workDate=" + workDate + ", chargePerson="
				+ chargePerson + "]";
	}
	
}
