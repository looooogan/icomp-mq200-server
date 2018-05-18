package com.icomp.v01b01.b01s010.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s010.ICOMPV01B01S010Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vtoolquicksearch;
import com.icomp.v01b01.b01s010.business.B01S010Business;
/**
 *  库存信息快速查询BUSINESS实现类
 * @ClassName: B01S010BusinessImpl 
 * @author Taoyy
 * @date 2014-8-15 下午05:01:06
 */
public class B01S010BusinessImpl implements B01S010Business{


	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;	
	}
	/**
	 * 库存信息快速查询SERVICE
	 */
	private ICOMPV01B01S010Service icompv01b01s010Service;
	public void setIcompv01b01s010Service(ICOMPV01B01S010Service icompv01b01s010Service) {
		this.icompv01b01s010Service = icompv01b01s010Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 库存信息快速查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException{

		/**
		 *  设置检索条件
		 */
		Vtoolquicksearch entity = new Vtoolquicksearch();
		// 刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ToolProcuredID");			
		// 库存信息快速查询列表-ToolCode模糊查询
		Map<String, Object> rtn = icompv01b01s010Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtoolquicksearch>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
