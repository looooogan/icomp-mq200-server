package com.icomp.v01b06.b06s005.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vdepartment;

/**
 * 刀具实时分布状况BUSINESS接口
 * @ClassName: B06S005Business 
 * @author Taoyy
 * @date 2014-8-22 上午09:57:17
 */

public interface B06S005Business {
	/**
	 * 刀具实时分布状况列表
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
		String customerID,String langCode , String langValue) throws BusinessException;
/**
 * 取得机构信息列表
 * @param param 删除区分
 * @param lang 语言编码
 * @return
 * @throws BusinessException
 */
public List<Vagency> getAgencyList(String param,String  langCode,String langValue)throws BusinessException;

/**
 * 取得部门信息列表
 * @param param 删除区分
 * @param lang 语言编码
 * @return
 * @throws BusinessException
 */
public List<Vdepartment> getDepartmentList(String agencyID,String delFlag,String  langCode,String langValue)throws BusinessException;

	/**
	 * 定额执行情况分析统计
	 * @title getStatisticalCount
	 * @param param
	 * @param langValue
	 * @return
	 * Object
	 */
	public Object getStatisticalCount(Map<String, Object> param, String langCode, String langValue);

	String getNumber() throws BusinessException;
}
