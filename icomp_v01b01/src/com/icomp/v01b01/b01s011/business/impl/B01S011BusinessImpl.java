package com.icomp.v01b01.b01s011.business.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s011.ICOMPV01B01S011Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vtransitalarm;
import com.icomp.v01b01.b01s011.business.B01S011Business;

/**
 * 在途计划报警查询BUSINESS实现类
 * 
 * @ClassName: B01S011BusinessImpl
 * @author Taoyy
 * @date 2014-8-15 下午06:08:19
 */
public class B01S011BusinessImpl implements B01S011Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 在途计划报警查询SERVICE
	 */
	private ICOMPV01B01S011Service icompv01b01s011Service;

	public void setIcompv01b01s011Service(ICOMPV01B01S011Service icompv01b01s011Service) {
		this.icompv01b01s011Service = icompv01b01s011Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 在途计划报警查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException{

		/**
		 * 设置检索条件
		 */
		Vtransitalarm entity = new Vtransitalarm();
		// 警报时间
		entity.setDateStar(new Date((new Date().getTime()) - (Integer.parseInt(IConstant.DAYS_MILLI_SECOND) * Integer.parseInt(IConstant.ALERT_DAYS))));
		// 采购批次
		entity.setProcuredBatch(StringUtils.isEmpty(param.get("ProcuredBatch").toString()) ? null : param.get("ProcuredBatch").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ProcuredBatch");			
		// 在途计划报警查询列表
		Map<String, Object> rtn = icompv01b01s011Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtransitalarm>) rtn.get("error")).get(0).getMessageCode(), langCode,langValue);
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
}
