package com.icomp.wsdl.v01c01.c01s014.business;

import com.icomp.wsdl.v01c01.c01s014.endpoint.C01S014Request;
import com.icomp.wsdl.v01c01.c01s014.endpoint.C01S014Respons;

/**
 * 刀具分拣-Business接口
 * @ClassName: C01S014Business 
 * @author Taoyy
 * @date 2016-2-29 下午03:02:28
 */
public interface C01S014Business {
	
	/**
	 * 取得分拣刀具的信息
	 * @title getToolsSorting 
	 * @param regSwitch
	 * @return
	 * C01S014Respons
	 */
	public C01S014Respons getToolsSorting(C01S014Request regSwitch)throws Exception;
	
	/**
	 * 提交分拣刀具的信息
	 * @title saveToolsSortingInfo 
	 * @param regSwitch
	 * @return
	 * C01S014Respons
	 */
	public C01S014Respons saveToolsSortingInfo(C01S014Request regSwitch)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 刃磨方式取得
	 * @title getRepairWayList 
	 * @param regSwitch
	 * @return
	 * C01S014Respons
	 */
	public C01S014Respons getRepairWayList(C01S014Request regSwitch)throws Exception;
	/**
	 * 修复通知单号生成
	 * @title createRepairNoticeNumber 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S014Respons
	 */
	public C01S014Respons createRepairNoticeNumber(C01S014Request regSwitch)throws Exception;
	/**
	 * 取得扫描刀具信息
	 * @title getToolInfo 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S014Respons
	 */
	public C01S014Respons getToolInfo(C01S014Request regSwitch)throws Exception;
	/**
	 * 修复通知单发布
	 * @title saveToolRepairNotice 
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 * C01S014Respons
	 */
	public C01S014Respons saveToolRepairNotice(C01S014Request regSwitch)throws Exception;

	/**
	 * 取得修磨处理(非单品)
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	C01S014Respons getRegrindingList(C01S014Request regSwitch)throws Exception;

	/**
	 * 保存修磨处理(非单品)
	 * @param regSwitch
	 * @return
	 * @throws Exception
	 */
	C01S014Respons saveRegrinding(C01S014Request regSwitch)throws Exception;
}
