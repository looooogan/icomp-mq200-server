/*
 * 工具自动生成：设备DAO接口
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Equipment;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface EquipmentDao extends BaseDao{
	/**
	 * 与合成刀具参数关联查询
	 * 
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Equipment> getEquipmentBySynCode(BaseEntity entity)
			throws SQLException;
	//解绑Rfid
	int updateNonQueryEmpRifd(Equipment entity) throws SQLException;
    int updateNonQueryEmpRifdContainer(Equipment entity) throws SQLException;

	int deleteBatchByRfidCodeList(List<String> list) throws SQLException;
}

