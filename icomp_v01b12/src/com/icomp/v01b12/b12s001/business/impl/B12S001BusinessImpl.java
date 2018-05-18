package com.icomp.v01b12.b12s001.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b12.s001.ICOMPV01B12S001Service;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflow;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vbusiness;
import com.icomp.v01b12.b12s001.business.B12S001Business;

/**
 *操作流程管理BUSINESS实现类
 * 
 * @ClassName: B12S001BusinessImpl
 * @author Licc
 * @date 2014-9-23 下午02:02:34
 */
@SuppressWarnings("unchecked")
public class B12S001BusinessImpl implements B12S001Business {

	private CommonService commonService;

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	/**
	 * 操作流程管理SERVICE
	 */
	private ICOMPV01B12S001Service icompv01b12s001Service;

	public void setIcompv01b12s001Service(
			ICOMPV01B12S001Service icompv01b12s001Service) {
		this.icompv01b12s001Service = icompv01b12s001Service;
	}

	/**
	 * 取得流程名列表
	 */
	public List<Businessflow> getBusinessFlowList(String dELFLAG_0,
			String langCode, String langValue) {
		Businessflow entity = new Businessflow();
		entity.setDelFlag(dELFLAG_0); // 删除区分
		List<Businessflow> list = icompv01b12s001Service
				.getBusinessFlowList(entity);

		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}

	/**
	 * 取得系统区分列表
	 * 
	 * @param flagType
	 *            区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,
			String langValue) throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = commonService.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}

	/**
	 * 取得流程管理信息
	 * 
	 * @param
	 * @langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		// 设置检索条件
		Vbusiness entity = new Vbusiness();
		entity.setBusinessFlowID(StringUtils.isEmpty(param.get("BusinessFlowID").toString()) ? null : param.get("BusinessFlowID").toString());
		entity.setBusinessName(StringUtils.isEmpty(param.get("BusinessName").toString()) ? null : param.get("BusinessName").toString());
		entity.setDownBusinessIDName(StringUtils.isEmpty(param.get("DownstreamBusiness").toString()) ? null : param.get("DownstreamBusiness").toString());
		// 删除区分
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("createtime desc, businessFlowid,ordernumber");		
		Map<String, Object> rtn = icompv01b12s001Service.getList(entity);

		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vbusiness>) rtn.get("error"))
					.get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}


	/**
	 * 新建流程
	 */
	public Map<String, Object> businessAdd(Map<String, Object> param,
			String customerID, String langCode, String langValue)throws BusinessException   {
		// 语言输入验证
		Map<String, Object> ret = icompv01b12s001Service.checkInput(param,
				langCode, langValue, customerID, 1);
		if (ret.size() > 1 && ret.get("error") != null) {
			throw new BusinessException(((Businessflowlnk) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		} else if (ret.size() > 1 && ret.get("message") != null) {
			return ret;
		}
		Businessflow businessflow= (Businessflow) ret.get("businessflow");
		List<Businessflowlnk> businessflowlnkList= (List<Businessflowlnk>) ret.get("businessflowlnkList");
		// 插入流程
		ret = icompv01b12s001Service.businessAdd(businessflow,businessflowlnkList,customerID, langCode,
				langValue);

		if (ret.size() > 1 && ret.get("error") != null) {
			// 新建失败时，返回
			throw new BusinessException(((Businessflow) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}
		return ret;
	}
	/**
	 * 编辑流程
	 */
	public Map<String, Object> businessEdit(Map<String, Object> param,
			String customerID, String langCode, String langValue)throws BusinessException   {
		// 语言输入验证
		Map<String, Object> ret = icompv01b12s001Service.checkInput(param,
				langCode, langValue, customerID, 2);
		if (ret.size() > 1 && ret.get("error") != null) {
			throw new BusinessException(((Businessflowlnk) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		} else if (ret.size() > 1 && ret.get("message") != null) {
			return ret;
		}
		Businessflow businessflow= (Businessflow) ret.get("businessflow");
		List<Businessflowlnk> businessflowlnkList= (List<Businessflowlnk>) ret.get("businessflowlnkList");
		// 插入流程
		ret = icompv01b12s001Service.businessEdit(businessflow,businessflowlnkList,customerID, langCode,
				langValue);
		
		if (ret.size() > 1 && ret.get("error") != null) {
			// 新建失败时，返回
			throw new BusinessException(((Businessflow) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得业务信息
	 * 
	 * @param
	 * @langValue
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<Business> getBusinessList(String dELFLAG_0, String langCode,
			String langValue) throws BusinessException  {
		Business entity = new Business();
		entity.setDelFlag(dELFLAG_0); // 删除区分
		List<Business> list = icompv01b12s001Service.getBusinessList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}

	/**
	 * 取得流程信息
	 * 
	 * @param
	 * @langValue
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<Vbusiness> getBusinessFlowList(Map<String, Object> param,
			String langCode, String langValue) {
		Vbusiness entity = new Vbusiness();
		entity.setBusinessFlowID(param.get("businessFlowID").toString());
		entity.setOrderString("BusinessFlowID,OrderNumber"); // 排序
		List<Vbusiness> list = icompv01b12s001Service.getBusinessList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}

	/**
	 * 删除流程
	 * 
	 * @param
	 * @langValue
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Map<String, Object> businessDelete(Map<String, Object> param,
			String customerID, String langCode, String langValue) throws BusinessException  {
		Map<String, Object> ret = new HashMap<String, Object>();
		List<Businessflowlnk> businessflowlnkList=new ArrayList<Businessflowlnk>();
		
		Businessflow businessflow=new Businessflow();
		String ID = param.get("ID").toString();
		String version = param.get("version").toString();
		businessflow.setBusinessFlowIDWhere(ID);
		businessflow.setDelFlag(IConstant.DEL_FLAG_1);
		businessflow.setVersion(new BigDecimal(version).add(BigDecimal.ONE));
		// 删除流程
		ret = icompv01b12s001Service.businessDelete(businessflow,businessflowlnkList,customerID,
				langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 新建失败时，返回
			throw new BusinessException(((Businessflow) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 获取业务-流程中间表信息
	 * 
	 * @param
	 * @langValue
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Map<String, Object> businessInfo(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		Map<String, Object> ret = new HashMap<String, Object>();
		String ID = param.get("ID").toString();
		// 取得刀具参数
		Vbusiness entity = new Vbusiness();
		entity.setBusinessFlowID(ID);
		entity.setOrderString("OrderNumber");
		ret = icompv01b12s001Service.businessInfo(entity);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 新建失败时，返回
			throw new BusinessException(((Vbusiness) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}

		return ret;
	}

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, String userID,
			String langCode, String langValue) throws BusinessException {

		// 取得页面grid显示项目列表
		Map<String, Object> ret = commonService.getGridColmun(pageID, langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public List<Capability> getCapabilityList(String dELFLAG_0,
			String langCode, String langValue) {
		Capability entity = new Capability();
		entity.setDelFlag(IConstant.DEL_FLAG_0); // 删除区分
		entity.setBelongFlag(IConstant.BELONG_FLAG_1); // 1手持机
		entity.setCapabilityLevel(BigDecimal.valueOf(2));
		List<Capability> list = icompv01b12s001Service.getBusinessList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}


}
