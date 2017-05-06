package com.webleader.appms.bean.system;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @className TBUrl
 * @description 模块菜单表
 * @author ding
 * @date 2017年3月31日 下午4:02:25
 * @version 1.0.0
 */
public class TBUrl {
	private String moduleId;// 模块ID

	private String moduleName;// 模块名称

	private String upModuleId;// 上级模块编号
	
	private String upModuleName; //上级模块名称

	private String inUse;// 是否被启用

	private String description;// 描述

	private String moduleUrl;// 模块url
	
	private List<TBUrl> children;

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId == null ? null : moduleId.trim();
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName == null ? null : moduleName.trim();
	}

	public String getUpModuleId() {
		return upModuleId;
	}

	public void setUpModuleId(String upModuleId) {
		this.upModuleId = upModuleId == null ? null : upModuleId.trim();
	}

	public String getInUse() {
		return inUse;
	}

	public void setInUse(String inUse) {
		this.inUse = inUse == null ? null : inUse.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getModuleUrl() {
		return moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl == null ? null : moduleUrl.trim();
	}
	@JsonIgnore
	public List<TBUrl> getChildren() {
		return children;
	}

	public void setChildren(List<TBUrl> children) {
		this.children = children;
	}

	public String getUpModuleName() {
		return upModuleName;
	}

	public void setUpModuleName(String upModuleName) {
		this.upModuleName = upModuleName;
	}

	@Override
	public String toString() {
		return "TBUrl [moduleId=" + moduleId + ", moduleName=" + moduleName
				+ ", upModuleId=" + upModuleId + ", upModuleName="
				+ upModuleName + ", inUse=" + inUse + ", description="
				+ description + ", moduleUrl=" + moduleUrl + "]";
	}

	
}