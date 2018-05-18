package com.icomp.common.service.icomp.v01c01.s007;

import com.icomp.entity.base.Vgetsealedsafekeepingtool;

import java.util.List;
import java.util.Map;

/**
 * 封存刀具-Services接口
 * @ClassName: ICOMPV01C01S007Service 
 * @author Taoyy
 * @date 2014-9-25 上午11:14:18
 */
public interface ICOMPV01C01S007Service {
	/**
	 * 取得待封存刀具信息
	 * @title getToolInfo 
	 * @param entity
	 * @return
	 * Vgetsealedsafekeepingtool
	 */
	public List<Vgetsealedsafekeepingtool> getToolInfo(Vgetsealedsafekeepingtool entity)throws Exception;
	/**
	 * 保存封存刀具数据
	 * @title saveReturnToolInfo 
	 * @param map
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 * int
	 */
	public int saveReturnToolInfo(Map<String,Object> map) throws Exception;

   /**
     * 该刀具是否封存
     * @param rfidString
     * @return true 已封存  false  未封存
     */
    public  boolean isHasSaveTools(String rfidString)throws  Exception;
}
