package com.icomp.v01b01.b01s007.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s007.ICOMPV01B01S007Service;
import com.icomp.entity.base.Deliveryplan;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vcustomer;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;
import com.icomp.entity.base.Vtransitplan;
import com.icomp.v01b01.b01s007.business.B01S007Business;

/**
 * 在途计划查询BUSINESS实现类
 * 
 * @ClassName: B11S007BusinessImpl
 * @author Taoyy
 * @date 2014-8-15 上午11:32:55
 */
public class B01S007BusinessImpl implements B01S007Business {

	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 在途计划查询SERVICE
	 */
	private ICOMPV01B01S007Service icompv01b01s007Service;

	public void setIcompv01b01s007Service(ICOMPV01B01S007Service icompv01b01s007Service) {
		this.icompv01b01s007Service = icompv01b01s007Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 在途计划查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException {

		/**
		 * 设置检索条件
		 */
		Vtransitplan entity = new Vtransitplan();
		// 采购批次
		entity.setProcuredBatch(StringUtils.isEmpty(param.get("ProcuredBatch").toString()) ? null : param.get("ProcuredBatch").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("TheyStatus");
		// 在途计划查询列表
		Map<String, Object> rtn = icompv01b01s007Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtransitplan>) rtn.get("error")).get(0).getMessageCode(), langCode,langValue);
		}
		return rtn;
	}

	/**
	 * 编辑在途计划
	 */
	public Map<String, Object> vtransitPlanEdit(Map<String, Object> param,String langValue, String customerID, String langCode)
			throws BusinessException {
		//输入验证
		Map<String,Object> ret = icompv01b01s007Service.checkInput(param,langCode,customerID,2,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Deliveryplan)ret.get("error")).getMessageCode(),langCode, langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		ret = icompv01b01s007Service.vtransitPlanEdit((Deliveryplan)ret.get("data"),langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //编辑失败时，返回
			  throw new BusinessException(((Deliveryplan)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> vtransitPlanAdd(Map<String, Object> param,String langValue, String customerID, String langCode)throws BusinessException {
		//输入验证
		Map<String,Object> ret = icompv01b01s007Service.checkInput(param,langCode,customerID,1,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Deliveryplan)ret.get("error")).getMessageCode(),langCode, langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		//保存在途计划信息
	    ret = icompv01b01s007Service.vtransitPlanAdd((Deliveryplan)ret.get("data"),langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Deliveryplan)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID, String userID,
			String langCode, String langValue) throws BusinessException {

		// 取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得当前在途计划信息
	 * 
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> vtransitInfo(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object>();
		String deliveryplanID = param.get("deliveryPlanID").toString();
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			//取得待编辑在途计划信息
			Deliveryplan entity = new Deliveryplan();
			entity.setDeliveryPlanID(deliveryplanID);
			ret = icompv01b01s007Service.getVtransitInfo(entity);
			if(ret.size() > 1 && ret.get("error") != null){
				  //检索错误时，返回
				  throw new BusinessException(((Deliveryplan)ret.get("error")).getMessageCode(), langCode, langValue);
			}
		}
		return ret;
	}

	/**
	 * 取得机构信息列表
	 * 
	 * @param param
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	public List<Vagency> getAgencyList(String param, String langCode,String langValue) throws BusinessException {
		Vagency entity = new Vagency();
		entity.setDelFlag(param);
		entity.setAgencyLanguageCode(langCode);
		List<Vagency> list = service.getVagency(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
		}
		return list;
	}

	/**
	 * 取得部门信息列表
	 * 
	 * @param param
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	public List<Vdepartment> getDepartmentList(String agencyID, String delFlag, String langCode) throws BusinessException {
		Vdepartment entity = new Vdepartment();
		entity.setDepartmentAgencyID(agencyID);
		entity.setDepartmentDelFlag(delFlag);
		entity.setDepartmentLanguageCode(langCode);
		List<Vdepartment> list = service.getVdepartment(entity);
		return list;

	}

	@Override
	/**
	 * 取得用户列表
	 */
	public List<Vcustomer> getUserNameList(String positionID, String delFlag, String langValue) {
		Vcustomer entity = new Vcustomer();
		entity.setCustomerPositionID(positionID);
		entity.setDelFlag(delFlag);
		List<Vcustomer> list = service.getVcustomer(entity);
		return list;
	}

	/**
	 * 取得职务信息列表
	 * 
	 * @param departmentID
	 *            部门ID
	 * @param delFlag
	 *            删除区分
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Vposition> getPositionList(String departmentID, String delFlag, String langCode) throws BusinessException {
		Vposition entity = new Vposition();
		entity.setDepartmentID(departmentID);
		entity.setDelFlag(delFlag);
		List<Vposition> list = service.getVposition(entity);
		return list;
	}
}
