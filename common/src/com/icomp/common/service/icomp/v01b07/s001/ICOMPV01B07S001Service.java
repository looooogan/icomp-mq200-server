package com.icomp.common.service.icomp.v01b07.s001;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Vtransitalarm;
import com.icomp.entity.base.Werkzeugeanforderun;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 在途计划报警查询SERVICE接口
 * @ClassName: ICOMPV01B07S001Service 
 * @author Licc
 * @date 2014-8-20 下午06:10:00
 */
public interface ICOMPV01B07S001Service {
	/**
	 * 在途计划报警查询列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Vtransitalarm entity);

	List<Werkzeugeanforderun> getWerList()throws SQLException;

	int getUpdate(Map<String, Object> werMap);

	Object werkAdd(List<Werkzeugeanforderun> insertList) throws SQLException;

	List<Toolprocured> getToolpro()throws SQLException;

	int getupdateTool(Werkzeugeanforderun werList) throws SQLException;

	Object toolproAdd(Toolprocured toolEntiy)throws SQLException;


	Map<String,Object> getList1(Werkzeugeanforderun entity);

    Map<String,Object> werDelete(Werkzeugeanforderun werkzeugeanforderun);

    Map<String,Object> dbWerforderun(Map<String, Object> param)throws BusinessException;
}
