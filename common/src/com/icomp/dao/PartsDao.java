/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/03/03 16:41:44
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Parts;

import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface PartsDao extends BaseDao {
    /**
     * 根据ID查询零部件列表
     * @param p
     * @return
     * @throws Exception
     */
    List<Parts> getPartsList(Parts p)throws Exception;

    List<Parts> searchListByName(Parts p) throws Exception;

    List<Parts> searchListById(String id) throws Exception;
}

