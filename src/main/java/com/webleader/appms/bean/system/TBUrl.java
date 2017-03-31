package com.webleader.appms.bean.system;

import java.util.List;

public class TBUrl {
    
	private String moduleId;

    private String moduleName;

    private String upModuleId;

    private String inUse;

    private String description;

    private String moduleUrl;
    
    private List<TBUrl> subUrls;

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

	public List<TBUrl> getSubUrls() {
		return subUrls;
	}

	public void setSubUrls(List<TBUrl> subUrls) {
		this.subUrls = subUrls;
	}

	@Override
	public String toString() {
		return "TBUrl [moduleId=" + moduleId + ", moduleName=" + moduleName
				+ ", upModuleId=" + upModuleId + ", inUse=" + inUse
				+ ", description=" + description + ", moduleUrl=" + moduleUrl
				+ ", subUrls=" + subUrls + "]";
	}
	
	
}