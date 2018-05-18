/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/03/03 10:24:38
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Oplink;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface OplinkDao extends BaseDao{

	/**
	 * 根据ID查询零部件列表
	 * @param oplink
	 * @return
	 * @throws SQLException
	 */
	List<Oplink> getPartsList(Oplink oplink)throws SQLException;

	Oplink getOplinkInfo(Oplink entity)throws Exception;

	List<Oplink> searchByListWhere(Oplink oplink) throws  SQLException;

	List<Oplink> searchSyn(Oplink oplink) throws  SQLException;

	Object insertBatchs(List<Oplink> listop) throws SQLException;


	//2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
	List<Oplink> searchOplinkList(Oplink oplink) throws  SQLException;
	//2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
}

