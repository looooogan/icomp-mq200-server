package com.icomp.v01b03.b03s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b03.s001.ICOMPV01B03S001Service;
import com.icomp.entity.base.Userdetail;
import com.icomp.entity.base.Vtoolnoticehistory;
import com.icomp.v01b03.b03s001.business.B03S001Business;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 刃磨记录查询BUsiness实现类
 *
 * @ClassName: B03S001BusinessImpl
 * @author Taoyy
 * @date 2014-8-12 下午04:10:15
 */
public class B03S001BusinessImpl implements B03S001Business {

	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 刃磨记录查询SERVICE
	 */
	private ICOMPV01B03S001Service icompv01b03s001Service;

	public void setIcompv01b03s001Service(ICOMPV01B03S001Service icompv01b03s001Service) {
		this.icompv01b03s001Service = icompv01b03s001Service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 刃磨记录查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue,int checkType)throws BusinessException {
		/**
		 * 设置检索条件
		 */
		String dateStarStr = param.get("DateStar").toString().trim();
		String dateEndStr = param.get("DateEnd").toString().trim();
		Vtoolnoticehistory entity=new Vtoolnoticehistory();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			// 申请起始时间
			if (dateStarStr != null && dateStarStr != "") {
				dateStarStr += " 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));
			}
			// 申请结束时间
			if (dateEndStr != null && dateEndStr != "") {
				dateEndStr += " 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 刀具入库编码
		//entity.setToolType(StringUtils.isEmpty(param.get("ToolConsumetype").toString()) ? null : param.get("ToolConsumetype").toString());
		//材料号
		entity.setSysteCode(StringUtils.isEmpty(param.get("systeCode").toString()) ? null : param.get("systeCode").toString());
		//设备编号
		// 2017/09/1 宋健 变更↓↓↓　dazhong@YMSC
//		entity.setEquipmentCode(StringUtils.isEmpty(param.get("grindingCode").toString()) ? null : param.get("grindingCode").toString());
		// 2017/09/1 宋健 变更↑↑↑　dazhong@YMSC
		//操作者
		entity.setRepairID(StringUtils.isEmpty(param.get("operator").toString()) ? null : param.get("operator").toString());
		entity.setEmpCard(StringUtils.isEmpty(param.get("operator").toString()) ? null : param.get("operator").toString());
		//刃磨后状态
		entity.setRepairedBecause(StringUtils.isEmpty(param.get("grindingStatus").toString()) ? null : param.get("grindingStatus").toString());
		//时间段
		if(checkType ==1) {
			// 分页起始行数
			entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
			// 分页页数
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		}else  if(checkType==2){
			entity.setStaIndex(0);
			entity.setRowCount(3000);
		}
		// 排序
		entity.setOrderString("NoticeTime desc");
		// 刃磨记录查询列表-ToolCode模糊查询
		Map<String, Object> rtn = icompv01b03s001Service.getListtool(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Vtoolnoticehistory>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
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
			throw new BusinessException(((List<Vtoolnoticehistory>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public String getNumber() throws BusinessException {
		return icompv01b03s001Service.getNumber();
	}

	@Override
	public List<Userdetail> getUser(Userdetail user) throws BusinessException {
		return icompv01b03s001Service.getUsner(user);
	}

}
