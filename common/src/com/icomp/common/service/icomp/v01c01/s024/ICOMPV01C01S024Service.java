package com.icomp.common.service.icomp.v01c01.s024;

import com.icomp.entity.base.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 刀具状态查询
 *
 * @author yzq
 */
public interface ICOMPV01C01S024Service {

    /**
     * 刀具状态查询
     *
     * @param rfidString
     * @return
     */
    public Map<String, Object> getToolInfo(String rfidString, String languageCode, String languageValue);

    /**
     * 查询单品刀信息
     *
     * @return
     * @throws Exception
     */
    Vgettoolinformation gettoolinformation(Vgettoolinformation r) throws Exception;

    /**
     * 查询员工卡
     *
     * @return
     * @throws Exception
     */
    Vgetcustomermsg getUserInfo(Vgetcustomermsg r) throws Exception;

    /**
     * 查询合成刀
     *
     * @return
     * @throws Exception
     */
    Vgetsynthsisinfo getsynthsisinfo(Vgetsynthsisinfo r) throws Exception;

    /**
     * 查询设备
     *
     * @return
     * @throws Exception
     */
    List<Vgetequipmentinfo> getequipmentinfo(Vgetequipmentinfo r) throws Exception;

    /**
     * 查询容器
     *
     * @return
     * @throws Exception
     */
    Vgetcontainercarrierinfo getcontainercarrierinfo(Vgetcontainercarrierinfo r) throws Exception;

    /**
     * 查询库位标签
     *
     * @return
     * @throws Exception
     */
    Vgetinventorymsg getInventoryMsg(Vgetinventorymsg r) throws Exception;

    /**
     * 查询标签类型
     *
     * @param rfc
     * @return
     * @throws Exception
     */
    Rfidcontainer getQeryType(Rfidcontainer rfc) throws Exception;

    /**
     * 查询轴数
     *
     * @param vv
     * @return
     * @throws Exception
     */
    List<Vgetequipmentinfo> getequipmentinfolist(Vgetequipmentinfo vv) throws Exception;

    /**
     * 查询修磨设备信息
     *
     * @param ne
     * @return
     * @throws Exception
     */
    Noticeequipment getNoticeEqu(Noticeequipment ne) throws Exception;

    /**
     * 查询容器内数量
     *
     * @param vv
     * @return
     * @throws Exception
     */
    List<Vgetcontainercarrierinfo> getcontainercarrierinfolist(Vgetcontainercarrierinfo vv) throws Exception;

    List<Vgetcontainercarrierinfo> getcontainercarrierinfolist1(Vgetcontainercarrierinfo vv) throws Exception;

    /**
     * 查询容器名称
     *
     * @param cc
     * @return
     * @throws Exception
     */
    Containercarrier getContainerName(Containercarrier cc) throws Exception;

    /**
     * 查询库存单品刀
     *
     * @param vvv
     * @return
     * @throws Exception
     */

    Vgetknifeinventoryinfo getKnifeInfo(Vgetknifeinventoryinfo vvv) throws Exception;

    /**
     * 快速查询合成刀具流转信息
     *
     * @param vtt
     * @return
     * @throws Exception
     */
    List<Vgetsynthsistooltransferinfo> getSynthsisTooltransferInfo(Vgetsynthsistooltransferinfo vtt) throws Exception;

    /**
     * 根据材料号查询数量
     *
     * @param vtt
     * @return
     * @throws Exception
     */
    List<Vgetinventorymsg> getNumber(Vgetinventorymsg msg) throws Exception;

    List<Synthesisparameters> getSynthsisTools(Synthesisparameters sp) throws Exception;
}
