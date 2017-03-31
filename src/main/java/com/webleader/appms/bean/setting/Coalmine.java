package com.webleader.appms.bean.setting;

/**
 * @className Coalmine
 * @description 煤矿基本信息表
 * @author ding
 * @date 2017年3月31日 下午3:44:35
 * @version 1.0.0
 */
public class Coalmine {
	private String coalmineId;// 煤矿ID

	private String coalmineName;// 煤矿名

	private String coalmineAbbr;// 煤矿简称

	private Double coalmineOutput;// 煤矿年产量（单位：万吨）

	private Integer coalmineNum;// 核定井下人数

	private String coalmineType;// 矿井类型

	private String gasGrade;// 瓦斯级别

	private String remark;// 备注

	public String getCoalmineId() {
		return coalmineId;
	}

	public void setCoalmineId(String coalmineId) {
		this.coalmineId = coalmineId == null ? null : coalmineId.trim();
	}

	public String getCoalmineName() {
		return coalmineName;
	}

	public void setCoalmineName(String coalmineName) {
		this.coalmineName = coalmineName == null ? null : coalmineName.trim();
	}

	public String getCoalmineAbbr() {
		return coalmineAbbr;
	}

	public void setCoalmineAbbr(String coalmineAbbr) {
		this.coalmineAbbr = coalmineAbbr == null ? null : coalmineAbbr.trim();
	}

	public Double getCoalmineOutput() {
		return coalmineOutput;
	}

	public void setCoalmineOutput(Double coalmineOutput) {
		this.coalmineOutput = coalmineOutput;
	}

	public Integer getCoalmineNum() {
		return coalmineNum;
	}

	public void setCoalmineNum(Integer coalmineNum) {
		this.coalmineNum = coalmineNum;
	}

	public String getCoalmineType() {
		return coalmineType;
	}

	public void setCoalmineType(String coalmineType) {
		this.coalmineType = coalmineType == null ? null : coalmineType.trim();
	}

	public String getGasGrade() {
		return gasGrade;
	}

	public void setGasGrade(String gasGrade) {
		this.gasGrade = gasGrade == null ? null : gasGrade.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "Coalmine [coalmineId=" + coalmineId + ", coalmineName=" + coalmineName + ", coalmineAbbr="
				+ coalmineAbbr + ", coalmineOutput=" + coalmineOutput + ", coalmineNum=" + coalmineNum
				+ ", coalmineType=" + coalmineType + ", gasGrade=" + gasGrade + ", remark=" + remark + "]";
	}

}