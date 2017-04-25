package com.webleader.appms.db.service.impl.positioning;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.positioning.PastDoc;
import com.webleader.appms.db.mapper.positioning.PastDocMapper;
import com.webleader.appms.db.service.positioning.PastDocService;

/**
 * @className PastDocServiceImpl
 * @description 历史轨迹查询服务层
 * @author ding
 * @date 2017年4月25日 上午10:37:58
 * @version 1.0.0
 */
@Service("pastDocService")
public class PastDocServiceImpl implements PastDocService{
	
	@Autowired
	private PastDocMapper pastDocMapper;
	
	/** 
	 * @description 组合条件分页查询历史轨迹信息(部门编号，员工姓名，定位卡号，开始时间，结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(unitId,staffName,cardId,startTime,endTime,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<PastDoc> listPastDocByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return pastDocMapper.listPastDocByPageCondition(pageCondition);
	}

	/** 
	 * @description 统计符合条件的历史轨迹信息数量(部门编号，员工姓名，定位卡号，开始时间，结束时间)
	 * @param condition(unitId,staffName,cardId,startTime,endTime)
	 * @return
	 * @throws SQLException 
	 */
	public int countPastDocByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)) {
			return 0;
		}
		return pastDocMapper.countPastDocByConditon(condition);
	}
	
	/** 
	 * @description 组合条件查询地图信息(部门编号，员工姓名，定位卡号，开始时间，结束时间， 起始记录数，每页的记录数)
	 * @param pageCondition(geo_point, staff_name, unit_id, staff_info_his_id, staff_id)
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<Object, Object>> listMapPoint(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return pastDocMapper.listMapPoint(pageCondition);
	}
}
