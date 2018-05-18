package com.icomp.v01b05.b05s001.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b05.s001.ICOMPV01B05S001Service;
import com.icomp.entity.base.Deliveryplan;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vqualityinspection;
import com.icomp.v01b05.b05s001.business.B05S001Business;

/**
 * 待质检刀具查询BUsiness实现类
 * 
 * @ClassName: B01S001BusinessImpl
 * @author Licc
 * @date 2014-8-12 下午04:10:15
 */
public class B05S001BusinessImpl implements B05S001Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 待质检刀具查询SERVICE
	 */
	private ICOMPV01B05S001Service icompv01b05s001Service;

	public void setIcompv01b05s001Service(ICOMPV01B05S001Service icompv01b05s001Service) {
		this.icompv01b05s001Service = icompv01b05s001Service;
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




	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException {
		/**
		 * 设置检索条件
		 */
		Vqualityinspection entity = new Vqualityinspection();
		// 刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		// 货品状态：已到货
		entity.setTheyStatus(IConstant.STRING_1);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ProcuredBatch");			
		// 待质检刀具查询列表-ToolCode模糊查询
		Map<String, Object> rtn = icompv01b05s001Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vqualityinspection>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}

	@Override
	public Map<String, Object> deliveryplanEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//输入验证
		Map<String,Object> ret = icompv01b05s001Service.checkInput(param,langCode,customerID,2,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Deliveryplan)ret.get("error")).getMessageCode(),langCode, langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
	    ret = icompv01b05s001Service.deliveryplanEdit((Deliveryplan)ret.get("data"),langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //编辑失败时，返回
			  throw new BusinessException(((Deliveryplan)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> deliveryplanInfo(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object>();
		String deliveryplanID = param.get("deliveryPlanID").toString();
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			//取得待质检的刀具信息
			Deliveryplan entity = new Deliveryplan();
			entity.setDeliveryPlanID(deliveryplanID);
			ret = icompv01b05s001Service.getDeliveryplanInfo(entity);
			if(ret.size() > 1 && ret.get("error") != null){
				  //检索错误时，返回
				  throw new BusinessException(((Deliveryplan)ret.get("error")).getMessageCode(), langCode, langValue);
			}
		}
		return ret;
	}

}
