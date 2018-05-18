package com.icomp.common.service.impl.icomp.v01b08.s013;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b08.s013.ICOMPV01B08S013Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01B08S013ServiceImpl extends BaseService implements ICOMPV01B08S013Service {

    private AssemblylineDao assemblylineDao;
    private AxleDao axleDao;
    private VoplinkdownDao voplinkdownDao;

    public void setVoplinkdownDao(VoplinkdownDao voplinkdownDao) {
        this.voplinkdownDao = voplinkdownDao;
    }

    public void setAxleDao(AxleDao axleDao) {
        this.axleDao = axleDao;
    }

    public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
        this.assemblylineDao = assemblylineDao;
    }

    private ProcessDao processDao;

    public void setProcessDao(ProcessDao processDao) {
        this.processDao = processDao;
    }

    private EquipmentDao equipmentDao;

    public void setEquipmentDao(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    private PartsDao partsDao;

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }

    private SynthesisparametersDao synthesisparametersDao;

    public void setSynthesisparametersDao(SynthesisparametersDao synthesisparametersDao) {
        this.synthesisparametersDao = synthesisparametersDao;
    }

    private VoplinkDao voplinkDao;

    public void setVoplinkDao(VoplinkDao voplinkDao) {
        this.voplinkDao = voplinkDao;
    }

    private OplinkDao oplinkDao;

    public void setOplinkDao(OplinkDao oplinkDao) {
        this.oplinkDao = oplinkDao;
    }

    /**
     * 取得生产关联信息
     *
     * @param entity
     * @return
     */
    public Map<String, Object> getList(Voplink entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

/*
        List<Oplink> listop = new ArrayList<Oplink>();
        Oplink oplink = null;

            List<Oplink> list = (List<Oplink>) oplinkDao.searchByList(new Oplink());
            for (Oplink op : list) {
                oplink = new Oplink();
                oplink.setOplinkID(op.getOplinkID());
                //轴ID
                oplink.setAxleID(getaxle(op.getAxleID()));
                //耐用度
                oplink.setToolDurable(op.getToolDurable());
                //工序ID
                oplink.setProcessID(getProcessCode(op.getProcessID()));
                //设备ID
                oplink.setEquipmentID(getEquipments(op.getEquipmentID()));
                //流水线ID
                oplink.setAssemblyLineID(getalink(op.getAssemblyLineID()));
                //合成刀具参数ID
                oplink.setSynthesisParametersID(getSynthestID(op.getSynthesisParametersID()));
                //零部件ID
                oplink.setPartsID(getPartss(op.getPartsID()));
                listop.add(oplink);
            }
            //删除数据
            oplinkDao.delete(new Oplink());
            //批量插入
            oplinkDao.insertBatchs(listop);
*/

            //SynthesisParametersCode模糊查询
            List<Voplink> voplinks = (List<Voplink>) voplinkDao.searchByList ( entity );
            if (voplinks.size () <= 0) {
                voplinks = new ArrayList<Voplink> ();
                Voplink voplink = new Voplink ();
                // 消息：检索为0
                voplink.setMessageCode ( IConstant.EMSG0001 );
                voplink.setRetErrFlag ( true );
                voplinks.add ( voplink );
                rtn.put ( "rows", null );
                rtn.put ( "error", voplinks );
                return rtn;
            } else {
                int total = voplinkDao.searchByCount ( entity );
                rtn.put ( "rows", voplinks );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );

            }
            return rtn;
        } catch (SQLException e) {
            e.printStackTrace ();
            List<Voplink> list = new ArrayList<Voplink> ();
            Voplink voplink = new Voplink ();
            // 错误消息：数据库操作异常，查询失败!
            voplink.setMessageCode ( IConstant.EMSG0004 );
            voplink.setRetErrFlag ( true );
            voplink.setExceMessage ( e.getMessage () );
            list.add ( voplink );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
        }
        return rtn;
    }

    private String getSynthestID(String synthesisParametersID) throws SQLException {
        Synthesisparameters synthesisparameters = new Synthesisparameters ();
        synthesisparameters.setSynthesisParametersCode ( synthesisParametersID );
        synthesisparameters.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Synthesisparameters> equipmentList = (List<Synthesisparameters>) synthesisparametersDao.searchByList ( synthesisparameters );
        if (equipmentList != null && equipmentList.size () > 0) {
            return equipmentList.get ( 0 ).getSynthesisParametersID ();
        }
        return null;
    }

    private String getalink(String alink) throws SQLException {
        Assemblyline assemblyline = new Assemblyline ();
        assemblyline.setAssemblyLineCode ( alink );
        assemblyline.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Assemblyline> equipmentList = (List<Assemblyline>) assemblylineDao.searchByList ( assemblyline );
        if (equipmentList != null && equipmentList.size () > 0) {
            return equipmentList.get ( 0 ).getAssemblyLineID ();
        }
        return null;
    }

    private String getPartss(String pa) throws SQLException {
        Parts parts = new Parts ();
        parts.setPartsCode ( pa );
        parts.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Parts> part = (List<Parts>) partsDao.searchByList ( parts );
        if (part != null && part.size () > 0) {
            return part.get ( 0 ).getPartsID ();
        }
        return null;
    }

    private String getaxle(String axle) throws SQLException {
        Axle axle1 = new Axle ();
        axle1.setAxleCode ( axle );
        axle1.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Axle> axleList = (List<Axle>) axleDao.searchByList ( axle1 );
        if (axleList != null && axleList.size () > 0) {
            return axleList.get ( 0 ).getAxleID ();
        }
        return null;
    }

    private String getEquipments(String equipmentID) throws SQLException {
        Equipment equipment = new Equipment ();
        equipment.setEquipmentCode ( equipmentID );
        equipment.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Equipment> equipmentList = (List<Equipment>) equipmentDao.searchByList ( equipment );
        if (equipmentList != null && equipmentList.size () > 0) {
            return equipmentList.get ( 0 ).getEquipmentID ();
        }
        return null;
    }

    private String getProcessCode(String processCode) throws SQLException {
        Process pr = new Process ();
        pr.setProcessCode ( processCode );
        pr.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Process> processList = (List<Process>) processDao.searchByList ( pr );
        if (processList != null && processList.size () > 0) {
            return processList.get ( 0 ).getProcessID ();
        }
        return null;
    }

    /**
     * 取得生产线件列表
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Assemblyline> getAssemblyLine() {
        try {
            Assemblyline entity = new Assemblyline ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setOrderString ( "assemblyLineName" );
            List<Assemblyline> list = (List<Assemblyline>) assemblylineDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Assemblyline> ();
                Assemblyline assemblyline = new Assemblyline ();
                // 消息：检索为0
                assemblyline.setMessageCode ( IConstant.EMSG0001 );
                assemblyline.setRetErrFlag ( false );
                list.add ( assemblyline );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Assemblyline> list = new ArrayList<Assemblyline> ();
            Assemblyline assemblyline = new Assemblyline ();
            // 错误消息：数据库操作异常，查询失败!
            assemblyline.setMessageCode ( IConstant.EMSG0004 );
            assemblyline.setRetErrFlag ( true );
            assemblyline.setExceMessage ( e.getMessage () );
            list.add ( assemblyline );
            return list;
        }
    }

    /**
     * 取得轴编号列表
     *
     * @return
     */
    @Override
    public List<Axle> getAxleLine() {

        List<Axle> list = null;
        Axle axle = null;
        try {
            Axle entity = new Axle ();

            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setOrderString ( "axleName" );
            list = (List<Axle>) axleDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Axle> ();
                axle = new Axle ();
                // 消息：检索为0
                axle.setMessageCode ( IConstant.EMSG0001 );
                axle.setRetErrFlag ( false );
                list.add ( axle );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            list = new ArrayList<Axle> ();
            axle = new Axle ();
            // 错误消息：数据库操作异常，查询失败!
            axle.setMessageCode ( IConstant.EMSG0004 );
            axle.setRetErrFlag ( true );
            axle.setExceMessage ( e.getMessage () );
            list.add ( axle );

        }
        return list;


    }

    /**
     * 取得工序列表
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Process> getProcess() {
        try {
            Process entity = new Process ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setOrderString ( "processName" );
            List<Process> list = (List<Process>) processDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Process> ();
                Process process = new Process ();
                // 消息：检索为0
                process.setMessageCode ( IConstant.EMSG0001 );
                process.setRetErrFlag ( false );
                list.add ( process );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Process> list = new ArrayList<Process> ();
            Process process = new Process ();
            // 错误消息：数据库操作异常，查询失败!
            process.setMessageCode ( IConstant.EMSG0004 );
            process.setRetErrFlag ( true );
            process.setExceMessage ( e.getMessage () );
            list.add ( process );
            return list;
        }
    }

    /**
     * 取得设备列表
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Equipment> getEquipment() {
        try {
            Equipment entity = new Equipment ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setOrderString ( "equipmentName" );
            entity.setEquipmentType ( IConstant.EQUIPMENT_TYPES_0 );
            List<Equipment> list = (List<Equipment>) equipmentDao.searchByList ( entity );
            entity = new Equipment ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setEquipmentType ( IConstant.EQUIPMENT_TYPES_2 );
            List<Equipment> list2 = (List<Equipment>) equipmentDao.searchByList ( entity );
            for (Equipment equipment : list2) {
                list.add ( equipment );
            }
            if (list.size () <= 0) {
                list = new ArrayList<Equipment> ();
                Equipment equipment = new Equipment ();
                // 消息：检索为0
                equipment.setMessageCode ( IConstant.EMSG0001 );
                equipment.setRetErrFlag ( false );
                list.add ( equipment );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Equipment> list = new ArrayList<Equipment> ();
            Equipment equipment = new Equipment ();
            // 错误消息：数据库操作异常，查询失败!
            equipment.setMessageCode ( IConstant.EMSG0004 );
            equipment.setRetErrFlag ( true );
            equipment.setExceMessage ( e.getMessage () );
            list.add ( equipment );
            return list;
        }
    }

    /**
     * 取得合成刀具参数列表
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Synthesisparameters> getSynthesisParameters() {
        try {
            Synthesisparameters entity = new Synthesisparameters ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Synthesisparameters> ();
                Synthesisparameters synthesisparameters = new Synthesisparameters ();
                // 消息：检索为0
                synthesisparameters.setMessageCode ( IConstant.EMSG0001 );
                synthesisparameters.setRetErrFlag ( false );
                list.add ( synthesisparameters );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Synthesisparameters> list = new ArrayList<Synthesisparameters> ();
            Synthesisparameters synthesisparameters = new Synthesisparameters ();
            // 错误消息：数据库操作异常，查询失败!
            synthesisparameters.setMessageCode ( IConstant.EMSG0004 );
            synthesisparameters.setRetErrFlag ( true );
            synthesisparameters.setExceMessage ( e.getMessage () );
            list.add ( synthesisparameters );
            return list;
        }
    }

    /**
     * 取得加工工艺列表
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Parts> getParts() {
        try {
            Parts entity = new Parts ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setOrderString ( "partsID" );
            List<Parts> list = (List<Parts>) partsDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Parts> ();
                Parts parts = new Parts ();
                // 消息：检索为0
                parts.setMessageCode ( IConstant.EMSG0001 );
                parts.setRetErrFlag ( false );
                list.add ( parts );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Parts> list = new ArrayList<Parts> ();
            Parts parts = new Parts ();
            // 错误消息：数据库操作异常，查询失败!
            parts.setMessageCode ( IConstant.EMSG0004 );
            parts.setRetErrFlag ( true );
            parts.setExceMessage ( e.getMessage () );
            list.add ( parts );
            return list;
        }
    }

    /**
     * 取得生产关联信息
     *
     * @param oplink
     * @return
     */
    public Map<String, Object> oplinkInfo(Oplink oplink) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            Oplink entity = (Oplink) oplinkDao.searchByPrimaryKey ( oplink );
            if (entity == null) {
                entity = new Oplink ();
                // 消息：检索为0
                entity.setMessageCode ( IConstant.EMSG0001 );
                entity.setRetErrFlag ( true );
                rtn.put ( "data", null );
                rtn.put ( "error", entity );
                return rtn;
            } else {
                rtn.put ( "data", entity );
                return rtn;
            }

        } catch (SQLException e) {
            Oplink entity = new Oplink ();
            // 错误消息：数据库操作异常，查询失败!
            entity.setMessageCode ( IConstant.EMSG0004 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "data", null );
            rtn.put ( "error", entity );
            return rtn;
        }
    }

    /**
     * 新建关联
     *
     * @param oplink
     * @param langCode
     * @param langValue
     * @return
     */
    public Map<String, Object> oplinkAdd(Oplink oplink, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            oplink.setOplinkID ( NextKeyValue.getNextkeyvalue ( IConstant.OPLINK, IConstant.OPLINKID, oplink.getUpdateUser () ) );// 取得角色表主键

            oplinkDao.insert ( oplink );

            // 成功消息：插入成功
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0004, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );

            return rtn;
        } catch (SQLException e) {
            Oplink entity = new Oplink ();
            // 错误消息：数据库操作异常，插入失败!
            entity.setMessageCode ( IConstant.EMSG0007 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    /**
     * 编辑关联
     *
     * @param oplink
     * @param langCode
     * @param langValue
     * @return
     */
    public Map<String, Object> oplinkEdit(Oplink oplink, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            // 更新职务成功
            @SuppressWarnings("unused")
            int ret = oplinkDao.updateNonQuery ( oplink );
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0005, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );

            return rtn;
        } catch (SQLException e) {
            Oplink entity = new Oplink ();
            // 错误消息：数据库操作异常，更新失败!
            entity.setMessageCode ( IConstant.EMSG0006 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    /**
     * 删除关联
     *
     * @param oplink
     * @param langCode
     * @param langValue
     * @return
     */
    public Map<String, Object> oplinkDelete(Oplink oplink, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            // 删除成功
            @SuppressWarnings("unused")
            int ret = oplinkDao.delete ( oplink );
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0003, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
            return rtn;
        } catch (SQLException e) {
            Oplink entity = new Oplink ();
            // 错误消息：数据库操作异常，删除失败!
            entity.setMessageCode ( IConstant.EMSG0008 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    /**
     * 验证用户输入信息
     *
     * @param param
     * @param langCode
     * @param langValue
     * @param userID
     * @param checkType
     * @return
     */
    public Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, String userID, int checkType) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        Oplink oplink = new Oplink ();
        Map<String, String> map = new HashMap<String, String> ();
        try {
            if (StringUtils.isEmpty ( param.get ( "DivAssemblyLine" ).toString () )) {// 请选择流水线!
                map.put ( "DivAssemblyLine", MessageReSource.getMessageBox ( IConstant.SCLY01, langCode, langValue ) );
            } else {
                oplink.setAssemblyLineID ( StringUtils.isEmpty ( param.get ( "DivAssemblyLine" ).toString () ) ? null : param.get ( "DivAssemblyLine" ).toString () );
            }
            if (StringUtils.isEmpty ( param.get ( "DivProcess" ).toString () )) {// 请选择工序!
                map.put ( "DivProcess", MessageReSource.getMessageBox ( IConstant.WMSG0172, langCode, langValue ) );
            } else {
                oplink.setProcessID ( StringUtils.isEmpty ( param.get ( "DivProcess" ).toString () ) ? null : param.get ( "DivProcess" ).toString () );
            }
            if (StringUtils.isEmpty ( param.get ( "DivSynthesisParameters" ).toString () )) {// 请选择合成刀具!
                map.put ( "DivSynthesisParameters", MessageReSource.getMessageBox ( IConstant.WMSG0176, langCode, langValue ) );
            } else {
                Oplink oplink1 = new Oplink ();
                oplink1.setEquipmentID ( param.get ( "DivEquipment" ).toString () ); //设备
                oplink1.setAxleID ( param.get ( "DivAxle" ).toString () );
                oplink1.setSynthesisParametersID ( param.get ( "DivSynthesisParameters" ).toString () );
                List<Oplink> oList = oplinkDao.searchSyn ( oplink );
                if (oList.size () == 0) {
                    oplink.setSynthesisParametersID ( StringUtils.isEmpty ( param.get ( "DivSynthesisParameters" ).toString () ) ? null : param.get ( "DivSynthesisParameters" ).toString () );
                } else {
                    map.put ( "DivSynthesisParameters", MessageReSource.getMessageBox ( IConstant.REPLLC008, langCode, langValue ) );
                }

            }
            if (StringUtils.isEmpty ( param.get ( "Parts_Div_Val" ).toString () )) {// 请选择加工工艺!
                map.put ( "Parts_Div_Text", MessageReSource.getMessageBox ( IConstant.WMSG0177, langCode, langValue ) );
            } else {
                oplink.setPartsID ( StringUtils.isEmpty ( param.get ( "Parts_Div_Val" ).toString () ) ? null : param.get ( "Parts_Div_Val" ).toString () );
            }

            if (StringUtils.isEmpty ( param.get ( "DivEquipment" ).toString () )) {// 请选择设备!
                map.put ( "DivEquipment", MessageReSource.getMessageBox ( IConstant.WMSG0092, langCode, langValue ) );
            } else {
                oplink.setEquipmentID ( StringUtils.isEmpty ( param.get ( "DivEquipment" ).toString () ) ? null : param.get ( "DivEquipment" ).toString () );
            }

            // 耐用度(非空验证,数字验证)
            if (StringUtils.isEmpty ( param.get ( "DivToolDurable" ).toString () )) {
                map.put ( "DivToolDurable", MessageReSource.getMessageBox ( IConstant.WMSG0064, langCode, langValue ) );
            } else if (!checkOutNum ( param.get ( "DivToolDurable" ).toString () )) {
                map.put ( "DivToolDurable", MessageReSource.getMessageBox ( IConstant.WMSG0065, langCode, langValue ) );
            } else {
                oplink.setToolDurable ( new BigDecimal ( param.get ( "DivToolDurable" ).toString () ) );
            }
            // 请选择轴!
            if (StringUtils.isEmpty ( param.get ( "DivAxle" ).toString () )) {
                map.put ( "DivAxle", MessageReSource.getMessageBox ( IConstant.SCLY02, langCode, langValue ) );
            } else {

                oplink.setAxleID ( StringUtils.isEmpty ( param.get ( "DivAxle" ).toString () ) ? null : param.get ( "DivAxle" ).toString () );
            }

            List<Oplink> list = oplinkDao.searchByListWhere ( oplink );
            if (checkType == 1) {
                if (list.size () == 0) {
                    rtn.put ( "data", oplink );
                } else {
                    map.put ( "", MessageReSource.getMessageBox ( IConstant.REPLLC008, langCode, langValue ) );
                }
            }
            if (checkType == 2) {
                if (list.size () < 0) {
                    map.put ( "DivToolDurable", MessageReSource.getMessageBox ( IConstant.WMSG0065, langCode, langValue ) );

                } else {
                    rtn.put ( "data", oplink );
                }
            }

            if (map.size () > 0) {
                rtn.put ( "message", map );
                rtn.put ( "data", null );
                rtn.put ( "status", IConstant.RESULT_CODE_2 );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
            Oplink entity = new Oplink ();
            // 错误消息：数据库操作异常，删除失败!
            entity.setMessageCode ( IConstant.EMSG0008 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
        return rtn;

    }

    @Override
    public List<Voplinkdown> getVoplinList(Voplinkdown entity) {
        try {

            List<Voplinkdown> list = (List<Voplinkdown>) voplinkdownDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Voplinkdown> ();
                Voplinkdown voplinkdown = new Voplinkdown ();
                voplinkdown.setMessageCode ( IConstant.WMSG0008 );
                voplinkdown.setRetErrFlag ( false );
                list.add ( voplinkdown );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Voplinkdown> list = new ArrayList<Voplinkdown> ();
            Voplinkdown voplinkdown = new Voplinkdown ();
            voplinkdown.setMessageCode ( IConstant.EMSG0004 );
            voplinkdown.setRetErrFlag ( true );
            voplinkdown.setExceMessage ( e.getMessage () );
            list.add ( voplinkdown );
            return list;
        }
    }
}