package com.icomp.common.service.impl.icomp.v01b08.s005;

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
import com.icomp.common.service.icomp.v01b08.s005.ICOMPV01B08S005Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.ComlistDao;
import com.icomp.dao.VcomlistDao;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Vcomlist;

public class ICOMPV01B08S005ServiceImpl extends BaseService implements
		ICOMPV01B08S005Service {

	/**
	 * 系统码表配置Dao
	 */		
    private ComlistDao comlistDao;
    
    public void setComlistDao(ComlistDao comlistDao) {
		this.comlistDao = comlistDao;
	}

	/**
	 * 系统码表配置Dao
	 */	
    private VcomlistDao vcomlistDao;
    
	public void setVcomlistDao(VcomlistDao vcomlistDao) {
		this.vcomlistDao = vcomlistDao;
	}

	/**
	 * 系统码表配置
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 系统码表配置信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vcomlist entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vcomlist> list = (List<Vcomlist>) vcomlistDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vcomlist>();
				Vcomlist comlist = new Vcomlist();
				//消息：检索为0				
				comlist.setMessageCode(IConstant.EMSG0001);
				comlist.setRetErrFlag(true);
				list.add(comlist);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vcomlistDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vcomlist> list = new ArrayList<Vcomlist>();
			Vcomlist comlist = new Vcomlist();
			//错误消息：数据库操作异常，查询失败!			
			comlist.setMessageCode(IConstant.EMSG0004);
			comlist.setRetErrFlag(true);
			comlist.setExceMessage(e.getMessage());
			list.add(comlist);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
	/**
	 * 系统码表配置删除
	 * @param comlist 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> comlistDelete(Comlist comlist, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Comlist entity = new Comlist();
			entity.setComlistID(comlist.getComlistIDWhere());
			entity.setUpdateTime(comlist.getUpdateTimeWhere());
			entity.setUpdateUser(comlist.getUpdateUserWhere());
			entity.setVersion(comlist.getVersionWhere());
			List<Comlist> list = (List<Comlist>) comlistDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Comlist();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!				
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = comlistDao.updateNonQuery(comlist);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Comlist entity = new Comlist();
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
	 * 系统码表配置新建
	 * @param comlist 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	public Map<String, Object> comlistAdd(Comlist comlist, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			comlist.setComlistID(NextKeyValue.getNextkeyvalue(
					IConstant.COMLIST, IConstant.COMLIST_ID, comlist.getUpdateUser()));// 取得区分定义表主键
			comlistDao.insert(comlist);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Comlist entity = new Comlist();
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}


	/**
	 * 系统码表配置编辑
	 * @param comlist 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> comlistEdit(Comlist comlist, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 编辑失败! 进行数据排他验证
			Comlist entity = new Comlist();
			entity.setComlistID(comlist.getComlistIDWhere());
			entity.setUpdateTime(comlist.getUpdateTimeWhere());
			entity.setUpdateUser(comlist.getUpdateUserWhere());
			entity.setVersion(comlist.getVersionWhere());
			List<Comlist> list = (List<Comlist>) comlistDao.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Comlist();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新系统码表成功
			@SuppressWarnings("unused")
			int ret = comlistDao.updateNonQuery(comlist);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Comlist entity = new Comlist();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	
	/**
	 * 取得系统码表配置信息
	 * @param comlist 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getComlistInfo(Comlist entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Comlist> list = (List<Comlist>) comlistDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Comlist comlist = new Comlist();
				//消息：检索为0
				comlist.setMessageCode(IConstant.EMSG0001);
				comlist.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", comlist);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Comlist comlist = new Comlist();
			//错误消息：数据库操作异常，查询失败!
			comlist.setMessageCode(IConstant.EMSG0004);
			comlist.setRetErrFlag(true);
			comlist.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", comlist);
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
	@SuppressWarnings("unchecked")
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Comlist comlist = new Comlist();		
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		try {
			//新建验证
			if(checkType == 1){ 
				//区分值验证
				if(StringUtils.isEmpty(param.get("DIVComListValue").toString())){
					map.put("DIVComListValue", MessageReSource.getMessageBox(
							IConstant.WMSG0042, langCode, langValue));
				}else{
					Comlist entity = new Comlist();
					entity.setLanguageCode(param.get("DIVLanguageCode").toString());
					entity.setComListType(param.get("DIVComListType").toString());
					entity.setComListValue(param.get("DIVComListValue").toString());
					List<Comlist> list = (List<Comlist>)comlistDao.searchByList(entity);
					if(list.size()>0){
						//消息：您所新建的区分值已存在!
						map.put("DIVComListValue", MessageReSource.getMessageBox(
								IConstant.WMSG0193, langCode, langValue));
			        }
				}
				//区分文本验证
				if(StringUtils.isEmpty(param.get("DIVComListText").toString())){
					map.put("DIVComListText", MessageReSource.getMessageBox(
							IConstant.WMSG0043, langCode, langValue));
				}else{
					Comlist entity = new Comlist();
					entity.setLanguageCode(param.get("DIVLanguageCode").toString());
					entity.setComListType(param.get("DIVComListType").toString());
					entity.setComListText(param.get("DIVComListText").toString());
					List<Comlist> list = (List<Comlist>)comlistDao.searchByList(entity);
					if(list.size()>0){
						//消息：您所新建的区分文本已存在!
						map.put("DIVComListText", MessageReSource.getMessageBox(
								IConstant.WMSG0194, langCode, langValue));
			        }
				}
				//语言验证
				if(StringUtils.isEmpty(param.get("DIVLanguageCode").toString())){
					map.put("DIVLanguageCode", MessageReSource.getMessageBox(
							IConstant.WMSG0024, langCode, langValue));
				}
				//区分类型验证
				if(StringUtils.isEmpty(param.get("DIVComListType").toString())){
					map.put("DIVComListType", MessageReSource.getMessageBox(
							IConstant.WMSG0041, langCode, langValue));
				}
				//区分描述验证
				if(StringUtils.isEmpty(param.get("DIVComListMs").toString())){
					map.put("DIVComListMs", MessageReSource.getMessageBox(
							IConstant.WMSG0044, langCode, langValue));
				}
				//是否可以编辑验证
				if(StringUtils.isEmpty(param.get("DIVEditFlag").toString())){
					map.put("DIVEditFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0045, langCode, langValue));
				}
				//删除区分验证
				if(StringUtils.isEmpty(param.get("DIVDelFlag").toString())){
					map.put("DIVDelFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
			//编辑验证
			}else{ 
				//语言验证
				if(StringUtils.isEmpty(param.get("DIVLanguageCode").toString())){
					map.put("DIVLanguageCode", MessageReSource.getMessageBox(
							IConstant.WMSG0024, langCode, langValue));
				}
				//区分类型验证
				if(StringUtils.isEmpty(param.get("DIVComListType").toString())){
					map.put("DIVComListType", MessageReSource.getMessageBox(
							IConstant.WMSG0041, langCode, langValue));
				}
				//区分描述验证
				if(StringUtils.isEmpty(param.get("DIVComListMs").toString())){
					map.put("DIVComListMs", MessageReSource.getMessageBox(
							IConstant.WMSG0044, langCode, langValue));
				}
				//是否可以编辑验证
				if(StringUtils.isEmpty(param.get("DIVEditFlag").toString())){
					map.put("DIVEditFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0045, langCode, langValue));
				}
				//删除区分验证
				if(StringUtils.isEmpty(param.get("DIVDelFlag").toString())){
					map.put("DIVDelFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
			}
			
			//新建提交
			if (checkType ==1){
				if(map.size() <= 0 ){
					comlist.setComlistID(NextKeyValue.getNextkeyvalue(
						IConstant.COMLIST, IConstant.COMLIST_ID, customerID));// 取得区分定义表主键
					comlist.setUpdateTime(new Date());// 更新时间
					comlist.setUpdateUser(customerID);// 更新者
					comlist.setCreateTime(new Date());// 创建时间
					comlist.setCreateUser(customerID);// 创建者
					comlist.setVersion(BigDecimal.ZERO);// 版本号
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
			Comlist entity = new Comlist();
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