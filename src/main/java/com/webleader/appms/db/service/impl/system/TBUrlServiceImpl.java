package com.webleader.appms.db.service.impl.system;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webleader.appms.bean.system.TBUrl;
import com.webleader.appms.db.mapper.system.TBUrlMapper;
import com.webleader.appms.db.service.system.TBUrlService;


/**
 * @className TBUrlServiceImpl
 * @description 菜单服务层
 * @author ding
 * @date 2017年4月24日 下午9:12:38
 * @version 1.0.0
 */
@Service("tbUrlService")
public class TBUrlServiceImpl implements TBUrlService {

	@Autowired
	private TBUrlMapper tbUrlMapper;
	
	/** 
	 * @description 组合条件分页查询菜单信息(菜单编号，菜单名称，上级菜单编号，是否启用， 起始记录数，每页的记录数)
	 * @param pageCondition(moduleId,moduleName,upModuleId,inUse,pageSize,pageBegin)
	 * @return
	 * @throws SQLException 
	 */
	public List<TBUrl> getUrlByPageCondition(Map<Object,Object> pageCondition) throws SQLException{
		if (Objects.isNull(pageCondition)){
			return null;
		}
		return tbUrlMapper.getUrlByPageCondition(pageCondition);
	}
	
	/** 
	 * @description 统计符合条件的菜单数量(菜单编号，菜单名称，上级菜单编号，是否启用)
	 * @param condition(moduleId,moduleName,upModuleId,inUse)
	 * @return
	 * @throws SQLException 
	 */
	public int getCountByConditon(Map<Object,Object> condition) throws SQLException{
		if (Objects.isNull(condition)){
			return 0;
		}
		return tbUrlMapper.getCountByConditon(condition);
	}
	
	/** 
	 * @description 通过userID，查询该用户，的菜单列表
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	public List<TBUrl> getUserUrl(String userId) throws SQLException {
		if (Objects.isNull(userId)) {
			return null;
		}
		return tbUrlMapper.getUserUrl(userId);
	}
	
	/** 
	 * @description 通过userId 只查询用户的url
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	public List<String> getUserURLOnly(String userId) throws SQLException {
		if (Objects.isNull(userId)) {
			return null;
		}
		return tbUrlMapper.getUserURLOnly(userId);
	}
	
	/** 
	 * @description 通过userID，查询该用户是否需要直接访问首页
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	public int isContainsHomePage(String userId) throws SQLException {
		if (Objects.isNull(userId)) {
			return 0;
		}
		return (tbUrlMapper.isContainsHomePage(userId) == null) ? 0 : 1; 
	}
	
	/** 
	 * @description 根据上级菜单下的子菜单的最大编号
	 * @param upModuleId
	 * @return
	 * @throws SQLException 
	 */
	public String getMaxTBUrlId(String upModuleId) throws SQLException{

		if (Objects.isNull(upModuleId)) {
			return "1";
		}
		String maxId = tbUrlMapper.getMaxUrlId(upModuleId);
		if (Objects.isNull(maxId)){
			return upModuleId + "01";
		} else {
			return Integer.valueOf(maxId) + 1 + "";
		}
	}
	
	/** 
	 * @description 查询菜单树
	 * @return upModuleId
	 * @throws SQLException 
	 */
	public List<TBUrl> getTBUrlTree(String upModuleId) throws SQLException{
		return tbUrlMapper.getUrlTree(upModuleId);
	}
	
	/** 
	 * @description 添加菜单
	 * @param tbUrl
	 * @return
	 * @throws SQLException 
	 */
	public int insert(TBUrl tbUrl) throws SQLException{
		if (Objects.isNull(tbUrl)) {
			return 0;
		}
		return tbUrlMapper.insert(tbUrl);
	}
	
	/** 
	 * @description 根据菜单编号删除菜单
	 * @param moduleId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByPrimaryKey(String moduleId) throws SQLException{
		if (Objects.isNull(moduleId)) {
			return 0;
		}
		return tbUrlMapper.deleteByPrimaryKey(moduleId);
	}
	
	/** 
	 * @description 根据上级菜单编号删除菜单
	 * @param upModuleId
	 * @return
	 * @throws SQLException 
	 */
	public int deleteByUpTBUrlId(String upModuleId) throws SQLException{
		if (Objects.isNull(upModuleId)) {
			return 0;
		}
		return tbUrlMapper.deleteByUpModuleId(upModuleId);
	}
	
	/** 
	 * @description 更新菜单信息
	 * @param tbUrl
	 * @return
	 * @throws SQLException 
	 */
	public int updateByPrimaryKeySelective(TBUrl tbUrl) throws SQLException{
		if (Objects.isNull(tbUrl)) {
			return 0;
		}
		return tbUrlMapper.updateByPrimaryKeySelective(tbUrl);
	}
	
	/** 
	 * @description 根据上级菜单编号修改菜单的启用和禁用 
	 * @param condition(inUse, upModuleId)
	 * @return 是否启用，上级菜单编号
	 * @throws SQLException 
	 */
	public int updateInUseByUpModuleId(Map<Object,Object> condition) throws SQLException {
		if (Objects.isNull(condition)) {
			return 0;
		}
		return tbUrlMapper.updateInUseByUpModuleId(condition);
	}
}
