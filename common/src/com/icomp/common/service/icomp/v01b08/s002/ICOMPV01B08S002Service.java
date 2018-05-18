package com.icomp.common.service.icomp.v01b08.s002;

import java.util.Map;

import com.icomp.entity.base.Librarycode;
import com.icomp.entity.base.Onoff;

/**
 * 内置编码Service
 * @author lcc
 *
 */
public interface ICOMPV01B08S002Service {


	/**
	 * 取得内置编码列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String,Object> getList(Onoff entity);

	/**
	 * 删除内置编码配置
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> librarycodeDelete(Librarycode librarycode,String langCode,String langValue);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode,String langValue, String customerID, int checkType);

	public Map<String, Object> getlibrarycodeInfo(Librarycode entity);

	public Map<String, Object> LibrarycodeEdit(Librarycode librarycode,
			String langCode,String langValue);


	Map<String,Object> getOnoff(Map<String, Object> param, Onoff entity, String customer);



}
