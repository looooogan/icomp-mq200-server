package com.icomp.v01b08.b08s003.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s003.ICOMPV01B08S003Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s003.business.B08S003Business;

public class B08S003BusinessImpl implements B08S003Business {
	
	/**
	 * 系统初始化SERVICE
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
    /**
     * 国际化需求配置SERVICE
     */
	private ICOMPV01B08S003Service iCOMPV01B08S003Service;

	public void setiCOMPV01B08S003Service(
			ICOMPV01B08S003Service iCOMPV01B08S003Service) {
		this.iCOMPV01B08S003Service = iCOMPV01B08S003Service;
	}

	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
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
	 * 取得国际化需求列表
	 * 
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue)
			throws BusinessException {
		// 设置检索条件
		Languagetable entity = new Languagetable();
		// 语言编码
		entity.setLanguageCode(StringUtils.isEmpty(param.get("LanguageCode").toString())?null:param.get("LanguageCode").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("LanguageCode");		
		// 取得国际化需求列表
		Map<String,Object> rtn = iCOMPV01B08S003Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Languagetable>)rtn.get("error")).get(0).getMessageCode(),  langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 删除国际化需求信息
	 * 
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> languageTableDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		
		Languagetable languagetable = new Languagetable();
		//删除区分设为“1”
		languagetable.setDelFlag(IConstant.DEL_FLAG_1);
		//更新时间
		languagetable.setUpdateTime(new Date());
		//用户ID
		languagetable.setUpdateUser(customerID);
		//版本号
		languagetable.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));
		//更新条件:语言编码
		languagetable.setLanguageCodeWhere(param.get("languageCode").toString());
		//更新条件:更新时间
		languagetable.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		//更新条件:更新者
		languagetable.setUpdateUserWhere(param.get("updateuser").toString());
		//更新条件:版本号
		languagetable.setVersionWhere(new BigDecimal(param.get("version").toString()));
		//删除国际化需求信息
		Map<String,Object> ret = iCOMPV01B08S003Service.languageTableDelete(languagetable,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Languagetable)ret.get("error")).getMessageCode(), langCode,langValue);
		}
		return ret;
	}

	/**
	 * 新建国际化需求信息
	 * 
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> languageAdd(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//语言输入验证
		Map<String,Object> ret = iCOMPV01B08S003Service.checkInput(param,langCode,langValue,customerID,1);
		//当验证失败时
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Languagetable)ret.get("error")).getMessageCode(),langCode,langValue);
		//当验证成功时，返回
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Languagetable language = new Languagetable();
		//新建时删除区分都为未启用1
		language.setDelFlag(IConstant.DEL_FLAG_1);
		//语言编码
		language.setLanguageCode(param.get("DivLanguageCode").toString());
		//语言值
		language.setLanguageValue(param.get("DIVLanguageValue").toString());
		//语言
		language.setLanguageName(param.get("DIVLanguageName").toString());	
		//更新时间
		language.setUpdateTime(new Date());
		//更新者
		language.setUpdateUser(customerID);
		//新建时间
		language.setCreateTime(new Date());
		//新建者
		language.setCreateUser(customerID);
		//版本号
		language.setVersion(new BigDecimal(param.get("DivVersion").toString()));

		//保存语言信息
		ret = iCOMPV01B08S003Service.languageAdd(language,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Languagetable)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;

	}

	/**
	 * 编辑国际化需求信息
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> languageEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode) {
		//语言输入验证
		Map<String,Object> ret = iCOMPV01B08S003Service.checkInput(param,langCode,langValue,customerID,2);
		//当验证失败时
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Languagetable)ret.get("error")).getMessageCode(),langCode,langValue);
		//当验证成功时，返回
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Languagetable languagetable = new Languagetable();
        //语言值
		languagetable.setLanguageValue(param.get("DIVLanguageValue").toString());
		//语言
		languagetable.setLanguageName(param.get("DIVLanguageName").toString());
		//更新时间
		languagetable.setUpdateTime(new Date());
		//更新者
		languagetable.setUpdateUser(customerID);
		//版本号
		languagetable.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
		//更新条件：语言编码
		languagetable.setLanguageCodeWhere(param.get("DivLanguageCode").toString());
		//更新条件：更新时间
		languagetable.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
		//更新条件：更新者
		languagetable.setUpdateUserWhere(param.get("DivUpdateUser").toString());
		//更新条件：版本号
		languagetable.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
		//保存语言信息
		ret = iCOMPV01B08S003Service.languageEdit(languagetable,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //编辑失败时，返回
			  throw new BusinessException(((Languagetable)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	/**
     * 待处理国际化需求取得
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
     * @return
     * @throws BusinessException
     */
	public Map<String, Object> languageInfo(Map<String, Object> param,
			String langCode,String langValue) {
		Map<String,Object> ret = new HashMap<String,Object>();
		//语言编码
		String languageCode = param.get("languageCode").toString();
		//当点击编辑时
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			//取得待编辑语言信息
			Languagetable entity = new Languagetable();
			//语言编码
			entity.setLanguageCode(languageCode);
			ret = iCOMPV01B08S003Service.getlanguageInfo(entity);
			if(ret.size() > 1 && ret.get("error") != null){
				  //取得错误时，返回
				  throw new BusinessException(((Languagetable)ret.get("error")).getMessageCode(),langCode, langValue);
			}
		}
		return ret;
	}
	
	/**
	 * 启用国际化需求信息
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Map<String, Object> languageStartUse(Map<String, Object> param,
			String langValue, String customerID, String langCode)throws BusinessException{
		Languagetable languagetable = new Languagetable();
		//启用-删除区分都为0
		languagetable.setDelFlag(IConstant.DEL_FLAG_0);
		//更新时间
		languagetable.setUpdateTime(new Date());
		//更新者
		languagetable.setUpdateUser(customerID);
		//版本号
		languagetable.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
		//更新条件：语言编码
		languagetable.setLanguageCodeWhere(param.get("DivLanguageCode").toString());
		//更新条件：更新时间
		languagetable.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
		//更新条件：更新者		
		languagetable.setUpdateUserWhere(param.get("DivUpdateUser").toString());
		//更新条件：版本号		
		languagetable.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
		//保存语言信息
		Map<String,Object>  ret = iCOMPV01B08S003Service.languageStartUse(languagetable,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //保存失败时，返回
			  throw new BusinessException(((Languagetable)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID     页面ID
	 * @param userID     用户ID
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
