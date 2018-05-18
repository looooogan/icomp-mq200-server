package com.icomp.common.service.icomp.v01b04.s006;

import java.util.Map;

import com.icomp.entity.base.Vgrindingrecord;
import com.icomp.entity.base.Vprocessingquickquery;

/**
 * 加工信息快速查询SERVICES接口
 * @ClassName: ICOMPV01B03S005Service 
 * @author Taoyy
 * @date 2014-8-20 下午04:42:36
 */
public interface ICOMPV01B04S006Service {
/**
 * 加工信息快速查询
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */

	public Map<String, Object> getList(Vprocessingquickquery entity);


}
