package com.icomp.common.service.impl.icomp.v01b08.s007;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b08.s007.ICOMPV01B08S007Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.EquipmentDao;
import com.icomp.dao.NoticeequipmentDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.VequipmentDao;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Noticeequipment;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Vequipment;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
@SuppressWarnings("unchecked")
public class ICOMPV01B08S007ServiceImpl extends BaseService implements
		ICOMPV01B08S007Service {
	
    // 设备视图Dao
	private VequipmentDao vequipmentDao;
	
	public void setVequipmentDao(VequipmentDao vequipmentDao) {
		this.vequipmentDao = vequipmentDao;
	}

	//设备Dao
	private EquipmentDao equipmentDao;
	
	public void setEquipmentDao(EquipmentDao equipmentDao) {
		this.equipmentDao = equipmentDao;
	}
	private NoticeequipmentDao noticeequipmentDao;
	public void setNoticeequipmentDao(NoticeequipmentDao noticeequipmentDao) {
		this.noticeequipmentDao = noticeequipmentDao;
	}

	//rfidDao
	private RfidcontainerDao rfidcontainerDao;

	public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
		this.rfidcontainerDao = rfidcontainerDao;
	}


	/**
	 * 设备列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 手持机配置信息
	 */

    @Override
	public Map<String, Object> getList(Vequipment entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vequipment> list = (List<Vequipment>) vequipmentDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vequipment>();
				Vequipment equipment = new Vequipment();
				//消息：检索为0
				equipment.setMessageCode(IConstant.EMSG0001);
				equipment.setRetErrFlag(true);
				list.add(equipment);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vequipmentDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vequipment> list = new ArrayList<Vequipment>();
			Vequipment equipment = new Vequipment();
			//错误消息：数据库操作异常，查询失败!
			equipment.setMessageCode(IConstant.EMSG0004);
			equipment.setRetErrFlag(true);
			equipment.setExceMessage(e.getMessage());
			list.add(equipment);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
    

	/**
	 * 设备删除
	 * @param equipment
	 *            页面查询条件
	 * @return 手持机配置信息
	 */	
	public Map<String, Object> equipmentDelete(Equipment equipment, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Equipment entity = new Equipment();
			entity.setEquipmentID(equipment.getEquipmentIDWhere()); //设备ID
			entity.setUpdateTime(equipment.getUpdateTimeWhere()); //更新时间
			entity.setUpdateUser(equipment.getUpdateUserWhere()); //更新者
			entity.setVersion(equipment.getVersionWhere());       //版本号
			List<Equipment> list = (List<Equipment>) equipmentDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Equipment();
				//您所请求的数据，已被其他用户修改，请重新查询后再进行修改！
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}else{
				Rfidcontainer rfid =new Rfidcontainer();
				rfid.setDelFlag(IConstant.DEL_FLAG_1);
				rfid.setRfidContainerIDWhere(list.get(0).getRfidContainerID());
				if(rfid.getRfidContainerIDWhere()!=null)
				rfidcontainerDao.updateNonQuery(rfid);
			}
			equipmentDao.updateNonQuery(equipment);
	
			//删除成功，ID:{0}!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Equipment entity = new Equipment();
			//错误消息：数据库操作异常，删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	
	/**
	 * 设备删除
	 * @param equipment
	 *            页面查询条件
	 * @return 手持机配置信息
	 */	
	public Map<String, Object> noticeequipmentDelete(Noticeequipment equipment, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			
			// 删除失败! 进行数据排他验证
			Noticeequipment entity = new Noticeequipment();
			entity.setNoticeEquipmentID(equipment.getNoticeEquipmentIDWhere()); //设备ID
			entity.setUpdateTime(equipment.getUpdateTimeWhere()); //更新时间
			entity.setUpdateUser(equipment.getUpdateUserWhere()); //更新者
			entity.setVersion(equipment.getVersionWhere());       //版本号
			List<Noticeequipment> list = (List<Noticeequipment>) noticeequipmentDao
			.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Noticeequipment();
				//您所请求的数据，已被其他用户修改，请重新查询后再进行修改！
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			noticeequipmentDao.updateNonQuery(equipment);
			//删除成功，ID:{0}!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Noticeequipment entity = new Noticeequipment();
			//错误消息：数据库操作异常，删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 新建设备
	 * @param langCode
	 *            页面查询条件
	 * @return 手持机配置信息
	 */	
	public Map<String, Object> equipmentAdd(Equipment equipment,String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			equipment.setEquipmentID(NextKeyValue.getNextkeyvalue(
					IConstant.EQUIPMENT, IConstant.EQUIPMENT_ID, equipment.getUpdateUser()));// 取得设备表主键

			equipmentDao.insert(equipment);
			//插入成功,ID:{0}!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Equipment entity = new Equipment();
			//错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 新建编辑的验证
	 * @param param      页面查询条件
	 * @param langCode   语言编码
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param checkType  1代表新建，2代表编辑
	 * @return
	 */
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Equipment equipment = new Equipment();		
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		try {
			//类型验证
			if(StringUtils.isEmpty(param.get("DIVEquipmentType").toString())){
				map.put("DIVEquipmentType",  MessageReSource.getMessageBox(
						IConstant.WMSG0170, langCode, langValue));
			}else{
				equipment.setEquipmentType(param.get("DIVEquipmentType").toString());
				
			}
			//语言验证
//			if(StringUtils.isEmpty(param.get("DIVLanguageCode").toString())){
//				map.put("DIVLanguageCode",MessageReSource.getMessageBox(
//						IConstant.WMSG0024, langCode, langValue));
//			}else{
//				equipment.setLanguageCode(param.get("DIVLanguageCode").toString()); // 语言编码
//			}
//			//删除区分验证
//			if(StringUtils.isEmpty(param.get("DIVDelFlag").toString())){
//				map.put("DIVDelFlag", MessageReSource.getMessageBox(
//						IConstant.WMSG0019, langCode, langValue));
//			}else{
//				equipment.setDelFlag(param.get("DIVDelFlag").toString()); // 删除区分
//			}
				//设备名称验证
				if(StringUtils.isEmpty(param.get("DIVEquipmentName").toString())){
					map.put("DIVEquipmentName",  MessageReSource.getMessageBox(
							IConstant.WMSG0168, langCode, langValue));
				}else{
					if(checkType == 1){ 
						Vequipment entity = new Vequipment();
						entity.setEquipmentID(param.get("DIVEquipmentName").toString());
						entity.setDelFlag(IConstant.DEL_FLAG_0);
						List<Vequipment> list = (List<Vequipment>)vequipmentDao.searchByList(entity);
						if(list.size()>0){
							//消息：您所新建的设备名称已存在!
							map.put("DIVEquipmentName",  MessageReSource.getMessageBox(
									IConstant.WMSG0169, langCode, langValue));
						}	
					}
					equipment.setEquipmentCode(param.get("DIVEquipmentCode").toString()); // 设备编码
					
				}
				
				//设备编码验证
				if(StringUtils.isEmpty(param.get("DIVEquipmentCode").toString())){
					map.put("DIVEquipmentCode",  MessageReSource.getMessageBox(
							IConstant.WMSG0170, langCode, langValue));
				}else{
					if(checkType == 1){ 
					Vequipment entity = new Vequipment();
					entity.setEquipmentCode(param.get("DIVEquipmentCode").toString());
					entity.setDelFlag(IConstant.DEL_FLAG_0);
					List<Vequipment> list = (List<Vequipment>)vequipmentDao.searchByList(entity);
					if(list.size()>0){
						//消息：您所新建的设备编码已存在!
						map.put("DIVEquipmentCode",  MessageReSource.getMessageBox(
								IConstant.WMSG0171, langCode, langValue));
			        }
					}
					equipment.setEquipmentName(param.get("DIVEquipmentName").toString()); // 设备名称
				}
			//新建提交
			if(map.size() >0){
				rtn.put("message", map);//返回map
				rtn.put("data", equipment); //数据
				rtn.put("status", IConstant.RESULT_CODE_2);//状态
			}else if (checkType ==1&&map.size()==0){
				equipment.setUpdateTime(new Date()); // 更新时间
				equipment.setUpdateUser(customerID); // 更新者
				equipment.setCreateTime(new Date()); // 创建时间
				equipment.setCreateUser(customerID); // 创建者
				equipment.setVersion(BigDecimal.ZERO); // 版本号
				rtn.put("data", equipment); //数据
				rtn.put("status", IConstant.RESULT_CODE_0);//状态
			}else if (checkType ==2&&map.size()==0){
				equipment.setUpdateTime(new Date());
				equipment.setUpdateUser(customerID);
				equipment.setVersion(new BigDecimal(
						param.get("DivVersion").toString()).add(BigDecimal.ONE));
				equipment.setEquipmentID(param.get("DivEquipmentID").toString());
				equipment.setEquipmentIDWhere(param.get("DivEquipmentID").toString());
				equipment.setUpdateTimeWhere(Ctl.strToDate(
						param.get("DivUpdateTime").toString().replace("T", " ")));
				equipment.setUpdateUserWhere(param.get("DivUpdateUser").toString());
				equipment.setVersionWhere(new BigDecimal(
						param.get("DivVersion").toString()));
				rtn.put("data", equipment); //数据
				rtn.put("status", IConstant.RESULT_CODE_0);//状态
			}
			return rtn;
		} catch (SQLException e) {
			Equipment entity = new Equipment();
			//错误消息：数据库操作异常，查询失败!
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
			}						
		
	}


	/**
	 * 编辑设备信息 
	 */
	public Map<String, Object> equipmentEdit(Equipment equipment, String langCode,String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 更新失败! 进行数据排他验证
			Equipment entity = new Equipment();
			entity.setEquipmentID(equipment.getEquipmentIDWhere());
			entity.setUpdateTime(equipment.getUpdateTimeWhere());
			entity.setUpdateUser(equipment.getUpdateUserWhere());
			entity.setVersion(equipment.getVersionWhere());
			List<Equipment> list = (List<Equipment>) equipmentDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Equipment();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新职务成功
			equipmentDao.updateNonQuery(equipment);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Equipment entity = new Equipment();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	

	
	/**
	 * 取得设备信息
	 */
	public Map<String, Object> equipmentInfo(Vequipment entity){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			Vequipment equipment = (Vequipment) vequipmentDao.searchByPrimaryKey(entity);
			if (equipment == null) {
				equipment = new Vequipment();
				//消息：检索为0
				equipment.setMessageCode(IConstant.EMSG0001);
				equipment.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", equipment);
				return rtn;
			} else {
				rtn.put("data", equipment);
				return rtn;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			Vequipment equipment = new Vequipment();
			//错误消息：数据库操作异常，查询失败!
			equipment.setMessageCode(IConstant.EMSG0004);
			equipment.setRetErrFlag(true);
			equipment.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", equipment);
			return rtn;
		}
	}
	

	@Override
	public Map<String, Object> equipmentUnbund(Equipment equipment,
			String langCode, String langValue) {
		 int reVal = 0;
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			// 更新失败! 进行数据排他验证
			Equipment entity = new Equipment();
			entity.setEquipmentID(equipment.getEquipmentIDWhere());//设备id
//			entity.setUpdateTime(equipment.getUpdateTimeWhere());//更新时间
//			entity.setUpdateUser(equipment.getUpdateUserWhere());//用户ID
//			entity.setVersion(equipment.getVersionWhere());
			List<Equipment> list = (List<Equipment>) equipmentDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Equipment();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新成功
			Equipment  e = new Equipment();
			e.setUpdateTime(new Date());
			e.setUpdateUser(equipment.getUpdateUser());
			if(list.size()>0){
				e.setRfidContainerID(list.get(0).getRfidContainerID());
			}
			//把RFID改为无效
			reVal += equipmentDao.updateNonQueryEmpRifdContainer(e);
			reVal += equipmentDao.updateNonQueryEmpRifd(equipment);
			Rfidcontainer rfidcontainer=new Rfidcontainer();
			rfidcontainer.setDelFlag(IConstant.DEL_FLAG_1);
			rfidcontainer.setRfidContainerIDWhere(e.getRfidContainerID());
			rfidcontainerDao.updateNonQuery(rfidcontainer);
			if(reVal > 0){
				rtn.put("message", MessageReSource.getMessageBox(
						IConstant.IMSG0005, langCode, langValue));
				rtn.put("status", IConstant.RESULT_CODE_0);
			}else{
				rtn.put("message", MessageReSource.getMessageBox(
						IConstant.EMSG0006, langCode, langValue));
				rtn.put("status", IConstant.RESULT_CODE_1);
			}
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Equipment entity = new Equipment();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}


	@Override
	public Map<String, Object> noticeequipmentAdd(Noticeequipment noequipment,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			noequipment.setNoticeEquipmentID(NextKeyValue.getNextkeyvalue(
					IConstant.NOTICE_EQUIPMENT, IConstant.NOTICE_EQUIPMENT_ID, noequipment.getUpdateUser()));// 取得设备表主键
			noticeequipmentDao.insert(noequipment);
			//插入成功,ID:{0}!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Equipment entity = new Equipment();
			//错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	
	
	/**
	 * 编辑设备信息 
	 */
	public Map<String, Object> noticeequipmentEdit(Noticeequipment equipment, String langCode,String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 更新失败! 进行数据排他验证
			Noticeequipment entity = new Noticeequipment();

			//entity.setUpdateTime(equipment.getUpdateTimeWhere());
			entity.setNoticeEquipmentID(equipment.getNoticeEquipmentID());
			entity.setUpdateUser(equipment.getUpdateUserWhere());
			entity.setVersion(equipment.getVersionWhere());
			List<Noticeequipment> list = (List<Noticeequipment>) noticeequipmentDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Noticeequipment();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新职务成功
			noticeequipmentDao.updateNonQuery(equipment);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Noticeequipment entity = new Noticeequipment();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
}