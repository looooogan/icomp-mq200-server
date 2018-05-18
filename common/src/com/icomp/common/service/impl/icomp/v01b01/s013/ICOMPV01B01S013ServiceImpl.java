package com.icomp.common.service.impl.icomp.v01b01.s013;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b01.s013.ICOMPV01B01S013Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.UserdetailDao;
import com.icomp.dao.VinventorystatusDao;
import com.icomp.dao.VtoolsopDao;
import com.icomp.entity.base.Vtoolsop;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存状况查询SERVICE实现类
 * @ClassName: ICOMPV01B01S013ServiceImpl
 * @author Licc
 * @date 2014-11-10 下午03:48:40
 */
public class ICOMPV01B01S013ServiceImpl extends BaseService implements ICOMPV01B01S013Service {

	/**
	 * 库存状况查询DAO
	 */
	private VinventorystatusDao vinventorystatusDao;
	private VtoolsopDao vtoolsopDao;
	private UserdetailDao userdetailDao;
	public VtoolsopDao getVtoolsopDao() {
		return vtoolsopDao;
	}

	public void setUserdetailDao(UserdetailDao userdetailDao) {
		this.userdetailDao = userdetailDao;
	}

	public void setVtoolsopDao(VtoolsopDao vtoolsopDao) {
		this.vtoolsopDao = vtoolsopDao;
	}

	public void setVinventorystatusDao(VinventorystatusDao vinventorystatusDao) {
		this.vinventorystatusDao = vinventorystatusDao;
	}

	@Override
	/**
	 * 库存状况查询列表ToolCode模糊查询
	 */
	public Map<String, Object> getList(Vtoolsop entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<Vtoolsop> list = (List<Vtoolsop>) vtoolsopDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vtoolsop>();
				Vtoolsop toolsop = new Vtoolsop();
				toolsop.setMessageCode(IConstant.EMSG0001);
				toolsop.setRetErrFlag(true);
				list.add(toolsop);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				SimpleDateFormat dateformat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				for (Vtoolsop vtoolsop : list) {
					vtoolsop.setExpandSpace1(String.valueOf(vtoolsop.getToolCode().charAt(0)));


					vtoolsop.setOutInDate(dateformat.format(vtoolsop.getCreateTime()));

//					Userdetail usd=new Userdetail();
//					usd.setCustomerID(vtoolsop.getLibraryUser());
//					List<Userdetail> ls=(List<Userdetail>) userdetailDao.searchByList(usd);
//					if(list.size()==0){
//						vtoolsop.setLibraryUser("-");
//					}
//					else {
//						vtoolsop.setLibraryUser(ls.get(0).getUserName());
//					}
				}

				int total = vtoolsopDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtoolsop> list = new ArrayList<Vtoolsop>();
			Vtoolsop vtoolsop = new Vtoolsop();
			vtoolsop.setMessageCode(IConstant.EMSG0004);
			vtoolsop.setRetErrFlag(true);
			vtoolsop.setExceMessage(e.getMessage());
			list.add(vtoolsop);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 编辑用户信息
	 *
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 * @paramparam
	 */
	public Map<String, Object> sapEdit(Map<String, Object> param, String langCode, String langValue) throws Exception{
		Map<String, Object> rtn = new HashMap<String, Object> ();
		try {

			// 更新失败! 进行数据排他验证
			Vtoolsop entity = new Vtoolsop ();
			entity.setSapID(param.get("DivSapID").toString());
			entity.setStateSt( param.get("DivState").toString());

			int ret = vtoolsopDao.updateNonQuery ( entity );
			rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0005, langCode, langValue ) );
			rtn.put ( "status", IConstant.RESULT_CODE_0 );
			return rtn;
		} catch (SQLException e) {
			Vtoolsop entity = new Vtoolsop ();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode ( IConstant.EMSG0006 );
			entity.setRetErrFlag ( true );
			entity.setExceMessage ( e.getMessage () );
			rtn.put ( "error", entity );
			rtn.put ( "data", null );
			return rtn;

		}

	}
}
