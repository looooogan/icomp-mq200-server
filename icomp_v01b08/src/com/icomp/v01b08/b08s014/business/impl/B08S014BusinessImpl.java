package com.icomp.v01b08.b08s014.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s014.ICOMPV01B08S014Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Toolshelf;
import com.icomp.entity.base.Toolshelflnk;
import com.icomp.entity.base.Vtoolshelf;
import com.icomp.v01b08.b08s014.business.B08S014Business;

public class B08S014BusinessImpl implements B08S014Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B08S014Service iCOMPV01B08S014Service;

	public void setiCOMPV01B08S014Service(
			ICOMPV01B08S014Service iCOMPV01B08S014Service) {
		this.iCOMPV01B08S014Service = iCOMPV01B08S014Service;
	}

	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode, String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
		}
		return list;
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
			throw new BusinessException(((List<Displayeditemconfiguration>) ret.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}
	
	/**
	 * 取得零部件信息列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> getList(Map<String,Object> param,String langCode, String langValue)throws BusinessException{
		//设置检索条件
		Vtoolshelf entity = new Vtoolshelf();
		entity.setToolShelfCode(StringUtils.isEmpty(param.get("ToolShelfCode").toString())?null:param.get("ToolShelfCode").toString());
		//分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		//分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ToolShelfCode");
		Map<String,Object> rtn = iCOMPV01B08S014Service.getList(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Vtoolshelf>)rtn.get("error")).get(0).getMessageCode(), langCode,  langValue);
		}
		return rtn;
	}
	
	

	
	/**
	 * 新建关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> toolshelfAdd(Map<String,Object> param,String userID,String langCode,String langValue){
		//用户输入验证
		Map<String,Object> ret = iCOMPV01B08S014Service.checkInput(param,langCode, langValue,userID,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Toolshelf)ret.get("error")).getMessageCode(), langCode,  langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Toolshelf toolshelf = ( Toolshelf)ret.get("data");
		//保存关联信息
		ret = iCOMPV01B08S014Service.toolshelfAdd(toolshelf,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Toolshelflnk)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}
	
	/**
	 * 删除关联信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> toolshelfDelete(Map<String,Object> param,String userID,String langCode,String langValue){
		Toolshelf toolshelf = new Toolshelf();
		toolshelf.setToolShelfIDWhere(StringUtils.isEmpty(param.get("toolshelfID").toString())?null:param.get("toolshelfID").toString());
		Map<String,Object> ret = iCOMPV01B08S014Service.toolshelfDelete(toolshelf,langCode, langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Toolshelf)ret.get("error")).getMessageCode(), langCode,  langValue);
		}
		return ret;
	}

}
