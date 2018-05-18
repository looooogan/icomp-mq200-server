package com.icomp.common.service.icomp.v01c04.s001;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Vgettoolinformation;
import com.icomp.entity.base.Vstockinglist;

public interface ICOMPV01C04S001Service {
	
	/**
	 * 取得当前扫描刀具数据
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Vstockinglist> getToolList(Vstockinglist entity); 
	
	/**
	 * 取得盘点数据列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Vstockinglist> getStockingList(List<String> rfids); 
	
	/**
	 * 取得已扫描盘点数据列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Vstockinglist> searchByOldToolList(List<String> rfids); 
	
	/**
	 * 保存盘点数据列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> saveStockingList(List<String> rfids,List<Map<String,Object>> stockings, String customerID,
			String langCode, String langValue, String handsetid,String gruantUserID);

	/**
	 * 查询库位标签信息
	 * @param k
	 * @return
	 * @throws Exception
     */
	Knifeinventory getKNMsg(Knifeinventory k)throws Exception;

	/**
	 * 根据刀具ID查询材料号
	 * @param t
	 * @return
	 * @throws Exception
     */
	Tool getToolCode(Tool t)throws Exception;

	/**
	 * 提交在库盘点刀具信息
	 * @param kn
	 * @return
	 * @throws Exception
     */
	int submitCheckToolDate(Knifeinventory kn)throws Exception;

	/**
	 * 查询库位标签信息
	 * @param k
	 * @return
	 * @throws Exception
     */
	List<Knifeinventory> getKNMsgs(Knifeinventory k)throws Exception;



	List<Tool> getToolIDByToolCode(Tool t)throws Exception;


	List<Rfidcontainer> rfidList(List<Rfidcontainer> recodeList)throws Exception


			;

	int getupdateDel(Map<String, Object> rfMap)throws Exception;

	Vgettoolinformation gettoolinformation(Vgettoolinformation vv) throws SQLException, Exception;

	int getDelRFIDAndKn(Map<String, Object> rfMap) throws SQLException;
}
