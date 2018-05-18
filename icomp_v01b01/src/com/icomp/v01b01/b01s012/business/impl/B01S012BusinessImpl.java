package com.icomp.v01b01.b01s012.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s012.ICOMPV01B01S012Service;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vauthorization;
import com.icomp.v01b01.b01s012.business.B01S012Business;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 库存异常报警 BUSINESS实现类
 * @ClassName: B01S012BusinessImpl 
 * @author Taoyy
 * @date 2014-8-14 下午04:08:02
 */
public class B01S012BusinessImpl implements B01S012Business{


	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}
	/**
	 * 库存异常报警 SERVICE
	 */
	private ICOMPV01B01S012Service icompv01b01s012Service;
	public void setIcompv01b01s012Service(ICOMPV01B01S012Service icompv01b01s012Service) {
		this.icompv01b01s012Service = icompv01b01s012Service;
	}



	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 授权查询
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue,int checkType)throws BusinessException {
		String dateStarStr = param.get("dstar").toString().trim();
		String dateEndStr = param.get("dend").toString().trim();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		/**
		 *  设置检索条件
		 */
		Vauthorization entity = new Vauthorization();
		try {
			// 出库开始时间
			if (dateStarStr != null && dateStarStr != "") {
				dateStarStr+=" 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));
			}
			// 出库结束时间
			if (dateEndStr != null && dateEndStr != "") {
				dateEndStr+=" 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 出库开始时间
		// 出库开始时间
		// 原因
		entity.setAuthorizedReason(StringUtils.isEmpty(param.get("authorizedReason").toString()) ? null : param.get("authorizedReason").toString());
		//材料号
		entity.setToolCode(StringUtils.isEmpty(param.get("systeCode").toString()) ? null : param.get("systeCode").toString());
		//时间
		//授权人
		entity.setAuthorizationUser(StringUtils.isEmpty(param.get("authorizationName").toString()) ? null : param.get("authorizationName").toString());
		entity.setEmpCard(StringUtils.isEmpty(param.get("authorizationName").toString()) ? null : param.get("authorizationName").toString());
		//操作流程

		entity.setBusinessCode(StringUtils.isEmpty(param.get("OperationConten").toString()) ? null : param.get("OperationConten").toString());
		//情况简述
		entity.setNote(StringUtils.isEmpty(param.get("SituationBrief").toString()) ? null : param.get("SituationBrief").toString());
		if (checkType==1) {

			// 分页起始行数
			entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
			// 分页页数
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
			// 排序
			entity.setOrderString("authorizedTime desc");
		}else if(checkType==2){
			entity.setStaIndex(0);
			entity.setRowCount(3000);
		}
		// 授权列表-模糊查询
		Map<String, Object> rtn = icompv01b01s012Service.getInventoryCountLists(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vauthorization>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
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
		List<Business> businessesList = icompv01b01s012Service.getBusiness();
		if(businessesList.size()>0 && businessesList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(businessesList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("BusinessesList", businessesList);
		return ret;
	}

	@Override
	public String getNumber() throws BusinessException {

		return icompv01b01s012Service.getNumber();
	}

}
