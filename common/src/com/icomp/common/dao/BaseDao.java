package com.icomp.common.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Tooltransfer;


public interface BaseDao {

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	public BaseEntity searchByPrimaryKey(BaseEntity entity) throws SQLException;
	
	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	public List<?> searchByList(BaseEntity entity) throws SQLException;
	
	/**
	 * 查询数据条数
	 * @param entity 查询条件
	 * @return 条数
	 * @throws SQLException
	 */
	public int searchByCount(BaseEntity entity) throws SQLException;
	
	/**
	 * 数据插入
	 * @param entity 插入数据
	 * @return 被插入的主键
	 * @throws SQLException
	 */
	public Object insert(BaseEntity entity) throws SQLException;
	
	/**
	 * 数据删除
	 * @param entity 删除数据
	 * @return 影响条数
	 * @throws SQLException
	 */
	public int delete(BaseEntity entity) throws SQLException;
	
	/**
	 * 数据更新
	 * @param entity 更新数据(未指定数据更新为null)
	 * @return 影响条数
	 * @throws SQLException
	 */
	public int update(BaseEntity entity) throws SQLException;

	/**
	 * 数据更新
	 * @param entity 更新数据(未指定数据不更新)
	 * @return 影响条数
	 * @throws SQLException
	 */
	public int updateNonQuery(BaseEntity entity) throws SQLException;


	/**
	 * 数据批量更新
	 * @param list 批量更新数据(未指定数据更新为null)
	 * @return 影响条数
	 * @throws SQLException
	 */
	public int updateBatch(List<? extends BaseEntity> list) throws SQLException;
	
	/**
	 * 数据批量更新
	 * @param entity 批量更新数据(未指定数据不更新)
	 * @return 影响条数
	 * @throws SQLException
	 */
	public int updateNonQueryBatch(List<? extends BaseEntity> list) throws SQLException;
	
	/**
	 * 数据批量插入
	 * @param entity 批量插入数据
	 * @param list
	 * @return 影响条数
	 * @throws SQLException
	 */
	public int insertBatch(List<? extends BaseEntity> list) throws SQLException;


}

