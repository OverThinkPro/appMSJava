package com.webleader.appms.bean.setting;

public class Coalmine {
	private String coalmineId;

	private String coalmineName;

	private String coalmineAbbr;

	private Double coalmineOutput;

	private Integer coalmineNum;

	private String coalmineType;

	private String gasGrade;

	private String remark;

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