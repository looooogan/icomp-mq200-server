package com.icomp.common.service.icomp.v01b08.s009;

import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Vparts;


/**
 * 零部件配置Service
 * @author lcc
 *
 */
public interface ICOMPV01B08S009Service {
	
	/**
	 * 取得零部件配置配置列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Vparts entity);
	
	/**
	 * 删除零部件配置信息
	 * @param parts 页面检索条件
	 * @param lang 语言编码
	 * @return
	 */
	public Map<String, Object> partsDelete(Parts parts, String langCode,String langValue);
	
	/**
	 * 新建零部件配置信息
	 * @param parts 页面检索条件
	 * @param lang 语言编码
	 * @return
	 */
	public Map<String, Object> partsAdd(Parts parts, String langCode,String langValue);
	
	/**
	 * 取得待处理零部件配置信息
	 * @param entity 页面检索条件
	 * @return
	 */
	public Map<String, Object> getPartsInfo(Parts entity);

	/**
	 * 编辑零部件配置信息
	 * @param parts 页面检索条件
	 * @param lang 语言编码
	 * @return
	 */
	public Map<String, Object> partsEdit(Parts parts, String langCode,String langValue);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int i);
	


}