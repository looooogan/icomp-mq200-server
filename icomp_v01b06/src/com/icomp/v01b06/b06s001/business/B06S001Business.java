package com.icomp.v01b06.b06s001.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Business;

import java.util.List;
import java.util.Map;

/**
 *  报废分析BUsiness接口
 * @ClassName: B06S001Business 
 * @author Taoyy
 * @date 2014-8-22 上午09:10:17
 */
public interface B06S001Business {
/**
 * 报废分析列表
 * @title getList 
 * @param param
 * @param langValue
 * @return
 * Map<String,Object>
 */
public	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue,int checkType)throws BusinessException;
/**
 * 报废分析统计数量
 * @title getStatisticalCount 
 * @param param
 * @param langValue
 * @return
 * Object
 */
public Object getStatisticalCount(Map<String, Object> param, String langCode, String langValue);

/**
 * 取得页面grid显示项目列表
 * 
 * @param pageID
 * @param langValue
 * @return
 * @throws BusinessException
 */
public Map<String, Object> getGridColmun(String pageID, 
		String customerID,String langCode , String langValue) throws BusinessException;

	List<Business> getBusinessList() throws BusinessException;

	String getNumber()throws BusinessException;
}
