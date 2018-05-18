package com.icomp.common.service.icomp.v01b08.s006;

import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Handset;
import com.icomp.entity.base.Vhandset;


/**
 * 手持机配置Service
 * @author lcc
 *
 */
public interface ICOMPV01B08S006Service {

	/**
	 * 取得手持机配置配置列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Vhandset entity);
	
	/**
	 * 删除手持机配置信息
	 * @param handset 页面检索条件
	 * @param lang 语言编码
	 * @return
	 */
	public Map<String, Object> handsetDelete(Handset handset, String langCode,String langValue);
	
	/**
	 * 新建手持机配置信息
	 * @param handset 页面检索条件
	 * @param lang 语言编码
	 * @return
	 */
	public Map<String, Object> handsetAdd(Handset handset, String langCode,String langValue);
	
	/**
	 * 编辑手持机配置信息
	 * @param handset 页面检索条件
	 * @param lang 语言编码
	 * @return
	 */
	public Map<String, Object> handsetEdit(Handset handset, String langCode,String langValue);
	
	/**
	 * 取得待处理手持机信息
	 * @param handset 页面检索条件
	 * @return
	 */
	public Map<String, Object> getHandsetInfo(Handset entity);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int i);
	

}
