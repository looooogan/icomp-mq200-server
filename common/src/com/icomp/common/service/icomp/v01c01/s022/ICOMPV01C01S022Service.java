package com.icomp.common.service.icomp.v01c01.s022;

import com.icomp.entity.base.Business;
import com.icomp.entity.base.Toolshelflnk;
import com.icomp.entity.base.Vgettoolshelfmessage;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 异常刀具处理-Services接口
 * @ClassName: ICOMPV01C01S022Service 
 * @author Taoyy
 * @date 2014-10-31 上午11:20:50
 */
public interface ICOMPV01C01S022Service {
	/**
	 * 取得工具盘列表
	 * @title getToolShelfList 
	 * @param entity
	 * @return
	 * @throws Exception
	 * List<Vgettoolshelfmessage>
	 */
  public List<Vgettoolshelfmessage> getToolShelfList(Vgettoolshelfmessage entity)throws Exception;
  	/**
  	 * 取得工具盘位置列表
  	 * @title getToolShelfLocations 
  	 * @param entity
  	 * @return
  	 * List<Vgettoolshelfmessage>
  	 */
	public List<Vgettoolshelfmessage> getToolShelfLocations(Toolshelflnk entity)throws Exception;
	/**
	 * 工具盘异常刀具处理
	 * @title saveToolShelfAbnormalTool 
	 * @param map
	 * @return
	 * @throws Exception
	 * int
	 */
	public int saveToolShelfAbnormalTool(Map<String, Object> map)throws Exception;
	
	/**
	 * 取得业务流程数据列表
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public List<Business> getBusinessList(Business entity) throws Exception;
	
	/**
	 * 取得待扫描标签列表
	 * @param businessCode
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> getRfidList(String businessCode,String toolType) throws Exception;
	
	/**
	 * 保存更替标签数据
	 * @param rfidString
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> saveRfid(String rfidString,String newRfidString) throws Exception;

    /**
     * 保存替换辅具
     * @param map
     * @return
     * @throws SQLException
     */
    public int saveHelpToolInfo(Map<String, Object> map) throws SQLException;

}
