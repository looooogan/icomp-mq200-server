package com.icomp.v01b08.b08s004.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s004.ICOMPV01B08S004Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Toolalarmparam;
import com.icomp.v01b08.b08s004.business.B08S004Business;

public class B08S004BusinessImpl implements B08S004Business {
	
	/**
	 * 系统初始化SERVICE
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
    /**
     * 刀具告警配置SERVICE
     */
	private ICOMPV01B08S004Service iCOMPV01B08S004Service;

	public void setiCOMPV01B08S004Service(
			ICOMPV01B08S004Service iCOMPV01B08S004Service) {
		this.iCOMPV01B08S004Service = iCOMPV01B08S004Service;
	}

	/**
	 * 取得系统区分列表
	 * @param flagType  区分定义名称
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,String langValue)
			throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
		}
		return list;
	}

	/**
	 * 取得刀具告警配置列表
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)
			throws BusinessException {
		// 设置检索条件
		Toolalarmparam entity = new Toolalarmparam();
		// 语言编码
		entity.setToolAlarmType(StringUtils.isEmpty(param.get("ToolAlarmType")
				.toString()) ? null : param.get("ToolAlarmType").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ToolAlarmParamID");			
		Map<String, Object> rtn = iCOMPV01B08S004Service.getList(entity);
		// 拼接--告警类别
		List<Toolalarmparam> list = (List<Toolalarmparam>) rtn.get("rows");
		for (Toolalarmparam t : list) {
			List<Comlist> com = getComList(IConstant.TOOL_ALARM_TYPE, langCode, langValue);
			for (Comlist c : com) {
				if (c.getComListValue().equals(t.getToolAlarmType())) {
					t.setToolAlarmTypeWhere(c.getComListText());
				}
			}
		}
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Toolalarmparam>) rtn
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}



	

	/**
	 * 编辑刀具告警配置
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolAlarmEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode) {
		// 刀具告警输入验证
		Map<String,Object> ret =iCOMPV01B08S004Service.checkInput(param,langCode,langValue,customerID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			throw new BusinessException(((Toolalarmparam)ret.get("error")).getMessageCode(),langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
		    return ret;
		}
		List<Toolalarmparam> toolalarmparamList =new ArrayList<Toolalarmparam>();
		// 库存异常告警 告警系数 0
		Toolalarmparam entity0=new Toolalarmparam();
		entity0.setToolAlarmType(IConstant.STRING_0);
		entity0.setToolAlarmRatio(new BigDecimal(param.get("InventoryAlarm").toString()));
		toolalarmparamList.add(entity0);
		// 在途计划告警 告警系数1
		Toolalarmparam entity1=new Toolalarmparam();
		entity1.setToolAlarmType(IConstant.STRING_1);
		entity1.setToolAlarmRatio(new BigDecimal(param.get("TransitPlanningAlarm").toString()));
		toolalarmparamList.add(entity1);
		// 加工异常告警告警系数2
		Toolalarmparam entity2=new Toolalarmparam();
		entity2.setToolAlarmType(IConstant.STRING_2);
		entity2.setToolAlarmRatio(new BigDecimal(param.get("AbnormalAlarm").toString()));
		toolalarmparamList.add(entity2);
		
		// 保存语言信息
		ret = iCOMPV01B08S004Service.toolAlarmAddOrEdit(
				toolalarmparamList, langCode,customerID,langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 新建失败时，返回
			throw new BusinessException(((Toolalarmparam) ret.get("error"))
					.getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	/**
     * 取得待处理刀具告警配置
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
     * @return
     * @throws BusinessException
     */
	@Override
	public Map<String, Object> toolAlarmInfo(Map<String, Object> param,String langCode,
			String langValue) {
		Map<String, Object> ret = new HashMap<String, Object>();
			// 取得待处理刀具告警配置信息
			Toolalarmparam entity = new Toolalarmparam();
			ret = iCOMPV01B08S004Service.getToolAlarmInfo(entity);
			if (ret.size() > 1 && ret.get("error") != null) {
				// 检索错误时，返回
				throw new BusinessException(((Toolalarmparam) ret.get("error"))
						.getMessageCode(),langCode, langValue);
			}
		return ret;
	}


	/**
	 * 取得页面grid显示项目列表
	 * @param pageID     页面ID
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @param langValue  语言值
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
