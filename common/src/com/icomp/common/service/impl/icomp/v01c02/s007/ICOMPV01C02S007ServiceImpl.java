package com.icomp.common.service.impl.icomp.v01c02.s007;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c02.s007.ICOMPV01C02S007Service;
import com.icomp.dao.LanguagetableDao;
import com.icomp.entity.base.Languagetable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ICOMPV01C02S007ServiceImpl  extends BaseService implements ICOMPV01C02S007Service{

	/* 语言dao */
	private LanguagetableDao languagetableDao;
	public void setLanguagetableDao(LanguagetableDao languagetableDao) {
		this.languagetableDao = languagetableDao;
	}
	/**
	 * 获取系统支持的语言列表
	 * @param
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Languagetable> getLangageList(Languagetable entity){
		try {
             //entity.setDelFlag(IConstant.DEL_FLAG_0);
			List<Languagetable> list = (List<Languagetable>)languagetableDao.searchByList(entity);
			if(list == null || list.size() <= 0){
				//系统支持的语言未找到相应数据!
				list = new ArrayList<Languagetable>();
				Languagetable language = new Languagetable();
				language.setMessageCode(IConstant.WMSG0156);
				language.setRetErrFlag(true);
				list.add(language);
				return list;
			}else{
				return list;
			}
			
		} catch (SQLException e) {
			List<Languagetable> list = new ArrayList<Languagetable>();
			Languagetable language = new Languagetable();
			language.setMessageCode(IConstant.EMSG0004);
			language.setRetErrFlag(true);
			language.setExceMessage(e.getMessage());
			list.add(language);
			return list;
		}
	}
}
