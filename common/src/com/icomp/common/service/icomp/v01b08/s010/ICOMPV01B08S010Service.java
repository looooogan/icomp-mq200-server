package com.icomp.common.service.icomp.v01b08.s010;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Productiondesign;
import com.icomp.entity.base.Vproductiondesign;


/**
 * 零部件配置Service
 * @author lcc
 *
 */
public interface ICOMPV01B08S010Service {
	
	/**
	 * 取得零部件配置配置列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Vproductiondesign entity);
	/**
	 * 验证参数信息
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String customerID, String langValue, int i);
	/**
	 * 数据保存
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> productionDesignSave(
			List<Productiondesign> entity, String langCode, String customerID,
			String langValue);
	
	/**
	 * 取得零部件列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	
	List<Assemblyline> getAssemblylineList(Assemblyline entity);
	public List<Vproductiondesign> getYearList(Vproductiondesign entity);
	

	


}