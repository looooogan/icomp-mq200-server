/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/12/26 14:30:49
 */
package com.icomp.dao;

import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vtoolplatemessagelist;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VtoolplatemessagelistDao extends BaseViewDao{
/**
 * 取得工具盘列表
 * @title searchAllToolPan 
 * @return
 * @throws Exception
 * List<Vtoolplatemessagelist>
 */
 public	List<Vtoolplatemessagelist> searchAllToolPan()throws Exception;
/**
 * 根据工具盘ID取出空盘的位置号
 * @title searchIsNullByPanId 
 * @param vt
 * @return
 * @throws Exception
 * List<Vtoolplatemessagelist>
 */
public List<Vtoolplatemessagelist> searchIsNullByPanId(Vtoolplatemessagelist vt) throws Exception;
/**
 * 根据刀具入库编码查找对应工具盘
 * @title searchListByStrlist 
 * @param knifeList
 * 刀具入库编码list<String>
 * @return
 * 返回这工具盘id 和工具盘code
 * @throws Exception
 * List<Vtoolplatemessagelist>
 */
public List<Vtoolplatemessagelist> searchListByStrlist(List<String> knifeList) throws Exception;

}

