package com.icomp.v01b09.b09s008.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Merchants;

import java.util.List;
import java.util.Map;

/**
 * 修复通知单查询BUSINESS接口
 * @ClassName: B01S002Business
 * @author Taoyy
 * @date 2014-8-14 下午02:01:40
 */
public interface B09S008Business {
	/**
	 * 修复通知单查询列表
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue,int checkType)throws BusinessException;
	/**
	 * 修复通知单查询列表
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getListMerchants(Map<String, Object> param, String langCode, String langValue,int checkType)throws BusinessException;

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
	 *  新建厂外通知单
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	Map<String,Object> outFactoryAdd(Map<String, Object> param, String langCode, String langValue)throws BusinessException;
	/**
	 *  新建厂外商家
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	Map<String,Object> merchantsAdd(Map<String, Object> param, String langCode, String langValue,String userID)throws BusinessException;
	/**
	 *  编辑商家
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	Map<String,Object> merchantsEdit(Map<String, Object> param, String langCode, String langValue,String userID)throws BusinessException;

	/**
	 *  厂外商家验证
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> checkInputMer(Map<String, Object> param, int checkType)throws BusinessException;
	/**
	 *  厂外商家删除
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> merchantDelete(Map<String,Object> param ,String userID,String langCode,String langValue)throws BusinessException;
	/**
	 * 取得待编辑的用户信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> merchantsInfo(Map<String,Object> param,String langCode,String langValue)throws BusinessException;

	Map<String, Object> merchantsFind(Map<String, Object> param, String langCode, String langValue) throws BusinessException;
	/**
	 * 取得页面下拉列表内容
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;
	/**
	 * 查询待编辑内容
	 * */
	Map<String,Object> outInfo(Map<String, Object> param, String langCode, String langValue)throws BusinessException;

	// 2017/08/25 宋健 追加↓↓↓　dazhong@YMSC
	Map<String,Object> outListInfo(Map<String, Object> param, String langCode, String langValue)throws BusinessException;
	// 2017/08/25 宋健 追加↑↑↑　dazhong@YMSC

	Map<String,Object> outFactoryEdit(Map<String, Object> param, String langCode, String langValue,String userID,String userName)throws BusinessException;

	List<Merchants> outMerchants(Merchants mer)throws BusinessException;

	String getNumber()throws BusinessException;

	String getMnumber()throws BusinessException;
}
