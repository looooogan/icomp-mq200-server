package com.icomp.common.service.impl.icomp.v01c02.s006;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c02.s006.ICOMPV01C02S006Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.DepartmentDao;
import com.icomp.dao.HandsetDao;
import com.icomp.entity.base.Department;
import com.icomp.entity.base.Handset;

public class ICOMPV01C02S006ServiceImpl  extends BaseService implements ICOMPV01C02S006Service{

	private DepartmentDao departmentDao;
	private HandsetDao handsetDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public void setHandsetDao(HandsetDao handsetDao) {
		this.handsetDao = handsetDao;
	}

	/**
	 * 取得部门列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Department> getDepatement(Department entity){
		try {
			List<Department> list = (List<Department>)departmentDao.searchByList(entity);
			if(list == null || list.size() <= 0){
				//系统无可注册部门!
				list = new ArrayList<Department>();
				Department department = new Department();
				department.setMessageCode(IConstant.WMSG0154);
				department.setRetErrFlag(true);
				list.add(department);
				return list;
			}else{
				return list;
			}
			
		} catch (SQLException e) {
			List<Department> list = new ArrayList<Department>();
			Department department = new Department();
			department.setMessageCode(IConstant.EMSG0004);
			department.setRetErrFlag(true);
			department.setExceMessage(e.getMessage());
			list.add(department);
			return list;
		}
	}

	/**
	 * 取得已注册部门信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Handset> getHandsets(Handset entity){
		try {
			List<Handset> list = (List<Handset>)handsetDao.searchByList(entity);
			if(list == null || list.size() <= 0){
				list = new ArrayList<Handset>();
				return list;
			}else{
				return list;
			}
			
		} catch (SQLException e) {
			List<Handset> list = new ArrayList<Handset>();
			Handset handset = new Handset();
			handset.setMessageCode(IConstant.EMSG0004);
			handset.setRetErrFlag(true);
			handset.setExceMessage(e.getMessage());
			list.add(handset);
			return list;
		}
	}
	
	/**
	 * 手持机注册
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> saveHand(Handset entity){
		Map<String,Object> ret = new HashMap<String,Object>();
		try {
		//检测当前手持机是可以注册
		Handset handset = new Handset();
		handset.setHandSetCode(entity.getHandSetCode());
		handset.setHandSetStauts(IConstant.HANDSET_STAUTS_1);
		handset.setDelFlag(entity.getDelFlag());
		List<Handset> list = (List<Handset>)handsetDao.searchByList(handset);
		//可以注册，则更新数据
		if(list.size()>0){
			handset = list.get(0);
			handset.setHandSetIDWhere(handset.getHandSetID());
			handset.setIsRegistration(entity.getIsRegistration());
			handset.setDepartmentID(entity.getDepartmentID());
			handset.setUpdateTime(entity.getUpdateTime());
			handset.setUpdateUser(entity.getUpdateUser());
			handset.setVersion(handset.getVersion().add(BigDecimal.ONE));
			handsetDao.updateNonQuery(handset);
			ret.put("MessageCode", IConstant.CIMSG0075);
			ret.put("status", IConstant.RESULT_CODE_0);
			return ret;
		}else{//未注册，则插入新数据
			handset = new Handset();
			handset.setHandSetID(UUID.randomUUID().toString());
			handset.setHandSetCode(entity.getHandSetCode());
			handset.setHandSetStauts(IConstant.HANDSET_STAUTS_1);
			handset.setDelFlag(IConstant.DEL_FLAG_0);
			handset.setIsRegistration(entity.getIsRegistration());
			handset.setDepartmentID(entity.getDepartmentID());
			handset.setUpdateTime(entity.getUpdateTime());
			handset.setUpdateUser(entity.getUpdateUser());
			handset.setCreateTime(entity.getCreateTime());
			handset.setCreateUser(entity.getCreateUser());
			handset.setVersion(BigDecimal.ZERO);
			handset.setLoginStauts(IConstant.LOGINSTAUTS_1);
			handsetDao.insert(handset);
			ret.put("MessageCode", IConstant.CIMSG0075);
			ret.put("status", IConstant.RESULT_CODE_0);
			return ret;
		}
		} catch (SQLException e) {
			ret.put("MessageCode", IConstant.EMSG0004);
			ret.put("status", IConstant.RESULT_CODE_1);
			return ret;
		}
	}
}
