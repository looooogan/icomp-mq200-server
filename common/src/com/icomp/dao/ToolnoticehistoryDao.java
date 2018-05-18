/*
 * 工具自动生成：刀具修复履历DAO接口
 * 生成时间    : 2014/08/11 15:35:18
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Toolnoticehistory;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface ToolnoticehistoryDao extends BaseDao{
/**
 * 批量更新刀具修复履历提交 
 * @title updateBatchDate 
 * @param tnhList
 * @return
 * int
 */
 public	int updateBatchDate(List<Toolnoticehistory> tnhList)throws Exception;
 /**
  * 更新刀具修复后履历提交 
  * @title updateBatchDateOld 
  * @param tnhList
  * @return
  * int
  */
public int updateBatchDateOld(List<Toolnoticehistory> tnhList)throws Exception;

    /**
     * 更改刀具修复前信息
     * @param tnh
     * @return
     * @throws SQLException
     */
  public   int updateProNotece(Toolnoticehistory tnh)throws SQLException;





    Object updateBatchss(List<Toolnoticehistory> tnlist)throws SQLException;
}

