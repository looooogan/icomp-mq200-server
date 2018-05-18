/*
 * 工具自动生成：RFID载体DAO接口
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Rfidcontainer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 继承父接口
 *
 * @author 工具自动生成
 */
public interface RfidcontainerDao extends BaseDao {
	/**
	 * 根据RFID删除对应的载体
	 *
	 * @param map
	 * @return
	 * @throws SQLException int
	 * @title updateDelByRfid
	 */
	public int updateDelByRfid(Map<String, Object> map) throws SQLException;

	/**
	 * 根据RFID找到toolCode
	 *
	 * @param rfidList
	 * @return
	 * @throws SQLException List<Rfidcontainer>
	 * @title searchToolCodeByRfid
	 */
	public List<Rfidcontainer> searchToolCodeByRfid(List<String> rfidList) throws SQLException;

	/**
	 * 根据RFID找到查询列表
	 * @param rfidlist(rfidCode)
	 * @return
	 */
	public List<Rfidcontainer> searchListByRfids(List<String> rfidlist)throws  SQLException;

	/**
	 * 取得钻头入库的信息
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	List<Rfidcontainer> searchByList2(Rfidcontainer entity)throws SQLException;
	/**
	 * 批量插入rfid载体表
	 * @param rfList
	 * @return
	 * @throws SQLException
	 */
	Object insertBatchs(List<Rfidcontainer> rfList)throws SQLException;

	/**
	 * 取得rfid（安上）
	 * @return
	 * @throws SQLException
	 */
	List<Rfidcontainer> getRfidCode()throws SQLException;

	/**
	 * 回厂入库钻头更新
	 * @param rff
	 * @return
	 * @throws SQLException
	 */
	int updateC(Rfidcontainer rff)throws SQLException;

	int insertBatch(Rfidcontainer r)throws Exception;

	/**
	 * 批量插入RFID载体
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	Object insertBatchRfid(List<Rfidcontainer> list) throws SQLException;

	int updateNonQueryss(Rfidcontainer rff)throws Exception;

	List<Rfidcontainer> getRfidMsg(Rfidcontainer rc)throws SQLException;


	/**
	 * 查询是否有已初始化的数据
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	List<Rfidcontainer> searchListBySamle(Map<String,Object> map)throws SQLException;

	List<Rfidcontainer> searchListBySamle1(List<Rfidcontainer> recodeList)throws SQLException;

	List<Rfidcontainer> checkRFIDType(Rfidcontainer entity) throws SQLException;

	int deleteBatchByRfidCode(Map<String, Object> rfMap) throws SQLException;

	/**
	 * 删除非当前标签的数据
	 * @param rfMap
	 * @throws SQLException
	 */
	int deleteBatchByHasRfidCode(Map<String, Object> rfMap) throws SQLException;

	/**
	 * 按激光码进行模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	public List<?> searchByLikeList(BaseEntity entity) throws SQLException;

	int deleteByRfidCodeList(List<String> list) throws SQLException;

	// 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
	List<Rfidcontainer> getRfidInfoByRfid(String rfId) throws SQLException;
	// 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC
}

