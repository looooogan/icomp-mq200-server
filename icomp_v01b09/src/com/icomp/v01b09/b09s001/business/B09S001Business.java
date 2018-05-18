package com.icomp.v01b09.b09s001.business;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Vlibrarycode;

/**
 * 入库信息查询BUsiness接口
 * 
 * @ClassName: B01S001Business
 * @author Taoyy
 * @date 2014-8-12 下午04:09:08
 */
public interface B09S001Business {

	/**
	 * 取得刀具参数列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param
	 *
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;

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
	 * 新建刀具参数信息
	 * 
	 * @param param
	 * @param langValue
	 * @param langCode
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolAdd(Map<String, Object> param,
			String savePath,String uploadFileName, File upload, String langValue, String userId,
			String langCode) throws BusinessException;

	/**
	 * 根据id获取刀具参数信息
	 * 
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolInfo(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException;

	/**
	 * 编辑刀具参数信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolEdit(Map<String, Object> param,
			String savePath,String uploadFileName, File upload, 
			String langValue, String customerID, String langCode)
			throws BusinessException;

	/**
	 * 删除刀具参数信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException;

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,
			String departmentID, String langCode, String langValue)
			throws BusinessException;

	/**
	 * 取得库位码视图列表
	 * 
	 * @param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	
	public List<Vlibrarycode> getVLibraryCodeList(Map<String, Object> param,
			String langValue);

}
