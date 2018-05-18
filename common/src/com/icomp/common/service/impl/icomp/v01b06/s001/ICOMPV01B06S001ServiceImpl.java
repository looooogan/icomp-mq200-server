package com.icomp.common.service.impl.icomp.v01b06.s001;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s001.ICOMPV01B06S001Service;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.VscrapDao;
import com.icomp.dao.VscrapanalysisDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Vscrap;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  报废分析SERVICE实现类
 * @ClassName: ICOMPV01B06S001ServiceImpl 
 * @author Taoyy
 * @date 2014-8-22 上午09:18:17
 */

public class ICOMPV01B06S001ServiceImpl extends BaseService implements ICOMPV01B06S001Service {
	/**
	 * 报废分析DAO
	 */
	private VscrapanalysisDao vscrapanalysisDao;
	private VscrapDao vscrapDao;
	private BusinessDao businessDao;

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public void setVscrapanalysisDao(VscrapanalysisDao vscrapanalysisDao) {
		this.vscrapanalysisDao = vscrapanalysisDao;
	}

	public void setVscrapDao(VscrapDao vscrapDao) {
		this.vscrapDao = vscrapDao;
	}

	public Map<String, Object> getList(Vscrap entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Vscrap vscrap = null;
		try {
			//列表-ToolCode模糊查询
			List<Vscrap> list = (List<Vscrap>) vscrapDao.searchByList(entity);
			for (Vscrap scraplist : list) {
//				"最后业务流程"
				scraplist.setToolType(String.valueOf(scraplist.getToolType().charAt(0)));
				String businessFlowLnkID = scraplist.getBusinessID();
				String businessFlowLnkName = null;
				if (IConstant.C03S001.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C03S001_TEXT;
				} else if (IConstant.C01S011.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S011_TEXT;
				} else if (IConstant.C01S013.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S013_TEXT;
				} else if (IConstant.C01S010.equals(businessFlowLnkID)) {
					businessFlowLnkName ="刀具换装";
				} else if (IConstant.C01S014.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S014_TEXT;
				} else if (IConstant.C01S018.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S018_TEXT;
				} else if (IConstant.C01S027.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S027_TEXT;
				} else if (IConstant.C01S016.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S016_TEXT;
				} else if (IConstant.C01S005.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S005_TEXT;
				} else if (IConstant.C01S020.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S020_TEXT;
				} else if (IConstant.C01S019.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S019_TEXT;
				}
				//2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
				else if (IConstant.C01S004.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S004_TEXT;
				}
				else if (IConstant.C01S005.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S005_TEXT;
				}
				else if (IConstant.C01S008.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S008_TEXT;
				}

				else if (IConstant.C01S009.equals(businessFlowLnkID)) {
					businessFlowLnkName =IConstant.C01S009_TEXT;
				}
				//2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
				scraplist.setBusinessName(businessFlowLnkName);
			}
			if (list.size() <= 0) {
				list = new ArrayList<Vscrap>();
				vscrap = new Vscrap();
				vscrap.setMessageCode(IConstant.EMSG0001);
				vscrap.setRetErrFlag(true);
				list.add(vscrap);
				rtn.put("rows", null);
				rtn.put("error", list);

			} else {
				//总数量
				int total = vscrapDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			List<Vscrap> list = new ArrayList<Vscrap>();
			vscrap = new Vscrap();
			vscrap.setMessageCode(IConstant.EMSG0004);
			vscrap.setRetErrFlag(true);
			vscrap.setExceMessage(e.getMessage());
			list.add(vscrap);
			rtn.put("rows", null);
			rtn.put("error", list);

		}
		return rtn;
	}

	/**
	 * 报废分析列表
	 */
//	public Map<String, Object> getLists(Vscrapanalysis entity) {
//		Map<String, Object> rtn = new HashMap<String, Object>();
//		try {
//			int d = 0;
//			int t = 0;
//			List<Vscrapanalysis> list =  (List<Vscrapanalysis>) vscrapanalysisDao.getStatisticalCount(entity);
//
//			if (list.size() <= 0) {
//				list = new ArrayList<Vscrapanalysis>();
//				Vscrapanalysis vscrapanalysis = new Vscrapanalysis();
//				vscrapanalysis.setMessageCode(IConstant.EMSG0001);
//				vscrapanalysis.setRetErrFlag(true);
//				list.add(vscrapanalysis);
//				rtn.put("rows", null);
//				rtn.put("error", list);
//				return rtn;
//			} else {
//				for (Vscrapanalysis vs  : list) {
//					//断刀
//					if (IConstant.TOOL_STATE_0.equals(vs.getToolState())) {
//						d++;
//						//丢失
//					} else if (IConstant.TOOL_STATE_1.equals(vs.getToolState())) {
//						t++;
//					}
//				}
//				rtn.put("rows", d);
//				rtn.put("total", t);
//				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
//				return rtn;
//			}
//
//		} catch (SQLException e) {
//			List<Vscrapanalysis> list = new ArrayList<Vscrapanalysis>();
//			Vscrapanalysis vscrapanalysis = new Vscrapanalysis();
//			vscrapanalysis.setMessageCode(IConstant.EMSG0004);
//			vscrapanalysis.setRetErrFlag(true);
//			vscrapanalysis.setExceMessage(e.getMessage());
//			list.add(vscrapanalysis);
//			rtn.put("rows", null);
//			rtn.put("error", list);
//			return rtn;
//		}
//	}

	@Override
	/**
	 * 丢失
	 */
	public String getStatisticalCount(Vscrap entity) {
//		0.断刀1.丢刀2.到寿3.其他(吴哥说的)
		int d = 0;
		int t = 0;
	    int s = 0;
	    int c = 0;
	    int q = 0;
		try {
			for (Vscrap vs  : (List<Vscrap>) vscrapDao.searchByList(entity)) {
				//断刀
				if (IConstant.TOOL_STATE_0.equals(vs.getScrapCause())) {
					d++;
				//丢失
				}else if (IConstant.TOOL_STATE_1.equals(vs.getScrapCause())) {
					t++;
				}else  if (IConstant.TOOL_STATE_2.equals(vs.getScrapCause())){
					s++;
				}else  if (IConstant.TOOL_STATE_3.equals(vs.getScrapCause())){
					q++;
				}
			} 
		} catch (SQLException e) {
			List<Vscrap> list = new ArrayList<Vscrap>();
		}
			
		return d+","+t+","+s+","+q;
	}

	@Override
	public List<Business> getBusinessList() {

		try {
			Business entity = new Business();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			List<Business> list = (List<Business>) businessDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Business>();
				Business business = new Business();
				// 消息：检索为0
				business.setMessageCode(IConstant.EMSG0001);
				business.setRetErrFlag(false);
				list.add(business);
				return list;
			} else {
				return list;
			}

		} catch (SQLException e) {
			List<Business> list = new ArrayList<Business>();
			Business business = new Business();
			// 错误消息：数据库操作异常，查询失败!
			business.setMessageCode(IConstant.EMSG0004);
			business.setRetErrFlag(true);
			business.setExceMessage(e.getMessage());
			list.add(business);
			return list;
		}
	}

	@Override
	public String getNumber() {
		int total = 0;
		Vscrap vs = new Vscrap();
		vs.setDelFlag(IConstant.DEL_FLAG_0);
		try {
			total=vscrapDao.searchByCount(vs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(total);
	}


}
