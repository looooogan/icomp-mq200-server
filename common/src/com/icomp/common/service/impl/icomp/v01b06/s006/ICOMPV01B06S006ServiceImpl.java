package com.icomp.common.service.impl.icomp.v01b06.s006;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s006.ICOMPV01B06S006Service;
import com.icomp.dao.VanalysisabnormalprocessingDao;
import com.icomp.entity.base.Vanalysisabnormalprocessing;
/**
 *  定额执行情况分析SERVICES实现类
 * @ClassName: ICOMPV01B06S006ServiceImpl 
 * @author Taoyy
 * @date 2014-8-20 下午06:19:41
 */

public class ICOMPV01B06S006ServiceImpl extends BaseService implements ICOMPV01B06S006Service {

	/**
	 * 定额执行情况分析DAO
	 */
	private VanalysisabnormalprocessingDao vanalysisabnormalprocessingDao;

	public void setVanalysisabnormalprocessingDao(VanalysisabnormalprocessingDao vanalysisabnormalprocessingDao) {
		this.vanalysisabnormalprocessingDao = vanalysisabnormalprocessingDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getList(Vanalysisabnormalprocessing entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//列表
			List<Vanalysisabnormalprocessing> list = (List<Vanalysisabnormalprocessing>) vanalysisabnormalprocessingDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vanalysisabnormalprocessing>();
				Vanalysisabnormalprocessing vanalysisabnormalprocessing = new Vanalysisabnormalprocessing();
				vanalysisabnormalprocessing.setMessageCode(IConstant.EMSG0001);
				vanalysisabnormalprocessing.setRetErrFlag(true);
				list.add(vanalysisabnormalprocessing);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				//总数量
				int total = vanalysisabnormalprocessingDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vanalysisabnormalprocessing> list = new ArrayList<Vanalysisabnormalprocessing>();
			Vanalysisabnormalprocessing vanalysisabnormalprocessing = new Vanalysisabnormalprocessing();
			vanalysisabnormalprocessing.setMessageCode(IConstant.EMSG0004);
			vanalysisabnormalprocessing.setRetErrFlag(true);
			vanalysisabnormalprocessing.setExceMessage(e.getMessage());
			list.add(vanalysisabnormalprocessing);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}


}
