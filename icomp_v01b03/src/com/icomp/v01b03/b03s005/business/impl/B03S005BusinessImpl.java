package com.icomp.v01b03.b03s005.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b03.s005.ICOMPV01B03S005Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vgrindingquicksearch;
import com.icomp.v01b03.b03s005.business.B03S005Business;

/**
 * 刃磨信息快速查询BUSINESS实现类
 * 
 * @ClassName: B03S005BusinessImpl
 * @author Taoyy
 * @date 2014-8-20 下午04:38:35
 */
public class B03S005BusinessImpl implements B03S005Business {

	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}
	/**
	 * 刃磨信息快速查询SERVICES
	 */
	
	private ICOMPV01B03S005Service icompv01b03s005Service;


	public void setIcompv01b03s005Service(ICOMPV01B03S005Service icompv01b03s005Service) {
		this.icompv01b03s005Service = icompv01b03s005Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 刃磨信息快速查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue) throws BusinessException {

		/**
		 * 设置检索条件
		 */
		Vgrindingquicksearch entity = new Vgrindingquicksearch();
		// 换领申请流水号
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ToolCode");	
		// 刃磨信息快速查询列表
		Map<String, Object> rtn = icompv01b03s005Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vgrindingquicksearch>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
