package com.icomp.common.service.icomp.v01b08.s005;

import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Vcomlist;


/**
 * 系统码表配置Service
 * @author lcc
 *
 */
public interface ICOMPV01B08S005Service {

	/**
	 * 取得系统码表配置列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Vcomlist entity);

	/**
	 * 删除系统码表配置信息
	 * @param comlist 页面检索条件
	 * @param lang 语言编码
	 * @return
	 */
	public Map<String, Object> comlistDelete(Comlist entity, String langCode,String langValue);
	
	/**
	 * 新建系统码表配置信息
	 * @param comlist 页面检索条件
	 * @param lang 语言编码
	 * @return
	 */
	public Map<String, Object> comlistAdd(Comlist comlist, String langCode,String langValue);

	public Map<String, Object> getComlistInfo(Comlist entity);

	public Map<String, Object> comlistEdit(Comlist comlist, String langCode,String langValue);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int i);
	



}
