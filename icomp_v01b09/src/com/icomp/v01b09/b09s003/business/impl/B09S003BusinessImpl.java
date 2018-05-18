package com.icomp.v01b09.b09s003.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b09.s003.ICOMPV01B09S003Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.v01b09.b09s003.business.B09S003Business;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B09S003BusinessImpl implements B09S003Business{
	/**
	 * 系统初始化Service
	 */
	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}
	
	private ICOMPV01B09S003Service iCOMPV01B09S003Service;
	


	public void setiCOMPV01B09S003Service(
			ICOMPV01B09S003Service iCOMPV01B09S003Service) {
		this.iCOMPV01B09S003Service = iCOMPV01B09S003Service;
	}

	//打印项目列表
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)
			throws BusinessException {
		Toolwholelifecycle entity = new Toolwholelifecycle();
		entity.setKnifeInventoryCode(StringUtils.isEmpty(param.get("libraryCode").toString())?null:param.get("libraryCode").toString());
		// 删除区分
		entity.setDelFlag(IConstant.STRING_0);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("createTime desc");
		Map<String, Object> rtn = iCOMPV01B09S003Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Toolwholelifecycle>) rtn.get("error")).get(0).getMessageCode(), langCode,langValue);
		}
		return rtn;
	}
	
	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode, String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(),langCode,langValue);
		}
		return list;
	}
	/**
	 * 新建打印项目信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> PrintItemAdd(Map<String, Object> param,String userID,
			String langCode, String langValue) {
		//打印项目输入验证
		Map<String,Object> ret = iCOMPV01B09S003Service.checkInput(param,langCode,langValue,userID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Displayeditemconfiguration)ret.get("error")).getMessageCode(), langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Displayeditemconfiguration entity = (Displayeditemconfiguration)ret.get("data");
		
		entity.setLanguageCode(param.get("DIVlanguageCode").toString());
		entity.setItemType( param.get("DIVItemType").toString());
		entity.setPageName(param.get("DIVPageName").toString());
		entity.setColName(param.get("DIVColName").toString());
		entity.setDisplayedFlag(param.get("DIVDisplayedFlag").toString());
		entity.setItemText(param.get("DIVItemText").toString());
		//保存打印项目信息
		ret = iCOMPV01B09S003Service.printItemAdd(entity,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Displayeditemconfiguration)ret.get("error")).getMessageCode(), langCode,langValue);
		}
		return ret;
	}
	
	
	/**
	 * 删除打印项目信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printItemDelete(Map<String, Object> param,
			String langCode, String userID, String langValue) {
		
		Displayeditemconfiguration entity = new Displayeditemconfiguration();
		entity.setDelFlag(IConstant.DEL_FLAG_1);
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(userID);
		//版本号
		entity.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));
		//更新条件:版本号
		entity.setVersionWhere(new BigDecimal(param.get("version").toString()));
		entity.setDisplayedItemConfigurationIDWhere(param.get("displayedItemConfigurationID").toString());
		entity.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		entity.setUpdateUserWhere(userID);
		Map<String,Object> ret = iCOMPV01B09S003Service.printEditDelete(entity,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Displayeditemconfiguration)ret.get("error")).getMessageCode(), langCode,langValue);
		}
		return ret;
	}
	
	
	/**
	 * 编辑项目打印信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printItemEdit(Map<String, Object> param,
			String langCode, String userID, String langValue)
			throws BusinessException {
	//用户输入验证
		Map<String,Object> ret = iCOMPV01B09S003Service.checkInput(param,langCode,langValue,userID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Displayeditemconfiguration)ret.get("error")).getMessageCode(), langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Displayeditemconfiguration entity =(Displayeditemconfiguration)ret.get("data");
		
		entity.setDisplayedItemConfigurationIDWhere(param.get("DivDisplayedItemConfigurationID").toString());
		entity.setItemType( param.get("DIVItemType").toString());
		entity.setLanguageCode(param.get("DIVlanguageCode").toString());
		entity.setPageName(param.get("DIVPageName").toString());
		entity.setColName(param.get("DIVColName").toString());
		entity.setDisplayedFlag(param.get("DIVDisplayedFlag").toString());
		entity.setItemText(param.get("DIVItemText").toString());
		//保存打印项目信息
		 ret = iCOMPV01B09S003Service.printEdit(entity,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Displayeditemconfiguration)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}
	/**
	 * 取得待编辑的项目打印信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printItemInfo(Map<String, Object> param,
			String langCode,String langValue) {
		Map<String,Object> ret = new HashMap<String,Object>();
		String DisplayedItemConfigurationID = param.get("displayedItemConfigurationID").toString();
		//取得待编辑用户信息
		Displayeditemconfiguration entity = new Displayeditemconfiguration();
		entity.setDisplayedItemConfigurationID(DisplayedItemConfigurationID);
		ret = iCOMPV01B09S003Service.getprintItemInfo(entity);
		if(ret.size() > 1 && ret.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((Displayeditemconfiguration)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
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
}
