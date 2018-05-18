package com.icomp.common.service.impl.icomp.v01b01.s007;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b01.s007.ICOMPV01B01S007Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.DeliveryplanDao;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.VtransitplanDao;
import com.icomp.entity.base.Deliveryplan;
import com.icomp.entity.base.Vtransitplan;
/**
 * 在途计划查询SERVICE实现类
 * @ClassName: ICOMPV01B01S007ServiceImpl 
 * @author Taoyy
 * @date 2014-8-15 上午11:49:13
 */
public class ICOMPV01B01S007ServiceImpl extends BaseService implements ICOMPV01B01S007Service {

	/**
	 * 系统显示项目配置(兼顾打印项目)
	 */
	@SuppressWarnings("unused")
	private DisplayeditemconfigurationDao displayeditemconfigurationDao;

	public void setDisplayeditemconfigurationDao(
			DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}

	/**
	 * 在途计划查询Dao
	 */
	private VtransitplanDao vtransitplanDao;
	public void setVtransitplanDao(VtransitplanDao vtransitplanDao) {
		this.vtransitplanDao = vtransitplanDao;
	}
	/**
	 * 到货计划DAO
	 */
	private DeliveryplanDao deliveryplanDao;
	public void setDeliveryplanDao(DeliveryplanDao deliveryplanDao) {
		this.deliveryplanDao = deliveryplanDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 在途计划查询列表
	 */
	public Map<String, Object> getList(Vtransitplan entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vtransitplan> list = (List<Vtransitplan>) vtransitplanDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vtransitplan>();
				Vtransitplan vtransitplan = new Vtransitplan();
				vtransitplan.setMessageCode(IConstant.EMSG0001);
				vtransitplan.setRetErrFlag(true);
				list.add(vtransitplan);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Vtransitplan vt : list) {
					//金额= 采购数量 * 单价
					vt.setAmountMoney((vt.getProcuredCount().doubleValue()*vt.getUnitPrice().doubleValue())+"");
				}
				int total = vtransitplanDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtransitplan> list = new ArrayList<Vtransitplan>();
			Vtransitplan vtransitplan= new Vtransitplan();
			vtransitplan.setMessageCode(IConstant.EMSG0004);
			vtransitplan.setRetErrFlag(true);
			vtransitplan.setExceMessage(e.getMessage());
			list.add(vtransitplan);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 在途计划编辑
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 在途计划信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> vtransitPlanEdit(Deliveryplan deliveryplan, String langCode,String langValue)throws BusinessException {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 编辑失败! 进行数据排他验证
			Deliveryplan entity = new Deliveryplan();
			entity.setDeliveryPlanID(deliveryplan.getDeliveryPlanIDWhere());
			entity.setUpdateTime(deliveryplan.getUpdateTimeWhere());
			entity.setUpdateUser(deliveryplan.getUpdateUserWhere());
			entity.setVersion(deliveryplan.getVersionWhere());
			List<Deliveryplan> list = (List<Deliveryplan>) deliveryplanDao.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Deliveryplan();
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}			
			// 更新货品状态成功
			@SuppressWarnings("unused")
			int ret = deliveryplanDao.updateNonQuery(deliveryplan);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Deliveryplan entity = new Deliveryplan();
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
		
	}

	@Override
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String customerID, int checkType,String langValue) {
		Deliveryplan entity = new Deliveryplan();
		Map<String, Object> rtn = new HashMap<String, Object>();
		Map<String, String> map = new HashMap<String, String>();
		try {
		// 货品状态
		if (StringUtils.isEmpty(param.get("DIVTheyStatus").toString())) {
		}else {
			entity.setTheyStatus(param.get("DIVTheyStatus").toString());
		}
		// 实际到货时间 
		if (StringUtils.isEmpty(param.get("DIVRealityTheyTime").toString())) {
			map.put("DIVRealityTheyTime", MessageReSource.getMessageBox(
					IConstant.WMSG0114, langCode, langValue));
		}else {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//预计到货时间
			String createTimeStr=param.get("DIVOldTheyTime").toString();
			Date createDate=format.parse(createTimeStr);
			//实际到货时间 
			String dateTheyTimeStr=param.get("DIVRealityTheyTime").toString();
			Date dateTheyTime=format.parse(dateTheyTimeStr);
			if(createDate.after(dateTheyTime)){
				map.put("DIVRealityTheyTime", "到货时间不可早于订单创建时间");
			}else{
				//申请起始时间
				if (dateTheyTimeStr != null && dateTheyTimeStr != "") {
					entity.setRealityTheyTime(dateTheyTime);
				}
			}
		}

		if (map.size()>0){//返回错误消息
			rtn.put("message", map);
			rtn.put("status", IConstant.RESULT_CODE_2);
			return rtn;
		} else if (map.size() <= 0&&checkType == 2){// 如果是编辑
			// 编辑后的组装参数于新增后不同
			entity.setUpdateTime(new Date());// 更新时间
			entity.setUpdateUser(customerID);// 更新者
			entity.setTransferPeople(customerID);// 更新者==到货交接人
			entity.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
			entity.setDeliveryPlanID(param.get("DivDeliveryPlanID").toString());
			entity.setRealityTheyCount(new BigDecimal(param.get("DIVProcuredCount").toString()));
			// 查询条件
			entity.setDeliveryPlanIDWhere(entity.getDeliveryPlanID());
			entity.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
			entity.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
			entity.setUpdateUserWhere(param.get("DivUpdateUser").toString());
			rtn.put("data", entity);
			rtn.put("status", IConstant.RESULT_CODE_2);
			return rtn;
		}
		} catch (Exception e) {
			e.printStackTrace();
			Deliveryplan deliveryplan = new Deliveryplan();			
			deliveryplan.setMessageCode(IConstant.EMSG0004);
			deliveryplan.setRetErrFlag(true);
			deliveryplan.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", deliveryplan);
			return rtn;
		}
		return rtn;
	}

	@Override
	public Map<String, Object> vtransitPlanAdd(Deliveryplan entity, String lang,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			deliveryplanDao.insert(entity);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, lang,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Deliveryplan deliveryplan = new Deliveryplan();
			deliveryplan.setMessageCode(IConstant.EMSG0004);
			deliveryplan.setRetErrFlag(true);
			deliveryplan.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getVtransitInfo(Deliveryplan entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Deliveryplan> list = (List<Deliveryplan>) deliveryplanDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Deliveryplan deliveryplan = new Deliveryplan();
				deliveryplan.setMessageCode(IConstant.EMSG0001);
				deliveryplan.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", deliveryplan);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Deliveryplan deliveryplan = new Deliveryplan();			
			deliveryplan.setMessageCode(IConstant.EMSG0004);
			deliveryplan.setRetErrFlag(true);
			deliveryplan.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", deliveryplan);
			return rtn;
		}
	}

}
