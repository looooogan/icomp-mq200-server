package com.icomp.common.service.icomp.v01b03.s003;

import java.util.Map;

import com.icomp.entity.base.Vtreasuryrepairtool;

/**
 * 库房待修复刀具查询SERVICE接口
 * @ClassName: ICOMPV01B03S003Service 
 * @author Taoyy
 * @date 2014-8-20 下午04:15:24
 */
public interface ICOMPV01B03S003Service {
/**
 * 库房待修复刀具查询
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */
public	Map<String, Object> getList(Vtreasuryrepairtool entity);


	
}
