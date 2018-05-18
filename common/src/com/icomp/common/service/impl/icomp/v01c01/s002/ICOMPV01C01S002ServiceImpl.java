package com.icomp.common.service.impl.icomp.v01c01.s002;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s002.ICOMPV01C01S002Service;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.AuthorizationDao;
import com.icomp.dao.CustomerDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.entity.base.Authorization;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Rfidcontainer;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 授权
 * 
 * @author Taoyy
 * @ClassName: ICOMPV01C01S002ServiceImpl
 * @date 2016-1-24 上午09:56:18
 */
public class ICOMPV01C01S002ServiceImpl extends BaseService implements
		ICOMPV01C01S002Service {
	/**
	 * 授权表Dao
	 */
	private AuthorizationDao authorizationDao;

	public void setAuthorizationDao(AuthorizationDao authorizationDao) {
		this.authorizationDao = authorizationDao;
	}

	/**
	 * RFID载体
	 */
	private RfidcontainerDao rfidcontainerDao;

	public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
		this.rfidcontainerDao = rfidcontainerDao;
	}
	
	/**
	 * 用户表
	 */
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	/**
	 * 授权
	 */
	public Map<String, Object> saveAuthorized(String customerID,String authorizedReason, String toolID,
			String businessID,Customer entity)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Authorization authorization = new Authorization();
		try {
			//授权ID
			authorization.setAuthorizationID(UUIDgen.getId());
			//授权人ID
			authorization.setAuthorizationUserID(entity.getCustomerID());
			//授权原因（0.断刀1.丢刀2.补领）
			authorization.setAuthorizedReason(authorizedReason);
			//授权时间
			authorization.setAuthorizedTime(new Date());
			//创建人
			authorization.setCreateUserID(customerID);
			//修改人
			authorization.setUpdateUser(customerID);
			//修改时间
			authorization.setUpdateTime(new Date());
			//创建时间
			authorization.setCreateTime(new Date());
			//刀具ID
			authorization.setToolID(toolID);
			//流程ID
			authorization.setBusinessCode(businessID);
			// 插入授权表
			authorizationDao.insert(authorization);

			result.put("status", IConstant.RESULT_CODE_0);
			// 入库成功！
			result.put("messagetext", IConstant.IMSG0009);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			result.put("status", IConstant.RESULT_CODE_2);
			// 数据库操作异常,查询失败!
			result.put("messagetext", IConstant.EMSG0004);
			return result;
		}
	}

	/**
	 * 查询授权ID
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Customer searchAuID(String customerID, Customer entity)
			throws Exception {
		List<Customer> list = null;
		try {
			list = (List<Customer>) customerDao.searchByList(entity);
			if (list == null || list.size() <= 0) {
				// 您所查询的用户不存在!
				Customer customer = new Customer();
				customer.setMessageCode(IConstant.WMSG0122);
				customer.setRetErrFlag(true);
				return customer;
			} else {
				return list.get(0);
			}

		} catch (SQLException e) {
			// 数据库操作异常，查询失败!
			Customer customer = new Customer();
			customer.setMessageCode(IConstant.EMSG0004);
			customer.setRetErrFlag(true);
			customer.setExceMessage(e.getMessage());
			return customer;
		}

	}

	/**
	 * 查询RFID载体ID
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Rfidcontainer searchRfid(Rfidcontainer entity) throws Exception {
		List<Rfidcontainer> list = null;
		try {
			list = (List<Rfidcontainer>) rfidcontainerDao.searchByList(entity);
			if (list == null || list.size() <= 0) {
				// 您所查询的RFID载体ID不存在!
				Rfidcontainer rfidcontainer = new Rfidcontainer();
				rfidcontainer.setMessageCode(IConstant.WMSG0122);
				rfidcontainer.setRetErrFlag(true);
				return rfidcontainer;
			} else {
				return list.get(0);
			}

		} catch (SQLException e) {
			// 数据库操作异常，查询失败!
			Rfidcontainer rfidcontainer = new Rfidcontainer();
			rfidcontainer.setMessageCode(IConstant.EMSG0004);
			rfidcontainer.setRetErrFlag(true);
			rfidcontainer.setExceMessage(e.getMessage());
			return rfidcontainer;
		}
	}

}
