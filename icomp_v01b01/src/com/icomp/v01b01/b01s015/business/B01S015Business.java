package com.icomp.v01b01.b01s015.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;

import java.util.List;
import java.util.Map;

/**
 * 库存盘点查询BUsiness接口
 * @ClassName: B01S014Business 
 * @author Licc
 * @date 2014-11-12 下午04:09:08
 */
public interface B01S015Business {
	/**
	 * 库存盘点查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;

	/**
	 * 取得系统区分列表
	 * 
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,
                                    String langValue) throws BusinessException;
	
	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,
                                             String departmentID, String langCode, String langValue) throws BusinessException;

	/**
	 * 取得页面下拉列表内容
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;
	
}
