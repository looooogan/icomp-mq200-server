package com.icomp.v01b01.b01s014.business.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s014.ICOMPV01B01S014Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vstocking;
import com.icomp.v01b01.b01s014.business.B01S014Business;


/**
 * 库存盘点查询BUsiness实现类
 * 
 * @ClassName: B01S014BusinessImpl
 * @author Licc
 * @date 2014-11-12 下午04:10:15
 */
public class B01S014BusinessImpl implements B01S014Business {

	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 库存盘点查询SERVICE
	 */
	private ICOMPV01B01S014Service icompv01b01s014Service;

	public void setIcompv01b01s014Service(
			ICOMPV01B01S014Service icompv01b01s014Service) {
		this.icompv01b01s014Service = icompv01b01s014Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 库存盘点列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue)throws BusinessException{
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();

		/**
		 * 设置检索条件
		 */
		Vstocking entity = new Vstocking();
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
		//刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		//操作人
		entity.setCheckUser(StringUtils.isEmpty(param.get("CheckUser").toString()) ? null : param.get("CheckUser").toString());
		//盘点状态
		entity.setInventoryStatus(StringUtils.isEmpty(param.get("InventoryStatus").toString()) ? null : param.get("InventoryStatus").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		//排序：刀具编码
		entity.setOrderString("ToolCode");
		// 库存盘点列表-ToolCode模糊查询
		Map<String, Object> rtn = icompv01b01s014Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vstocking>) rtn.get("error")).get(0).getMessageCode(),langCode ,langValue);
		}
		return rtn;
	}

	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
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
