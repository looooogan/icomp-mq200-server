/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/03/10 15:23:42
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.TooltransferTotal;
import com.icomp.entity.base.Vsynthesiscondition;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface VsynthesisconditionDao extends BaseViewDao {
    public List<Vsynthesiscondition> searchByList1(BaseEntity entity) throws SQLException;
    public List<TooltransferTotal> searchByList2(BaseEntity entity) throws SQLException;
    public List<TooltransferTotal> searchByList3(BaseEntity entity) throws SQLException;
    public int updateTooltransferTotal(TooltransferTotal entity) throws Exception;

}

