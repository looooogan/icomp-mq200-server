package com.icomp.common.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetassequipmentlistDao;
import com.icomp.entity.base.Vgetassequipmentlist;


public interface BaseViewDao {

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


}
