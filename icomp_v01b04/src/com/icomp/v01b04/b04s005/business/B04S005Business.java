package com.icomp.v01b04.b04s005.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;

import java.util.List;
import java.util.Map;

/**
 * 车间工作量汇总BUSINESS接口
 * 
 * @ClassName: B01S002Business
 * @author Taoyy
 * @date 2014-8-20 下午02:01:40
 */
public interface B04S005Business {
	/**
	 * 车间工作量汇总列表
	 * 
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return Map<String,Object>
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue,int checkType) throws BusinessException;
	/**
	 *  取得系统区分列表
	 * @title getComList 
	 * @param worksummary
	 * @param langValue
	 * @return
	 * List<Comlist>
	 */

	public List<Comlist> getComList(String worksummary,String langCode, String langValue) throws BusinessException;
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
	 * 取得页面下拉列表内容
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;

	String getNumber()throws BusinessException;
}
