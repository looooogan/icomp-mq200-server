/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/02/15 18:57:18
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vknid123;
import com.icomp.entity.base.Vknifeinventory;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface Vknid123Dao extends BaseViewDao {
    /**
     * 按任意查询-ToolCode模糊查询
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */

   List<Vknid123> searchByList(BaseEntity entity) throws SQLException;
}

