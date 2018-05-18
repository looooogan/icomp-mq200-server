package com.icomp.v01b04.b04s006.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b04.s006.ICOMPV01B04S006Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vprocessingquickquery;
import com.icomp.v01b04.b04s006.business.B04S006Business;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
/**
 *加工信息快速查询BUSINESS实现类
 * @ClassName: B01S006BusinessImpl 
 * @author Taoyy
 * @date 2014-8-14 下午02:02:34
 */
public class B04S006BusinessImpl implements B04S006Business{


	/**
	 * 加工信息快速查询SERVICE
	 */
	private ICOMPV01B04S006Service icompv01b04s006Service;
	public void setIcompv01b04s006Service(ICOMPV01B04S006Service icompv01b04s006Service) {
		this.icompv01b04s006Service = icompv01b04s006Service;
	}

	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
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
	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 加工信息快速查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue)throws BusinessException {

		/**
		 *  设置检索条件
		 */

		Vprocessingquickquery entity = new Vprocessingquickquery();
		//刀具编码 
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		//分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		//分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		//排序
		entity.setOrderString("ToolCode");					
		//加工信息快速查询列表-ToolCode模糊查询
		Map<String, Object> rtn = icompv01b04s006Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vprocessingquickquery>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}
	
	

}
