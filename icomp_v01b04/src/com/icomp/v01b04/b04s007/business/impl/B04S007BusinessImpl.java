package com.icomp.v01b04.b04s007.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b04.s007.ICOMPV01B04S007Service;
import com.icomp.entity.base.Vwarning;
import com.icomp.entity.base.Warning;
import com.icomp.v01b04.b04s007.business.B04S007Business;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *加工信息快速查询BUSINESS实现类
 * @ClassName: B01S006BusinessImpl 
 * @author Taoyy
 * @date 2014-8-14 下午02:02:34
 */
public class B04S007BusinessImpl implements B04S007Business {


	/**
	 * 加工信息快速查询SERVICE
	 */
	private ICOMPV01B04S007Service icompv01b04s007Service;

	public void setIcompv01b04s007Service(ICOMPV01B04S007Service icompv01b04s007Service) {
		this.icompv01b04s007Service = icompv01b04s007Service;
	}

	/**
	 * 加工信息快速查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue)throws BusinessException {

		/**
		 *  设置检索条件
		 */
		Vwarning entity = new Vwarning();
		entity.setWarningFunction(StringUtils.isEmpty(param.get("warningfunction").toString()) ? null : param.get("warningfunction").toString());
		entity.setWarningName(StringUtils.isEmpty(param.get("warningname").toString()) ? null : param.get("warningname").toString());
		//分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		//分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		//排序
//		entity.setOrderString("ToolCode");
		Map<String, Object> rtn = icompv01b04s007Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vwarning>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}

	@Override
	public Map<String, Object> VwarningAdd(Map<String, Object> param, String userID, String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = icompv01b04s007Service.checkInput(param,langCode,langValue,userID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			throw new BusinessException(((Warning)ret.get("error")).getMessageCode(), langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Warning entity =(Warning)ret.get("data");
		//保存打印项目信息
		ret = icompv01b04s007Service.VwarningAdd(entity,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//新建失败时，返回
			throw new BusinessException(((Warning)ret.get("error")).getMessageCode(), langCode,langValue);
		}
		return ret;
	}

	public Map<String, Object> VwarningSsp(Map<String, Object> param, String customerID, String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String, Object>();
		String warningID =  param.get("warningID").toString();

		Warning  entity = new Warning();
		entity.setWarningID(warningID);
		ret = icompv01b04s007Service.getWanrning(param,entity,customerID);
		if(ret.size() > 1 && ret.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((Warning)ret.get("error")).getMessageCode(),langCode,langValue);
		}
	  return ret;
	}

	@Override
	public String getNumber() throws BusinessException {
		return icompv01b04s007Service.getNumber();
	}


}
