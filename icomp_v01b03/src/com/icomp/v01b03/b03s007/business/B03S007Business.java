package com.icomp.v01b03.b03s007.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;

/**
 * 筒刀拆装记录查询BUSINESS接口
 * @ClassName: B01S007Business
 * @author Sj
 * @date 2017-7-7 下午04:21:51
 */
public interface B03S007Business {
	/**
	 * 刃磨信息快速查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
 public	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;


	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,
                                             String departmentID, String langCode, String langValue) throws BusinessException;

	/**
	 * 修复通知单查询列表
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getListMerchants(Map<String, Object> param, String langCode, String langValue, int checkType)throws BusinessException;

	String getMnumber()throws BusinessException;

	// 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
	/**
	 * 取得详细信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> detailInfo(Map<String,Object> param,String langCode,String langValue)throws BusinessException;

	/**
	 * 取得详细信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> totalInfo(Map<String,Object> param,String langCode,String langValue)throws BusinessException;
	// 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC
	
}
