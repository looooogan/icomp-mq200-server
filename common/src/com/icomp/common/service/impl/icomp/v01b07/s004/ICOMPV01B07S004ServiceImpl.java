package com.icomp.common.service.impl.icomp.v01b07.s004;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b07.s004.ICOMPV01B07S004Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.*;
import com.icomp.entity.base.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 * 采购订单SERVICE实现类
 * 
 * @ClassName: ICOMPV01B07S004ServiceImpl
 * @author Taoyy
 * @date 2014-9-16 下午01:52:16
 */

public class ICOMPV01B07S004ServiceImpl extends BaseService implements ICOMPV01B07S004Service {

	/**
	 * 系统显示项目配置(兼顾打印项目)
	
	private DisplayeditemconfigurationDao displayeditemconfigurationDao;

	public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}
 */
	/**
	 * 采购计划处理DAO
	 */
	private VpurchasingorderDao vpurchasingorderDao;
	/**
	 * 用户Dao
	 */
	private VcustomerDao vcustomerDao;
	/**
	 * 到货计划DAO
	 */
	private DeliveryplanDao deliveryplanDao;
	/**
	 * 刀具采购
	 */
	private ToolprocuredDao toolprocuredDao;

	private VtoolprocuredsDao vtoolprocuredsDao;



	public void setVtoolprocuredsDao(VtoolprocuredsDao vtoolprocuredsDao) {
		this.vtoolprocuredsDao = vtoolprocuredsDao;
	}

	@Override
	/**
	 * 采购计划处理列表
	 */
	public Map<String, Object> getList(Vtoolprocureds entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			//toolCode模糊查询
			List<Vtoolprocureds> list = (List<Vtoolprocureds>) vtoolprocuredsDao.searchByList(entity);
			int  number=0;
			for (Vtoolprocureds vlist : list) {
			if(vlist.getToolID()==null||vlist.getToolID().equals("")){
				  number = 0;
			}else {
				number = Integer.parseInt(vlist.getToolID());
			}

				int take =(vlist.getProcuredCount()).intValue() ;
				int surplus= number-take;

				if (surplus>0){
					vlist.setExpandSpace1(String.valueOf(surplus));
					vlist.setProcuredInto(IConstant.PROCURED_PAYING_1);
				}else  {
					vlist.setExpandSpace1(IConstant.BAND_TYPE_0);
					vlist.setProcuredInto(IConstant.PROCURED_PAYING_0);
				}

			}
			if (list.size() <= 0) {
				list = new ArrayList<Vtoolprocureds>();
				Vtoolprocureds vtoolprocureds = new Vtoolprocureds();
				vtoolprocureds.setMessageCode(IConstant.EMSG0001);
				vtoolprocureds.setRetErrFlag(true);
				list.add(vtoolprocureds);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Vtoolprocureds vtlist : list) {
					vtlist.setToolType(String.valueOf(vtlist.getToolType().charAt(0)));
				}
				int total = vtoolprocuredsDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			List<Vtoolprocureds> list = new ArrayList<Vtoolprocureds>();
			Vtoolprocureds vtoolprocureds = new Vtoolprocureds();
			vtoolprocureds.setMessageCode(IConstant.EMSG0004);
			vtoolprocureds.setRetErrFlag(true);
			vtoolprocureds.setExceMessage(e.getMessage());
			list.add(vtoolprocureds);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
		return rtn;
	}
	/**
	 * 未预定数量
	 * 未预定数量 = 采购数量 - 已预定数量
	 * @title getTheyCount 
	 * @param v
	 * @return
	 * BigDecimal
	 */
	private BigDecimal getTheyCount(Vpurchasingorder v) {
		//未预定数量 = 采购数量 - 已预定数量
		if (v.getTheyCount() == null) {
			v.setTheyCount(BigDecimal.ZERO);
		}
		return new BigDecimal(v.getProcuredCount().intValue()- v.getTheyCount().intValue());
	}

	/**
	 * 取得用户列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vcustomer> getVcustomer(Vcustomer entity) {
		List<Vcustomer> list = null;
		try {
			list = (List<Vcustomer>) vcustomerDao.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Vcustomer>();
				Vcustomer vcustomer = new Vcustomer();
				vcustomer.setMessageCode(IConstant.WMSG0008);
				vcustomer.setRetErrFlag(true);
				list.add(vcustomer);
				return list;
			} else {
				return list;
			}

		} catch (SQLException e) {
			 list = new ArrayList<Vcustomer>();
			Vcustomer vcustomer = new Vcustomer();
			//错误消息：数据库操作异常，查询失败!
			vcustomer.setMessageCode(IConstant.EMSG0004);
			vcustomer.setRetErrFlag(true);
			vcustomer.setExceMessage(e.getMessage());
			list.add(vcustomer);

		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> orderAdd(Deliveryplan entity, String langCode,String tempCount ,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		int tempCount1 = 0;
		try {
			//查询已订购数量
			entity.setToolProcuredIDWhere(entity.getToolProcuredID());
			for (Deliveryplan dp : (List<Deliveryplan>) deliveryplanDao.searchByList(entity)) {
				tempCount1 += dp.getTheyCount().intValue();
			}
			//订单数据插入
			deliveryplanDao.insert(entity);
			//订单订购数量是否全部订完
			int theyNumber = Integer.parseInt(tempCount)-entity.getTheyCount().intValue()-tempCount1;
			if (theyNumber <= 0) {
				Toolprocured toolprocured = new Toolprocured();
				//更新刀具采购
				toolprocured.setDelFlag(IConstant.DEL_FLAG_1);
				toolprocured.setToolProcuredIDWhere(entity.getToolProcuredID());
				toolprocuredDao.updateNonQuery(toolprocured);
			}
			//插入成功 返回信息
			rtn.put("message", MessageReSource.getMessageBox(IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Deliveryplan deliveryplan = new Deliveryplan();
			// 错误消息：数据库操作异常,插入失败!
			deliveryplan.setMessageCode(IConstant.EMSG0007);
			deliveryplan.setRetErrFlag(true);
			deliveryplan.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			rtn.put("message", MessageReSource.getMessageBox(IConstant.EMSG0007, langCode,langValue));
			//rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> deliveryplansAdd(Vtoolprocureds vtoolprocureds, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			toolprocuredDao.insert(vtoolprocureds);
			//成功消息：插入成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);

		} catch (SQLException e) {
			Replacement entity = new Replacement();
			//错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);

		}
		return rtn;
	}


	/**
	 * 启用采购计划提交
	 */
	
	public void setVpurchasingorderDao(VpurchasingorderDao vpurchasingorderDao) {
		this.vpurchasingorderDao = vpurchasingorderDao;
	}
	public void setVcustomerDao(VcustomerDao vcustomerDao) {
		this.vcustomerDao = vcustomerDao;
	}
	public void setDeliveryplanDao(DeliveryplanDao deliveryplanDao) {
		this.deliveryplanDao = deliveryplanDao;
	}

	public void setToolprocuredDao(ToolprocuredDao toolprocuredDao) {
		this.toolprocuredDao = toolprocuredDao;
	}
	
}
