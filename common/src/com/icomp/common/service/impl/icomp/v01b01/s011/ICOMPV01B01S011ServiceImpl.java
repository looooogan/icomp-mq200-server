package com.icomp.common.service.impl.icomp.v01b01.s011;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s011.ICOMPV01B01S011Service;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.ToolalarmparamDao;
import com.icomp.dao.VtransitalarmDao;
import com.icomp.entity.base.Toolalarmparam;
import com.icomp.entity.base.Vtransitalarm;
/**
 * 在途计划报警查询SERVICE实现类
 * @ClassName: ICOMPV01B01S011ServiceImpl 
 * @author Taoyy
 * @date 2014-8-15 下午06:11:19
 */
public class ICOMPV01B01S011ServiceImpl extends BaseService implements ICOMPV01B01S011Service {
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
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
	 * 告警参数配置
	 */
	ToolalarmparamDao toolalarmparamDao;
	
	public void setToolalarmparamDao(ToolalarmparamDao toolalarmparamDao) {
		this.toolalarmparamDao = toolalarmparamDao;
	}

	/**
	 * 在途计划报警查询Dao
	 */
	private VtransitalarmDao vtransitalarmDao;
	public void setVtransitalarmDao(VtransitalarmDao vtransitalarmDao) {
		this.vtransitalarmDao = vtransitalarmDao;
	}


	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 在途计划报警查询列表
	 */
	public Map<String, Object> getList(Vtransitalarm entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vtransitalarm> list = (List<Vtransitalarm>) vtransitalarmDao.searchByList(entity);
			
			//在途计划告警参数
			Toolalarmparam param=new Toolalarmparam();
			param.setToolAlarmType(IConstant.STRING_1);
			List<Toolalarmparam> paramlist=(List<Toolalarmparam> ) toolalarmparamDao.searchByList(param);
			BigDecimal TransitPlanningAlarm=BigDecimal.ONE;
			
			if (list.size() <= 0) {
				list = new ArrayList<Vtransitalarm>();
				Vtransitalarm vtransitalarm = new Vtransitalarm();
				vtransitalarm.setMessageCode(IConstant.EMSG0001);
				vtransitalarm.setRetErrFlag(true);
				list.add(vtransitalarm);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Toolalarmparam pa : paramlist) {
					TransitPlanningAlarm=pa.getToolAlarmRatio();
				}
			}
			if (list.size() <= 0) {
				list = new ArrayList<Vtransitalarm>();
				Vtransitalarm vtransitalarm = new Vtransitalarm();
				vtransitalarm.setMessageCode(IConstant.EMSG0001);
				vtransitalarm.setRetErrFlag(true);
				list.add(vtransitalarm);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				//对数据进行操作
				for (Vtransitalarm v : list) {
					//逾期天数
					if(v.getTheyTime()!=null)
					v.setDayCount(getTheyDays(v.getTheyTime().substring(0,19)));
					//是否逾期
					if(v.getTheyTime()!=null)
					v.setRetErrFlag(getTheyStatus(v.getTheyTime().substring(0,19),TransitPlanningAlarm));
					//设定预计到货时间
					if(v.getTheyTime()!=null)
					v.setTheyTime(v.getTheyTime().substring(0,10));
				}
				int total = vtransitalarmDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtransitalarm> list = new ArrayList<Vtransitalarm>();
			Vtransitalarm vtransitalarm = new Vtransitalarm();
			vtransitalarm.setMessageCode(IConstant.EMSG0004);
			vtransitalarm.setRetErrFlag(true);
			vtransitalarm.setExceMessage(e.getMessage());
			list.add(vtransitalarm);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
	

	/**
	 * 是否逾期
	 * @title getTheyStatus 
	 * @param theyTime
	 * @return
	 * String
	 */
	private boolean getTheyStatus(String theyTime,BigDecimal TransitPlanningAlarm) {
		//是否逾期
			boolean ret =false;
			try {
				int Ratiio =TransitPlanningAlarm.intValue();
				int theyDays=Integer.parseInt(getTheyDays(theyTime));
				if(theyDays>Ratiio){
					ret=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return ret;
			}
			return ret;
	}

	/**
	 * 逾期天数
	 * @title getTheyStatus 
	 * @param theyTime
	 * @return
	 * String
	 */
	private String getTheyDays(String theyTime) {
		long theyDays;
			try {
				
				//当前时间
				long currentTime=(long)System.currentTimeMillis();
				// 一天的秒数
				long daytime=Long.parseLong(IConstant.DAYS_MILLI_SECOND);
				//预计到货时间
				long theTime=(long)sf.parse(theyTime).getTime();
				//逾期天数 = (当前时间 - 预计到货时间)/一天的秒数
				theyDays = ((currentTime-theTime) /daytime);
			} catch (Exception e) {
				e.printStackTrace();
				return e.toString();
			}
			return theyDays+"";
	}
	
	
	
}
