package com.icomp.v01b08.b08s009.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s009.ICOMPV01B08S009Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Vparts;
import com.icomp.v01b08.b08s009.business.B08S009Business;

public class B08S009BusinessImpl implements B08S009Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S009Service iCOMPV01B08S009Service;

	public void setiCOMPV01B08S009Service(
			ICOMPV01B08S009Service iCOMPV01B08S009Service) {
		this.iCOMPV01B08S009Service = iCOMPV01B08S009Service;
	}
	
	/**
	 * 取得系统区分列表
	 * 
	 * @param flagType
	 *            区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,String langValue)
			throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
		}
		return list;
	}
	
	/**
	 * 取得零部件配置列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)
			throws BusinessException {
		// 设置检索条件
		Vparts entity = new Vparts();
		// 零部件名称
		entity.setPartsName(StringUtils.isEmpty(param.get("PartsName").toString())?null:param.get("PartsName").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("PartsID");
		Map<String,Object> rtn = iCOMPV01B08S009Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Vparts>)rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 删除零部件配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> partsDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		Parts parts = new Parts();
		parts.setDelFlag(IConstant.DEL_FLAG_1);
		parts.setUpdateTime(new Date());
		parts.setUpdateUser(customerID);
		parts.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));
		parts.setPartsIDWhere(param.get("partsID").toString());
		parts.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		parts.setUpdateUserWhere(param.get("updateuser").toString());
		parts.setVersionWhere(new BigDecimal(param.get("version").toString()));
		Map<String,Object> ret = iCOMPV01B08S009Service.partsDelete(parts,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Parts)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 新建零部件配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> partsAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//零部件输入验证
		Map<String,Object> ret = iCOMPV01B08S009Service.checkInput(param,langCode,langValue,customerID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Parts)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Parts parts = new Parts();
		parts.setDelFlag(param.get("DIVDelFlag").toString());
		parts.setLanguageCode(param.get("DIVLanguageCode").toString());
		parts.setPartsCode(param.get("DIVPartsCode").toString());
		parts.setPartsName(param.get("DIVPartsName").toString());
		parts.setUpdateTime(new Date());
		parts.setUpdateUser(customerID);
		parts.setCreateTime(new Date());
		parts.setCreateUser(customerID);
		parts.setVersion(new BigDecimal(param.get("DivVersion").toString()));

		//保存系统码表信息
		ret = iCOMPV01B08S009Service.partsAdd(parts,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Parts)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得待处理零部件配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> partsInfo(Map<String, Object> param,
			String langCode,String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object>();
		String partsID = param.get("partsID").toString();
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			//取得待编辑零部件信息
			Parts entity = new Parts();
			entity.setPartsID(partsID);
			ret = iCOMPV01B08S009Service.getPartsInfo(entity);
			if(ret.size() > 1 && ret.get("error") != null){
				  //检索错误时，返回
				  throw new BusinessException(((Parts)ret.get("error")).getMessageCode(), langCode, langValue);
			}
		}
		return ret;
	}

	@Override
	public Map<String, Object> partsEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//零部件输入验证
		Map<String,Object> ret = iCOMPV01B08S009Service.checkInput(param,langCode,langValue,customerID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Parts)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Parts parts = new Parts();
		parts.setPartsID(param.get("DivPartsID").toString());//零部件ID
		parts.setDelFlag(param.get("DIVDelFlag").toString());//删除区分
		parts.setLanguageCode(param.get("DIVLanguageCode").toString());
		parts.setPartsCode(param.get("DIVPartsCode").toString());
		parts.setPartsName(param.get("DIVPartsName").toString());
		parts.setUpdateTime(new Date());
		parts.setUpdateUser(customerID);
		parts.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));	
		parts.setPartsIDWhere(param.get("DivPartsID").toString());
		parts.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
		parts.setUpdateUserWhere(param.get("DivUpdateUser").toString());
		parts.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));

		//保存零部件信息
		ret = iCOMPV01B08S009Service.partsEdit(parts,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Parts)ret.get("error")).getMessageCode(), langCode, langValue);
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
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

}
