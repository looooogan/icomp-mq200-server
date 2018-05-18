package com.icomp.v01b08.b08s013.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s013.ICOMPV01B08S013Service;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;
import com.icomp.v01b08.b08s013.business.B08S013Business;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public class B08S013BusinessImpl implements B08S013Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S013Service iCOMPV01B08S013Service;

	public void setiCOMPV01B08S013Service(
			ICOMPV01B08S013Service iCOMPV01B08S013Service) {
		this.iCOMPV01B08S013Service = iCOMPV01B08S013Service;
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

	 * @return
	 * @throws BusinessException
	 */

	public Map<String,Object> getList(Map<String,Object> param,String langCode, String langValue)throws BusinessException{
		//设置检索条件
		Voplink entity = new Voplink();
		entity.setAssemblyLineID(StringUtils.isEmpty(param.get("AssemblyLineID").toString())?null:param.get("AssemblyLineID").toString());
		entity.setEquipmentID(StringUtils.isEmpty(param.get("EquipmentID").toString())?null:param.get("EquipmentID").toString());
		entity.setProcessID(StringUtils.isEmpty(param.get("ProcessID").toString())?null:param.get("ProcessID").toString());
		entity.setPartsID(StringUtils.isEmpty(param.get("PartsID").toString())?null:param.get("PartsID").toString());
		entity.setSynthesisParametersCode(StringUtils.isEmpty(param.get("SynthesisParametersID").toString())?null:param.get("SynthesisParametersID").toString());
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		//entity.setSynthesisParametersCode(param.get("SynthesisParametersID")==null?null:param.get("SynthesisParametersID").toString());
		//分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		//分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("AssemblyLineID,ProcessID,PartsID");

		Map<String,Object> rtn = iCOMPV01B08S013Service.getList(entity);

		if(rtn.size() > 1 && rtn.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((List<Voplink>)rtn.get("error")).get(0).getMessageCode(), langCode,  langValue);
		}
		return rtn;
	}


	/**
	 * 取得页面下拉列表内容
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException{
		Map<String,Object> ret = new HashMap<String,Object> ();
		//取得零部件列表
		List<Assemblyline> assemblylineList = iCOMPV01B08S013Service.getAssemblyLine();
		if(assemblylineList.size()>0 && assemblylineList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(assemblylineList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("AssemblyLineList", assemblylineList);
		//取得轴编号
		List<Axle> axleList = iCOMPV01B08S013Service.getAxleLine();
		if(axleList.size()>0 && axleList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(axleList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("AxleLineList", axleList);
		//取得工序列表
		List<Process> processList = iCOMPV01B08S013Service.getProcess();
		if(processList.size()>0 && processList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(processList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("ProcessList", processList);
		//取得设备列表
		List<Equipment> equipmentList = iCOMPV01B08S013Service.getEquipment();
		if(equipmentList.size()>0 && equipmentList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(equipmentList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("EquipmentList", equipmentList);
		//取得合成刀具列表
		List<Synthesisparameters> synthesisparametersList = iCOMPV01B08S013Service.getSynthesisParameters();
		if(equipmentList.size()>0 && synthesisparametersList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(synthesisparametersList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("SynthesisParametersList", synthesisparametersList);
		//取得加工工艺列表
		List<Parts> partsList = iCOMPV01B08S013Service.getParts();
		if(equipmentList.size()>0 && partsList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(partsList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("PartsList", partsList);

		return ret;
	}

	/**
	 * 取得关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkInfo(Map<String,Object> param,String langCode,String langValue){
		//设置检索条件
		Oplink entity = new Oplink();

		entity.setOplinkID(StringUtils.isEmpty(param.get("oplinkID").toString())?null:param.get("oplinkID").toString());


		Map<String,Object> rtn = iCOMPV01B08S013Service.oplinkInfo(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((List<Voplink>)rtn.get("error")).get(0).getMessageCode(), langCode,  langValue);
		}
		return rtn;
	}

	/**
	 * 编辑关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkEdit(Map<String,Object> param,String userID,String langCode,String langValue){
		//用户输入验证
//		Map<String,Object> ret = iCOMPV01B08S013Service.checkInput(param,langCode, langValue,userID,2);
//		if(ret.size() > 1 && ret.get("error") != null){
//			  throw new BusinessException(((Oplink)ret.get("error")).getMessageCode(), langCode,  langValue);
//		}else if(ret.size() > 1 && ret.get("message") != null){
//			return ret;
//		}
//		Oplink oplink = (Oplink)ret.get("data");
//		oplink.setOplinkIDWhere(StringUtils.isEmpty(param.get("DivOplinkID").toString())?null:param.get("DivOplinkID").toString());

		// 2017/07/03 宋健 追加↓↓↓　dazhong@YMSC
		//保存角色信息
		Oplink oplink = new Oplink();
		oplink.setOplinkID(param.get("DivOplinkID").toString());
		oplink.setOplinkIDWhere(param.get("DivOplinkID").toString());
		oplink.setProcessID(param.get("DivProcess").toString());
		oplink.setProcessIDWhere(param.get("DivProcess").toString());
		oplink.setEquipmentID(param.get("DivEquipment").toString());
		oplink.setEquipmentIDWhere(param.get("DivEquipment").toString());
		oplink.setAssemblyLineID(param.get("DivAssemblyLine").toString());
		oplink.setAssemblyLineIDWhere(param.get("DivAssemblyLine").toString());
		oplink.setSynthesisParametersID(param.get("SynthesisParameters").toString());
		oplink.setSynthesisParametersIDWhere(param.get("SynthesisParameters").toString());
		oplink.setPartsID(param.get("Parts").toString());
		oplink.setPartsIDWhere(param.get("Parts").toString());
		oplink.setAxleID(param.get("DivAxle").toString());
		oplink.setAxleIDWhere(param.get("DivAxle").toString());
		oplink.setToolDurable(new BigDecimal(param.get("DivToolDurable").toString()));
		oplink.setToolDurableWhere(new BigDecimal(param.get("DivToolDurable").toString()));
		// 2017/07/03 宋健 追加↑↑↑　dazhong@YMSC
		Map<String,Object> ret = iCOMPV01B08S013Service.oplinkEdit(oplink,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//新建失败时，返回
			throw new BusinessException(((Oplink)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

	/**
	 * 新建关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkAdd(Map<String,Object> param,String userID,String langCode,String langValue){
		//用户输入验证
//		Map<String,Object> ret = iCOMPV01B08S013Service.checkInput(param,langCode, langValue,userID,1);
//		if(ret.size() > 1 && ret.get("error") != null){
//			  throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
//		}else if(ret.size() > 1 && ret.get("message") != null){
//			return ret;
//		}
//		Oplink oplink = (Oplink)ret.get("data");

		Oplink oplink = null;
		// 生产线id
		String assemblyLineID = param.get("assemblyLineID").toString();
		// 工序id
		String processID = param.get("processID").toString();
		//设备id
		String[] shebeiIds = param.get("equipmentID").toString().split(",");
		//轴编号
		String[] zhouIds = param.get("axleID").toString().split(",");
		//零部件
		String[] lingbijianIds = param.get("parts").toString().split(",");
		//零部件-合成刀-耐用度拼接
		String[] hechengdaoAndNaiyongdus = param.get("str").toString().split(",");
		Map insertMap = new HashMap<String, Object>();
		Map<String,Object> ret = null;
		oplink = new Oplink();
		// 工序ID
		oplink.setProcessID(processID);
		// 生产线ID
		oplink.setAssemblyLineID(assemblyLineID);
		for(int i = 0;i<shebeiIds.length;i++){
			//设备ID
			oplink.setEquipmentID(shebeiIds[i]);
			for(int j = 0;j<zhouIds.length;j++){
				//轴ID
				oplink.setAxleID(zhouIds[j]);
				for(int l = 0;l<hechengdaoAndNaiyongdus.length;l++){
					//零部件ID
					oplink.setPartsID(hechengdaoAndNaiyongdus[l].split(";")[0]);
					//合成刀ID
					oplink.setSynthesisParametersID(hechengdaoAndNaiyongdus[l].split(";")[1]);
					//耐用度
					oplink.setToolDurable(BigDecimal.valueOf(Double.parseDouble(hechengdaoAndNaiyongdus[l].split(";")[2])));
					//保存关联信息
					ret = iCOMPV01B08S013Service.oplinkAdd(oplink,langCode, langValue);

				}
			}
		}

		if(ret.size() > 1 && ret.get("error") != null){
			//新建失败时，返回
			throw new BusinessException(((Position)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

	/**
	 * 删除关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkDelete(Map<String,Object> param,String userID,String langCode,String langValue){
		Oplink oplink = new Oplink();
		oplink.setOplinkIDWhere(StringUtils.isEmpty(param.get("oplinkID").toString())?null:param.get("oplinkID").toString());
		Map<String,Object> ret = iCOMPV01B08S013Service.oplinkDelete(oplink,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//删除失败时，返回
			throw new BusinessException(((Oplink)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

	@Override
	public List<Voplinkdown> getVoplink(Map<String, Object> param, String delFlag0, String langCode, String langValue, int i) {
		Voplinkdown entity = new Voplinkdown();
		String AssemblylineID =(String) param.get("productionLineID");
		String ProcedureID = (String)param.get("procedureID");
		String EquipmentID = (String) param.get("equipmentID");


		entity.setAssemblyLineID(AssemblylineID);
		entity.setProcessID(ProcedureID);
		entity.setEquipmentID(EquipmentID);
		entity.setDelFlag(delFlag0);
		entity.setGroupString("ProcessCode,EquipmentID,partsID");
		entity.setOrderString("AxleCode");
		List<Voplinkdown> list = iCOMPV01B08S013Service.getVoplinList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}
}
