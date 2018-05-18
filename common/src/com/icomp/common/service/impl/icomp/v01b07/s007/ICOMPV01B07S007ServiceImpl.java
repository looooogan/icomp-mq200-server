package com.icomp.common.service.impl.icomp.v01b07.s007;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b07.s007.ICOMPV01B07S007Service;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.RfidpurchaseDao;
import com.icomp.entity.base.Rfidpurchase;
/**
 * 标签采购SERVICE实现类
 * @ClassName: ICOMPV01B07S007ServiceImpl 
 * @author Licc
 * @date 2014-8-21 下午04:20:08
 */
public class ICOMPV01B07S007ServiceImpl extends BaseService implements ICOMPV01B07S007Service {

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
	 * 标签采购DAO
	 */
    private RfidpurchaseDao rfidpurchaseDao;

	public void setRfidpurchaseDao(RfidpurchaseDao rfidpurchaseDao) {
		this.rfidpurchaseDao = rfidpurchaseDao;
	}


	/**
	 * 标签采购列表
	 */
	public Map<String, Object> getList(Rfidpurchase entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Rfidpurchase> list = (List<Rfidpurchase>) rfidpurchaseDao.searchByListWithPurchaseUser(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Rfidpurchase>();
				Rfidpurchase rfidPurchase = new Rfidpurchase();
				// 消息：检索为0
				rfidPurchase.setMessageCode(IConstant.EMSG0001);
				rfidPurchase.setRetErrFlag(true);
				list.add(rfidPurchase);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = rfidpurchaseDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Rfidpurchase> list = new ArrayList<Rfidpurchase>();
			Rfidpurchase rfidPurchase = new Rfidpurchase();
			// 错误消息：数据库操作异常,查询失败!
			rfidPurchase.setMessageCode(IConstant.EMSG0004);
			rfidPurchase.setRetErrFlag(true);
			rfidPurchase.setExceMessage(e.getMessage());
			list.add(rfidPurchase);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
}
