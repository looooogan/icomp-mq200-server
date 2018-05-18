package com.icomp.common.service.impl.icomp.v01b05.s001;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b05.s001.ICOMPV01B05S001Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.DeliveryplanDao;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.VqualityinspectionDao;
import com.icomp.entity.base.Deliveryplan;
import com.icomp.entity.base.Vqualityinspection;
/**
 * 待质检刀具查询SERVICE实现类
 * @ClassName: ICOMPV01B01S008ServiceImpl 
 * @author Licc
 * @date 2014-8-15 下午03:20:48
 */
public class ICOMPV01B05S001ServiceImpl extends BaseService implements ICOMPV01B05S001Service {

	public void setDisplayeditemconfigurationDao(
			DisplayeditemconfigurationDao displayeditemconfigurationDao) {
	}
	/**
	 * 待质检刀具查询Dao
	 */
	private VqualityinspectionDao vqualityinspectionDao;
	
	public void setVqualityinspectionDao(VqualityinspectionDao vqualityinspectionDao) {
		this.vqualityinspectionDao = vqualityinspectionDao;
	}

	/**
	 * 到货计划DAO
	 */
	private DeliveryplanDao deliveryplanDao;
	public void setDeliveryplanDao(DeliveryplanDao deliveryplanDao) {
		this.deliveryplanDao = deliveryplanDao;
	}

	@Override
	/**
	 * 待质检刀具查询列表
	 */
	public Map<String, Object> getList(Vqualityinspection entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<Vqualityinspection> list = (List<Vqualityinspection>) vqualityinspectionDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vqualityinspection>();
				Vqualityinspection vqualityinspection = new Vqualityinspection();
				vqualityinspection.setMessageCode(IConstant.EMSG0001);
				vqualityinspection.setRetErrFlag(true);
				list.add(vqualityinspection);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Vqualityinspection  v : list) {
					//计算总金额
					v.setTotalMoney(getMoney(v));
				}
				int total = vqualityinspectionDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vqualityinspection> list = new ArrayList<Vqualityinspection>();
			Vqualityinspection vqualityinspection = new Vqualityinspection();
			vqualityinspection.setMessageCode(IConstant.EMSG0004);
			vqualityinspection.setRetErrFlag(true);
			vqualityinspection.setExceMessage(e.getMessage());
			list.add(vqualityinspection);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	/**
	 * 总金额= 单价 * 数量
	 * @title getMoney 
	 * @param v
	 * @return
	 * String
	 */
	private String getMoney(Vqualityinspection v) {
		DecimalFormat df = new DecimalFormat("#.00");
		//总金额= 单价 * 数量
		Double d = (v.getUnitPrice().doubleValue()) * (v.getProcuredCount().doubleValue());
		return df.format(d);
	}

	@Override
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String customerID, int checkType, String langValue) {
		Deliveryplan entity = new Deliveryplan();
		Map<String, Object> rtn = new HashMap<String, Object>();
		Map<String, String> map = new HashMap<String, String>();
		try {
			// 货品状态
			if (StringUtils.isEmpty(param.get("DIVTheyStatus").toString())) {
			}else {
				entity.setTheyStatus(param.get("DIVTheyStatus").toString());
			}
			if (map.size() <= 0&&checkType == 2){// 如果是编辑
					// 编辑后的组装参数于新增后不同
					entity.setUpdateTime(new Date());// 更新时间
					entity.setUpdateUser(customerID);// 更新者
					entity.setInspectionUser(customerID);// 更新者
					entity.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
					entity.setDeliveryPlanID(param.get("DivDeliveryPlanID").toString());
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

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> deliveryplanEdit(Deliveryplan deliveryplan,
			String langCode, String langValue) {
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

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDeliveryplanInfo(Deliveryplan entity) {
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
