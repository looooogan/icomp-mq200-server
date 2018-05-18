package com.icomp.common.service.icomp.v01b07.s002;

import com.icomp.entity.base.Vtoolalarmparam;

import java.util.Map;


/**
 * 库存异常报警SERVICE接口
 * @ClassName: ICOMPV01B07S002Service 
 * @author Taoyy
 * @date 2014-9-19 下午01:30:45
 */

public interface ICOMPV01B07S002Service {

//	Map<String, Object> getInventoryCountList(Vinventoryalarm entity);
Map<String, Object> getLists(Vtoolalarmparam entity);

    String getNumber();
}
