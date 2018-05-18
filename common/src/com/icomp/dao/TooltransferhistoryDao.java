/*
 * 工具自动生成：刀具流转履历DAO接口
 * 生成时间    : 2014/08/14 17:53:20
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Tooltransferhistory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface TooltransferhistoryDao extends BaseDao{
	/**
	 * 批量添加
	 * @title insertBatchDefined 
	 * @param tthList
	 * @throws Exception
	 * void
	 */
  public Object insertBatchDefined(List<Tooltransferhistory> tthList)throws SQLException;
  	/**
  	 * 按刀具入库编码修改载体ID
  	 * @title updateByList 
  	 * @param map
  	 *  newRfid：新载体ID
  	 *  userId：用户ID
  	 *  list：入库刀具编码
  	 * @return
  	 * int
  	 */
	public int updateByList(Map<String, Object> map)throws Exception;

   /**
     * 根据RFIDlist删除流转履历的数据
     * @param map
     * delFlag -> 删除区分
     * userId -> 删除用户id
     * updateTime ->删用户时间
     * list -> rfidCode
     * @return
     */
    int updateBatchDeFlagByRfid(Map<String, Object> map) throws SQLException;
}

