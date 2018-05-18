package com.icomp.common.service.icomp.v01c01.s001;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.*;

public interface ICOMPV01C01S001Service {

	/**
	 * 取得系统当前可选批次列表
	 * 
	 * @param entity
	 * @return
	 */
	public List<Toolprocured> getProcuredBatchList(Toolprocured entity);

	/**
	 * 取得钻头(刀片)入库的信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Rfidcontainer getBitInputInf(Rfidcontainer entity);
	
	/**
	 * 查询钻头(刀片)入库的信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Tool searchBitInputInf(Tool entity);
	
	/**
	 * 取得RFID信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Rfidcontainer getRfidExist(Rfidcontainer entity);

	/**
	 * 提交钻头入库信息
	 * 
	 * @param entity
	 * @return
	 */
	public Map<String, Object> setBitInputInf(List<Map<String, Object>> toolList,Knifeinventory entity);
	
	/**
	 * 提交刀片入库信息
	 * 
	 * @param entity
	 * @return
	 */
	public Map<String, Object> setToolInputInf(Knifeinventory entity,String toolCode);

	/**
	 * 判断新刀入库表是否有数据
	 * 
	 * @title getKnifeinventoryInfo 
	 * @param ki
	 * @return
	 * List<Knifeinventory>
	 */
	public List<Knifeinventory> getKnifeinventoryInfo(Knifeinventory ki)throws Exception;

	/**
	 * 判断刀具流转表是否有数据
	 * 
	 * @title getTooltransferInfo 
	 * @param tt
	 * @return
	 * List<Tooltransfer>
	 */
	public List<Tooltransfer> getTooltransferInfo(Tooltransfer tt)throws Exception;

	/**
	 * 获得刀具信息
	 * 
	 * @title getToolInfo 
	 * @param tool
	 * @return
	 * Tool
	 */
	public List<Tool> getToolInfo(Tool tool)throws Exception;


}
