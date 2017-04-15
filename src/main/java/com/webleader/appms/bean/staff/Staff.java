package com.webleader.appms.bean.staff;

import java.sql.Date;

/**
 * @className Staff
 * @description 员工基本信息表
 * @author ding
 * @date 2017年3月31日 下午3:50:06
 * @version 1.0.0
 */
public class Staff {
	private String staffId;// 员工ID

	private String staffName;// 员工姓名

	private String staffAbbr;//

	private Date staffBirthday;// 出生日期

	private String staffGender;// 性别

	private String staffPicPath;// 员工头像

	private String staffIdCard;// 员工ID卡

	private String staffNativePlace;// 籍贯

	private String staffTelephone;// 联系电话

	private Date staffWorkDate;// 参见工作时间

	private String unitId;// 部门ID

	private String jobId;// 工种ID

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId == null ? null : staffId.trim();
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName == null ? null : staffName.trim();
	}

	public String getStaffAbbr() {
		return staffAbbr;
	}

	public void setStaffAbbr(String staffAbbr) {
		this.staffAbbr = staffAbbr == null ? null : staffAbbr.trim();
	}

	public Date getStaffBirthday() {
		return staffBirthday;
	}

	public void setStaffBirthday(Date staffBirthday) {
		this.staffBirthday = staffBirthday;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender == null ? null : staffGender.trim();
	}

	public String getStaffPicPath() {
		return staffPicPath;
	}

	public void setStaffPicPath(String staffPicPath) {
		this.staffPicPath = staffPicPath == null ? null : staffPicPath.trim();
	}

	public String getStaffIdCard() {
		return staffIdCard;
	}

	public void setStaffIdCard(String staffIdCard) {
		this.staffIdCard = staffIdCard == null ? null : staffIdCard.trim();
	}

	public String getStaffNativePlace() {
		return staffNativePlace;
	}

	public void setStaffNativePlace(String staffNativePlace) {
		this.staffNativePlace = staffNativePlace == null ? null : staffNativePlace.trim();
	}

	public String getStaffTelephone() {
		return staffTelephone;
	}

	public void setStaffTelephone(String staffTelephone) {
		this.staffTelephone = staffTelephone == null ? null : staffTelephone.trim();
	}

	public Date getStaffWorkDate() {
		return staffWorkDate;
	}

	public void setStaffWorkDate(Date staffWorkDate) {
		this.staffWorkDate = staffWorkDate;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId == null ? null : unitId.trim();
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId == null ? null : jobId.trim();
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffAbbr=" + staffAbbr
				+ ", staffBirthday=" + staffBirthday + ", staffGender=" + staffGender + ", staffPicPath=" + staffPicPath
				+ ", staffIdCard=" + staffIdCard + ", staffNativePlace=" + staffNativePlace + ", staffTelephone="
				+ staffTelephone + ", staffWorkDate=" + staffWorkDate + ", unitId=" + unitId + ", jobId=" + jobId + "]";
	}

}