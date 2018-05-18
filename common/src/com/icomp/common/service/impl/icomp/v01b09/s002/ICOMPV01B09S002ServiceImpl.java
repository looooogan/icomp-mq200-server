package com.icomp.common.service.impl.icomp.v01b09.s002;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b09.s002.ICOMPV01B09S002Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class ICOMPV01B09S002ServiceImpl extends BaseService implements ICOMPV01B09S002Service {
    private SynthesiscutterlocationDao synthesiscutterlocationDao;
    private SynthesisparametersDao synthesisparametersDao;
    @SuppressWarnings("unused")
    private VsynthesisparametersDao vsynthesisparametersDao;

    public void setSynthesiscutterlocationDao(SynthesiscutterlocationDao synthesiscutterlocationDao) {
        this.synthesiscutterlocationDao = synthesiscutterlocationDao;
    }

    public void setSynthesisparametersDao(SynthesisparametersDao synthesisparametersDao) {
        this.synthesisparametersDao = synthesisparametersDao;
    }

    public void setVsynthesisparametersDao(VsynthesisparametersDao vsynthesisparametersDao) {
        this.vsynthesisparametersDao = vsynthesisparametersDao;
    }

    private EquipmentDao equipmentDao;
    private PartsDao partsDao;
    private ToolDao toolDao;
    private ToolReplaceDao toolReplaceDao;

    public void setToolReplaceDao(ToolReplaceDao toolReplaceDao) {
        this.toolReplaceDao = toolReplaceDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }

    public void setEquipmentDao(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    /**
     * SynthesisParametersCode模糊查询
     */
    @Override
    public Map<String, Object> getList(Synthesisparameters entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            //SynthesisParametersCode模糊查询
            List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByList_F ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Synthesisparameters> ();
                Synthesisparameters comlist = new Synthesisparameters ();
                //消息：检索为0
                comlist.setMessageCode ( IConstant.EMSG0001 );
                comlist.setRetErrFlag ( true );
                list.add ( comlist );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                int total = synthesisparametersDao.searchByCount ( entity );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );
                return rtn;
            }

        } catch (SQLException e) {
            e.printStackTrace ();
            List<Synthesisparameters> list = new ArrayList<Synthesisparameters> ();
            Synthesisparameters comlist = new Synthesisparameters ();
            //错误消息：数据库操作异常，查询失败!
            comlist.setMessageCode ( IConstant.EMSG0004 );
            comlist.setRetErrFlag ( true );
            comlist.setExceMessage ( e.getMessage () );
            list.add ( comlist );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    /**
     * 刀具参数验证
     *
     * @param param
     * @param langValue
     * @return
     */

    /**
     * 新建刀具参数信息 312 SYNTHESISPARAMETERS String SynthesisParameters 合成刀具参数表
     * 主键生成字段 陈亚楠 2014-09-22 16:23:43 否 313 SYNTHESISPARAMETERSID String
     * SynthesisParametersID 合成刀具参数表主键 主键生成字段 陈亚楠 2014-09-22 16:23:44 否
     *
     * @param
     * @param langValue
     * @return
     */
    @Override
    public Map<String, Object> synthesisAdd(Synthesisparameters synthesisParameters, List<Synthesiscutterlocation> SynLocList, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            synthesisparametersDao.insert ( synthesisParameters );
            //成功消息：插入成功
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0004, langCode, langValue ) );
            for (Synthesiscutterlocation synLoc : SynLocList) {
                synLoc.setSynthesisParametersID ( synthesisParameters.getSynthesisParametersID () );
                synthesiscutterlocationDao.insert ( synLoc );
            }
            //保存替换刀具
            ToolReplace toolReplace = null;
            for (Synthesiscutterlocation synLoc : SynLocList) {
                if (null == synLoc.getReplaceCodes()){
                    continue;
                }
                for (ToolReplace replace : synLoc.getReplaceCodes()) {
                    toolReplace = new ToolReplace();
                    toolReplace.setSynthesisParametersID(synthesisParameters.getSynthesisParametersID());
                    toolReplace.setToolCode(synLoc.getToolCode());
                    toolReplace.setRepalceToolCode(replace.getRepalceToolCode());
                    toolReplaceDao.insert ( toolReplace );
                }
            }
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
            return rtn;
        } catch (SQLException e) {
            e.printStackTrace ();
            Synthesisparameters entity = new Synthesisparameters ();
            //错误消息：数据库操作异常，插入失败!
            entity.setMessageCode ( IConstant.EMSG0007 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "status", IConstant.RESULT_CODE_2 );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    /**
     * 刀具参数删除
     *
     * @param
     * @return 刀具参数信息
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> synthesisDelete(Synthesisparameters synthesisParameters, String langCode, String langValue) {

        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            // 删除失败! 进行数据排他验证
            Synthesisparameters entity = new Synthesisparameters ();

            entity.setSynthesisParametersCode ( synthesisParameters.getSynthesisParametersCodeWhere () );
            entity.setUpdateTime ( synthesisParameters.getUpdateTimeWhere () );
            entity.setUpdateUser ( synthesisParameters.getUpdateUserWhere () );
            entity.setVersion ( synthesisParameters.getVersionWhere () );
            List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByList ( entity );
            if (list == null || list.size () == 0) {
                entity = new Synthesisparameters ();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode ( IConstant.WMSG0009 );
                entity.setRetErrFlag ( true );
                rtn.put ( "error", entity );
                rtn.put ( "data", null );
                return rtn;
            } else {
                // 删除成功
                @SuppressWarnings("unused")
                int ret = synthesisparametersDao.updateNonQuery ( synthesisParameters );
                rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0003, langCode, langValue ) );
                rtn.put ( "status", IConstant.RESULT_CODE_0 );
                return rtn;
            }
        } catch (SQLException e) {
            Position entity = new Position ();
            //错误消息：数据库操作异常，删除失败!
            entity.setMessageCode ( IConstant.EMSG0008 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    /**
     * 编辑刀具参数信息
     *
     * @param
     * @param langValue
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> synthesisEdit(Synthesisparameters synthesis, List<Synthesiscutterlocation> locatList, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            // 更新失败! 进行数据排他验证
            Synthesisparameters entity = new Synthesisparameters ();
            entity.setSynthesisParametersID ( synthesis.getSynthesisParametersIDWhere () );
            entity.setVersion ( synthesis.getVersionWhere () );
            List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByList ( entity );

            if (list == null || list.size () == 0) {
                entity = new Synthesisparameters ();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                synthesis.setMessageCode ( IConstant.WMSG0009 );
                entity.setRetErrFlag ( true );
                rtn.put ( "error", entity );
                rtn.put ( "data", null );
                return rtn;
            }
            // 更新刀具合成信息
            @SuppressWarnings("unused")
            int ret = synthesisparametersDao.updateNonQuery ( synthesis );
            // 删除刀具位置
            Synthesiscutterlocation location = new Synthesiscutterlocation ();
            location.setSynthesisParametersIDWhere ( synthesis.getSynthesisParametersID () );
            synthesiscutterlocationDao.delete ( location );
            // 添加刀具位置
            for (Synthesiscutterlocation synLoc : locatList) {
                synthesiscutterlocationDao.insert ( synLoc );
            }
            // 删除替换刀具参数
            ToolReplace toolReplace = new ToolReplace();
            toolReplace.setSynthesisParametersIDWhere(synthesis.getSynthesisParametersID ());
            toolReplaceDao.delete(toolReplace);
            // 添加刀具替换参数
            ToolReplace insToolReplace = null;
            for (Synthesiscutterlocation synLoc : locatList) {
                if (null == synLoc.getReplaceCodes()){
                    continue;
                }
                for (ToolReplace replace : synLoc.getReplaceCodes()) {
                    insToolReplace = new ToolReplace();
                    insToolReplace.setSynthesisParametersID(synthesis.getSynthesisParametersID());
                    insToolReplace.setToolCode(synLoc.getToolCode());
                    insToolReplace.setRepalceToolCode(replace.getRepalceToolCode());
                    toolReplaceDao.insert ( insToolReplace );
                }
            }
            // 更新成功
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0005, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
            return rtn;
        } catch (SQLException e) {
            e.printStackTrace ();
            Synthesisparameters entity = new Synthesisparameters ();
            //错误消息：数据库操作异常，更新失败!
            entity.setMessageCode ( IConstant.EMSG0006 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }

    }

    // 2017/09/5 宋健 追加↓↓↓　dazhong@YMSC
    @Override
    public Map<String, Object> syntEdit(Synthesisparameters synthesis,Synthesiscutterlocation location, String langCode, String langValue) throws BusinessException {
        try {
            // 更新刀具合成信息
            //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
            int ret = synthesisparametersDao.updateNonQuery ( synthesis );
            //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
            synthesiscutterlocationDao.updateById(location);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> rtn = new HashMap<String, Object> ();
        // 更新成功
        rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0005, langCode, langValue ) );
        rtn.put ( "status", IConstant.RESULT_CODE_0 );
        return rtn;
    }
    // 2017/09/5 宋健 追加↑↑↑　dazhong@YMSC

    /**
     * 获取合成刀具参数
     *
     * @param entity 页面查询条件
     * @return 项目信息信息
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> synthesisInfo(Synthesisparameters entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            // 合成刀参数
            List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByList ( entity );
            if (list.size () <= 0) {
                Synthesisparameters synthesisParameters = new Synthesisparameters ();
                //消息：检索为0
                synthesisParameters.setMessageCode ( IConstant.EMSG0001 );
                synthesisParameters.setRetErrFlag ( true );
                rtn.put ( "data", null );
                rtn.put ( "error", synthesisParameters );
                return rtn;
            } else {
                Synthesisparameters synthesisParameters = list.get ( 0 );
                rtn.put ( "data", synthesisParameters );
                return rtn;
            }
        } catch (SQLException e) {
            Synthesisparameters synthesisParameters = new Synthesisparameters ();
            //错误消息：数据库操作异常，查询失败!
            synthesisParameters.setMessageCode ( IConstant.EMSG0004 );
            synthesisParameters.setRetErrFlag ( true );
            synthesisParameters.setExceMessage ( e.getMessage () );
            rtn.put ( "data", null );
            rtn.put ( "error", synthesisParameters );
            return rtn;
        }
    }

    /**
     * 获取合成刀具位置参数
     *
     * @param entity 页面查询条件
     * @return 项目信息信息
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Synthesiscutterlocation> synthesisLocationInfo(Synthesiscutterlocation entity) {
        try {

            List<Synthesiscutterlocation> list = (List<Synthesiscutterlocation>) synthesiscutterlocationDao.searchByList ( entity );
            for (Synthesiscutterlocation synthesiscutterlocation : list) {
                ToolReplace toolReplace = new ToolReplace();
                toolReplace.setSynthesisParametersIDWhere(synthesiscutterlocation.getSynthesisParametersID());
                toolReplace.setToolIDWhere(synthesiscutterlocation.getToolCode());
                synthesiscutterlocation.setReplaceCodes((List<ToolReplace>) toolReplaceDao.searchByList(toolReplace));
            }
            return list;
        } catch (SQLException e) {
            List<Synthesiscutterlocation> list = new ArrayList<Synthesiscutterlocation> ();
            Synthesiscutterlocation vdepartment = new Synthesiscutterlocation ();
            //错误消息：数据库操作异常，查询失败!
            vdepartment.setMessageCode ( IConstant.EMSG0004 );
            vdepartment.setRetErrFlag ( true );
            vdepartment.setExceMessage ( e.getMessage () );
            list.add ( vdepartment );
            return list;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> checkInput(Map<String, Object> param, String uploadFileName, File upload, String langCode, String langValue, String userID, int checkType) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        // 合成刀参数
        Synthesisparameters entity = new Synthesisparameters ();
        Map<String, String> map = new HashMap<String, String> ();
        try {
            //图片类型
            if (StringUtils.isEmpty ( uploadFileName )) {
            } else {
                String str = uploadFileName.substring ( uploadFileName.lastIndexOf ( "." ) + 1 );
                //					if(" .jpg .jpeg .gif .png .bmp".indexOf(str)==-1){
                //						map.put("Div",MessageReSource.getMessageBox(
                //								IConstant.EWMSG0262, langCode, langValue));
                //					}
            }
            // 组成类型
            if (StringUtils.isEmpty ( param.get ( "DivCreateType" ).toString () )) {
                //请选择组成类型
                map.put ( "DivCreateType", MessageReSource.getMessageBox ( IConstant.WMSG0180, langCode, langValue ) );
            } else {
                entity.setCreateType ( param.get ( "DivCreateType" ).toString () );
            }
            // 2017/09/8 宋健 变更↓↓↓　dazhong@YMSC
            // 定额加工量
//            if (StringUtils.isEmpty ( param.get ( "DivQuotaProcessingVolume" ).toString () )) {
//                //请输入定额加工量
//                map.put ( "DivQuotaProcessingVolume", MessageReSource.getMessageBox ( IConstant.WMSG0078, langCode, langValue ) );
//            } else if (!checkOutNum ( param.get ( "DivQuotaProcessingVolume" ).toString () )) {
//                //定额加工量应为数字!
//                map.put ( "DivQuotaProcessingVolume", MessageReSource.getMessageBox ( IConstant.WMSG0079, langCode, langValue ) );
//            } else if (new BigDecimal ( param.get ( "DivQuotaProcessingVolume" ).toString () ).compareTo ( BigDecimal.ZERO ) != 1) {//如果不大于0
//                //定额加工量应该大于0!
//                map.put ( "DivQuotaProcessingVolume", "定额加工量应该大于0!" );
//            } else {
//                entity.setQuotaProcessingVolume ( new BigDecimal ( param.get ( "DivQuotaProcessingVolume" ).toString () ) );
//            }
            // 2017/09/8 宋健 变更↑↑↑　dazhong@YMSC
            // 合成刀具编码
            if (checkType == 1)
                if (StringUtils.isEmpty ( param.get ( "DivSynthesisParametersCode" ).toString () )) {
                    map.put ( "DivSynthesisParametersCode", MessageReSource.getMessageBox ( IConstant.WMSG0094, langCode, langValue ) );
                } else {
                    Synthesisparameters synthesisparameters = new Synthesisparameters ();
                    synthesisparameters.setSynthesisParametersCode ( param.get ( "DivSynthesisParametersCode" ).toString () );
                    synthesisparameters.setDelFlag ( IConstant.DEL_FLAG_0 );
                    List<Synthesisparameters> list = (List<Synthesisparameters>) synthesisparametersDao.searchByList ( synthesisparameters );
                    if (list.size () > 0) {
                        //消息：您所新建的合成刀具编码已存在!WMSG0182
                        map.put ( "DivSynthesisParametersCode", MessageReSource.getMessageBox ( IConstant.WMSG0182, langCode, langValue ) );
                    }
                    entity.setSynthesisParametersCode ( param.get ( "DivSynthesisParametersCode" ).toString () );

                }
            // 位置数
            if (StringUtils.isEmpty ( param.get ( "DivSynthesisCount" ).toString () )) {
            } else {
                entity.setSynthesisCount ( new BigDecimal ( param.get ( "DivSynthesisCount" ).toString () ) );
            }
            // 合成刀位置
            List<Synthesiscutterlocation> synList = new ArrayList<Synthesiscutterlocation> ();
            // 位置数
            if (!StringUtils.isEmpty ( entity.getSynthesisCount () + "" )) {
                int length = entity.getSynthesisCount ().intValue ();
                for (int i = 0; i < length; i++) {
                    Synthesiscutterlocation syn = new Synthesiscutterlocation ();
                    if (param.get ( "DivCutterType[" + i + "]" ) == null) {
                        param.put ( "DivCutterType[" + i + "]", "" );
                    }
                    //位置类型
                    if (StringUtils.isEmpty ( param.get ( "DivCutterType[" + i + "]" ).toString () )) {
                        //请选择位置类型!
                        map.put ( "DivCutterType[" + i + "]", MessageReSource.getMessageBox ( IConstant.WMSG0183, langCode, langValue ) );
                    } else {
                        syn.setCutterType ( param.get ( "DivCutterType[" + i + "]" ).toString () );
                    }
                    // 位置号
                    if (param.get ( "DivSynthesisCutterNumber[" + i + "]" ) == null) {
                        param.put ( "DivSynthesisCutterNumber[" + i + "]", "" );
                    }
                    if (StringUtils.isEmpty ( param.get ( "DivSynthesisCutterNumber[" + i + "]" ).toString () )) {
                        map.put ( "DivSynthesisCutterNumber[" + i + "]", MessageReSource.getMessageBox ( IConstant.WMSG0096, langCode, langValue ) );
                    } else if (checkOutNum ( param.get ( "DivSynthesisCutterNumber[" + i + "]" ).toString () )) {
                        syn.setSynthesisCutterNumber ( new BigDecimal ( param.get ( "DivSynthesisCutterNumber[" + i + "]" ).toString () ) );
                    } else {
                        map.put ( "DivSynthesisCutterNumber[" + i + "]", MessageReSource.getMessageBox ( IConstant.WMSG0110, langCode, langValue ) );
                    }
                    // 刀具编码
                    if (param.get ( "DivToolCode[" + i + "]" ) == null) {
                        param.put ( "DivToolCode[" + i + "]", "" );
                    }
                    if (StringUtils.isEmpty ( param.get ( "DivToolCode[" + i + "]" ).toString () )) {
                        map.put ( "DivToolCode[" + i + "]", MessageReSource.getMessageBox ( IConstant.WMSG0055, langCode, langValue ) );
                    } else {
                        syn.setToolCode ( param.get ( "DivToolCode[" + i + "]" ).toString () );
                        Tool tool = new Tool ();
                        tool.setToolCode ( param.get ( "DivToolCode[" + i + "]" ).toString () );
                        tool.setToolType ( param.get ( "DivCutterType[" + i + "]" ).toString () );
                        //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
                        tool.setDelFlag(IConstant.DEL_FLAG_0);
                        //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
                        List<Tool> list = (List<Tool>) toolDao.searchByList ( tool );
                        if (list.size () < 1) {
                            //消息：该刀具编号尚不存在，请在刀具参数中设置！
                            map.put ( "DivToolCode[" + i + "]", MessageReSource.getMessageBox ( IConstant.WMSG0184, langCode, langValue ) );
                        }
                    }
                    // 替换刀具编码
                    if (param.get ( "DivTempToolCode[" + i + "]" ) == null) {
                        param.put ( "DivTempToolCode[" + i + "]", "" );
                    }
                    if (StringUtils.isEmpty ( param.get ( "DivTempToolCode[" + i + "]" ).toString () )) {
                    /*	map.put("DivTempToolCode["+i+"]", MessageReSource.getMessageBox(
                                IConstant.WMSG0097, langCode, langValue));*/
                        syn.setTempToolCode ( "" );
                    } else {
                        syn.setTempToolCode ( param.get ( "DivTempToolCode[" + i + "]" ).toString () );
                        Tool tool = new Tool ();
                        tool.setToolCode ( param.get ( "DivTempToolCode[" + i + "]" ).toString () );
                        tool.setToolType ( param.get ( "DivCutterType[" + i + "]" ).toString () );
                        //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
                        tool.setDelFlag(IConstant.DEL_FLAG_0);
                        //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
                        List<Tool> list = (List<Tool>) toolDao.searchByList ( tool );
                        if (list.size () < 1) {
                            //消息：该刀具编号尚不存在，请在刀具参数中设置！
                            map.put ( "DivTempToolCode[" + i + "]", MessageReSource.getMessageBox ( IConstant.WMSG0184, langCode, langValue ) );
                        }
                        List<ToolReplace> toolReplaces = new ArrayList<>();
                        ToolReplace toolReplace = new ToolReplace();
                        toolReplace.setRepalceToolCode( param.get ( "DivTempToolCode[" + i + "]" ).toString () );
                        toolReplaces.add(toolReplace);
                        syn.setReplaceCodes(toolReplaces);
                    }
                    synList.add ( syn );
                }
            }

            if (checkType == 1) {// 如果是新增

                if (map.size () <= 0) {
                    // 合成刀具编码
                    entity.setSynthesisParametersID ( NextKeyValue.getNextkeyvalue ( IConstant.SYNTHESISPARAMETERS, IConstant.SYNTHESISPARAMETERSID, entity.getUpdateUser () ) );// 取得主键
                    entity.setCreateTime ( new Date () );// 创建时间
                    entity.setCreateUser ( userID );// 创建者
                    entity.setUpdateTime ( new Date () );// 更新时间
                    entity.setUpdateUser ( userID );// 更新者
                    entity.setDelFlag ( IConstant.DEL_FLAG_0 );//删除区分
                    entity.setVersion ( BigDecimal.ZERO );// 版本号
                    for (Synthesiscutterlocation location : synList) {
                        location.setCreateTime ( new Date () );// 创建时间
                        location.setCreateUser ( userID );// 创建者
                        location.setUpdateTime ( new Date () );// 更新时间
                        location.setDelFlag ( IConstant.DEL_FLAG_0 );//删除区分
                        location.setUpdateUser ( userID );// 更新者
                        location.setVersion ( BigDecimal.ZERO );// 版本号
                    }
                    rtn.put ( "synList", synList );
                    rtn.put ( "data", entity );
                } else {
                    rtn.put ( "message", map );
                }

            } else if (checkType == 2) {
                // 2017/09/5 宋健 变更↓↓↓　dazhong@YMSC
                Synthesiscutterlocation syn = new Synthesiscutterlocation();
                syn.setSynthesisParametersID(param.get("DivSynthesisParametersID").toString());
                syn.setCutterType(param.get("DivCutterType[0]").toString());
                try {
                    synthesiscutterlocationDao.updateById(syn);
                }catch (Exception e){

                }
                // 2017/09/5 宋健 变更↑↑↑　dazhong@YMSC
                // 如果是编辑
                if (map.size () <= 0) {
                    entity.setUpdateUser ( userID );
                    entity.setUpdateTime ( new Date () );
                    entity.setVersion ( new BigDecimal ( param.get ( "DivVersion" ).toString () ).add ( BigDecimal.ONE ) );
                    entity.setVersionWhere ( new BigDecimal ( param.get ( "DivVersion" ).toString () ) );
                    entity.setSynthesisParametersID ( param.get ( "DivSynthesisParametersID" ).toString () );
                    entity.setSynthesisParametersIDWhere ( param.get ( "DivSynthesisParametersID" ).toString () );
                    entity.setDelFlag ( IConstant.DEL_FLAG_0 );//删除区分
                    for (Synthesiscutterlocation location : synList) {
                        // 删除区分
                        location.setCreateTime ( new Date () );// 创建时间
                        location.setCreateUser ( userID );// 创建者
                        location.setUpdateTime ( new Date () );// 更新时间
                        location.setUpdateUser ( userID );// 更新者
                        location.setVersion ( BigDecimal.ZERO );// 版本号
                        location.setDelFlag ( IConstant.DEL_FLAG_0 );//删除区分
                        location.setSynthesisParametersID ( entity.getSynthesisParametersID () );
                        location.setSynthesisParametersIDWhere ( entity.getSynthesisParametersID () );
                        location.setToolCodeWhere ( location.getToolCode () );
                        location.setSynthesisCutterNumberWhere ( location.getSynthesisCutterNumber () );
                    }
                    rtn.put ( "data", entity );
                    rtn.put ( "synList", synList );
                } else {
                    rtn.put ( "message", map );
                }

            }
            rtn.put ( "status", IConstant.RESULT_CODE_2 );
            return rtn;
        } catch (SQLException e) {
            Synthesisparameters entity1 = new Synthesisparameters ();
            //错误消息：数据库操作异常，查询失败!
            entity1.setMessageCode ( IConstant.EMSG0004 );
            entity1.setRetErrFlag ( true );
            entity1.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity1 );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    /**
     * 获取设备名称信息
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Equipment> getEquipment(Equipment entity) {
        try {

            List<Equipment> list = (List<Equipment>) equipmentDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Equipment> ();
                Equipment vdepartment = new Equipment ();
                vdepartment.setMessageCode ( IConstant.WMSG0008 );
                vdepartment.setRetErrFlag ( false );
                list.add ( vdepartment );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Equipment> list = new ArrayList<Equipment> ();
            Equipment vdepartment = new Equipment ();
            //错误消息：数据库操作异常，查询失败!
            vdepartment.setMessageCode ( IConstant.EMSG0004 );
            vdepartment.setRetErrFlag ( true );
            vdepartment.setExceMessage ( e.getMessage () );
            list.add ( vdepartment );
            return list;
        }
    }

    /**
     * 获取零部件信息
     *
     * @param
     * @param
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Parts> getParts(Parts entity) {
        try {

            List<Parts> list = (List<Parts>) partsDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Parts> ();
                Parts vdepartment = new Parts ();
                vdepartment.setMessageCode ( IConstant.WMSG0008 );
                vdepartment.setRetErrFlag ( true );
                list.add ( vdepartment );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Parts> list = new ArrayList<Parts> ();
            Parts vdepartment = new Parts ();
            //错误消息：数据库操作异常，查询失败!
            vdepartment.setMessageCode ( IConstant.EMSG0004 );
            vdepartment.setRetErrFlag ( true );
            vdepartment.setExceMessage ( e.getMessage () );
            list.add ( vdepartment );
            return list;
        }
    }
}
