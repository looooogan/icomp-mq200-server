package com.icomp.common.service.impl.icomp.v01b01.s006;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s006.ICOMPV01B01S006Service;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.VreplacesynthesisDao;
import com.icomp.entity.base.Vreplacesynthesis;
/**
 * 更替刀具库存查询SERVICE实现类
 * @ClassName: ICOMPV01B01S006ServiceImpl 
 * @author Taoyy
 * @date 2014-8-15 上午11:00:34
 */
public class ICOMPV01B01S006ServiceImpl extends BaseService implements ICOMPV01B01S006Service {

	/**
	 * 系统显示项目配置(兼顾打印项目)
	 */
	@SuppressWarnings("unused")
	private DisplayeditemconfigurationDao displayeditemconfigurationDao;

	public void setDisplayeditemconfigurationDao(
			DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}

	/**
	 * 更替刀具库存查询Dao
	 */
	private VreplacesynthesisDao vreplacesynthesisDao;
	public void setVreplacesynthesisDao(VreplacesynthesisDao vreplacesynthesisDao) {
		this.vreplacesynthesisDao = vreplacesynthesisDao;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(Vreplacesynthesis entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//SynthesisParametersCode模糊查询
			List<Vreplacesynthesis> list = (List<Vreplacesynthesis>) vreplacesynthesisDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vreplacesynthesis>();
				Vreplacesynthesis vreplacesynthesis = new Vreplacesynthesis();
				vreplacesynthesis.setMessageCode(IConstant.EMSG0001);
				vreplacesynthesis.setRetErrFlag(true);
				list.add(vreplacesynthesis);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vreplacesynthesisDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vreplacesynthesis> list = new ArrayList<Vreplacesynthesis>();
			Vreplacesynthesis vreplacesynthesis = new Vreplacesynthesis();
			vreplacesynthesis.setMessageCode(IConstant.EMSG0004);
			vreplacesynthesis.setRetErrFlag(true);
			vreplacesynthesis.setExceMessage(e.getMessage());
			list.add(vreplacesynthesis);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
}
