/*
 * 工具自动生成：库位码DAO接口
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Librarycode;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface LibrarycodeDao extends BaseDao{

	List<Librarycode> vsearchByList(BaseEntity entity) throws SQLException;

}

