package com.icomp.common.service.impl.icomp.v01b08.s001;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b08.s001.ICOMPV01B08S001Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.CapabilityDao;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.SclinkDao;
import com.icomp.dao.SystemDao;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Position;
import com.icomp.entity.base.Sclink;

public class ICOMPV01B08S001ServiceImpl extends BaseService implements
		ICOMPV01B08S001Service {

	/**
	 * 系统显示项目配置(兼顾打印项目)
	 */
	private DisplayeditemconfigurationDao displayeditemconfigurationDao;

	public void setDisplayeditemconfigurationDao(
			DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}

	/**
	 * 功能Dao
	 */
	private CapabilityDao capabilityDao;

	public void setCapabilityDao(CapabilityDao capabilityDao) {
		this.capabilityDao = capabilityDao;
	}

	/**
	 * 系统DAO
	 */
	private SystemDao systemDao;
	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}

	/**
	 * 系统功能关联表Dao
	 */
	private SclinkDao sclinkDao;
	public void setSclinkDao(SclinkDao sclinkDao) {
		this.sclinkDao = sclinkDao;
	}

	/**
	 * 角色管理
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 角色信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Capability entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Capability> list = (List<Capability>) capabilityDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Capability>();
				Capability capability = new Capability();
				// 消息：检索为0
				capability.setMessageCode(IConstant.EMSG0001);
				capability.setRetErrFlag(true);
				list.add(capability);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				rtn.put("rows", list);
				return rtn;
			}

		} catch (SQLException e) {
			List<Capability> list = new ArrayList<Capability>();
			Capability capability = new Capability();
			// 错误消息：数据库操作异常,查询失败!
			capability.setMessageCode(IConstant.EMSG0004);
			capability.setRetErrFlag(true);
			capability.setExceMessage(e.getMessage());
			list.add(capability);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID, String lang) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			Displayeditemconfiguration entity = new Displayeditemconfiguration();
			entity.setPageName(pageID);
			entity.setLanguageCode(lang);

			List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao
					.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Displayeditemconfiguration>();
				Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
				displayeditemconfiguration.setMessageCode(IConstant.WMSG0008);
				displayeditemconfiguration.setRetErrFlag(true);
				list.add(displayeditemconfiguration);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Displayeditemconfiguration displayeditemconfiguration : list) {
					rtn
							.put(displayeditemconfiguration.getColName(),
									IConstant.DISPLAYED_FLAG_0
											.equals(displayeditemconfiguration
													.getDisplayedFlag()) ? true
											: false);
				}
				return rtn;
			}

		} catch (SQLException e) {
			List<Displayeditemconfiguration> list = new ArrayList<Displayeditemconfiguration>();
			Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
			// 错误消息：数据库操作异常,查询失败!
			displayeditemconfiguration.setMessageCode(IConstant.EMSG0004);
			displayeditemconfiguration.setRetErrFlag(true);
			displayeditemconfiguration.setExceMessage(e.getMessage());
			list.add(displayeditemconfiguration);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;

		}
	}

	/**
	 * 新建功能信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> capablitiyAdd(Capability capability, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			capability.setCapabilityID(NextKeyValue.getNextkeyvalue(
					IConstant.CAPABILITY, IConstant.CAPABILITY_ID, capability
							.getUpdateUser()));// 取得功能表主键
			if (capability.getCapCapabilityID() == null) {// 新建根目录
				capability.setCapCapabilityID(capability.getCapabilityID());
			}
			Object obj = capabilityDao.insert(capability);
			//检测当前功能与系统是否关联
			com.icomp.entity.base.System system = new com.icomp.entity.base.System();
			system.setDelFlag(IConstant.DEL_FLAG_0);
			List<com.icomp.entity.base.System> list = (List<com.icomp.entity.base.System>)systemDao.searchByList(system);
			if (list == null || list.size() == 0) {
				Capability entity = new Capability();
				entity = new Capability();
				// 消息：检索为0
				entity.setMessageCode(IConstant.EMSG0001);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			system = list.get(0);
			Sclink sclink = new Sclink();
			sclink.setSystemID(system.getSystemID());
			sclink.setCapabilityID(obj.toString());
			if(sclinkDao.searchByCount(sclink) <= 0){
				sclink.setscLinkID(NextKeyValue.getNextkeyvalue(
					IConstant.SCLINK, IConstant.SCLINK_ID, capability
							.getUpdateUser()));
				sclinkDao.insert(sclink);
			}
			// 消息：新建成功!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;
		} catch (SQLException e) {
			Capability entity = new Capability();
			// 错误消息：数据库操作异常,查询失败!
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 功能删除
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> capablitiyDelete(Capability capability, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Capability entity = new Capability();
			entity.setCapabilityID(capability.getCapabilityIDWhere());
			entity.setUpdateTime(capability.getUpdateTimeWhere());
			entity.setUpdateUser(capability.getUpdateUserWhere());
			entity.setVersion(capability.getVersionWhere());
			List<Capability> list = (List<Capability>) capabilityDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Capability();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = capabilityDao.updateNonQuery(capability);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Capability entity = new Capability();
			// 错误消息：数据库操作异常,查询失败!
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 编辑功能信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> capablitiyEdit(Capability capability, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			// 删除失败! 进行数据排他验证
			Capability entity = new Capability();
			entity.setCapabilityID(capability.getCapabilityIDWhere());
			entity.setUpdateTime(capability.getUpdateTimeWhere());
			entity.setUpdateUser(capability.getUpdateUserWhere());
			entity.setVersion(capability.getVersionWhere());
			List<Capability> list = (List<Capability>) capabilityDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Capability();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新职务成功
			@SuppressWarnings("unused")
			int ret = capabilityDao.updateNonQuery(capability);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;
		} catch (SQLException e) {
			Position entity = new Position();
			// 错误消息：数据库操作异常,查询失败!
			entity.setMessageCode(IConstant.EMSG0004);
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
			String langCode,String langValue, String userID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Capability capability = new Capability();
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		//新建验证
		if(checkType == 1){ 
			if(StringUtils.isEmpty(param.get("DIV_LanguageCode").toString())){
				map.put("DIV_LanguageCode",  MessageReSource.getMessageBox(
						IConstant.WMSG0024, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_CapabilityName").toString())){
				map.put("DIV_CapabilityName", MessageReSource.getMessageBox(
						IConstant.WMSG0026, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_CapabilityCode").toString())){
				map.put("DIV_CapabilityCode",  MessageReSource.getMessageBox(
						IConstant.WMSG0027, langCode, langValue));
			}
			//请输入功能级别!
			if(StringUtils.isEmpty(param.get("DIV_CapabilityLevel").toString())){
				map.put("DIV_CapabilityLevel", MessageReSource.getMessageBox(
						IConstant.WMSG0028, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_CapabilityOrder").toString())){
				map.put("DIV_CapabilityOrder", MessageReSource.getMessageBox(
						IConstant.WMSG0029, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_BelongFlag").toString())){
				map.put("DIV_BelongFlag", MessageReSource.getMessageBox(
						IConstant.WMSG0030, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_CapabilityUrl").toString())){
				map.put("DIV_CapabilityUrl", MessageReSource.getMessageBox(
						IConstant.WMSG0031, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_MenuFlag").toString())){
				map.put("DIV_MenuFlag", MessageReSource.getMessageBox(
						IConstant.WMSG0032, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_DelFlag").toString())){
				map.put("DIV_DelFlag", MessageReSource.getMessageBox(
						IConstant.WMSG0019, langCode, langValue));
			}
		//编辑验证
		}else{ 
			if(StringUtils.isEmpty(param.get("DIV_LanguageCode").toString())){
				map.put("DIV_LanguageCode",  MessageReSource.getMessageBox(
						IConstant.WMSG0024, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_CapabilityName").toString())){
				map.put("DIV_CapabilityName", MessageReSource.getMessageBox(
						IConstant.WMSG0026, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_CapabilityCode").toString())){
				map.put("DIV_CapabilityCode",  MessageReSource.getMessageBox(
						IConstant.WMSG0027, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_BelongFlag").toString())){
				map.put("DIV_BelongFlag", MessageReSource.getMessageBox(
						IConstant.WMSG0030, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_CapabilityUrl").toString())){
				map.put("DIV_CapabilityUrl", MessageReSource.getMessageBox(
						IConstant.WMSG0031, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_MenuFlag").toString())){
				map.put("DIV_MenuFlag", MessageReSource.getMessageBox(
						IConstant.WMSG0032, langCode, langValue));
			}
			if(StringUtils.isEmpty(param.get("DIV_DelFlag").toString())){
				map.put("DIV_DelFlag", MessageReSource.getMessageBox(
						IConstant.WMSG0019, langCode, langValue));
			}
		}
		
		//新建提交
		if (checkType ==1){
			if(map.size() <= 0 ){
				capability.setCapabilityID(NextKeyValue.getNextkeyvalue(
					IConstant.CAPABILITY, IConstant.CAPABILITY_ID, userID));// 取得功能表主键
				capability.setUpdateTime(new Date());// 更新时间
				capability.setUpdateUser(userID);// 更新者
				capability.setCreateTime(new Date());// 创建时间
				capability.setCreateUser(userID);// 创建者
				capability.setVersion(BigDecimal.ZERO);// 版本号
			}else{
				rtn.put("message", map);//返回map
				rtn.put("data", null); //数据
				rtn.put("status", IConstant.RESULT_CODE_2);//状态
				return rtn;
			}
		//编辑提交	
		}else{
			if(map.size() > 0 ){
			rtn.put("message", map);//返回map
			rtn.put("data", null); //数据
			rtn.put("status", IConstant.RESULT_CODE_2);//状态
			return rtn;
			}
		}
		
		return rtn;
		
	}


	/**
	 * 取得功能信息列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCapabilityList(Capability entity,String langCode){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Capability> list = (List<Capability>) capabilityDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Capability>();
				Capability capability = new Capability();
				// 消息：检索为0
				capability.setMessageCode(IConstant.EMSG0001);
				capability.setRetErrFlag(true);
				list.add(capability);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				rtn.put("rows", list);
				return rtn;
			}

		} catch (SQLException e) {
			List<Capability> list = new ArrayList<Capability>();
			Capability capability = new Capability();
			// 错误消息：数据库操作异常,查询失败!
			capability.setMessageCode(IConstant.EMSG0004);
			capability.setRetErrFlag(true);
			capability.setExceMessage(e.getMessage());
			list.add(capability);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
	/**
	 * 功能信息查询
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 功能信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCapablitiyInfo(Capability entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Capability> list = (List<Capability>) capabilityDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Capability capability = new Capability();
				capability.setOrderString(IConstant.STRING_0);
				rtn.put("data", capability);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Capability capability = new Capability();
			// 错误消息：数据库操作异常,查询失败!
			capability.setMessageCode(IConstant.EMSG0004);
			capability.setRetErrFlag(true);
			capability.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", capability);
			return rtn;
		}
	}
}
