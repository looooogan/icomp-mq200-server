package com.icomp.common.service.impl.icomp.v01b12.s001;

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
import com.icomp.common.service.icomp.v01b12.s001.ICOMPV01B12S001Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.CapabilityDao;
import com.icomp.dao.VbusinessDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflow;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Process;
import com.icomp.entity.base.Vbusiness;
@SuppressWarnings("unchecked")
public class ICOMPV01B12S001ServiceImpl extends BaseService implements
		ICOMPV01B12S001Service {

	private VbusinessDao vbusinessDao;
	private BusinessDao businessDao;
	private BusinessflowDao businessflowDao;
	private BusinessflowlnkDao businessflowlnkDao;
	private CapabilityDao capabilityDao;

	public void setVbusinessDao(VbusinessDao vbusinessDao) {
		this.vbusinessDao = vbusinessDao;
	}

	public void setCapabilityDao(CapabilityDao capabilityDao) {
		this.capabilityDao = capabilityDao;
	}

	public void setBusinessflowDao(BusinessflowDao businessflowDao) {
		this.businessflowDao = businessflowDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
		this.businessflowlnkDao = businessflowlnkDao;
	}

	@Override
	public Map<String, Object> getList(Vbusiness entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vbusiness> list = (List<Vbusiness>) vbusinessDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vbusiness>();
				Vbusiness vbusiness = new Vbusiness();
				// 消息：检索为0
				vbusiness.setMessageCode(IConstant.EMSG0001);
				vbusiness.setRetErrFlag(true);
				list.add(vbusiness);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vbusinessDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)
						/ IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vbusiness> list = new ArrayList<Vbusiness>();
			Vbusiness vbusiness = new Vbusiness();
			// 错误消息：数据库操作异常，查询失败!
			vbusiness.setMessageCode(IConstant.EMSG0004);
			vbusiness.setRetErrFlag(true);
			vbusiness.setExceMessage(e.getMessage());
			list.add(vbusiness);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 删除功能
	 * 
	 * @param business
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> businessDelete(Businessflowlnk business,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			Businessflow entity = new Businessflow();
			List<Businessflowlnk> list = (List<Businessflowlnk>) businessflowlnkDao
					.searchByList(business);
			if (list == null || list.size() == 0) {
				entity = new Businessflow();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
			} else {
				entity.setBusinessFlowIDWhere(list.get(0).getBusinessFlowID());
				entity.setDelFlag(IConstant.DEL_FLAG_1);// 删除
				@SuppressWarnings("unused")
				int ret = businessflowDao.updateNonQuery(entity);
				// 成功消息：删除成功
				rtn.put("message", MessageReSource.getMessageBox(
						IConstant.IMSG0003, langCode, langValue));
				rtn.put("status", IConstant.RESULT_CODE_0);
			}
			
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Business entity = new Business();
			// 错误消息：数据库操作异常，删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 流程名列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public List<Businessflow> getBusinessFlowList(Businessflow entity)
			throws BusinessException {
		try {

			List<Businessflow> list = (List<Businessflow>) businessflowDao
					.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Businessflow>();
				Businessflow vbusiness = new Businessflow();
				vbusiness.setMessageCode(IConstant.WMSG0008);
				vbusiness.setRetErrFlag(false);
				list.add(vbusiness);
				return list;
			} else {
				return list;
			}
		} catch (SQLException e) {
			List<Businessflow> list = new ArrayList<Businessflow>();
			Businessflow vbusiness = new Businessflow();
			// 错误消息：数据库操作异常，查询失败!
			vbusiness.setMessageCode(IConstant.EMSG0004);
			vbusiness.setRetErrFlag(true);
			vbusiness.setExceMessage(e.getMessage());
			list.add(vbusiness);
			return list;
		}
	}

	/**
	 * 业务名列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public List<Business> getBusinessList(Business entity) {
		try {

			List<Business> list = (List<Business>) businessDao
					.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Business>();
				Business vbusiness = new Business();
				vbusiness.setMessageCode(IConstant.WMSG0008);
				vbusiness.setRetErrFlag(false);
				list.add(vbusiness);
				return list;
			} else {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			List<Business> list = new ArrayList<Business>();
			Business vbusiness = new Business();
			// 错误消息：数据库操作异常，查询失败!
			vbusiness.setMessageCode(IConstant.EMSG0004);
			vbusiness.setRetErrFlag(true);
			vbusiness.setExceMessage(e.getMessage());
			list.add(vbusiness);
			return list;
		}
	}

	@Override
	public List<Vbusiness> getBusinessList(Vbusiness entity) {
		try {

			List<Vbusiness> list = (List<Vbusiness>) vbusinessDao
					.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Vbusiness>();
				Vbusiness vbusiness = new Vbusiness();
				vbusiness.setMessageCode(IConstant.WMSG0008);
				vbusiness.setRetErrFlag(true);
				list.add(vbusiness);
				return list;
			} else {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			List<Vbusiness> list = new ArrayList<Vbusiness>();
			Vbusiness vbusiness = new Vbusiness();
			// 错误消息：数据库操作异常，查询失败!
			vbusiness.setMessageCode(IConstant.EMSG0004);
			vbusiness.setRetErrFlag(true);
			vbusiness.setExceMessage(e.getMessage());
			list.add(vbusiness);
			return list;
		}
	}

	public Map<String, Object> businessInfo(Vbusiness entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vbusiness> list = (List<Vbusiness>) vbusinessDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Vbusiness vbusiness = new Vbusiness();
				// 消息：检索为0
				vbusiness.setMessageCode(IConstant.EMSG0001);
				vbusiness.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", vbusiness);
				return rtn;
			} else {
				rtn.put("data", list);
				return rtn;
			}
		} catch (SQLException e) {
			Vbusiness vbusiness = new Vbusiness();
			// 错误消息：数据库操作异常，查询失败!
			vbusiness.setMessageCode(IConstant.EMSG0004);
			vbusiness.setRetErrFlag(true);
			vbusiness.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", vbusiness);
			return rtn;
		}
	}

	/**
	 验证
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 */
	@Override
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int checkType)
			throws BusinessException {

		Map<String, Object> rtn = new HashMap<String, Object>();
		Map<String, String> map = new HashMap<String, String>();
		List<Businessflowlnk> businessflowlnkList= new ArrayList<Businessflowlnk>();
		Businessflow businessflow= new Businessflow();
		//流程名 
		if (StringUtils.isEmpty(param.get("DIVBusinessFlowName").toString())) {
			//请输入流程名!
			map.put("DIVBusinessFlowName", "请输入流程名!");
		} else {
			businessflow.setBusinessFlowName(param.get("DIVBusinessFlowName").toString());
			if(checkType==1)
			businessflow.setBusinessFlowID(NextKeyValue.getNextkeyvalue(
					IConstant.BUSINESS_FLOW, IConstant.BUSINESS_FLOW_ID,
					customerID));// 取得主键
			
			if(checkType==2)
				businessflow.setBusinessFlowID(param.get("DivBusinessFlowID").toString());
		}
		try {
			String[] OrderNumber=(String[]) param.get("OrderNumber");
			String[] DIV_Business=(String[]) param.get("DIVCurrentBusiness");
			String[] DIV_Capability=(String[]) param.get("DIVCapability");
			for (int i = 0; i < DIV_Business.length; i++) {
				Businessflowlnk businessflowlnk =new Businessflowlnk();
				businessflowlnk.setBusinessFlowLnkID(NextKeyValue.getNextkeyvalue(
						IConstant.BUSINESS_FLOW_LNK, IConstant.BUSINESS_FLOW_LNK_ID,
						customerID));// 取得用户表主键
				businessflowlnk.setBusinessFlowID(businessflow.getBusinessFlowID());
				businessflowlnk.setBusinessID(DIV_Business[i]);
				businessflowlnk.setCapabilityID(DIV_Capability[i]);
				businessflowlnk.setOrderNumber(new BigDecimal(OrderNumber[i]));
				businessflowlnkList.add(businessflowlnk);
			}
		} catch (ClassCastException e) {
			String OrderNumber=(String) param.get("OrderNumber");
			String DIV_Business=(String) param.get("DIVCurrentBusiness");
			String DIV_Capability=(String) param.get("DIVCapability");
				Businessflowlnk businessflowlnk =new Businessflowlnk();
				businessflowlnk.setBusinessFlowLnkID(NextKeyValue.getNextkeyvalue(
						IConstant.BUSINESS_FLOW_LNK, IConstant.BUSINESS_FLOW_LNK_ID,
						customerID));// 取得用户表主键
				businessflowlnk.setBusinessFlowID(businessflow.getBusinessFlowID());
				businessflowlnk.setBusinessID(DIV_Business);
				businessflowlnk.setCapabilityID(DIV_Capability);
				businessflowlnk.setOrderNumber(new BigDecimal(OrderNumber));
				businessflowlnkList.add(businessflowlnk);
			
		}catch (NullPointerException e) {
			map.put("aa", "请添加流程节点");
		}
		if(map.size()>0){
			rtn.put("message", map);
			rtn.put("status", IConstant.RESULT_CODE_2);
		}else if(map.size()==0&&checkType==1){//新建
			
			businessflow.setDelFlag(IConstant.DEL_FLAG_0);//版本号
			businessflow.setVersion(BigDecimal.ZERO);//版本号
			businessflow.setCreateTime(new Date());// 创建时间
			businessflow.setCreateUser(customerID);// 创建者
			businessflow.setUpdateUser(customerID);//更新者
			businessflow.setUpdateTime(new Date());//更新时间
			rtn.put("status", IConstant.RESULT_CODE_0);
		}else if(map.size()==0&&checkType==2){//编辑
			
			businessflow.setBusinessFlowIDWhere(param.get("DivBusinessFlowID").toString());
			businessflow.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));//版本号
			businessflow.setUpdateTime(new Date());// 更新时间
			businessflow.setUpdateUser(customerID);// 更新者
			rtn.put("status", IConstant.RESULT_CODE_0);
		}
		rtn.put("businessflow", businessflow);
		rtn.put("businessflowlnkList", businessflowlnkList);
		return rtn;
	}

	/**
	 * 功能名列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	@Override
	public List<Capability> getBusinessList(Capability entity) {
		try {

			List<Capability> list = (List<Capability>) capabilityDao
					.searchByListByLevel(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Capability>();
				Capability vbusiness = new Capability();
				vbusiness.setMessageCode(IConstant.WMSG0008);
				vbusiness.setRetErrFlag(true);
				list.add(vbusiness);
				return list;
			} else {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			List<Capability> list = new ArrayList<Capability>();
			Capability vbusiness = new Capability();
			// 错误消息：数据库操作异常，查询失败!
			vbusiness.setMessageCode(IConstant.EMSG0004);
			vbusiness.setRetErrFlag(true);
			vbusiness.setExceMessage(e.getMessage());
			list.add(vbusiness);
			return list;
		}
	}
	/**
	 * 流程列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	@Override
	public Map<String, Object> getbusinessFlow(Businessflow entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Businessflow> list = (List<Businessflow>)businessflowDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Businessflow vbusiness = new Businessflow();
				// 消息：检索为0
				vbusiness.setMessageCode(IConstant.EMSG0001);
				vbusiness.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", vbusiness);
				return rtn;
			} else {
				Businessflow tool = list.get(0);
				rtn.put("data", tool);
				return rtn;
			}
		} catch (SQLException e) {
			Businessflow vbusiness = new Businessflow();
			// 错误消息：数据库操作异常，查询失败!
			vbusiness.setMessageCode(IConstant.EMSG0004);
			vbusiness.setRetErrFlag(true);
			vbusiness.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", vbusiness);
			return rtn;
		}
	}

	/**
	 * 新建流程
	 * @return
	 */
	@Override
	public Map<String, Object>businessAdd(Businessflow businessflow,
			List<Businessflowlnk> businessflowlnkList, String customerID,
			String langCode, String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			
			 businessflowDao.insert(businessflow);
			 for (Businessflowlnk businessflowlnk : businessflowlnkList) {
				 businessflowlnkDao.insert(businessflowlnk);
			}
			//插入成功,ID:{0}!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Businessflow entity = new Businessflow();
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
	 * 删除流程
	 */
	@Override
	public Map<String, Object> businessDelete(Businessflow businessflow,
			List<Businessflowlnk> businessflowlnkList, String customerID,
			String langCode, String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			Businessflow entity =new Businessflow();
			entity.setVersion(businessflow.getVersionWhere());
			entity.setBusinessFlowID(businessflow.getBusinessFlowIDWhere());
			// 删除失败! 进行数据排他验证
			List<Businessflow> list = (List<Businessflow>) businessflowDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				businessflow = new Businessflow();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				businessflow.setMessageCode(IConstant.WMSG0009);
				businessflow.setRetErrFlag(true);
				rtn.put("error", businessflow);
				rtn.put("data", null);
				return rtn;
			}
			// 更新成功
			businessflowDao.updateNonQuery(businessflow);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Businessflow entity = new Businessflow();
			//消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	/**
	 * 编辑流程
	 */
	@Override
	public Map<String, Object> businessEdit(Businessflow businessflow,
			List<Businessflowlnk> businessflowlnkList, String customerID,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			Businessflow entity =new Businessflow();
			entity.setVersion(businessflow.getVersionWhere());
			entity.setBusinessFlowID(businessflow.getBusinessFlowIDWhere());
			List<Businessflow> list = (List<Businessflow>) businessflowDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				businessflow = new Businessflow();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				businessflow.setMessageCode(IConstant.WMSG0009);
				businessflow.setRetErrFlag(true);
				rtn.put("error", businessflow);
				rtn.put("data", null);
				return rtn;
			}
			// 更新成功
			businessflowDao.updateNonQuery(businessflow);
			
			Businessflowlnk businessflowlnk=new Businessflowlnk();
			businessflowlnk.setBusinessFlowIDWhere(businessflow.getBusinessFlowIDWhere());
			businessflowlnkDao.delete(businessflowlnk);
			
			for (Businessflowlnk businessflowlnk2 : businessflowlnkList) {
				 businessflowlnkDao.insert(businessflowlnk2);
			}
			
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Businessflow entity = new Businessflow();
			// 错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}




}
