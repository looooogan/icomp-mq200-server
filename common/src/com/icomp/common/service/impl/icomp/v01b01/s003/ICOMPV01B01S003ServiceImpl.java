package com.icomp.common.service.impl.icomp.v01b01.s003;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s003.ICOMPV01B01S003Service;
import com.icomp.dao.VprocessingtoolsDao;
import com.icomp.entity.base.Vprocessingtools;
/**
 * 待处理刀具信息查询SERVICE实现
 * @ClassName: ICOMPV01B01S003ServiceImpl 
 * @author Taoyy
 * @date 2014-8-19 下午04:32:46
 */
public class ICOMPV01B01S003ServiceImpl extends BaseService implements ICOMPV01B01S003Service {

private VprocessingtoolsDao vprocessingtoolsDao;
	public void setVprocessingtoolsDao(VprocessingtoolsDao vprocessingtoolsDao) {
	this.vprocessingtoolsDao = vprocessingtoolsDao;
}


	@Override
	/**
	 * 待处理刀具信息查询列表-ToolCode模糊查询
	 */
	public Map<String, Object> getList(Vprocessingtools entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<Vprocessingtools> list = (List<Vprocessingtools>) vprocessingtoolsDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vprocessingtools>();
				Vprocessingtools vprocessingtools = new Vprocessingtools();
				vprocessingtools.setMessageCode(IConstant.EMSG0001);
				vprocessingtools.setRetErrFlag(true);
				list.add(vprocessingtools);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vprocessingtoolsDao.searchByCount_F(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vprocessingtools> list = new ArrayList<Vprocessingtools>();
			Vprocessingtools vprocessingtools = new Vprocessingtools();
			vprocessingtools.setMessageCode(IConstant.EMSG0004);
			vprocessingtools.setRetErrFlag(true);
			vprocessingtools.setExceMessage(e.getMessage());
			list.add(vprocessingtools);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
}
