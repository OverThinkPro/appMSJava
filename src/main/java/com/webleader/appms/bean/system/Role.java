package com.webleader.appms.bean.system;

/**
 * @className Role
 * @description 角色表
 * @author ding
 * @date 2017年3月31日 下午4:07:02
 * @version 1.0.0
 */
public class Role {
	private String roleId;// 角色ID

	private String roleName;// 角色名

	private String description;// 描述

	private String inUse;// 是否启用

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getInUse() {
		return inUse;
	}

	public void setInUse(String inUse) {
		this.inUse = inUse == null ? null : inUse.trim();
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description + ", inUse=" + inUse
				+ "]";
	}

}