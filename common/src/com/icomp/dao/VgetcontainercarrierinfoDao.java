/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/03/08 10:20:54
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vgetcontainercarrierinfo;

import java.util.List;

/**
 * 继承父接口
 *
 * @author 工具自动生成
 *         创建者  ：yzq
 *         更新者  ：taoyy
 */
public interface VgetcontainercarrierinfoDao extends BaseViewDao {

    Vgetcontainercarrierinfo getcontainercarrierinfo(Vgetcontainercarrierinfo r) throws Exception;

    List<Vgetcontainercarrierinfo> searchByListGroud(Vgetcontainercarrierinfo vv) throws Exception;
}

