package com.icomp.v01b08.b08s006.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s006.ICOMPV01B08S006Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Handset;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vhandset;
import com.icomp.v01b08.b08s006.business.B08S006Business;

public class B08S006BusinessImpl implements B08S006Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S006Service iCOMPV01B08S006Service;

	public void setiCOMPV01B08S006Service(
			ICOMPV01B08S006Service iCOMPV01B08S006Service) {
		this.iCOMPV01B08S006Service = iCOMPV01B08S006Service;
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
	 * 取得手持机配置列表
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
		Vhandset entity = new Vhandset();
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 手持机编码
		entity.setHandSetCode(StringUtils.isEmpty(param.get("HandSetCode").toString())?null:param.get("HandSetCode").toString());
		// 手持机名称
		entity.setHandSetName(StringUtils.isEmpty(param.get("HandSetName").toString())?null:param.get("HandSetName").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("HandSetID");			
		Map<String,Object> rtn = iCOMPV01B08S006Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Vhandset>)rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 删除手持机配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> handSetDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		Handset handset = new Handset();
		handset.setDelFlag(IConstant.DEL_FLAG_1);//删除区分设为1
		handset.setUpdateTime(new Date());//更新时间
		handset.setUpdateUser(customerID);//更新者
		handset.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));//版本号加1
		handset.setHandSetIDWhere(param.get("handSetID").toString());//手持机ID
		handset.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));//更新时间
		handset.setUpdateUserWhere(param.get("updateuser").toString());//更新者
		handset.setVersionWhere(new BigDecimal(param.get("version").toString()));//版本号
		//删除手持机信息
		Map<String,Object> ret = iCOMPV01B08S006Service.handsetDelete(handset,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Handset)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	/**
	 * 新建手持机配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> handSetAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//手持机输入验证
		Map<String,Object> ret = iCOMPV01B08S006Service.checkInput(param,langCode,langValue,customerID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Handset)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Handset handset = new Handset();
		handset.setDelFlag(param.get("DIVDelFlag").toString());
		handset.setDepartmentID(param.get("DIVDepartment").toString());
		handset.setHandSetCode(param.get("DIVHandSetCode").toString());
		handset.setHandSetName(param.get("DIVHandSetName").toString());
		handset.setHandSetStauts(param.get("DIVHandSetStauts").toString());
		handset.setIsRegistration(param.get("DIVIsRegistration").toString());
		handset.setLoginStauts(param.get("DIVLoginStauts").toString());
		handset.setUpdateTime(new Date());
		handset.setUpdateUser(customerID);
		handset.setCreateTime(new Date());
		handset.setCreateUser(customerID);
		handset.setVersion(new BigDecimal(param.get("DivVersion").toString()));

		//保存系统码表信息
		ret = iCOMPV01B08S006Service.handsetAdd(handset,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Handset)ret.get("error")).getMessageCode(), langCode,langValue);
		}
		return ret;
	}

	/**
	 * 编辑手持机配置信息
	 * @param param 页面检索条件
	 * @param langValue 
	 * @param customerID
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> handSetEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
   		//手持机输入验证
		Map<String,Object> ret = iCOMPV01B08S006Service.checkInput(param,langCode,langValue,customerID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Handset)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Handset handset = new Handset();
		handset.setHandSetID(param.get("DivHandSetID").toString());	
		handset.setDelFlag(param.get("DIVDelFlag").toString());
		handset.setDepartmentID(param.get("DIVDepartment").toString());
//		handset.setHandSetCode(param.get("DIVHandSetCode").toString());
		handset.setHandSetName(param.get("DIVHandSetName").toString());
		handset.setHandSetStauts(param.get("DIVHandSetStauts").toString());
		handset.setIsRegistration(param.get("DIVIsRegistration").toString());
		handset.setLoginStauts(param.get("DIVLoginStauts").toString());
		handset.setUpdateTime(new Date());
		handset.setUpdateUser(customerID);
		handset.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));		
		handset.setHandSetIDWhere(param.get("DivHandSetID").toString());
		handset.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
		handset.setUpdateUserWhere(param.get("DivUpdateUser").toString());
		handset.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
		
		//保存手持机信息
		ret = iCOMPV01B08S006Service.handsetEdit(handset,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Handset)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得待处理手持机信息
	 * @param param 页面检索条件
	 * @param langValue 语言
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> handSetInfo(Map<String, Object> param,String langCode,
			String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object>();
		String handSetID = param.get("handSetID").toString();
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			//取得待编辑手持机信息
			Handset entity = new Handset();
			entity.setHandSetID(handSetID);
			ret = iCOMPV01B08S006Service.getHandsetInfo(entity);
			if(ret.size() > 1 && ret.get("error") != null){
				  //检索错误时，返回
				  throw new BusinessException(((Handset)ret.get("error")).getMessageCode(),langCode, langValue);
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

	/**
	 * 取得部门列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Object getVdepartment(String dELFLAG, String langCode,
			String langValue) {
		Vdepartment entity = new Vdepartment();
		entity.setDepartmentDelFlag(dELFLAG);
		List<Vdepartment> list = service.getVdepartment(entity);
		return list;
	}
}
