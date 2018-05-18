package com.icomp.common.service.impl.icomp.v01b03.s007;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b03.s007.ICOMPV01B03S007Service;
import com.icomp.dao.MerchantsDao;
import com.icomp.dao.ToolnoticehistoryDao;
import com.icomp.dao.TubedetailinfoDao;
import com.icomp.dao.VgrindingquicksearchDao;
import com.icomp.entity.base.Merchants;
import com.icomp.entity.base.Tubedetailinfo;
import com.icomp.entity.base.Vgrindingquicksearch;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 筒刀拆装记录查询SERVICES实现类
 * 
 * @ClassName: ICOMPV01B03S007ServiceImpl
 * @author Taoyy
 * @date 2014-8-20 下午04:43:14
 */
public class ICOMPV01B03S007ServiceImpl extends BaseService implements ICOMPV01B03S007Service {

	private MerchantsDao merchantsDao;

	public void setMerchantsDao(MerchantsDao merchantsDao) {
		this.merchantsDao = merchantsDao;
	}

	private TubedetailinfoDao tubedetailinfoDao;

	public void setTubedetailinfoDao(TubedetailinfoDao tubedetailinfoDao) {
		this.tubedetailinfoDao = tubedetailinfoDao;
	}

	/**
	 * 刃磨信息快速查询DAO
	 */
	private VgrindingquicksearchDao vgrindingquicksearchDao;

	public void setVgrindingquicksearchDao(VgrindingquicksearchDao vgrindingquicksearchDao) {
		this.vgrindingquicksearchDao = vgrindingquicksearchDao;
	}

	/**
	 * 刀具修复履历Dao
	 */
	private ToolnoticehistoryDao toolnoticehistoryDao;

	public void setToolnoticehistoryDao(ToolnoticehistoryDao toolnoticehistoryDao) {
		this.toolnoticehistoryDao = toolnoticehistoryDao;
	}

	/**
	 * 加工信息快速查询
	 */
	public Map<String, Object> getList(Vgrindingquicksearch entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<Vgrindingquicksearch> list = (List<Vgrindingquicksearch>) vgrindingquicksearchDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vgrindingquicksearch>();
				Vgrindingquicksearch vgrindingquicksearch = new Vgrindingquicksearch();
				vgrindingquicksearch.setMessageCode(IConstant.EMSG0001);
				vgrindingquicksearch.setRetErrFlag(true);
				list.add(vgrindingquicksearch);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Vgrindingquicksearch vq : list) {
					//约当产量计算
					vq.setResidualValue(getSalvageVal(vq));
				}
				int total = vgrindingquicksearchDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vgrindingquicksearch> list = new ArrayList<Vgrindingquicksearch>();
			Vgrindingquicksearch vgrindingquicksearch = new Vgrindingquicksearch();
			vgrindingquicksearch.setMessageCode(IConstant.EMSG0004);
			vgrindingquicksearch.setRetErrFlag(true);
			vgrindingquicksearch.setExceMessage(e.getMessage());
			list.add(vgrindingquicksearch);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> getlistsMer(Tubedetailinfo entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Tubedetailinfo merchants = null;
		try {
//			List<Merchants> list = (List<Merchants>) merchantsDao.searchByList(entity);

			List<Tubedetailinfo> list = tubedetailinfoDao.searchByList(entity);

			if (list.size() <= 0) {
				list = new ArrayList<Tubedetailinfo>();
				merchants = new Tubedetailinfo();
				merchants.setMessageCode(IConstant.EMSG0001);
				merchants.setRetErrFlag(true);
				list.add(merchants);
				rtn.put("rows", null);
				rtn.put("error", list);
			} else {
				int total = tubedetailinfoDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			List<Tubedetailinfo> list = new ArrayList<Tubedetailinfo>();
			merchants = new Tubedetailinfo();
			merchants.setMessageCode(IConstant.EMSG0004);
			merchants.setRetErrFlag(true);
			merchants.setExceMessage(e.getMessage());
			list.add(merchants);
			rtn.put("rows", null);
			rtn.put("error", list);
		}
		return rtn;
	}

	/**
	 * 约当产量计算
	 * 修复后测量长度*(单价/刀具长度)
	 * @title getSalvageVal 
	 * @param v
	 * @return
	 * String
	 */
	private String getSalvageVal(Vgrindingquicksearch v) {
		DecimalFormat df = new DecimalFormat("#.00");
		Double double1=Double.parseDouble(IConstant.STRING_0);
		if(v.getUnitPrice()!=null){
			double1  =(v.getToolSharpennum().doubleValue()/v.getStandardNum().doubleValue())*v.getUnitPrice().doubleValue();
		}
		return df.format(double1);
	}

	@Override
	public String getMnumber() {
		int total = 0;
		try {
			total= merchantsDao.searchByCount(new Merchants());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(total);
	}

	// 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
	@Override
	public Map<String, Object> getDetailInfo(Tubedetailinfo entity) {
		Map<String, Object> rtn = new HashMap<String, Object> ();
		try {
			List<Tubedetailinfo> list = tubedetailinfoDao.searchDetailList ( entity );
			if (list.size () <= 0) {
				list = new ArrayList<Tubedetailinfo> ();
				Tubedetailinfo detail = new Tubedetailinfo ();
				//消息：检索为0
				detail.setMessageCode ( IConstant.EMSG0001 );
				detail.setRetErrFlag ( true );
				list.add ( detail );
				rtn.put ( "data", null );
				rtn.put ( "error", list );
				return rtn;
			} else {
				rtn.put ( "data", list );
				return rtn;
			}

		} catch (SQLException e) {
			List<Tubedetailinfo> list = new ArrayList<Tubedetailinfo> ();
			Tubedetailinfo detail = new Tubedetailinfo ();
			//错误消息：数据库操作异常，查询失败!
			detail.setMessageCode ( IConstant.EMSG0004 );
			detail.setRetErrFlag ( true );
			detail.setExceMessage ( e.getMessage () );
			list.add ( detail );
			rtn.put ( "data", null );
			rtn.put ( "error", list );
			return rtn;
		}
	}

	@Override
	public Map<String, Object> getTotalInfo(Tubedetailinfo entity) {
		Map<String, Object> rtn = new HashMap<String, Object> ();
		try {
			List<Tubedetailinfo> list = tubedetailinfoDao.searchTotalList ( entity );
			if (list.size () <= 0) {
				list = new ArrayList<Tubedetailinfo> ();
				Tubedetailinfo detail = new Tubedetailinfo ();
				//消息：检索为0
				detail.setMessageCode ( IConstant.EMSG0001 );
				detail.setRetErrFlag ( true );
				list.add ( detail );
				rtn.put ( "data", null );
				rtn.put ( "error", list );
				return rtn;
			} else {
				rtn.put ( "data", list );
				return rtn;
			}

		} catch (SQLException e) {
			List<Tubedetailinfo> list = new ArrayList<Tubedetailinfo> ();
			Tubedetailinfo detail = new Tubedetailinfo ();
			//错误消息：数据库操作异常，查询失败!
			detail.setMessageCode ( IConstant.EMSG0004 );
			detail.setRetErrFlag ( true );
			detail.setExceMessage ( e.getMessage () );
			list.add ( detail );
			rtn.put ( "data", null );
			rtn.put ( "error", list );
			return rtn;
		}
	}
	// 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC

}
