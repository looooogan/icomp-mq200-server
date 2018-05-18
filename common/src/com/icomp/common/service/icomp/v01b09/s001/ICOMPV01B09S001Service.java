package com.icomp.common.service.icomp.v01b09.s001;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Vlibrarycode;
import com.icomp.entity.base.Vtool;


public interface ICOMPV01B09S001Service {
	
	public Map<String, Object> getList(Vtool entity)throws BusinessException ;
	/**
	 * 验证刀具参数信息
	 * @param param
	 * @param langValue
	 * @return
	 */
	public 	Map<String, Object> checkInput(Map<String, Object> param,
			String uploadFileName, String langCode, String langValue,
			String userId, int checkType) throws BusinessException;
	/**
	 * 保存刀具参数信息
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> toolAdd(Tool tool,String langCode,String  langValue)throws BusinessException ;
	/**
	 * 根据ID获取刀具信息
	 * @param entity 页面查询条件
	 * @return 项目信息信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getToolInfo(Tool entity)throws BusinessException ;
	/**
	 * 编辑刀具参数信息

	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolEdit(Tool tool, String langCode,String  langValue)throws BusinessException ;

	/**
	 * 删除刀具参数信息

	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolDelete(
			Tool tool, String langCode,String  langValue) throws BusinessException ;
	

	/**
	 * 根据ID获取刀具视图信息
	 * @param entity 页面查询条件
	 * @return 项目信息信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getVtoolInfo(Vtool entity) throws BusinessException;
	/**
	 * 获取库位码视图信息

	 * @return 项目信息信息
	 * @throws BusinessException
	 */
	
	public List<Vlibrarycode> getVLibraryCodeList(Map<String, Object> param,
			String langValue)throws BusinessException ;
	/**
	 * toolcode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 */
	public Map<String, Object> getListToolcodeF(Vtool entity);

}
