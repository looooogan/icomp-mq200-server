/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/02/25 16:47:09
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Synthesistoolsmachining;
import com.icomp.entity.base.Synthesistoolsmachininginfo;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface SynthesistoolsmachiningDao extends BaseDao{
    /**
     * 
     *
     * @param empty
     * @return List<Synthesistoolsmachining>
     * @throws SQLException
     * @title searchSummaryByTime
     */
    public List<Synthesistoolsmachining> searchSummaryByTime(BaseEntity entity) throws SQLException;

    /**
     * 
     *
     * @param entity
     * @return List<Synthesistoolsmachining>
     * @title searchSummaryCount
     */

    public List<Synthesistoolsmachining> searchSummaryCount(BaseEntity entity) throws SQLException;

    /**
     * 
     *
     * @param list3
     * @throws Exception void
     * @title insertBatchs
     */
    public Object insertBatchs(List<Synthesistoolsmachining> list3) throws Exception;

    @Override
    int updateBatch(List<? extends BaseEntity> list) throws SQLException;

    /**
     * 
     * @param entity
     * @return
     * @throws SQLException
     */
    int searchSumCountByEntity(Synthesistoolsmachining entity) throws SQLException;

    /**
     * 查询换刀记录
     * @param entity
     * @return
     * @throws SQLException
     */
    List<Synthesistoolsmachininginfo> searchListByInfo(Synthesistoolsmachininginfo entity) throws SQLException;

    /**
     * 查询换刀记录数量
     * @param entity
     * @return
     * @throws SQLException
     */
  int searchListByInfoCount(Synthesistoolsmachininginfo entity) throws SQLException;
}

