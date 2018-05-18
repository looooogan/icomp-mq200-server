package com.icomp.v01b06.b06s002.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Parts;

import java.util.List;
import java.util.Map;

/**
 * 加工异常分析BUSINESS接口
 *
 * @ClassName: B06S002Business
 * @author Taoyy
 * @date 2014-8-22 上午09:29:26
 */

public interface B06S002Business {
	/**
	 * 加工异常分析列表
	 *
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue,int checkType) throws BusinessException;
	/**
	 * 加工异常分析统计数量
	 * @title getStatisticalCount
	 * @param param
	 * @param langValue
	 * @return
	 * String
	 */
	public String getStatisticalCount(Map<String, Object> param, String langCode, String langValue);

	/**
	 * 根据生产线Id获取零部件集合
	 * @title getPartsListById
	 * @param id
	 * @return
	 * List<Parts>
	 */
	public List<Parts> getPartsListById(String id);

	/**
	 * 取得页面grid显示项目列表
	 *
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,
											 String customerID,String langCode , String langValue) throws BusinessException;

	Map<String,Object> getPPList() throws BusinessException;

	String getNumber()throws BusinessException;
}
