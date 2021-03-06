package com.webleader.appms.common;

import org.springframework.stereotype.Component;

/**
 * @className ModelPageConstants
 * @description 模态框的分页
 * @author ding
 * @date 2017年4月21日 下午3:38:07
 * @version 1.0.0
 */
@Component
public final class ModalPageConstants {
	private int MASSAGE_PAGE_SIZE = 6;//每页条数
	
	/* 得到总页数 */
	public  int getPages(int nums) {
		return (nums - 1) / MASSAGE_PAGE_SIZE + 1;
	}
	/* 得到起始记录数 */
	public int getRecordNums(int page){
		return (page - 1) * MASSAGE_PAGE_SIZE;
	}

	public void setPageSize(int pageSize) {
		MASSAGE_PAGE_SIZE = pageSize;
	}
	
	public int getPageSize() {
		return MASSAGE_PAGE_SIZE;
	}
}
