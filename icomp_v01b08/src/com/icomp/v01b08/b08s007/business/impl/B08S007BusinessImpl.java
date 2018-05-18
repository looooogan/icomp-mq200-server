package com.icomp.v01b08.b08s007.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s007.ICOMPV01B08S007Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Noticeequipment;
import com.icomp.entity.base.Position;
import com.icomp.entity.base.Process;
import com.icomp.entity.base.Vequipment;
import com.icomp.v01b08.b08s007.business.B08S007Business;

public class B08S007BusinessImpl implements B08S007Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S007Service iCOMPV01B08S007Service;

	public void setiCOMPV01B08S007Service(
			ICOMPV01B08S007Service iCOMPV01B08S007Service) {
		this.iCOMPV01B08S007Service = iCOMPV01B08S007Service;
	}

	/**
	 * 取得系统区分列表
	 * 
	 * @param flagType
	 *            区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,
			String langValue) throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}

	/**
	 * 取得设备配置列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		// 设置检索条件
		Vequipment entity = new Vequipment();
		// 设备ID
		entity.setEquipmentName(StringUtils.isEmpty(param.get("EquipmentID").toString()) ? null : param.get("EquipmentID").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("EquipmentName");
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		Map<String, Object> rtn = iCOMPV01B08S007Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vequipment>) rtn.get("error"))
					.get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 删除设备配置
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> equipmentDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		Map<String, Object> ret =new HashMap<String, Object>();
		Equipment equipment = new Equipment();
		equipment.setDelFlag(IConstant.DEL_FLAG_1); // 删除区分
		equipment.setUpdateTime(new Date()); // 更新时间
		equipment.setUpdateUser(customerID); // 更新者
		equipment.setVersion(new BigDecimal(param.get("version").toString())
				.add(BigDecimal.ONE)); // 版本号
		equipment.setEquipmentIDWhere(param.get("equipmentID").toString()); // 工序ID
		equipment.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime")
				.toString().replace("T", " "))); // 更新时间
		equipment.setUpdateUserWhere(param.get("updateuser").toString()); // 更新者
		equipment.setVersionWhere(new BigDecimal(param.get("version")
				.toString())); // 版本号
		equipment.setEquipmentType(param.get("EquipmentType").toString());
		if(equipment.getEquipmentType().equals(IConstant.EQUIPMENT_TYPES_3)||equipment.getEquipmentType().equals(IConstant.EQUIPMENT_TYPES_4)){
			// 保存刃磨设备信息
			Noticeequipment noticeEqupment=new Noticeequipment();
			noticeEqupment.setEquipmentName(equipment.getEquipmentName());
			noticeEqupment.setEquipmentCode(equipment.getEquipmentCode());
			noticeEqupment.setLanguageCode(equipment.getLanguageCode());
			noticeEqupment.setEquipmentType(equipment.getEquipmentType());
			noticeEqupment.setNoticeEquipmentIDWhere(equipment.getEquipmentIDWhere());
			noticeEqupment.setDelFlag(IConstant.DEL_FLAG_1);
			noticeEqupment.setCreateTime(equipment.getCreateTime());
			noticeEqupment.setCreateUser(customerID);
			noticeEqupment.setUpdateTime(equipment.getUpdateTime());
			noticeEqupment.setUpdateUser(customerID);
			noticeEqupment.setVersion(BigDecimal.ZERO);
			ret = iCOMPV01B08S007Service.noticeequipmentDelete(noticeEqupment, langCode,
					langValue);
			if (ret.size() > 1 && ret.get("error") != null) {
				// 删除失败时，返回
				throw new BusinessException(((Noticeequipment) ret.get("error"))
						.getMessageCode(), langCode, langValue);
			}
		}else{
			ret = iCOMPV01B08S007Service.equipmentDelete(
				equipment, langCode, langValue);
			if (ret.size() > 1 && ret.get("error") != null) {
				// 删除失败时，返回
				throw new BusinessException(((Equipment) ret.get("error"))
						.getMessageCode(), langCode, langValue);
			}
		}
		return ret;

	}

	/**
	 * 添加设备配置信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> equipmentAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		// 工序输入验证
		Map<String, Object> ret = iCOMPV01B08S007Service.checkInput(param,
				langCode, langValue, customerID, 1);
		if (ret.size() > 1 && ret.get("error") != null) {
			throw new BusinessException(((Process) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		} else if (ret.size() > 1 && ret.get("message") != null) {
			return ret;
		}
		Equipment equipment =(Equipment) ret.get("data");

		if(equipment.getEquipmentType().equals(IConstant.EQUIPMENT_TYPES_3)
				||equipment.getEquipmentType().equals(IConstant.EQUIPMENT_TYPES_4)){
			// 保存刃磨设备信息
			Noticeequipment noticeEqupment=new Noticeequipment();
			noticeEqupment.setEquipmentName(equipment.getEquipmentName());
			noticeEqupment.setEquipmentCode(equipment.getEquipmentCode());
			noticeEqupment.setLanguageCode(equipment.getLanguageCode());
			noticeEqupment.setEquipmentType(param.get("DIVRmEquipmentType").toString());
			noticeEqupment.setDelFlag(IConstant.DEL_FLAG_0);
			noticeEqupment.setCreateTime(equipment.getCreateTime());
			noticeEqupment.setCreateUser(customerID);
			noticeEqupment.setUpdateTime(equipment.getUpdateTime());
			noticeEqupment.setUpdateUser(customerID);
			noticeEqupment.setVersion(BigDecimal.ZERO);
			ret = iCOMPV01B08S007Service.noticeequipmentAdd(noticeEqupment, langCode,
					langValue);
		}else{
			// 保存设备信息
			equipment.setStatues(IConstant.DEL_FLAG_1);
			ret = iCOMPV01B08S007Service.equipmentAdd(equipment, langCode,
					langValue);
		}
		if (ret.size() > 1 && ret.get("error") != null) {
			// 新建失败时，返回
			throw new BusinessException(((Equipment) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID, String userID,
			String langCode, String langValue) throws BusinessException {

		// 取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID, langCode,
				IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 编辑设备
	 * 
	 * @param param
	 * @return
	 */
	public Map<String, Object> equipmentEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode) {
		// 用户输入验证
		Map<String, Object> ret = iCOMPV01B08S007Service.checkInput(param,
				langCode, langValue, customerID, 2);
		if (ret.size() > 1 && ret.get("error") != null) {
			throw new BusinessException(((Position) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		} else if (ret.size() > 1 && ret.get("message") != null) {
			return ret;
		}
		Equipment equipment =(Equipment) ret.get("data");
		if(equipment.getEquipmentType().equals(IConstant.EQUIPMENT_TYPES_3)
				||equipment.getEquipmentType().equals(IConstant.EQUIPMENT_TYPES_4)){
			// 保存刃磨设备信息
			Noticeequipment noticeEqupment=new Noticeequipment();
			noticeEqupment.setEquipmentName(equipment.getEquipmentName());
			noticeEqupment.setEquipmentCode(equipment.getEquipmentCode());
//			noticeEqupment.setLanguageCode(equipment.getLanguageCode());
//			noticeEqupment.setEquipmentType(param.get("DIVRmEquipmentType").toString());
			noticeEqupment.setNoticeEquipmentID(param.get("DivEquipmentID").toString());
			noticeEqupment.setNoticeEquipmentIDWhere(param.get("DivEquipmentID").toString());
			noticeEqupment.setDelFlag(equipment.getDelFlag());
			noticeEqupment.setUpdateTime(equipment.getUpdateTime());//更新时间
			noticeEqupment.setUpdateTimeWhere(equipment.getUpdateTimeWhere());
			noticeEqupment.setUpdateUser(customerID);
			noticeEqupment.setUpdateUserWhere(equipment.getUpdateUserWhere());
			noticeEqupment.setVersionWhere(new BigDecimal( param.get("DivVersion").toString()));
			noticeEqupment.setVersion(new BigDecimal( param.get("DivVersion").toString()).add(BigDecimal.ONE));
			ret = iCOMPV01B08S007Service.noticeequipmentEdit(noticeEqupment, langCode,
					langValue);
			if (ret.size() > 1 && ret.get("error") != null) {
				// 失败返回
				throw new BusinessException(((Noticeequipment) ret.get("error"))
						.getMessageCode(), langCode, langValue);
			}
		}else{
			// 保存设备信息
			ret = iCOMPV01B08S007Service.equipmentEdit(equipment, langCode,
					langValue);
			if (ret.size() > 1 && ret.get("error") != null) {
				// 失败返回
				throw new BusinessException(((Equipment) ret.get("error"))
						.getMessageCode(), langCode, langValue);
			}
		}
		return ret;
	}

	/**
	 * 取得设备信息
	 */
	public Map<String, Object> equipmentInfo(Map<String, Object> param, String langCode,
			String langValue) {
		Map<String, Object> ret = new HashMap<String, Object>();
		Vequipment equipment = new Vequipment();
		// 设定设备ID
		equipment.setEquipmentID(param.get("EquipmentID").toString());
		ret = iCOMPV01B08S007Service.equipmentInfo(equipment);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((Vequipment) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> equipmentUnbund(Map<String, Object> param,
			String langValue, String customerID, String langCode) 	throws BusinessException {
				Equipment equipment = new Equipment();
				equipment.setUpdateTime(new Date()); // 更新时间
				equipment.setUpdateUser(customerID); // 更新者
				equipment.setVersion(new BigDecimal(param.get("version").toString())
						.add(BigDecimal.ONE)); // 版本号
				equipment.setEquipmentIDWhere(param.get("equipmentID").toString()); // 工序ID
				equipment.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime")
						.toString().replace("T", " "))); // 更新时间
				equipment.setUpdateUserWhere(param.get("updateuser").toString()); // 更新者
				equipment.setVersionWhere(new BigDecimal(param.get("version")
						.toString())); // 版本号
				Map<String, Object> ret = iCOMPV01B08S007Service.equipmentUnbund(
						equipment, langCode, langValue);
				if (ret.size() > 1 && ret.get("error") != null) {
					// 删除失败时，返回
					throw new BusinessException(((Process) ret.get("error"))
							.getMessageCode(), langCode, langValue);
				}
				return ret;
	}

}
