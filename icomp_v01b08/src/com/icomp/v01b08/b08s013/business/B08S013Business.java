package com.icomp.v01b08.b08s013.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Voplinkdown;

import java.util.List;
import java.util.Map;


public interface B08S013Business {

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
	 * @param langCode 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode, String langValue)throws BusinessException;

	/**
	 * 取得页面下拉列表内容
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;

	/**
	 * 取得关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkInfo(Map<String,Object> param,String langCode,String langValue);

	/**
	 * 编辑关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkEdit(Map<String,Object> param,String userID,String langCode,String langValue);

	/**
	 * 新建关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkAdd(Map<String,Object> param,String userID,String langCode,String langValue);

	/**
	 * 删除关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkDelete(Map<String,Object> param,String userID,String langCode,String langValue);

	List<Voplinkdown> getVoplink(Map<String, Object> param, String delFlag0, String langCode, String langValue, int i);

}
