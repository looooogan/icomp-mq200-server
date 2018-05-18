package com.icomp.v01b11.b11s002.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b11.s002.ICOMPV01B11S002Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Department;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vdept;
import com.icomp.v01b11.b11s002.business.B11S002Business;

/**
 * 部门管理BUSINESS实现类
 * 
 * @ClassName: B11S002BusinessImpl
 * @author Licc
 * @date 2014-8-21 下午02:02:34
 */
public class B11S002BusinessImpl implements B11S002Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 部门管理SERVICE
	 */
	private ICOMPV01B11S002Service iCOMPV01B11S002Service;

	public void setiCOMPV01B11S002Service(
			ICOMPV01B11S002Service iCOMPV01B11S002Service) {
		this.iCOMPV01B11S002Service = iCOMPV01B11S002Service;
	}

	/**
	 * 取得系统区分列表
	 * 
	 * @param flagType
	 *            区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,
			String langValue) throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 部门管理列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		// 设置检索条件
		Vdept entity = new Vdept();
		// 机构
		entity.setAgencyID(StringUtils
				.isEmpty(param.get("AgencyID").toString()) ? null : param.get(
				"AgencyID").toString());
		// 部门
		entity.setDepartmentID(StringUtils.isEmpty(param.get("DepartmentID")
				.toString()) ? null : param.get("DepartmentID").toString());
		// 删除区分
		entity.setDepartmentDelFlag(StringUtils.isEmpty(param.get("DelFlag").toString())? null : param.get("DelFlag").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1)
				* IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("AgencyID,DepartmentID");	
		Map<String, Object> rtn = iCOMPV01B11S002Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vdept>) rtn.get("error")).get(0)
					.getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 取得机构信息列表
	 * 
	 * @param param
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	public List<Vagency> getAgencyList(String param, String langCode,
			String langValue) throws BusinessException {
		Vagency entity = new Vagency();
		entity.setDelFlag(param);
		entity.setAgencyLanguageCode(langCode);
		List<Vagency> list = service.getVagency(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
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
	public List<Vdepartment> getDepartmentList(String agencyID, String delFlag,
			String langCode, String langValue) throws BusinessException {
		Vdepartment entity = new Vdepartment();
		entity.setDepartmentAgencyID(agencyID);
		entity.setDepartmentDelFlag(delFlag);
		entity.setDepartmentLanguageCode(langCode);
		List<Vdepartment> list = service.getVdepartment(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;

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
	 * 删除部门信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> departmentDelete(Map<String, Object> param,
			String customerID, String langCode, String langValue)
			throws BusinessException {

		Department department = new Department();
		department.setDelFlag(IConstant.DEL_FLAG_1);
		department.setUpdateTime(new Date());
		department.setUpdateUser(customerID);
		department.setVersion(new BigDecimal(param.get("version").toString())
				.add(BigDecimal.ONE));
		department.setDepartmentIDWhere(param.get("departmentID").toString());
		department.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime")
				.toString().replace("T", " ")));
		department.setUpdateUserWhere(param.get("updateuser").toString());
		department.setVersionWhere(new BigDecimal(param.get("version")
				.toString()));
		Map<String, Object> ret = iCOMPV01B11S002Service.departmentDelete(
				department,  langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 删除失败时，返回
			throw new BusinessException(((Department) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 新建部门信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> departmentAdd(Map<String, Object> param,
			String customerID, String langCode, String langValue)
			throws BusinessException {

		// 部门输入验证
		Map<String, Object> ret = iCOMPV01B11S002Service.checkInput(param,
				langCode,  langValue, customerID, 1);
		if (ret.size() > 1 && ret.get("error") != null) {
			throw new BusinessException(((Department) ret.get("error"))
					.getMessageCode(), langCode,langValue);
		} else if (ret.size() > 1 && ret.get("message") != null) {
			return ret;
		}
		Department department = (Department)ret.get("data");
		// 保存部门信息
		ret = iCOMPV01B11S002Service.departmentAdd(department, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 新建失败时，返回
			throw new BusinessException(((Department) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> departmentEdit(Map<String, Object> param,
			String customerID, String langCode, String langValue) {
		// 部门输入验证
		Map<String, Object> ret = iCOMPV01B11S002Service.checkInput(param,
				langCode,  langValue, customerID, 2);
		if (ret.size() > 1 && ret.get("error") != null) {
			throw new BusinessException(((Department) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		} else if (ret.size() > 1 && ret.get("message") != null) {
			return ret;
		}
		Department department =(Department)ret.get("data");
		// 保存部门信息
		ret = iCOMPV01B11S002Service.departmentEdit(department, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 新建失败时，返回
			throw new BusinessException(((Department) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得待编辑的部门信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> departmentInfo(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		Map<String, Object> ret = new HashMap<String, Object>();
		String departmentID = param.get("departmentID").toString();
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			// 取得待编辑部门信息
			Vdept entity = new Vdept();
			entity.setDepartmentID(departmentID);
			ret = iCOMPV01B11S002Service.getDepartmentInfo(entity);
			if (ret.size() > 1 && ret.get("error") != null) {
				// 检索错误时，返回
				throw new BusinessException(((Vdept) ret.get("error"))
						.getMessageCode(), langCode, langValue);
			}
		}
		return ret;
	}

}
