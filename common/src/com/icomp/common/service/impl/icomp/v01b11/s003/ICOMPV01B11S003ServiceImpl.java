package com.icomp.common.service.impl.icomp.v01b11.s003;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b11.s003.ICOMPV01B11S003Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.DplinkDao;
import com.icomp.dao.PositionDao;
import com.icomp.dao.VpositionsDao;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Dplink;
import com.icomp.entity.base.Position;
import com.icomp.entity.base.Vpositions;

public class ICOMPV01B11S003ServiceImpl extends BaseService implements
		ICOMPV01B11S003Service {

	/**
	 * 系统显示项目配置(兼顾打印项目)
	 */
	private DisplayeditemconfigurationDao displayeditemconfigurationDao;

	public void setDisplayeditemconfigurationDao(
			DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}
	
	/**
	 * 角色取得视图Dao
	 */
	private VpositionsDao vpositionsDao;
	public void setVpositionsDao(VpositionsDao vpositionsDao) {
		this.vpositionsDao = vpositionsDao;
	}

	/**
	 * 角色Dao
	 */
	private PositionDao positionDao;
	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}


	/**
	 * 角色部门中间表Dao
	 */
	private DplinkDao dplinkDao;
	
	public void setDplinkDao(DplinkDao dplinkDao) {
		this.dplinkDao = dplinkDao;
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
	public Map<String, Object> getList(Vpositions entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vpositions> list = (List<Vpositions>) vpositionsDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vpositions>();
				Vpositions vpositions = new Vpositions();
				//消息：检索为0
				vpositions.setMessageCode(IConstant.EMSG0001);
				vpositions.setRetErrFlag(true);
				list.add(vpositions);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vpositionsDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vpositions> list = new ArrayList<Vpositions>();
			Vpositions vpositions = new Vpositions();
			//错误消息：数据库操作异常，查询失败!
			vpositions.setMessageCode(IConstant.EMSG0004);
			vpositions.setRetErrFlag(true);
			vpositions.setExceMessage(e.getMessage());
			list.add(vpositions);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
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
	public Map<String, Object> getRoleInfo(Vpositions entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vpositions> list = (List<Vpositions>) vpositionsDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Vpositions vpositions = new Vpositions();
				//消息：检索为0
				vpositions.setMessageCode(IConstant.EMSG0001);
				vpositions.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", vpositions);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Vpositions vpositions = new Vpositions();
			//错误消息：数据库操作异常，查询失败!
			vpositions.setMessageCode(IConstant.EMSG0004);
			vpositions.setRetErrFlag(true);
			vpositions.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", vpositions);
			return rtn;
		}
	}
	
	/**
	 * 角色删除
	 * 
	 * @param position
	 *            页面查询条件
	 * @return 角色信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> roleDelete(Position position, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Position entity = new Position();
			entity.setPositionID(position.getPositionIDWhere());
			entity.setUpdateTime(position.getUpdateTimeWhere());
			entity.setUpdateUser(position.getUpdateUserWhere());
			entity.setVersion(position.getVersionWhere());
			List<Position> list = (List<Position>) positionDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Position();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = positionDao.updateNonQuery(position);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Position entity = new Position();
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
	 * 新建角色信息
	 * 
	 * @param position
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> roleAdd(Position position,Dplink dplink, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			position.setPositionID(NextKeyValue.getNextkeyvalue(
					IConstant.POSITION, IConstant.POSITION_ID, position.getUpdateUser()));// 取得角色表主键
			positionDao.insert(position);

			dplink.setdpLinkID(NextKeyValue.getNextkeyvalue(
					IConstant.DPLINK, IConstant.DPLINK_ID, position.getUpdateUser()));// 取得角色部门中间表表主键
			dplink.setPositionID(position.getPositionID());
			dplinkDao.insert(dplink);
			//成功消息：插入成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Position entity = new Position();
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
	 * 编辑角色信息
	 * @param position
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> roleEdit(Position position, String langCode,String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Position entity = new Position();
			entity.setPositionID(position.getPositionIDWhere());
			entity.setUpdateTime(position.getUpdateTimeWhere());
			entity.setUpdateUser(position.getUpdateUserWhere());
			entity.setVersion(position.getVersionWhere());
			List<Position> list = (List<Position>) positionDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Position();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新职务成功
			@SuppressWarnings("unused")
			int ret = positionDao.updateNonQuery(position);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Position entity = new Position();
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
	 * 新建角色信息验证
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode,String langValue, String userID,int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unused")
			Position position = new Position();
			Map<String, String> map = new HashMap<String, String>();
			if(checkType ==1){ //新建
				if (StringUtils.isEmpty(param.get("DIV_AgencyID").toString())) {// 如果机构未选择
					map.put("DIV_AgencyID", MessageReSource.getMessageBox(
							IConstant.WMSG0015, langCode, langValue));
				}
				//验证部门是否选择
				if (StringUtils.isEmpty(param.get("DIV_DepartmentID").toString())) {// 如果部门未选择
					map.put("DIV_DepartmentID", MessageReSource.getMessageBox(
							IConstant.WMSG0016, langCode, langValue));
				}
				if (StringUtils.isEmpty(param.get("DIV_PositionName").toString())) {// 如果角色名未输入
					map.put("DIV_PositionName", MessageReSource.getMessageBox(
							IConstant.WMSG0020, langCode, langValue));
				}else{
					if (!StringUtils.isEmpty(param.get("DIV_AgencyID").toString())
							&& !StringUtils.isEmpty(param.get("DIV_DepartmentID").toString())) {
						//验证角色名是否存在
						Vpositions vpositions = new Vpositions();
						vpositions.setAgencyID(param.get("DIV_AgencyID").toString());
						vpositions.setDepartmentID(param.get("DIV_DepartmentID").toString());
						vpositions.setPositionName(param.get("DIV_PositionName").toString());
						List<Vpositions> ret = (List<Vpositions>)vpositionsDao.searchByList(vpositions);
						if(ret.size() > 0){//角色唯一性认证
							map.put("DIV_PositionName", MessageReSource.getMessageBox(
									IConstant.WMSG0022, langCode, langValue));
						}
					}
				}
				if (StringUtils.isEmpty(param.get("DIV_PositionCode").toString())) {// 如果角色编码未输入
					map.put("DIV_PositionCode", MessageReSource.getMessageBox(
							IConstant.WMSG0021, langCode, langValue));
				}else{
					if (!StringUtils.isEmpty(param.get("DIV_AgencyID").toString()) 
							&& !StringUtils.isEmpty(param.get("DIV_DepartmentID").toString())) {
						//验证角色编码是否存在
						Vpositions vpositions = new Vpositions();
						vpositions.setAgencyID(param.get("DIV_AgencyID").toString());
						vpositions.setDepartmentID(param.get("DIV_DepartmentID").toString());
						vpositions.setPositionCode(param.get("DIV_PositionCode").toString());
						List<Vpositions> ret = (List<Vpositions>)vpositionsDao.searchByList(vpositions);
						if(ret.size() > 0){//角色编码唯一性验证
							map.put("DIV_PositionCode", MessageReSource.getMessageBox(
									IConstant.WMSG0023, langCode, langValue));
						}
					}
				}
				if (StringUtils.isEmpty(param.get("DIV_LanguageCode").toString())) {// 如果语言未选择
					map.put("DIV_LanguageCode", MessageReSource.getMessageBox(
							IConstant.WMSG0024, langCode, langValue));
				}
				if (StringUtils.isEmpty(param.get("DIV_DelFlag").toString())) {// 如果删除区分未选择
					map.put("DIV_DelFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
			}else if(checkType ==2){ //编辑
				if (StringUtils.isEmpty(param.get("DIV_PositionName").toString())) {// 如果角色名未输入
					map.put("DIV_PositionName", MessageReSource.getMessageBox(
							IConstant.WMSG0020, langCode, langValue));
				}
				if (StringUtils.isEmpty(param.get("DIV_PositionCode").toString())) {// 如果角色编码未输入
					map.put("DIV_PositionCode", MessageReSource.getMessageBox(
							IConstant.WMSG0021, langCode, langValue));
				}
				if (StringUtils.isEmpty(param.get("DIV_LanguageCode").toString())) {// 如果语言未选择
					map.put("DIV_LanguageCode", MessageReSource.getMessageBox(
							IConstant.WMSG0024, langCode, langValue));
				}
				if (StringUtils.isEmpty(param.get("DIV_DelFlag").toString())) {// 如果删除区分未选择
					map.put("DIV_DelFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
			}
			if(map.size()>0){
				rtn.put("message", map);
				rtn.put("data", null);
				rtn.put("status", IConstant.RESULT_CODE_2);
			}
			return rtn;
			
		} catch (SQLException e){
			Position entity = new Position();
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
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param langCode
	 * @param langValue
     * @return
     */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID,String langCode,String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			Displayeditemconfiguration entity = new Displayeditemconfiguration();
			entity.setPageName(pageID);
			entity.setLanguageCode(langCode);
		
			List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>)displayeditemconfigurationDao.searchByList(entity);
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
					rtn.put(displayeditemconfiguration.getColName(), IConstant.DISPLAYED_FLAG_0.equals(displayeditemconfiguration.getDisplayedFlag())?true:false);
				}
				return rtn;
			}

		} catch (SQLException e) {
			List<Displayeditemconfiguration> list = new ArrayList<Displayeditemconfiguration>();
			Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
			//错误消息：数据库操作异常，查询失败!
			displayeditemconfiguration.setMessageCode(IConstant.EMSG0004);
			displayeditemconfiguration.setRetErrFlag(true);
			displayeditemconfiguration.setExceMessage(e.getMessage());
			list.add(displayeditemconfiguration);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
	
		}
	}
}
