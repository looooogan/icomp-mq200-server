package com.icomp.common.service.icomp.v01b01.s007;

import java.util.Map;

import com.icomp.entity.base.Deliveryplan;
import com.icomp.entity.base.Vtransitplan;

/**
 * 在途计划查询SERVICE接口
 * @ClassName: ICOMPV01B01S007Service 
 * @author Taoyy
 * @date 2014-8-15 上午11:40:29
 */
public interface ICOMPV01B01S007Service {
	
  /**
   * 在途计划查询列表
   * @title getList 
   * @param entity
   * @return
   * Map<String,Object>
  */
  public	Map<String, Object> getList(Vtransitplan entity);
  
  /**
   * 编辑在途计划
   * @title vtransitPlanEdit 
   * @param entity
   * @return
   * Map<String,Object>
  */
  public Map<String, Object> vtransitPlanEdit(Deliveryplan entity, String langCode,String langValue);
  
  /**
   * 添加实际到货时间、实际到货数量
   * @title vtransitPlanAdd 
   * @param entity
   * @return
   * Map<String,Object>
  */
  public Map<String, Object> vtransitPlanAdd(Deliveryplan entity, String lang,String langValue);

  public Map<String, Object> checkInput(Map<String, Object> param, String lang,String customerID, int i,String langValue);
  
  /**
   * 取得在途计划信息
   * @title getVtransitInfo 
   * @param entity
   * @return
   * Map<String,Object>
  */
  public Map<String, Object> getVtransitInfo(Deliveryplan entity);



}
