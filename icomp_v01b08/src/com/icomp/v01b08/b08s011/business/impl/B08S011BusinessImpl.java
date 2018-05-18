package com.icomp.v01b08.b08s011.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s011.ICOMPV01B08S011Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Stack;
import com.icomp.entity.base.Vlibrarycode;
import com.icomp.entity.base.Vprocess;
import com.icomp.entity.base.Vstack;
import com.icomp.v01b08.b08s011.business.B08S011Business;

public class B08S011BusinessImpl implements B08S011Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S011Service iCOMPV01B08S011Service;

	public void setiCOMPV01B08S011Service(
			ICOMPV01B08S011Service iCOMPV01B08S011Service) {
		this.iCOMPV01B08S011Service = iCOMPV01B08S011Service;
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
	 * 取得库房货架配置列表
	 * @param param 页面检索条件
	 * @param langCode 语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)
			throws BusinessException {
		// 设置检索条件
		Vstack entity = new Vstack();
		// 厂区
		entity.setComplex(StringUtils.isEmpty(param.get("Complex").toString())?null:param.get("Complex").toString());
		// 库房号
		entity.setDepot(StringUtils.isEmpty(param.get("Depot").toString())?null:param.get("Depot").toString());
		// 货架
		entity.setShelf(StringUtils.isEmpty(param.get("Shelf").toString())?null:param.get("Shelf").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("StackID");		
		Map<String,Object> rtn = iCOMPV01B08S011Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			 throw new BusinessException(((List<Vstack>)rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 删除库房货架配置
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> stackDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		Stack stack = new Stack();
		stack.setDelFlag(IConstant.DEL_FLAG_1);    //删除区分
		stack.setUpdateTime(new Date());           //更新时间
		stack.setUpdateUser(customerID);           //更新者
		stack.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));         //版本号
		stack.setStackIDWhere(param.get("stackID").toString());     //货架ID
		stack.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " "))); //更新时间
		stack.setUpdateUserWhere(param.get("updateuser").toString());                                  //更新者
		stack.setVersionWhere(new BigDecimal(param.get("version").toString()));                        //版本号
		Map<String,Object> ret = iCOMPV01B08S011Service.stackDelete(stack,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Stack)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;

	}

	/**
	 * 添加库房货架配置信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> stackAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//库房货架输入验证
		Map<String,Object> ret = iCOMPV01B08S011Service.checkInput(param,langCode,langValue,customerID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Stack)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		
		Stack stack = new Stack();
		stack.setremark(param.get("DIVRemark").toString());//备注
		stack.setDelFlag(param.get("DIVDelFlag").toString());                  //删除区分
		stack.setComplex(param.get("DIVComplex").toString());        //语言编码
		stack.setDepot(param.get("DIVDepot").toString());          //工序编码
		stack.setShelf(param.get("DIVShelf").toString());          //工序名称
		stack.setLayer(param.get("DIVLayer").toString());
		stack.setStack(param.get("DIVStack").toString());
		stack.setLibraryCodeID(param.get("DivLibraryCodeID").toString());//库位码id
		stack.setUpdateTime(new Date());                                       //更新时间
		stack.setUpdateUser(customerID);                                       //更新者
		stack.setCreateTime(new Date());                                       //创建时间
		stack.setCreateUser(customerID);                                       //创建者
		stack.setVersion(new BigDecimal(param.get("DivVersion").toString()));	 //版本号

		//保存库房货架信息
		ret = iCOMPV01B08S011Service.stackAdd(stack,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Stack)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 编辑库房货架配置信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> stackEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//工序输入验证
		Map<String,Object> ret = iCOMPV01B08S011Service.checkInput(param,langCode,langValue,customerID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Stack)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Stack stack = new Stack();
		stack.setremark(param.get("DIVRemark").toString());//备注
		stack.setDelFlag(param.get("DIVDelFlag").toString());                  //删除区分
		stack.setComplex(param.get("DIVComplex").toString());        //语言编码
		stack.setDepot(param.get("DIVDepot").toString());          //库房号
		stack.setShelf(param.get("DIVShelf").toString());          //货架
		stack.setLayer(param.get("DIVLayer").toString());
		stack.setStack(param.get("DIVStack").toString());
		stack.setLibraryCodeID(param.get("DivLibraryCodeID").toString());//库位码ID
		stack.setUpdateTime(new Date());                                       //更新时间
		stack.setUpdateUser(customerID);                                       //更新者
		stack.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));	 //版本号
		stack.setStackIDWhere(param.get("DivStackID").toString());         //货架ID
		stack.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));   //更新时间
		stack.setUpdateUserWhere(param.get("DivUpdateUser").toString());                                    //更新者
		stack.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));       
		
		//保存工序信息
		ret = iCOMPV01B08S011Service.stackEdit(stack,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Stack)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得待处理库房货架配置信息
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> stackInfo(Map<String, Object> param,
			String langCode,String langValue) throws BusinessException {
		
		Map<String,Object> ret = new HashMap<String,Object>();
		String stackID = param.get("stackID").toString();
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			//取得待编辑工序信息
			Vstack entity = new Vstack();
			entity.setStackID(stackID);      //工序ID
			ret = iCOMPV01B08S011Service.getStackInfo(entity);
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
	/**
	 * 取得库位码
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<Vlibrarycode> getVLibraryCodeList(Map<String, Object> param,
			String langValue) {
		List<Vlibrarycode> list = iCOMPV01B08S011Service.getVLibraryCodeList(param,langValue);
		return list;
	}
	
}
