package com.icomp.common.service.impl.icomp.v01b02.s001;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b02.s001.ICOMPV01B02S001Service;
import com.icomp.dao.VsynthesisexperienceDao;
import com.icomp.entity.base.Vsynthesisexperience;
/**
 * 待处理刀具信息查询SERVICE实现
 * @ClassName: ICOMPV01B02S001ServiceImpl 
 * @author Cyn
 * @date 2014-10-24 下午04:32:46
 */
public class ICOMPV01B02S001ServiceImpl extends BaseService implements ICOMPV01B02S001Service {

	private VsynthesisexperienceDao vsynthesisexperienceDao;

	public void setVsynthesisexperienceDao(VsynthesisexperienceDao vsynthesisexperienceDao) {
	this.vsynthesisexperienceDao = vsynthesisexperienceDao;
	}




	@Override
	/**
	 * 待处理刀具信息查询列表-SynthesisParametersCode模糊查询
	 */
	public Map<String, Object> getList(Vsynthesisexperience entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vsynthesisexperience> list = (List<Vsynthesisexperience>) vsynthesisexperienceDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vsynthesisexperience>();
				Vsynthesisexperience entityRtn = new Vsynthesisexperience();
				entityRtn.setMessageCode(IConstant.EMSG0001);
				entityRtn.setRetErrFlag(true);
				list.add(entityRtn);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vsynthesisexperienceDao.searchByCount_F(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vsynthesisexperience> list = new ArrayList<Vsynthesisexperience>();
			Vsynthesisexperience entityRtn = new Vsynthesisexperience();
			entityRtn.setMessageCode(IConstant.EMSG0004);
			entityRtn.setRetErrFlag(true);
			entityRtn.setExceMessage(e.getMessage());
			list.add(entityRtn);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
}
