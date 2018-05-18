/*
 * 工具自动生成：DAO实现类
 * 生成时间    : 2016/03/24 16:13:59
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.TooltransferDao;
import com.icomp.entity.base.TooltranarMassage;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.TooltransferTotal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TooltransferDao实现类
 *
 * @author 工具自动生成
 *         生成时间    : 2016/03/24 16:13:59
 *         创建者  ：yzq
 *         更新者  ：taoyy
 */
public class TooltransferDaoImpl implements TooltransferDao {


    /* 数据源 */
    private SqlMapClient dataSource;

    public void setDataSource(SqlMapClient dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 数据删除
     *
     * @param entity 删除数据
     * @return 影响条数
     * @throws SQLException
     */
    @Override
    public int delete(BaseEntity entity) throws SQLException {
        // 数据删除
        return dataSource.delete ( "Tooltransfer.delete", entity );
    }

    /**
     * 数据插入
     *
     * @param entity 插入数据
     * @return 被插入的主键
     * @throws SQLException
     */
    @Override
    public Object insert(BaseEntity entity) throws SQLException {
        // 数据插入
        // 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
//        return dataSource.insert ( "Tooltransfer.insert", entity );
        return dataSource.insert ( "TooltransferTotal.insert", entity );
        // 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC
    }

    /**
     * 数据批量插入
     *
     * @param list 批量插入数据
     * @return 影响条数
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    @Override
    public int insertBatch(List<? extends BaseEntity> list) throws SQLException {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) list) {
                //数据批量插入
                Object obj = dataSource.insert ( "Tooltransfer.insertBatch", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    /**
     * 查询数据条数
     *
     * @param entity 查询条件
     * @return 条数
     * @throws SQLException
     */
    @Override
    public int searchByCount(BaseEntity entity) throws SQLException {
        // 查询数据条数
        return (Integer) dataSource.queryForObject ( "Tooltransfer.searchByCount", entity );
    }

    /**
     * 按任意查询
     *
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Tooltransfer> searchByList(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", entity );
    }

    /**
     * 按主键查询
     *
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    @Override
    public Tooltransfer searchByPrimaryKey(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (Tooltransfer) dataSource.queryForObject ( "Tooltransfer.searchByPrimaryKey", entity );
    }

    /**
     * 数据更新
     *
     * @param entity 更新数据(未指定数据更新为null)
     * @return 影响条数
     * @throws SQLException
     */
    @Override
    public int update(BaseEntity entity) throws SQLException {
        // 数据更新(未指定数据更新为null)
        return dataSource.update ( "Tooltransfer.update", entity );
    }

    /**
     * 数据批量更新
     *
     * @param list 批量数据更新(未指定数据更新为null)
     * @return 影响条数
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    @Override
    public int updateBatch(List<? extends BaseEntity> list) throws SQLException {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) list) {
                //数据批量更新(未指定数据更新为null)
                Object obj = dataSource.update ( "Tooltransfer.update", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    /**
     * 数据更新
     *
     * @param entity 更新数据(未指定数据不更新)
     * @return 影响条数
     * @throws SQLException
     */
    @Override
    public int updateNonQuery(BaseEntity entity) throws SQLException {
        // 数据更新(未指定数据不更新)
        return dataSource.update ( "Tooltransfer.updateNonQuery", entity );
    }

    /**
     * 数据批量更新
     *
     * @param list 批量数据更新(未指定数据不更新)
     * @return 影响条数
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    @Override
    public int updateNonQueryBatch(List<? extends BaseEntity> list) throws SQLException {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) list) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Tooltransfer.updateNonQuery", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    @Override
    public int updateRfidNuber(Map<String, Object> map) throws Exception {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) map) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Tooltransfer.updateNonQuery", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    @Override
    public List<Tooltransfer> searchHalfByList(List<String> rfidList) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", rfidList );
    }

    @Override
    public int updateBatchByRfid(Map<String, Object> map) throws SQLException {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) map) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Tooltransfer.updateNonQuery", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    @Override
    public int updateBatchByOldRfid(Map<String, Object> map) throws Exception {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) map) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Tooltransfer.updateNonQuery", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    @Override
    public int updateContainerByRfid(Map<String, Object> pMap) throws Exception {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) pMap) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Tooltransfer.updateNonQuery", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    @Override
    public int updateBatchDeFlagByRfid(Map<String, Object> map) throws SQLException {
        return dataSource.update ( "Tooltransfer.updateBatchDeFlagByRfid", map );

    }

    @Override
    public int updateDelFlagByRfid(Map<String, Object> map) throws Exception {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) map) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Tooltransfer.updateNonQuery", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    @Override
    public Object insertBatchs(List<Tooltransfer> ttList1) throws SQLException {
        // 数据插入
        return dataSource.insert ( "Tooltransfer.insertBatchs", ttList1 );
    }

    @Override
    public int saveb06s010(Map<String, Object> map) throws SQLException {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) map) {
                //数据批量插入
                Object obj = dataSource.insert ( "Tooltransfer.insert", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    @Override
    public List<Tooltransfer> findCUserByTK(Map<String, Object> map) throws Exception {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", map );
    }

    @Override
    public int delListByCIdAndTKCode(List<Tooltransfer> list) throws Exception {
        // 数据删除
        return dataSource.delete ( "Tooltransfer.delete", list );
    }

    @Override
    public List<Tooltransfer> searchListByKiCodes(List<String> list) throws Exception {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", list );
    }

    @Override
    public int updateStockState(Map<String, Object> map) throws SQLException {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entity : (List<Tooltransfer>) map) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Tooltransfer.updateNonQuery", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    @Override
    public Object getHelpToolCode(String rfidString) throws SQLException {
        // 数据插入
        return dataSource.insert ( "Tooltransfer.insert", rfidString );
    }

    @Override
    public int updateNonQuerySplistBox(Tooltransfer entity) throws SQLException {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Tooltransfer entit : (List<Tooltransfer>) entity) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Tooltransfer.updateNonQuery", entity );
                listObject.add ( obj );
            }
            //提交事务
            dataSource.commitTransaction ();
        } catch (SQLException e) {
            //回滚事务
            dataSource.endTransaction ();
            throw e;
        } finally {
        }
        return listObject.size ();
    }

    @Override
    public List<Tooltransfer> findAllBySynthesRfid(String rfidSynthesisString) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", rfidSynthesisString );
    }

    @Override
    public int updateDateByToolID(Tooltransfer entity) throws SQLException {
        //根据刀具id和载体id,部门状态,limit数量 更新载体和刀具状态为报废
        return dataSource.update ( "Tooltransfer.updateDateByToolID", entity );
    }

    @Override
    public List<TooltranarMassage> getToolCodeAndKivCode(TooltranarMassage entity) throws SQLException {
        // 按任意查询
        return (List<TooltranarMassage>) dataSource.queryForList ( "TooltranarMassage.searchByList", entity );
    }

    @Override
    public List<Tooltransfer> getRegrindingList(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", entity );
    }

    @Override
    public List<Tooltransfer> getToolInfoDetail(Tooltransfer tooltransfer) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", tooltransfer );
    }

    @Override
    public List<TooltranarMassage> getGrindingContarnerByRfid(TooltranarMassage entity) throws SQLException {
        // 按任意查询
        return (List<TooltranarMassage>) dataSource.queryForList ( "TooltranarMassage.searchByList", entity );
    }

    @Override
    public List<Tooltransfer> tooltransferList2(Tooltransfer tooltransfer) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", tooltransfer );
    }

    @Override
    public List<Tooltransfer> getSynSingesToolList(Tooltransfer tt) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", tt );
    }

    @Override
    public Tooltransfer getToolCode(Tooltransfer t) throws Exception {
        // 按任意查询
        return (Tooltransfer) dataSource.queryForList ( "Tooltransfer.searchByList", t );
    }

    @Override
    public List<Tooltransfer> searchByList_F(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", entity );
    }

    public Object insertBatchss(List<Tooltransfer> tt) throws SQLException {
        // 数据插入
        return dataSource.insert ( "Tooltransfer.insertBatchs", tt );
    }

    @Override
    public List<Tooltransfer> getToolMSgBToolID(Tooltransfer t) throws Exception {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", t );
    }

    @Override
    public List<Tooltransfer> getTooltransferMsg(Tooltransfer tf) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList", tf );
    }

    @Override
    public Object updateBatchss(List<Tooltransfer> ttlist) throws SQLException {
        // 数据更新(未指定数据不更新)
        return dataSource.update ( "Tooltransfer.updateNonQuery", ttlist );
    }

    @Override
    public List<Tooltransfer> getRfidConnerIDed(List<String> list) throws SQLException {
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.getRfidConnerIDed", list );
    }

    @Override
    public List<Tooltransfer> getSynthesisknifeToolMsg(Tooltransfer entity) throws SQLException {
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.getSynthesisknifeToolMsg", entity );

    }

    @Override
    public List<Tooltransfer> getToolMsg(Tooltransfer entiry) throws SQLException {
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.getToolMsgTools", entiry );
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<?> searchByList2(BaseEntity entity) throws SQLException {
        // 查询待报废刀具列表信息
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByList2", entity );
    }

    @Override
    public int updateBatchbyttRfidConID(List<String> list) throws SQLException {
        return dataSource.delete ( "Tooltransfer.updateBatchbyttRfidConID", list );
    }

    @Override
    public int updatecontainerCount(Tooltransfer tt) throws SQLException {
        return dataSource.update ( "Tooltransfer.updatecontainerCount", tt );
    }

    @Override
    public int deleteByRfidCodeList(List<String> list) throws SQLException {
        return dataSource.delete ( "Tooltransfer.deleteByRfidCodeList", list );
    }

    @Override
    public List<Tooltransfer> searchByListGrouby(Tooltransfer entity) throws SQLException {
        // 按任意查询
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchByListGrouby", entity );
    }

    @Override
    public int updatStateByRfidConner(Map<String, Object> map) throws SQLException {
        return dataSource.update ( "Tooltransfer.updatStateByRfidConner", map );
    }

    @Override
    public int updateToolStateBatchByRfid(Map<String, Object> map) throws SQLException {
        //按照RFIDcode修改状态
        return dataSource.update ( "Tooltransfer.updateToolStateBatchByRfid", map );
    }

    @Override
    public int updateToolStateBatchByRFIDConnerID(Map<String, Object> map) throws SQLException {
        //修改流转表中的信息为待换装状态
        return dataSource.update ( "Tooltransfer.updateToolStateBatchByRFIDConnerID", map );
    }

    @Override
    public int updateToolStateBatchByRFIDConnerIDAddOne(Map<String, Object> map) throws SQLException {
        //修改流转表中的信息为待换装状态
        return dataSource.update ( "Tooltransfer.updateToolStateBatchByRFIDConnerIDAddOne", map );
    }

    // 2017/08/30 宋健 追加↓↓↓　dazhong@YMSC
    @Override
    public List<TooltransferTotal> getTooltransferTotalByKey(BaseEntity entity) throws SQLException {

        return (List<TooltransferTotal>)dataSource.queryForList("TooltransferTotal.getTooltransferTotalByKey",entity);
    }

    @Override
    public int updateTooltransferTotal(BaseEntity entity) throws SQLException {
        // 数据更新(未指定数据更新为null)
        return dataSource.update ( "TooltransferTotal.update", entity );
    }

    @Override
    public List<TooltransferTotal> searchList(BaseEntity entity) throws SQLException {
        return (List<TooltransferTotal>)dataSource.queryForList("TooltransferTotal.searchList",entity);
    }

    @Override
    public int searchCount(BaseEntity entity) throws SQLException {
        return (Integer)dataSource.queryForObject("TooltransferTotal.searchCount", entity);
    }
    public List<TooltransferTotal> searchList2(BaseEntity entity) throws SQLException {
        return (List<TooltransferTotal>)dataSource.queryForList("TooltransferTotal.searchList2",entity);
    }
    public int searchCount2(BaseEntity entity) throws SQLException {
        return (Integer)dataSource.queryForObject("TooltransferTotal.searchCount2", entity);
    }
    // 2017/08/30 宋健 追加↑↑↑　dazhong@YMSC

    // 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
    @Override
    public List<Tooltransfer> searchTooltransferList(Tooltransfer t) throws SQLException {
        return (List<Tooltransfer>) dataSource.queryForList ( "Tooltransfer.searchTooltransferList", t );
    }

    @Override
    public int updateTooltransferTotalInfo(TooltransferTotal t)  throws SQLException {
        // 数据更新(未指定数据更新为null)
        return dataSource.update ( "TooltransferTotal.updateTooltransferTotalInfo", t );
    }
    // 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC

    // 2017/09/13 宋健 追加↓↓↓　dazhong@YMSC
    @Override
    public int updateNum(TooltransferTotal t) throws SQLException {
        // 数据更新(未指定数据更新为null)
        return dataSource.update ( "TooltransferTotal.updateNum", t );
    }
    // 2017/09/13 宋健 追加↑↑↑　dazhong@YMSC
}