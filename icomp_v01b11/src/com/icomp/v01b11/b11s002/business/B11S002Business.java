package com.icomp.v01b11.b11s002.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vdepartment;

/**
 * 部门管理BUSINESS接口
 * @ClassName: B11S002Business 
 * @author Licc
 * @date 2014-8-21 下午02:01:40
 */
public interface B11S002Business {
	
	/**
	 * 取得系统区分列表
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String  langCode,String langValue)throws BusinessException;
	
	/**
	 * 部门管理列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)throws BusinessException;

	/**
	 * 取得机构信息列表
	 * @param param 删除区分
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Vagency> getAgencyList(String param,String  langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得部门信息列表
	 * @param param 删除区分
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Vdepartment> getDepartmentList(String agencyID,String delFlag,String  langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,String departmentID,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 删除部门信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> departmentDelete(Map<String, Object> param,String langValue, String customerID, String lang);
	
	/**
	 * 新建部门信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> departmentAdd(Map<String, Object> param,String langValue, String customerID, String lang);
	
	/**
	 * 取得部门信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> departmentInfo(Map<String, Object> param,String langCode, String langValue) ;
	
	/**
	 * 编辑部门信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> departmentEdit(Map<String, Object> param,String langValue, String customerID, String lang);


	
}
