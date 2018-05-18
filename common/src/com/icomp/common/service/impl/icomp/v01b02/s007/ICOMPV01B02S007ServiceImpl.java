package com.icomp.common.service.impl.icomp.v01b02.s007;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b02.s007.ICOMPV01B02S007Service;
import com.icomp.dao.VoperationrecordDao;
import com.icomp.entity.base.Voperationrecord;

public class ICOMPV01B02S007ServiceImpl extends BaseService implements ICOMPV01B02S007Service {

	/**
	 * 操作记录DAO接口
	 */
	private VoperationrecordDao voperationrecordDao;
	
	public void setVoperationrecordDao(VoperationrecordDao voperationrecordDao) {
		this.voperationrecordDao = voperationrecordDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(Voperationrecord entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Voperationrecord> list = (List<Voperationrecord>) voperationrecordDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Voperationrecord>();
				Voperationrecord voperationrecord = new Voperationrecord();
				voperationrecord.setMessageCode(IConstant.EMSG0001);
				voperationrecord.setRetErrFlag(true);
				list.add(voperationrecord);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = voperationrecordDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Voperationrecord> list = new ArrayList<Voperationrecord>();
			Voperationrecord voperationrecord = new Voperationrecord();
			voperationrecord.setMessageCode(IConstant.EMSG0004);
			voperationrecord.setRetErrFlag(true);
			voperationrecord.setExceMessage(e.getMessage());
			list.add(voperationrecord);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}


}
