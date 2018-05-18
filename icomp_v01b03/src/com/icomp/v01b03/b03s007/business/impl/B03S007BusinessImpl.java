package com.icomp.v01b03.b03s007.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b03.s007.ICOMPV01B03S007Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Tubedetailinfo;
import com.icomp.entity.base.Vgrindingquicksearch;
import com.icomp.v01b03.b03s007.business.B03S007Business;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 筒刀拆装记录查询BUSINESS实现类
 *
 * @ClassName: B03S007BusinessImpl
 * @author Sj
 * @date 2017-7-7 下午04:21:51
 */
public class B03S007BusinessImpl implements B03S007Business {

	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}
	/**
	 * 刃磨信息快速查询SERVICES
	 */

	private ICOMPV01B03S007Service icompv01b03s007Service;


	public void setIcompv01b03s007Service(ICOMPV01B03S007Service icompv01b03s007Service) {
		this.icompv01b03s007Service = icompv01b03s007Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 刃磨信息快速查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue) throws BusinessException {

		/**
		 * 设置检索条件
		 */
		Vgrindingquicksearch entity = new Vgrindingquicksearch();
		// 换领申请流水号
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ToolCode");
		// 刃磨信息快速查询列表
		Map<String, Object> rtn = icompv01b03s007Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vgrindingquicksearch>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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

	@Override
	public Map<String, Object> getListMerchants(Map<String, Object> param, String langCode, String langValue, int checkType) throws BusinessException {

		// 2017/09/16 宋健 变更↓↓↓　dazhong@YMSC
		Tubedetailinfo entity = new Tubedetailinfo();
		// 筒刀材料号
		// 2017/09/16 王冉 变更↓↓↓　dazhong@YMSC
		entity.setSynthesisParametersCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		// 2017/09/16 王冉 变更↑↑↑　dazhong@YMSC

		// 筒刀编号
		entity.setLaserIdentificationCode(StringUtils.isEmpty(param.get("LaserIdentificationCode").toString()) ? null : param.get("LaserIdentificationCode").toString());

		// 拆解人
		entity.setSplitUser(StringUtils.isEmpty(param.get("SplitUser").toString()) ? null : param.get("SplitUser").toString());

		// 拆解日期
		entity.setSplitTimeStar(StringUtils.isEmpty(param.get("SplitTimeStar").toString()) ? null : param.get("SplitTimeStar").toString());

		// 拆解日期
		entity.setSplitTimeEnd(StringUtils.isEmpty(param.get("SplitTimeEnd").toString()) ? null : param.get("SplitTimeEnd").toString());

		// 装配人
		entity.setInstallUser(StringUtils.isEmpty(param.get("InstallUser").toString()) ? null : param.get("InstallUser").toString());

		// 装配日期
		entity.setInstallTimeStar(StringUtils.isEmpty(param.get("InstallTimeStar").toString()) ? null : param.get("InstallTimeStar").toString());

		// 装配日期
		entity.setInstallTimeEnd(StringUtils.isEmpty(param.get("InstallTimeEnd").toString()) ? null : param.get("InstallTimeEnd").toString());
		// 2017/09/16 宋健 变更↑↑↑　dazhong@YMSC

		entity.setDelFlag(IConstant.DEL_FLAG_0);
		if (checkType == 1) {
			// 分页起始行数
			entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
			// 分页页数
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		} else if (checkType == 2) {
			entity.setStaIndex(0);
			entity.setRowCount(3000);
		}
		Map<String, Object> rtn = icompv01b03s007Service.getlistsMer(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			// 2017/09/16 王冉 变更↓↓↓　dazhong@YMSC
			throw new BusinessException(((List<Tubedetailinfo>) rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
			// 2017/09/16 王冉 变更↑↑↑　dazhong@YMSC
		}
		return rtn;
	}

	@Override
	public String getMnumber() throws BusinessException {
		return icompv01b03s007Service.getMnumber();
	}

	// 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
	@Override
	public Map<String, Object> detailInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
		Map<String, Object> ret = new HashMap<String, Object>();
		//取得详细信息
		Tubedetailinfo entity = new Tubedetailinfo ();
		entity.setSynthesisParametersCode(param.get("synthesisParametersCode").toString());
		entity.setRfId(param.get("rfId").toString());
		entity.setSplitTime(param.get("splitTime").toString());

		ret = icompv01b03s007Service.getDetailInfo ( entity );

		//查询失败
		if (ret.size () > 1 && ret.get ( "error" ) != null) {
			throw new BusinessException ( ((List<Tubedetailinfo>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
		}
		return ret;
	}

	@Override
	public Map<String, Object> totalInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
		Map<String, Object> ret = new HashMap<String, Object> ();
		//取得详细信息
		// 2017/09/16 宋健 变更↓↓↓　dazhong@YMSC
		Tubedetailinfo entity = new Tubedetailinfo();
		// 筒刀材料号
		// 2017/09/16 王冉 变更↓↓↓　dazhong@YMSC
		entity.setSynthesisParametersCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
		// 2017/09/16 王冉 变更↑↑↑　dazhong@YMSC

		// 筒刀编号
		entity.setLaserIdentificationCode(StringUtils.isEmpty(param.get("LaserIdentificationCode").toString()) ? null : param.get("LaserIdentificationCode").toString());

		// 拆解人
		entity.setSplitUser(StringUtils.isEmpty(param.get("SplitUser").toString()) ? null : param.get("SplitUser").toString());

		// 拆解日期
		entity.setSplitTimeStar(StringUtils.isEmpty(param.get("SplitTimeStar").toString()) ? null : param.get("SplitTimeStar").toString());

		// 拆解日期
		entity.setSplitTimeEnd(StringUtils.isEmpty(param.get("SplitTimeEnd").toString()) ? null : param.get("SplitTimeEnd").toString());

		// 装配人
		entity.setInstallUser(StringUtils.isEmpty(param.get("InstallUser").toString()) ? null : param.get("InstallUser").toString());

		// 装配日期
		entity.setInstallTimeStar(StringUtils.isEmpty(param.get("InstallTimeStar").toString()) ? null : param.get("InstallTimeStar").toString());

		// 装配日期
		entity.setInstallTimeEnd(StringUtils.isEmpty(param.get("InstallTimeEnd").toString()) ? null : param.get("InstallTimeEnd").toString());
		// 2017/09/16 宋健 变更↑↑↑　dazhong@YMSC

		ret = icompv01b03s007Service.getTotalInfo ( entity );

		//查询失败
		if (ret.size () > 1 && ret.get ( "error" ) != null) {
			throw new BusinessException ( ((List<Tubedetailinfo>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
		}
		return ret;
	}
	// 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC


}
