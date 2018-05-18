package com.icomp.common.service.impl.icomp.v01b03.s004;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b03.s004.ICOMPV01B03S004Service;
import com.icomp.dao.VgrindingworksummaryDao;
import com.icomp.entity.base.Vgrindingworksummary;
/**
 * 刃磨工作量汇总SERVICE实现类
 * @ClassName: ICOMPV01B03S004ServiceImpl 
 * @author Taoyy
 * @date 2014-8-20 下午04:29:32
 */
public class ICOMPV01B03S004ServiceImpl extends BaseService implements ICOMPV01B03S004Service {

	/**
	 * 刃磨工作量汇总DAO
	 */
	private VgrindingworksummaryDao vgrindingworksummaryDao;

	public void setVgrindingworksummaryDao(VgrindingworksummaryDao vgrindingworksummaryDao) {
		this.vgrindingworksummaryDao = vgrindingworksummaryDao;
	}
	/**
	 * 刃磨工作量汇总
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vgrindingworksummary entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vgrindingworksummary> list = (List<Vgrindingworksummary>) vgrindingworksummaryDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vgrindingworksummary>();
				Vgrindingworksummary vgrindingworksummary = new Vgrindingworksummary();
				vgrindingworksummary.setMessageCode(IConstant.EMSG0001);
				vgrindingworksummary.setRetErrFlag(true);
				list.add(vgrindingworksummary);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Vgrindingworksummary v : list) {
					// 是否超标
					v.setOverproof(getIsNoOverproof(v));
					//折旧金额计算 
					v.setDepreciationAmount(getMoney(v));
					//残值计算
					v.setSalvageValue(getSalvageVal(v));
				}
				int total = vgrindingworksummaryDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vgrindingworksummary> list = new ArrayList<Vgrindingworksummary>();
			Vgrindingworksummary vgrindingworksummary = new Vgrindingworksummary();
			vgrindingworksummary.setMessageCode(IConstant.EMSG0004);
			vgrindingworksummary.setRetErrFlag(true);
			vgrindingworksummary.setExceMessage(e.getMessage());
			list.add(vgrindingworksummary);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	/**
	 * 是否超标
	 * @title getIsNoOverproof 
	 * @param v
	 * @return
	 * String
	 */
	private String getIsNoOverproof(Vgrindingworksummary v) {
		
		//修复前测量长度-修复后测量长度
		String str = null;
		BigDecimal NoticeOldLength=BigDecimal.ZERO;
		BigDecimal NoticeLength=BigDecimal.ZERO;
		if(v.getNoticeOldLength()!=null){
			NoticeOldLength=v.getNoticeOldLength();
		}
		if(v.getNoticeLength()!=null){
			NoticeLength=v.getNoticeLength();
		}
		Double double1 = NoticeLength.doubleValue()-NoticeOldLength.doubleValue();
		if (double1 > Double.parseDouble(IConstant.STANDARD_VALUE)) {
			str = IConstant.GRINDING_1;
		} else {
			str = IConstant.GRINDING_0;
		}
		return str;
	}
	/**
	 * 残值计算
	 * 修复后测量长度*(单价/刀具长度)
	 * @title getSalvageVal 
	 * @param vr
	 * @return
	 * String
	 */
	private String getSalvageVal(Vgrindingworksummary v) {
		DecimalFormat df = new DecimalFormat("#.00");
		BigDecimal NoticeOldLength=BigDecimal.ZERO;
		BigDecimal NoticeLength=BigDecimal.ZERO;
		if(v.getNoticeOldLength()!=null){
			NoticeOldLength=v.getNoticeOldLength();
		}
		if(v.getNoticeLength()!=null){
			NoticeLength=v.getNoticeLength();
		}
		 Double double1  =((NoticeOldLength.doubleValue())*((v.getUnitPrice().doubleValue())/(v.getToolLength().doubleValue())));
		return df.format(double1);
	}

	/**
	 * 获取折旧金额 
	 * (修复前测量长度-修复后测量长度)+刀具已刃磨长度)* (单价/刀具长度)
	 * @title getMoney 
	 * @param vr
	 * @return
	 * String
	 */
	private String getMoney(Vgrindingworksummary v) {
		DecimalFormat df = new DecimalFormat("#.00");
		BigDecimal NoticeOldLength=BigDecimal.ZERO;
		BigDecimal NoticeLength=BigDecimal.ZERO;
		Double dou=BigDecimal.ZERO.doubleValue();
		if(v.getNoticeOldLength()!=null){
			NoticeOldLength=v.getNoticeOldLength();
		}
		if(v.getNoticeLength()!=null){
			NoticeLength=v.getNoticeLength();
		}
		if(v.getNoticeLength()!=null&&v.getNoticeOldLength()!=null&&v.getToolGrindingLength()!= null&&v.getUnitPrice()!= null&&v.getToolLength()!= null)
		dou = ((((NoticeLength.doubleValue())-(NoticeOldLength.doubleValue()))
				+(v.getToolGrindingLength().doubleValue()))
				* ((v.getUnitPrice().doubleValue())
						/(v.getToolLength().doubleValue())));
		return df.format(dou);
	}
}
