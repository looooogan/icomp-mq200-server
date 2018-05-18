package com.icomp.v01b02.b02s006.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b02.s006.ICOMPV01B02S006Service;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.v01b02.b02s006.business.B02S006Business;

public class B02S006BusinessImpl implements B02S006Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	public ICOMPV01B02S006Service icompv01b02s006Service;

	public void setIcompv01b02s006Service(ICOMPV01B02S006Service icompv01b02s006Service) {
		this.icompv01b02s006Service = icompv01b02s006Service;
	}

	/**
	 * 取得系统区分列表
	 * 
	 * @param flagType
	 *            区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,String langValue) throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
		}
		return list;
	}

	/**
	 * 取得快速查询列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue) throws BusinessException{

		/**
		 * 设置检索条件
		 */
		Synthesisknife entity = new Synthesisknife();

		// 合成刀具编码
		entity.setSynthesisParametersCode(StringUtils.isEmpty(param.get("SynthesisParametersCode").toString()) ? null : param.get("SynthesisParametersCode").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("SynthesisParametersNumber*1,SynthesisParametersCode,SynthesisCutterNumber");
		// 快速查询列表-SynthesisParametersCode模糊查询
		Map<String, Object> rtn = icompv01b02s006Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Synthesisknife>) rtn.get("error")).get(0).getMessageCode(), langCode,langValue);
		}
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






}
