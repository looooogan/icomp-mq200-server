/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/12/08 10:06:15
 */
package com.icomp.dao;

import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vgetrenewalapplication_New;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface Vgetrenewalapplication_NewDao extends BaseViewDao{
	/**
	 * 热套刀具申请 
	 * @title searchHotByList 
	 * @param vnNew
	 * @param 合成刀具编码
	 * @param 合成刀具编号（001，002，003。。。）
	 * @return
	 * @throws Exception
	 * List<Vgetrenewalapplication_New>
	 */
public	List<Vgetrenewalapplication_New> searchHotByList(Vgetrenewalapplication_New vnNew)throws Exception;

}

