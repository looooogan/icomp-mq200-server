/*
 * 工具自动生成：申领申请DAO接口
 * 生成时间    : 2016/03/17 19:24:17
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Redemptionapplied;
import com.icomp.entity.base.Replacement;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface ReplacementDao extends BaseDao{

	List<Replacement> searchByListWithUSername(BaseEntity entity)
			throws SQLException;

	int searchByCountWithUSername(BaseEntity entity) throws SQLException;

	 /**
     *  取得补领出库申请列表
     * @param entity
     * @return
     * @throws SQLException
     */
   public   List<Replacement>  getReplacementList(Replacement entity) throws  SQLException;

	 /**
    *  取得补领出库申请单信息
    * @param entity
    * @return
    * @throws SQLException
    */
  public   List<Replacement>  getReplacementApply(Replacement entity) throws  SQLException;
  public   List<Replacement>  getReplacementApplyElse(Replacement entity) throws  SQLException;
	List<Replacement> getsearchByPrimaryKey_Code(Replacement entity) throws  SQLException;

}

