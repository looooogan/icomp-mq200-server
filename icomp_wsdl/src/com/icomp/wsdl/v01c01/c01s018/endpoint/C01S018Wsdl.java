package com.icomp.wsdl.v01c01.c01s018.endpoint;

import java.net.ConnectException;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 刀具复磨安上-Webservce接口
 *
 * @author Taoyy
 * @ClassName: C01S018Wsdl
 * @date 2014-9-23 下午12:03:10
 */
@WebService
public interface C01S018Wsdl {

    /**
     * 取得扫描刀具的信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String getToolInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 复磨刀具安上
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String saveNoticeToolload(@WebParam(name = "request") String request) throws Exception;

    /**
     * 复磨刀具报废
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public String savetoolDelete(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得刀具长度和不可刃磨长度
     */
    public String getToolLength(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得报废盒子
     */
    public String getDiscardBox(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得盒子数量
     */
    public String getToolInfoCount(@WebParam(name = "request") String request) throws Exception;

    /**
     * 按刀具编码或物料号查询取得刃磨数量(非单品)
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getToolCodeAndKivCode(@WebParam(name = "request") String request) throws Exception;


    /**
     * 取得刃磨设备信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getEquipmentByRfid(@WebParam(name = "request") String request) throws Exception;

    /**
     * 扫描待放刃磨完刀具的容器(报废)
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String putScrapGrindingContainer(@WebParam(name = "request") String request) throws Exception;

    /**
     * 扫描待放刃磨完刀具的容器(无报废)
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String putGrindingContainer(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得所有刃磨刀具的设备列表
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getPanGrindingEquipment(@WebParam(name = "request") String request) throws Exception;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * 取得修磨设备列表
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getGrindingEqulist(@WebParam(name = "request") String request) throws Exception;
    /**
     * 取得修磨刀具的信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String getGrindingToolsInfo(@WebParam(name = "request") String request) throws Exception;
    /**
     * 提交刀具修磨设备信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    String submitToolsGrindingEquInfo(@WebParam(name = "request") String request) throws Exception;
    
    
}
