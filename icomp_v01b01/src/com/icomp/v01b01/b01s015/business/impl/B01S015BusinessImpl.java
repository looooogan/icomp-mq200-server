package com.icomp.v01b01.b01s015.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s015.ICOMPV01B01S015Service;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;
import com.icomp.v01b01.b01s015.business.B01S015Business;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 库存盘点查询BUsiness实现类
 * 
 * @ClassName: B01S015BusinessImpl
 * @author Licc
 * @date 2014-11-12 下午04:10:15
 */
public class B01S015BusinessImpl implements B01S015Business {

	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 库存盘点查询SERVICE
	 */
	private ICOMPV01B01S015Service icompv01b01s015Service;

	public void setIcompv01b01s015Service(
			ICOMPV01B01S015Service icompv01b01s015Service) {
		this.icompv01b01s015Service = icompv01b01s015Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 库存盘点列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue)throws BusinessException{
		String dateStarStr = param.get("dstar").toString().trim();
		String dateEndStr = param.get("dend").toString().trim();

		/**
		 * 设置检索条件
		 */
		ToolChangehistory entity = new ToolChangehistory();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			// 申请起始时间
			if (dateStarStr != null && dateStarStr != "") {
				dateStarStr+=" 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));
			}
			// 申请结束时间
			if (dateEndStr != null && dateEndStr != "") {
				dateEndStr+=" 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//生产线
		entity.setAssemblyLineID ( StringUtils.isEmpty ( param.get ( "productionLine" ).toString () ) ? null : param.get ( "productionLine" ).toString () );
		//工序
		entity.setProcessID ( StringUtils.isEmpty ( param.get ( "procedure" ).toString () ) ? null : param.get ( "procedure" ).toString () );
		//加工设备
		entity.setEquipmentID ( StringUtils.isEmpty ( param.get ( "equipment" ).toString () ) ? null : param.get ( "equipment" ).toString () );
		//轴编号
		entity.setAxleID ( StringUtils.isEmpty ( param.get ( "axisNumber" ).toString () ) ? null : param.get ( "axisNumber" ).toString () );
		//机型
		entity.setPartsID ( StringUtils.isEmpty ( param.get ( "model" ).toString () ) ? null : param.get ( "model" ).toString () );
		//合成刀具编码
		entity.setSynthesisParametersCode ( StringUtils.isEmpty ( param.get ( "toolCode" ).toString () ) ? null : param.get ( "toolCode" ).toString () );
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		//排序：刀具编码
		//entity.setOrderString("ToolCode");
		// 库存盘点列表-ToolCode模糊查询
		Map<String, Object> rtn = icompv01b01s015Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<ToolChangehistory>) rtn.get("error")).get(0).getMessageCode(),langCode ,langValue);
		}
		return rtn;
	}

	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
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

	@Override
	public Map<String, Object> getPageSelList(String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object>();

		//取得生产线
		List<Assemblyline> assemblylineList = icompv01b01s015Service.getAssemblyline();
		if(assemblylineList.size()>0 && assemblylineList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(assemblylineList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("AssemblyLineList", assemblylineList);
		//取得轴编号
		List<Axle> axleList = icompv01b01s015Service.getAxleLine();
		if(axleList.size()>0 && axleList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(axleList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("AxleLineList", axleList);
		//取得工序列表
		List<Process> processList = icompv01b01s015Service.getProcess();
		if(processList.size()>0 && processList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(processList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("ProcessList", processList);
		//取得设备列表
		List<Equipment> equipmentList = icompv01b01s015Service.getEquipment();
		if(equipmentList.size()>0 && equipmentList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(equipmentList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("EquipmentList", equipmentList);
		//取得零部件列表
		List<Parts> partsList = icompv01b01s015Service.getParts();
		if(partsList.size()>0 && partsList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(partsList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("PartsList", partsList);


		return ret;
	}
}
