package com.icomp.v01b01.b01s007.business;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vcustomer;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;

/**
 *在途计划查询BUSINESS接口
 * @ClassName: B01S007Business 
 * @author Taoyy
 * @date 2014-8-15 上午11:31:31
 */
public interface B01S007Business {
	/**
	 * 在途计划查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	public	Map<String, Object> getList(Map<String, Object> param,  String langCode,String langValue)throws BusinessException;

	/**
	 * 编辑在途计划
	 * @title vtransitPlanEdit 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> vtransitPlanEdit(Map<String, Object> param,String langValue, String customerID, String langCode)throws BusinessException;
	
	/**
	 * 添加实际到货时间、实际到货数量
	 * @title vtransitPlanAdd 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> vtransitPlanAdd(Map<String, Object> param,String langValue, String customerID, String langCode)throws BusinessException;


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
	 * 取得当前在途计划信息
	 * 
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> vtransitInfo(Map<String, Object> param,
			String langCode, String langValue)throws BusinessException;

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
	 * 取得职务列表
	 * @title getPositionList 
	 * @param departmentID
	 * @param dELFLAG_0
	 * @param langValue
	 * @return
	 * Object
	 */
	List<Vposition> getPositionList(String departmentID, String dELFLAG_0, String langValue);
	
}
