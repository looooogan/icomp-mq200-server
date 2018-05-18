package com.icomp.common.service.impl.icomp.v01b04.s005;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b04.s005.ICOMPV01B04S005Service;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 车间工作量汇总SERVICES实现类
 * 
 * @ClassName: ICOMPV01B03S005ServiceImpl
 * @author Taoyy
 * @date 2014-8-20 下午04:43:14
 */
public class ICOMPV01B04S005ServiceImpl extends BaseService implements ICOMPV01B04S005Service {
	DateFormat format_year = new SimpleDateFormat("yyyy");
	DateFormat format_month = new SimpleDateFormat("yyyy-MM");
	DateFormat format_day= new SimpleDateFormat("yyyy-MM-dd");
	public final static int YEAR = 1;
	public final static int MONTH = 2;
	public final static int WEEK = 3;
	public final static int DAY = 4;
	/**
	 * 车间工作量汇总DAO
	 */
	private AssemblylineDao assemblylineDao;
	private AxleDao axleDao;
	private ProcessDao processDao;
	private EquipmentDao equipmentDao;
	private PartsDao partsDao;
 	private SynthesistoolsmachiningDao synthesistoolsmachiningDao;
	private VsynthesistoolsmachiningDao vsynthesistoolsmachiningDao;
	private VworkshopsummaryDao vworkshopsummaryDao;

	public void setPartsDao(PartsDao partsDao) {
		this.partsDao = partsDao;
	}

	public void setEquipmentDao(EquipmentDao equipmentDao) {
		this.equipmentDao = equipmentDao;
	}

	public void setAxleDao(AxleDao axleDao) {
		this.axleDao = axleDao;
	}

	public void setProcessDao(ProcessDao processDao) {
		this.processDao = processDao;
	}

	public void setAssemblylineDao(AssemblylineDao assemblylineDao) {

		this.assemblylineDao = assemblylineDao;
	}

	public void setVworkshopsummaryDao(VworkshopsummaryDao vworkshopsummaryDao) {
		this.vworkshopsummaryDao = vworkshopsummaryDao;
	}

	public void setVsynthesistoolsmachiningDao(
			VsynthesistoolsmachiningDao vsynthesistoolsmachiningDao) {
		this.vsynthesistoolsmachiningDao = vsynthesistoolsmachiningDao;
	}

	public void setSynthesistoolsmachiningDao(SynthesistoolsmachiningDao synthesistoolsmachiningDao) {
		this.synthesistoolsmachiningDao = synthesistoolsmachiningDao;
	}

