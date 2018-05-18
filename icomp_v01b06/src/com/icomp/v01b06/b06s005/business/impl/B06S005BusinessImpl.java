package com.icomp.v01b06.b06s005.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s005.ICOMPV01B06S005Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Distribution;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vdepartment;
import com.icomp.v01b06.b06s005.business.B06S005Business;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 *  刀具实时分布状况BUsiness实现类
 * @ClassName: B06S005BusinessImpl 
 * @author Taoyy
 * @date 2014-8-22 上午09:57:55
 */


public class B06S005BusinessImpl implements B06S005Business {
	
	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
	/**
	 * 刀具实时分布状况SERVICES
	 */
	public ICOMPV01B06S005Service icompv01b06s005Service;

	public void setIcompv01b06s005Service(ICOMPV01B06S005Service icompv01b06s005Service) {
		this.icompv01b06s005Service = icompv01b06s005Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue)throws BusinessException {

		/**
		 * 设置检索条件
		 */
		//Vtoolrealtimedistribution entity = new Vtoolrealtimedistribution();
		Distribution entity = new Distribution();

//		if (param.get("ToolConsumetype") != null) {
//		 entity.setToolType(StringUtils.isEmpty(param.get("ToolConsumetype").toString())? null : param.get("ToolConsumetype").toString());
//		}
		 // 刀具入库编码
		 entity.setToolCode(StringUtils.isEmpty(param.get("SysteCode").toString())? null : param.get("SysteCode").toString());
		 
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ToolType");
		// 刀具实时分布状况列表
		Map<String, Object> rtn = icompv01b06s005Service.getLists(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Distribution>) rtn.get("error")).get(0).getMessageCode(), langCode,langValue);
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
	public Map<String, Object> getGridColmun(String pageID, String userID, String langCode, String langValue) throws BusinessException {

		// 取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID, langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}
	/**
	 * 取得机构信息列表
	 * 
	 * @param param

	 * @return
	 * @throws BusinessException
	 */
	public List<Vagency> getAgencyList(String param, String langCode,
			String langValue) throws BusinessException {
		Vagency entity = new Vagency();
		entity.setDelFlag(param);
		entity.setAgencyLanguageCode(langCode);
		List<Vagency> list = service.getVagency(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;

	}

	/**
	 * 取得部门信息列表
	 * 

	 * @return
	 * @throws BusinessException
	 */
	public List<Vdepartment> getDepartmentList(String agencyID, String delFlag, String langCode, String langValue) throws BusinessException {
		Vdepartment entity = new Vdepartment();
		entity.setDepartmentAgencyID(agencyID);
		entity.setDepartmentDelFlag(delFlag);
		entity.setDepartmentLanguageCode(langCode);
		List<Vdepartment> list = service.getVdepartment(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;

	}

	@Override
	public Object getStatisticalCount(Map<String, Object> param, String langCode, String langValue) {

		Distribution entity = new Distribution();

		// 刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("SysteCode").toString())? null : param.get("SysteCode").toString());
		//刀具资金占用情况分析统计
		return icompv01b06s005Service.getStatisticalCount(entity);
	}

	@Override
	public String getNumber() throws BusinessException {
		return icompv01b06s005Service.getNumber();
	}

}
