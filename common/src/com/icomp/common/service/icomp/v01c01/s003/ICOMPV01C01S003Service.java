package com.icomp.common.service.icomp.v01c01.s003;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.entity.base.*;

/**
 * 刀具换领-Serbice接口
 * 
 * @ClassName: ICOMPV01C01S003Service
 * @author Taoyy
 * @date 2016-3-4 下午05:25:59
 */
public interface ICOMPV01C01S003Service {
	
	/**
	 * 取得用户信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Redemptionapplied searchUserExit(Redemptionapplied entity);
	
	/**
	 * 取得换领申请单
	 * 
	 * @title getRedemptionInfo
	 * @param entity
	 * @return List<Redemptionapplied>
	 */
	public List<Redemptionapplied> getRedemptionInfo(Redemptionapplied entity)
			throws Exception;
	
	/**
	 * 取得换领申请人申请信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getApplyInfo(Redemptionapplied entity) throws Exception;
	
    /**
	  * 取得新刀库存信息
	  * @param entity
	  * @return
	  * @throws SQLException
	  */
	Knifeinventory searchToolIn(Knifeinventory entity)throws SQLException;
	
    /**
	  * 取得要换领出库的刀具信息
	  * @param entity
	  * @return
	  * @throws SQLException
	  */
	Tool getRedemptionapplyInfo(Tool entity)throws SQLException;
	
	/**
	 * 提交换领出库的刀具信息
	 * 
	 * @title saveRedemptionapplyInfo
	 * @param map
	 * @return int
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public Map<String, Object> saveRedemptionapplyInfo(List<Map<String, Object>> toolList) throws Exception;

	/**
	 * 取得换领申请单明细
	 * 
	 * @title getRedemptionDetail
	 * @param entity
	 * @return List<Vgetredemptionappdetailedmsg>
	 */
	public List<Vgetredemptionappdetailedmsg> getRedemptionDetail(
			Vgetredemptionappdetailedmsg entity) throws Exception;

	/**
	 * 取得货架信息
	 * 
	 * @title getRedemptionToolInfo
	 * @param entity
	 * @return List<Vgetshelfinformation>
	 */
	public List<Vgetshelfinformation> getRedemptionToolInfo(
			Vgetshelfinformation entity) throws Exception;

	/**
	 * 更新备货刀具状态
	 * 
	 * @title saveStockingToolStauts
	 * @param map
	 * @return int
	 */
	public int saveStockingToolStauts(Map<String, Object> map) throws Exception;

	/**
	 * 新旧RFID交换
	 * 
	 * @title saveOutputStockingTool
	 * @param map
	 * @return
	 * @throws Exception int
	 */
	public int saveOutputStockingTool(Map<String, Object> map) throws Exception;

	/**
	 * 取得Old用户
	 * 
	 * @title findOldUserId
	 * @param redemptionAppliedID
	 * @return
	 * @throws Exception
	 *             String
	 */
	public Redemptionapplied findOldUserId(String redemptionAppliedID)
			throws Exception;

	/**
	 * 换领结束
	 * 
	 * @title saveRedemptionInfo
	 * @param map
	 * @return
	 * @throws Exception int
	 */
	public int saveRedemptionInfo(Map<String, Object> map) throws Exception;
	/**
	 * 换领结束
	 * 
	 * @title saveRedemptionInfo
	 * @param map
	 * @return
	 * @throws Exception int
	 */
	public Map<String, Object> saveRedemptionApplied(Map<String, Object> map);

	/**
	 * 验证是否存在专机领用数据
	 * 
	 * @title existLedplane
	 * @param entity
	 * @return
	 * @throws Exception
	 *             C01S003Respons
	 */
	public List<Vledplanelist> existLedplane(Vledplanelist entity)
			throws Exception;

	/**
	 * 刀具信息快速查询
	 * 
	 * @title getToolInfo
	 * @param entity
	 * @return
	 * @throws Exception
	 *             C01S023Respons
	 */
	public List<Vquerytoollist> getToolInfo(Vquerytoollist entity)
			throws Exception;

	/**
	 * 更新专机领用数据
	 * 
	 * @param map
	 * @throws Exception
	 */
	public int saveLedplane(Map<String, Object> map) throws Exception;

	/**
	 *取得申请信息
	 * 
	 * @return
	 */
	public List<Redemptionapplied> getRequestList() throws Exception;

	/**
	 * 获取申请单列表详细信息_新
	 * 
	 * @param entity
	 * @return
	 */
	public List<Vredemptionappdetailedmsgnew> getChoiceList(
			Vredemptionappdetailedmsgnew entity);

	/**
	 * 备货信息提交_新
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int stockMsgSubmit(Map<String, Object> map) throws Exception;

	/**
	 * 领刀授权提交
	 * 
	 * @param map
	 * @return
	 */
	public int saveGetChangeTool(Map<String, Object> map) throws Exception;

	/**
	 * 获取申请单送回列表信息
	 * 
	 * @param entity
	 * @return
	 */
	public List<Redemptionapplied> getRemand(Redemptionapplied entity);

	/**
	 * 刀具送回信息提交
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int rereToolSubmit(Map<String, Object> map) throws Exception;

	/**
	 * 取得已备货的刀具信息
	 * 
	 * @param map
	 *            rfidString RFIDCODE userId 查询人Id
	 * @return
	 */
	public Redemptionapplied getReadiedToolsMessage(Map<String, Object> map)
			throws Exception;

	/**
	 * 获取申请人
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getApplyUser() throws Exception;
	/**
	 * 获取换领出库列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getRedemptionappliedListCodeByUserid() throws Exception;
	
	/**
	 *非单品--换领出库
	 * 
	 * @title saveRedemptionInfo
	 * @param redemptionapplied
	 * @return
	 * @throws Exception int
	 */
	public Map<String, Object> updateRedemptionApplied(Redemptionapplied redemptionapplied) throws Exception;

	/**
	 * 非单品-获取换领出库申请单
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Vquerytoollist findToolInfo(Vquerytoollist entity) throws Exception;

	/**
	 * 根据刀具编码获取入库量
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public List<Knifeinventory> getKnifeinventoryInfo(Knifeinventory ki) throws Exception;


}
