/*
 * 工具自动生成：合成刀库DAO实现类
 * 生成时间    : 2016/03/24 16:13:59
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.SynthesisknifeDao;
import com.icomp.entity.base.Synthesisknife;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SynthesisknifeDao实现类
 *
 * @author 工具自动生成
 *         生成时间    : 2016/03/24 16:13:59
 *         创建者  ：yzq
 *         更新者  ：taoyy
 */
public class SynthesisknifeDaoImpl implements SynthesisknifeDao {

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
        return dataSource.delete ( "Synthesisknife.delete", entity );
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
        return dataSource.insert ( "Synthesisknife.insert", entity );
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
            for (Synthesisknife entity : (List<Synthesisknife>) list) {
                //数据批量插入
                Object obj = dataSource.insert ( "Synthesisknife.insert", entity );
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
        // 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
        // 查询数据条数
        return (Integer) dataSource.queryForObject ( "Synthesisknife.searchByCount", entity );
        // 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC
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
    public List<Synthesisknife> searchByList(BaseEntity entity) throws SQLException {
        // 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
        // 2017/09/18 王冉 变更↓↓↓　dazhong@YMSC
        // 按任意查询
        return (List<Synthesisknife>) dataSource.queryForList ( "Synthesisknife.searchByList", entity );
        // 2017/09/18 王冉 变更↑↑↑　dazhong@YMSC
        // 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC
    }

    /**
     * 按主键查询
     *
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    @Override
    public Synthesisknife searchByPrimaryKey(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (Synthesisknife) dataSource.queryForObject ( "Synthesisknife.searchByPrimaryKey", entity );
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
        return dataSource.update ( "Synthesisknife.update", entity );
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
            for (Synthesisknife entity : (List<Synthesisknife>) list) {
                //数据批量更新(未指定数据更新为null)
                Object obj = dataSource.update ( "Synthesisknife.update", entity );
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
        return dataSource.update ( "Synthesisknife.updateNonQuery", entity );
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
            for (Synthesisknife entity : (List<Synthesisknife>) list) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Synthesisknife.updateNonQuery", entity );
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
    public int updateBatchs(List<Synthesisknife> list) throws Exception {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Synthesisknife entity : (List<Synthesisknife>) list) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Synthesisknife.updateNonQuery", entity );
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
    public int updateBatchByRfid(Map<String, Object> map) throws Exception {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Synthesisknife entity : (List<Synthesisknife>) map) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Synthesisknife.updateNonQuery", entity );
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
    public List<Synthesisknife> searchListByRfid(Synthesisknife sk) throws Exception {
        // 按任意查询
        return (List<Synthesisknife>) dataSource.queryForList ( "Synthesisknife.searchListByRfid", sk );
    }

    @Override
    public List<Synthesisknife> findskListByRfid(String rfidString) throws Exception {
        // 按任意查询
        return (List<Synthesisknife>) dataSource.queryForList ( "Synthesisknife.searchByList", rfidString );
    }

    @Override
    public int updateListbyCode(HashMap<String, Object> map) throws Exception {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Synthesisknife entity : (List<Synthesisknife>) map) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Synthesisknife.updateNonQuery", entity );
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
    public List<Synthesisknife> searchByList_F(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (List<Synthesisknife>) dataSource.queryForList ( "Synthesisknife.searchByList", entity );
    }

    @Override
    public int updateBatchDeFlagByRfid(Map<String, Object> map) throws SQLException {
        //开启事务
        dataSource.startTransaction ();
        List<Object> listObject = new ArrayList<Object> ();
        try {
            for (Synthesisknife entity : (List<Synthesisknife>) map) {
                //数据批量更新(未指定数据不更新)
                Object obj = dataSource.update ( "Synthesisknife.updateNonQuery", entity );
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
    public List<Synthesisknife> findskListByRfidList(List<String> list) throws SQLException {
        // 按任意查询
        return (List<Synthesisknife>) dataSource.queryForList ( "Synthesisknife.findskListByRfidList", list );
    }

    @Override
    public int searchByCount_F(BaseEntity entity) throws SQLException {
        // 查询数据条数
        return (Integer) dataSource.queryForObject ( "Synthesisknife.searchByCount", entity );
    }

    @Override
    public Synthesisknife getSynthesisknife(Synthesisknife entity) throws SQLException {
        // 按任意查询
        return (Synthesisknife) dataSource.queryForObject ( "Synthesisknife.getSynthesisknife", entity );
    }

    @Override
    public Synthesisknife getSynParameNumber(Synthesisknife sk) throws Exception {
        // 按任意查询
        return (Synthesisknife) dataSource.queryForObject ( "Synthesisknife.searchByPrimaryKey", sk );
    }

    @Override
    public Synthesisknife getSynthesisknifebyRfidc(Synthesisknife skEntity) throws Exception {
        // 按任意查询
        return (Synthesisknife) dataSource.queryForObject ( "Synthesisknife.getSynthesisknifebyRfidc", skEntity );
    }

    @Override
    public Object insertBatchs(List<Synthesisknife> list) throws Exception {
        // 数据插入
        return dataSource.insert ( "Synthesisknife.insertBatchs", list );
    }

    /**
     * @param skn
     * @return
     * @throws Exception
     */
    @Override
    public Synthesisknife getSynthesisParametersNumberMAX(Synthesisknife skn) throws Exception {
        // 按任意查询
        return (Synthesisknife) dataSource.queryForObject ( "Synthesisknife.getSynthesisParametersNumberMAX", skn );
    }

    @Override
    public Synthesisknife getSynCodeByRfidConner(Synthesisknife skentity) throws Exception {
        // 按任意查询
        return (Synthesisknife) dataSource.queryForObject ( "Synthesisknife.getSynCodeByRfidConner", skentity );
    }

    @Override
    public Object submitInitSynthesis(List<Synthesisknife> sk) throws Exception {
        // 数据插入
        return dataSource.insert ( "Synthesisknife.insertBatch", sk );
    }

    @Override
    public Synthesisknife searchBySynthesisknife(Synthesisknife entity) throws Exception {
        return (Synthesisknife) dataSource.queryForObject ( "Synthesisknife.searchBySynthesisknife", entity );
    }

    @Override
    public int deleteBatchByRfidCodeList(List<String> list) throws SQLException {
        // 2017/11/01 王冉 变更↓↓↓　dazhong@YMSC
        return dataSource.delete ( "Synthesisknife.deleteByRfidCodeList", list );
        // 2017/11/01 王冉 变更↑↑↑　dazhong@YMSC
    }

    // 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
    @Override
    public Synthesisknife searchSyn(Synthesisknife entity) throws Exception {
        return (Synthesisknife) dataSource.queryForObject ( "Synthesisknife.searchSyn", entity );
    }
    // 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC

    // 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
    @Override
    public List<Synthesisknife> searchSynthesisknifeList(BaseEntity entity) throws SQLException {
        return (List<Synthesisknife>) dataSource.queryForList ( "Synthesisknife.searchSynthesisknifeList", entity );
    }

    @Override
    public int searchSynthesisknifeListByCount(BaseEntity entity) throws SQLException {
        return (Integer) dataSource.queryForObject ( "Synthesisknife.searchSynthesisknifeListByCount", entity );
    }
    // 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC

}

