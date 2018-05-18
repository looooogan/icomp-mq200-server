/*
 * 工具自动生成：换领申请DAO实现类
 * 生成时间    : 2016/03/24 16:13:59
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.icomp.common.entity.BaseEntity;
import  com.icomp.dao.RedemptionappliedDao;
import  com.icomp.entity.base.Redemptionapplied;

/**
 * RedemptionappliedDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/24 16:13:59
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class RedemptionappliedDaoImpl implements RedemptionappliedDao{

	/* 数据源 */
	private SqlMapClient dataSource;

	public void setDataSource(SqlMapClient dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 数据删除
	 *
	 * @param entity
	 *            删除数据
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int delete(BaseEntity entity) throws SQLException {
		// 数据删除
		return dataSource.delete("Redemptionapplied.delete", entity);
	}

	/**
	 * 数据插入
	 *
	 * @param entity
	 *            插入数据
	 * @return 被插入的主键
	 * @throws SQLException
	 */
	@Override
	public Object insert(BaseEntity entity) throws SQLException {
		// 数据插入

		return dataSource.insert("Redemptionapplied.insert", entity);

	}

	/**
	 * 数据批量插入
	 *
	 * @param entity
	 *            批量插入数据
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int insertBatch(List<? extends BaseEntity> list) throws SQLException {
		// 开启事务
		dataSource.startTransaction();
		List<Object> listObject = new ArrayList<Object>();
		try {
			for (Redemptionapplied entity : (List<Redemptionapplied>) list) {
				// 数据批量插入
				Object obj = dataSource.insert("Redemptionapplied.insert",
						entity);
				listObject.add(obj);
			}
			// 提交事务
			dataSource.commitTransaction();
		} catch (SQLException e) {
			// 回滚事务
			dataSource.endTransaction();
			throw e;
		} finally {
		}
		return listObject.size();
	}

	/**
	 * 查询数据条数
	 *
	 * @param entity
	 *            查询条件
	 * @return 条数
	 * @throws SQLException
	 */
	@Override
	public int searchByCount(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer) dataSource.queryForObject(
				"Redemptionapplied.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 *
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Redemptionapplied> searchByList(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (List<Redemptionapplied>) dataSource.queryForList(
				"Redemptionapplied.searchByList", entity);
	}

	/**
	 * 按任意查询
	 *
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Redemptionapplied> searchByList_Redemption(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (List<Redemptionapplied>) dataSource.queryForList(
				"Redemptionapplied.searchByList_Redemption", entity);
	}

	/**
	 * 非单品-获取换领出库申请人
	 *
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Redemptionapplied> getApplyUser(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (List<Redemptionapplied>) dataSource.queryForList(
				"Redemptionapplied.getApplyUser", entity);
	}

	/**
	 * 非单品-获取换领出库申请单
	 *
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Redemptionapplied> getRedemptionappliedListCodeByUserid(
			BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Redemptionapplied>) dataSource.queryForList(
				"Redemptionapplied.getRedemptionappliedListCodeByUserid", entity);
	}

	/**
	 * 按主键查询
	 *
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Redemptionapplied searchByPrimaryKey(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (Redemptionapplied) dataSource.queryForObject(
				"Redemptionapplied.searchByPrimaryKey", entity);
	}

	/**
	 * 数据更新
	 *
	 * @param entity
	 *            更新数据(未指定数据更新为null)
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int update(BaseEntity entity) throws SQLException {
		// 数据更新(未指定数据更新为null)
		return dataSource.update("Redemptionapplied.update", entity);
	}

	/**
	 * 数据批量更新
	 *
	 * @param entity
	 *            批量数据更新(未指定数据更新为null)
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int updateBatch(List<? extends BaseEntity> list) throws SQLException {
		// 开启事务
		dataSource.startTransaction();
		List<Object> listObject = new ArrayList<Object>();
		try {
			for (Redemptionapplied entity : (List<Redemptionapplied>) list) {
				// 数据批量更新(未指定数据更新为null)
				Object obj = dataSource.update("Redemptionapplied.update",
						entity);
				listObject.add(obj);
			}
			// 提交事务
			dataSource.commitTransaction();
		} catch (SQLException e) {
			// 回滚事务
			dataSource.endTransaction();
			throw e;
		} finally {
		}
		return listObject.size();
	}

	/**
	 * 数据更新
	 *
	 * @param entity
	 *            更新数据(未指定数据不更新)
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int updateNonQuery(BaseEntity entity) throws SQLException {
		// 数据更新(未指定数据不更新)
		return dataSource.update("Redemptionapplied.updateNonQuery", entity);
	}

	/**
	 * 数据批量更新
	 *
	 * @param entity
	 *            批量数据更新(未指定数据不更新)
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int updateNonQueryBatch(List<? extends BaseEntity> list)
			throws SQLException {
		// 开启事务
		dataSource.startTransaction();
		List<Object> listObject = new ArrayList<Object>();
		try {
			for (Redemptionapplied entity : (List<Redemptionapplied>) list) {
				// 数据批量更新(未指定数据不更新)
				Object obj = dataSource.update(
						"Redemptionapplied.updateNonQuery", entity);
				listObject.add(obj);
			}
			// 提交事务
			dataSource.commitTransaction();
		} catch (SQLException e) {
			// 回滚事务
			dataSource.endTransaction();
			throw e;
		} finally {
		}
		return listObject.size();
	}

	/**
	 * 批量插入 saveApplyInfoBatch
	 *
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	public Object saveApplyInfoBatch(List<Redemptionapplied> list)
			throws SQLException {
		// 数据插入
		return dataSource.insert("Redemptionapplied.saveApplyInfoBatch", list);
	}

	/**
	 *取得换领申请单
	 */
	@Override
	public List<Redemptionapplied> getRedemptionInfo(List<String> list)
			throws Exception {
		// 按查询
		return (List<Redemptionapplied>) dataSource.queryForList(
				"Redemptionapplied.getRedemptionInfo", list);
	}

	@Override
	public int updateBatchById(List<Redemptionapplied> list) throws Exception {
		// 更新换领申请表为已换领
		return dataSource.update("Redemptionapplied.updateBatchById", list);
	}

	@Override
	public int updateBatchStateByRfid(Map<String, Object> map) throws Exception {
		return dataSource.update("Redemptionapplied.updateBatchStateByRfid",
				map);
	}

	@Override
	public int updateBatchNotStateByRfid(Map<String, Object> map)
			throws Exception {
		return dataSource.update("Redemptionapplied.updateBatchNotStateByRfid",
				map);

	}

	@Override
	public List<Redemptionapplied> searchListById(Redemptionapplied entity)
			throws Exception {
		return (List<Redemptionapplied>) dataSource.queryForList(
				"Redemptionapplied.searchListById", entity);
	}

	@Override
	public int updateUnBackById(List<Redemptionapplied> list) throws Exception {
		// 更新换领申请表为实际送回数量
		return dataSource.update("Redemptionapplied.updateUnBackById", list);
	}

	@Override
	public int updateReceiveByIdAndToolCode(List<Redemptionapplied> list)
			throws Exception {
		// 根据申请单号的刀具编码修改实际送回数量
		return dataSource.update(
				"Redemptionapplied.updateReceiveByIdAndToolCode", list);
	}

	@Override
	public int updateBatchNotStateByState(Map<String, Object> map)
			throws Exception {
		return dataSource.update(
				"Redemptionapplied.updateBatchNotStateByState", map);
	}

	@Override
	public int updateByAnything(Redemptionapplied entity) throws Exception {
		// 按任意条件修改任意属性
		return dataSource.update("Redemptionapplied.updateByAnything", entity);
	}

	@Override
	public int updateByAnythingFour(Redemptionapplied entity)
			throws SQLException {
		return dataSource.update("Redemptionapplied.updateByAnythingFour",
				entity);
	}

	@Override
	public List<Redemptionapplied> getRequestList() throws SQLException {
		return (List<Redemptionapplied>) dataSource
				.queryForList("Redemptionapplied.getRequestList");
	}

	@Override
	public int updateRfidNullByAnything(Redemptionapplied entity)
			throws SQLException {
		// 按任意条件修改任意属性
		return dataSource.update("Redemptionapplied.updateRfidNullByAnything",
				entity);
	}

	@Override
	public List<Redemptionapplied> getReadiedToolsMessage() throws SQLException {
		// 取得已备货的刀具信息
		return dataSource
				.queryForList("Redemptionapplied.getReadiedToolsMessage");
	}

	@Override
	public List<Redemptionapplied> getApplyInfo(Redemptionapplied entity)
			throws SQLException {
		return dataSource
				.queryForList("Redemptionapplied.getApplyInfo",entity);
	}
}