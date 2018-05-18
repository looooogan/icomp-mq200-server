/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/05/18 10:10:13
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Toolprocured;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface ToolprocuredDao extends BaseDao{
	/**
	 * 批量增加
	 * @title batchInsert
	 * @param list
	 * void
	 */
	Object batchInsert(List<Toolprocured> list)throws SQLException;

	Toolprocured getTProcuredBacth(Toolprocured tp)throws Exception;

	List<Toolprocured> searchByToolList()throws SQLException;

	List<Toolprocured> searchListByToolCode(Toolprocured tp) throws SQLException;

	/**
	 * 查询到订单详情表中未入库的信息
	 * @return
	 * @throws SQLException
     */
	List<Toolprocured> findListByNoLib() throws SQLException;

}

