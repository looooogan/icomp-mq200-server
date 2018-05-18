package com.icomp.common.service.icomp.v01b08.s001;

import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Capability;

/**
 * 用户登录Service
 * @author yzq
 *
 */
public interface ICOMPV01B08S001Service {


	/**
	 * 取得功能信息列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Capability entity);
	

	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,String lang);
	
	/**
	 * 功能信息查询
	 * @param entity 页面查询条件
	 * @return 功能信息
	 * @throws BusinessException
	 */
	public Map<String,Object> getCapablitiyInfo(Capability capability);
	
	/**
	 * 功能删除
	 * @param entity 页面查询条件
	 * @return 功能信息
	 * @throws BusinessException
	 */
	public Map<String,Object> capablitiyDelete(Capability capability,String langCode,String langValue);
	
	/**
	 * 取得功能信息列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getCapabilityList(Capability capability,String langCode);
	
	/**
	 * 新建功能信息
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> capablitiyAdd(Capability capability,String langCode,String langValue);
	

	/**
	 * 编辑功能信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> capablitiyEdit(Capability capability,String langCode,String langValue);
	
	/**
	 * 新建功能信息验证
	 * @param param
	 * @param langCode 
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> checkInput(Map<String,Object> param,String langCode,String langValue,String userID, int checkType);
}
