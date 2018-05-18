package com.icomp.common.service.icomp.v01c01.s014;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Oplink;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolrepairnotice;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgetrepairnoticetoolmsg;

/**
 * 刀具分拣-Service接口
 * 
 * @ClassName: ICOMPV01C01S014Service
 * @author Taoyy
 * @date 2016-2-29 上午10:35:29
 */
public interface ICOMPV01C01S014Service {
	
	/**
	 * 查询容器列表	 
	 * @param entity 
	 * @return
	 */
	List<Tool> getToolList(Tool entity)throws Exception;
	
	/**
     * 按照RFIDCode取得刀具ID
     * @param entity
     * @return
     */
    String getToolID(Tooltransfer entity)throws Exception;
    
    /**
	  * 查询单品刀信息
	  * @param entity
	  * @return
	  * @throws SQLException
	  */
    Tool getToolInfo(Tool entity)throws SQLException;
    
    /**
	  * 查询标签类型
	  * @param entity
	  * @return
	  * @throws SQLException
	  */
    Rfidcontainer getQueryType(Rfidcontainer entity)throws SQLException;
    
    /**
	  * 取得流转表刀具信息
	  * @param entity
	  * @return
	  * @throws SQLException
	  */
    Tooltransfer getToolSortInfo(Tooltransfer entity)throws SQLException;
    
    /**
	 * 更新刀具流转表
	 * 
	 * @param spEmtity
	 * @return
	 */
    public int updateSyrfid(Map<String, Object> map) throws Exception;
	
	/**
	 * 分拣容器中的数据
	 * @param map
	 * rfidConnerID(String) 载体ID
	 * toolID(String)   刀具ID  
	 * toolDurable(String)   确认数量 
	 * grindingMode（String） 0厂内,1厂外
	 * @return
	 */
	int updateToolMsg(Map<String, Object> map)throws Exception;
	
	
	
	
	
	
	
	
	
	
	/**
	 * 取得刀具修复通知单信息
	 * 
	 * @title getToolInfo
	 * @param entity
	 * @return Vgetrepairnoticetoolmsg
	 */
	public Vgetrepairnoticetoolmsg getToolInfo(Vgetrepairnoticetoolmsg entity)
			throws Exception;

	/**
	 * 修复通知单号生成
	 * 
	 * @title createRepairNoticeNumber
	 * @param customerID
	 * @return String
	 */
	public String createRepairNoticeNumber(String customerID) throws Exception;

	/**
	 * 修复通知单发布
	 * 
	 * @title saveToolRepairNotice
	 * @param list
	 * @throws Exception void
	 */
	public Object saveToolRepairNotice(List<Toolrepairnotice> list,
			String userId, String handId) throws Exception;

	/**
	 * 取得修磨处理(非单品)
	 * 
	 * @title saveToolRepairNotice
	 * @param list
	 * @throws Exception void
	 */
	public Map<String, Object> getRegrindingList(Map<String, Object> rtn) throws Exception;
	/**
	 * 保存修磨处理(非单品)
	 * @title saveToolRepairNotice
	 * @param list
	 * @throws Exception void
	 */
	public Map<String, Object> saveRegrinding(Map<String, Object> rtn) throws Exception;

	List<Tooltransfer> getToolidBrfidconer(Tooltransfer tr)throws Exception;
	/**
	 * 获取容器类型
	 * @title getContainerType
	 * @param rfidContainerId
	 * @throws Exception void
	 */
	String getContainerType(String rfidContainerId)throws Exception;
}
