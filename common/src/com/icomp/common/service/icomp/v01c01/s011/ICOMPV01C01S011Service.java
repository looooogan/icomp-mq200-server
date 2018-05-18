package com.icomp.common.service.icomp.v01c01.s011;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Oplink;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Synthesisparameters;
import com.icomp.entity.base.Synthesistoolsmachining;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgetequipmentlist;
import com.icomp.entity.base.Vgetequipmentnamebyrfid;

/**
 * 设备安上-Serbice接口
 * 
 * @ClassName: ICOMPV01C01S011Service
 * @author cyn
 * @date 2014-10-8 下午05:25:59
 */
public interface ICOMPV01C01S011Service {

	/**
	 * 合成刀具安上设备 saveToolInEquipment
	 * 
	 * @param rdid
	 * @param handid
	 * @param regSwitch
	 * @return
	 */
	public int saveToolInEquipment(Synthesisknife entity, String rdid,
			String handid) throws Exception;

	/**
	 * 取得设备 saveToolInEquipment
	 * 
	 * @param rdid
	 * @param handid
	 * @param regSwitch
	 * @return
	 */
	Map<String, Object> getEquipmentInfo(String rdid,
			String synthesisParametersCode) throws Exception;

	/**
	 * 取得合成刀具安装设备信息 getEquipmentToolInfo
	 * 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	List<Vgetequipmentnamebyrfid> getEquipmentToolInfo(
			Vgetequipmentnamebyrfid entity) throws Exception;

	/**
	 * 根据载体id查询合成刀具编码
	 * 
	 * @param spEmtity
	 * @return
	 */
	Synthesisknife getSynthesisknife(
			Synthesisknife spEmtity) throws Exception;

	/**
	 * 取得所有设备列表
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Vgetequipmentlist> getEquipmentList(Vgetequipmentlist vg) throws Exception;

	/**
	 * 取得流水线列表的信息
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	 Oplink getOplinkInfo(Oplink entity) throws Exception;
	 /**
	  * 插入合成刀具加工表
	  * @param stm
	 * @throws SQLException
	  */
	 int submitSyntheticInstallEquipmentInfo(Synthesistoolsmachining stm) throws SQLException;
	 /**
	  * 查询合成刀具编码和编号
	  * @param sk
	  * @return
	  * @throws SQLException
	  */
	 Synthesisknife getSynParameNumber(Synthesisknife sk)throws SQLException;

	/**
	 * 根据载体id查询刀具编码
	 * @param skEntity
	 * @return
	 * @throws SQLException
     */
	Synthesisknife getSynthesisknifebyRfidc(Synthesisknife skEntity) throws Exception;
	/**
	 * 根据RFID载体取得所有刀具信息
	 * @param skEntity
	 * @return
	 * @throws SQLException
     */
	List<Tooltransfer> getAllTool(String rfidConner,String customerID) throws Exception;



}
