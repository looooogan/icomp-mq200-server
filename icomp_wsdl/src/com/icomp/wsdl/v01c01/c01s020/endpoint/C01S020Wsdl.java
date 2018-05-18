package com.icomp.wsdl.v01c01.c01s020.endpoint;

import java.net.ConnectException;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 回厂识别-Webservce接口
 *
 * @author Taoyy
 * @ClassName: C01S020Wsdl
 * @date 2014-9-23 下午12:05:54
 */
@WebService
public interface C01S020Wsdl {

    /**
     * 取得通知单号列表
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getNotificationList(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得通知单号信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getNotificationListInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得盛放入库刀具的空盒信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getEmptyBoxInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交回厂入库刀片信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String submitBackFactoryToolInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交钻头激光码
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String submitBitLaserCode(@WebParam(name = "request") String request) throws Exception;

    /****************************************/

    /**
     * 取得出厂单号列表
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String getFactoryNoList(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得出厂刀具列表
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String getFactoryToolList(@WebParam(name = "request") String request) throws Exception;

    /**
     * 回厂刀片绑定
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String saveFactoryBlade(@WebParam(name = "request") String request) throws Exception;

    /**
     * 回厂钻头绑定
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String saveFactoryBoringCrown(@WebParam(name = "request") String request) throws Exception;

    /**
     * 验证当前RFID 是否绑定
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String checkRfid(@WebParam(name = "request") String request) throws Exception;

    /**
     * 扫描rfid（只能是空标签）
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String getRFIDnullCode(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交扫描信息并初始化
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String submitOutFactInData(@WebParam(name = "request") String request) throws Exception;
}
