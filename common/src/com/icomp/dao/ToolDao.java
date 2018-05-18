/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/03/07 15:30:07
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Tool;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface ToolDao extends BaseDao{
	/**
	 * 按任意查询

	 * @return 查询结果
	 * @throws SQLException
	 */
	public List<?> searchByToolList() throws SQLException;
	/**
	 * 按任意查询ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Tool> searchByList_F(BaseEntity entity) throws SQLException;

	/**
	 * 查询钻头（刀片）入库的信息
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Tool> searchBitInputInf(Tool entity) throws SQLException;

	/**
	 * 查询容器列表的信息
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Tool> getToolList(Tool entity) throws SQLException;



	/**
	 * 取得要换领出库的刀具信息
	 * @param tl
	 * @return
	 * @throws Exception
	 */
	public List<Tool> getRedemptionapplyInfo(Tool tl) throws SQLException;

	List<Tool> getSynSingesToolList(Tool tt)throws SQLException;

	Tool getToolID(Tool t)throws SQLException;

	Tool getToolCode(Tool t)throws Exception;

	List<Tool> getToolIDByToolCode(Tool t)throws Exception;

	Tool getOldToolMsg(Tool t)throws Exception;

	// 2017/09/8 宋健 追加↓↓↓　dazhong@YMSC
	List<Tool> getToolByToolCode(Tool t)throws Exception;
	// 2017/09/8 宋健 追加↑↑↑　dazhong@YMSC

	// 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
	List<Tool> searchToolInfoBySpcode(String spCode)throws Exception;

	List<Tool> searchBitInputInfo(Tool t)throws Exception;

	// 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC

}

