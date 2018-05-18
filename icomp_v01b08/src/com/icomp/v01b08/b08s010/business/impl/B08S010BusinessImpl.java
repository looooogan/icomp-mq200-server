package com.icomp.v01b08.b08s010.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s010.ICOMPV01B08S010Service;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Productiondesign;
import com.icomp.entity.base.Vproductiondesign;
import com.icomp.v01b08.b08s010.business.B08S010Business;
@SuppressWarnings("unchecked")
public class B08S010BusinessImpl implements B08S010Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S010Service icompv01b08s010Service;
	public void setIcompv01b08s010Service(
			ICOMPV01B08S010Service icompv01b08s010Service) {
		this.icompv01b08s010Service = icompv01b08s010Service;
	}

	/**
	 * 取得手持机配置列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Map<String, Object> param,String customerID, String langCode,String langValue)
			throws BusinessException {
		// 设置检索条件
		Vproductiondesign entity = new Vproductiondesign();
		// 年
		entity.setProductionYear(StringUtils.isEmpty(param.get("ProductionYear").toString())?null:param.get("ProductionYear").toString());
		// 零部件名称 
		entity.setAssemblyLineID(StringUtils.isEmpty(param.get("AssemblyLineID").toString())?null:param.get("AssemblyLineID").toString());
		entity.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分-有效
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE_12);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("UpdateTime,ProductionYear,AssemblyLineID,ProductionMonth*1");			
		Map<String,Object> rtn = icompv01b08s010Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Vproductiondesign>)rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}


	/**
	 * 取得生产计划
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> productionDesignInfo(Map<String, Object> param,
			String langCode,String customerID, String langValue) {
		// 设置检索条件
		Vproductiondesign entity = new Vproductiondesign();
		entity.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分-有效
		entity.setProductionYear(param.get("Year").toString());// 年
		entity.setAssemblyLineID(param.get("AssemblyLineID").toString());// 零部件名称 
		entity.setOrderString("ProductionMonth*1");	
		Map<String,Object>  rtn = icompv01b08s010Service.getList(entity);
		if(rtn.get("rows") == null){
		}
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Vproductiondesign>)rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}
	
	/**
	 *编辑生产计划
	 * @return
	 */
	@Override
	public Map<String, Object> productionDesignEdit(Map<String, Object> param,
			String langCode, String customerID, String langValue) {
		//输入验证
		Map<String,Object> ret = icompv01b08s010Service.checkInput(param,langCode,customerID,langValue,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Displayeditemconfiguration)ret.get("error")).getMessageCode(), langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		List<Productiondesign> entity  = (List<Productiondesign>)ret.get("data");
		//保存生产计划
		ret = icompv01b08s010Service.productionDesignSave(entity,langCode,customerID,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Productiondesign)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}
	/**
	 * 新建生产计划
	 * @return
	 */
	@Override
	public Map<String, Object> productionDesignAdd(Map<String, Object> param,
			String langCode, String customerID, String langValue) {
		//输入验证
		Map<String,Object> ret = icompv01b08s010Service.checkInput(param,langCode,customerID,langValue,1);
		if(ret.size() > 1 && ret.get("error") != null){
			throw new BusinessException(((Displayeditemconfiguration)ret.get("error")).getMessageCode(), langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		List<Productiondesign> entity  = (List<Productiondesign>)ret.get("data");
		//新建生产计划
		ret = icompv01b08s010Service.productionDesignSave(entity,langCode,customerID,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//新建失败时，返回
			throw new BusinessException(((Productiondesign)ret.get("error")).getMessageCode(),langCode, langValue);
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
	 * 取得零部件列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	
	@Override
	public List<Assemblyline> getPartsList(String dELFLAG_0, String langCode,
			String langValue) {
		Assemblyline entity = new Assemblyline();
		entity.setDelFlag(dELFLAG_0); // 删除区分
		List<Assemblyline> list = icompv01b08s010Service.getAssemblylineList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}

	@Override
	public List<Vproductiondesign> getYearList(String dELFLAG_0, String langCode,
			String langValue) {
		// 设置检索条件
		Vproductiondesign entity = new Vproductiondesign();
		entity.setDelFlag(dELFLAG_0);// 删除区分
		List<Vproductiondesign> rtn = icompv01b08s010Service.getYearList(entity);
		return rtn;
	}

}
