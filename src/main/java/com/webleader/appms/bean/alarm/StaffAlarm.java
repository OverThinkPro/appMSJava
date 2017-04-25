package com.webleader.appms.bean.alarm;


/**
 * @className StaffAlarm
 * @description 井下人员呼叫井上人员报警表
 * @author ding
 * @date 2017年3月31日 下午2:31:20
 * @version 1.0.0
 */

/**
 * @className StaffAlarm
 * @description 继承Alarm并删掉冗余的字段
 * @author HaoShaSha
 * @date 2017年4月12日 下午9:59:58
 * @version 1.0.0
 */
public class StaffAlarm extends Alarm{
	//private Date alarmTime;// 报警时间

	private Double readerDis;// 离分站的距离

	private String readerAntId;// 天线编号

	private String staffName;// 员工姓名

	private String unitId;// 部门ID

	private String unitName;// 部门名称

	private String readerId;// 分站ID

	//private String alarmId;// 报警ID

	private String cardId;// 定位卡ID
	
	private String readerName;

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId == null ? null : readerId.trim();
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId == null ? null : cardId.trim();
	}

	public Double getReaderDis() {
		return readerDis;
	}

	public void setReaderDis(Double readerDis) {
		this.readerDis = readerDis;
	}

	public String getReaderAntId() {
		return readerAntId;
	}

	public void setReaderAntId(String readerAntId) {
		this.readerAntId = readerAntId == null ? null : readerAntId.trim();
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName == null ? null : staffName.trim();
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId == null ? null : unitId.trim();
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName == null ? null : unitName.trim();
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	@Override
	public String toString() {
		return "StaffAlarm [readerDis=" + readerDis + ", readerAntId=" + readerAntId + ", staffName=" + staffName
				+ ", unitId=" + unitId + ", unitName=" + unitName + ", readerId=" + readerId + ", cardId=" + cardId
				+ ", readerName=" + readerName + "]";
	}

}