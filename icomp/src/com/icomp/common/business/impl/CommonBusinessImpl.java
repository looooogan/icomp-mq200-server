package com.icomp.common.business.impl;


import com.icomp.common.business.CommonBusiness;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b00.s000.ICOMPV01B00S000Service;
import com.icomp.common.service.icomp.v01b04.s003.ICOMPV01B04S003Service;
import com.icomp.common.service.icomp.v01b07.s001.ICOMPV01B07S001Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 系统初始化Business
 * @author yzq
 *
 */
public class CommonBusinessImpl implements CommonBusiness{
    
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B00S000Service iCOMPV01B00S000Service;
	public void setiCOMPV01B00S000Service(
			ICOMPV01B00S000Service iCOMPV01B00S000Service) {
		this.iCOMPV01B00S000Service = iCOMPV01B00S000Service;
	}
	/**
	 * 在途计划报警查询SERVICE
	 */
	private ICOMPV01B07S001Service icompv01b07s001Service;

	public void setIcompv01b07s001Service(ICOMPV01B07S001Service icompv01b07s001Service) {
		this.icompv01b07s001Service = icompv01b07s001Service;
	}
	
	/**
	 * 加工量异常报警SERVICE
	 */
	private ICOMPV01B04S003Service icompv01b04s003Service;
	public void setIcompv01b04s003Service(ICOMPV01B04S003Service icompv01b04s003Service) {
		this.icompv01b04s003Service = icompv01b04s003Service;
	}
	/**
	 * 取得系统默认语言
	 * @return 默认语言编码
	 * @throws BusinessException
	 * 作成者：杨作庆
	 * 作成时间:2014-07-08 17:14 
	 */
	public Languagetable getSystemDefaultLanguage() throws BusinessException{
		Languagetable entity = service.getSystemDefaultLanguage();
		if(entity.isRetErrFlag()){//查询失败
		  throw new BusinessException(entity.getMessageCode(), "01","zh_CN");
		}
		return entity;
	}
	
