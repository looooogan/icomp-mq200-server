package com.icomp.common.service.icomp.v01b03.s004;

import java.util.Map;

import com.icomp.entity.base.Vgrindingworksummary;
/**
 * 刃磨工作量汇总SERVICE接口
 * @ClassName: ICOMPV01B03S004Service 
 * @author Taoyy
 * @date 2014-8-20 下午04:28:56
 */
public interface ICOMPV01B03S004Service {

/**
 * 刃磨工作量汇总列表
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */
public	Map<String, Object> getList(Vgrindingworksummary entity);

}
