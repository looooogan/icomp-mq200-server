package com.icomp.v01b08.b08s014.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;


public interface B08S014Business {	

	/**
	 * 取得系统区分列表
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode, String langValue)throws BusinessException;
	
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
	 * 取得关联信息列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode, String langValue)throws BusinessException;
	
		
	/**
	 * 新建工具盘信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> toolshelfAdd(Map<String,Object> param,String userID,String langCode,String langValue);
	
	/**
	 * 删除关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> toolshelfDelete(Map<String,Object> param,String userID,String langCode,String langValue);
}
