/*
 * 工具自动生成：刀具修复通知(需要领取人到库房领取)DAO接口
 * 生成时间    : 2014/08/11 15:35:18
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Toolrepairnotice;

import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface ToolrepairnoticeDao extends BaseDao{
	/**
	 * 修复通知单发布
	 * 批量添加 
	 * @title saveToolRepairNotice 
	 * @param list
	 * @return
	 * @throws Exception
	 * Object
	 */
	public Object saveToolRepairNotice(List<Toolrepairnotice> list)throws Exception;

    /**
     * 取得修复通知单列表
     * @param entity
     * @return
     * @throws Exception
     */
    public List<Toolrepairnotice> searchByListGroupId(Toolrepairnotice entity) throws Exception;

}

