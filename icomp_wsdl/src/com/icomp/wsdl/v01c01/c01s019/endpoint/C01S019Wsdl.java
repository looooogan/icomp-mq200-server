package com.icomp.wsdl.v01c01.c01s019.endpoint;

import java.net.ConnectException;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 对刀结束-Webservce接口
 *
 * @author Taoyy
 * @ClassName: C01S019Wsdl
 * @date 2014-9-23 下午12:04:31
 */
@WebService
public interface C01S019Wsdl {

    /**
     * 取得要绑定的刀具信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String getBindingToolInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得激光码
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String getLaserCode(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交激光码
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String setLaserCode(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交刀具绑定信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String submitToolBindingInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * rfid扫描接口
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getOutfactTools(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交出厂刀具信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String submitOutFackterTools(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得合成刀具信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String getToolInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 对刀结束
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String saveToolInfo(@WebParam(name = "request") String request) throws Exception;
}
