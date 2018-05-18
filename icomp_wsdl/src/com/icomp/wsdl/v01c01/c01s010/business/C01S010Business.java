package com.icomp.wsdl.v01c01.c01s010.business;

import com.icomp.wsdl.v01c01.c01s010.endpoint.C01S010Request;
import com.icomp.wsdl.v01c01.c01s010.endpoint.C01S010Respons;

/**
 * 刀具换装-Business接口
 *
 * @author Taoyy
 * @ClassName: C01S010Business
 * @date 2016-2-26 下午02:40:43
 */
public interface C01S010Business {
    /**
     * 取得合成刀组成信息
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S010Respons
     * @title getSynthesisTool
     */
    C01S010Respons getSynthesisTool(C01S010Request regSwitch) throws Exception;

    /**
     * 取得单品刀具信息
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S010Respons
     * @title getSingleTool
     */
    C01S010Respons getSingleTool(C01S010Request regSwitch) throws Exception;

    /**
     * 提交热套换装完成信息
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S010Respons
     * @title saveHotChangeInfo
     */
    C01S010Respons saveHotChangeInfo(C01S010Request regSwitch) throws Exception;

    /**
     * 查询报废容器的RFID
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S010Respons
     * @title searchByScrapContainerRfid
     */
    C01S010Respons searchByScrapContainerRfid(C01S010Request regSwitch) throws Exception;

    /**
     * 查询盛放可刃磨钻头的刀盒的信息
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S010Respons
     * @title searchGrindingBitInfo
     */
    C01S010Respons searchGrindingBitInfo(C01S010Request regSwitch) throws Exception;

    /**
     * 查询刃磨容器的Rfid
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S010Respons
     * @title searchByGrindingContainerRfid
     */
    C01S010Respons searchByGrindingContainerRfid(C01S010Request regSwitch) throws Exception;

    /**
     * 刀具换装最后提交
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S010Respons
     * @title saveSubmit
     */
    C01S010Respons saveSubmit(C01S010Request regSwitch) throws Exception;

    /**
     * 提交合成刀具报废信息
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S010Respons
     * @title saveToolScrapInfo
     */
    C01S010Respons saveToolScrapInfo(C01S010Request regSwitch) throws Exception;

    /**
     * 提交可复磨钻头的信息
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S010Respons
     * @title saveToolScrapInfo
     */
    C01S010Respons saveGrindingBitInfo(C01S010Request regSwitch) throws Exception;

    /**
     * 提交可复磨刀片的信息
     *
     * @param regSwitch
     * @return
     * @throws Exception
     */
    C01S010Respons savesGrindingToolInfo(C01S010Request regSwitch) throws Exception;
/*==================================刀具卸下辅具=====================================Begin====taoyy=============2016年8月13日23:09:12================ */

    /**
     * 取得合成刀组成信息（新增）
     *
     * @param request
     * @return
     * @throws Exception
     */
    C01S010Respons getSynthesisToolByRfid(C01S010Request request) throws Exception;

    /**
     * 保存刀具卸下辅具信息（新增）
     *
     * @param request
     * @return
     * @throws Exception
     */
    C01S010Respons saveLoadownMsg(C01S010Request request) throws Exception;

    C01S010Respons getSynthesisToolByupload(C01S010Request request) throws Exception;

    C01S010Respons getSynthesisToolByCode(C01S010Request request) throws Exception;

    C01S010Respons saveUploadingMsg(C01S010Request request) throws Exception;

    C01S010Respons deleteRfidByToolID(C01S010Request request) throws Exception;

    C01S010Respons seachToolMsg(C01S010Request request) throws Exception;


    /*===================================刀具卸下辅具=====================================End=====taoyy=============2016年8月13日14:48:37=============== */
}
