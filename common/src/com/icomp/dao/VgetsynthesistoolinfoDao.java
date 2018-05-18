/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/09/25 17:52:02
 */
package com.icomp.dao;

import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vgetsynthesistoolinfo;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VgetsynthesistoolinfoDao extends BaseViewDao{
	/**
	 * 刀具装盒
	 * @title saveToolBox 
	 * @param list
	 * @return
	 * int
	 */
	public int saveToolBox(List<Vgetsynthesistoolinfo> list)throws Exception;
	/**
	 * 刀具装盘
	 * @title saveToolPlate 
	 * @param list
	 * @return
	 * int
	 */
	public int saveToolPlate(List<Vgetsynthesistoolinfo> list)throws Exception;

}

