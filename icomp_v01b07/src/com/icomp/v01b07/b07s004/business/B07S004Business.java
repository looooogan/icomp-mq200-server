package com.icomp.v01b07.b07s004.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vcustomer;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;

/**
 * 换领申请信息查询BUSINESS接口
 * @ClassName: B01S004Business 
 * @author Taoyy
 * @date 2014-8-13 上午10:34:59
 */
public interface B07S004Business {
	/**
	 * 换领申请信息列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;
	/**
	 * 取得机构信息列表
	 * @title getAgencyList 
	 * @param dELFLAG_0
	 * @param langValue
	 * @return
	 * List<Vagency>
	 */
	List<Vagency> getAgencyList(String dELFLAG_0,String langCode, String langValue);
	/**
	 * 取得部门列表
	 * @title getDepartmentList 
	 * @param agencyID
	 * @param dELFLAG_0
	 * @param langValue
	 * @return
	 * List<Vdepartment>
	 */
	List<Vdepartment> getDepartmentList(String agencyID, String dELFLAG_0, String langValue);
	/**
	 * 取得职务列表
	 * @title getPositionList 
	 * @param departmentID
	 * @param dELFLAG_0
	 * @param langValue
	 * @return
	 * Object
	 */
	List<Vposition> getPositionList(String departmentID, String dELFLAG_0, String langValue);
	/**
	 * 取得用户列表
	 * @title getUserNameList 
	 * @param string
	 * @param dELFLAG_0
	 * @param langValue
	 * @return
	 * List<Vcustomer>
	 */
	List<Vcustomer> getUserNameList(String positionID, String dELFLAG_0, String langValue);
	/**
	 * 保存采购订单
	 * @title saveAll 
	 * @param param
	 * @param langValue
	 * @param customer
	 * @param lang
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> saveAll(Map<String, Object> param, String langValue, String customer, String langCode);

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
	 *  新建
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	Map<String,Object> newAdd(Map<String, Object> param, String langCode, String langValue)throws BusinessException;
	
}