	/**
	 * 取得系统默认语言
	 * @return 默认语言编码
	 * @throws BusinessException
	 * 作成者：杨作庆
	 * 作成时间:2014-07-08 17:14 
	 */
	public List<Languagetable> getSystemListLanguage(String lang,String langValue) throws BusinessException{
		List<Languagetable> list = service.getSystemListLanguage();
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), lang,langValue);
		}
		return list;
	}
	
	/**
	 * 取得页面文本内容
	 * @param getType 取得类型
	 * @param langCode 语言Code
	 * @param pageID 页面ID
	 * @param paraName 项目ID(未指定时则全取)
	 * @return 页面文本内容
	 * @throws BusinessException
	 * 作成者：杨作庆
	 * 作成时间:2014-07-08 17:14 
	 */
	public Map<String,String> getPageLabelText (String getType,String langCode,String pageID,String paraName,String langValue)throws BusinessException{
		Map<String,String> entity = service.getPageLabelText(getType,langCode, pageID, paraName);
		if(entity == null || entity.size() == 0){//查询失败
		  throw new BusinessException(IConstant.EMSG0001, langCode,langValue);
		}
		return entity;
	}
	

	/**
	 * 用户登录
	 * @return 登录用户信息、权限菜单
	 * @throws BusinessException
	 * 作成者：杨作庆
	 * 作成时间:2014-07-08 17:14 
	 */
	public Customer login (Map<String, Object> param,String langCode,String langValue)throws BusinessException{
		Customer entity = new Customer();
		entity.setUserName(param.get("UserName").toString());
		entity.setUserPass(Ctl.md5(param.get("UserPass").toString()));
		entity = iCOMPV01B00S000Service.login(entity);
		if(entity.isRetErrFlag()){//查询失败
			  throw new BusinessException(entity.getMessageCode(), langCode,langValue);
		}
		return entity;
	}
	

	/**
	 * 取得用户权限信息
	 * @param lang 系统使用语言
	 * @param userName 用户名
	 * @return 用户权限信息
	 * @throws BusinessException
	 * 作成者：杨作庆
	 * 作成时间:2014-07-08 17:14 
	 */
	public List<Vgrantlist> getUserGrant (String lang,String userName,String langValue) throws BusinessException{
		Vgrantlist serachParam = new Vgrantlist();//设置权限列表查询条件
		serachParam.setPositionLanguageCode(lang);
		serachParam.setPositionDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setSystemLanguageCode(lang);
		serachParam.setSystemDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setCapabilityLanguageCode(lang);
		serachParam.setCapabilityDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setAgencyLanguageCode(lang);
		serachParam.setAgencyDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setDepartmentLanguageCode(lang);
		serachParam.setDepartmentDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setBelongFlag(IConstant.BELONG_FLAG_0);
		serachParam.setUserName(userName);
		serachParam.setOrderString("CapabilityLevel ,CapabilityOrder");
		List<Vgrantlist> list = iCOMPV01B00S000Service.getUserGrant (serachParam);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), lang,langValue);
		}
		//将取出的list进行排序
		List<Vgrantlist> oneList = new ArrayList<Vgrantlist>();
		List<Vgrantlist> toList = new ArrayList<Vgrantlist>();
		List<Vgrantlist> outList = new ArrayList<Vgrantlist>();
		List<Vgrantlist> sanList = new ArrayList<Vgrantlist>();
		for(Vgrantlist entity: list){
			if(entity.getCapabilityLevel().intValue() == 1){//一级菜单
				oneList.add(entity);
			} else if(entity.getCapabilityLevel().intValue() == 2){//二级菜单
				toList.add(entity);
			} else if(entity.getCapabilityLevel().intValue() == 3){
				sanList.add(entity);
			}
		}
		for(Vgrantlist entity: oneList){
			outList.add(entity);
			for(Vgrantlist toEntity: toList){
				if(StringUtils.equals(toEntity.getCapCapabilityID(),entity.getCapabilityID())){
					outList.add(toEntity);
					for (Vgrantlist vgrantlist : sanList) {
						if(StringUtils.equals(toEntity.getCapabilityID(),vgrantlist.getCapCapabilityID())){
							outList.add(vgrantlist);
						}
					}
				}
			}
		}
		return outList;
	}
	/**
	 * 库存异常报警列表
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException {
		//结果集
		List<ValarmParamView> retList=new ArrayList<ValarmParamView>();
		// 库存异常报警列表
		Vtoolsmachining entity = new Vtoolsmachining();
		Map<String, Object> rtn = icompv01b04s003Service.getList(entity);
		List<Vtoolsmachining> listVin =(List<Vtoolsmachining>)rtn.get("rows");
		int vinventoryalarmNUM=0;
//		if(listVin!=null){
//		for (Vinventoryalarm vinventoryalarm : listVin) {
//			if(vinventoryalarm.getStates().equals(IConstant.INVENTORY_ALERT_0)){
//				vinventoryalarmNUM++;
//			}
//		}
		if (listVin == null) {
			listVin = new ArrayList<>();
		}
		vinventoryalarmNUM = listVin.size();
		ValarmParamView ent =new ValarmParamView();
		ent.setToolAlarmParam(vinventoryalarmNUM+"");
		ent.setToolAlarmType(IConstant.STRING_0);//0 库存异常报警
		retList.add(ent);
//		}
//		//在途异常报警
//		Vtransitalarm entity1 = new Vtransitalarm();
//		ValarmParamView entRet1 =new ValarmParamView();
//		Map<String, Object> rtn1 = icompv01b07s001Service.getList(entity1);
//		List<Vtransitalarm> listVin1 =(List<Vtransitalarm>)rtn1.get("rows");
//		vinventoryalarmNUM=0;
//		if(listVin1!=null){
//			for (Vtransitalarm ent1: listVin1) {
//				if(ent1.isRetErrFlag()){
//					vinventoryalarmNUM++;
//				}
//			}
//			entRet1.setToolAlarmParam(vinventoryalarmNUM+"");
//		}else{
//			entRet1.setToolAlarmParam(IConstant.STRING_0);
//		}
//		entRet1.setToolAlarmType(IConstant.STRING_1);//1在途异常报警
//		retList.add(entRet1);
//		//加工量异常报警
//		Vprocessingabnormalalarm entity2 = new Vprocessingabnormalalarm();
//		Map<String, Object> rtn2 = icompv01b04s003Service.getLista(entity2);
//		List<Vprocessingabnormalalarm> listVin2 =(List<Vprocessingabnormalalarm>)rtn2.get("rows");
//		vinventoryalarmNUM=0;
//		//告警参数r.toolAlarmRatio;
//		//加工数量设定r.processAmount;
//		//定额加工量设定r.quotaProcessingVolume;
//		if(listVin2!=null){
//		for (Vprocessingabnormalalarm ent2: listVin2) {
//			if(ent2.getToolAlarmRatio()!=null
//					&&ent2.getProcessAmount()!=null
//					&&ent2.getQuotaProcessingVolume()!=null
//					&&ent2.getQuotaProcessingVolume().intValue()!=0){
//			int ret=Math.abs(ent2.getProcessAmount().subtract(ent2.getQuotaProcessingVolume()).intValue())/ent2.getQuotaProcessingVolume().intValue()*100;
//			if(ret>ent2.getToolAlarmRatio().intValue()){
//				vinventoryalarmNUM++;
//			}
//			}
//		}
//		ValarmParamView ent21 =new ValarmParamView();
//		ent21.setToolAlarmParam(vinventoryalarmNUM+"");
//		ent21.setToolAlarmType(IConstant.STRING_2);//2加工量异常报警
//		retList.add(ent21);
//		}
		rtn.put("rows",retList);
		rtn.put("total", 1);
		rtn.put("page", 1);

		return rtn;
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
	/**
	 * 修改密码
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> ChangePassword(Map<String, Object> param, String customerID,
			String langCode, String langValue) {
		
		//密码输入验证
		Map<String,Object> ret = service.checkChangePasswordInput(param,langCode,langValue,customerID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Customer)ret.get("error")).getMessageCode(), langCode, langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Customer customer = ( Customer)ret.get("data");
		//保存密码信息
		 ret = service.ChangePassword(customer,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Customer)ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}
}
