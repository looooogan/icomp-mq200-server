package com.icomp.common.service.icomp.v01c03.s001;

import com.icomp.entity.base.*;

import java.util.List;
import java.util.Map;

public interface ICOMPV01C03S001Service {
	
	/**
	 * 验证RFID是否可用
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Rfidcontainer checkRfid(Rfidcontainer entity);
	
	/**
	 * 取得刀具信息
	 * @param entity
	 * @return
	 */
	public Vtoolparam getToolInfo(Vtoolparam entity);
	
	/**
	 * 判断rfid状态
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Vtoolstack getRfidType(Vtoolstack entity);
	 
	/**
	 * 刀具初始化处理
	 * @param rfidList
	 * @param customerID
	 * @param langCode
	 * @param langValue
	 * @param handsetid
	 * @return
	 */
	public Map<String,Object> saveInitialization(List<Map<String,Object>> rfidList,
			String customerID,String langCode,String langValue,String handsetid);

	/**
	 * 根据材料号查询流转旧刀信息
	 * @param t
	 * @return
	 * @throws Exception
     */
	Tool getOldToolMsg(Tool t)throws Exception;

	/**
	 * 提交流转旧刀初始化
	 * @param param
	 * @return
	 * @throws Exception
     */
	Map<String,Object> submitOldRunInItDate(Map<String,Object> param)throws Exception;

	/**
	 * 查询库存新刀信息
	 * @param kentity
	 * @return
	 * @throws Exception
     */
	List<Vknifeinventoryinfo> getknifeinventoryinfo(Vknifeinventoryinfo kentity)throws Exception;

	/**
	 * 提交库存新刀初始化数据
	 * @param param
	 * @return
	 * @throws Exception
     */
	Map<String,Object> submitNewVentoryInItDate(Map<String,Object> param)throws Exception;

	/**
	 * 根据材料号查询刀具信息
	 * @param t
	 * @return
	 * @throws Exception
     */
	Tool getToolIDByToolCode(Tool t)throws Exception;

	/**
	 * 提交库位标签初始化数据
	 * @param param
	 * @return
	 * @throws Exception
     */
	Map<String,Object> submitLibraryCodeMsg(Map<String,Object> param)throws Exception;

	/**
	 * 根据载体ID查询合成刀具编码
	 * @param skentity
	 * @return
	 * @throws Exception
     */
	Synthesisknife getSynCodeByRfidConner(Synthesisknife skentity)throws Exception;



	/**
	 * 根据合成刀具ID查询合成刀具位置信息
	 * @param sm
	 * @return
	 * @throws Exception
     */
	List<Vgetsynsistoolmsg> getSynLocationMsg(Vgetsynsistoolmsg sm)throws Exception;






	Toolprocured getTProcuredBacth(Toolprocured tp)throws Exception;

	Object submitRfidConer(List<Rfidcontainer> r)throws Exception;


	//查询库位标签信息
	Vknifeinventoryinfo getknifeinventoryinfos(Vknifeinventoryinfo v)throws Exception;

	/**
	 * 根据rfidconer查询刀具id
	 * @param tt
	 * @return
	 * @throws Exception
     */
	Knifeinventory getToolCodeByRfidcon(Knifeinventory tt)throws Exception;
	
	/**
	 * 根据rfidconer查询刀具id
	 * @param tt
	 * @return
	 * @throws Exception
	 */
	Tooltransfer getToolIDByRfidcon(Tooltransfer tt)throws Exception;



	/**
	 * 提交合成刀具初始化
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> submitInitSynthesis( Map<String,Object> map)throws Exception;

	/**
	 * 查询当前材料号是否初始化
	 * @param vknifeinventoryinfo
	 * @return
	 * @throws Exception
     */
	Vknifeinventoryinfo getIsHasToolInit(Vknifeinventoryinfo vknifeinventoryinfo) throws Exception;

	/**
	 * 材料号查询库存信息
	 * @param entity
	 * @return
	 * @throws Exception
     */
	Vknifeinventoryinfo getknifeinventoryByToolCode(Vknifeinventoryinfo entity) throws Exception;

	/**
	 * 按照RFID查询库存信息
	 * @param kentity
	 * @return
	 * @throws Exception
     */
	Vknifeinventoryinfo getknifeinventoryBySamleTool(Vknifeinventoryinfo kentity)throws Exception;

	/**
	 * 按合成刀具编码查询合成刀具信息
	 * @param parMap
	 * @return
	 * @throws Exception
     */
	List<Vsynthesisparameters> getSynLocationMsgs(Map<String, Object> parMap)throws Exception;

	int getKinfeiverToolCount(Knifeinventory knifeinventory) throws Exception;
}
