package com.icomp.v01b09.b09s004.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b09.s004.ICOMPV01B09S004Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.TooltransferTotal;
import com.icomp.v01b09.b09s004.business.B09S004Business;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class B09S004BusinessImpl implements B09S004Business {
	/**
	 * 系统初始化Service
	 */
	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B09S004Service iCOMPV01B09S004Service;
	public void setiCOMPV01B09S004Service(
			ICOMPV01B09S004Service iCOMPV01B09S004Service) {
		this.iCOMPV01B09S004Service = iCOMPV01B09S004Service;
	}
	/**
	 * 打印项目列表
	 * @param param 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue) throws BusinessException {
		//	Vdisplayeditemconfiguration entity = new Vdisplayeditemconfiguration();
		Containercarrier entity = new Containercarrier();
		entity.setContainerCarrierType(StringUtils.isEmpty(param.get("containerCarrierType").toString())?null:param.get("containerCarrierType").toString());
		entity.setPerson(StringUtils.isEmpty(param.get("person").toString())?null:param.get("person").toString());
		// 删除区分
		entity.setDelFlag(IConstant.DEL_FLAG_0);

		//	entity.setDelFlag(StringUtils.isEmpty(param.get("DelFlag").toString())?null:param.get("DelFlag").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		//	entity.setOrderString("PageName");
		Map<String, Object> rtn = iCOMPV01B09S004Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Containercarrier>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
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
		Map<String,Object> ret = iCOMPV01B09S004Service.checkInput(param,langCode,langValue,userID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			throw new BusinessException(((Displayeditemconfiguration)ret.get("error")).getMessageCode(), langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Containercarrier entity =(Containercarrier)ret.get("data");
		//保存打印项目信息
		ret = iCOMPV01B09S004Service.printItemAdd(entity,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//新建失败时，返回
			throw new BusinessException(((Containercarrier)ret.get("error")).getMessageCode(), langCode,langValue);
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
		// 2017/09/13 宋健 变更↓↓↓　dazhong@YMSC
		TooltransferTotal entity = new TooltransferTotal();
		entity.setToolCode(param.get("ID").toString());
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(userID);
		Map<String,Object> ret = iCOMPV01B09S004Service.itemDelete(entity,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//删除失败时，返回
			throw new BusinessException(((Containercarrier)ret.get("error")).getMessageCode(), langCode,langValue);
		}
		// 2017/09/13 宋健 变更↑↑↑　dazhong@YMSC
		return ret;
	}


	/**
	 * 编辑容器信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printItemEdit(Map<String, Object> param,
											 String langCode, String userID, String langValue)
			throws BusinessException {
		//用户输入验证
		Map<String,Object> ret = iCOMPV01B09S004Service.checkInput(param,langCode,langValue,userID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			throw new BusinessException(((Containercarrier)ret.get("error")).getMessageCode(), langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}

		Containercarrier entity = (Containercarrier) ret.get("data");
		//保存打印项目信息
		ret = iCOMPV01B09S004Service.printEdit(entity,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//新建失败时，返回
			throw new BusinessException(((Containercarrier)ret.get("error")).getMessageCode(),langCode, langValue);
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
	public Map<String, Object> printItemInfo(Map<String, Object> param, String langCode,String langValue) {
		Map<String,Object> ret = new HashMap<String,Object>();
		String containerCarrierID = param.get("containerCarrierID").toString();
		//取得待编辑用户信息
		Containercarrier entity = new Containercarrier();
		entity.setContainerCarrierID(containerCarrierID);
		ret = iCOMPV01B09S004Service.getprintItemInfo(entity);
		if(ret.size() > 1 && ret.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((Containercarrier)ret.get("error")).getMessageCode(),langCode,langValue);
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