	public Map<String, Object> getList(Vsynthesistoolsmachining entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		entity.setOrderString(IConstant.OUTER_TIME);
		int type = Integer.parseInt(entity.getSummary());
	
		try {
			List<Vsynthesistoolsmachining> list = new  ArrayList<Vsynthesistoolsmachining>();
			switch (type) {
			case YEAR:
				entity.setYear(IConstant.OUTER_TIME);
				list = (List<Vsynthesistoolsmachining>) vsynthesistoolsmachiningDao.searchSummaryByTime(entity);
				for (Vsynthesistoolsmachining ss : list) {
					ss.setOutDate((format_year.format(ss.getOuterTime())));
				}
				break;
			case MONTH:
				entity.setMonth(IConstant.OUTER_TIME);
				list = (List<Vsynthesistoolsmachining>) vsynthesistoolsmachiningDao.searchSummaryByTime(entity);
				for (Vsynthesistoolsmachining ss : list) {
					ss.setOutDate((format_month.format(ss.getOuterTime())));
				}
				break;
			case DAY:
				entity.setDay(IConstant.OUTER_TIME);
				list = (List<Vsynthesistoolsmachining>) vsynthesistoolsmachiningDao.searchSummaryByTime(entity);
				for (Vsynthesistoolsmachining ss : list) {
					ss.setOutDate((format_day.format(ss.getOuterTime())));
				}
				break;
			default:
				break;
			}
			
			if (list.size() <= 0) {
				list = new ArrayList<Vsynthesistoolsmachining>();
				entity.setMessageCode(IConstant.EMSG0001);
				entity.setRetErrFlag(true);
				list.add(entity);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = 0;
				// 数量
				if (type != WEEK) {
					 total = ((List<Vsynthesistoolsmachining>) vsynthesistoolsmachiningDao.searchSummaryCount(entity)).size();
				}else {
					 total = list.size();
				}
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			List<Vsynthesistoolsmachining> list = new ArrayList<Vsynthesistoolsmachining>();
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			list.add(entity);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> getLists(Vworkshopsummary entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//模糊查询
			List<Vworkshopsummary> list = (List<Vworkshopsummary>) vworkshopsummaryDao.searchByList1(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vworkshopsummary>();
				Vworkshopsummary vworkshopsummary = new Vworkshopsummary();
				vworkshopsummary.setMessageCode(IConstant.EMSG0001);
				vworkshopsummary.setRetErrFlag(true);
				list.add(vworkshopsummary);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {

				int total = vworkshopsummaryDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			List<Vworkshopsummary> list = new ArrayList<Vworkshopsummary>();
			Vworkshopsummary vworkshopsummary = new Vworkshopsummary();
			vworkshopsummary.setMessageCode(IConstant.EMSG0004);
			vworkshopsummary.setRetErrFlag(true);
			vworkshopsummary.setExceMessage(e.getMessage());
			list.add(vworkshopsummary);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
		return rtn;
	}


	public List<Assemblyline> getAssemblyline(){
	Assemblyline entity = null;
		Assemblyline assemblyline = null;
		try {
			entity = new Assemblyline();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			List<Assemblyline> list = (List<Assemblyline>) assemblylineDao.searchByList(entity);

//			for (Equipment equipment : list2) {
//				list.add(equipment);
//			}
			if (list.size() <= 0) {
				list = new ArrayList<Assemblyline>();
				 assemblyline = new Assemblyline();
				// 消息：检索为0
				assemblyline.setMessageCode(IConstant.EMSG0001);
				assemblyline.setRetErrFlag(false);
				list.add(assemblyline);
				return list;
			}
			return list;

		} catch (SQLException e) {
			List<Assemblyline> list = new ArrayList<Assemblyline>();
			 assemblyline = new Assemblyline();
			// 错误消息：数据库操作异常，查询失败!
			assemblyline.setMessageCode(IConstant.EMSG0004);
			assemblyline.setRetErrFlag(true);
			assemblyline.setExceMessage(e.getMessage());
			list.add(assemblyline);
			return list;
		}

	}

	@Override
	public String getNumber() {
		int total =0;
		try {
			total = vworkshopsummaryDao.searchByCount(new Vworkshopsummary());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(total);
	}

	@Override
	public List<Axle> getAxleLine() {
		List<Axle> list = null;
		Axle axle = null;
		Axle entity = null;
		try {
			entity = new Axle();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			list = (List<Axle>) axleDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Axle>();
				axle = new Axle();
				// 消息：检索为0
				axle.setMessageCode(IConstant.EMSG0001);
				axle.setRetErrFlag(false);
				list.add(axle);
			}
		} catch (SQLException e) {
			list = new ArrayList<Axle>();
			axle = new Axle();
			// 错误消息：数据库操作异常，查询失败!
			axle.setMessageCode(IConstant.EMSG0004);
			axle.setRetErrFlag(true);
			axle.setExceMessage(e.getMessage());
			list.add(axle);
		}
		return list;


	}

	@Override
	public List<Process> getProcess() {
		try {
			Process entity = new Process();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			entity.setOrderString("processName");
			List<Process> list = (List<Process>) processDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Process>();
				Process process = new Process();
				// 消息：检索为0
				process.setMessageCode(IConstant.EMSG0001);
				process.setRetErrFlag(false);
				list.add(process);
				return list;
			} else {
				return list;
			}

		} catch (SQLException e) {
			List<Process> list = new ArrayList<Process>();
			Process process = new Process();
			// 错误消息：数据库操作异常，查询失败!
			process.setMessageCode(IConstant.EMSG0004);
			process.setRetErrFlag(true);
			process.setExceMessage(e.getMessage());
			list.add(process);
			return list;
		}
	}

	@Override
	public List<Equipment> getEquipment() {
		try {
			Equipment entity = new Equipment();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			entity.setEquipmentType(IConstant.EQUIPMENT_TYPES_0);
			entity.setOrderString("equipmentName");
			List<Equipment> list = (List<Equipment>) equipmentDao
					.searchByList(entity);
			entity = new Equipment();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			entity.setEquipmentType(IConstant.EQUIPMENT_TYPES_2);
			List<Equipment> list2 = (List<Equipment>) equipmentDao
					.searchByList(entity);
			for (Equipment equipment : list2) {
				list.add(equipment);
			}
			if (list.size() <= 0) {
				list = new ArrayList<Equipment>();
				Equipment equipment = new Equipment();
				// 消息：检索为0
				equipment.setMessageCode(IConstant.EMSG0001);
				equipment.setRetErrFlag(false);
				list.add(equipment);
				return list;
			} else {
				return list;
			}

		} catch (SQLException e) {
			List<Equipment> list = new ArrayList<Equipment>();
			Equipment equipment = new Equipment();
			// 错误消息：数据库操作异常，查询失败!
			equipment.setMessageCode(IConstant.EMSG0004);
			equipment.setRetErrFlag(true);
			equipment.setExceMessage(e.getMessage());
			list.add(equipment);
			return list;
		}
	}



	@Override
	public List<Parts> getParts() {
		Parts entity = null;
		Parts parts = null;
		try {
			entity = new Parts();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			List<Parts> list = (List<Parts>) partsDao.searchByList(entity);

//			for (Equipment equipment : list2) {
//				list.add(equipment);
//			}
			if (list.size() <= 0) {
				list = new ArrayList<Parts>();
				parts = new Parts();
				// 消息：检索为0
				parts.setMessageCode(IConstant.EMSG0001);
				parts.setRetErrFlag(false);
				list.add(parts);
				return list;
			}
			return list;

		} catch (SQLException e) {
			List<Parts> list = new ArrayList<Parts>();
			parts = new Parts();
			// 错误消息：数据库操作异常，查询失败!
			parts.setMessageCode(IConstant.EMSG0004);
			parts.setRetErrFlag(true);
			parts.setExceMessage(e.getMessage());
			list.add(parts);
			return list;
		}

	}


	/**
	 * 周工作量汇总
	 * 
	 * @title getWeekSummary
	 * @param entity
	 * @return List<Synthesistoolsmachining>
	 * @throws SQLException
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	private List<Synthesistoolsmachining> getWeekSummary(Synthesistoolsmachining entity) throws SQLException {
		List<Synthesistoolsmachining> list1 = new ArrayList<Synthesistoolsmachining>();
		List<Synthesistoolsmachining> list2 = new ArrayList<Synthesistoolsmachining>();

		Date beginTimeDate = new Date(114, 7, 1);
		Date endTimeDate = new Date();
		// Date beginTimeDate = entity.getBeginTime();
		// Date endTimeDate = entity.getEndTime();
		Date endDate = null;
		GregorianCalendar gc = new GregorianCalendar();
	//	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 时间段
		while (beginTimeDate.getTime() < endTimeDate.getTime()) {
			//System.out.println("1111--" + sf.format(beginTimeDate));
			gc.setTime(beginTimeDate);
			gc.add(4, +1);// 加一周
			gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
			endDate = gc.getTime();
			//System.out.println("2222--" + sf.format(gc.getTime()));
			// 开始 时间 条件
			//entity.setBeginTime(beginTimeDate);
			// 结束时间条件
		//	entity.setEndTime(endDate);
			list1 = (List<Synthesistoolsmachining>) synthesistoolsmachiningDao.searchSummaryByTime(entity);
			if (list1.get(0).getProcessAmount() != null) {
				list2.add(list1.get(0));
			}
			beginTimeDate = endDate;
		}

		return list2;
	}

}
