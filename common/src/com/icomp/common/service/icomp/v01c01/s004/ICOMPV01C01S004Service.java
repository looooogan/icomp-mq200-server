package com.icomp.common.service.icomp.v01c01.s004;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Replacement;
import com.icomp.entity.base.Vgetshelfinformation;
import com.icomp.entity.base.Vreplacement;

public interface ICOMPV01C01S004Service {
	
	/**
	 * 取得补领出库申请列表
	 * 
	 * @title getReplacementList
	 * @param entity
	 * @return List<ReplacementInfo>
	 */
	public Map<String, Object> getReplacementList() throws Exception;
	
	/**
	 * 取得补领出库申请单信息
	 * 
	 * @title getReplacementApply
	 * @param entity
	 * @return List<ReplacementInfo>
	 */
	public Map<String, Object> getReplacementApply(Map<String, Object> map) throws Exception;
	
	/**
	 * 提交补领出库的刀具信息
	 * 
	 * @title saveRedemptionapplyInfo
	 * @param map
	 * @return int
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public Map<String, Object> saveReplacementapplyInfo(List<Map<String, Object>> toolList) throws Exception;

	/**
	 * 获取生成申领单号
	 * @title getApplyNumber
	 * @return
	 * @throws Exception
	 * String
	 */
	public String getApplyNumber(String customerID) throws Exception;

	/**
	 * 取得待申领刀具信息
	 * @param map
	 * @return
	 */

	public List<Vgetshelfinformation> getApplyToolInfo(Map<String, Object> map);

	/**
	 * 扫描rfid，取得当前rfid对应的信息
	 * @title getRfidToolInfo
	 * @param entity
	 * @return
	 * @throws Exception
	 * Vreplacement
	 */
	public List<Vreplacement> getRfidToolInfo(Vreplacement entity) throws Exception;

	/**
	 * 备货刀具出库
	 * @title saveOutputStockingTool
	 * @param entity
	 * @return
	 * @throws Exception
	 * Vreplacement
	 */
	public List<Vreplacement> saveOutputStockingTool(Vreplacement entity) throws Exception;

	/**
	 * 申领结束，记录申请单
	 * @title saveApplyInfo
	 * @param map
	 * @return
	 * @throws Exception
	 * Vreplacement
	 */
	public int saveApplyInfo(Map<String, Object> map) throws Exception;

	Replacement searchUserExitq(Replacement entity)throws Exception;
	
	/**
	 * 根据补领获取材料号
	 */
	List<Replacement> getToolCode(Replacement entity)throws Exception; 
}
