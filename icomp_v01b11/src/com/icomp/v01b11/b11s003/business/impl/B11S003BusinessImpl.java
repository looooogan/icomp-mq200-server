package com.icomp.v01b11.b11s003.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b11.s003.ICOMPV01B11S003Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Dplink;
import com.icomp.entity.base.Position;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;
import com.icomp.entity.base.Vpositions;
import com.icomp.v01b11.b11s003.business.B11S003Business;

public class B11S003BusinessImpl implements B11S003Business{


	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
	private ICOMPV01B11S003Service iCOMPV01B11S003Service;

	public void setiCOMPV01B11S003Service(
			ICOMPV01B11S003Service iCOMPV01B11S003Service) {
		this.iCOMPV01B11S003Service = iCOMPV01B11S003Service;
	}

	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode, String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
		}
		return list;
	}
	
	/**
	 * 取得用户信息列表
	 * @param param 页面检索条件
	 * @param langCode 语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> getList(Map<String,Object> param,String langCode, String langValue)throws BusinessException{
		//设置检索条件
		Vpositions entity = new Vpositions();
		entity.setAgencyID(StringUtils.isEmpty(param.get("AgencyID").toString())?null:param.get("AgencyID").toString());
		entity.setDepartmentID(StringUtils.isEmpty(param.get("DepartmentID").toString())?null:param.get("DepartmentID").toString());
		entity.setPositionID(StringUtils.isEmpty(param.get("PositionID").toString())?null:param.get("PositionID").toString());
		entity.setDelFlag(StringUtils.isEmpty(param.get("DelFlag").toString())?null:param.get("DelFlag").toString());
		//分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		//分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("AgencyID,DepartmentID,PositionID");			
		Map<String,Object> rtn = iCOMPV01B11S003Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Vpositions>)rtn.get("error")).get(0).getMessageCode(), langCode,  langValue);
		}
		return rtn;
	}
	
	/**
	 * 取得部门信息列表
	 * @param param
	 * @return
	 * @throws BusinessException
	 */
	public List<Vagency> getAgencyList(String param,String langCode, String langValue)throws BusinessException{
		Vagency entity = new Vagency();
		entity.setDelFlag(param);
		entity.setAgencyLanguageCode(langCode);
		List<Vagency> list = service.getVagency(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), langCode,  langValue);
		}
		return list;
	
	}

	/**
	 * 取得部门信息列表
	 * @return
	 * @throws BusinessException
	 */
	public  List<Vdepartment> getDepartmentList(String agencyID,String delFlag,String langCode, String langValue)throws BusinessException{
		Vdepartment entity = new Vdepartment();
		entity.setDepartmentAgencyID(agencyID);
		entity.setDepartmentDelFlag(delFlag);
		entity.setDepartmentLanguageCode(langCode);
		List<Vdepartment> list = service.getVdepartment(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}
	

	/**
	 * 取得职务信息列表
	 * @param delFlag 删除区分
	 * @return
	 * @throws BusinessException
	 */
	public List<Vposition> getPositionList(Map<String, Object> param,String delFlag,String langCode, String langValue)throws BusinessException{
		Vposition entity = new Vposition();
		String departmentID = param.get("DepartmentID").toString();
		String agencyID = param.get("AgencyID").toString();
		entity.setDepartmentID(departmentID);
		entity.setAgencyID(agencyID);
		entity.setDelFlag(delFlag);
		List<Vposition> list = service.getVposition(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), langCode,  langValue);
		}
		return list;
	}
	
	/**
	 * 取得待编辑的角色信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> roleInfo(Map<String,Object> param,String langCode, String langValue)throws BusinessException{
		Map<String,Object> ret = new HashMap<String,Object>();
		String roleID = param.get("roleID").toString();
		//取得待编辑用户信息
		Vpositions entity = new Vpositions();
		entity.setPositionID(roleID);
		ret = iCOMPV01B11S003Service.getRoleInfo(entity);
		if(ret.size() > 1 && ret.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((Vpositions)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}
	

	
	/**
	 * 删除角色信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> roleDelete(Map<String,Object> param,String userID,String langCode, String langValue)throws BusinessException{
		 
		Position position = new Position();
		position.setDelFlag(IConstant.DEL_FLAG_1);
		position.setUpdateTime(new Date());
		position.setUpdateUser(userID);
		position.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));
		position.setPositionIDWhere(param.get("roleID").toString());
		position.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		position.setUpdateUserWhere(param.get("updateuser").toString());
		position.setVersionWhere(new BigDecimal(param.get("version").toString()));
		Map<String,Object> ret = iCOMPV01B11S003Service.roleDelete(position,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

	
	/**
	 * 新建角色信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> roleAdd(Map<String,Object> param,String userID,String langCode, String langValue)throws BusinessException{
		//用户输入验证
		Map<String,Object> ret = iCOMPV01B11S003Service.checkInput(param,langCode, langValue,userID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Position position = new Position();
		position.setDelFlag(param.get("DIV_DelFlag").toString());
		position.setLanguageCode(param.get("DIV_LanguageCode").toString());
		position.setPositionCode(param.get("DIV_PositionCode").toString());
		position.setPositionName(param.get("DIV_PositionName").toString());
		position.setUpdateTime(new Date());
		position.setUpdateUser(userID);
		position.setCreateTime(new Date());
		position.setCreateUser(userID);
		position.setVersion(new BigDecimal(param.get("DivVersion").toString()));
		Dplink dplink = new Dplink();
		dplink.setDepartmentID(param.get("DIV_DepartmentID").toString());
		//保存角色信息
		ret = iCOMPV01B11S003Service.roleAdd(position,dplink,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}
	

	/**
	 * 编辑角色信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> roleEdit(Map<String,Object> param,String userID,String langCode, String langValue)throws BusinessException{
		//用户输入验证
		Map<String,Object> ret = iCOMPV01B11S003Service.checkInput(param,langCode, langValue,userID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Position position = new Position();
		position.setDelFlag(param.get("DIV_DelFlag").toString());
		position.setLanguageCode(param.get("DIV_LanguageCode").toString());
		position.setPositionCode(param.get("DIV_PositionCode").toString());
		position.setPositionName(param.get("DIV_PositionName").toString());
		position.setUpdateTime(new Date());
		position.setUpdateUser(userID);
		position.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
		position.setPositionIDWhere(param.get("DivPositionID").toString());
		position.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
		position.setUpdateUserWhere(param.get("DivUpdateUser").toString());
		position.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
		//保存角色信息
		ret = iCOMPV01B11S003Service.roleEdit(position,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}
	
	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID,String userID,String langCode, String langValue)throws BusinessException{
		
		//取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if(ret.size() > 1 && ret.get("error") != null){
			  //取得失败时，返回
			  throw new BusinessException(((List<Displayeditemconfiguration>)ret.get("error")).get(0).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}
}
