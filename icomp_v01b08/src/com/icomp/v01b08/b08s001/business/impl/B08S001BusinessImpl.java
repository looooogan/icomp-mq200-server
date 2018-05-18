package com.icomp.v01b08.b08s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s001.ICOMPV01B08S001Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Position;
import com.icomp.v01b08.b08s001.business.B08S001Business;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B08S001BusinessImpl implements B08S001Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01B08S001Service iCOMPV01B08S001Service;

    public void setiCOMPV01B08S001Service(ICOMPV01B08S001Service iCOMPV01B08S001Service) {
        this.iCOMPV01B08S001Service = iCOMPV01B08S001Service;
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
     * 取得用户信息列表
     *
     * @param param 页面检索条件
     * @param langCode  语言编码
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        // 设置检索条件
        Capability entity = new Capability ();
        entity.setCapabilityLevel ( BigDecimal.ONE );
        if (param.get ( "nodeid" ) != null) {
            entity.setCapCapabilityID ( "".equals ( param.get ( "nodeid" ).toString () ) ? null : param.get ( "nodeid" ).toString () );
            entity.setOrderString ( "CapabilityOrder" );
        } else {
            entity.setOrderString ( "BelongFlag,CapabilityOrder" );
        }
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        if (param.get ( "n_lvevl" ) != null && !"".equals ( param.get ( "n_lvevl" ).toString () )) {
            entity.setCapabilityLevel ( new BigDecimal ( param.get ( "n_lvevl" ).toString () ) );
        }
        // 排序
        entity.setOrderString ( "CapabilityID" );
        Map<String, Object> rtn = iCOMPV01B08S001Service.getList ( entity );
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Capability>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return rtn;
    }

    /**
     * 取得用户信息列表
     *
     * @param param 页面检索条件
     * @param langCode  语言编码
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getCapabilityIDList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        // 设置检索条件
        Capability entity = new Capability ();
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        Map<String, Object> rtn = iCOMPV01B08S001Service.getList ( entity );
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Capability>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return rtn;
    }

    /**
     * 取得功能信息列表
     *
     * @param param 页面检索条件
     * @param langCode  语言编码
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getCapabilityList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        // 取得功能项目列表
        Capability entity = new Capability ();
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        Map<String, Object> rtn = iCOMPV01B08S001Service.getCapabilityList ( entity, langCode );
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Capability>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return rtn;
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
    public Map<String, Object> getGridColmun(String pageID, String langValue, String userID, String langCode) throws BusinessException {

        // 取得页面grid显示项目列表
        Map<String, Object> ret = service.getGridColmun ( pageID, langCode, IConstant.ITEM_TYPE_1 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 取得失败时，返回
            throw new BusinessException ( ((List<Displayeditemconfiguration>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 取得待编辑的角色信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> capabilityInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        Capability capability = new Capability ();
        capability.setDelFlag ( IConstant.DEL_FLAG_0 );
        if ("addNode".equals ( param.get ( "opt" ) )) {// 新建子节点，根据所选功能进行建立
            capability.setCapabilityID ( StringUtils.isEmpty ( param.get ( "DivCapabilityID" ).toString () ) ? null : param.get ( "DivCapabilityID" ).toString () );
        } else if ("addRoot".equals ( param.get ( "opt" ) )) {// 新建根节点，根据最大顺序进行建立
            capability.setCapabilityLevel ( BigDecimal.ONE );
            capability.setBelongFlag ( StringUtils.isEmpty ( param.get ( "DIV_BelongFlag" ).toString () ) ? null : param.get ( "DIV_BelongFlag" ).toString () );
            capability.setOrderString ( "CapabilityOrder desc" );
        } else if ("addSUB".equals ( param.get ( "opt" ) )) {// 新建子节点，根据最大顺序进行建立
            capability = new Capability ();
            if (param.get ( "DivCapabilityID" ) == null) {
                param.put ( "DivCapabilityID", "" );
            }
            capability.setCapCapabilityID ( StringUtils.isEmpty ( param.get ( "DivCapabilityID" ).toString () ) ? null : param.get ( "DivCapabilityID" ).toString () );
            capability.setStates ( "CapabilityID != CapCapabilityID" );
            capability.setOrderString ( "CapabilityOrder desc" );
        } else if ("reflash".equals ( param.get ( "opt" ) )) {// 新建子节点，根据最大顺序进行建立
            capability = new Capability ();
        } else {// 编辑取得
            capability.setCapabilityID ( StringUtils.isEmpty ( param.get ( "DivCapabilityID" ).toString () ) ? null : param.get ( "DivCapabilityID" ).toString () );
        }
        Map<String, Object> ret = new HashMap<String, Object> ();
        ret = iCOMPV01B08S001Service.getCapablitiyInfo ( capability );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((Capability) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 删除功能信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> capabilityDelete(Map<String, Object> param, String langValue, String userID, String langCode) throws BusinessException {

        Capability capability = new Capability ();
        capability.setDelFlag ( IConstant.DEL_FLAG_1 );
        capability.setUpdateTime ( new Date () );
        capability.setUpdateUser ( userID );
        capability.setVersion ( new BigDecimal ( param.get ( "version" ).toString () ).add ( BigDecimal.ONE ) );
        capability.setCapabilityIDWhere ( param.get ( "capabilityID" ).toString () );
        capability.setUpdateTimeWhere ( Ctl.strToDate ( param.get ( "updatetime" ).toString ().replace ( "T", " " ) ) );
        capability.setUpdateUserWhere ( param.get ( "updateuser" ).toString () );
        capability.setVersionWhere ( new BigDecimal ( param.get ( "version" ).toString () ) );
        Map<String, Object> ret = iCOMPV01B08S001Service.capablitiyDelete ( capability, langCode, langValue );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 删除失败时，返回
            throw new BusinessException ( ((Capability) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 新建功能信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> capabilityAdd(Map<String, Object> param, String langValue, String userID, String langCode) throws BusinessException {
        // 用户输入验证
        Map<String, Object> ret = iCOMPV01B08S001Service.checkInput ( param, langCode, langValue, userID, 1 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            throw new BusinessException ( ((Position) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        } else if (ret.size () > 1 && ret.get ( "message" ) != null) {
            return ret;
        }
        Capability capability = new Capability ();
        capability.setDelFlag ( param.get ( "DIV_DelFlag" ).toString () );
        capability.setLanguageCode ( param.get ( "DIV_LanguageCode" ).toString () );
        capability.setCapabilityCode ( param.get ( "DIV_CapabilityCode" ).toString () );
        capability.setCapabilityLevel ( new BigDecimal ( param.get ( "DIV_CapabilityLevel" ).toString () ) );
        capability.setCapabilityOrder ( new BigDecimal ( param.get ( "DIV_CapabilityOrder" ).toString () ) );
        capability.setCapabilityName ( param.get ( "DIV_CapabilityName" ).toString () );
        capability.setBelongFlag ( param.get ( "DIV_BelongFlag" ).toString () );
        capability.setCapabilityUrl ( param.get ( "DIV_CapabilityUrl" ).toString () );
        capability.setCapabilityImg ( param.get ( "DIV_CapabilityImg" ).toString () );
        capability.setMenuFlag ( param.get ( "DIV_MenuFlag" ).toString () );
        capability.setUpdateTime ( new Date () );
        capability.setUpdateUser ( userID );
        capability.setCreateTime ( new Date () );
        capability.setCreateUser ( userID );
        capability.setVersion ( new BigDecimal ( param.get ( "DivVersion" ).toString () ) );
        if ("addNode".equals ( param.get ( "opt" ) )) {// 新建子节点，根据所选功能进行建立
            capability.setCapCapabilityID ( param.get ( "DivCapabilityID" ).toString () );
        }
        // 保存功能信息
        ret = iCOMPV01B08S001Service.capablitiyAdd ( capability, langCode, langValue );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 新建失败时，返回
            throw new BusinessException ( ((Capability) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 编辑功能信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> capabilityEdit(Map<String, Object> param, String langValue, String userID, String langCode) throws BusinessException {
        // 用户输入验证
        Map<String, Object> ret = iCOMPV01B08S001Service.checkInput ( param, langCode, langValue, userID, 2 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            throw new BusinessException ( ((Position) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        } else if (ret.size () > 1 && ret.get ( "message" ) != null) {
            return ret;
        }
        Capability capability = new Capability ();
        capability.setDelFlag ( param.get ( "DIV_DelFlag" ).toString () );
        capability.setLanguageCode ( param.get ( "DIV_LanguageCode" ).toString () );
        capability.setCapabilityCode ( param.get ( "DIV_CapabilityCode" ).toString () );
        capability.setCapabilityName ( param.get ( "DIV_CapabilityName" ).toString () );
        capability.setBelongFlag ( param.get ( "DIV_BelongFlag" ).toString () );
        capability.setCapabilityUrl ( param.get ( "DIV_CapabilityUrl" ).toString () );
        capability.setCapabilityImg ( param.get ( "DIV_CapabilityImg" ).toString () );
        capability.setMenuFlag ( param.get ( "DIV_MenuFlag" ).toString () );
        capability.setUpdateTime ( new Date () );
        capability.setUpdateUser ( userID );
        capability.setVersion ( new BigDecimal ( param.get ( "DivVersion" ).toString () ).add ( BigDecimal.ONE ) );
        capability.setCapabilityIDWhere ( param.get ( "DivCapabilityID" ).toString () );
        capability.setUpdateTimeWhere ( Ctl.strToDate ( param.get ( "DivUpdateTime" ).toString ().replace ( "T", " " ) ) );
        capability.setUpdateUserWhere ( param.get ( "DivUpdateUser" ).toString () );
        capability.setVersionWhere ( new BigDecimal ( param.get ( "DivVersion" ).toString () ) );
        // 保存功能信息
        ret = iCOMPV01B08S001Service.capablitiyEdit ( capability, langCode, langValue );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 新建失败时，返回
            throw new BusinessException ( ((Capability) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

}
