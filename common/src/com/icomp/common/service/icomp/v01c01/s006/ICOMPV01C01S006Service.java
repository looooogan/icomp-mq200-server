package com.icomp.common.service.icomp.v01c01.s006;

import com.icomp.entity.base.Vgetreturnfactorytool;

import java.util.List;
import java.util.Map;

/**
 * 刀具返厂-Service接口
 * @ClassName: ICOMPV01C01S006Service 
 * @author Taoyy
 * @date 2014-9-24 下午07:58:57
 */
public interface ICOMPV01C01S006Service {
	/**
	 * 查询待返厂刀具信息
	 * @title getToolInfo 
	 * @param entity
	 * @return
	 * Vgetreturnfactorytool
	 */
	public List<Vgetreturnfactorytool> getToolInfo(Vgetreturnfactorytool entity);
	/**
	 * 保存返厂刀具数据
	 * @title saveReturnToolInfo 
	 * @param map
	 * @return
	 * int
	 * @throws Exception 
	 */
	public int saveReturnToolInfo(Map<String,Object> map) throws Exception;

    /**
     * 待返厂刀具信息
     * @param map
     * @return
     * @throws Exception
     */
    public Vgetreturnfactorytool getReturnFactoryTools(Map<String, Object> map)throws Exception;

    /**
     * 该刀具是否返厂
     * @param rfidString
     * @return true 已返厂  false  未返厂
     */
    public  boolean isHasReturnFactory(String rfidString)throws  Exception;

}
