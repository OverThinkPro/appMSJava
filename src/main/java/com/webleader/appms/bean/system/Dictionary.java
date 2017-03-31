package com.webleader.appms.bean.system;

public class Dictionary {
    private String dictionaryId;

    private String dictionaryName;

    private String description;

    private String upDictionaryId;

    private String inUse;

    private String englistName;

    private String dataType;

    private String remark;

    public String getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(String dictionaryId) {
        this.dictionaryId = dictionaryId == null ? null : dictionaryId.trim();
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName == null ? null : dictionaryName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUpDictionaryId() {
        return upDictionaryId;
    }

    public void setUpDictionaryId(String upDictionaryId) {
        this.upDictionaryId = upDictionaryId == null ? null : upDictionaryId.trim();
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse == null ? null : inUse.trim();
    }

    public String getEnglistName() {
        return englistName;
    }

    public void setEnglistName(String englistName) {
        this.englistName = englistName == null ? null : englistName.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}