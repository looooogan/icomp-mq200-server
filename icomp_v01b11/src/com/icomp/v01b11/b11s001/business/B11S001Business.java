package com.icomp.v01b11.b11s001.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;

public interface B11S001Business {

	/**
	 * 取得功能信息列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;


	/**
	 * 保存权限信息列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> saveGruant(Map<String,Object> param,String user,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得功能信息列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object>  getRoleGruanList(Map<String,Object> param,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得部门信息列表
	 * @param param 删除区分
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Vagency> getAgencyList(String param,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得部门信息列表
	 * @param param 删除区分
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Vdepartment> getDepartmentList(String agencyID,String delFlag,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得职务信息列表
	 * @param departmentID 部门ID
	 * @param delFlag 删除区分
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Vposition> getPositionList(Map<String, Object>  param,String delFlag,String langCode,String langValue)throws BusinessException;


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
	 * 取得页面Capability显示项目树
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */

	public Map<String,Object> getCapTree(Map<String, Object> param,
			String langCode, String langValue);


	/**
	 * 取得系统区分列表
	 * 
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,
			String langValue) throws BusinessException;

	
}
