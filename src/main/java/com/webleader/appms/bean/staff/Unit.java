package com.webleader.appms.bean.staff;

import java.sql.Date;
import java.util.List;

/**
 * @className Unit
 * @description 单位信息表
 * @author ding
 * @date 2017年3月31日 下午3:54:48
 * @version 1.0.0
 */
public class Unit {
	private String unitId;// 部门ID

	private String upUnitId;// 上级部门ID

	private String upUnitName;// 上级部门名称

	private String unitName;// 部门名称

	private String telephone;// 电话

	private String contactPerson;// 联系人

	private String header;// 领导

	private Date createDate;// 创建时间

	private String description;// 描述

	private String remark;// 备注

	private List<Unit> unitList;

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId == null ? null : unitId.trim();
	}

	public String getUpUnitId() {
		return upUnitId;
	}

	public void setUpUnitId(String upUnitId) {
		this.upUnitId = upUnitId == null ? null : upUnitId.trim();
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName == null ? null : unitName.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson == null ? null : contactPerson
				.trim();
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header == null ? null : header.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public List<Unit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}

	public String getUpUnitName() {
		return upUnitName;
	}

	public void setUpUnitName(String upUnitName) {
		this.upUnitName = upUnitName;
	}

	@Override
	public String toString() {
		return "Unit [unitId=" + unitId + ", upUnitId=" + upUnitId
				+ ", upUnitName=" + upUnitName + ", unitName=" + unitName
				+ ", telephone=" + telephone + ", contactPerson="
				+ contactPerson + ", header=" + header + ", createDate="
				+ createDate + ", description=" + description + ", remark="
				+ remark + ", unitList=" + unitList + "]";
	}
	
}