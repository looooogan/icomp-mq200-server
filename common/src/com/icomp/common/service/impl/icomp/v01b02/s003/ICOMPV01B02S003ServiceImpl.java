package com.icomp.common.service.impl.icomp.v01b02.s003;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b02.s003.ICOMPV01B02S003Service;
import com.icomp.dao.VredemptionappliedDao;
import com.icomp.entity.base.Vredemptionapplied;

public class ICOMPV01B02S003ServiceImpl extends BaseService implements ICOMPV01B02S003Service {


	/**
	 * 换领申请DAO接口
	 */
	private VredemptionappliedDao vredemptionappliedDao;
	
	public void setVredemptionappliedDao(VredemptionappliedDao vredemptionappliedDao) {
		this.vredemptionappliedDao = vredemptionappliedDao;
	}

	/**
	 *  换领申请信息列表
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vredemptionapplied entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vredemptionapplied> list = (List<Vredemptionapplied>) vredemptionappliedDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vredemptionapplied>();
				Vredemptionapplied vredemptionapplied = new Vredemptionapplied();
				vredemptionapplied.setMessageCode(IConstant.EMSG0001);
				vredemptionapplied.setRetErrFlag(true);
				list.add(vredemptionapplied);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vredemptionappliedDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vredemptionapplied> list = new ArrayList<Vredemptionapplied>();
			Vredemptionapplied vredemptionapplied = new Vredemptionapplied();
			vredemptionapplied.setMessageCode(IConstant.EMSG0004);
			vredemptionapplied.setRetErrFlag(true);
			vredemptionapplied.setExceMessage(e.getMessage());
			list.add(vredemptionapplied);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
}
