package com.icomp.common.service.impl.icomp.v01b06.s008;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s008.ICOMPV01B06S008Service;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.CapitalTakesDao;
import com.icomp.dao.VpriceDao;
import com.icomp.entity.base.CapitalTakes;
import com.icomp.entity.base.Vprice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具资金占用情况分析SERVICES实现类
 * 
 * @ClassName: ICOMPV01B06S008ServiceImpl
 * @author Taoyy
 * @date 2014-8-22 上午10:23:06
 */
public class ICOMPV01B06S008ServiceImpl extends BaseService implements
		ICOMPV01B06S008Service {

	private VpriceDao vpriceDao;
	private CapitalTakesDao capitalTakesDao;

	public void setCapitalTakesDao(CapitalTakesDao capitalTakesDao) {
		this.capitalTakesDao = capitalTakesDao;
	}

	public void setVpriceDao(VpriceDao vpriceDao) {
		this.vpriceDao = vpriceDao;
	}
	@SuppressWarnings("unused")
	private BusinessflowlnkDao businessflowlnkDao;

	public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
		this.businessflowlnkDao = businessflowlnkDao;
	}

	@SuppressWarnings("unused")
	private BusinessDao businessDao;

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}


	public Map<String, Object> getList(Vprice entity, String langCode) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			//toolCode模糊查询
			List<Vprice> list = (List<Vprice>) vpriceDao.searchByList_F(entity);
			if (list.size() <= 0) {
				List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("stockPrice", 0);//库房
				data.put("toolRoomPrice", 0);//对刀室
				data.put("dressingPrice", 0);//刃磨室
				data.put("farmPrice", 0);//车间
				ret.add(data);
				rtn.put("rows", ret);
				return rtn;
			} else {
				float stockPrice = 0, toolRoomPrice = 0, dressingPrice = 0, farmPrice = 0;
				// 总数量
				for (Vprice v : list) {
						String flowlnkID = v.getBusinessCode();
						if (flowlnkID == null ||flowlnkID.equals("")) {
							// 当前流程不存在!
							rtn.put("agreeFlag", false);
							rtn.put("messageCode", IConstant.WMSG0119);
							return rtn;
						}
						if (v.getBusinessCode().equals("C01S001")) {
							stockPrice += v.getUnitPrice().floatValue();
						}
						if ("C01S002".equals(v.getBusinessCode())) {// 配套出库
																			// 对刀室
							toolRoomPrice += v.getUnitPrice().floatValue();
						} else if ("C01S003".equals(v.getBusinessCode())) {// 刀具换领
																					// 库房
							stockPrice += v.getUnitPrice().floatValue();
						} else if ("C01S004".equals(v.getBusinessCode())) {// 刀具申领
																					// 对刀室
							toolRoomPrice += v.getUnitPrice().floatValue();
						} else if ("C01S005".equals(v.getBusinessCode())) {// 换领申请
																					// 对刀室
							toolRoomPrice += v.getUnitPrice().floatValue();
						} else if ("C01S006".equals(v.getBusinessCode())) {// 刀具返厂
																					// 库房
							stockPrice += v.getUnitPrice().floatValue();
						} else if ("C01S007".equals(v.getBusinessCode())) {// 刀具封存
																					// 库房
							stockPrice += v.getUnitPrice().floatValue();
						} else if ("C01S008".equals(v.getBusinessCode())) {// 刀具卸下辅具
																					// 对刀室
							toolRoomPrice += v.getUnitPrice().floatValue();
						} else if ("C01S009".equals(v.getBusinessCode())) {// 刀具送回车间
																					// 车间
							farmPrice += v.getUnitPrice().floatValue();
						} else if ("C01S010".equals(v.getBusinessCode())) {// 刀具安上辅具
																					// 对刀室
							toolRoomPrice += v.getUnitPrice().floatValue();
						} else if ("C01S011".equals(v.getBusinessCode())) {// 设备安上
																					// 车间
							farmPrice += v.getUnitPrice().floatValue();
						} else if ("C01S012".equals(v.getBusinessCode())) {// 旧刀回收
																					// 对刀室
							toolRoomPrice += v.getUnitPrice().floatValue();
						} else if ("C01S013".equals(v.getBusinessCode())) {// 设备卸下
																					// 车间
							farmPrice += v.getUnitPrice().floatValue();
						} else if ("C01S014".equals(v.getBusinessCode())) {// 刀具修复通知单
																					// 库房
							stockPrice += v.getUnitPrice().floatValue();
						} else if ("C01S015".equals(v.getBusinessCode())) {// 回库刀具处理
																					// 库房
							stockPrice += v.getUnitPrice().floatValue();
						} else if ("C01S016".equals(v.getBusinessCode())) {// 旧刀入库交接
																					// 库房
							stockPrice += v.getUnitPrice().floatValue();
						} else if ("C01S017".equals(v.getBusinessCode())) {// 刀具复磨卸下
																					// 刃磨室
							dressingPrice += v.getUnitPrice().floatValue();
						} else if ("C01S018".equals(v.getBusinessCode())) {// 刀具复磨安上
																					// 刃磨室
							dressingPrice += v.getUnitPrice().floatValue();
						} else if ("C01S019".equals(v.getBusinessCode())) {// 刀身打码
																					// 库房
							stockPrice += v.getUnitPrice().floatValue();
						} else if ("C01S020".equals(v.getBusinessCode())) {// 回厂识别
																					// 库房
							stockPrice += v.getUnitPrice().floatValue();
						} else if ("C01S021".equals(v.getBusinessCode())) {// 修复通知领取
																					// 刃磨室
							dressingPrice += v.getUnitPrice().floatValue();
						} else if ("C01S022".equals(v.getBusinessCode())) {// 异常刀具处理
																					// 对刀室
							toolRoomPrice += v.getUnitPrice().floatValue();
						} else if ("C01S025".equals(v.getBusinessCode())) {// 对刀开始
																					// 对刀室
							toolRoomPrice += v.getUnitPrice().floatValue();
						} else if ("C01S026".equals(v.getBusinessCode())) {// 对刀结束
																					// 对刀室
							toolRoomPrice += v.getUnitPrice().floatValue();
						} else { // 库房
							stockPrice += v.getUnitPrice().floatValue();
						}
				}
				List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("stockPrice", stockPrice);//库房
				data.put("toolRoomPrice", toolRoomPrice);//对刀室
				data.put("dressingPrice", dressingPrice);//刃磨室
				data.put("farmPrice", farmPrice);//车间
				ret.add(data);
				rtn.put("rows", ret);
				return rtn;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			rtn.put("agreeFlag", false);
			rtn.put("messageCode", IConstant.EMSG0004);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> getLists(CapitalTakes entity, String langCode) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//任意条件查询-toolCode模糊查询
			List<CapitalTakes> list = (List<CapitalTakes>) capitalTakesDao.searchByList(entity);

			if (list.size() <= 0) {
				list = new ArrayList<CapitalTakes>();
				CapitalTakes capitalTakes = new CapitalTakes();
				capitalTakes.setMessageCode(IConstant.EMSG0001);
				capitalTakes.setRetErrFlag(true);
				list.add(capitalTakes);
				rtn.put("rows", null);
				rtn.put("error", list);

			} else {
//				for (CapitalTakes clist : list) {
//
//					clist.setToolType(String.valueOf(clist.getToolType().charAt(0)));
//					double cnumber  =Double.parseDouble(clist.getNumberDevices())+Double.parseDouble(clist.getNumberDevices1())+Double.parseDouble(clist.getNumberDevices2())+Double.parseDouble(clist.getNumberDevices3())+
//							Double.parseDouble(clist.getNumberDevices4())+Double.parseDouble(clist.getNumberDevices5())+Double.parseDouble(clist.getNumberDevices6())+
//							Double.parseDouble(clist.getExpandSpace1())+Double.parseDouble(clist.getExpandSpace2());
//					BigDecimal   b   =   new   BigDecimal(cnumber);
//					double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
//					clist.setSprice(String.valueOf(f1));
//				}
				int total = capitalTakesDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			List<CapitalTakes> list = new ArrayList<CapitalTakes>();
			CapitalTakes capitalTakes = new CapitalTakes();
			capitalTakes.setMessageCode(IConstant.EMSG0004);
			capitalTakes.setRetErrFlag(true);
			capitalTakes.setExceMessage(e.getMessage());
			list.add(capitalTakes);
			rtn.put("rows", null);
			rtn.put("error", list);

		}
	return rtn;
}


	@Override
	public String getStatisticalCount(CapitalTakes entity) {

		// 可刃磨钻头
		int  dou1 =100;
		// 可刃磨刀片
		int  dou2 = 10;
		// 一次性刀具
		int  dou3 = 366;
		// 其他
		int dou4 = 155;
		int dou5 = 125;
		int dou6 = 14;

		return dou1+","+dou2+","+dou3+","+dou4+","+dou5+","+dou6;
	}

	@Override
	public String getNumber() {
		int total =0;
		try {
			total = capitalTakesDao.searchByCount(new CapitalTakes());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(total);
	}

}
