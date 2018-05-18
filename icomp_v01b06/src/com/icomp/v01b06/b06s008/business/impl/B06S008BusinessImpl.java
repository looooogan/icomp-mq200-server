package com.icomp.v01b06.b06s008.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s008.ICOMPV01B06S008Service;
import com.icomp.entity.base.CapitalTakes;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.v01b06.b06s008.business.B06S008Business;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 刀具资金占用情况分析BUsiness实现类
 * @ClassName: B06S008BusinessImpl 
 * @author Taoyy
 * @date 2014-8-22 上午10:21:57
 */
 

public class B06S008BusinessImpl implements B06S008Business {
	
	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
	/**
	 * 刀具资金占用情况分析SERVICES
	 */
	public ICOMPV01B06S008Service icompv01b06s008Service;

	public void setIcompv01b06s008Service(ICOMPV01B06S008Service icompv01b06s008Service) {
		this.icompv01b06s008Service = icompv01b06s008Service;
	}

	@Override
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException {

		/**
		 * 设置检索条件
		 */
		//Vprice entity = new Vprice();
		CapitalTakes entity = new CapitalTakes();
		// 刀具编码
		//entity.setToolType(StringUtils.isEmpty(param.get("ToolConsumetype").toString())? null : param.get("ToolConsumetype").toString());
		entity.setToolCode(StringUtils.isEmpty(param.get("SysteCode").toString())? null : param.get("SysteCode").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		entity.setOrderString("ToolType");
		// 刀具资金占用情况分析列表
		Map<String, Object> rtn = icompv01b06s008Service.getLists(entity,langCode);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<CapitalTakes>) rtn.get("error")).get(0).getMessageCode(),langCode ,langValue);

		}
		return rtn;
	}
	
	/**
	 * 刀具资金占用情况分析统计
	 */
	@Override
	public String getStatisticalCount(Map<String, Object> param, String langCode, String langValue) {
		CapitalTakes entity = new CapitalTakes();
		
		// 刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("SysteCode").toString())? null : param.get("SysteCode").toString());
		//刀具资金占用情况分析统计
		return icompv01b06s008Service.getStatisticalCount(entity);

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
	public Map<String, Object> getLists(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
		CapitalTakes entity = new CapitalTakes();
		// 刀具编码
		//entity.setToolType(StringUtils.isEmpty(param.get("ToolConsumetype").toString())? null : param.get("ToolConsumetype").toString());
		entity.setToolCode(StringUtils.isEmpty(param.get("SysteCode").toString())? null : param.get("SysteCode").toString());
		Map<String, Object> rtn = icompv01b06s008Service.getLists(entity,langCode);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<CapitalTakes>) rtn.get("error")).get(0).getMessageCode(),langCode ,langValue);

		}
		return rtn;
	}

	@Override
	public String getNumber() {
		return icompv01b06s008Service.getNumber();
	}
}
