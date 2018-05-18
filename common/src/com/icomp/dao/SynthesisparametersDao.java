/*
 * 工具自动生成：合成刀具参数DAO接口
 * 生成时间    : 2014/08/11 15:35:18
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Synthesiscutterlocation;
import com.icomp.entity.base.Synthesisparameters;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface SynthesisparametersDao extends BaseDao{
	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	public List<?> searchByLikeList(BaseEntity entity) throws SQLException;
	/**
	 * 按任意查询-SynthesisParametersCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	public List<Synthesisparameters> searchByList_F(Synthesisparameters entity) throws SQLException ;
	/**
	 * 根据载体id查询合成刀具编码
	 * @param spEmtity
	 * @return
	 */
	public Synthesisparameters getSythesisCodeByRfidContainerID(Synthesisparameters entity)throws SQLException ;

	/**
	 * 根据合成刀具编码查询合成刀具ID
	 * @param sp
	 * @return
	 * @throws SQLException
     */
	Synthesisparameters getSynID(Synthesisparameters sp)throws SQLException;

	Synthesisparameters getSynIDByCode(Synthesisparameters sp)throws Exception;

	List<Synthesisparameters> getSysthesCodeByToolCode(Synthesisparameters sp) throws SQLException;

    List<Synthesisparameters> searchByListPoint(Synthesisparameters synthesisparameters)throws SQLException;


}



