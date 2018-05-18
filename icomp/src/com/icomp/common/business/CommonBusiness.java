package com.icomp.common.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vgrantlist;
/**
 * 系统初始化Business
 * @author yzq
 *
 */
public interface CommonBusiness {

	/**
	 * 取得系统默认语言
	 * @return 默认语言编码
	 * @throws BusinessException
	 */
	public Languagetable getSystemDefaultLanguage ()throws BusinessException;
	
	/**
	 * 取得系统默认语言
	 * @return 默认语言编码
	 * @throws BusinessException
	 */
	public List<Languagetable> getSystemListLanguage (String lang,String langValue)throws BusinessException;
	
	/**
	 * 取得页面文本内容
	 * @param getType 取得类型
	 * @param langCode 语言Code
	 * @param pageID 页面ID
	 * @param paraName 项目ID(未指定时则全取)
	 * @return 页面文本内容
	 * @throws BusinessException
	 */
	public Map<String,String>  getPageLabelText (String getType,String langCode,String pageID,String paraName,String langValue)throws BusinessException;
	
	/**
	 * 用户登录
	 * @return 登录用户信息
	 * @throws BusinessException
	 */
	public Customer login (Map<String, Object> param,String langCode,String langValue)throws BusinessException;
	
	/**
	 * 取得用户权限信息
	 * @param lang 系统使用语言
	 * @param userName 用户名
	 * @return 用户权限信息
	 * @throws BusinessException
	 */
	public List<Vgrantlist> getUserGrant (String lang,String userName,String langValue)throws BusinessException;

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
	 * 库存异常报警 列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	public	Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException;
	/**
	 * 修改密码
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */

	public Map<String, Object> ChangePassword(Map<String, Object> param, String customerID,
			String langCode, String langValue);


}
