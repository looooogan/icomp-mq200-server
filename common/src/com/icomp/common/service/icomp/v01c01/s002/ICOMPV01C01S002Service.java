package com.icomp.common.service.icomp.v01c01.s002;
import java.util.Map;

import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Rfidcontainer;

/**
 * 授权
 * @ClassName: ICOMPV01C01S002Service 
 * @author Taoyy
 * @date 2016-1-24 上午09:55:33
 */
public interface ICOMPV01C01S002Service {
	/**
	 * 授权
	 * @param request 
	 * @title setAuthorized 
	 * @param entity
	 * @return
	 * @throws Exception
	 * 	
	 */
	public Map<String, Object> saveAuthorized(String customerID,String authorizedReason, String toolID,
			String businessID,Customer entity)throws Exception;
	
	/**
	 * 查询授权ID(登陆)
	 * @title searchAuID 
	 * @param entity
	 * @return
	 * @throws Exception
	 * 	
	 */
	public Customer searchAuID(String customerID,Customer entity)throws Exception;
	
	/**
	 * 查询RFID载体ID
	 * @title searchRfid 
	 * @param entity
	 * @return
	 * @throws Exception
	 * 	
	 */
	public Rfidcontainer searchRfid(Rfidcontainer entity)throws Exception;
	

}
