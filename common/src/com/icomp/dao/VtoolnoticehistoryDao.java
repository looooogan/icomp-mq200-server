/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/02/25 15:44:05
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vtoolnoticehistory;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface VtoolnoticehistoryDao extends BaseViewDao {
    List<Vtoolnoticehistory> searchByList(BaseEntity entity) throws SQLException;

}

