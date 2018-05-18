package com.icomp.wsdl.v01c01.c01s010.endpoint;

import java.net.ConnectException;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 刀具换装-Webservce接口
 *
 * @author Taoyy
 * @ClassName: C01S010Wsdl
 * @date 2016-2-26 下午6:11:20
 */
@WebService
public interface C01S010Wsdl {

    /**
     * 取得合成刀组成信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title getSynthesisTool
     */
    String getSynthesisTool(@WebParam(name = "request") String request) throws Exception;

    /**
     * 取得单品刀具信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title getSingleTool
     */
    String getSingleTool(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交热套换装完成信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title saveHotChangeInfo
     */
    String saveHotChangeInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 查询报废容器的RFID
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title searchByScrapContainerRfid
     */
    String searchByScrapContainerRfid(@WebParam(name = "request") String request) throws Exception;

    /**
     * 查询盛放可刃磨钻头的刀盒的信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title searchGrindingBitInfo
     */
    String searchGrindingBitInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 查询刃磨容器的Rfid
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title searchByGrindingContainerRfid
     */
    String searchByGrindingContainerRfid(@WebParam(name = "request") String request) throws Exception;

    /**
     * 刀具换装最后提交
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title saveSubmit
     */
    String saveSubmit(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交合成刀具报废信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title saveToolScrapInfo
     */
    String saveToolScrapInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交可复磨钻头的信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title saveToolScrapInfo
     */
    String saveGrindingBitInfo(@WebParam(name = "request") String request) throws Exception;

    /**
     * @param request
     * @return
     * @throws Exception
     */
    String savesGrindingToolInfo(@WebParam(name = "request") String request) throws Exception;
/*===================================刀具卸下辅具=====================================Begin====taoyy=============2016年8月13日14:48:37================ */

    /**
     * 取得合成刀组成信息（新增）
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S010Respons
     * @title getSynthesisToolByRfid
     */
    String getSynthesisToolByRfid(@WebParam(name = "request") String request) throws Exception;

    /**
     * 保存刀具卸下辅具信息（新增）
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S010Respons
     * @title saveLoadownMsg
     */
    String saveLoadownMsg(@WebParam(name = "request") String request) throws Exception;

/*===================================刀具卸下辅具=====================================End=====taoyy=============2016年8月13日14:48:37=============== */
/*===================================刀具安上 辅具=====================================Begin====taoyy=============2016年8月14日9:57:40================ */

    /**
     * 取得合成刀组成信息（安上新增）
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S010Respons
     * @title getSynthesisToolByupload
     */
    String getSynthesisToolByupload(@WebParam(name = "request") String request) throws Exception;

    /**
     * 根据合成刀具编码查询刀具信息（安上）
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S010Respons
     * @title getSynthesisToolByCode
     */
    String getSynthesisToolByCode(@WebParam(name = "request") String request) throws Exception;

    /**
     * 提交刀具安上辅具信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S010Respons
     * @title saveUploadingMsg
     */
    String saveUploadingMsg(@WebParam(name = "request") String request) throws Exception;

/*===================================刀具卸下辅具=====================================End=====taoyy=============2016年8月13日14:48:37=============== */

    String deleteRfidByToolID(@WebParam(name = "request") String request) throws Exception;

    /**
     * 验证扫描的是否和安上的刀具相符合
     * @param request
     * @return
     * @throws Exception
     */
    String seachToolMsg(@WebParam(name = "request") String request) throws Exception;


}
