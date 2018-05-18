package com.icomp.v01b08.b08s008.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s008.ICOMPV01B08S008Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Process;
import com.icomp.entity.base.Vprocess;
import com.icomp.v01b08.b08s008.business.B08S008Business;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B08S008BusinessImpl implements B08S008Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S008Service iCOMPV01B08S008Service;

	public void setiCOMPV01B08S008Service(
			ICOMPV01B08S008Service iCOMPV01B08S008Service) {
		this.iCOMPV01B08S008Service = iCOMPV01B08S008Service;
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
	 * 取得工序配置列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)
			throws BusinessException {
		// 设置检索条件
		Vprocess entity = new Vprocess();
		// 工序ID
		entity.setProcessName(StringUtils.isEmpty(param.get("ProcessName").toString())?null:param.get("ProcessName").toString());
//   删除分区
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("processName");

		Map<String,Object> rtn = iCOMPV01B08S008Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Vprocess>)rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 删除工序配置
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> processDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		Process process = new Process();
		process.setDelFlag(IConstant.DEL_FLAG_1);    //删除区分
		process.setUpdateTime(new Date());           //更新时间
		process.setUpdateUser(customerID);           //更新者
		process.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));         //版本号
		process.setProcessIDWhere(param.get("processID").toString());                                    //工序ID
		process.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " "))); //更新时间
		process.setUpdateUserWhere(param.get("updateuser").toString());                                  //更新者
		process.setVersionWhere(new BigDecimal(param.get("version").toString()));                        //版本号
		Map<String,Object> ret = iCOMPV01B08S008Service.processDelete(process,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Process)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;

	}

	/**
	 * 添加工序配置信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> processAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//工序输入验证
		Map<String,Object> ret = iCOMPV01B08S008Service.checkInput(param,langCode,langValue,customerID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Process)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Process process = new Process();
//		process.setDelFlag(param.get("DIVDelFlag").toString());                  //删除区分
//		process.setLanguageCode(param.get("DIVLanguageCode").toString());        //语言编码
		process.setProcessCode(param.get("DIVProcessCode").toString());          //工序编码
		process.setProcessName(param.get("DIVProcessName").toString());          //工序名称
		process.setDelFlag(IConstant.DEL_FLAG_0);
		process.setUpdateTime(new Date());                                       //更新时间
		process.setUpdateUser(customerID);                                       //更新者
		process.setCreateTime(new Date());                                       //创建时间
		process.setCreateUser(customerID);                                       //创建者
		process.setVersion(new BigDecimal(param.get("DivVersion").toString()));	 //版本号

		//保存工序信息
		ret = iCOMPV01B08S008Service.processtAdd(process,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Process)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 编辑工序配置信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> processEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//工序输入验证
		Map<String,Object> ret = iCOMPV01B08S008Service.checkInput(param,langCode,langValue,customerID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Process)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Process process = new Process();
		process.setDelFlag(IConstant.STRING_0);                  //删除区分
		process.setLanguageCode("01");        //语言编码
		process.setProcessCode(param.get("DIVProcessCode").toString());          //工序编码
		process.setProcessName(param.get("DIVProcessName").toString());          //工序名称
		process.setUpdateTime(new Date());                                       //更新时间
		process.setUpdateUser(customerID);                                       //更新者
		process.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE)); //版本号
		process.setProcessIDWhere(param.get("DivProcessID").toString());         //工序ID
		process.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));   //更新时间
		process.setUpdateUserWhere(param.get("DivUpdateUser").toString());                                    //更新者
		process.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));                          //版本号
		
		//保存工序信息
		ret = iCOMPV01B08S008Service.processtEdit(process,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Process)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得待处理工序配置信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param langValue
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> processInfo(Map<String, Object> param,
			String langCode,String langValue) throws BusinessException {
		
		Map<String,Object> ret = new HashMap<String,Object>();
		String processID = param.get("processID").toString();
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			//取得待编辑工序信息
			Process entity = new Process();
			entity.setProcessID(processID);      //工序ID
			ret = iCOMPV01B08S008Service.getProcessInfo(entity);
			if(ret.size() > 1 && ret.get("error") != null){
				  //检索错误时，返回
				  throw new BusinessException(((Vprocess)ret.get("error")).getMessageCode(), langCode, langValue);
			}
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
