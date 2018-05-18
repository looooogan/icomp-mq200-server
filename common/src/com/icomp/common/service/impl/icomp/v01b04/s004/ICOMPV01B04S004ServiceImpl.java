package com.icomp.common.service.impl.icomp.v01b04.s004;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b04.s004.ICOMPV01B04S004Service;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具消耗查询SERVICE实现类
 * @ClassName: ICOMPV01B03S004ServiceImpl 
 * @author Taoyy
 * @date 2014-8-20 下午04:29:32
 */
public class ICOMPV01B04S004ServiceImpl extends BaseService implements ICOMPV01B04S004Service {

	/**
	 * 刀具消耗查询DAO
	 */
	private VtoolconsumptionqueryDao vtoolconsumptionqueryDao;
	private VamortizationDao vamortizationDao;
	private AssemblylineDao assemblylineDao;
	private AxleDao axleDao;
	private ProcessDao processDao;
	private EquipmentDao equipmentDao;
	private PartsDao partsDao;
	private BusinessDao businessDao;
	private OplinkDao oplinkDao;
	private VoplinkdownDao voplinkdownDao;

	public void setVoplinkdownDao(VoplinkdownDao voplinkdownDao) {
		this.voplinkdownDao = voplinkdownDao;
	}

	public void setOplinkDao(OplinkDao oplinkDao) {
		this.oplinkDao = oplinkDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
		this.assemblylineDao = assemblylineDao;
	}

	public void setAxleDao(AxleDao axleDao) {
		this.axleDao = axleDao;
	}

	public void setProcessDao(ProcessDao processDao) {
		this.processDao = processDao;
	}

	public void setEquipmentDao(EquipmentDao equipmentDao) {
		this.equipmentDao = equipmentDao;
	}

	public void setPartsDao(PartsDao partsDao) {
		this.partsDao = partsDao;
	}

	public void setVtoolconsumptionqueryDao(VtoolconsumptionqueryDao vtoolconsumptionqueryDao) {
		this.vtoolconsumptionqueryDao = vtoolconsumptionqueryDao;
	}

	public void setVamortizationDao(VamortizationDao vamortizationDao) {
		this.vamortizationDao = vamortizationDao;
	}

	/**
	 * 刀具消耗查询--ToolCode模糊查询
	 */

