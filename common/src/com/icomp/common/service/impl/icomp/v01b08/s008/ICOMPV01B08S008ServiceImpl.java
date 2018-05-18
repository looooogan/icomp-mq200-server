package com.icomp.common.service.impl.icomp.v01b08.s008;

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
import com.icomp.common.service.icomp.v01b08.s008.ICOMPV01B08S008Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.ProcessDao;
import com.icomp.dao.VprocessDao;
import com.icomp.entity.base.Process;
import com.icomp.entity.base.Vprocess;

public class ICOMPV01B08S008ServiceImpl extends BaseService implements
		ICOMPV01B08S008Service {
	

	//工序Dao
	private ProcessDao processDao;
	
	public void setProcessDao(ProcessDao processDao) {
		this.processDao = processDao;
	}
	
	//工序视图Dao
	private VprocessDao vprocessDao;
	
	public void setVprocessDao(VprocessDao vprocessDao) {
		this.vprocessDao = vprocessDao;
	}

	/**
	 * 工序列表
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 手持机配置信息
	 */
    @SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vprocess entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vprocess> list = (List<Vprocess>) vprocessDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vprocess>();
				Vprocess process = new Vprocess();
				//消息：检索为0
				process.setMessageCode(IConstant.EMSG0001);
				process.setRetErrFlag(true);
				list.add(process);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vprocessDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}
		} catch (SQLException e) {
			List<Vprocess> list = new ArrayList<Vprocess>();
			Vprocess process = new Vprocess();
			//错误消息：数据库操作异常，查询失败!
			process.setMessageCode(IConstant.EMSG0004);
			process.setRetErrFlag(true);
			process.setExceMessage(e.getMessage());
			list.add(process);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
    
	/**
	 * 取得工序信息
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 手持机配置信息
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getProcessInfo(Process entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Process> list = (List<Process>) processDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Process process = new Process();
				//消息：检索为0
				process.setMessageCode(IConstant.EMSG0001);
				process.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", process);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Process process = new Process();
			//错误消息：数据库操作异常，查询失败!
			process.setMessageCode(IConstant.EMSG0004);
			process.setRetErrFlag(true);
			process.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", process);
			return rtn;
		}
	}

	/**
	 * 工序删除
	 * @param

	 * @return 手持机配置信息
	 */	
	@SuppressWarnings("unchecked")
	public Map<String, Object> processDelete(Process process, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Process entity = new Process();
			entity.setProcessID(process.getProcessIDWhere());   //工序ID
			entity.setUpdateTime(process.getUpdateTimeWhere()); //更新时间
			entity.setUpdateUser(process.getUpdateUserWhere()); //更新者
			entity.setVersion(process.getVersionWhere());       //版本号
			List<Process> list = (List<Process>) processDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Process();
				//您所请求的数据，已被其他用户修改，请重新查询后再进行修改！
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = processDao.updateNonQuery(process);
			//删除成功，ID:{0}!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Process entity = new Process();
			//错误消息：数据库操作异常，删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 新建工序
	 * @param

	 * @return 手持机配置信息
	 */	
	public Map<String, Object> processtAdd(Process process, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			process.setProcessID(NextKeyValue.getNextkeyvalue(
					IConstant.PROCESS, IConstant.PROCESS_ID, process.getUpdateUser()));// 取得工序表主键
			 processDao.insert(process);
			//插入成功,ID:{0}!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Process entity = new Process();
			//错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	
	/**
	 * 编辑工序

	 *            页面查询条件
	 * @return 手持机配置信息
	 */	
	@SuppressWarnings("unchecked")
	public Map<String, Object> processtEdit(Process process, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Process entity = new Process();
			entity.setProcessID(process.getProcessIDWhere());
			entity.setUpdateTime(process.getUpdateTimeWhere());
			entity.setUpdateUser(process.getUpdateUserWhere());
			entity.setVersion(process.getVersionWhere());
			List<Process> list = (List<Process>) processDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Process();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新成功
			@SuppressWarnings("unused")
			int ret = processDao.updateNonQuery(process);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Process entity = new Process();
			//消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 工序新建编辑的验证
	 * @param param      页面查询条件
	 * @param langCode   语言编码
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param checkType  1代表新建，2代表编辑
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Process process = new Process();		
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		try {
				//工序名称验证
				if(StringUtils.isEmpty(param.get("DIVProcessName").toString())){
					map.put("DIVProcessName", MessageReSource.getMessageBox(
							IConstant.WMSG0051, langCode, langValue));
				}else{
					Process entity = new Process();
					entity.setProcessName(param.get("DIVProcessName").toString());
					List<Process> list = (List<Process>)processDao.searchByList(entity);
					if(list.size()>0){
						//消息：您所新建的工序名称已存在!
						if(checkType==1)
						map.put("DIVProcessName",  MessageReSource.getMessageBox(
								IConstant.WMSG0200, langCode, langValue));
			        }
				}
				
				//工序编码验证
				if(StringUtils.isEmpty(param.get("DIVProcessCode").toString())){
					map.put("DIVProcessCode", MessageReSource.getMessageBox(
							IConstant.WMSG0052, langCode, langValue));
				}else{
					Process entity = new Process();
					entity.setProcessCode(param.get("DIVProcessCode").toString());
					List<Process> list = (List<Process>)processDao.searchByList(entity);
					if(list.size()>0){
						//消息：您所新建的工序编码已存在!
						if(checkType==1)
						map.put("DIVProcessCode",  MessageReSource.getMessageBox(
								IConstant.WMSG0201, langCode, langValue));
			        }
				}
				
				//语言验证
//				if(StringUtils.isEmpty(param.get("DIVLanguageCode").toString())){
//					map.put("DIVLanguageCode",MessageReSource.getMessageBox(
//							IConstant.WMSG0024, langCode, langValue));
//				}
//				//删除区分验证
//				if(StringUtils.isEmpty(param.get("DIVDelFlag").toString())){
//					map.put("DIVDelFlag", MessageReSource.getMessageBox(
//							IConstant.WMSG0019, langCode, langValue));
//				}
			//编辑验证
			
			//新建提交
			if (checkType ==1){
				if(map.size() <= 0 ){
					process.setProcessID(NextKeyValue.getNextkeyvalue(
						IConstant.PROCESS, IConstant.PROCESS_ID, customerID));// 取得工序表主键
					process.setUpdateTime(new Date());// 更新时间
					process.setUpdateUser(customerID);// 更新者
					process.setCreateTime(new Date());// 创建时间
					process.setCreateUser(customerID);// 创建者
					process.setVersion(BigDecimal.ZERO);// 版本号
				}else{
					rtn.put("message", map);//返回map
					rtn.put("data", null); //数据
					rtn.put("status", IConstant.RESULT_CODE_2);//状态
					return rtn;
				}
			//编辑提交	
			}else{
				if(map.size() > 0 ){
				rtn.put("message", map);//返回map
				rtn.put("data", null); //数据
				rtn.put("status", IConstant.RESULT_CODE_2);//状态
				return rtn;
				}
			}
		} catch (SQLException e) {
            Process entity = new Process();
			//错误消息：数据库操作异常，查询失败!
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
			}						
		return rtn;
		
	}

}