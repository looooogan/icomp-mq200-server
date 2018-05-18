package com.icomp.v01b08.b08s007.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;


public interface B08S007Business {
	
	/**
	 * 取得系统区分列表
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得设备配置列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 删除设备配置
	 * @param param 页面检索条件
	 * @param langValue	 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> equipmentDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException;
	
	/**
	 * 新建工序配置
	 * @param param 页面检索条件
	 * @param langValue	 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> equipmentAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode);
	
	
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
     * 编辑设备
     * @param param
     * @return
     */
	public Map<String, Object> equipmentEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode);
	/**
	 * 取得设备信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> equipmentInfo(Map<String,Object> param,String langCode, String langValue);
	/**
	 * 解绑设备
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> equipmentUnbund(Map<String, Object> param,
			String langValue, String customerID, String langCode);


}
