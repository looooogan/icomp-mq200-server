package com.icomp.v01b07.b07s003.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b07.s003.ICOMPV01B07S003Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Procurementplans;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Vsuggestionpurchaseplan;
import com.icomp.v01b07.b07s003.business.B07S003Business;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 采购计划处理Business实现类
 * 
 * @ClassName: B07S003BusinessImpl
 * @author Taoyy
 * @date 2014-9-13 下午03:00:57
 */
@SuppressWarnings("unchecked")
public class B07S003BusinessImpl implements B07S003Business {
	
	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	/**
	 * 采购计划处理SERVICE
	 */
	private ICOMPV01B07S003Service icompv01b07s003Service;

	public void setIcompv01b07s003Service(ICOMPV01B07S003Service icompv01b07s003Service) {
		this.icompv01b07s003Service = icompv01b07s003Service;
	}

	@Override
	/**
	 * 采购计划处理列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue) throws BusinessException {
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();
		String procurementPlansID = param.get("ProcurementPlansID").toString().trim();
		/**
		 * 设置检索条件
		 */
		Vsuggestionpurchaseplan entity = new Vsuggestionpurchaseplan();
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
		// 查询有效的
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		if(procurementPlansID!=null&&!procurementPlansID.equals("")){
			entity.setProcurementPlansCode(procurementPlansID);
		}
		// 排序
		entity.setOrderString("ProcurementPlansCode");			
		// 采购计划处理列表
		Map<String, Object> rtn = icompv01b07s003Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vsuggestionpurchaseplan>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		//ProcurementPlansID
		return rtn;
	}

	/**
	 * 取得待采购计划信息
	 */
	@Override
	public List<Vsuggestionpurchaseplan> procurementInfo(Map<String, Object> param, String langCode,String langValue) throws BusinessException {
		String procurementPlansCode = param.get("ProcurementPlansCode").toString();
		if ("".equals(procurementPlansCode)) {
			throw new BusinessException(IConstant.WMSG0017, langCode,langValue);
		}
		Vsuggestionpurchaseplan entity = new Vsuggestionpurchaseplan();
		// 采购计划编号设定
		entity.setProcurementPlansCode(procurementPlansCode);
		// 删除区分- 有效
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 取得待编辑采购计划信息
		List<Vsuggestionpurchaseplan> list = icompv01b07s003Service.getProcurementInfo(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
		}
		return list;
	}

	/**
	 * 启用采购计划
	 */
	@Override
	public Map<String, Object> saveAll(Map<String, Object> param, String langValue, String userID, String langCode) {
		List<Toolprocured> list = new ArrayList<Toolprocured>();
		/**
		 * 参数
		 */
		// 刀具ID
		String[] toolIds = param.get("ToolId").toString().split(",");
		// 采购单价
		String[] unitPrice = param.get("UnitPrice").toString().split(",");
		//采购批次
		DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");  
		String procuredBatch = format2.format(new Date())+"";
		// 采购数量
		String[] procuredCount = param.get("ProcuredCount").toString().split(",");
		// 采购日期  2014-09-16 变为 20140916
		String[]  procuredTime = param.get("ProcuredTime").toString().split("-");

		/**
		 * 批量增加-刀具采购
		 */
		for (int i = 0; i < toolIds.length; i++) {
			Toolprocured tp = new Toolprocured(); // 刀具采购实体
			// 采购ID
			tp.setToolProcuredID(NextKeyValue.getNextkeyvalue(IConstant.TOOL_PROCURED, IConstant.TOOL_PROCURED_ID, userID));
			// 刀具ID
			tp.setToolCode(toolIds[i]);
			// 采购批次
			tp.setProcuredBatch(procuredBatch);
			// 采购日期
			tp.setProcuredTime(procuredTime[0]+procuredTime[1]+procuredTime[2]);
			// 采购单价
			tp.setUnitPrice(unitPrice[i]);
			// 采购者
			tp.setProcuredUser(userID);
			// 采购数量
			tp.setProcuredCount(new BigDecimal(procuredCount[i]));
			// 是否付费
			tp.setProcuredPaying(param.get("ProcuredPaying").toString());
			//更新时间
			tp.setUpdateTime(new Date());
			//更新者
			tp.setUpdateUser(userID);
			// 采购类型
			tp.setProcuredType(IConstant.PROCURED_TYPE_0);
			// 版本号
			tp.setVersion(BigDecimal.ZERO);
			// 创建时间
			tp.setCreateTime(new Date());
			// 创建者
			tp.setCreateUser(userID);
			// 删除区分(0有效1删除)
			tp.setDelFlag(IConstant.DEL_FLAG_0);

			list.add(tp);
		}

		return icompv01b07s003Service.saveAll(list, langCode ,param.get("ProcurementPlansCode").toString(),langValue);
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
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}
	/**
	 * 建议采购计划删除
	 * @title procurementPlansDel 
	 * @return
	 * String
	 */
	@Override
	public Map<String, Object> procurementPlansDel(Map<String, Object> param,
			String langValue, String customer, String langCode) {
		Procurementplans entity = new Procurementplans();
		entity.setProcurementPlansCodeWhere(param.get("procurementPlansCode").toString());
		Map<String,Object> ret = icompv01b07s003Service.procurementPlansDel(entity,langCode,  langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Procurementplans)ret.get("error")).getMessageCode(),langCode,langValue);
		}
		return ret;
	}
}
