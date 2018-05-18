package com.icomp.common.service.impl.icomp.v01b08.s006;

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
import com.icomp.common.service.icomp.v01b08.s006.ICOMPV01B08S006Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.HandsetDao;
import com.icomp.dao.VhandsetDao;
import com.icomp.entity.base.Handset;
import com.icomp.entity.base.Vhandset;

public class ICOMPV01B08S006ServiceImpl extends BaseService implements
		ICOMPV01B08S006Service {

	/**
	 * 手持机配置Dao
	 */		
    private HandsetDao handsetDao;
    private VhandsetDao vhandsetDao;
    
	public void setVhandsetDao(VhandsetDao vhandsetDao) {
		this.vhandsetDao = vhandsetDao;
	}

	public void setHandsetDao(HandsetDao handsetDao) {
		this.handsetDao = handsetDao;
	}

	/**
	 * 手持机配置
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 手持机配置信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vhandset entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vhandset> list = (List<Vhandset>) vhandsetDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vhandset>();
				Vhandset handset = new Vhandset();
				//消息：检索为0
				handset.setMessageCode(IConstant.EMSG0001);
				handset.setRetErrFlag(true);
				list.add(handset);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vhandsetDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			List<Vhandset> list = new ArrayList<Vhandset>();
			Vhandset handset = new Vhandset();
			//错误消息：数据库操作异常，查询失败!
			handset.setMessageCode(IConstant.EMSG0004);
			handset.setRetErrFlag(true);
			handset.setExceMessage(e.getMessage());
			list.add(handset);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 手持机配置删除
	 * @param handset 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> handsetDelete(Handset handset, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Handset entity = new Handset();
			entity.setHandSetID(handset.getHandSetIDWhere());
			entity.setUpdateTime(handset.getUpdateTimeWhere());
			entity.setUpdateUser(handset.getUpdateUserWhere());
			entity.setVersion(handset.getVersionWhere());
			List<Handset> list = (List<Handset>) handsetDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Handset();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = handsetDao.updateNonQuery(handset);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Handset entity = new Handset();
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
	 * 新建手持机配置
	 * @param handset 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	public Map<String, Object> handsetAdd(Handset handset, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			handset.setHandSetID(NextKeyValue.getNextkeyvalue(
					IConstant.HANDSET, IConstant.HANDSET_ID, handset.getUpdateUser()));// 取得手持机表主键
			handsetDao.insert(handset);
			//成功消息：插入成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Handset entity = new Handset();
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
	 * 取得待处理手持机信息
	 * @param handset 页面查询条件
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getHandsetInfo(Handset entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Handset> list = (List<Handset>) handsetDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Handset handset = new Handset();
				//消息：检索为0
				handset.setMessageCode(IConstant.EMSG0001);
				handset.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", handset);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Handset handset = new Handset();
			//错误消息：数据库操作异常，查询失败!
			handset.setMessageCode(IConstant.EMSG0004);
			handset.setRetErrFlag(true);
			handset.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", handset);
			return rtn;
		}
	}

	/**
	 * 编辑手持机信息
	 * @param handset 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> handsetEdit(Handset handset, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 编辑失败! 进行数据排他验证
			Handset entity = new Handset();
			entity.setHandSetID(handset.getHandSetIDWhere());
			entity.setUpdateTime(handset.getUpdateTimeWhere());
			entity.setUpdateUser(handset.getUpdateUserWhere());
			entity.setVersion(handset.getVersionWhere());
			List<Handset> list = (List<Handset>) handsetDao.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Handset();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新手持机成功
			@SuppressWarnings("unused")
			int ret = handsetDao.updateNonQuery(handset);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Handset entity = new Handset();
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
		Handset handset = new Handset();		
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		try {
			//新建验证
			if(checkType == 1){ 
				//手持机编码验证
				if(StringUtils.isEmpty(param.get("DIVHandSetCode").toString())){
					map.put("DIVHandSetCode",  MessageReSource.getMessageBox(
							IConstant.WMSG0046, langCode, langValue));
				}else{
					Handset entity = new Handset();
					entity.setDepartmentID(param.get("DIVDepartment").toString());
					entity.setHandSetCode(param.get("DIVHandSetCode").toString());
					entity.setDelFlag(IConstant.DEL_FLAG_0);
					List<Handset> list = (List<Handset>)handsetDao.searchByList(entity);
					if(list.size()>0){
						//消息：您所新建的手持机编码已存在!
						map.put("DIVHandSetCode",MessageReSource.getMessageBox(
								IConstant.WMSG0198, langCode, langValue));
			        }
				}
				//手持机名称验证
				if(StringUtils.isEmpty(param.get("DIVHandSetName").toString())){
					//请输入手持机名称!
					map.put("DIVHandSetName",MessageReSource.getMessageBox(
							IConstant.WMSG0196, langCode, langValue));
				}else{
					Handset entity = new Handset();
					entity.setDepartmentID(param.get("DIVDepartment").toString());
					entity.setHandSetName(param.get("DIVHandSetName").toString());
					entity.setDelFlag(IConstant.DEL_FLAG_0);
					List<Handset> list = (List<Handset>)handsetDao.searchByList(entity);
					if(list.size()>0){
						//消息：您所新建的手持机名称已存在!
						map.put("DIVHandSetName", MessageReSource.getMessageBox(
								IConstant.WMSG0197, langCode, langValue));
			        }
				}
				//部门验证
				if(StringUtils.isEmpty(param.get("DIVDepartment").toString())){
					map.put("DIVDepartment",  MessageReSource.getMessageBox(
							IConstant.WMSG0016, langCode, langValue));
				}
				
				//手持机状态验证
				if(StringUtils.isEmpty(param.get("DIVHandSetStauts").toString())){
					map.put("DIVHandSetStauts",  MessageReSource.getMessageBox(
							IConstant.WMSG0047, langCode, langValue));
				}
				//是否注册验证
				if(StringUtils.isEmpty(param.get("DIVIsRegistration").toString())){
					map.put("DIVIsRegistration",  MessageReSource.getMessageBox(
							IConstant.WMSG0048, langCode, langValue));
				}
				//登录状态验证
				if(StringUtils.isEmpty(param.get("DIVLoginStauts").toString())){
					map.put("DIVLoginStauts", MessageReSource.getMessageBox(
							IConstant.WMSG0049, langCode, langValue));
				}
				//删除区分验证
				if(StringUtils.isEmpty(param.get("DIVDelFlag").toString())){
					map.put("DIVDelFlag",  MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
			//编辑验证
			}else{ 
				//部门验证
				if(StringUtils.isEmpty(param.get("DIVDepartment").toString())){
					map.put("DIVDepartment",  MessageReSource.getMessageBox(
							IConstant.WMSG0016, langCode, langValue));
				}
				//手持机状态验证
				if(StringUtils.isEmpty(param.get("DIVHandSetStauts").toString())){
					map.put("DIVHandSetStauts",  MessageReSource.getMessageBox(
							IConstant.WMSG0047, langCode, langValue));
				}
				//是否注册验证
				if(StringUtils.isEmpty(param.get("DIVIsRegistration").toString())){
					map.put("DIVIsRegistration",  MessageReSource.getMessageBox(
							IConstant.WMSG0048, langCode, langValue));
				}
				//登录状态验证
				if(StringUtils.isEmpty(param.get("DIVLoginStauts").toString())){
					map.put("DIVLoginStauts", MessageReSource.getMessageBox(
							IConstant.WMSG0049, langCode, langValue));
				}
				//删除区分验证
				if(StringUtils.isEmpty(param.get("DIVDelFlag").toString())){
					map.put("DIVDelFlag",  MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
			}
			
			//新建提交
			if (checkType ==1){
				if(map.size() <= 0 ){
					handset.setHandSetID(NextKeyValue.getNextkeyvalue(
						IConstant.HANDSET, IConstant.HANDSET_ID, customerID));// 取得手持机表主键
					handset.setUpdateTime(new Date());// 更新时间
					handset.setUpdateUser(customerID);// 更新者
					handset.setCreateTime(new Date());// 创建时间
					handset.setCreateUser(customerID);// 创建者
					handset.setVersion(BigDecimal.ZERO);// 版本号
				}else{
					rtn.put("message", map);//返回map
					
				}
			//编辑提交	
			}else{
				if(map.size() > 0 ){
				rtn.put("message", map);//返回map
				}
			}
			
			rtn.put("data", handset); //数据
			rtn.put("status", IConstant.RESULT_CODE_2);//状态
		} catch (SQLException e) {
            Handset entity = new Handset();
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