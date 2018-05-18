package com.icomp.common.service.impl.icomp.v01b07.s006;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b07.s006.ICOMPV01B07S006Service;
import com.icomp.dao.VtoolprocuredDao;
import com.icomp.entity.base.Vtoolprocured;
/**
 * 工作记录SERVICE实现类
 * @ClassName: ICOMPV01B07S006ServiceImpl 
 * @author Licc
 * @date 2014-8-21 下午04:20:08
 */
public class ICOMPV01B07S006ServiceImpl extends BaseService implements ICOMPV01B07S006Service {

	/**
	 * 工作记录DAO
	 */
    private VtoolprocuredDao vtoolprocuredDao;

	public void setVtoolprocuredDao(VtoolprocuredDao vtoolprocuredDao) {
		this.vtoolprocuredDao = vtoolprocuredDao;
	}

	/**
	 * 工作记录列表
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vtoolprocured entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vtoolprocured> list = (List<Vtoolprocured>) vtoolprocuredDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vtoolprocured>();
				Vtoolprocured vtoolprocured = new Vtoolprocured();
				//消息：检索为0
				vtoolprocured.setMessageCode(IConstant.EMSG0001);
				vtoolprocured.setRetErrFlag(true);
				list.add(vtoolprocured);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vtoolprocuredDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtoolprocured> list = new ArrayList<Vtoolprocured>();
			Vtoolprocured vtoolprocured = new Vtoolprocured();
			//错误消息：数据库操作异常，查询失败!
			vtoolprocured.setMessageCode(IConstant.EMSG0004);
			vtoolprocured.setRetErrFlag(true);
			vtoolprocured.setExceMessage(e.getMessage());
			list.add(vtoolprocured);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
}
