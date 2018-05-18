package com.icomp.v01b01.b01s008.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s008.ICOMPV01B01S008Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vpurchaseplan;
import com.icomp.v01b01.b01s008.business.B01S008Business;
/**
 * 采购计划查询BUSINESS实现类
 * @ClassName: B11S008BusinessImpl 
 * @author Taoyy
 * @date 2014-8-15 下午03:16:48
 */
public class B01S008BusinessImpl implements B01S008Business{


	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}
	/**
	 * 采购计划查询SERVICE
	 */
	private ICOMPV01B01S008Service icompv01b01s008Service;
	public void setIcompv01b01s008Service(ICOMPV01B01S008Service icompv01b01s008Service) {
		this.icompv01b01s008Service = icompv01b01s008Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 采购计划查询
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException {

		/**
		 *  设置检索条件
		 */
		Vpurchaseplan entity = new Vpurchaseplan();
		// 采购批次 
		entity.setProcuredBatch(StringUtils.isEmpty(param.get("ProcuredBatch").toString()) ? null : param.get("ProcuredBatch").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ProcuredBatch");		
		// 采购计划查询列表
		Map<String, Object> rtn = icompv01b01s008Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vpurchaseplan>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
