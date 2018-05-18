/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/08/21 17:07:36
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vanalysisabnormalprocessing;

/**
 * 继承父接口
 * 
 * @author 工具自动生成
 * 
 */
public interface VanalysisabnormalprocessingDao extends BaseViewDao {
/**
 * 加工异常分析统计数量
 * @title getStatisticalCount 
 * @param entity
 * @return
 * @throws SQLException
 * List<Vanalysisabnormalprocessing>
 */
public	List<Vanalysisabnormalprocessing> getStatisticalCount(BaseEntity entity) throws SQLException;
/**
 * 按任意查询-SynthesisParametersCode模糊查询
 * @param entity 查询条件
 * @return 查询结果
 * @throws SQLException
 */
List<Vanalysisabnormalprocessing> searchByList_F(BaseEntity entity)
		throws SQLException;

}
