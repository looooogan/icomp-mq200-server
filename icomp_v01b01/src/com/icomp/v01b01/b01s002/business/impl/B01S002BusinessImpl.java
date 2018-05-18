package com.icomp.v01b01.b01s002.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s002.ICOMPV01B01S002Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vtoollibraryhistory;
import com.icomp.v01b01.b01s002.business.B01S002Business;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 出库信息查询BUSINESS实现类
 * 
 * @ClassName: B01S002BusinessImpl
 * @author Taoyy
 * @date 2014-8-14 下午02:02:34
 */
public class B01S002BusinessImpl implements B01S002Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 出库信息查询SERVICE
	 */
	private ICOMPV01B01S002Service icompv01b01s002Service;

	public void setIcompv01b01s002Service(ICOMPV01B01S002Service icompv01b01s002Service) {
		this.icompv01b01s002Service = icompv01b01s002Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 出库信息列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue,int checkType)throws BusinessException {
		String dateStarStr = param.get("dstar").toString().trim();
		String dateEndStr = param.get("dend").toString().trim();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		/**
		 * 设置检索条件
		 */
		Vtoollibraryhistory entity = new Vtoollibraryhistory();
		try {
			// 出库开始时间
			if (dateStarStr != null &&!"".equals(dateStarStr)) {
				dateStarStr += " 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));

			}
			// 出库结束时间
			if (dateEndStr != null &&!"".equals(dateStarStr)) {
				dateEndStr += " 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}


		//补领出库 replacementReason
		entity.setReplacementReason(StringUtils.isEmpty(param.get("deliveryReason1").toString()) ? null : param.get("deliveryReason1").toString());
		//出库原因
		entity.setLibraryCause(StringUtils.isEmpty(param.get("deliveryReason").toString()) ? null : param.get("deliveryReason").toString());
		//刀具类型
		//entity.setToolType(StringUtils.isEmpty(param.get("ToolConsumetype").toString()) ? null : param.get("ToolConsumetype").toString());
		// 材料号
		entity.setToolCode(StringUtils.isEmpty(param.get("systeCode").toString()) ? null : param.get("systeCode").toString());
		// 领取人
		entity.setReceiveUser(StringUtils.isEmpty(param.get("usePerson").toString()) ? null : param.get("usePerson").toString());
		entity.setReceiveCard(StringUtils.isEmpty(param.get("usePerson").toString()) ? null : param.get("usePerson").toString());
		// 库管员
		entity.setLibraryUser(StringUtils.isEmpty(param.get("libraryMember").toString()) ? null : param.get("libraryMember").toString());
		entity.setLibraryCard(StringUtils.isEmpty(param.get("libraryMember").toString()) ? null : param.get("libraryMember").toString());
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		entity.setOrderString("ReceiveTime DESC");
		if(checkType==1) {

			//分页起始行数
			entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
			//分页页数
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
			//排序


		}else if(checkType==2){
			entity.setStaIndex(0);
			entity.setRowCount(3000);
		}
		// 出库信息列表-ToolCode模糊查询
		Map<String, Object> rtn = icompv01b01s002Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtoollibraryhistory>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
		return icompv01b01s002Service.getNumber();
	}
}
