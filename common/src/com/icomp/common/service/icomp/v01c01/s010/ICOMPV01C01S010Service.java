package com.icomp.common.service.icomp.v01c01.s010;

import com.icomp.entity.base.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 刀具换装-Service接口
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S010Service
 * @date 2016-2-26 下午01:30:36
 */
public interface ICOMPV01C01S010Service {
	/**
	 * 根据载体id查询合成刀具编码
	 * 
	 * @param entity
	 * @return
	 */
    Synthesisknife getSynthesisknife(Synthesisknife syentity) throws Exception;
    
    /**
	 * 根据载体id查询合成刀具ID
	 * 
	 * @param entity
	 * @return
	 */
    public List<Tooltransfer> getTooltransferList(Tooltransfer entity) throws Exception;
    
    /**
	 * 根据刀具ID查询材料号和刀具类型
	 * 
	 * @param entity
	 * @return
	 */
    public Tool getTool(Tool entity) throws Exception;
    
    /**
	 * 查询合成刀信息
	 * 
	 * @param entity
	 * @return
	 */
  List<Tooltransfer> getSyrfid(Tooltransfer entity) throws Exception;

    /**
	 * 查询单品刀信息
	 * 
	 * @param entity
	 * @return
	 */
      List<Tooltransfer> getSirfids(Tooltransfer entity) throws Exception;
    
    /**
	 * 更新刀具流转表
	 * 
	 * @param entity
	 * @return
	 */
    public int updateSyrfid(Tooltransfer entity) throws Exception;


	Synthesisparameters getSynthesisknifeId(Synthesisparameters syters) throws Exception;

	Tooltransfer getTooltransfer(Tooltransfer tooltransfer) throws Exception;

	/**
	 * 提交合成刀具报废信息
	 * @param map
	 * @return
	 * @throws SQLException
     */
	int saveToolScrapInfo(Map<String, Object> map)throws SQLException;

	/**
	 * 提交可复磨刀片的信息
	 * @param map
	 * @return
	 * @throws SQLException
     */
	int savesGrindingToolInfo(Map<String, Object> map)throws SQLException;

	/**
	 * 查询当前rfid的不同信息
	 * @param tfentity
	 * @return
	 * @throws SQLException
     */
	List<Tooltransfer> getSynthesisknifeToolMsg(Tooltransfer tfentity) throws SQLException;
	
	/**
	 * 查询当前标签类型
	 * @param scrapContainerRfid
	 * @return
	 * @throws SQLException
     */
	String getRfidType(String scrapContainerRfid,String userId,String type) throws SQLException;
	
	/**
	 * 刀具换装最后提交
	 * @param map
	 * @return
	 * @throws SQLException
     */
	String saveSubmit(Map<String, Object> map) throws SQLException;

	/**
	 * 提交热套换装完成信息
	 * @param par
	 * @return
	 * @throws Exception
     */
	int saveHotChangeInfo(Map<String, String> par) throws Exception;
	
	/**
	 * 提交换装信息(没有卸下任何刀具)
	 * @param par
	 * @return
	 * @throws Exception
     */
	int saveSubmitWithoutUnload(String rfidContainerId,String userId) throws Exception;

	/**
	 * 保存刀具卸下辅具信息（新增）
	 * @param map
	 * @return
	 * @throws Exception
     */
	int saveLoadownMsg(Map<String, String> map)throws Exception;

	/**
	 *  提交刀具安上辅具信息
	 * @param map
	 * @return
	 * @throws Exception
     */
	int saveUploadingMsg(Map<String, String> map) throws Exception;

	int getTooltransferCount(Tooltransfer tt) throws Exception;

	/**
	 * 删除备刀库的刀具信息
	 * @param map
	 * @return
	 * @throws Exception
     */
	int deleteRfidByToolID(Map<String, Object> map) throws Exception;

	/**
	 * 验证扫描的是否和安上的刀具相符合
	 * @param map
	 * @return
	 * @throws Exception
     */
	int seachToolMsg(Map<String, String> map) throws Exception;
}
