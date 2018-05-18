package com.icomp.v01b09.b09s002.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b09.s002.ICOMPV01B09S002Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.Files;
import com.icomp.entity.base.*;
import com.icomp.v01b09.b09s002.business.B09S002Business;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B09S002BusinessImpl implements B09S002Business {
    /**
     * 系统初始化Service
     */
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01B09S002Service iCOMPV01B09S002Service;

    public void setiCOMPV01B09S002Service(ICOMPV01B09S002Service iCOMPV01B09S002Service) {
        this.iCOMPV01B09S002Service = iCOMPV01B09S002Service;
    }

    // 合成刀具参数列表
    @SuppressWarnings("unchecked")
    public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        Synthesisparameters entity = new Synthesisparameters ();
        // 查询条件--合成刀具编码
        entity.setSynthesisParametersCode ( StringUtils.isEmpty ( param.get ( "SynthesisParametersCode" ).toString () ) ? null : param.get ( "SynthesisParametersCode" ).toString () );
        // 删除区分
        //		entity.setDelFlag(StringUtils.isEmpty(param.get("DelFlag").toString())?null:param.get("DelFlag").toString());
        // 分页起始行数
        entity.setStaIndex ( (Integer.parseInt ( param.get ( "page" ).toString () ) - 1) * IConstant.ROWSIZE );
        // 分页页数
        entity.setRowCount ( Integer.parseInt ( param.get ( "rows" ).toString () ) );
        // 排序
        entity.setOrderString ( "SynthesisParametersCode" );
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        // 查询-SynthesisParametersCode模糊查询
        Map<String, Object> rtn = iCOMPV01B09S002Service.getList ( entity );
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Synthesisparameters>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return rtn;
    }

    /**
     * 取得系统区分列表
     *
     * @param flagType 区分定义名称
     * @return
     * @throws BusinessException
     */
    public List<Comlist> getComList(String flagType, String langCode, String langValue) throws BusinessException {
        Comlist entity = new Comlist ();
        entity.setComListType ( flagType );
        entity.setLanguageCode ( langCode );
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Comlist> list = service.getComList ( entity );
        if (list.size () == 1 && list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return list;
    }

    /**
     * 新建合成刀具参数信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> synthesisAdd(Map<String, Object> param, String savePath, String uploadFileName, File upload, String langCode, String customerID, String langValue) throws BusinessException {
        // 合成刀具参数输入验证
        Map<String, Object> ret = iCOMPV01B09S002Service.checkInput ( param, uploadFileName, upload, langCode, langValue, customerID, 1 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            throw new BusinessException ( ((Synthesisparameters) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        } else if (ret.size () > 1 && ret.get ( "message" ) != null) {
            return ret;
        }
        //合成刀参数
        Synthesisparameters entity = (Synthesisparameters) ret.get ( "data" );
        // 合成刀位置
        List<Synthesiscutterlocation> synList = (List<Synthesiscutterlocation>) ret.get ( "synList" );
        try {
            if (!StringUtils.isEmpty ( uploadFileName )) {
                String fileType = uploadFileName.substring ( uploadFileName.lastIndexOf ( "." ) + 1, uploadFileName.length () );
                //			String fileName=entity.getSynthesisParametersID()+"-"+entity.getVersion()+"."+fileType;
                String a[] = uploadFileName.split ( "[.]" );

                String fileName = a[0] + new Date ().getTime () + "." + fileType;
                Files.fileUpload ( savePath + "//b09s002//" + entity.getSynthesisParametersID (), fileName, upload );
                entity.setToolPic ( fileName );
            }
        } catch (IOException e) {
            //上传文件失败
            throw new BusinessException ( IConstant.WMSG0112, langCode, langValue );
        }
        // 保存合成刀具参数信息
        ret = iCOMPV01B09S002Service.synthesisAdd ( entity, synList, langCode, langValue );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 新建失败时，返回
            throw new BusinessException ( ((Synthesisparameters) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 删除合成刀具参数信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> synthesisDelete(Map<String, Object> param, String langCode, String userID, String langValue) {

        Synthesisparameters entity = new Synthesisparameters ();
        //删除区分设为“1”
        entity.setDelFlag ( IConstant.DEL_FLAG_1 );
        entity.setUpdateTime ( new Date () );
        entity.setUpdateUser ( userID );
        entity.setSynthesisParametersCodeWhere ( param.get ( "SynthesisParametersCode" ).toString () );
        entity.setUpdateTimeWhere ( Ctl.strToDate ( param.get ( "updatetime" ).toString ().replace ( "T", " " ) ) );
        //版本号
        entity.setVersion ( new BigDecimal ( param.get ( "version" ).toString () ).add ( BigDecimal.ONE ) );
        //更新条件:版本号
        entity.setVersionWhere ( new BigDecimal ( param.get ( "version" ).toString () ) );
        //更新条件:更新者
        entity.setUpdateUserWhere ( param.get ( "updateuser" ).toString () );
        Map<String, Object> ret = iCOMPV01B09S002Service.synthesisDelete ( entity, langCode, langValue );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 删除失败时，返回
            throw new BusinessException ( ((Synthesisparameters) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 编辑 合成刀具参数
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> synthesisEdit(Map<String, Object> param, String savePath, String uploadFileName, File upload, String userID, String langCode, String langValue) throws BusinessException {
        Map<String, Object> ret = new HashedMap();
        //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
//        if("4".equals(param.get("DivCreateType").toString())){
//
//        }else {
        //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
            // 用户输入验证
            ret = iCOMPV01B09S002Service.checkInput(param, uploadFileName, upload, langCode, langValue, userID, 2);
            if (ret.size() > 1 && ret.get("error") != null) {
                throw new BusinessException(((Synthesisparameters) ret.get("error")).getMessageCode(), langCode, langValue);
            } else if (ret.size() > 1 && ret.get("message") != null) {
                return ret;
            }
//        }
        // 合成刀位置
        List<Synthesiscutterlocation> synList = (List<Synthesiscutterlocation>) ret.get ( "synList" );
        Synthesisparameters entity = (Synthesisparameters) ret.get ( "data" );
        try {
            if (!StringUtils.isEmpty ( uploadFileName )) {
                String fileType = uploadFileName.substring ( uploadFileName.lastIndexOf ( "." ) + 1, uploadFileName.length () );
                //			String fileName=entity.getSynthesisParametersID()+"."+fileType;

                String a[] = uploadFileName.split ( "[.]" );

                String fileName = a[0] + new Date ().getTime () + "." + fileType;
                Files.fileUpload ( savePath + "//b09s002//" + entity.getSynthesisParametersID (), fileName, upload );
                entity.setToolPic ( fileName );
            }
        } catch (IOException e) {
            //上传文件失败
            throw new BusinessException ( IConstant.WMSG0112, langCode, langValue );
        }
            ret = iCOMPV01B09S002Service.synthesisEdit ( entity, synList, langCode, langValue );
//        }
        // 2017/09/5 宋健 变更↑↑↑　dazhong@YMSC
        //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            //编辑失败时，返回
            throw new BusinessException ( ((Synthesisparameters) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }

        return ret;
    }

    /**
     * 取得合成刀具信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> synthesisInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        Map<String, Object> ret = new HashMap<String, Object> ();
        // 取得待编辑用户信息
        Synthesisparameters entity = new Synthesisparameters ();
        entity.setSynthesisParametersCode ( param.get ( "synthesisParametersCode" ).toString () );
        entity.setSynthesisParametersID ( param.get ( "synthesisParametersID" ).toString () );

        ret = iCOMPV01B09S002Service.synthesisInfo ( entity );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            //取得错误时，返回
            throw new BusinessException ( ((Languagetable) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;

    }

    /**
     * 取得合成刀具位置信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public List<Synthesiscutterlocation> synthesisLocationInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        // 取得合成刀具位置信息
        Synthesiscutterlocation entity = new Synthesiscutterlocation ();
        entity.setSynthesisParametersID ( param.get ( "synthesisParametersID" ).toString () );

        List<Synthesiscutterlocation> list = iCOMPV01B09S002Service.synthesisLocationInfo ( entity );
        if (list.size () == 1 && list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return list;
    }

    /**
     * 获取设备名称信息
     *
     * @param dELFLAG
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Object getEquipmentNameList(String dELFLAG, String langCode, String langValue) {
        Equipment entity = new Equipment ();
        List<Equipment> list = iCOMPV01B09S002Service.getEquipment ( entity );
        if (list.size () == 1 && list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return list;
    }

    public Object getPartsNameList(String dELFLAG, String langCode, String langValue) {
        Parts entity = new Parts ();
        List<Parts> list = iCOMPV01B09S002Service.getParts ( entity );
        if (list.size () == 1 && list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return list;
    }

    /**
     * 取得页面grid显示项目列表
     *
     * @param pageID
     * @param langValue
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getGridColmun(String pageID, String userID, String langCode, String langValue) throws BusinessException {

        // 取得页面grid显示项目列表
        Map<String, Object> ret = service.getGridColmun ( pageID, langCode, IConstant.ITEM_TYPE_1 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 取得失败时，返回
            throw new BusinessException ( ((List<Displayeditemconfiguration>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

}
