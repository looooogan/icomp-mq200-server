package com.icomp.common.service.impl.icomp.v01b01.s014;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s014.ICOMPV01B01S014Service;
import com.icomp.dao.ToolDao;
import com.icomp.dao.VstockingDao;
import com.icomp.entity.base.Vstocking;
/**
 * 库存盘点查询SERVICE实现类 
 * @ClassName: ICOMPV01B01S014ServiceImpl 
 * @author Licc
 * @date 2014-11-12 下午03:48:40
 */
public class ICOMPV01B01S014ServiceImpl extends BaseService implements ICOMPV01B01S014Service {

	/**
	 * 库存盘点查询DAO
	 */
	private VstockingDao vstockingDao;

	public void setVstockingDao(VstockingDao vstockingDao) {
		this.vstockingDao = vstockingDao;
	}
	private ToolDao toolDao;
	public void setToolDao(ToolDao toolDao) {
		this.toolDao = toolDao;
	}


	@Override
	/**
	 * 库存盘点查询列表-ToolCode模糊查询
	 */
	public Map<String, Object> getList(Vstocking entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<Vstocking> list = (List<Vstocking>) vstockingDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vstocking>();
				Vstocking vstocking = new Vstocking();
				vstocking.setMessageCode(IConstant.EMSG0001);
				vstocking.setRetErrFlag(true);
				list.add(vstocking);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vstockingDao.searchByCount_F(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)/ IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vstocking> list = new ArrayList<Vstocking>();
			Vstocking vstocking = new Vstocking();
			vstocking.setMessageCode(IConstant.EMSG0004);
			vstocking.setRetErrFlag(true);
			vstocking.setExceMessage(e.getMessage());
			list.add(vstocking);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	

}
