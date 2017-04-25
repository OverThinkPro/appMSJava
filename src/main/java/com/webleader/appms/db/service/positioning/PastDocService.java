package com.webleader.appms.db.service.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.webleader.appms.bean.positioning.PastDoc;

/**
 * @className PastDocService
 * @description 历史轨迹查询
 * @author ding
 * @date 2017年4月25日 上午10:37:26
 * @version 1.0.0
 */
public interface PastDocService {

	/** 
	 * @description 组合条件分页查询历史轨迹信息(部门编号，员工姓名，定位卡号，开始时间，结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(unitId,staffName,cardId,startTime,endTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<PastDoc> listPastDocByPageCondition(Map<Object,Object> pageCondition) throws SQLException;

	/** 
	 * @description 统计符合条件的历史轨迹信息数量(部门编号，员工姓名，定位卡号，开始时间，结束时间)
	 * @param condition(unitId,staffName,cardId,startTime,endTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countPastDocByConditon(Map<Object,Object> condition) throws SQLException;
	
	/** 
	 * @description 组合条件查询地图信息(部门编号，员工姓名，定位卡号，开始时间，结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(geo_point, staff_name, unit_id, staff_info_his_id, staff_id)
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> listMapPoint(Map<Object,Object> pageCondition) throws SQLException;
}
