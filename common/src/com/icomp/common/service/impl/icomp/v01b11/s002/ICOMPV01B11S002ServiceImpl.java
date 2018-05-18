package com.icomp.common.service.impl.icomp.v01b11.s002;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b11.s002.ICOMPV01B11S002Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.AgencyDao;
import com.icomp.dao.DepartmentDao;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.VdeptDao;
import com.icomp.entity.base.Department;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vdept;

public class ICOMPV01B11S002ServiceImpl extends BaseService implements
		ICOMPV01B11S002Service {

	/**
	 * 系统显示项目配置(兼顾打印项目)
	 */
	private DisplayeditemconfigurationDao displayeditemconfigurationDao;

	public void setDisplayeditemconfigurationDao(
			DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}

	/**
	 * 部门管理视图Dao
	 */
	private VdeptDao vdeptDao;

	public void setVdeptDao(VdeptDao vdeptDao) {
		this.vdeptDao = vdeptDao;
	}

	/**
	 * 部门Dao
	 */
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	/**
	 * 机构Dao
	 */
	@SuppressWarnings("unused")
	private AgencyDao agencyDao;

	public void setAgencyDao(AgencyDao agencyDao) {
		this.agencyDao = agencyDao;
	}

	/**
	 * 部门管理
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 部门信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vdept entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vdept> list = (List<Vdept>) vdeptDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vdept>();
				Vdept vdept = new Vdept();
				//消息：检索为0
				vdept.setMessageCode(IConstant.EMSG0001);
				vdept.setRetErrFlag(true);
				list.add(vdept);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vdeptDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)
						/ IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vdept> list = new ArrayList<Vdept>();
			Vdept vdept = new Vdept();
			//错误消息：数据库操作异常，查询失败!
			vdept.setMessageCode(IConstant.EMSG0004);
			vdept.setRetErrFlag(true);
			vdept.setExceMessage(e.getMessage());
			list.add(vdept);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID, String lang) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			Displayeditemconfiguration entity = new Displayeditemconfiguration();
			entity.setPageName(pageID);
			entity.setLanguageCode(lang);

			List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao
					.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Displayeditemconfiguration>();
				Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
				displayeditemconfiguration.setMessageCode(IConstant.WMSG0008);
				displayeditemconfiguration.setRetErrFlag(true);
				list.add(displayeditemconfiguration);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Displayeditemconfiguration displayeditemconfiguration : list) {
					rtn
							.put(displayeditemconfiguration.getColName(),
									IConstant.DISPLAYED_FLAG_0
											.equals(displayeditemconfiguration
													.getDisplayedFlag()) ? true
											: false);
				}
				return rtn;
			}
		} catch (SQLException e) {
			List<Displayeditemconfiguration> list = new ArrayList<Displayeditemconfiguration>();
			Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
			//错误消息：数据库操作异常，查询失败!
			displayeditemconfiguration.setMessageCode(IConstant.EMSG0004);
			displayeditemconfiguration.setRetErrFlag(true);
			displayeditemconfiguration.setExceMessage(e.getMessage());
			list.add(displayeditemconfiguration);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;

		}
	}
	
	/**
	 * 部门删除
	 * @param department 页面查询条件
	 * @param langCode   语言编码 
	 * @param langValue  语言值
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> departmentDelete(Department department,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Department entity = new Department();
			entity.setDepartmentID(department.getDepartmentIDWhere());
			entity.setUpdateTime(department.getUpdateTimeWhere());
			entity.setUpdateUser(department.getUpdateUserWhere());
			entity.setVersion(department.getVersionWhere());
			List<Department> list = (List<Department>) departmentDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Department();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = departmentDao.updateNonQuery(department);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Department entity = new Department();
			//错误消息：数据库操作异常，删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 新建编辑的验证
	 * 
	 * @param param
	 *            页面查询条件
	 * @param langCode
	 *            语言编码
	 * @param langValue
	 *            语言值
	 * @param customerID
	 *            用户ID
	 * @param checkType
	 *            1代表新建，2代表编辑
	 * @return
	 */
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			// 页面输入项目验证
			Map<String, String> map = new HashMap<String, String>();
			Department department = new Department();
			if(checkType ==1){
				if (StringUtils.isEmpty(param.get("DIVDepartmentName").toString())) {// 如果部门名称未输入
					map.put("DIVDepartmentName", MessageReSource.getMessageBox(
									IConstant.WMSG0083, langCode, langValue));
				} else {
						if (!StringUtils.isEmpty(param.get("DivAgencyID").toString())) {
						//验证部门名称是否存在
						Vdept vdept = new Vdept();
						vdept.setAgencyID(param.get("DivAgencyID").toString());
						vdept.setDepartmentName(param.get("DIVDepartmentName").toString());
						List<Vdept> ret = (List<Vdept>)vdeptDao.searchByList(vdept);
						if(ret.size() > 0){
						    //消息：您所新建的部门名称已存在!
							map.put("DIVDepartmentName", MessageReSource.getMessageBox(
									IConstant.WMSG0109, langCode, langValue));
						}
					}
						department.setDepartmentName(param.get("DIVDepartmentName").toString());
				}
			}
			// 验证机构名称 是否选择
			if (StringUtils.isEmpty(param.get("DivAgencyID").toString())) {
				map.put("DivAgencyID", MessageReSource.getMessageBox(IConstant.WMSG0015, langCode, langValue));
			}else{
				department.setAgencyID(param.get("DivAgencyID").toString());
			}
			// 验证部门是否选择
			if (StringUtils.isEmpty(param.get("DIVLanguageCode").toString())) {
				map.put("DIVLanguageCode", MessageReSource.getMessageBox(IConstant.WMSG0024, langCode, langValue));
			}else{
				department.setLanguageCode(param.get("DIVLanguageCode").toString());
			}
			// 验证部门电话
			if (StringUtils.isEmpty(param.get("DIVDepartmentTel").toString())) {
				map.put("DIVDepartmentTel", MessageReSource.getMessageBox(IConstant.WMSG0082, langCode, langValue));
			}else if (!(isPhone(param.get("DIVDepartmentTel").toString())
					||isMobile(param.get("DIVDepartmentTel").toString()))) {
				map.put("DIVDepartmentTel","部门电话格式不正确！");//部门电话格式不正确
			}else{
				department.setDepartmentTel(param.get("DIVDepartmentTel").toString());
			}
			// 验证部门描述
			if (StringUtils.isEmpty(param.get("DIVDepartmentDescription")
					.toString())) {// 如果删除区分未选择
				map.put("DIVDepartmentDescription", MessageReSource.getMessageBox(IConstant.WMSG0084, langCode, langValue));
			}else{
				department.setDepartmentDescription(param.get(
				"DIVDepartmentDescription").toString());
			}
			// 验证部门成立时间
			if (StringUtils.isEmpty(param.get("DIVDepartmentCdate").toString())) {
				map.put("DIVDepartmentCdate", MessageReSource.getMessageBox(IConstant.WMSG0085, langCode, langValue));
			}else{
				department.setDepartmentCdate(param.get("DIVDepartmentCdate")
						.toString().replaceAll("-", ""));
				
			}
			// 验证负责人电话
			if (StringUtils.isEmpty(param.get("DIVDepartmentHeadTel").toString())) {
				map.put("DIVDepartmentHeadTel", MessageReSource.getMessageBox(IConstant.WMSG0086, langCode, langValue));
			}else if (!(isPhone(param.get("DIVDepartmentHeadTel").toString())
					||isMobile(param.get("DIVDepartmentHeadTel").toString()))) {
				map.put("DIVDepartmentHeadTel",MessageReSource.getMessageBox(IConstant.WMSG0166, langCode, langValue));//电话格式不正确
			}else{
				department.setDepartmentHeadTel(param.get("DIVDepartmentHeadTel")
						.toString());
			}
			// 验证负责人手机
			if (StringUtils.isEmpty(param.get("DIVDepartmentHeadMobile").toString())) {
				
				map.put("DIVDepartmentHeadMobile", MessageReSource.getMessageBox(IConstant.WMSG0087, langCode, langValue));
			}else if( !isMobile(param.get("DIVDepartmentHeadMobile").toString())){
				map.put("DIVDepartmentHeadMobile",MessageReSource.getMessageBox(IConstant.WMSG0167, langCode, langValue));//手机格式不正确
			}else{
				department.setDepartmentHeadMobile(param.get("DIVDepartmentHeadMobile")
						.toString());
			}
			// 验证负责人
			if (StringUtils.isEmpty(param.get("DIVDepartmentHead").toString())) {
				map.put("DIVDepartmentHead", MessageReSource.getMessageBox(IConstant.WMSG0088, langCode, langValue));
			}else{
				department.setDepartmentHead(param.get("DIVDepartmentHead").toString());
			}
			if (checkType == 1) {
				if (map.size() > 0) {
					rtn.put("message", map);
				} else {
					department.setDepartmentID(NextKeyValue.getNextkeyvalue(
							IConstant.DEPARTMENT, IConstant.DEPARTMENT_ID,
							department.getUpdateUser()));// 取得部门表主键
					department.setUpdateTime(new Date());// 更新时间
					department.setUpdateUser(customerID);// 更新者
					department.setCreateTime(new Date());// 创建时间
					department.setCreateUser(customerID);// 创建者
					department.setDelFlag(IConstant.DEL_FLAG_0);//删除区分
					department.setVersion(BigDecimal.ZERO);// 版本号
				}
			} else if (checkType == 2) {
				if (map.size() > 0) {
					rtn.put("message", map);
				} else {
					department.setUpdateTime(new Date());// 更新时间
					department.setUpdateUser(customerID);// 更新者
					department.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));//版本号
					department.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));//更新时间
					department.setUpdateUserWhere(param.get("DivUpdateUser").toString());//更新者
					department.setDepartmentIDWhere(param.get("DivDepartmentID").toString());//ID
					department.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));//版本号
				}
			}
			rtn.put("data", department);
			rtn.put("status", IConstant.RESULT_CODE_2);
			return rtn;
		} catch (SQLException e) {
			Department entity = new Department();
			//错误消息：数据库操作异常，查询失败!
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}

	}

	/**
	 * 新建部门信息
	 * @param department 页面查询条件
	 * @param langCode   语言编码 
	 * @param langValue  语言值
	 */
	public Map<String, Object> departmentAdd(Department department,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			departmentDao.insert(department);
			//成功消息：插入成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;
		} catch (SQLException e) {
			Department entity = new Department();
			//错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 部门编辑
	 * @param department 页面查询条件
	 * @param langCode   语言编码 
	 * @param langValue  语言值
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> departmentEdit(Department department,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Department entity = new Department();
			entity.setDepartmentID(department.getDepartmentIDWhere());
			entity.setUpdateTime(department.getUpdateTimeWhere());
			entity.setUpdateUser(department.getUpdateUserWhere());
			entity.setVersion(department.getVersionWhere());
			List<Department> list = (List<Department>) departmentDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Department();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新部门成功
			@SuppressWarnings("unused")
			int ret = departmentDao.updateNonQuery(department);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;
		} catch (SQLException e) {
			Department entity = new Department();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 取得部门信息
	 * @param department 页面查询条件
	 * @param langCode   语言编码 
	 * @param langValue  语言值
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDepartmentInfo(Vdept entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vdept> list = (List<Vdept>) vdeptDao.searchByList(entity);
			if (list.size() <= 0) {
				Vdept vdept = new Vdept();
				//消息：检索为0
				vdept.setMessageCode(IConstant.EMSG0001);
				vdept.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", vdept);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Vdept vdept = new Vdept();
			//错误消息：数据库操作异常，查询失败!
			vdept.setMessageCode(IConstant.EMSG0004);
			vdept.setRetErrFlag(true);
			vdept.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", vdept);
			return rtn;
		}
	}

}
