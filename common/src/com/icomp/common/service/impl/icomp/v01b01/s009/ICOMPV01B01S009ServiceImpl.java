package com.icomp.common.service.impl.icomp.v01b01.s009;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s009.ICOMPV01B01S009Service;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.VinspectionrecordDao;
import com.icomp.entity.base.Vinspectionrecord;
/**
 * 质检记录查询SERVICE实现类
 * @ClassName: ICOMPV01B01S009ServiceImpl 
 * @author Taoyy
 * @date 2014-8-15 下午04:26:17
 */
public class ICOMPV01B01S009ServiceImpl extends BaseService implements ICOMPV01B01S009Service {

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
	 * 质检记录查询Dao
	 */
	private VinspectionrecordDao vinspectionrecordDao;
	public void setVinspectionrecordDao(VinspectionrecordDao vinspectionrecordDao) {
		this.vinspectionrecordDao = vinspectionrecordDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 质检记录查询列表--ToolCode模糊查询
	 */
	public Map<String, Object> getList(Vinspectionrecord entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vinspectionrecord> list = (List<Vinspectionrecord>) vinspectionrecordDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vinspectionrecord>();
				Vinspectionrecord vinspectionrecord = new Vinspectionrecord();
				vinspectionrecord.setMessageCode(IConstant.EMSG0001);
				vinspectionrecord.setRetErrFlag(true);
				list.add(vinspectionrecord);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vinspectionrecordDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vinspectionrecord> list = new ArrayList<Vinspectionrecord>();
			Vinspectionrecord vinspectionrecord = new Vinspectionrecord();
			vinspectionrecord.setMessageCode(IConstant.EMSG0004);
			vinspectionrecord.setRetErrFlag(true);
			vinspectionrecord.setExceMessage(e.getMessage());
			list.add(vinspectionrecord);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
}
