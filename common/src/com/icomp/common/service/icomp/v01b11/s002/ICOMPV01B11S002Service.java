package com.icomp.common.service.icomp.v01b11.s002;

import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Department;
import com.icomp.entity.base.Vdept;



public interface ICOMPV01B11S002Service {


	/**
	 * 部门管理
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 部门信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Vdept entity);

	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,String langCode);
	
	/**
	 * 部门删除
	 * @param entity 页面查询条件
	 * @return 部门信息
	 * @throws BusinessException
	 */
	public Map<String, Object> departmentDelete(Department department,String langCode,String langValue);
	
	/**
	 * 新建编辑的验证
	 * @param param      页面查询条件
	 * @param langCode   语言编码
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param checkType  1代表新建，2代表编辑
	 * @return
	 */
	public Map<String, Object> checkInput(Map<String, Object> param,String langCode, String langValue , String departmentID, int i);
	
	/**
	 * 保存部门信息
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> departmentAdd(Department department, String  langCode,String langValue);

	
	public Map<String, Object> getDepartmentInfo(Vdept entity);

	public Map<String, Object> departmentEdit(Department department,String langCode,String langValue);

	
}