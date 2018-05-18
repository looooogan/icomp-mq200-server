/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/03/10 14:58:49
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vworkshopsummary;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface VworkshopsummaryDao extends BaseViewDao {
    public List<Vworkshopsummary> searchByList1(BaseEntity entity) throws SQLException;

}

