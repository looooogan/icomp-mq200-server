package com.icomp.v01b09.b09s005.business.impl;


import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b09.s005.ICOMPV01B09S005Service;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.TooltransferTotal;
import com.icomp.v01b09.b09s005.business.B09S005Business;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class B09S005BusinessImpl implements B09S005Business {
	private ICOMPV01B09S005Service iCOMPV01B09S005Service;
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	public void setiCOMPV01B09S005Service(ICOMPV01B09S005Service iCOMPV01B09S005Service) {
		this.iCOMPV01B09S005Service = iCOMPV01B09S005Service;
	}

	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
		// 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
		TooltransferTotal entity = new TooltransferTotal();
		// 材料号
		entity.setToolCode(StringUtils.isEmpty(String.valueOf(param.get("expandSpace1"))) ? null : String.valueOf(param.get("expandSpace1")));

		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 待处理刀具信息查询-SynthesisParametersCode模糊查询
		Map<String, Object> rtn = iCOMPV01B09S005Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<TooltransferTotal>) rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		// 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC
		return rtn;
	}

	//	/**
//	 * 取得页面grid显示项目列表
//	 *
//	 * @param pageID
//	 * @param langValue
//	 * @return
//	 * @throws BusinessException
//	 */
//
////	public Map<String, Object> getGridColmun(String pageID,  String langCode, String langValue) throws BusinessException {
//
//		// 取得页面grid显示项目列表
//		Map<String, Object> ret = service.getGridColmun(pageID, langCode, IConstant.ITEM_TYPE_1);
//		if (ret.size() > 1 && ret.get("error") != null) {
//			// 取得失败时，返回
//			throw new BusinessException(((List<Displayeditemconfiguration>) ret
//					.get("error")).get(0).getMessageCode(), langCode, langValue);
//		}
//		return ret;
//	}
	public Map<String, Object> sferAdds(Map<String, Object> param, String langCode, String langValue,String userID)throws BusinessException {
		//补领输入验证
		Map<String, Object> ret = iCOMPV01B09S005Service.checkInput(param,langCode,langValue,1,userID);

		if(ret.size() >1 && ret.get("error") != null){
			throw new BusinessException(((Tooltransfer)ret.get("error")).getMessageCode(),"",langValue);
		}else if(ret.size() >1 && ret.get("message") != null){
			return ret;
		}
		Tooltransfer tooltransfer = (Tooltransfer) ret.get("data");

		ret = iCOMPV01B09S005Service.sfersAdd(tooltransfer, langCode, langValue);
		if (ret.size() > 0 && ret.get("error") != null && ret.get("message")!=null) {
			//新建失败时，返回
			throw new BusinessException(((Tooltransfer) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> getPageSelList(String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object>();
		List<Containercarrier> containercarriersList = iCOMPV01B09S005Service.getContainList();
		if(containercarriersList.size()>0 && containercarriersList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(containercarriersList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("ContainercarriersList", containercarriersList);
		return  ret;
	}


}
