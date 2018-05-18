/*
 * 工具自动生成：加工履历（在刀具安上设备上需要记录当前合成刀与刀具的绑定关系）DAO接口
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.dao;

import java.util.List;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Machiningexperience;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface MachiningexperienceDao extends BaseDao{

   public Object insertBatchs(List<Machiningexperience> meList)throws Exception;

}

