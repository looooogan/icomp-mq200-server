package com.icomp.common.service.impl.icomp.v01b03.s001;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b03.s001.ICOMPV01B03S001Service;
import com.icomp.dao.UserdetailDao;
import com.icomp.dao.VgrindingrecordDao;
import com.icomp.dao.VtoolnoticehistoryDao;
import com.icomp.entity.base.Userdetail;
import com.icomp.entity.base.Vgrindingrecord;
import com.icomp.entity.base.Vtoolnoticehistory;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刃磨记录查询SERVICE实现类
 * 
 * @ClassName: ICOMPV01B03S001ServiceImpl
 * @author Taoyy
 * @date 2014-8-20 下午03:41:04
 */
public class ICOMPV01B03S001ServiceImpl extends BaseService implements ICOMPV01B03S001Service {
	/**
	 * 刃磨记录查询DAO
	 */
	private VgrindingrecordDao vgrindingrecordDao;
	private UserdetailDao userdetailDao;

	public UserdetailDao getUserdetailDao() {
		return userdetailDao;
	}

	public void setUserdetailDao(UserdetailDao userdetailDao) {
		this.userdetailDao = userdetailDao;
	}

	public void setVgrindingrecordDao(VgrindingrecordDao vgrindingrecordDao) {
		this.vgrindingrecordDao = vgrindingrecordDao;
	}


	public Map<String, Object> getList(Vgrindingrecord entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//列表-ToolCode模糊查询
			List<Vgrindingrecord> list = (List<Vgrindingrecord>) vgrindingrecordDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vgrindingrecord>();
				Vgrindingrecord vgrindingrecord = new Vgrindingrecord();
				vgrindingrecord.setMessageCode(IConstant.EMSG0001);
				vgrindingrecord.setRetErrFlag(true);
				list.add(vgrindingrecord);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Vgrindingrecord vr : list) {
					//折旧金额计算 
					vr.setDepreciationAmount(getMoney(vr));
					//约当产量计算
					vr.setSalvageValue(getSalvageVal(vr));
					//计算加工量
					vr.setAvgNum(getAvgNum(vr));
				}
				//数量
				int total = vgrindingrecordDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			List<Vgrindingrecord> list = new ArrayList<Vgrindingrecord>();
			Vgrindingrecord vgrindingrecord = new Vgrindingrecord();
			vgrindingrecord.setMessageCode(IConstant.EMSG0004);
			vgrindingrecord.setRetErrFlag(true);
			vgrindingrecord.setExceMessage(e.getMessage());
			list.add(vgrindingrecord);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
		return rtn;
	}

	private VtoolnoticehistoryDao vtoolnoticehistoryDao;

	public void setVtoolnoticehistoryDao(VtoolnoticehistoryDao vtoolnoticehistoryDao) {
		this.vtoolnoticehistoryDao = vtoolnoticehistoryDao;
	}

	@Override
	public Map<String, Object> getListtool(Vtoolnoticehistory entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Vtoolnoticehistory vtoolnoticehistory= null;
		try {
			//列表-ToolCode模糊查询
			List<Vtoolnoticehistory> list = vtoolnoticehistoryDao.searchByList(entity);
			for (Vtoolnoticehistory vtslist : list) {
				vtslist.setToolType(String.valueOf(vtslist.getToolType().charAt(0)));
			}

			if (list.size() <= 0) {
				list = new ArrayList<Vtoolnoticehistory>();
				vtoolnoticehistory = new Vtoolnoticehistory();
				vtoolnoticehistory.setMessageCode(IConstant.EMSG0001);
				vtoolnoticehistory.setRetErrFlag(true);
				list.add(vtoolnoticehistory);
				rtn.put("rows", null);
				rtn.put("error", list);

			} else {
				//数量
				int total = vtoolnoticehistoryDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
			}
		} catch (SQLException e) {
			List<Vtoolnoticehistory> list = new ArrayList<Vtoolnoticehistory>();
			 vtoolnoticehistory = new Vtoolnoticehistory();
			vtoolnoticehistory.setMessageCode(IConstant.EMSG0004);
			vtoolnoticehistory.setRetErrFlag(true);
			vtoolnoticehistory.setExceMessage(e.getMessage());
			list.add(vtoolnoticehistory);
			rtn.put("rows", null);
			rtn.put("error", list);
		}
		return rtn;
	}

	@Override
	public String getNumber() {
		int total=0;
		try {
			total = vtoolnoticehistoryDao.searchByCount(new Vtoolnoticehistory());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(total);
	}

	@Override
	public List<Userdetail> getUsner(Userdetail user) {
		List<Userdetail> userdetailList=null;
		try {
			userdetailList =(List<Userdetail>) userdetailDao.searchByList(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userdetailList;
	}

	/**
	 * 约当产量计算(残值)
	 * 如果是钻头： 修复后测量长度/刀具可刃磨原长度*单价
	 * 如果是刀片：可使用次数/标准次数*单价
	 * @title getSalvageVal 
	 * @param vr
	 * @return
	 * String
	 */
	private String getSalvageVal(Vgrindingrecord vr) {
		DecimalFormat df = new DecimalFormat("#.00");
		Double double1=new Double(0);
		if(vr.gettoolConsumetype().equals(IConstant.STRING_1)
				||vr.gettoolConsumetype().equals(IConstant.STRING_2)){
			//刀片类的
			if(vr.getToolSharpennum()!=null&&vr.getUnitPrice()!=null&&vr.getstandardTimes()!=null)
			double1=(vr.getToolSharpennum().doubleValue()*vr.getUnitPrice().doubleValue())/vr.getstandardTimes().doubleValue();
		}else if (vr.gettoolConsumetype().equals(IConstant.STRING_0)){
			//钻头类的
			if(vr.getNoticeOldLength()!=null&&vr.getUnitPrice()!=null&&vr.getToolLength()!=null){
			  double1  =((vr.getNoticeOldLength().doubleValue())*((vr.getUnitPrice().doubleValue())/(vr.getToolLength().doubleValue())));
			}
		}
		return df.format(double1);
	}

	/**
	 * 获取折旧金额 
	 * (已使用次数/标准次数)* 单价
	 * @title getMoney 
	 * @param vr
	 * @return
	 * String
	 */
	private String getMoney(Vgrindingrecord vr) {
		 DecimalFormat df = new DecimalFormat("#.00");
		 Double dou=new Double(0);
		 if(vr.getUsageCounter()!=null&&vr.getstandardTimes()!=null&&vr.getUnitPrice()!=null){
			 dou = (vr.getUsageCounter().doubleValue()/vr.getstandardTimes().doubleValue())*vr.getUnitPrice().doubleValue();
		 }
		return df.format(dou);
	}
	
	/**
	 * 计算加工量
	 * @title getAvgNum 
	 * @param vr
	 * @return
	 * String
	 */
	private String getAvgNum(Vgrindingrecord vr) {
		 DecimalFormat df = new DecimalFormat("#0.00");
		 Double dou=new Double(0);
		 if(vr.getconsumedCount()!=null 
				 && !vr.getconsumedCount().equals(BigDecimal.ZERO)
				 &&vr.getProcessAmount()!=null
				 &&!vr.getProcessAmount().equals(BigDecimal.ZERO)){
			 //(每种刀具)实际加工总数量/(每种)刀具消耗总数量
			 dou = (vr.getProcessAmount().doubleValue())/(vr.getconsumedCount().doubleValue());
		 }
		return df.format(dou);
	}	
	

}
