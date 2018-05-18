package com.icomp.v01b06.b06s003.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s003.ICOMPV01B06S003Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.EntityProcurementplansWhere;
import com.icomp.entity.base.Procurementplans;
import com.icomp.v01b06.b06s003.business.B06S003Business;

/**
 * 建议采购计划BUsiness实现类
 * 
 * @ClassName: B06S003BusinessImpl
 * @author Taoyy
 * @date 2014-9-9 上午09:57:39
 */

public class B06S003BusinessImpl implements B06S003Business {

	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 建议采购计划SERVICES
	 */
	public ICOMPV01B06S003Service icompv01b06s003Service;

	public void setIcompv01b06s003Service(
			ICOMPV01B06S003Service icompv01b06s003Service) {
		this.icompv01b06s003Service = icompv01b06s003Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		// 建议采购计划
		Map<String, Object> rtn = icompv01b06s003Service.getList(param,
				langCode, langValue);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(
					((List<EntityProcurementplansWhere>) rtn.get("error")).get(
							0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 取得页面grid显示项目列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getGridColmun(String pageID, String langCode, String userID,
			String langValue) throws BusinessException {
		// 取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID, langCode,
				IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 增加建议采购计划
	 */
	@Override
	public Map<String, Object> saveAll(Map<String, Object> param,
			String langCode, String userID, String langValue)
			throws BusinessException {
			
		
		List<Procurementplans> list = new ArrayList<Procurementplans>();
		try {
		// 参数
		String strs = param.get("Contents").toString();
		// 分行
		String[] strings = strs.split("###");
		// 获取采购计划编号
		String key = NextKeyValue.getkeyvalueNO(IConstant.PROCUREMENT_PLANS,
				IConstant.PROCUREMENT_PLANS_ID,userID);
		for (int i = 0; i < strings.length; i++) {
			Procurementplans pp = new Procurementplans();
			// 取出每行中的列
			String[] entityArr = strings[i].split(",");
			if(entityArr.length<5){
				System.out.println(entityArr);
			}
			if (IConstant.STRING_0.equals(entityArr[4])) {//采购数量为0则跳出
				continue;
			}
			// 采购计划ID
			pp.setProcurementPlansID(NextKeyValue.getNextkeyvalue(
					IConstant.PROCUREMENT_PLANS,
					IConstant.PROCUREMENT_PLANS_ID, userID));
			// 采购计划编号
			pp.setProcurementPlansCode(key);
			// 刀具ID
			pp.setToolID(entityArr[0]);
			// 库存量
			pp.setInventory(new BigDecimal(entityArr[3]));
			// 生产计划(总数)
			pp.setProductionPlan(BigDecimal.ZERO);
			// 计划周期(天数)
			pp.setPlanningCycles(BigDecimal.ZERO);
			// 加工效率(个/每天)
			pp.setEfficiency(BigDecimal.ZERO);
			// 应采购数量
			pp.setProcurementCount(new BigDecimal(entityArr[4]));
			// 版本号
			pp.setVersion(BigDecimal.ONE);
			// 创建时间
			pp.setCreateTime(new Date());
			// 创建者
			pp.setCreateUser(userID);
			// 删除区分(0有效1删除)
			pp.setDelFlag(IConstant.DEL_FLAG_0);

			list.add(pp);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return icompv01b06s003Service.saveAll(list, langCode, langValue);
	}

}
