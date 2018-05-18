package com.icomp.v01b07.b07s004.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b07.s004.ICOMPV01B07S004Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.entity.base.Deliveryplan;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Position;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vcustomer;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;
import com.icomp.entity.base.Vtoolprocureds;
import com.icomp.v01b07.b07s004.business.B07S004Business;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采购订单BUSINESS实体类
 * 
 * @ClassName: B07S004BusinessImpl
 * @author Taoyy
 * @date 2014-9-16 下午01:48:55
 */

public class B07S004BusinessImpl implements B07S004Business {

	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 采购订单SERVICE接口
	 */
	private ICOMPV01B07S004Service icompv01b07s004Service;

	public void setIcompv01b07s004Service(ICOMPV01B07S004Service icompv01b07s004Service) {
		this.icompv01b07s004Service = icompv01b07s004Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 采购订单列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue) throws BusinessException {
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();

		/**
		 * 设置检索条件
		 */
		// Vpurchasingorder entity = new Vpurchasingorder();
		Vtoolprocureds entity = new Vtoolprocureds();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			// 申请起始时间
			if (dateStarStr != null && dateStarStr != "") {
				dateStarStr+=" 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));
			}
			// 申请结束时间
			if (dateEndStr != null && dateEndStr != "") {
				dateEndStr+=" 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 刀具编码
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		entity.setToolsOrdeNO(StringUtils.isEmpty(param.get("toolsOrdeNO").toString()) ? null : param.get("toolsOrdeNO").toString());
		//entity.setToolType(StringUtils.isEmpty(param.get("toolType").toString()) ? null : param.get("toolType").toString());
		//采购批次 
		entity.setProcuredBatch(StringUtils.isEmpty(param.get("procuredBatch").toString()) ? null : param.get("procuredBatch").toString());
		//供应商
		entity.setSupplier (StringUtils.isEmpty(param.get("supplier").toString()) ? null : param.get("supplier").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ProcuredTime desc");
		// 采购订单列表
		Map<String, Object> rtn = icompv01b07s004Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtoolprocureds>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 保存采购订单
	 */
	@Override
	public Map<String, Object> saveAll(Map<String, Object> param, String langValue, String customer, String langCode) throws BusinessException {
		Map<String, Object> ret = new HashMap<String, Object>();
		//到货数量(总数)
		String tempCount = param.get("TempCount").toString();
		Deliveryplan entity = new Deliveryplan();
		// 货品状态
		entity.setTheyStatus(IConstant.STRING_0);
		// 到货计划ID
		entity.setDeliveryPlanID(NextKeyValue.getNextkeyvalue(IConstant.DELIVERY_PLAN, IConstant.DELIVERY_PLAN_ID, customer));
		// 采购ID
		entity.setToolProcuredID(param.get("ToolProcuredID").toString());
		// 到货时间
			try {
				
				entity.setTheyTime(new SimpleDateFormat("yyyyMMdd").parse(param.get("TheyTime").toString()+""));
			} catch (ParseException e) {
				 //数据库操作异常,插入失败!
				  throw new BusinessException(IConstant.EMSG0007,langCode, langValue);
			}
		// 到货数量
		entity.setTheyCount(new BigDecimal(param.get("TheyCount").toString()));
		// 删除区分
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 创建者
		entity.setCreateUser(customer);
		// 创建时间
		entity.setCreateTime(new Date());
		// 版本号
		entity.setVersion(BigDecimal.ZERO);
		// 更新者
		entity.setUpdateUser(customer);
		// 更新时间
		entity.setUpdateTime(new Date());
		/**
		 * 校验
		 */
		/*
		 * ret = icompv01b07s004Service.checkInput(param,lang,userID,1);
		 * if(ret.size() > 1 && ret.get("error") != null){ throw new
		 * BusinessException(((Customer)ret.get("error")).getMessageCode(),
		 * langValue); }else if(ret.size() > 1 && ret.get("message") != null){
		 * return ret; }
		 */
		/**
		 * 保存用户信息
		 */
		ret = icompv01b07s004Service.orderAdd(entity,langCode,tempCount,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //数据库操作异常,插入失败!
			  throw new BusinessException(((Position)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得机构信息列表
	 * 
	 * @param param
	 * @param langCode
	 * @return
	 * @throws BusinessException
	 */
	public List<Vagency> getAgencyList(String param, String langCode,String langValue) throws BusinessException {
		Vagency entity = new Vagency();
		entity.setDelFlag(param);
		entity.setAgencyLanguageCode(langCode);
		List<Vagency> list = service.getVagency(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
		}
		return list;

	}

	/**
	 * 取得部门信息列表
	 * 
	 * @param agencyID
	 * @param delFlag
	 * @return
	 * @throws BusinessException
	 */
	public List<Vdepartment> getDepartmentList(String agencyID, String delFlag, String langCode) throws BusinessException {
		Vdepartment entity = new Vdepartment();
		entity.setDepartmentAgencyID(agencyID);
		entity.setDepartmentDelFlag(delFlag);
		entity.setDepartmentLanguageCode(langCode);
		List<Vdepartment> list = service.getVdepartment(entity);
		return list;

	}

	/**
	 * 取得职务信息列表
	 * 
	 * @param departmentID
	 *            部门ID
	 * @param delFlag
	 *            删除区分
	 * @param delFlag
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Vposition> getPositionList(String departmentID, String delFlag, String langCode) throws BusinessException {
		Vposition entity = new Vposition();
		entity.setDepartmentID(departmentID);
		entity.setDelFlag(delFlag);
		List<Vposition> list = service.getVposition(entity);
		return list;
	}

	@Override
	/**
	 * 取得用户列表
	 */
	public List<Vcustomer> getUserNameList(String positionID, String delFlag, String langValue) {
		Vcustomer entity = new Vcustomer();
		entity.setCustomerPositionID(positionID);
		entity.setDelFlag(delFlag);
		List<Vcustomer> list = icompv01b07s004Service.getVcustomer(entity);
		return list;
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
	public Map<String, Object> newAdd(Map<String, Object> param, String langCode, String langValue) throws BusinessException {

		Map<String, Object> ret = new HashMap<String, Object>();
		//参数验证
		ret = checkInput(param, 1);
		if (ret.size() > 1 && ret.get(IConstant.MESSAGE_STR) != null) {
			return ret;
		}
//		//赋值
//		Toolprocured toolprocured = new Toolprocured();
//
//		//订单号
//		toolprocured.setToolsOrdeNO(param.get("DIVtoolsOrdeNO").toString());
//		//刀具类型
//		toolprocured.setToolType(param.get("ToolConsumetype").toString());
//		//材料号
//		toolprocured.setToolCode(param.get("DIVtoolCode").toString());
//		//采购时间
//		toolprocured.setProcuredTime(param.get("DIVprocuredTime").toString());
//		//采购批次
//		toolprocured.setProcuredBatch(param.get("DIVprocuredBatch").toString());
//		//采购单价
//		toolprocured.setUnitPrice(param.get("DIVunitPrice").toString());
//		//采购人
//		toolprocured.setProcuredUser(param.get("DIVprocuredUser").toString());
//		//是否绑定
//		toolprocured.setProcuredInto(param.get("DIVprocuredInto").toString());
//		//供应商
//		toolprocured.setSupplier(param.get("DIVsupplier").toString());
//
//
//		//创建人
//
//		//创建时间
//		vtoolprocureds.setCreateTime(new Date());
//		//版本号
//		vtoolprocureds.setVersion(BigDecimal.ZERO);
//		//删除分区
//		vtoolprocureds.setDelFlag(IConstant.DEL_FLAG_0);
//

		//插入新建厂家数据
	//	ret = icompv01b07s004Service.deliveryplansAdd(vtoolprocureds, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			//新建失败时，返回
			throw new BusinessException(((Vtoolprocureds) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		//返回信息
		return ret;
	}
	public Map<String, Object> checkInput(Map<String, Object> param, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		// 页面输入项目验证
		Map<String, String> map = new HashMap<String, String>();
		if (checkType == 1) {
			if (StringUtils.isEmpty(param.get("DIVtoolsOrdeNO").toString())) {// 如果通知单号未输入
				map.put("DIVtoolsOrdeNO", "请输入单号");
			}
			if (StringUtils.isEmpty(param.get("ToolConsumetype").toString())) {//如果补材料号未输入
				map.put("ToolConsumetype", "请选择刀具列表");
			}
			if (StringUtils.isEmpty(param.get("DIVtoolCode").toString())) {//如果商家名称未选
				map.put("DIVtoolCode", "请输入刀具编码");
			}

			if (StringUtils.isEmpty(param.get("DIVprocuredTime").toString())) {//如果修磨数量未选
				map.put(" DIVprocuredTime", IConstant.ERROR_MSG_04);
			}
			if (StringUtils.isEmpty(param.get("DIVprocuredBatch").toString())) {//如果修复类型未选
				map.put(" DIVprocuredBatch", IConstant.ERROR_MSG_05);
			}

			if (StringUtils.isEmpty(param.get("DIVunitPrice").toString())) {//如果出厂时间未选
				map.put(" DIVunitPrice", IConstant.ERROR_MSG_06);
			}
			if (StringUtils.isEmpty(param.get("DIVprocuredUser").toString())) {//如果审批人
				map.put(" DIVprocuredUser", IConstant.ERROR_MSG_07);
			}
			if (StringUtils.isEmpty(param.get("DIVsupplier").toString())) {//如果审批人
				map.put("DIVsupplier", IConstant.ERROR_MSG_07);
			}
		}


		if (map.size() > 0) {
			rtn.put(IConstant.MESSAGE_STR, map);
			rtn.put(IConstant.STATUS_STR, IConstant.RESULT_CODE_STR_3);
		}
		return rtn;
	}
}
