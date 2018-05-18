/*
 * 工具自动生成：合成刀位置DAO接口
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Synthesiscutterlocation;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface SynthesiscutterlocationDao extends BaseDao{
    /**
     * 根据合成刀具id查询刀具编码
     * @param ss
     * @return
     * @throws SQLException
     */
    Synthesiscutterlocation getToolCode(Synthesiscutterlocation ss)throws SQLException;

    List<Synthesiscutterlocation> getSynLocationMsg(Synthesiscutterlocation sc)throws Exception;

    // 2017/09/5 宋健 追加↓↓↓　dazhong@YMSC
    int updateById(BaseEntity entity)throws Exception;
    // 2017/09/5 宋健 追加↑↑↑　dazhong@YMSC

    //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
    List<Synthesiscutterlocation> searchSynthesiscutterlocationBySpCode(String spCode) throws Exception;
    //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
}

