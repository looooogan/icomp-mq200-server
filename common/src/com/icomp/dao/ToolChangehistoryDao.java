/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/11/13 14:08:26
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.ToolChangehistory;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface ToolChangehistoryDao{
    /**
     * 按任意查询--ToolCode模糊查询
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    List<ToolChangehistory> searchByList2(ToolChangehistory entity) throws SQLException;


    int searchByCount2(ToolChangehistory entity) throws SQLException;

}

