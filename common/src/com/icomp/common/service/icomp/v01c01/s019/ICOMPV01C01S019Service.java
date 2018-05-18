package com.icomp.common.service.icomp.v01c01.s019;

import com.icomp.entity.base.Leasertabe;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgettoolbindinginfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICOMPV01C01S019Service {

    /**
     * 刀具状态查询
     *
     * @param entity
     * @return
     */
    public Rfidcontainer getToolInfo(Rfidcontainer entity);

    /**
     * 刀具激光码保存
     *
     * @param entity
     * @return
     */
    public Rfidcontainer saveToolInfo(Rfidcontainer entity);

    /**
     * @return
     * @throws Exception
     */
    List<Vgettoolbindinginfo> gettoolbindinginfo(Vgettoolbindinginfo r) throws Exception;

    /**
     * 提交刀具绑定信息
     *
     * @param rt
     * @return
     * @throws Exception
     */
    int submitToolBindingInfo(Rfidcontainer rt, String toolCode) throws Exception;

    List<Tooltransfer> getToolInfomation(Tooltransfer tt) throws Exception;

    Tool getToolCode(Tool t) throws Exception;

    Tooltransfer getToolPB(Tooltransfer tf) throws Exception;

    List<Rfidcontainer> getLacerCode(Rfidcontainer rfidcontainer) throws Exception;

    /**
     * 取得最近一次的批次
     *
     * @param tp
     * @return List<Toolprocured>
     * @title getProcured
     */
    public List<Toolprocured> getProcured(Toolprocured tp) throws Exception;

    Object leasertabeInsert(Leasertabe lt) throws Exception;

    String getLacerCodeState(Leasertabe leasertabe) throws Exception;

    int getLaserCodeInfo(Leasertabe entity) throws Exception;

    /**
     *  提交出厂刀具信息
     *
     * @param params
     * @return
     * @throws SQLException
     */
    int submitOutFackterTools(Map<String, Object> params) throws SQLException;
}
