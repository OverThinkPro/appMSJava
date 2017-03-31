package com.webleader.appms.bean.setting;

/**
 * @className PeriodSetting
 * @description 数据采集周期参数表，可以存储数采周期、前台刷新周期等
 * @author ding
 * @date 2017年3月31日 下午3:34:02
 * @version 1.0.0
 */
public class PeriodSetting {
	private String periodId;// 周期ID

	private String periodName;// 周期名

	private String description;// 描述

	private Integer periodNum;//

	private String remark;// 备注

	public String getPeriodId() {
		return periodId;
	}

	public void setPeriodId(String periodId) {
		this.periodId = periodId == null ? null : periodId.trim();
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName == null ? null : periodName.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "PeriodSetting [periodId=" + periodId + ", periodName=" + periodName + ", description=" + description
				+ ", periodNum=" + periodNum + ", remark=" + remark + "]";
	}

}