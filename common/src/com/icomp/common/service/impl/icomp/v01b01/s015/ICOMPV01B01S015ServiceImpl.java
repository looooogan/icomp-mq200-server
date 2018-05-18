package com.icomp.common.service.impl.icomp.v01b01.s015;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s015.ICOMPV01B01S015Service;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存盘点查询SERVICE实现类 
 * @ClassName: ICOMPV01B01S015ServiceImpl
 * @author Licc
 * @date 2014-11-12 下午03:48:40
 */
public class ICOMPV01B01S015ServiceImpl extends BaseService implements ICOMPV01B01S015Service {

	/**
	 * 库存盘点查询DAO
	 */
	private ToolChangehistoryDao toolChangehistoryDao;
	private AssemblylineDao assemblylineDao;
	private AxleDao axleDao;
	private ProcessDao processDao;
	private EquipmentDao equipmentDao;
	private PartsDao partsDao;

	public void setToolChangehistoryDao(ToolChangehistoryDao toolChangehistoryDao) {
		this.toolChangehistoryDao = toolChangehistoryDao;
	}
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



	@Override
	/**
	 * 库存盘点查询列表-ToolCode模糊查询
	 */
	public Map<String, Object> getList(ToolChangehistory entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<ToolChangehistory> list = (List<ToolChangehistory>) toolChangehistoryDao.searchByList2(entity);
			if (list.size() <= 0) {
				list = new ArrayList<ToolChangehistory>();
				ToolChangehistory toolChangehistory = new ToolChangehistory();
				toolChangehistory.setMessageCode(IConstant.EMSG0001);
				toolChangehistory.setRetErrFlag(true);
				list.add(toolChangehistory);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = toolChangehistoryDao.searchByCount2(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)/ IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<ToolChangehistory> list = new ArrayList<ToolChangehistory>();
			ToolChangehistory toolChangehistory = new ToolChangehistory();
			toolChangehistory.setMessageCode(IConstant.EMSG0004);
			toolChangehistory.setRetErrFlag(true);
			toolChangehistory.setExceMessage(e.getMessage());
			list.add(toolChangehistory);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
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


}
