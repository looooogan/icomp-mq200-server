package com.icomp.v01b01.b01s005.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Vapplyuser;

import java.util.List;
import java.util.Map;

/**
 * 申请信息查询BUSINESS接口
 * @ClassName: B01S005Business 
 * @author Taoyy
 * @date 2014-8-13 下午04:45:46
 */
public interface B01S005Business {
	/**
	 * 申请信息列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue,int chey)throws BusinessException;


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

	Map<String,Object> replacementAdd(Map<String, Object> param, String langCode, String langValue,String userID) throws BusinessException;
	/**
	 * 取得页面下拉列表内容
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
 Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;

	/**
	 * 编辑
 	 * @param param
	 * @param langCod
	 * @param langValue
	 * @param userID
	 * @return
	 * @throws BusinessException
     */
    Map<String,Object> replacementEdit(Map<String,Object> param,String langCod,String langValue,String userID) throws  BusinessException;

	/**
	 * 根据id查询
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
     */
	Map<String, Object> printItemInfo(Map<String, Object> param, String langCode,String langValue)throws BusinessException;

	Map<String,Object> getUserList(String langCode, String langValue)throws BusinessException;

	List<Vapplyuser> getVapplyuser(String cuID, String delFlag0, String langCode, String langValue, int i)throws BusinessException;

	String getNumber()throws BusinessException;
}
