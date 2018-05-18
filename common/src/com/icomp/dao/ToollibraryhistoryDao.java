/*
 * 工具自动生成：刀具出库履历DAO接口
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.dao;

import java.util.List;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Toollibraryhistory;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface ToollibraryhistoryDao extends BaseDao{
	/**
	 * 批量添加出库履历  
	 * @title insertBatchs 
	 * @param tlhList
	 * @return
	 * @throws Exception
	 * Object
	 */
	Object  insertBatchs(List<Toollibraryhistory> tlhList)throws Exception;

}

