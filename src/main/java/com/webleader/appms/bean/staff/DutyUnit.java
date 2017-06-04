package com.webleader.appms.bean.staff;

/**
 * @className DutyUnit
 * @description 每天，某个班次选择的班组
 * @author ding
 * @date 2017年5月10日 上午9:55:52
 * @version 1.0.0
 */
public class DutyUnit {
	private String uId; //逻辑主键
	
	private String dId; //与dutyDate的外键关联
	
	private String unitId; //部门ID

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getdId() {
		return dId;
	}

	public void setdId(String dId) {
		this.dId = dId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	@Override
	public String toString() {
		return "DutyUnit [uId=" + uId + ", dId=" + dId + ", unitId=" + unitId + "]";
	}

}
