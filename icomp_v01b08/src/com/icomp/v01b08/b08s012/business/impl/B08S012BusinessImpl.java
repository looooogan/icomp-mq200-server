package com.icomp.v01b08.b08s012.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s012.ICOMPV01B08S012Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.*;
import com.icomp.v01b08.b08s012.business.B08S012Business;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B08S012BusinessImpl implements B08S012Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S012Service iCOMPV01B08S012Service;

	public void setiCOMPV01B08S012Service(
			ICOMPV01B08S012Service iCOMPV01B08S012Service) {
		this.iCOMPV01B08S012Service = iCOMPV01B08S012Service;
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
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得零部件信息列表
	 * @param param 页面检索条件
	 * @param langCode 语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> getList(Map<String,Object> param,String langCode, String langValue)throws BusinessException{
		//设置检索条件
		//Vassemblyline entity = new Vassemblyline();
		Vparts entity = new Vparts();

		entity.setPartsCode(StringUtils.isEmpty(param.get("AssemblyLineCode").toString())?null:param.get("AssemblyLineCode").toString());
		entity.setPartsName(StringUtils.isEmpty(param.get("AssemblyLineName").toString())?null:param.get("AssemblyLineName").toString());
		entity.setDelFlag(StringUtils.isEmpty(param.get("DelFlag").toString())?null:param.get("DelFlag").toString());
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		//分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		//分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("partsCode");
		Map<String,Object> rtn = iCOMPV01B08S012Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((List<Vparts>)rtn.get("error")).get(0).getMessageCode(), langCode,  langValue);
		}
		return rtn;
	}

	/**
	 * 取得待编辑的零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineInfo(Map<String,Object> param,String langCode, String langValue)throws BusinessException{
		Map<String,Object> ret = new HashMap<String,Object>();
		String partsID = param.get("partsID").toString();
		//取得待编辑零部件信息
		Parts entity = new Parts();
		entity.setPartsID(partsID);
		ret = iCOMPV01B08S012Service.paInfo(entity);
		if(ret.size() > 1 && ret.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((Parts)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

	/**
	 * 删除零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineDelete(Map<String,Object> param ,String userID,String langCode, String langValue)throws BusinessException{
		Assemblyline entity = new Assemblyline();
		entity.setDelFlag(IConstant.DEL_FLAG_1);
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(userID);
		entity.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));
		entity.setAssemblyLineIDWhere(param.get("AssemblyLineID").toString());
		entity.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		entity.setUpdateUserWhere(param.get("updateuser").toString());
		entity.setVersionWhere(new BigDecimal(param.get("version").toString()));
		Map<String,Object> ret = iCOMPV01B08S012Service.assemblyLineDelete(entity,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//删除失败时，返回
			throw new BusinessException(((Assemblyline)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> partsDelete(Map<String, Object> param, String userID, String langCode, String langValue) throws BusinessException {
		Parts entity = new Parts();
		entity.setDelFlag(IConstant.DEL_FLAG_1);
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(userID);
		entity.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));
		entity.setPartsID(param.get("partsID").toString());

		entity.setDelFlagWhere(IConstant.DEL_FLAG_0);
		entity.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		entity.setUpdateUserWhere(param.get("updateuser").toString());
		entity.setVersionWhere(new BigDecimal(param.get("version").toString()));
		Map<String,Object> ret = iCOMPV01B08S012Service.partslyLineDelete(entity,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//删除失败时，返回
			throw new BusinessException(((Assemblyline)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

	/**
	 * 新建零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineAdd(Map<String,Object> param ,String userID,String langCode, String langValue)throws BusinessException{
		//用户输入验证
		Map<String,Object> ret = iCOMPV01B08S012Service.checkInput(param,langCode, langValue,userID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		//Assemblyline entity = new Assemblyline();
		Parts entity = new Parts();
		entity.setDelFlag(param.get("DIVDelFlag").toString());

		entity.setPartsCode(param.get("DIVAssemblyLineCode").toString());
		entity.setPartsName(param.get("DIVAssemblyLineName").toString());
		// 2017/08/24 宋健 变更↓↓↓　dazhong@YMSC
//		entity.setPartsType(param.get("DIVAssemblyLineType").toString());
		// 2017/08/24 宋健 变更↑↑↑　dazhong@YMSC
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(userID);
		entity.setCreateTime(new Date());
		entity.setCreateUser(userID);
		entity.setVersion(new BigDecimal(param.get("DivVersion").toString()));
		//保存零部件信息
		ret = iCOMPV01B08S012Service.partsLineAdd(entity,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//新建失败时，返回
			throw new BusinessException(((Assemblyline)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

	/**
	 * 编辑零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineEdit(Map<String,Object> param ,String userID,String langCode, String langValue)throws BusinessException{
		//用户输入验证
		Map<String,Object> ret = iCOMPV01B08S012Service.checkInput(param,langCode, langValue,userID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		//	Assemblyline entity = new Assemblyline();
		Parts entity = new Parts();
		entity.setDelFlag(param.get("DIVDelFlag").toString());
		entity.setPartsCode(param.get("DIVAssemblyLineCode").toString());
		entity.setPartsName(param.get("DIVAssemblyLineName").toString());
		// 2017/08/24 宋健 变更↓↓↓　dazhong@YMSC
//		entity.setPartsType(param.get("DIVAssemblyLineType").toString());
		// 2017/08/24 宋健 变更↑↑↑　dazhong@YMSC
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(userID);
		entity.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));

		entity.setPartsIDWhere(param.get("DivPartsID").toString());
		entity.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
		entity.setUpdateUserWhere(param.get("DivUpdateUser").toString());
		entity.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
		//保存角色信息
		ret = iCOMPV01B08S012Service.parstEdit(entity,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//新建失败时，返回
			throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> getPageSelList(String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object> ();
		//取得零部件列表
		List<Parts> partseslineList = iCOMPV01B08S012Service.getPartsLine();
		if(partseslineList.size()>0 && partseslineList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(partseslineList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("PartsLineList", partseslineList);
		return ret;
	}

}
