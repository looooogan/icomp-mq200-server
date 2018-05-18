package com.icomp.wsdl.v01c01.c01s027.endpoint;

import java.net.ConnectException;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 刀具管理-刀具送回-Webservce接口
 *
 * @author Taoyy
 * @ClassName: C01S027Wsdl
 * @date 2016年3月9日 13:58:25
 */
@WebService
public interface C01S027Wsdl {
    /**
     * 取得刀具送回信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getToolBackInfo(@WebParam(name = "request") String request) throws Exception;
    
    /**
     * 提交刀具送回的刀具信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String saveToolBackInfo(@WebParam(name = "request") String request) throws Exception;
	
/**************************************************/
    /**
     * 取得交接的容器
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getTransferToolsContarner(@WebParam(name = "request") String request) throws Exception;

    /**
     * 对刀室-->刃磨室 提交数据
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String saveKnifeToGrindingData(@WebParam(name = "request") String request) throws Exception;

    /**
     * 刃磨室-->对刀室 提交数据
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String saveGrindingToKnifeData(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得盛放的容器
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getPutContarner(@WebParam(name = "request") String request) throws Exception;


















}

