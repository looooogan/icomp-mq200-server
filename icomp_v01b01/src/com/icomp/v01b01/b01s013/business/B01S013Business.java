package com.icomp.v01b01.b01s013.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;

import java.util.List;
import java.util.Map;

/**
 * 库存状况查询BUsiness接口
 * @ClassName: B01S013Business 
 * @author Licc
 * @date 2014-11-10 下午04:09:08
 */
public interface B01S013Business {
	/**
	 * 库存状况查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException;


	/**
	 * 编辑sap信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> sapEdit(Map<String,Object> param,String langCode,String langValue)throws Exception;

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
			String departmentID,String langCode , String langValue) throws BusinessException;
	
}
