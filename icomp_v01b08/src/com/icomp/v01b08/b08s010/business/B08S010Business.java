package com.icomp.v01b08.b08s010.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Vproductiondesign;

public interface B08S010Business {

	/**
	 * 取得生产计划列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Map<String, Object> param,
			String customerID, String langCode, String langValue);

//	/**
//	 * 新建生产计划信息
//	 * 
//	 * @param param
//	 *            页面检索条件
//	 * @param langValue
//	 *            语言编码
//	 * @param customerID
//	 *            用户ID
//	 * @param lang
//	 *            语言值
//	 * @return
//	 * @throws BusinessException
//	 */
//	public Map<String, Object> handSetAdd(Map<String, Object> param,
//			String langValue, String customerID, String langCode)
//			throws BusinessException;
//
//	/**
//	 * 取得待处理手持机信息
//	 * 
//	 * @param param
//	 *            页面检索条件
//	 * @param langValue
//	 *            语言编码
//	 * @return
//	 * @throws BusinessException
//	 */
//	public Map<String, Object> handSetInfo(Map<String, Object> param,
//			String langCode, String langValue) throws BusinessException;
//
//	/**
//	 * 编辑手持机信息
//	 * 
//	 * @param param
//	 *            页面检索条件
//	 * @param langValue
//	 *            语言编码
//	 * @param customerID
//	 *            用户ID
//	 * @param lang
//	 *            语言值
//	 * @return
//	 * @throws BusinessException
//	 */
//	public Map<String, Object> handSetEdit(Map<String, Object> param,
//			String langValue, String customerID, String langCode)
//			throws BusinessException;
	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, 
			String departmentID,String langCode , String langValue) throws BusinessException;
	/**
	 * 新建生产计划
	 * @return
	 */
	public Map<String, Object> productionDesignAdd(Map<String, Object> param,
			String langCode, String customerID, String langValue);
	/**
	 * 保存生产计划
	 * @return
	 */
	public Map<String, Object> productionDesignEdit(Map<String, Object> param,
			String langCode, String customerID, String langValue);
	/**
	 * 获取生产计划信息
	 * @return
	 */
	public Map<String, Object> productionDesignInfo(Map<String, Object> param,
			String langCode,String customerID, String langValue);

	/**
	 * 取得零部件列表
	 * @return
	 */
	
	public List<Assemblyline> getPartsList(String dELFLAG_0, String langCode,
			String langValue);
	
	/**
	 * 取得年份列表
	 * @return
	 */

	public List<Vproductiondesign> getYearList(String dELFLAG_0, String langCode,
			String langValue);


	
	
}
