package com.icomp.wsdl.v01c04.c04s001.business;

import com.icomp.wsdl.v01c04.c04s001.endpoint.C04S001Request;
import com.icomp.wsdl.v01c04.c04s001.endpoint.C04S001Respons;


public interface C04S001Business {
    /**
     * 取得当前扫描刀具数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C04S001Respons getToolList(C04S001Request request) throws Exception;

    /**
     * 取得盘点数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C04S001Respons getStockingList(C04S001Request request) throws Exception;

    /**
     * 保存盘点数据列表
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    public C04S001Respons saveStockingList(C04S001Request request) throws Exception;

    /**
     * 根据材料号查询刀具在库数量
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C04S001Respons seachInitNewVentory(C04S001Request request) throws Exception;

    /**
     * 提交在库盘点刀具
     *
     * @param request
     * @return
     * @throws Exception
     */
     C04S001Respons submitCheckToolDate(C04S001Request request) throws Exception;

     C04S001Respons checkRFIDType(C04S001Request request) throws Exception;

}
