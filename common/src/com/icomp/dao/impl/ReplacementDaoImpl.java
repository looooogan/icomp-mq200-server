/*
 * 工具自动生成：申领申请DAO实现类
 * 生成时间    : 2016/03/24 16:13:59
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.icomp.common.entity.BaseEntity;
import  com.icomp.dao.ReplacementDao;
import  com.icomp.entity.base.Replacement;

/**
 * ReplacementDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/24 16:13:59
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class ReplacementDaoImpl implements ReplacementDao{

	/* 数据源 */
	private SqlMapClient dataSource;
	public void setDataSource(SqlMapClient dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 数据删除
	 * @param entity 删除数据
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int delete(BaseEntity entity) throws SQLException {
		// 数据删除
		return dataSource.delete("Replacement.delete", entity);
	}

	/**
	 * 数据插入
	 * @param entity 插入数据
	 * @return 被插入的主键
	 * @throws SQLException
	 */
	@Override
	public Object insert(BaseEntity entity) throws SQLException {
		// 数据插入
		return dataSource.insert("Replacement.insert", entity);
	}

	/**
	 * 数据批量插入
	 * @param list 批量插入数据
	 * @return 影响条数
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int insertBatch(List<? extends BaseEntity> list) throws SQLException {
		//开启事务
		dataSource.startTransaction();
		List<Object> listObject = new ArrayList<Object>();
		try{
		for(Replacement entity : (List<Replacement>)list){
			//数据批量插入
			Object obj = dataSource.insert("Replacement.insert", entity);
			listObject.add(obj);
		}
		//提交事务
		dataSource.commitTransaction();
		}catch(SQLException e){
			//回滚事务
			dataSource.endTransaction();
			throw e;
		}finally {
        }
		return listObject.size();
	}

	/**
	 * 查询数据条数
	 * @param entity 查询条件
	 * @return 条数
	 * @throws SQLException
	 */
	@Override
	public int searchByCount(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Replacement.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Replacement> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Replacement>)dataSource.queryForList("Replacement.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Replacement searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Replacement)dataSource.queryForObject("Replacement.searchByPrimaryKey", entity);
	}

	/**
	 * 数据更新
	 * @param entity 更新数据(未指定数据更新为null)
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int update(BaseEntity entity) throws SQLException {
		// 数据更新(未指定数据更新为null)
		return dataSource.update("Replacement.update", entity);
	}

	/**
	 * 数据批量更新
	 * @param list 批量数据更新(未指定数据更新为null)
	 * @return 影响条数
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int updateBatch(List<? extends BaseEntity> list) throws SQLException {
		//开启事务
		dataSource.startTransaction();
		List<Object> listObject = new ArrayList<Object>();
		try{
		for(Replacement entity : (List<Replacement>)list){
			//数据批量更新(未指定数据更新为null)
			Object obj = dataSource.update("Replacement.update", entity);
			listObject.add(obj);
		}
		//提交事务
		dataSource.commitTransaction();
		}catch(SQLException e){
			//回滚事务
			dataSource.endTransaction();
			throw e;
		}finally {
        }
		return listObject.size();
	}

	/**
	 * 数据更新
	 * @param entity 更新数据(未指定数据不更新)
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int updateNonQuery(BaseEntity entity) throws SQLException {
		// 数据更新(未指定数据不更新)
		return dataSource.update("Replacement.updateNonQuery", entity);
	}

	/**
	 * 数据批量更新
	 * @param list 批量数据更新(未指定数据不更新)
	 * @return 影响条数
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int updateNonQueryBatch(List<? extends BaseEntity> list) throws SQLException {
		//开启事务
		dataSource.startTransaction();
		List<Object> listObject = new ArrayList<Object>();
		try{
		for(Replacement entity : (List<Replacement>)list){
			//数据批量更新(未指定数据不更新)
			Object obj = dataSource.update("Replacement.updateNonQuery", entity);
			listObject.add(obj);
		}
		//提交事务
		dataSource.commitTransaction();
		}catch(SQLException e){
			//回滚事务
			dataSource.endTransaction();
			throw e;
		}finally {
        }
		return listObject.size();
	}

	@Override
	public List<Replacement> searchByListWithUSername(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Replacement>)dataSource.queryForList("Replacement.searchByList", entity);
	}

	@Override
	public int searchByCountWithUSername(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Replacement.searchByCount", entity);
	}

	@Override
	public List<Replacement> getReplacementList(Replacement entity) throws SQLException {
		// 按任意查询
		return (List<Replacement>)dataSource.queryForList("Replacement.getReplacementList", entity);
	}

	@Override
	public List<Replacement> getReplacementApply(Replacement entity) throws SQLException {
		// 按任意查询
		return (List<Replacement>)dataSource.queryForList("Replacement.getReplacementApply", entity);
	}

	@Override
	public List<Replacement> getsearchByPrimaryKey_Code(Replacement entity) throws SQLException {
		// 按任意查询
		return (List<Replacement>)dataSource.queryForList("Replacement.searchByList", entity);
	}

	@Override
	public List<Replacement> getReplacementApplyElse(Replacement entity)
			throws SQLException {
		// 按任意查询
		return (List<Replacement>)dataSource.queryForList("Replacement.getReplacementApplyElse", entity);
	}
}

