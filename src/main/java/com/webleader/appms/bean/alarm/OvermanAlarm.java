package com.webleader.appms.bean.alarm;


/**
 * @className OvermanAlarm
 * @description 超员报警表
 * @author ding
 * @date 2017年3月31日 下午2:42:51
 * @version 1.0.0
 */
/**
 * @className OvermanAlarm
 * @description 修改他为Alarm的子类，并删除了冗余的字段
 * @author HaoShaSha
 * @date 2017年4月12日 下午6:30:38
 * @version 1.0.0
 */
public class OvermanAlarm extends Alarm{
	
	private String overmanId;// 超员ID

	//private String alarmId;// 警报ID

	private String regionName;// 区域名称

	private Integer reqNumber;// 应到人数

	private Integer realNumber;// 实到人数

	//private Date alarmStartTime;// 报警开始时间

	//private String alarmState;// 报警状态：0：新报警；1：已解除

	//private Date alarmEndTime;// 报警结束时间，当报警解除后，需要修改alarmState：1以及alarmEndTime

	private String regionId;// 区域ID

	public String getOvermanId() {
		return overmanId;
	}

	public void setOvermanId(String overmanId) {
		this.overmanId = overmanId == null ? null : overmanId.trim();
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName == null ? null : regionName.trim();
	}

	public Integer getReqNumber() {
		return reqNumber;
	}

	public void setReqNumber(Integer reqNumber) {
		this.reqNumber = reqNumber;
	}

	public Integer getRealNumber() {
		return realNumber;
	}

	public void setRealNumber(Integer realNumber) {
		this.realNumber = realNumber;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId == null ? null : regionId.trim();
	}

	@Override
	public String toString() {
		return "OvermanAlarm [overmanId=" + overmanId + ", regionName="
				+ regionName + ", reqNumber=" + reqNumber + ", realNumber="
				+ realNumber + ", regionId=" + regionId +"alarmId=" + getAlarmId() + ", alarmStartTime="
				+ getAlarmStartTime() + ", alarmEndTime=" + getAlarmEndTime()
				+ ", alarmInhandle=" + getAlarmInhandle() + ", alarmTypeId="
				+ getAlarmTypeId() + ", alarmTypeName=" + getAlarmTypeName()+  "]";
	}

}