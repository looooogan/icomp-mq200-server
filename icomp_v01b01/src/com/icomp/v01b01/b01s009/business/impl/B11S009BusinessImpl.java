package com.icomp.v01b01.b01s009.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s009.ICOMPV01B01S009Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vinspectionrecord;
import com.icomp.v01b01.b01s009.business.B01S009Business;
/**
 * 质检记录查询BUSINESS实现类
 * @ClassName: B11S009BusinessImpl 
 * @author Taoyy
 * @date 2014-8-15 下午04:04:08
 */
public class B11S009BusinessImpl implements B01S009Business{

	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	/**
	 * 质检记录查询SERVICE
	 */
	private ICOMPV01B01S009Service icompv01b01s009Service;
	public void setIcompv01b01s009Service(ICOMPV01B01S009Service icompv01b01s009Service) {
		this.icompv01b01s009Service = icompv01b01s009Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 质检记录查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException {

		/**
		 *  设置检索条件
		 */
		Vinspectionrecord entity = new Vinspectionrecord();
		//采购批次 
		entity.setProcuredBatch(StringUtils.isEmpty(param.get("ProcuredBatch").toString()) ? null : param.get("ProcuredBatch").toString());
		//刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		//分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		//分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ProcuredBatch");				
		//质检记录查询列表-ToolCode模糊查询
		Map<String, Object> rtn = icompv01b01s009Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vinspectionrecord>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