	public Map<String, Object> getList(Vamortization entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<Vamortization> list = (List<Vamortization>) vamortizationDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vamortization>();
				Vamortization vamortization = new Vamortization();
				vamortization.setMessageCode(IConstant.EMSG0001);
				vamortization.setRetErrFlag(true);
				list.add(vamortization);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			}
				int total = vamortizationDao.searchByCount(entity);
//				for (Vamortization v : list) {
//					//计算约当产量
//					v.setResidualValue(getResidualVal(v));
//					//计算已使用金额
//					v.setTotalAmount(getTotalAmount(v));
			//-----		v.setNumer(getprocessAmount());
//				}
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			return rtn;
		} catch (SQLException e) {
			List<Vamortization> list = new ArrayList<Vamortization>();
			Vamortization vamortization = new Vamortization();
			vamortization.setMessageCode(IConstant.EMSG0004);
			vamortization.setRetErrFlag(true);
			vamortization.setExceMessage(e.getMessage());
			list.add(vamortization);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	@Override
	public int getprocessAmount() {
		//TODO 刀具消耗统计中消耗次数
		return 1;
	}


	/**
	 * 计算约当产量
	 * @title getResidualVal 
	 * @param v
	 * @return
	 * String
	 */
	private String getResidualVal(Vtoolconsumptionquery v) {
		 DecimalFormat df = new DecimalFormat("#0.00");
		 Double dou  =new Double(0);
		 if(v.getToolNum()!=null
				 &&v.getToolSharpennum()!=null
				 &&v.getUnitPrice()!=null
				 &&!v.getToolNum().equals(BigDecimal.ZERO)
				 &&!v.getToolSharpennum().equals(BigDecimal.ZERO)
				 &&!v.getUnitPrice().equals(BigDecimal.ZERO)){
			 //剩余可使用长度*(单价/总长度)
			 dou = ((v.getToolNum().doubleValue())* ((v.getUnitPrice().doubleValue())/(v.getToolSharpennum().doubleValue())));
		 }
		return df.format(dou);
	}
	
	/**
	 * 计算已使用金额
	 * @title getTotalAmount 
	 * @param v
	 * @return
	 * String
	 */
	private String getTotalAmount(Vtoolconsumptionquery v) {
		DecimalFormat df = new DecimalFormat("#0.00");
		 //(总长度-剩余可使用长度)*约当产量
		 Double dou = (v.getToolSharpennum().doubleValue() - v.getToolNum().doubleValue())*v.getUnitPrice().doubleValue() ;
		return df.format(dou);
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

	@Override
	public List<Assemblyline> getAssemblylineList(Assemblyline entity) {
		try {

			List<Assemblyline> list = (List<Assemblyline>) assemblylineDao.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Assemblyline>();
				Assemblyline assemblyline = new Assemblyline();
				assemblyline.setMessageCode(IConstant.WMSG0008);
				assemblyline.setRetErrFlag(true);
				list.add(assemblyline);
				return list;
			} else {
				return list;
			}

		} catch (SQLException e) {
			List<Assemblyline> list = new ArrayList<Assemblyline>();
			Assemblyline assemblyline = new Assemblyline();
			assemblyline.setMessageCode(IConstant.EMSG0004);
			assemblyline.setRetErrFlag(true);
			assemblyline.setExceMessage(e.getMessage());
			list.add(assemblyline);
			return list;
		}
	}

	@Override
	public List<Voplinkdown> getVoplinList(Voplinkdown entity) {
		try {

			List<Voplinkdown> list = (List<Voplinkdown>) voplinkdownDao.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Voplinkdown>();
				Voplinkdown voplinkdown = new Voplinkdown();
				voplinkdown.setMessageCode(IConstant.WMSG0008);
				voplinkdown.setRetErrFlag(false);
				list.add(voplinkdown);
				return list;
			} else {
				return list;
			}

		} catch (SQLException e) {
			List<Voplinkdown> list = new ArrayList<Voplinkdown>();
			Voplinkdown voplinkdown = new Voplinkdown();
			voplinkdown.setMessageCode(IConstant.EMSG0004);
			voplinkdown.setRetErrFlag(true);
			voplinkdown.setExceMessage(e.getMessage());
			list.add(voplinkdown);
			return list;
		}
	}

	@Override
	public List<Process> getProcessList(Process entity) {
		try {

			List<Process> list = (List<Process>) processDao.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Process>();
				Process process = new Process();
				process.setMessageCode(IConstant.WMSG0008);
				process.setRetErrFlag(true);
				list.add(process);
				return list;
			} else {
				return list;
			}

		} catch (SQLException e) {
			List<Process> list = new ArrayList<Process>();
			Process process = new Process();
			process.setMessageCode(IConstant.EMSG0004);
			process.setRetErrFlag(true);
			process.setExceMessage(e.getMessage());
			list.add(process);
			return list;
		}
	}

	@Override
	public List<Equipment> getEquipmentList(Equipment entity) {
		try {
			List<Equipment> list = (List<Equipment>) equipmentDao.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Equipment>();
				Equipment equipment = new Equipment();
				equipment.setMessageCode(IConstant.WMSG0008);
				equipment.setRetErrFlag(true);
				list.add(equipment);
				return list;
			} else {
				return list;
			}

		} catch (SQLException e) {
			List<Equipment> list = new ArrayList<Equipment>();
			Equipment equipment = new Equipment();
			equipment.setMessageCode(IConstant.EMSG0004);
			equipment.setRetErrFlag(true);
			equipment.setExceMessage(e.getMessage());
			list.add(equipment);
			return list;
		}
	}

	@Override
	public List<Axle> getAxlelist(Axle entity) {
		try {
			List<Axle> list = (List<Axle>) axleDao.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Axle>();
				Axle axle = new Axle();
				axle.setMessageCode(IConstant.WMSG0008);
				axle.setRetErrFlag(true);
				list.add(axle);
				return list;
			} else {
				return list;
			}

		} catch (SQLException e) {
			List<Axle> list = new ArrayList<Axle>();
			Axle axle = new Axle();
			axle.setMessageCode(IConstant.EMSG0004);
			axle.setRetErrFlag(true);
			axle.setExceMessage(e.getMessage());
			list.add(axle);
			return list;
		}
	}

	@Override
	public String getNumber() {
		int total=0 ;
		try {
			total = vamortizationDao.searchByCount(new Vamortization());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(total);
	}
}
