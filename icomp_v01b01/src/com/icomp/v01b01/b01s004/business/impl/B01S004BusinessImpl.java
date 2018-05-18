package com.icomp.v01b01.b01s004.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s004.ICOMPV01B01S004Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vredemptionapplied;
import com.icomp.v01b01.b01s004.business.B01S004Business;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 换领申请信息查询BUSINESS实体类
 * 
 * @ClassName: B01S004BusinessImpl
 * @author Taoyy
 * @date 2014-8-13 上午10:39:35
 */
public class B01S004BusinessImpl implements B01S004Business {

	/**
	 * 调用COMMONSERVICES接口
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B01S004Service icompv01b01s004Service;

	public void setIcompv01b01s004Service(ICOMPV01B01S004Service icompv01b01s004Service) {
		this.icompv01b01s004Service = icompv01b01s004Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 换领申请信息列表
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue,int checkType) throws BusinessException {
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();

		/**
		 * 设置检索条件
		 */
		Vredemptionapplied entity = new Vredemptionapplied();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			// 申请起始时间
			if (dateStarStr != null && !"".equals(dateStarStr)) {
				dateStarStr+=" 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));
			}
			// 申请结束时间
			if (dateEndStr != null &&!"".equals(dateEndStr)) {
				dateEndStr+=" 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 刀具类型
		//entity.setToolType(StringUtils.isEmpty(param.get("ToolConsumetype").toString()) ? null : param.get("ToolConsumetype").toString());
		// 库管员
//		entity.setLibraryUser(StringUtils.isEmpty(param.get("libraryMember").toString()) ? null : param.get("libraryMember").toString());
		entity.setReceiveCad(StringUtils.isEmpty(param.get("libraryMember").toString()) ? null : param.get("libraryMember").toString());
		entity.setReceiveUser(StringUtils.isEmpty(param.get("libraryMember").toString()) ? null : param.get("libraryMember").toString());
		//申请人
		entity.setApplyUser(StringUtils.isEmpty(param.get("applyPerson").toString()) ? null : param.get("applyPerson").toString());
		entity.setApplyCad(StringUtils.isEmpty(param.get("applyPerson").toString()) ? null : param.get("applyPerson").toString());
//		材料号
		entity.setToolCode(StringUtils.isEmpty(param.get("systeCode").toString()) ? null : param.get("systeCode").toString());
//		状态processingStatus
		entity.setProcessingStatus(StringUtils.isEmpty(param.get("status").toString()) ? null : param.get("status").toString());


		if(checkType==1) {

			//分页起始行数
			entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
			//分页页数
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		}else if(checkType==2){
			entity.setStaIndex(0);
			entity.setRowCount(3000);
		}
		//排序
		entity.setOrderString("ApplyTime DESC");
		// 换领申请信息王列表
		Map<String, Object> rtn = icompv01b01s004Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vredemptionapplied>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
	public Map<String, Object> printItemInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object>();
		System.out.println(param.get("redemptionAppliedID").toString());
		String replacementID = param.get("redemptionAppliedID").toString();
		//取得待编辑用户信息
		Vredemptionapplied  entity = new Vredemptionapplied();
		entity.setRedemptionAppliedID(replacementID);
		ret = icompv01b01s004Service.getprintItemInfo(entity);
		if(ret.size() > 1 && ret.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((Vredemptionapplied)ret.get("error")).getMessageCode(),langCode,langValue);
		}
		return ret;
	}

	@Override
	public String getNumber() throws BusinessException {
		return icompv01b01s004Service.getVreNumber();
	}

}
