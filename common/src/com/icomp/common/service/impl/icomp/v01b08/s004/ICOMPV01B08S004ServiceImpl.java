package com.icomp.common.service.impl.icomp.v01b08.s004;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b08.s004.ICOMPV01B08S004Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.ToolalarmparamDao;
import com.icomp.entity.base.Toolalarmparam;

public class ICOMPV01B08S004ServiceImpl extends BaseService implements
		ICOMPV01B08S004Service {
	
	/**
	 * 国际化需求Dao
	 */		
    private ToolalarmparamDao toolalarmparamDao;
    

	public void setToolalarmparamDao(ToolalarmparamDao toolalarmparamDao) {
		this.toolalarmparamDao = toolalarmparamDao;
	}

	/**
	 * 国际化需求
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 国际化需求信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Toolalarmparam entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Toolalarmparam> list = (List<Toolalarmparam>) toolalarmparamDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Toolalarmparam>();
				Toolalarmparam toolalarmparam = new Toolalarmparam();
				//消息：检索为0
				toolalarmparam.setMessageCode(IConstant.EMSG0001);
				toolalarmparam.setRetErrFlag(true);
				list.add(toolalarmparam);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = toolalarmparamDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Toolalarmparam> list = new ArrayList<Toolalarmparam>();
			Toolalarmparam toolalarmparam = new Toolalarmparam();
			//消息：数据库操作异常,查询失败!
			toolalarmparam.setMessageCode(IConstant.EMSG0004);
			toolalarmparam.setRetErrFlag(true);
			toolalarmparam.setExceMessage(e.getMessage());
			list.add(toolalarmparam);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}


	/**
	 * 新建编辑的验证
	 * @param param      页面查询条件
	 * @param langCode   语言编码
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param checkType  1代表新建，2代表编辑
	 * @return
	 */
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode,String langValue, String customerID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Toolalarmparam toolalarmparam = new Toolalarmparam();
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		if(StringUtils.isEmpty(param.get("TransitPlanningAlarm").toString())){
			//在途计划告警不可为空
			map.put("TransitPlanningAlarm",MessageReSource.getMessageBox(
					IConstant.WMSG0187, langCode, langValue));
		}
		//在途计划告警  数字验证
		if(!checkOutNum(param.get("TransitPlanningAlarm").toString())){
			//在途计划告警请填入数字
			map.put("TransitPlanningAlarm", MessageReSource.getMessageBox(
					IConstant.WMSG0188, langCode, langValue));
		}
		//库存异常告警 空值验证
		if(StringUtils.isEmpty(param.get("InventoryAlarm").toString())){
			//库存异常告警不可为空
			map.put("InventoryAlarm", MessageReSource.getMessageBox(
					IConstant.WMSG0189, langCode, langValue));
		}
		//库存异常告警 数字验证
		if(!checkOutNum(param.get("InventoryAlarm").toString())){
			//库存异常告警请填入数字
			map.put("InventoryAlarm", MessageReSource.getMessageBox(
					IConstant.WMSG0190, langCode, langValue));
		}
		//加工异常告警 空值验证
		if(StringUtils.isEmpty(param.get("AbnormalAlarm").toString())){
			//加工异常告警不可为空
			map.put("AbnormalAlarm",MessageReSource.getMessageBox(
					IConstant.WMSG0191, langCode, langValue));
		}
		//加工异常告警 数字验证
		if(!checkOutNum(param.get("AbnormalAlarm").toString())){
			//加工异常告警请填入数字
			map.put("AbnormalAlarm",MessageReSource.getMessageBox(
					IConstant.WMSG0192, langCode, langValue));
		}
		
		
		if (checkType ==1){
			//新建提交
			if(map.size() <= 0 ){
				toolalarmparam.setUpdateTime(new Date());// 更新时间
				toolalarmparam.setUpdateUser(customerID);// 更新者
				toolalarmparam.setCreateTime(new Date());// 创建时间
				toolalarmparam.setCreateUser(customerID);// 创建者
				toolalarmparam.setVersion(BigDecimal.ZERO);// 版本号
				rtn.put("data", toolalarmparam); //数据
				return rtn;
			}else{
				rtn.put("message", map);//返回map
				rtn.put("data", null); //数据
				rtn.put("status", IConstant.RESULT_CODE_2);//状态
				return rtn;
			}
		}else if (checkType ==2){
			//编辑提交	
			if(map.size() > 0 ){
			rtn.put("message", map);//返回map
			rtn.put("data", null); //数据
			rtn.put("status", IConstant.RESULT_CODE_2);//状态
			return rtn;
			}else{
				toolalarmparam.setDelFlag(IConstant.STRING_1);
				toolalarmparam.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
				toolalarmparam.setUpdateUser(customerID);
				toolalarmparam.setUpdateTime(new Date());
				rtn.put("data", toolalarmparam); //数据
			}
		}
		
		return rtn;
				
	}
	/**
	 * 新建刀具告警配置
	 * 
	 * @return
	 */
	@Override
	public Map<String, Object> toolAlarmAdd(List<Toolalarmparam> toolalarmparamList, String langCode,String customerID,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			for(Toolalarmparam entity:toolalarmparamList){
				entity.setToolAlarmParamID(NextKeyValue.getNextkeyvalue(
						IConstant.TOOLALARMPARAM, IConstant.TOOL_ALARM_PARAM_ID, customerID));// 取得语言表主键
				 toolalarmparamDao.insert(entity);
			}
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Toolalarmparam entity = new Toolalarmparam();
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	/**
	 * 取得待处理刀具告警配置
	 * @param param 页面检索条件
	 * @param langValue 语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getToolAlarmInfo(Toolalarmparam entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Toolalarmparam> list = (List<Toolalarmparam>) toolalarmparamDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Toolalarmparam toolalarmparam = new Toolalarmparam();
				toolalarmparam.setMessageCode(IConstant.EMSG0001);
				toolalarmparam.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", toolalarmparam);
				return rtn;
			} else {
				rtn.put("data", list);
				return rtn;
			}

		} catch (SQLException e) {
			Toolalarmparam toolalarmparam = new Toolalarmparam();			
			toolalarmparam.setMessageCode(IConstant.EMSG0004);
			toolalarmparam.setRetErrFlag(true);
			toolalarmparam.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", toolalarmparam);
			return rtn;
		}
	}
	/**
	 * 编辑刀具告警配置
	 * @param param 页面检索条件
	 * @param langValue 语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> toolAlarmAddOrEdit(List<Toolalarmparam> toolalarmparamList,String customerID,
			String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			for(Toolalarmparam updateentity:toolalarmparamList){
				//根据getToolAlarmType查询
				Toolalarmparam shearch=new Toolalarmparam();
				shearch.setToolAlarmType(updateentity.getToolAlarmType());
				List<Toolalarmparam> list = (List<Toolalarmparam>) toolalarmparamDao
				.searchByList(shearch);
				
				if (list == null || list.size() == 0 ) {
					//如果不存在,插入
					updateentity.setToolAlarmParamID(NextKeyValue.getNextkeyvalue(
							IConstant.TOOLALARMPARAM, IConstant.TOOL_ALARM_PARAM_ID, customerID));// 取得主键
					updateentity.setUpdateTime(new Date());// 更新时间
					updateentity.setUpdateUser(customerID);// 更新者
					updateentity.setVersion(BigDecimal.ZERO);// 版本号
					updateentity.setDelFlag(IConstant.STRING_1);// 版本号
					toolalarmparamDao.insert(updateentity);
				}else{
					//如果存在,更新
					for(Toolalarmparam entity:list){
						entity.setToolAlarmRatio(updateentity.getToolAlarmRatio());
						entity.setToolAlarmParamIDWhere(entity.getToolAlarmParamID());
						toolalarmparamDao.updateNonQuery(entity);
					}
				}
		
			}
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Toolalarmparam entity = new Toolalarmparam();
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}


	

}
