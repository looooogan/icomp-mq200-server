package com.icomp.v01b11.b11s005.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b11.s005.ICOMPV01B11S005Service;
import com.icomp.entity.base.Leasertabe;
import com.icomp.v01b11.b11s005.business.B11S005Business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *加工信息快速查询BUSINESS实现类
 * @ClassName: B01S006BusinessImpl 
 * @author Taoyy
 * @date 2014-8-14 下午02:02:34
 */
public class B11S005BusinessImpl implements B11S005Business {


	/**
	 * 加工信息快速查询SERVICE
	 */
	private ICOMPV01B11S005Service icompv01B11S005Service;

	public void setIcompv01B11S005Service(ICOMPV01B11S005Service icompv01B11S005Service) {
		this.icompv01B11S005Service = icompv01B11S005Service;
	}

	/**
	 * 加工信息快速查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue)throws BusinessException {

		/**
		 *  设置检索条件
		 */
		Leasertabe entity = new Leasertabe();
		//0激活 1未激活
		entity.setLaserState(IConstant.GRINDING_1);
		//分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		//分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));

		entity.setDelFlag(IConstant.DEL_FLAG_0);
		//排序
//		entity.setOrderString("C");
		Map<String, Object> rtn = icompv01B11S005Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Leasertabe>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}

	public Map<String, Object> leaserSp(Map<String, Object> param, String customerID, String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String, Object>();
		String leaserID =  param.get("leaserID").toString();

		Leasertabe  entity = new Leasertabe();
		entity.setLeaserID(leaserID);
		ret = icompv01B11S005Service.getLease(param,entity,customerID);
		if(ret.size() > 1 && ret.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((Leasertabe)ret.get("error")).getMessageCode(),langCode,langValue);
		}
	  return ret;
	}


}
