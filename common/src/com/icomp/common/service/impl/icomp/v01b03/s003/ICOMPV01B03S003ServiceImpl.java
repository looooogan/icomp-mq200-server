package com.icomp.common.service.impl.icomp.v01b03.s003;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b03.s003.ICOMPV01B03S003Service;
import com.icomp.dao.VtreasuryrepairtoolDao;
import com.icomp.entity.base.Vtreasuryrepairtool;
/**
 * 库房待修复刀具查询SERVICE实现类
 * @ClassName: ICOMPV01B03S003ServiceImpl 
 * @author Taoyy
 * @date 2014-8-20 下午04:16:06
 */
public class ICOMPV01B03S003ServiceImpl extends BaseService implements ICOMPV01B03S003Service {
	/**
	 * 库房待修复刀具查询DAO
	 */
	private VtreasuryrepairtoolDao vtreasuryrepairtoolDao;

	public void setVtreasuryrepairtoolDao(VtreasuryrepairtoolDao vtreasuryrepairtoolDao) {
		this.vtreasuryrepairtoolDao = vtreasuryrepairtoolDao;
	}

	public Map<String, Object> getList(Vtreasuryrepairtool entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//库房待修复刀具查询-ToolCode模糊查询
			List<Vtreasuryrepairtool> list = (List<Vtreasuryrepairtool>) vtreasuryrepairtoolDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vtreasuryrepairtool>();
				Vtreasuryrepairtool vtreasuryrepairtool = new Vtreasuryrepairtool();
				vtreasuryrepairtool.setMessageCode(IConstant.EMSG0001);
				vtreasuryrepairtool.setRetErrFlag(true);
				list.add(vtreasuryrepairtool);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vtreasuryrepairtoolDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtreasuryrepairtool> list = new ArrayList<Vtreasuryrepairtool>();
			Vtreasuryrepairtool vtreasuryrepairtool = new Vtreasuryrepairtool();
			vtreasuryrepairtool.setMessageCode(IConstant.EMSG0004);
			vtreasuryrepairtool.setRetErrFlag(true);
			vtreasuryrepairtool.setExceMessage(e.getMessage());
			list.add(vtreasuryrepairtool);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
}
