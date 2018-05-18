/*
 * 工具自动生成：RFID载体DAO实现类
 * 生成时间    : 2016/03/24 16:13:59
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.entity.base.Rfidcontainer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * RfidcontainerDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/24 16:13:59
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class RfidcontainerDaoImpl implements RfidcontainerDao{

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
		return dataSource.delete("Rfidcontainer.delete", entity);
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
		return dataSource.insert("Rfidcontainer.insert", entity);
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
			for(Rfidcontainer entity : (List<Rfidcontainer>)list){
				//数据批量插入
				Object obj = dataSource.insert("Rfidcontainer.insertBatchs", entity);
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
		return (Integer)dataSource.queryForObject("Rfidcontainer.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Rfidcontainer> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Rfidcontainer>)dataSource.queryForList("Rfidcontainer.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Rfidcontainer searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Rfidcontainer)dataSource.queryForObject("Rfidcontainer.searchByPrimaryKey", entity);
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
		return dataSource.update("Rfidcontainer.update", entity);
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
			for(Rfidcontainer entity : (List<Rfidcontainer>)list){
				//数据批量更新(未指定数据更新为null)
				Object obj = dataSource.update("Rfidcontainer.update", entity);
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
		return dataSource.update("Rfidcontainer.updateNonQuery", entity);
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
			for(Rfidcontainer entity : (List<Rfidcontainer>)list){
				//数据批量更新(未指定数据不更新)
				Object obj = dataSource.update("Rfidcontainer.updateNonQuery", entity);
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
	public int updateDelByRfid(Map<String, Object> map) throws SQLException {
		//开启事务
		dataSource.startTransaction();
		List<Object> listObject = new ArrayList<Object>();
		try{
			for(Rfidcontainer entity : (List<Rfidcontainer>)map){
				//数据批量更新(未指定数据不更新)
				Object obj = dataSource.update("Rfidcontainer.updateNonQuery", entity);
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
	public List<Rfidcontainer> searchToolCodeByRfid(List<String> rfidList) throws SQLException {
		// 按任意查询
		return (List<Rfidcontainer>)dataSource.queryForList("Rfidcontainer.searchByList", rfidList);
	}

	@Override
	public List<Rfidcontainer> searchListByRfids(List<String> rfidlist) throws SQLException {
		// 按任意查询
		return (List<Rfidcontainer>)dataSource.queryForList("Rfidcontainer.searchByList", rfidlist);
	}

	@Override
	public List<Rfidcontainer> searchByList2(Rfidcontainer entity) throws SQLException {
		// 按任意查询
		return (List<Rfidcontainer>)dataSource.queryForList("Rfidcontainer.searchByList2", entity);
	}

	@Override
	public Object insertBatchs(List<Rfidcontainer> rfList) throws SQLException {
		// 数据插入
		return dataSource.insert("Rfidcontainer.insertBatchRfid", rfList);
	}


	@Override
	public List<Rfidcontainer> getRfidCode() throws SQLException {
		// 按任意查询
		return (List<Rfidcontainer>)dataSource.queryForList("Rfidcontainer.searchByList");
	}

	@Override
	public int updateC(Rfidcontainer rff) throws SQLException {
		//开启事务
		dataSource.startTransaction();
		List<Object> listObject = new ArrayList<Object>();
		try{
			for(Rfidcontainer entity : (List<Rfidcontainer>)rff){
				//数据批量更新(未指定数据不更新)
				Object obj = dataSource.update("Rfidcontainer.updateNonQuery", entity);
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


	public int insertBatch(Rfidcontainer r) throws Exception {
		//开启事务
		dataSource.startTransaction();
		List<Object> listObject = new ArrayList<Object>();
		try{
			for(Rfidcontainer entity : (List<Rfidcontainer>)r){
				//数据批量插入
				Object obj = dataSource.insert("Rfidcontainer.insertBatch", entity);
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
	public Object insertBatchRfid(List<Rfidcontainer> list) throws SQLException {
		// 数据插入
		return dataSource.insert("Rfidcontainer.insertBatchRfid", list);
	}

	@Override
	public int updateNonQueryss(Rfidcontainer rff) throws Exception {
		// 数据更新(未指定数据不更新)
		return dataSource.update("Rfidcontainer.update", rff);
	}

	@Override
	public List<Rfidcontainer> getRfidMsg(Rfidcontainer rc) throws SQLException {
		// 按任意查询
		return (List<Rfidcontainer>)dataSource.queryForList("Rfidcontainer.searchByList", rc);
	}

	@Override
	public List<Rfidcontainer> searchListBySamle(Map<String, Object> map) throws SQLException {
		return (List<Rfidcontainer>)dataSource.queryForList("Rfidcontainer.searchListBySamle", map);
	}

	@Override
	public List<Rfidcontainer> searchListBySamle1(List<Rfidcontainer> recodeList) throws SQLException {
		return dataSource.queryForList("Rfidcontainer.searchListBySamle1", recodeList);
	}

	@Override
	public List<Rfidcontainer> checkRFIDType(Rfidcontainer entity) throws SQLException {
		return dataSource.queryForList("Rfidcontainer.checkRFIDType", entity);
	}

	@Override
	public int deleteBatchByRfidCode(Map<String, Object> map) throws SQLException {
		return dataSource.update("Rfidcontainer.deleteBatchByRfidCode", map);
	}

	@Override
	public int deleteBatchByHasRfidCode(Map<String, Object> map) throws SQLException {
		return dataSource.update("Rfidcontainer.deleteBatchByHasRfidCode", map);
	}

	/**
	 * 按激光码进行模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<?> searchByLikeList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Rfidcontainer>)dataSource.queryForList("Rfidcontainer.searchByLikeList", entity);
	}

	@Override
	public int deleteByRfidCodeList(List<String> list) throws SQLException {
		return dataSource.delete ("Rfidcontainer.deleteByRfidCodeList", list);

	}

	@Override
	public List<Rfidcontainer> getRfidInfoByRfid(String rfId) throws SQLException {
		// 按任意查询
		return (List<Rfidcontainer>)dataSource.queryForList("Rfidcontainer.getRfidInfoByRfid", rfId);
	}

}

