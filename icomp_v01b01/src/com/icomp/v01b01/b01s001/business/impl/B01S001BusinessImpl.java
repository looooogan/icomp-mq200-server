package com.icomp.v01b01.b01s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s001.ICOMPV01B01S001Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Storagerecord;
import com.icomp.v01b01.b01s001.business.B01S001Business;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 入库信息查询BUsiness实现类
 * 
 * @ClassName: B01S001BusinessImpl
 * @author Taoyy
 * @date 2014-8-12 下午04:10:15
 */
public class B01S001BusinessImpl implements B01S001Business {

	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 入库信息查询SERVICE
	 */
	private ICOMPV01B01S001Service icompv01b01s001Service;

	public void setIcompv01b01s001Service(ICOMPV01B01S001Service icompv01b01s001Service) {
		this.icompv01b01s001Service = icompv01b01s001Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 入库信息列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue,int checkType )throws BusinessException{
		String dateStar = param.get("DateStar").toString().trim();
		String dateEnd = param.get("DateEnd").toString().trim();
		/**
		 * 设置检索条件
		 */
		System.out.println(dateStar);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Storagerecord entity = new Storagerecord();
		try {
			// 申请起始时间
			if (dateStar != null && !"".equals(dateStar)) {
				dateStar+=" 00:00:00";
				entity.setDateStar(format.parse(dateStar));
			}
			// 申请结束时间
			if (dateEnd != null && !"".equals(dateEnd)) {
				dateEnd+=" 23:59:59";
				entity.setDateEnd(format.parse(dateEnd));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}


//		刀具类型
		//entity.setStorageType(StringUtils.isEmpty(param.get("ToolConsumetype").toString()) ? null : param.get("ToolConsumetype").toString());
//		材料号
		entity.setToolCode(StringUtils.isEmpty(param.get("SysteCode").toString()) ? null : param.get("SysteCode").toString());
//		刀具状态
		entity.setStorageState(StringUtils.isEmpty(param.get("KnifeInventory").toString()) ? null : param.get("KnifeInventory").toString());
//		 库管员
		entity.setCreateUser(StringUtils.isEmpty(param.get("UserName").toString()) ? null : param.get("UserName").toString());
		entity.setEmployeeCard(	StringUtils.isEmpty(param.get("UserName").toString()) ? null : param.get("UserName").toString());
//		订单号
		entity.setToolsOrdeNO(StringUtils.isEmpty(param.get("ProcuredBatch").toString()) ? null: param.get("ProcuredBatch").toString());
//		删除分区

		entity.setOrderString("CreateTime DESC");
		if(checkType==1){

	//分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
	//分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));

	}else if (checkType==2){

		entity.setStaIndex(0);
		entity.setRowCount(3000);
	}
//
		// 入库信息列表--ToolCode模糊查询
		Map<String, Object> rtn = icompv01b01s001Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Storagerecord>) rtn.get("error")).get(0).getMessageCode(),langCode ,langValue);
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
	public String getnumber() throws BusinessException {

		String number = icompv01b01s001Service.getNumeber();


		return number;
	}


}
