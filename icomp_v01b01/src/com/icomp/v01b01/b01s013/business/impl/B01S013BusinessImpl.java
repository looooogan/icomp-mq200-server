package com.icomp.v01b01.b01s013.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s013.ICOMPV01B01S013Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vtoolsop;
import com.icomp.v01b01.b01s013.business.B01S013Business;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 库存状况查询BUsiness实现类
 *
 * @ClassName: B01S013BusinessImpl
 * @author Licc
 * @date 2014-11-10 下午04:10:15
 */
public class B01S013BusinessImpl implements B01S013Business {

	/**
	 * 系统初始化Service
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 库存状况查询SERVICE
	 */
	private ICOMPV01B01S013Service icompv01b01s013Service;

	public void setIcompv01b01s013Service(
			ICOMPV01B01S013Service icompv01b01s013Service) {
		this.icompv01b01s013Service = icompv01b01s013Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 库存状况列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue)throws BusinessException{
		/**
		 * 设置检索条件
		 */
		Vtoolsop entity = new Vtoolsop();
		//刀具编码
//		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
//		//刀具分类
//		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
//		//分页页数
//		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
//		//排序
//		entity.setOrderString("ToolCode");
		//entity.setToolType(StringUtils.isEmpty(param.get("ToolType").toString()) ? null : param.get("ToolType").toString());
		if("edit".equals(param.get("opt"))) {
			entity.setSapID(StringUtils.isEmpty(param.get("sapID").toString()) ? null : param.get("sapID").toString());
		}else{
			entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
			entity.setDstar(StringUtils.isEmpty(param.get("dstar").toString()) ? null : param.get("dstar").toString());
			entity.setDend(StringUtils.isEmpty(param.get("dend").toString()) ? null : param.get("dend").toString());
			entity.setUserName(StringUtils.isEmpty(param.get("UserName").toString()) ? null : param.get("UserName").toString());
			entity.setMoveType(StringUtils.isEmpty(param.get("moveType").toString()) ? null : param.get("moveType").toString());
			entity.setStateSt(StringUtils.isEmpty(param.get("stateSt").toString()) ? null : param.get("stateSt").toString());
		}



		// 库存状况列表-ToolCode模糊查询

		Map<String, Object> rtn = icompv01b01s013Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtoolsop>) rtn.get("error")).get(0).getMessageCode(),langCode ,langValue);
		}
		return rtn;
	}

	/**
	 * 编辑sap信息
	 *
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> sapEdit(Map<String, Object> param, String langCode, String langValue) throws Exception {
		Map<String, Object> ret;

		//修改sap上传信息
		ret = icompv01b01s013Service.sapEdit ( param, langCode, langValue );
		if (ret.size () > 1 && ret.get ( "error" ) != null) {
			//新建失败时，返回
			throw new BusinessException ( ((Vtoolsop) ret.get ( "error" )).getMessageCode (), langCode, langValue );
		}
		return ret;
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
