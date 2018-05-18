/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/03/18 14:39:25
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vgetcustomerinfo;

import java.sql.SQLException;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface VgetcustomerinfoDao extends BaseViewDao {

    Vgetcustomerinfo findMemberMsgByCard(Vgetcustomerinfo vgetcustomerinfo) throws SQLException;
}

