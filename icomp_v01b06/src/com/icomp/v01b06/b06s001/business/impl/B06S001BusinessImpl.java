package com.icomp.v01b06.b06s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s001.ICOMPV01B06S001Service;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Vscrap;
import com.icomp.v01b06.b06s001.business.B06S001Business;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 报废分析BUsiness实现类
 * 
 * @ClassName: B06S001BusinessImpl
 * @author Taoyy
 * @date 2014-8-22 上午09:10:39
 */

public class B06S001BusinessImpl implements B06S001Business {
	
	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
	/**
	 * 报废分析SERVICES
	 */
	public ICOMPV01B06S001Service icompv01b06s001Service;

	public void setIcompv01b06s001Service(ICOMPV01B06S001Service icompv01b06s001Service) {
		this.icompv01b06s001Service = icompv01b06s001Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue,int checkType)throws BusinessException {
		/**
		 * 设置检索条件
		 */
	//	Vscrapanalysis entity = new Vscrapanalysis();
		Vscrap entity = new Vscrap();
		String dateStarStr = null;
		String  dateEndStr = null;
		if (param.get("DateStar") != null) {
			dateStarStr =String.valueOf(param.get("DateStar")).trim();
		}
		if (param.get("DateEnd") != null) {
			dateEndStr =String.valueOf( param.get("DateEnd")).trim();
		}

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			// 申请起始时间
			if (dateStarStr != null &&  !"".equals(dateStarStr)) {
				dateStarStr+=" 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));
			}
			// 申请结束时间
			if (dateEndStr != null && !"".equals(dateEndStr)) {
				dateEndStr+=" 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();

		}

		//授权人
		if(!StringUtils.isEmpty(param.get("Authorized").toString())) {entity.setAuthorizationUser(param.get("Authorized").toString());}
		//操作流程
		if(!StringUtils.isEmpty(param.get("Operation").toString())){entity.setBusinessID(param.get("Operation").toString());}
		//库房点验者o
		if(!StringUtils.isEmpty(param.get("StorageCheck").toString())){entity.setCreateUser(param.get("StorageCheck").toString());}
		//刀具类型
		//if(!StringUtils.isEmpty(param.get("ToolConsumetype").toString())){entity.setToolType(param.get("ToolConsumetype").toString());}
		// 刀具编码
		if(!StringUtils.isEmpty(param.get("ToolCode").toString())){entity.setToolCode(param.get("ToolCode").toString());}
		//报废原因
		if(!StringUtils.isEmpty(param.get("ScrapReason").toString())){entity.setScrapCause(param.get("ScrapReason").toString());}

		if(checkType==1){
			entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));

		}else if (checkType==2){
			entity.setStaIndex(0);
			entity.setRowCount(3000);
		}
		entity.setOrderString("CreateTimes desc");

		//排序
	//	entity.setOrderString("ToolCode");
		//报废分析列表-ToolCode模糊查询
		//2017/08/17 王冉 变更↓↓↓　dazhong@YMSC

		//entity.setBusinessID(IConstant.C01S016);
		//2017/08/17 王冉 变更↑↑↑　dazhong@YMSC
		Map<String, Object> rtn = icompv01b06s001Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vscrap>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}

	@Override
	/**
	 * 报废分析统计数量
	 */
	public Object getStatisticalCount(Map<String, Object> param,String langCode, String langValue) {
		Vscrap entity = new Vscrap();
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();
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
		
		// 刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString())? null : param.get("ToolCode").toString());


		return icompv01b06s001Service.getStatisticalCount(entity);
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
			throw new BusinessException(((List<Vscrap>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public List<Business> getBusinessList() throws BusinessException {

		List<Business> businessesList = icompv01b06s001Service.getBusinessList();
		if(businessesList.size()>0 && businessesList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(businessesList.get(0).getMessageCode(), "",  "");
		}
		return businessesList;
	}

	@Override
	public String getNumber() throws BusinessException {
		return icompv01b06s001Service.getNumber();
	}

}
