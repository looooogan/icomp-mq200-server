/*
 * 工具自动生成：换领申请DAO接口
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Redemptionapplied;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface RedemptionappliedDao extends BaseDao{

	Object saveApplyInfoBatch(List<Redemptionapplied> list)throws Exception;
	/**
	 * 取得换领申请单
	 * @title getRedemptionInfo 
	 * @param list
	 * @return
	 * List<Redemptionapplied>
	 */
	public	List<Redemptionapplied> getRedemptionInfo(List<String> list)throws Exception;
	/**
	 * 更新换领申请表为已换领
	 * @title updateBatchById 
	 * @param list
	 * @return
	 * @throws Exception
	 * int
	 */
	int updateBatchById(List<Redemptionapplied> list)throws Exception;
	/**
	 * 更新换领申请状态
	 * @title updateBatchStateByRfid 
	 * @param mapParam
	 * @return
	 * int
	 */
	public int updateBatchStateByRfid(Map<String, Object> map) throws Exception;
	/**
	 * 更新换领申请状态(not in)
	 * @title updateBatchNotStateByRfid 
	 * @param mapParam
	 * @return
	 * @throws Exception
	 * int
	 */
	public int updateBatchNotStateByRfid(Map<String, Object> mapParam)throws Exception;
	/**
	 *  取得换领申请单
	 * @title searchListById 
	 * @param entity
	 * @return
	 * @throws Exception
	 * List<Redemptionapplied>
	 */
	public List<Redemptionapplied> searchListById(Redemptionapplied entity)throws Exception;
	/**
	 * 更新换领申请表为实际送回数量
	 * @title updateUnBackById 
	 * @param listThree
	 * @return
	 * @throws Exception
	 * int
	 */
	public int updateUnBackById(List<Redemptionapplied> list)throws Exception;
	/**
	 * 根据申请单号的刀具编码修改实际送回数量
	 * @title updateReceiveByIdAndToolCode 
	 * @param reList
	 * @return
	 * @throws Exception
	 * int
	 */
	public int updateReceiveByIdAndToolCode(List<Redemptionapplied> list)throws Exception;
	public int updateBatchNotStateByState(Map<String, Object> map)throws Exception;
	/**
	 * 按任意条件修改任意属性
	 * @title updateByAnything 
	 * @param redemptionapplied 
	 * @param 条件  xxxWhere 
	 * @param 要修改的属性  xxx 
	 * @return 
	 * int
	 */
	public int updateByAnything(Redemptionapplied redemptionapplied)throws Exception;

    int updateByAnythingFour(Redemptionapplied redemptionapplied) throws SQLException;

    /**
     *  取得换领申请单列表按照人名和日期进行排序并显示在list中
     * @return
     * @throws SQLException
     */
   public   List<Redemptionapplied>  getRequestList()throws  SQLException;

    public int updateRfidNullByAnything(Redemptionapplied entity)throws  SQLException;

    /**
     * 取得已备货的刀具信息
     * @return
     * @throws SQLException
     */
    List<Redemptionapplied> getReadiedToolsMessage() throws SQLException;
	/**
	 * 非单品-获取申请人
	 */
	List<Redemptionapplied> getApplyUser(BaseEntity entity) throws SQLException;
	/**
	 * 非单品-获取换领出库申请单
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	List<Redemptionapplied> getRedemptionappliedListCodeByUserid(
			BaseEntity entity) throws SQLException;
	/**
	 * 非单品-查询未完全出库的换领单
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	List<Redemptionapplied> searchByList_Redemption(BaseEntity entity)
			throws SQLException;
	
    /**
     *  取得换领申请人申请信息
     * @param entity 
     * @return
     * @throws SQLException
     */
   public   List<Redemptionapplied>  getApplyInfo(Redemptionapplied entity) throws  SQLException;
}

