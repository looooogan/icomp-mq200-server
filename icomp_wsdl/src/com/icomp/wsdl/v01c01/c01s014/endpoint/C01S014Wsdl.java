package com.icomp.wsdl.v01c01.c01s014.endpoint;

import java.net.ConnectException;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 刀具分拣-Webservce接口
 *
 * @author Taoyy
 * @ClassName: C01S014Wsdl
 * @date 2016-2-29 上午11:57:08
 */
@WebService
public interface C01S014Wsdl {
	
	/**
     * 取得分拣刀具的信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title getToolsSorting
     */
    public String getToolsSorting(@WebParam(name = "request") String request) throws Exception;
    
    /**
     * 提交分拣刀具的信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title saveToolsSortingInfo
     */
    public String saveToolsSortingInfo(@WebParam(name = "request") String request) throws Exception;
	
	
	
	
	
	
	
	
	
	
	

    /**
     * 取得扫描刀具信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title getToolInfo
     */
    public String getToolInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 刃磨方式取得
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title getRepairWayList
     */
    public String getRepairWayList(@WebParam(name = "request") String request) throws Exception;

    /**
     * 修复通知单号生成
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title createRepairNoticeNumber
     */
    public String createRepairNoticeNumber(@WebParam(name = "request") String request) throws Exception;

    /**
     * 修复通知单发布
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title saveToolRepairNotice
     */
     String saveToolRepairNotice(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得修磨处理(非单品)
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S014Respons
     * @title getRegrindingList
     */
     String getRegrindingList(@WebParam(name = "request") String request) throws Exception ;

    /**
     * 保存修磨处理(非单品)
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S014Respons
     * @title saveRegrinding
     */
     String saveRegrinding(@WebParam(name = "request") String request) throws Exception;

}
