package com.icomp.common.service.icomp.v01c01.s005;

import java.util.List;

import com.icomp.entity.base.Scrap;
import com.icomp.entity.base.Tooltransfer;

/**
 * 报废-Service接口
 * @ClassName: ICOMPV01C01S005Service 
 * @author Taoyy
 * @date 2016-2-25 上午11:01:07
 */
public interface ICOMPV01C01S005Service {
	/**
	 * 报废
	 * @title saveScrap 
	 * @return
	 * @throws Exception
	 * String
	 */
	public int saveScrap(Scrap entity,Tooltransfer tt)throws Exception;

	/**
	 * 获取刀具信息
	 * @param tt
	 * @return
	 * @throws Exception
     */
	List<Tooltransfer> getToolMsg(Tooltransfer tt) throws Exception;

	/**
	 * 报废刀具
	 * @param tt
	 * @return
	 * @throws Exception
     */
	int updateTooltransfer(Tooltransfer tt) throws Exception;
}
