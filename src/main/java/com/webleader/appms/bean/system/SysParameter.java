package com.webleader.appms.bean.system;

import java.util.Date;

/**
 * @className SysParameter
 * @description 系统参数
 * @author ding
 * @date 2017年3月31日 下午4:05:08
 * @version 1.0.0
 */
public class SysParameter {
	private String id;//

	private Date dataBackPar;//

	private String sysInitUsername;// 系统初始用户名

	private String sysInitPwd;// 系统初始密码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Date getDataBackPar() {
		return dataBackPar;
	}

	public void setDataBackPar(Date dataBackPar) {
		this.dataBackPar = dataBackPar;
	}

	public String getSysInitUsername() {
		return sysInitUsername;
	}

	public void setSysInitUsername(String sysInitUsername) {
		this.sysInitUsername = sysInitUsername == null ? null : sysInitUsername.trim();
	}

	public String getSysInitPwd() {
		return sysInitPwd;
	}

	public void setSysInitPwd(String sysInitPwd) {
		this.sysInitPwd = sysInitPwd == null ? null : sysInitPwd.trim();
	}

	@Override
	public String toString() {
		return "SysParameter [id=" + id + ", dataBackPar=" + dataBackPar + ", sysInitUsername=" + sysInitUsername
				+ ", sysInitPwd=" + sysInitPwd + "]";
	}

}