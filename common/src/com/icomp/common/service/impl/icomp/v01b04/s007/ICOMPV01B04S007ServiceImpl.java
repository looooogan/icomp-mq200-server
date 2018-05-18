package com.icomp.common.service.impl.icomp.v01b04.s007;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b04.s007.ICOMPV01B04S007Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.CustomerDao;
import com.icomp.dao.VwarningDao;
import com.icomp.dao.WarningDao;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Vwarning;
import com.icomp.entity.base.Warning;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 *  加工信息快速查询SERVICES实现类
 * @ClassName: ICOMPV01B04S006ServiceImpl 
 * @author Taoyy
 * @date 2014-8-20 下午06:19:41
 */

public class ICOMPV01B04S007ServiceImpl extends BaseService implements ICOMPV01B04S007Service {

	/**
	 * 加工信息快速查询DAO
	 */
	private VwarningDao vwarningDao;
	private CustomerDao customerDao;
	private WarningDao warningDao;

	public void setWarningDao(WarningDao warningDao) {
		this.warningDao = warningDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setVwarningDao(VwarningDao vwarningDao) {
		this.vwarningDao = vwarningDao;
	}

	public Map<String, Object> getList(Vwarning entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			List<Vwarning> list = (List<Vwarning>) vwarningDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vwarning>();
				entity.setMessageCode(IConstant.EMSG0001);
				entity.setRetErrFlag(true);
				list.add(entity);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			}
				int total = vwarningDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;


		} catch (SQLException e) {
			e.printStackTrace();
			List<Vwarning> list = new ArrayList<Vwarning>();
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			list.add(entity);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, String userID, int checkType)throws BusinessException {
		Map<String, Object> rtn = new HashMap<String, Object>();
		// 错误信息
		Map<String, String> map = new HashMap<String, String>();
		Warning entity = new Warning();
		try {
			//判断功能是否为空
			if (StringUtils.isEmpty(param.get("DIVwarningfunction").toString())) {
				map.put("DIVwarningfunction", MessageReSource.getMessageBox(IConstant.REPLYJ001, langCode, langValue));
			}
			//判断员工卡是否为空
		if (StringUtils.isEmpty(param.get("DIVwarningcar").toString())) {
				map.put("DIVwarningcar", MessageReSource.getMessageBox(IConstant.REPLYJ002, langCode, langValue));
		}else if(!StringUtils.isEmpty(param.get("DIVwarningcar").toString())){
			Customer customer = new Customer();
			customer.setEmployeeCard(param.get("DIVwarningcar").toString());
				List<Customer> customerList = customerDao.searchByEmployee(customer);
			if (customerList.size()==0){
				map.put("DIVwarningcar", MessageReSource.getMessageBox(IConstant.REPLYJ003, langCode, langValue));
			}else{
				Warning warning = new Warning();
				warning.setEmployeeCard(param.get("DIVwarningcar").toString());
				warning.setWarningFunction(param.get("DIVwarningfunction").toString());
				List<Warning> list = (List<Warning>)warningDao.searchByList(warning);
				if (list.size()==0){
					entity.setWarningFunction(param.get("DIVwarningfunction").toString());
					entity.setEmployeeCard(param.get("DIVwarningcar").toString());

					entity.setCustomerID(customerList.get(0).getCustomerID());
				}else {
					map.put("DIVwarningcar", MessageReSource.getMessageBox(
							IConstant.REPLYJ004, langCode, langValue));
				}

			}

		}

		// 如果是新增
		if(checkType==1) {
			if (map.size() <= 0) {
				entity.setSorT(IConstant.STRING_0);
				//entity.setItemType( param.get("DIVItemType").toString());
				entity.setVersion(BigDecimal.ZERO);// 版本号
				entity.setWarningID(NextKeyValue
						.getNextkeyvalue(IConstant.DISPLAYEDITEMCONFIGURATION,
								IConstant.DISPLAYEDITEMCONFIGURATION_ID, entity
										.getUpdateUser()));// 取得主键
				entity.setCreateTime(new Date());// 创建时间
				entity.setCreateUser(userID);// 创建者
				entity.setUpdateTime(new Date());// 更新时间
				entity.setUpdateUser(userID);// 更新者
				entity.setDelFlag(IConstant.DEL_FLAG_0);
			} else {
				rtn.put("message", map);
			}
		}

		if (checkType == 2) {
			// 如果是编辑
			if (map.size() <= 0) {
				entity.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
				entity.setUpdateUser(userID);
				entity.setUpdateTime(new Date());
				entity.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
				entity.setUpdateUserWhere(param.get("DivUpdateUser").toString());
				entity.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
			} else {
				rtn.put("message", map);
			}
		}
		rtn.put("data", entity);
		rtn.put("status", IConstant.RESULT_CODE_2);

		} catch (Exception e) {
			e.printStackTrace();
			Warning entitys =new Warning();
			entitys.setMessageCode(IConstant.EMSG0004);
			entitys.setRetErrFlag(true);
			entitys.setExceMessage(e.getMessage());
			rtn.put("rows", null);
			rtn.put("error", entitys);
		}
		return rtn;
	}

	@Override
	public Map<String, Object> VwarningAdd(Warning entity, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			warningDao.insert(entity);
			//插入成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;
		} catch (SQLException e) {
			Warning warning = new Warning();
			//错误消息：数据库操作异常，插入失败!
			warning.setMessageCode(IConstant.EMSG0007);
			warning.setRetErrFlag(true);
			warning.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> getWanrning(Map<String, Object> param, Warning entity,String customerID) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		String sspID = param.get("sspID").toString();

		try {
			List<Warning> list = (List<Warning>) warningDao.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Warning();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				// 更新项目打印成功
			}

			Warning warning =  list.get(0);
			warning.setWarningIDWhere(list.get(0).getWarningID());
			warning.setWarningFunction(list.get(0).getWarningFunction());
			warning.setCustomerID(list.get(0).getCustomerID());
			warning.setEmployeeCard(list.get(0).getEmployeeCard());
			warning.setDelFlag(list.get(0).getDelFlag());
			warning.setSorT(sspID);
			warning.setCreateUser(list.get(0).getCreateUser());
			warning.setCreateTime(list.get(0).getCreateTime());
			warning.setUpdateTime(new Date());
			warning.setUpdateUser(customerID);
			int ret = warningDao.updateNonQuery(warning);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, "",  ""));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;


		} catch (SQLException e) {
			Warning warning = new Warning();
			//错误消息：数据库操作异常，查询失败!
			warning.setMessageCode(IConstant.EMSG0004);
			warning.setRetErrFlag(true);
			warning.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", warning);
			return rtn;
		}
	}

	@Override
	public String getNumber() {
		int total = 0;
		try {
			total=vwarningDao.searchByCount(new Vwarning());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(total);
	}


}
