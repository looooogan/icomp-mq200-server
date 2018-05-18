/*
 * 工具自动生成：DAO实现类
 * 生成时间    : 2016/03/24 16:13:59
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.ToolDao;
import com.icomp.entity.base.Tool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ToolDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/24 16:13:59
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class ToolDaoImpl implements ToolDao{

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
		return dataSource.delete("Tool.delete", entity);
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
		return dataSource.insert("Tool.insert", entity);
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
			for(Tool entity : (List<Tool>)list){
				//数据批量插入
				Object obj = dataSource.insert("Tool.insert", entity);
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
		return (Integer)dataSource.queryForObject("Tool.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tool> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Tool searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Tool)dataSource.queryForObject("Tool.searchByPrimaryKey", entity);
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
		return dataSource.update("Tool.update", entity);
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
			for(Tool entity : (List<Tool>)list){
				//数据批量更新(未指定数据更新为null)
				Object obj = dataSource.update("Tool.update", entity);
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
		return dataSource.update("Tool.updateNonQuery", entity);
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
			for(Tool entity : (List<Tool>)list){
				//数据批量更新(未指定数据不更新)
				Object obj = dataSource.update("Tool.updateNonQuery", entity);
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
	public List<?> searchByToolList() throws SQLException {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.searchByList");
	}

	@Override
	public List<Tool> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.searchByList", entity);
	}

	@Override
	public List<Tool> searchBitInputInf(Tool entity) throws SQLException {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.searchBitInputInf", entity);
	}

	@Override
	public List<Tool> getToolList(Tool entity) throws SQLException {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.searchByList", entity);
	}



	@Override
	public List<Tool> getRedemptionapplyInfo(Tool tl) throws SQLException {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.getRedemptionapplyInfo", tl);
	}

	@Override
	public List<Tool> getSynSingesToolList(Tool tt) throws SQLException {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.searchByList", tt);
	}

	@Override
	public Tool getToolID(Tool t) throws SQLException {
		// 按任意查询
		return (Tool)dataSource.queryForObject("Tool.getToolID", t);
	}

	@Override
	public Tool getToolCode(Tool t) throws Exception {
		// 按任意查询
		return (Tool)dataSource.queryForObject("Tool.searchByPrimaryKey", t);
	}

	@Override
	public List<Tool> getToolIDByToolCode(Tool tt) throws Exception {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.getToolIDByToolCode", tt);
	}

	@Override
	public Tool getOldToolMsg(Tool t) throws Exception {
		// 按任意查询
		return (Tool)dataSource.queryForObject("Tool.getToolIDByToolCode", t);
	}

	// 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
	@Override
	public List<Tool> getToolByToolCode(Tool t) throws Exception {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.getToolByToolCode", t);
	}

	@Override
	public List<Tool> searchToolInfoBySpcode(String spCode) throws Exception {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.searchToolInfoBySpcode", spCode);
	}

	@Override
	public List<Tool> searchBitInputInfo(Tool t) throws Exception {
		// 按任意查询
		return (List<Tool>)dataSource.queryForList("Tool.searchBitInputInfo", t);
	}
	// 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC
}

