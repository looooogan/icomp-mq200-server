package com.icomp.wsdl.v01c01.c01s027.business;

import com.icomp.wsdl.v01c01.c01s027.endpoint.C01S027Request;
import com.icomp.wsdl.v01c01.c01s027.endpoint.C01S027Respons;

/**
 * 刀具管理-对刀送回-Business接口
 * @ClassName: C01S027Business
 * @author Taoyy
 * @date 2016年3月9日 14:09:01
 */
public interface C01S027Business {
	/**
     * 取得刀具送回信息
     * @param request
     * @return
     * @throws Exception
     */
    C01S027Respons getToolBackInfo(C01S027Request request) throws Exception;
    
    /**
     * 提交刀具送回的刀具信息
     * @param request
     * @return
     * @throws Exception
     */
    C01S027Respons saveToolBackInfo(C01S027Request request) throws Exception;
	
    /**
     * 取得交接的容器
     * @param request
     * @return
     * @throws Exception
     */
    C01S027Respons getTransferToolsContarner(C01S027Request request) throws Exception;

    /**
     * 对刀室-->刃磨室 提交数据
     * @param request
     * @return
     * @throws Exception
     */
    C01S027Respons saveKnifeToGrindingData(C01S027Request request) throws Exception;

    /**
     * 刃磨室-->对刀室 提交数据
     * @param request
     * @return
     * @throws Exception
     */
    C01S027Respons saveGrindingToKnifeData(C01S027Request request)throws Exception;

    /**
     * 取得盛放的容器
     * @param request
     * @return
     * @throws Exception
     */
    C01S027Respons getPutContarner(C01S027Request request) throws Exception;



}
