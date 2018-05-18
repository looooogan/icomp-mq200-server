/*
 * 工具自动生成：筒刀详细DAO接口
 * 生成时间    : 2017/07/10 15:35:18
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Tubedetailinfo;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface TubedetailinfoDao extends BaseViewDao{
    List<Tubedetailinfo> searchByList(BaseEntity entity) throws SQLException;

    // 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
    List<Tubedetailinfo> searchDetailList(BaseEntity entity) throws SQLException;

    List<Tubedetailinfo> searchTotalList(BaseEntity entity) throws SQLException;
    // 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC

}

