package com.icomp.common.service.impl.icomp.v01b02.s004;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b02.s004.ICOMPV01B02S004Service;
import com.icomp.dao.VtoolsettingDao;
import com.icomp.entity.base.Vtoolsetting;

public class ICOMPV01B02S004ServiceImpl extends BaseService implements ICOMPV01B02S004Service {


	/**
	 * 对刀记录DAO接口
	 */
	private VtoolsettingDao vtoolsettingDao;

	public void setVtoolsettingDao(VtoolsettingDao vtoolsettingDao) {
		this.vtoolsettingDao = vtoolsettingDao;
	}

	/**
	 *  对刀记录列表-SynthesisParametersCode模糊查询
	 */
	public Map<String, Object> getList(Vtoolsetting entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//SynthesisParametersCode模糊查询
			List<Vtoolsetting> list = (List<Vtoolsetting>) vtoolsettingDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vtoolsetting>();
				Vtoolsetting vtoolsetting = new Vtoolsetting();
				vtoolsetting.setMessageCode(IConstant.EMSG0001);
				vtoolsetting.setRetErrFlag(true);
				list.add(vtoolsetting);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vtoolsettingDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtoolsetting> list = new ArrayList<Vtoolsetting>();
			Vtoolsetting vtoolsetting = new Vtoolsetting();
			vtoolsetting.setMessageCode(IConstant.EMSG0004);
			vtoolsetting.setRetErrFlag(true);
			vtoolsetting.setExceMessage(e.getMessage());
			list.add(vtoolsetting);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
}
