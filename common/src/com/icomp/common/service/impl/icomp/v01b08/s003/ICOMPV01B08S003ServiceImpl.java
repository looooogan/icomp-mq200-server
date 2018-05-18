package com.icomp.common.service.impl.icomp.v01b08.s003;

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
import com.icomp.common.service.icomp.v01b08.s003.ICOMPV01B08S003Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.LanguagetableDao;
import com.icomp.entity.base.Department;
import com.icomp.entity.base.Languagetable;

public class ICOMPV01B08S003ServiceImpl extends BaseService implements
		ICOMPV01B08S003Service {
	
	/**
	 * 国际化需求Dao
	 */		
    private LanguagetableDao languagetableDao;
    
	public void setLanguagetableDao(LanguagetableDao languagetableDao) {
		this.languagetableDao = languagetableDao;
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
	public Map<String, Object> getList(Languagetable entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Languagetable> list = (List<Languagetable>) languagetableDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Languagetable>();
				Languagetable languagetable = new Languagetable();
				//消息：检索为0
				languagetable.setMessageCode(IConstant.EMSG0001);
				languagetable.setRetErrFlag(true);
				list.add(languagetable);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = languagetableDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Languagetable> list = new ArrayList<Languagetable>();
			Languagetable languagetable = new Languagetable();
			//错误消息：数据库操作异常，查询失败!
			languagetable.setMessageCode(IConstant.EMSG0004);
			languagetable.setRetErrFlag(true);
			languagetable.setExceMessage(e.getMessage());
			list.add(languagetable);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 国际化需求删除
	 * 
	 * @param languagetable 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> languageTableDelete(Languagetable languagetable,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Languagetable entity = new Languagetable();
			entity.setLanguageCode(languagetable.getLanguageCodeWhere());
			entity.setUpdateTime(languagetable.getUpdateTimeWhere());
			entity.setUpdateUser(languagetable.getUpdateUserWhere());
			entity.setVersion(languagetable.getVersionWhere());
			List<Languagetable> list = (List<Languagetable>) languagetableDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Languagetable();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
			}else{
				if(list.get(0).getDelFlag().equals(IConstant.DEL_FLAG_0)){
					entity = new Languagetable();
					// 消息：该语言已启用不可删除
					entity.setMessageCode(IConstant.IMSG0007);
					entity.setRetErrFlag(true);
					rtn.put("error", entity);
					rtn.put("data", null);
				}else{
					
					Languagetable delentity = new Languagetable();
					delentity.setLanguageCodeWhere(languagetable.getLanguageCodeWhere());
					@SuppressWarnings("unused")
					int ret = languagetableDao.delete(delentity);
					// 消息：删除成功
					rtn.put("message", MessageReSource.getMessageBox(
							IConstant.IMSG0003, langCode,langValue));
					rtn.put("status", IConstant.RESULT_CODE_0);
				}
			}
			return rtn;
		} catch (SQLException e) {
			Languagetable entity = new Languagetable();
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
			String langCode,String langValue, String customerID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Languagetable languagetable = new Languagetable();
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		try {
			if(checkType == 1){ 
				//语言编码验证
				if(StringUtils.isEmpty(param.get("DivLanguageCode").toString())){
					map.put("DivLanguageCode", MessageReSource.getMessageBox(
							IConstant.WMSG0036, langCode, langValue));
				}else{
					Languagetable entity =new Languagetable();
					entity.setLanguageCode(param.get("DivLanguageCode").toString());
					List<Languagetable> list = (List<Languagetable>) languagetableDao
					.searchByList(entity);
					
					if (list.size() > 0) {
						//消息：语言编码已经存在，请更换！
						map.put("DivLanguageCode", MessageReSource.getMessageBox(
								IConstant.WMSG0185, langCode, langValue));
					} 
				}
				//语言值验证
				if(StringUtils.isEmpty(param.get("DIVLanguageValue").toString())){
					map.put("DIVLanguageValue",MessageReSource.getMessageBox(
							IConstant.WMSG0037, langCode, langValue));
				}else{
					Languagetable entity =new Languagetable();
					entity.setLanguageValue(param.get("DIVLanguageValue").toString());
					List<Languagetable> list = (List<Languagetable>) languagetableDao
					.searchByList(entity);
					
					if (list.size() > 0) {
						//消息：您所新建的语言值已存在!
						map.put("DIVLanguageValue",MessageReSource.getMessageBox(
								IConstant.WMSG0185, langCode, langValue));
					} 
				}
				//语言名称验证
				if(StringUtils.isEmpty(param.get("DIVLanguageName").toString())){
					map.put("DIVLanguageName", MessageReSource.getMessageBox(
							IConstant.WMSG0038, langCode, langValue));
				}
				
		}else if(checkType == 2){ 
			//编辑验证
			//语言编码验证
			if(StringUtils.isEmpty(param.get("DivLanguageCode").toString())){
				map.put("DivLanguageCode", MessageReSource.getMessageBox(
						IConstant.WMSG0036, langCode, langValue));
			}
			//语言名称验证
			if(StringUtils.isEmpty(param.get("DIVLanguageName").toString())){
				map.put("DIVLanguageName", MessageReSource.getMessageBox(
						IConstant.WMSG0038, langCode, langValue));
			}
		}
		
		//新建提交
		if (checkType ==1){
			if(map.size() <= 0 ){
				languagetable.setLanguageCode(NextKeyValue.getNextkeyvalue(
					IConstant.LANGUAGETABLE, IConstant.LANGUAGE_CODE, customerID));// 取得语言表主键
				languagetable.setUpdateTime(new Date());// 更新时间
				languagetable.setUpdateUser(customerID);// 更新者
				languagetable.setCreateTime(new Date());// 创建时间
				languagetable.setCreateUser(customerID);// 创建者
				languagetable.setVersion(BigDecimal.ZERO);// 版本号
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
			Languagetable entity = new Languagetable();
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

	/**
	 * 国际化需求新建
	 * 
	 * @param languagetable 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	public Map<String, Object> languageAdd(Languagetable language, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			languagetableDao.insert(language);
			//消息：插入成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Languagetable entity = new Languagetable();
			//错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	@SuppressWarnings("unchecked")
    /**
	 * 取得国际化需求信息
	 * 
	 * @param languagetable 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	public Map<String, Object> getlanguageInfo(Languagetable entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Languagetable> list = (List<Languagetable>) languagetableDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Languagetable languagetable = new Languagetable();
				//消息：检索为0
				languagetable.setMessageCode(IConstant.EMSG0001);
				languagetable.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", languagetable);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Languagetable languagetable = new Languagetable();	
			//错误消息：数据库操作异常，查询失败!			
			languagetable.setMessageCode(IConstant.EMSG0004);
			languagetable.setRetErrFlag(true);
			languagetable.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", languagetable);
			return rtn;
		}
	}

	@SuppressWarnings("unchecked")
    /**
	 * 国际化需求删除
	 * 
	 * @param languagetable 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	public Map<String, Object> languageEdit(Languagetable languagetable,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Languagetable entity = new Languagetable();
			entity.setLanguageCode(languagetable.getLanguageCodeWhere());
			entity.setUpdateTime(languagetable.getUpdateTimeWhere());
			entity.setUpdateUser(languagetable.getUpdateUserWhere());
			entity.setVersion(languagetable.getVersionWhere());
			List<Languagetable> list = (List<Languagetable>) languagetableDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Languagetable();
				//消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新成功
			@SuppressWarnings("unused")
			int ret = languagetableDao.updateNonQuery(languagetable);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Department entity = new Department();
			//消息：数据库操作异常,删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	@SuppressWarnings("unchecked")
   /**
	 * 国际化需求启用
	 * 
	 * @param languagetable 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	public Map<String, Object> languageStartUse(Languagetable languagetable,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//查询已启用项
			Languagetable entity1 = new Languagetable();
			entity1.setDelFlag(IConstant.DEL_FLAG_0);
			entity1.setDelFlagWhere(IConstant.DEL_FLAG_0);
			List<Languagetable> list0 = (List<Languagetable>) languagetableDao
			.searchByList(entity1);
			if (list0 == null || list0.size() == 0) {
				entity1 = new Languagetable();
				//消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity1.setMessageCode(IConstant.WMSG0009);
				entity1.setRetErrFlag(true);
				rtn.put("error", entity1);
				rtn.put("data", null);
				return rtn;
			}else{
				//将已经启用想改为未启用
				for(Languagetable t0:list0){
					t0.setDelFlag(IConstant.DEL_FLAG_1);
					t0.setVersion(t0.getVersion().add(BigDecimal.ONE));
					t0.setLanguageCodeWhere(t0.getLanguageCode());
					languagetableDao.updateNonQuery(t0);
				}
				
			}
			// 进行数据排他验证
			Languagetable entity = new Languagetable();
			entity.setLanguageCode(languagetable.getLanguageCodeWhere());
			entity.setUpdateTime(languagetable.getUpdateTimeWhere());
			entity.setUpdateUser(languagetable.getUpdateUserWhere());
			entity.setVersion(languagetable.getVersionWhere());
			List<Languagetable> list = (List<Languagetable>) languagetableDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Languagetable();
				//消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 启用成功
			@SuppressWarnings("unused")
			int ret = languagetableDao.updateNonQuery(languagetable);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0008, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Department entity = new Department();
			//消息：数据库操作异常,启用失败!
			entity.setMessageCode(IConstant.EMSG0009);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}


}
