package com.icomp.v01b04.b04s005.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b04.s005.ICOMPV01B04S005Service;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;
import com.icomp.v01b04.b04s005.business.B04S005Business;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *车间工作量汇总BUSINESS实现类
 * @ClassName: B01S005BusinessImpl 
 * @author Taoyy
 * @date 2014-8-14 下午02:02:34
 */
public class B04S005BusinessImpl implements B04S005Business{
	/**
	 * 系统区Service
	 */
	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 车间工作量汇总SERVICE
	 */
	private ICOMPV01B04S005Service icompv01b04s005Service;
	public void setIcompv01b04s005Service(ICOMPV01B04S005Service icompv01b04s005Service) {
		this.icompv01b04s005Service = icompv01b04s005Service;
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
		List<Assemblyline> assemblylineList = icompv01b04s005Service.getAssemblyline();
		if(assemblylineList.size()>0 && assemblylineList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(assemblylineList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("AssemblyLineList", assemblylineList);
		//取得轴编号
		List<Axle> axleList = icompv01b04s005Service.getAxleLine();
		if(axleList.size()>0 && axleList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(axleList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("AxleLineList", axleList);
		//取得工序列表
		List<Process> processList = icompv01b04s005Service.getProcess();
		if(processList.size()>0 && processList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(processList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("ProcessList", processList);
		//取得设备列表
		List<Equipment> equipmentList = icompv01b04s005Service.getEquipment();
		if(equipmentList.size()>0 && equipmentList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(equipmentList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("EquipmentList", equipmentList);
		//取得零部件列表
		List<Parts> partsList = icompv01b04s005Service.getParts();
		if(partsList.size()>0 && partsList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(partsList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("PartsList", partsList);


		return ret;
	}

	@Override
	public String getNumber() throws BusinessException {
		return icompv01b04s005Service.getNumber();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 车间工作量汇总列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue,int checkType) throws BusinessException{

		/**
		 *  设置检索条件
		 */
		String dateStarStr = param.get("dstar").toString().trim();
		String dateEndStr = param.get("dend").toString().trim();

		//Vsynthesistoolsmachining entity = new Vsynthesistoolsmachining();
		Vworkshopsummary entity = new Vworkshopsummary();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			// 申请起始时间
			if (dateStarStr != null && dateStarStr != "") {
				dateStarStr += " 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));
			}
			// 申请结束时间
			else if (dateEndStr != null && dateEndStr != "") {
				dateEndStr += " 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//生产线
		entity.setAssemblyLineID(StringUtils.isEmpty(param.get("productionLine").toString()) ? null : param.get("productionLine").toString());
		//工序
		entity.setProcessID(StringUtils.isEmpty(param.get("procedure").toString()) ? null : param.get("procedure").toString());
		//设备
		entity.setEquipmentID(StringUtils.isEmpty(param.get("equipment").toString()) ? null : param.get("equipment").toString());
		//轴号
		entity.setAxleID(StringUtils.isEmpty(param.get("axisNumber").toString()) ? null : param.get("axisNumber").toString());
		//机型
    	entity.setPartsID(StringUtils.isEmpty(param.get("model").toString()) ? null : param.get("model").toString());
		//合成刀具编码
		entity.setSynthesisParametersCode(StringUtils.isEmpty(param.get("toolCode").toString()) ? null : param.get("toolCode").toString());


		//汇总--年月周日
	//	entity.setSummary(StringUtils.isEmpty(param.get("datePeriod").toString()) ? null : param.get("datePeriod").toString());.
		if (checkType==1) {
			//分页起始行数
			entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
			//分页页数
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
			//排序
			entity.setOrderString("outerTime desc");
		}else if (checkType==2){
			entity.setStaIndex(0);
			entity.setRowCount(3000);
		}
		//车间工作量汇总列表
		Map<String, Object> rtn = icompv01b04s005Service.getLists(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vworkshopsummary>) rtn.get("error")).get(0).getMessageCode(), langCode,langValue);
		}
		return rtn;
	}


	/**
	 * 取得系统区分列表
	 * @param worksummary 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String worksummary,String langCode, String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(worksummary);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
		}
		return list;
	}

}
