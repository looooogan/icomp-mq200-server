package com.icomp.common.service.icomp.v01b06.s006;

import java.util.Map;

import com.icomp.entity.base.Vanalysisabnormalprocessing;

/**
 * 定额执行情况分析SERVICES接口
 * @ClassName: ICOMPV01B06S006Service 
 * @author Taoyy
 * @date 2014-8-22 上午10:06:32
 */

public interface ICOMPV01B06S006Service {
/**
 *定额执行情况分析
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */
public Map<String, Object> getList(Vanalysisabnormalprocessing entity);


}
