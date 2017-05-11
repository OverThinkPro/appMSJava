package com.webleader.appms.bean.system;


/**
 * @className Dictionary
 * @description 系统字典
 * @author ding
 * @date 2017年3月31日 下午3:58:28
 * @version 1.0.0
 */
public class Dictionary {
	private String dictionaryId;// 字典ID

	private String dictionaryName;// 字典名称

	private String description;// 描述

	private String upDictionaryId;// 上级字典ID
	
	private String upDictionaryName;// 上级字典名称

	private String inUse;// 是否使用

	private String englishName;// 英文名称

	private String dataType;// 数据类型

	private String remark;// 备注
	
	private String baseDic; //表示字典是否是基础数据字典

	//private List<Dictionary> subDics;

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

	public String getUpDictionaryName() {
		return upDictionaryName;
	}

	public void setUpDictionaryName(String upDictionaryName) {
		this.upDictionaryName = upDictionaryName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getBaseDic() {
		return baseDic;
	}

	public void setBaseDic(String baseDic) {
		this.baseDic = baseDic;
	}

	@Override
	public String toString() {
		return "Dictionary [dictionaryId=" + dictionaryId + ", dictionaryName="
				+ dictionaryName + ", description=" + description
				+ ", upDictionaryId=" + upDictionaryId + ", upDictionaryName="
				+ upDictionaryName + ", inUse=" + inUse + ", englishName="
				+ englishName + ", dataType=" + dataType + ", remark=" + remark
				+ ", baseDic=" + baseDic + "]";
	}
	
}