/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/05/30 11:21:40
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vcostamortization;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface VcostamortizationDao extends BaseViewDao {
     List<Vcostamortization> searchByLists(BaseEntity entity) throws SQLException;
     List<Vcostamortization> searchByLists2(BaseEntity entity) throws SQLException;
     int searchByCount2(BaseEntity entity) throws SQLException;

}

