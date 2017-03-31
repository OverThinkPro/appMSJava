package com.webleader.appms.bean.alarm;

/**
 * @className AlarmSetting
 * @description 报警声音设置表
 * @author ding
 * @date 2017年3月31日 下午2:46:36
 * @version 1.0.0
 */
public class AlarmSetting {
	private String alarmTypeId;// 报警类型ID

	private String alarmName;// 报警名称

	private Boolean alarmInUse;// 报警是否被启用

	private String alarmFile;// 报警声音的文件

	private String remark;// 备注

	public String getAlarmTypeId() {
		return alarmTypeId;
	}

	public void setAlarmTypeId(String alarmTypeId) {
		this.alarmTypeId = alarmTypeId == null ? null : alarmTypeId.trim();
	}

	public String getAlarmName() {
		return alarmName;
	}

	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName == null ? null : alarmName.trim();
	}

	public Boolean getAlarmInUse() {
		return alarmInUse;
	}

	public void setAlarmInUse(Boolean alarmInUse) {
		this.alarmInUse = alarmInUse;
	}

	public String getAlarmFile() {
		return alarmFile;
	}

	public void setAlarmFile(String alarmFile) {
		this.alarmFile = alarmFile == null ? null : alarmFile.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "AlarmSetting [alarmTypeId=" + alarmTypeId + ", alarmName=" + alarmName + ", alarmInUse=" + alarmInUse
				+ ", alarmFile=" + alarmFile + ", remark=" + remark + "]";
	}

}