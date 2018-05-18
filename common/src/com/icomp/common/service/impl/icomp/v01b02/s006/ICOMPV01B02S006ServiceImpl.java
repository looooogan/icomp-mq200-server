package com.icomp.common.service.impl.icomp.v01b02.s006;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b02.s006.ICOMPV01B02S006Service;
import com.icomp.dao.SynthesisknifeDao;
import com.icomp.entity.base.Synthesisknife;

public class ICOMPV01B02S006ServiceImpl extends BaseService implements ICOMPV01B02S006Service {


	/**
	 * 快速查询DAO接口
	 */
	private SynthesisknifeDao synthesisknifeDao;
	
	public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
		this.synthesisknifeDao = synthesisknifeDao;
	}
	
	/**
	 *  快速查询列表-SynthesisParametersCode模糊查询
	 */
	public Map<String, Object> getList(Synthesisknife entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//SynthesisParametersCode模糊查询
			List<Synthesisknife> list = (List<Synthesisknife>) synthesisknifeDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Synthesisknife>();
				Synthesisknife synthesisknife = new Synthesisknife();
				synthesisknife.setMessageCode(IConstant.EMSG0001);
				synthesisknife.setRetErrFlag(true);
				list.add(synthesisknife);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = synthesisknifeDao.searchByCount_F(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Synthesisknife> list = new ArrayList<Synthesisknife>();
			Synthesisknife synthesisknife = new Synthesisknife();
			synthesisknife.setMessageCode(IConstant.EMSG0004);
			synthesisknife.setRetErrFlag(true);
			synthesisknife.setExceMessage(e.getMessage());
			list.add(synthesisknife);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
}
