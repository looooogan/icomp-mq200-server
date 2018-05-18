package com.icomp.common.service.icomp.v01b11.s005;

import com.icomp.entity.base.Leasertabe;

import java.util.Map;
/*刀具绑定接口*/
public interface ICOMPV01B11S005Service {
/*查询所有*/
	 Map<String, Object> getList(Leasertabe entity);

/*刀具绑定*/
	Map<String,Object> getLease(Map<String, Object> param, Leasertabe entity, String customerID);


}
