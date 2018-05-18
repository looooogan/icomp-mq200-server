package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.SubToolProcessAmountDao;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.SubToolProcessAmount;

public class SubToolProcessAmountDaoImpl implements SubToolProcessAmountDao{
	
	/* 数据源 */
	private SqlMapClient dataSource;
	public void setDataSource(SqlMapClient dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public int delete(BaseEntity entity) throws SQLException {
		return 0;
	}

	@Override
	public Object insert(BaseEntity entity) throws SQLException {
		return null;
	}



	@Override
	public int searchByCount(BaseEntity entity) throws SQLException {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubToolProcessAmount> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<SubToolProcessAmount>)dataSource.queryForList("SubToolProcessAmount.searchByList", entity);
	}

	@Override
	public BaseEntity searchByPrimaryKey(BaseEntity entity) throws SQLException {
		return null;
	}

	@Override
	public int update(BaseEntity entity) throws SQLException {
		return 0;
	}

	@Override
	public int updateBatch(List<? extends BaseEntity> list) throws SQLException {
		return 0;
	}

	@Override
	public int updateNonQuery(BaseEntity entity) throws SQLException {
		return 0;
	}

	@Override
	public int updateNonQueryBatch(List<? extends BaseEntity> list)
			throws SQLException {
		return 0;
	}

	@Override
	public int insertBatch(List<? extends BaseEntity> list) throws SQLException {
		return 0;
	}

}
