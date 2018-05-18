package com.icomp.common.service.impl;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.System;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class  CommonServiceImpl extends BaseService implements CommonService {

    /**
     * 用户信息Dao
     */
    private CustomerDao customerDao;

    private ToolDao toolDao;
    private EquipmentDao equipmentDao;
    private TooltransferhistoryDao tooltransferhistoryDao;
    private ToolwholelifecycleDao toolwholelifecycleDao;
    private SynthesisparametersDao synthesisparametersDao;
    private ContainercarrierDao containercarrierDao;
    private OnoffDao onoffDao;

    public void setOnoffDao(OnoffDao onoffDao) {
        this.onoffDao = onoffDao;
    }

    public void setContainercarrierDao(ContainercarrierDao containercarrierDao) {
        this.containercarrierDao = containercarrierDao;
    }

    public void setSynthesisparametersDao(SynthesisparametersDao synthesisparametersDao) {
        this.synthesisparametersDao = synthesisparametersDao;
    }

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    public void setEquipmentDao(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    private DisplayeditemconfigurationDao displayeditemconfigurationDao;

    public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
        this.displayeditemconfigurationDao = displayeditemconfigurationDao;
    }

    private VinventoryalarmDao vinventoryalarmDao;

    public void setVinventoryalarmDao(VinventoryalarmDao vinventoryalarmDao) {
        this.vinventoryalarmDao = vinventoryalarmDao;
    }

    @SuppressWarnings("unused")
    private BusinessflowDao businessflowDao;

    public void setBusinessflowDao(BusinessflowDao businessflowDao) {
        this.businessflowDao = businessflowDao;
    }

    private SubToolProcessAmountDao subToolProcessAmountDao;

    public void setSubToolProcessAmountDao(SubToolProcessAmountDao subToolProcessAmountDao) {
        this.subToolProcessAmountDao = subToolProcessAmountDao;
    }

    private SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao;

    public void setSubToolAvgToolSharpennumDao(SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao) {
        this.subToolAvgToolSharpennumDao = subToolAvgToolSharpennumDao;
    }

    /**
     * 用户Dao
     */
    private VcustomerDao vcustomerDao;

    public void setVcustomerDao(VcustomerDao vcustomerDao) {
        this.vcustomerDao = vcustomerDao;
    }

    /* 语言Dao */
    private LanguagetableDao languagetableDao;

    /**
     * 语言Dao 设定
     *
     * @param languagetableDao
     */
    public void setLanguagetableDao(LanguagetableDao languagetableDao) {
        this.languagetableDao = languagetableDao;
    }

    /* 系统区分Dao */
    private ComlistDao comlistDao;

    /**
     * 系统区分Dao 设定
     *
     * @param
     */
    public void setComlistDao(ComlistDao comlistDao) {
        this.comlistDao = comlistDao;
    }

    /**
     * 结构取得Dao
     */
    private VagencyDao vagencyDao;

    public void setVagencyDao(VagencyDao vagencyDao) {
        this.vagencyDao = vagencyDao;
    }

    /**
     * 结构取得Dao
     */
    private VdepartmentDao vdepartmentDao;

    public void setVdepartmentDao(VdepartmentDao vdepartmentDao) {
        this.vdepartmentDao = vdepartmentDao;
    }

    /**
     * 结构取得Dao
     */
    private VpositionDao vpositionDao;

    public void setVpositionDao(VpositionDao vpositionDao) {
        this.vpositionDao = vpositionDao;
    }

    /**
     * 流水线名称取得Dao
     */
    private AssemblylineDao assemblylineDao;

    public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
        this.assemblylineDao = assemblylineDao;
    }

    /**
     * 工序名称取得Dao
     */
    private VprocessDao vprocessDao;

    public void setVprocessDao(VprocessDao vprocessDao) {
        this.vprocessDao = vprocessDao;
    }

    /**
     * 设备名称取得Dao
     */
    private VequipmentDao vequipmentDao;

    public void setVequipmentDao(VequipmentDao vequipmentDao) {
        this.vequipmentDao = vequipmentDao;
    }

    /**
     * 流程名取得Dao
     */
    private VbusinessDao vbusinessDao;

    public void setVbusinessDao(VbusinessDao vbusinessDao) {
        this.vbusinessDao = vbusinessDao;
    }

    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    private SynthesisknifeDao synthesisknifeDao;

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    private VgetpositioncapabilityDao vgetpositioncapabilityDao;

    public void setVgetpositioncapabilityDao(VgetpositioncapabilityDao vgetpositioncapabilityDao) {
        this.vgetpositioncapabilityDao = vgetpositioncapabilityDao;
    }

    //查询合成刀具走过的流程
    private VgetsynthesisexperienceDao vgetsynthesisexperienceDao;

    public void setVgetsynthesisexperienceDao(VgetsynthesisexperienceDao vgetsynthesisexperienceDao) {
        this.vgetsynthesisexperienceDao = vgetsynthesisexperienceDao;
    }

    private UserdetailDao userdetailDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
    private VsynthesisconditionDao vsynthesisconditionDao;

    public void setVsynthesisconditionDao(VsynthesisconditionDao vsynthesisconditionDao) {
        this.vsynthesisconditionDao = vsynthesisconditionDao;
    }

    private SynthesiscutterlocationDao synthesiscutterlocationDao;

    public void setSynthesiscutterlocationDao(SynthesiscutterlocationDao synthesiscutterlocationDao) {
        this.synthesiscutterlocationDao = synthesiscutterlocationDao;
    }

    private ToolsmachiningDao toolsmachiningDao;

    public void setToolsmachiningDao(ToolsmachiningDao toolsmachiningDao) {
        this.toolsmachiningDao = toolsmachiningDao;
    }

    private SynthesistoolsmachiningDao synthesistoolsmachiningDao;

    public void setSynthesistoolsmachiningDao(SynthesistoolsmachiningDao synthesistoolsmachiningDao) {
        this.synthesistoolsmachiningDao = synthesistoolsmachiningDao;
    }

    private ToolnoticehistoryDao toolnoticehistoryDao;

    public void setToolnoticehistoryDao(ToolnoticehistoryDao toolnoticehistoryDao) {
        this.toolnoticehistoryDao = toolnoticehistoryDao;
    }



    //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC

    private AuthorizationDao authorizationDao;
    private PartsDao partsDao;
    private FormulasDao formulasDao;

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }

    public void setFormulasDao(FormulasDao formulasDao) {
        this.formulasDao = formulasDao;
    }

    public void setAuthorizationDao(AuthorizationDao authorizationDao) {
        this.authorizationDao = authorizationDao;
    }

    public static final String RETURN_ZERO = "0";
    public static final String RETURN_ONE = "1";
    public static final String RETURN_TWO = "2";
    public static final String RETURN_THREE = "3";
    public static final String RETURN_FOUR = "4";
    public static final String RETURN_FIVE = "5";
    /**
     * 显示合成刀具走过流程的条数
     */
    public static final int MAX_NUMBER = 5;

    /**
     * 取得系统默认语言
     *
     * @return 默认语言编码
     * @throws Exception 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    @SuppressWarnings("unchecked")
    public Languagetable getSystemDefaultLanguage() {
        Languagetable entity = new Languagetable ();
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        try {
            final List<Languagetable> list = (List<Languagetable>) languagetableDao.searchByList ( entity );
            if (list.size () <= 0) {
                entity = new Languagetable ();
                // 检索数据行数为0,检索失败!
                entity.setMessageCode ( IConstant.EMSG0001 );
                entity.setRetErrFlag ( true );
                return entity;
            } else {
                entity = list.get ( 0 );
                // 检索成功!
                entity.setMessageCode ( IConstant.IMSG0001 );
                return entity;
            }
        } catch (SQLException e) {
            entity = new Languagetable ();
            entity.setRetErrFlag ( true );
            // 数据库操作异常,查询失败!
            entity.setMessageCode ( IConstant.EMSG0004 );
            entity.setExceMessage ( e.getMessage () );
            return entity;
        }
    }

    /**
     * 取得系统语言列表
     *
     * @return 默认语言编码
     * @throws Exception 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    @SuppressWarnings("unchecked")
    public List<Languagetable> getSystemListLanguage() {
        Languagetable entity = new Languagetable ();
        try {

            List<Languagetable> list = (List<Languagetable>) languagetableDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 语言列表取得失败!
                list = new ArrayList<Languagetable> ();
                Languagetable vgrant = new Languagetable ();
                vgrant.setMessageCode ( IConstant.WMSG0005 );
                vgrant.setRetErrFlag ( true );
                list.add ( vgrant );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Languagetable> list = new ArrayList<Languagetable> ();
            Languagetable vgrant = new Languagetable ();
            vgrant.setMessageCode ( IConstant.EMSG0004 );
            vgrant.setRetErrFlag ( true );
            vgrant.setExceMessage ( e.getMessage () );
            list.add ( vgrant );
            return list;
        }
    }

    /**
     * 取得页面文本内容
     *
     * @param getType  取得类型
     * @param langCode 语言Code
     * @param pageID   页面ID
     * @param paraName 项目ID(未指定时则全取)
     * @return 页面文本内容 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    public Map<String, String> getPageLabelText(String getType, String langCode, String pageID, String paraName) {
        // 作成页面文本文件名
        String fileName = "language-" + getType;
        String[] codes = langCode.split ( "_" );
        Map<String, String> map = new HashMap<String, String> ();
        Locale locale = new Locale ( codes[0], codes.length > 1 ? codes[1] : StringUtils.EMPTY );
        ResourceBundle bundle = ResourceBundle.getBundle ( fileName, locale );
        for (String key : bundle.keySet ()) {
            String param = key.split ( "_" )[2];
            if (!StringUtils.isEmpty ( paraName )) {
                if (StringUtils.equals ( param, paraName )) {
                    map.put ( param, bundle.getString ( key ) );
                }
            } else {
                map.put ( param, bundle.getString ( key ) );
            }
        }
        return map;
    }

    /**
     * 取得系统区分列表
     *
     * @param entity 查询条件
     * @return 下拉列表内容 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    @SuppressWarnings("unchecked")
    public List<Comlist> getComList(Comlist entity) {
        try {
            List<Comlist> list = (List<Comlist>) comlistDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 区分列表取得失败!
                list = new ArrayList<Comlist> ();
                Comlist comlist = new Comlist ();
                comlist.setMessageCode ( IConstant.WMSG0007 );
                comlist.setRetErrFlag ( true );
                list.add ( comlist );
                return list;
            } else {
                return list;
            }
        } catch (SQLException e) {
            List<Comlist> list = new ArrayList<Comlist> ();
            Comlist comlist = new Comlist ();
            comlist.setMessageCode ( IConstant.EMSG0004 );
            comlist.setRetErrFlag ( true );
            comlist.setExceMessage ( e.getMessage () );
            list.add ( comlist );
            return list;
        }
    }

    /**
     * 取得Android端页面项目属性
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Displayeditemconfiguration> getContorllList(String langCode, String pageID, String itemType) {
        try {
            Displayeditemconfiguration entity = new Displayeditemconfiguration ();
            entity.setLanguageCode ( langCode );
            entity.setPageName ( pageID );
            entity.setItemType ( itemType );
            List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 区分列表取得失败!
                list = new ArrayList<Displayeditemconfiguration> ();
                Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration ();
                displayeditemconfiguration.setMessageCode ( IConstant.WMSG0007 );
                displayeditemconfiguration.setRetErrFlag ( true );
                list.add ( displayeditemconfiguration );
                return list;
            } else {
                return list;
            }
        } catch (SQLException e) {
            List<Displayeditemconfiguration> list = new ArrayList<Displayeditemconfiguration> ();
            Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration ();
            displayeditemconfiguration.setMessageCode ( IConstant.EMSG0004 );
            displayeditemconfiguration.setRetErrFlag ( true );
            displayeditemconfiguration.setExceMessage ( e.getMessage () );
            list.add ( displayeditemconfiguration );
            return list;
        }
    }

    /**
     * 取得组织结构信息列表
     *
     * @param entity 查询条件
     */
    @SuppressWarnings("unchecked")
    public List<Vagency> getVagency(Vagency entity) {
        try {

            List<Vagency> list = (List<Vagency>) vagencyDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Vagency> ();
                Vagency vagency = new Vagency ();
                vagency.setMessageCode ( IConstant.WMSG0008 );
                vagency.setRetErrFlag ( true );
                list.add ( vagency );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vagency> list = new ArrayList<Vagency> ();
            Vagency vagency = new Vagency ();
            vagency.setMessageCode ( IConstant.EMSG0004 );
            vagency.setRetErrFlag ( true );
            vagency.setExceMessage ( e.getMessage () );
            list.add ( vagency );
            return list;
        }
    }

    /**
     * 取得组织结构信息列表
     *
     * @param entity 查询条件
     */
    @SuppressWarnings("unchecked")
    public List<Vdepartment> getVdepartment(Vdepartment entity) {
        try {

            List<Vdepartment> list = (List<Vdepartment>) vdepartmentDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Vdepartment> ();
                Vdepartment vdepartment = new Vdepartment ();
                vdepartment.setMessageCode ( IConstant.WMSG0008 );
                vdepartment.setRetErrFlag ( false );
                list.add ( vdepartment );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vdepartment> list = new ArrayList<Vdepartment> ();
            Vdepartment vdepartment = new Vdepartment ();
            vdepartment.setMessageCode ( IConstant.EMSG0004 );
            vdepartment.setRetErrFlag ( true );
            vdepartment.setExceMessage ( e.getMessage () );
            list.add ( vdepartment );
            return list;
        }
    }

    /**
     * 取得组织结构信息列表
     *
     * @param entity 查询条件
     */
    @SuppressWarnings("unchecked")
    public List<Vposition> getVposition(Vposition entity) {
        try {

            List<Vposition> list = (List<Vposition>) vpositionDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Vposition> ();
                Vposition vposition = new Vposition ();
                vposition.setMessageCode ( IConstant.WMSG0008 );
                vposition.setRetErrFlag ( false );
                list.add ( vposition );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vposition> list = new ArrayList<Vposition> ();
            Vposition vposition = new Vposition ();
            vposition.setMessageCode ( IConstant.EMSG0004 );
            vposition.setRetErrFlag ( true );
            vposition.setExceMessage ( e.getMessage () );
            list.add ( vposition );
            return list;
        }
    }

    /**
     * 取得流水线信息列表
     *
     * @param entity 查询条件
     */
    @SuppressWarnings("unchecked")
    public List<Assemblyline> getAssemblyLine(Assemblyline entity) {
        try {

            List<Assemblyline> list = (List<Assemblyline>) assemblylineDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Assemblyline> ();
                Assemblyline assemblyline = new Assemblyline ();
                assemblyline.setMessageCode ( IConstant.WMSG0008 );
                assemblyline.setRetErrFlag ( false );
                list.add ( assemblyline );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Assemblyline> list = new ArrayList<Assemblyline> ();
            Assemblyline assemblyline = new Assemblyline ();
            assemblyline.setMessageCode ( IConstant.EMSG0004 );
            assemblyline.setRetErrFlag ( true );
            assemblyline.setExceMessage ( e.getMessage () );
            list.add ( assemblyline );
            return list;
        }
    }

    /**
     * 取得工序信息列表
     *
     * @param entity 查询条件
     */
    @SuppressWarnings("unchecked")
    public List<Vprocess> getProcess(Vprocess entity) {
        try {

            List<Vprocess> list = (List<Vprocess>) vprocessDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Vprocess> ();
                Vprocess vprocess = new Vprocess ();
                vprocess.setMessageCode ( IConstant.WMSG0008 );
                vprocess.setRetErrFlag ( false );
                list.add ( vprocess );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vprocess> list = new ArrayList<Vprocess> ();
            Vprocess vprocess = new Vprocess ();
            vprocess.setMessageCode ( IConstant.EMSG0004 );
            vprocess.setRetErrFlag ( true );
            vprocess.setExceMessage ( e.getMessage () );
            list.add ( vprocess );
            return list;
        }
    }

    /**
     * 取得设备信息列表
     *
     * @param entity 查询条件
     */
    @SuppressWarnings("unchecked")
    public List<Vequipment> getEquipment(Vequipment entity) {
        try {

            List<Vequipment> list = (List<Vequipment>) vequipmentDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Vequipment> ();
                Vequipment vequipment = new Vequipment ();
                vequipment.setMessageCode ( IConstant.WMSG0008 );
                vequipment.setRetErrFlag ( false );
                list.add ( vequipment );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vequipment> list = new ArrayList<Vequipment> ();
            Vequipment vequipment = new Vequipment ();
            vequipment.setMessageCode ( IConstant.EMSG0004 );
            vequipment.setRetErrFlag ( true );
            vequipment.setExceMessage ( e.getMessage () );
            list.add ( vequipment );
            return list;
        }
    }

    /**
     * 取得业务流程列表
     *
     * @param entity 查询条件
     */
    @SuppressWarnings("unchecked")
    public List<Vbusiness> getBusiness(Vbusiness entity) {
        try {

            List<Vbusiness> list = (List<Vbusiness>) vbusinessDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Vbusiness> ();
                Vbusiness vbusiness = new Vbusiness ();
                vbusiness.setMessageCode ( IConstant.WMSG0008 );
                vbusiness.setRetErrFlag ( true );
                list.add ( vbusiness );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vbusiness> list = new ArrayList<Vbusiness> ();
            Vbusiness vbusiness = new Vbusiness ();
            vbusiness.setMessageCode ( IConstant.EMSG0004 );
            vbusiness.setRetErrFlag ( true );
            vbusiness.setExceMessage ( e.getMessage () );
            list.add ( vbusiness );
            return list;
        }
    }

    /**
     * 取得页面grid显示项目列表
     *
     * @param pageID
     * @param lang
     * @param itemType(0手持机1平台2打印项目)
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getGridColmun(String pageID, String lang, String itemType) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            Displayeditemconfiguration entity = new Displayeditemconfiguration ();
            entity.setPageName ( pageID );
            entity.setLanguageCode ( lang );
            entity.setItemType ( itemType );
            List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Displayeditemconfiguration> ();
                Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration ();
                displayeditemconfiguration.setMessageCode ( IConstant.WMSG0008 );
                displayeditemconfiguration.setRetErrFlag ( true );
                list.add ( displayeditemconfiguration );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                for (Displayeditemconfiguration displayeditemconfiguration : list) {
                    rtn.put ( displayeditemconfiguration.getColName (), IConstant.DISPLAYED_FLAG_0.equals ( displayeditemconfiguration.getDisplayedFlag () ) ? true : false );
                }
                return rtn;
            }
        } catch (SQLException e) {
            List<Displayeditemconfiguration> list = new ArrayList<Displayeditemconfiguration> ();
            Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration ();
            displayeditemconfiguration.setMessageCode ( IConstant.EMSG0004 );
            displayeditemconfiguration.setRetErrFlag ( true );
            displayeditemconfiguration.setExceMessage ( e.getMessage () );
            list.add ( displayeditemconfiguration );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;

        }
    }

    /**
     * 刀具业务流程验证
     *
     * @param rfidString 当前扫描的rfid标签
     * @param flowName   流程名称：例如【C01S001】
     * @return 返回结果：Map{agreeFlag = 是否可以进行处理,messageText = 验证消息}
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> checkToolStauts(String rfidString, String flowName, String langCode) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        boolean agreeFlag = false;// 是否可以进行处理
        String messageText = "";// 验证消息
        List<Business> list;
        String lastFlowID;
        String lastFlowText;
        String newFlowText;
        try {
            Business business = new Business ();
            business.setLanguageCode ( langCode );
            business.setBusinessCode ( flowName );
            List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
            if (businessList == null || businessList.size () <= 0) {
                //  当前流程不存在!
                rtn.put ( "agreeFlag", agreeFlag );
                rtn.put ( "messageCode", IConstant.WMSG0119 );
                return rtn;
            } else {
                lastFlowText = businessList.get ( 0 ).getBusinessName ();// 取出流程ID
            }
            // 取得当前刀具的最后执行业务流程
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidCode ( rfidString );
            rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
            if (rfidList == null || rfidList.size () == 0) {
                // 当前扫描的RFID未绑定刀具!
                rtn.put ( "agreeFlag", agreeFlag );
                rtn.put ( "messageCode", IConstant.WMSG0143 );
                return rtn;
            }
            rfidcontainer = rfidList.get ( 0 );
            if (IConstant.QUERY_TYPE_0.equals ( rfidcontainer.getQueryType () )) {// 库存新刀
                // 最后执行业务流程编码【C01S001】
                // 取得当前业务对应的流程ID

                business = new Business ();
                business.setLanguageCode ( langCode );
                business.setBusinessCode ( IConstant.C01S001 );
                businessList = (List<Business>) businessDao.searchByList ( business );
                if (businessList == null || businessList.size () <= 0) {
                    //  当前流程不存在!
                    rtn.put ( "agreeFlag", agreeFlag );
                    rtn.put ( "messageCode", IConstant.WMSG0119 );
                    return rtn;
                } else {
                    business = businessList.get ( 0 );// 取出流程ID
                }
                lastFlowID = business.getBusinessID ();
                newFlowText = business.getBusinessName ();

            } else {// 流转中刀具
                Tooltransfer tooltransfer = new Tooltransfer ();
                tooltransfer.setRfidContainerID ( rfidcontainer.getRfidContainerID () );// 取得载体ID
                tooltransfer.setDelFlag ( IConstant.DEL_FLAG_0 );
                // 取得流转刀具信息
                List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );
                if (tooltransferList == null || tooltransferList.size () == 0) {
                    // 当前扫描的RFID未绑定刀具!
                    rtn.put ( "agreeFlag", agreeFlag );
                    rtn.put ( "messageCode", IConstant.WMSG0143 );
                    return rtn;
                }
                tooltransfer = tooltransferList.get ( 0 );
                if (IConstant.INSTALLATION_STATE_1.equals ( tooltransfer.getInstallationState () )) {// 合成刀具
                    // 取得合成刀具信息
                    Synthesisknife synthesisknife = new Synthesisknife ();
                    synthesisknife.setrFID ( tooltransfer.getRfidContainerID () );
                    synthesisknife.setDelFlag ( IConstant.DEL_FLAG_0 );
                    List<Synthesisknife> synthesisknifeList = (List<Synthesisknife>) synthesisknifeDao.searchByList ( synthesisknife );
                    synthesisknife = synthesisknifeList.get ( 0 );
                    // 最后执行业务流程ID
                    Businessflowlnk businessflowlnk = new Businessflowlnk ();
                    businessflowlnk.setBusinessFlowLnkID ( synthesisknife.getBusinessFlowLnkID () );
                    Businessflowlnk flowLink = (Businessflowlnk) businessflowlnkDao.searchByPrimaryKey ( businessflowlnk );
                    lastFlowID = flowLink.getBusinessID ();

                } else {// 单品刀具
                    // 最后执行业务流程ID
                    Businessflowlnk businessflowlnk = new Businessflowlnk ();
                    businessflowlnk.setBusinessFlowLnkID ( tooltransfer.getBusinessFlowLnkID () );
                    businessflowlnk.setDelFlag ( IConstant.DEL_FLAG_0 );
                    Businessflowlnk flowLink = (Businessflowlnk) businessflowlnkDao.searchByPrimaryKey ( businessflowlnk );
                    lastFlowID = flowLink.getBusinessID ();
                }

                business = new Business ();
                business.setLanguageCode ( langCode );
                business.setBusinessID ( lastFlowID );
                business.setDelFlag ( IConstant.DEL_FLAG_0 );
                businessList = (List<Business>) businessDao.searchByList ( business );
                if (businessList == null || businessList.size () <= 0) {
                    //  当前流程不存在!
                    rtn.put ( "agreeFlag", agreeFlag );
                    rtn.put ( "messageCode", IConstant.WMSG0119 );
                    return rtn;
                } else {
                    business = businessList.get ( 0 );// 取出流程ID

                }
                //如果当前刀具的最后流程为库房刃磨室初始化，则无需验证
                if (business.getBusinessCode ().equals ( "C03S001" )) {
                    rtn.put ( "agreeFlag", true );
                    return rtn;
                }
                //依据流程ID取得流程编码，如果当前刀具的最后流程为对刀室车间初始化，则无需验证
                if (business.getBusinessCode ().equals ( "C03S002" )) {
                    rtn.put ( "agreeFlag", true );
                    return rtn;
                }
            }

            // 取得当前合成刀具的下一可执行流程
            list = getNextBusiness ( lastFlowID );
            for (Business entity : list) {
                if (messageText.indexOf ( entity.getBusinessName () ) < 0) {
                    messageText += entity.getBusinessName () + ",";
                }
                if (flowName.equals ( entity.getBusinessCode () )) {
                    agreeFlag = true;
                }
            }
            if (!agreeFlag) {
                // 当前刀具最后执行流程是{0},正在{1}流程,该刀具应进行{2}流程!
                rtn.put ( "messageCode", IConstant.CIMSG0086 );
                if ("".equals ( messageText )) {
                    rtn.put ( "messageText", "\"操作流程管理\"" );
                } else {
                    messageText = messageText.substring ( 0, messageText.length () - 1 );
                    rtn.put ( "messageText", messageText );
                }
                business = new Business ();
                business.setLanguageCode ( langCode );
                business.setBusinessCode ( flowName );
                business.setDelFlag ( IConstant.DEL_FLAG_0 );
                businessList = (List<Business>) businessDao.searchByList ( business );
                if (businessList == null || businessList.size () <= 0) {
                    // 当前流程不存在!
                    rtn.put ( "agreeFlag", agreeFlag );
                    rtn.put ( "messageCode", IConstant.WMSG0119 );
                    return rtn;
                } else {
                    lastFlowText = businessList.get ( 0 ).getBusinessName ();// 取出流程ID
                }
                business = new Business ();
                business.setLanguageCode ( langCode );
                business.setBusinessID ( lastFlowID );
                business.setDelFlag ( IConstant.DEL_FLAG_0 );
                businessList = (List<Business>) businessDao.searchByList ( business );
                if (businessList == null || businessList.size () <= 0) {
                    // 当前流程不存在!
                    rtn.put ( "agreeFlag", agreeFlag );
                    rtn.put ( "messageCode", IConstant.WMSG0119 );
                    return rtn;
                } else {
                    newFlowText = businessList.get ( 0 ).getBusinessName ();// 取出流程ID
                }
                rtn.put ( "lastFlowText", lastFlowText );
                rtn.put ( "newFlowText", newFlowText );
            }
            rtn.put ( "agreeFlag", agreeFlag );
            return rtn;
        } catch (SQLException e) {
            rtn.put ( "agreeFlag", agreeFlag );
            rtn.put ( "messageCode", IConstant.EMSG0004 );
            return rtn;

        }
    }

    /**
     * 刀具业务流程验证
     *
     * @param rfidString 当前扫描的rfid标签
     * @param flowName   流程名称：例如【C01S001】
     * @return 返回结果：Map{agreeFlag = 是否可以进行处理,messageText = 验证消息}
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> checkToolStautspd(String rfidString, String flowName, String langCode) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        boolean agreeFlag = false;// 是否可以进行处理
        String messageText = "";// 验证消息
        List<Business> list;
        String lastFlowID = "";
        String lastFlowText;
        String newFlowText;
        try {
            Business business = new Business ();
            // 取得当前刀具的最后执行业务流程
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidCode ( rfidString );
            rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
            if (rfidList == null || rfidList.size () == 0) {
                // 当前扫描的RFID未绑定刀具!
                rtn.put ( "agreeFlag", agreeFlag );
                rtn.put ( "messageCode", IConstant.WMSG0143 );
                return rtn;
            }
            rfidcontainer = rfidList.get ( 0 );
            if (IConstant.QUERY_TYPE_0.equals ( rfidcontainer.getQueryType () )) {// 库存新刀
                rtn.put ( "agreeFlag", true );
                return rtn;
            } else {// 流转中刀具
                Tooltransfer tooltransfer = new Tooltransfer ();
                tooltransfer.setRfidContainerID ( rfidcontainer.getRfidContainerID () );// 取得载体ID
                tooltransfer.setDelFlag ( IConstant.DEL_FLAG_0 );
                // 取得流转刀具信息
                List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );
                if (tooltransferList == null || tooltransferList.size () == 0) {
                    // 当前扫描的RFID未绑定刀具!
                    rtn.put ( "agreeFlag", agreeFlag );
                    rtn.put ( "messageCode", IConstant.WMSG0143 );
                    return rtn;
                }
                tooltransfer = tooltransferList.get ( 0 );
                if (!IConstant.INSTALLATION_STATE_1.equals ( tooltransfer.getInstallationState () )) {
                    // 最后执行业务流程ID
                    Businessflowlnk businessflowlnk = new Businessflowlnk ();
                    businessflowlnk.setBusinessFlowLnkID ( tooltransfer.getBusinessFlowLnkID () );
                    Businessflowlnk flowLink = (Businessflowlnk) businessflowlnkDao.searchByPrimaryKey ( businessflowlnk );
                    lastFlowID = flowLink.getBusinessID ();
                }

                business = new Business ();
                business.setLanguageCode ( langCode );
                business.setBusinessID ( lastFlowID );
                List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
                if (businessList == null || businessList.size () <= 0) {
                    //  当前流程不存在!
                    rtn.put ( "agreeFlag", agreeFlag );
                    rtn.put ( "messageCode", IConstant.WMSG0119 );
                    return rtn;
                } else {
                    business = businessList.get ( 0 );// 取出流程ID

                }
                //如果当前刀具的最后流程为库房刃磨室初始化，则无需验证
                if (business.getBusinessCode ().equals ( "C03S001" )) {
                    rtn.put ( "agreeFlag", true );
                    return rtn;
                }
                //依据流程ID取得流程编码，如果当前刀具的最后流程为对刀室车间初始化，则无需验证
                if (business.getBusinessCode ().equals ( "C03S002" )) {
                    rtn.put ( "agreeFlag", true );
                    return rtn;
                }

                if (business.getBusinessCode ().equals ( "C01S002" )) {
                    rtn.put ( "agreeFlag", true );
                    return rtn;
                }

                if (business.getBusinessCode ().equals ( "C01S016" )) {
                    rtn.put ( "agreeFlag", true );
                    return rtn;
                }

                if (business.getBusinessCode ().equals ( "C01S015" )) {
                    rtn.put ( "agreeFlag", true );
                    return rtn;
                }

                if (business.getBusinessCode ().equals ( "C01S001" )) {
                    rtn.put ( "agreeFlag", true );
                    return rtn;
                }
            }

            // 取得当前合成刀具的下一可执行流程
            list = getNextBusiness ( lastFlowID );
            for (Business entity : list) {
                if (messageText.indexOf ( entity.getBusinessName () ) < 0) {
                    messageText += "," + entity.getBusinessName ();
                }
                if (flowName.equals ( entity.getBusinessCode () )) {
                    agreeFlag = true;
                }
            }
            if (!agreeFlag) {
                // 当前流程不存在!
                rtn.put ( "agreeFlag", agreeFlag );
                rtn.put ( "messageCode", IConstant.WMSG0250 );
                return rtn;
            }
            rtn.put ( "agreeFlag", agreeFlag );
            return rtn;
        } catch (SQLException e) {
            rtn.put ( "agreeFlag", agreeFlag );
            rtn.put ( "messageCode", IConstant.EMSG0004 );
            return rtn;

        }
    }

    /**
     * 取得当前流程的下一可执行流程
     *
     * @param lastFlowID
     * @return
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    private List<Business> getNextBusiness(String lastFlowID) throws SQLException {
        List<Business> ret = new ArrayList<Business> ();
        Businessflowlnk businessflowlnk = new Businessflowlnk ();
        businessflowlnk.setBusinessID ( lastFlowID );
        List<Businessflowlnk> list = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnk );
        for (Businessflowlnk businessflowlnk2 : list) {
            Businessflowlnk flowlnk = new Businessflowlnk ();
            flowlnk.setBusinessFlowID ( businessflowlnk2.getBusinessFlowID () );
            flowlnk.setOrderNumber ( businessflowlnk2.getOrderNumber ().add ( BigDecimal.ONE ) );
            List<Businessflowlnk> businessList = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( flowlnk );
            if (businessList.size () > 0) {
                flowlnk = businessList.get ( 0 );
                Business business = new Business ();
                business.setBusinessID ( flowlnk.getBusinessID () );
                business = (Business) businessDao.searchByPrimaryKey ( business );
                ret.add ( business );
            }
        }
        return ret;
    }

    /**
     * 取得用户列表
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Vcustomer> getVcustomer(Vcustomer entity) {
        try {
            List<Vcustomer> list = (List<Vcustomer>) vcustomerDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Vcustomer> ();
                Vcustomer vcustomer = new Vcustomer ();
                vcustomer.setMessageCode ( IConstant.WMSG0008 );
                vcustomer.setRetErrFlag ( true );
                list.add ( vcustomer );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vcustomer> list = new ArrayList<Vcustomer> ();
            Vcustomer vcustomer = new Vcustomer ();
            //错误消息：数据库操作异常，查询失败!
            vcustomer.setMessageCode ( IConstant.EMSG0004 );
            vcustomer.setRetErrFlag ( true );
            vcustomer.setExceMessage ( e.getMessage () );
            list.add ( vcustomer );
            return list;
        }
    }

    /**
     * 库存异常报警列表
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getInventoryCountList(Vinventoryalarm entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            List<Vinventoryalarm> list = (List<Vinventoryalarm>) vinventoryalarmDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Vinventoryalarm> ();
                Vinventoryalarm vinventoryalarm = new Vinventoryalarm ();
                vinventoryalarm.setMessageCode ( IConstant.EMSG0001 );
                vinventoryalarm.setRetErrFlag ( true );
                list.add ( vinventoryalarm );
                rtn.put ( "status", IConstant.RESULT_CODE_1 );//条数为0
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                List<Vinventoryalarm> resultList = new ArrayList<Vinventoryalarm> ();
                for (Vinventoryalarm temp : list) {
                    // 根据刀具编码取得 该类刀具的安上次数及间隔天数
                    SubToolProcessAmount subToolProcessAmount = new SubToolProcessAmount ();
                    subToolProcessAmount.setToolCode ( temp.getToolCode () );
                    List<SubToolProcessAmount> subToolProcessAmountList = (List<SubToolProcessAmount>) subToolProcessAmountDao.searchByList ( subToolProcessAmount );
                    String staTime = IConstant.STRING_0, endTime = IConstant.STRING_1;
                    if (subToolProcessAmountList.size () > 0) {
                        if (subToolProcessAmountList.get ( 0 ).getLoadTime () != null && !subToolProcessAmountList.get ( 0 ).getLoadTime ().equals ( "" )) {
                            staTime = subToolProcessAmountList.get ( 0 ).getLoadTime (); // 开始时间
                            endTime = subToolProcessAmountList.get ( subToolProcessAmountList.size () - 1 ).getLoadTime ();// 结束时间
                        }
                    }
                    // 间隔天数
                    int loadTime = Integer.parseInt ( endTime ) - Integer.parseInt ( staTime );
                    int loadCount = 0; // 安装次数
                    for (SubToolProcessAmount subToolProcessAmountEntity : subToolProcessAmountList) {
                        loadCount += subToolProcessAmountEntity.getLoadCount ().intValue ();
                    }
                    // 平均每天使用刀具次数
                    int avgToolCount = 0;
                    if (loadTime != 0) {
                        avgToolCount = loadCount / loadTime;
                    }

                    SubToolAvgToolSharpennum subToolAvgToolSharpennum = new SubToolAvgToolSharpennum ();
                    subToolAvgToolSharpennum.setToolCode ( temp.getToolCode () );
                    List<SubToolAvgToolSharpennum> subToolAvgToolSharpennumList = (List<SubToolAvgToolSharpennum>) subToolAvgToolSharpennumDao.searchByList ( subToolAvgToolSharpennum );
                    int purchasingCycle = 30;// 初始值
                    int avgcs = 1;// 初始值
                    if (subToolAvgToolSharpennumList.size () > 0) {
                        // 采购周期(天数)
                        purchasingCycle = subToolAvgToolSharpennumList.get ( 0 ).getPurchasingCycle ().intValue ();
                        // 刀具平均使用次数
                        avgcs = subToolAvgToolSharpennumList.get ( 0 ).getAvgcs ().intValue ();
                    } else {

                    }
                    if (avgcs != 0 && avgToolCount != 0 && purchasingCycle != 0) {// 如果分母或分子不等于0,才更新周转量
                        // 周转量= 采购周期(天) * 平均每天使用刀具次数/刀具平均使用次数
                        int toolTurnover = purchasingCycle * avgToolCount / avgcs;
                        // 赋值周转量
                        temp.setToolTurnover ( new BigDecimal ( toolTurnover ) );
                    }
                    //刀具是否告警
                    temp.setStates ( getThisStatusString ( temp ) );
                    resultList.add ( temp );
                }

                int total = vinventoryalarmDao.searchByCount ( entity );
                rtn.put ( "rows", resultList );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );
                return rtn;
            }

        } catch (SQLException e) {
            List<Vinventoryalarm> list = new ArrayList<Vinventoryalarm> ();
            Vinventoryalarm vinventoryalarm = new Vinventoryalarm ();
            vinventoryalarm.setMessageCode ( IConstant.EMSG0004 );
            vinventoryalarm.setRetErrFlag ( true );
            vinventoryalarm.setExceMessage ( e.getMessage () );
            list.add ( vinventoryalarm );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    /*********     Tyy  2014年11月29日 10:42:23     Start         *********/

    /**
     * 查询是否RFID是否绑定 如果没有绑定刚绑定
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> checkIsHasRfid(String rfidString, String userID) {
        boolean retIsEmptiy = true;
        Map<String, Object> rtn = new HashMap<String, Object> ();
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( rfidString );
        try {
            List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
            if (rfList.size () <= 0) {// 没有标签记录则新建
                rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setRfidContainerID ( NextKeyValue.getNextkeyvalue ( IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID, userID ) );// RFID载体ID
                rfidcontainer.setToolShelfID ( null );// ToolShelfID
                rfidcontainer.setRfidCode ( rfidString );// RFID标签ID
                rfidcontainer.setRfidReCount ( BigDecimal.ZERO );// RFID重用次数
                rfidcontainer.setLaserIdentificationCode ( null );// 激光识别码
                rfidcontainer.setBandType ( IConstant.BAND_TYPE_0 );// 绑定类型
                rfidcontainer.setQueryType ( IConstant.QUERY_TYPE_1 );// 查询方式
                rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
                rfidcontainer.setUpdateUser ( userID );// 更新者
                rfidcontainer.setUpdateTime ( new Date () );// 更新时间
                rfidcontainer.setSystemLogUser ( userID );// 操作人
                rfidcontainer.setVersion ( BigDecimal.ZERO );// 版本号
                rfidcontainerDao.insert ( rfidcontainer );
            } else {
                int count = 0;
                rfidcontainer = rfList.get ( 0 );
                // 判断是否已删除
                if (IConstant.DEL_FLAG_0.equals ( rfidcontainer.getDelFlag () )) {
                    // 没有删除
                    String queryType = rfidcontainer.getQueryType ();
                    // 判断是新库还中流转
                    if (IConstant.STRING_0.equals ( queryType )) {// 库存
                        Knifeinventory ki = new Knifeinventory ();
                        ki.setRfidContainerID ( rfidcontainer.getRfidContainerID () );
                        ki.setDelFlag ( IConstant.DEL_FLAG_0 );
                        count = knifeinventoryDao.searchByCount ( ki );
                    } else {// 流转
                        Tooltransfer tt = new Tooltransfer ();
                        tt.setRfidContainerID ( rfidcontainer.getRfidContainerID () );
                        tt.setDelFlag ( IConstant.DEL_FLAG_0 );
                        count = tooltransferDao.searchByCount ( tt );
                    }
                    // 查到对应的数量
                    if (count > 0) {
                        retIsEmptiy = false;
                        rtn.put ( "retIsEmptiy", retIsEmptiy );
                        rtn.put ( "msg", IConstant.WMSG0218 );
                        return rtn;
                    }
                } else {
                    // 已删除则更新为未删除（次数加1 ，delflag=0）
                    Rfidcontainer rc = new Rfidcontainer ();
                    rc.setRfidCodeWhere ( rfidString );// 条件
                    rc.setRfidReCount ( rfidcontainer.getRfidReCount ().add ( BigDecimal.ONE ) );// RFID重用次数
                    rc.setQueryType ( IConstant.QUERY_TYPE_1 );// 查询方式(0库存1流转)
                    rc.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分(0有效1删除)
                    rc.setUpdateUser ( userID );// 更新者
                    rc.setUpdateTime ( new Date () );// 更新时间
                    rc.setSystemLogUser ( userID );// 操作人
                    rc.setVersion ( rfidcontainer.getVersion ().add ( BigDecimal.ONE ) );// 版本号
                    rfidcontainerDao.updateNonQuery ( rc );
                }

            }
            rtn.put ( "retIsEmptiy", retIsEmptiy );
            rtn.put ( "success", true );
            rtn.put ( "msg", IConstant.WMSG0219 );

        } catch (SQLException e) {
            rtn.put ( "success", false );
            rtn.put ( "msg", IConstant.WMSG0220 );
        }
        return rtn;
    }

    /**
     * 获取库管的领刀人权限
     */
    public List<Vgetpositioncapability> getPositionCapability(Vgetpositioncapability entity) {
        List<Vgetpositioncapability> list = new ArrayList<Vgetpositioncapability> ();
        try {
            list = (List<Vgetpositioncapability>) vgetpositioncapabilityDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Vgetpositioncapability> ();
                Vgetpositioncapability vgetpositioncapability = new Vgetpositioncapability ();
                vgetpositioncapability.setRetErrFlag ( true );
                list.add ( vgetpositioncapability );

            }
        } catch (SQLException e) {
            Vgetpositioncapability vgetpositioncapability = new Vgetpositioncapability ();
            //错误消息：数据库操作异常，查询失败!
            vgetpositioncapability.setMessageCode ( IConstant.EMSG0004 );
            vgetpositioncapability.setRetErrFlag ( true );
            vgetpositioncapability.setExceMessage ( e.getMessage () );
            list.add ( vgetpositioncapability );
        }
        return list;
    }

    /**
     * 根据RFID判断是刀具的属性
     *
     * @param: rfidString
     * @return: "1"- 合成刀具
     * @return: "2"- 单品刀具
     * @return: "3"- 辅具
     * @return: "4"- 配套
     * @return: "5"- 设备
     * @return: "0"-该RFID没有初始化
     */
    @SuppressWarnings("unchecked")
    public String getToolsTypeByRfid(String rfidString) throws SQLException {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        rfidcontainer.setRfidCode ( rfidString );
        //查询RFID载体
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        if (rfList.size () > 0) {
            if (IConstant.STSATIC_ONE.equals ( rfList.get ( 0 ).getDelFlag () )) {
                return RETURN_ZERO;
            }
            //载体ID
            String rfidContainerId = rfList.get ( 0 ).getRfidContainerID ();
            //查询rfid是不是合成刀具
            Synthesisknife sk = new Synthesisknife ();
            sk.setrFID ( rfidContainerId );
            sk.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Synthesisknife> skList = (List<Synthesisknife>) synthesisknifeDao.searchByList ( sk );
            if (skList.size () > 0) {
                return RETURN_ONE;
            }
            //查询rfid是不是单品刀具
            Knifeinventory ki = new Knifeinventory ();
            ki.setRfidContainerID ( rfidContainerId );
            ki.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Knifeinventory> kiList = (List<Knifeinventory>) knifeinventoryDao.searchByList ( ki );
            if (kiList.size () > 0) {
                Tool tool = new Tool ();
                tool.setToolID ( kiList.get ( 0 ).getToolID () );
                //  tool.setDelFlag(IConstant.DEL_FLAG_0);
                tool = (Tool) toolDao.searchByList ( tool ).get ( 0 );
                //9其他
                if (RETURN_ZERO.equals ( tool.getToolType () )) {  //0刀具
                    return RETURN_TWO;
                }
                if (RETURN_ONE.equals ( tool.getToolType () )) {// 1辅具
                    return RETURN_THREE;
                }
                if (RETURN_TWO.equals ( tool.getToolType () )) {//2配套
                    return RETURN_FOUR;
                }
            }
            if (IConstant.STSATIC_TWO.equals ( rfList.get ( 0 ).getQueryType () )) {//设备
                Equipment em = new Equipment ();
                em.setDelFlag ( IConstant.DEL_FLAG_0 );
                em.setRfidContainerID ( rfList.get ( 0 ).getRfidContainerID () );
                List<Equipment> emList = (List<Equipment>) equipmentDao.searchByList ( em );
                if (emList.size () > 0) {
                    return RETURN_FIVE;
                }
            }
            //初始化的单品刀具
            Tooltransfer tt = new Tooltransfer ();
            tt.setRfidContainerID ( rfidContainerId );
            List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
            if (ttList.size () > 0) {
                Tool tool = new Tool ();
                tool.setToolID ( ttList.get ( 0 ).getToolID () );
                tool.setDelFlag ( IConstant.DEL_FLAG_0 );
                tool = (Tool) toolDao.searchByList ( tool ).get ( 0 );
                //9其他
                if (RETURN_ZERO.equals ( tool.getToolType () )) {  //0刀具
                    return RETURN_TWO;
                }
                if (RETURN_ONE.equals ( tool.getToolType () )) {// 1辅具
                    return RETURN_THREE;
                }
                if (RETURN_TWO.equals ( tool.getToolType () )) {//2配套
                    return RETURN_FOUR;
                }
            }
        }
        // 是否进行加入rfid载体中--待定
        return RETURN_ZERO;
    }

    @Override
    /**
     * 根据RFID获取当前合成刀具走过的流程
     */
    @SuppressWarnings("unchecked")
    public List<Vgetsynthesisexperience> getSynthesisHistory(String rfidString) throws SQLException {
        Vgetsynthesisexperience entity = new Vgetsynthesisexperience ();
        entity.setRfidCode ( rfidString ); //RFID
        entity.setRowCount ( MAX_NUMBER );
        return (List<Vgetsynthesisexperience>) vgetsynthesisexperienceDao.searchByList ( entity );
    }

    /**
     * 根据用户ID取得对应的姓名
     *
     * @param userId
     * @return
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    @Override
    public String getUserName(String userId) throws SQLException {
        Userdetail ud = new Userdetail ();
        ud.setCustomerID ( userId );
        ud.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Userdetail> userdetailList = (List<Userdetail>) userdetailDao.searchByList ( ud );
        if (userdetailList != null && userdetailList.size () > 0) {
            return userdetailList.get ( 0 ).getUserName ();
        } else {
            return "";
        }

    }

    @Override
    public String getBandType(String rfidString) throws SQLException {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setLaserIdentificationCode ( rfidString );
        List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        return rfidList.size () == 0 ? null : rfidList.get ( 0 ).getBandType ();
    }

    /**
     * 更新和增加RFIDConterner 如果有则更新,如果没有则增加
     *
     * @param rfidString //rfid
     * @param userId     //用户id
     * @throws SQLException
     */
    @Override
    public void updateAndInsertRFID(String rfidString, String userId) throws SQLException {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        // rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        rfidcontainer.setRfidCode ( rfidString );
        //查询RFID载体
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        if (rfList.size () > 0) {
            if (IConstant.DEL_FLAG_1.equals ( rfList.get ( 0 ).getDelFlag () )) { //无效
                rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setRfidCodeWhere ( rfidString );// RFID标签ID
                rfidcontainer.setRfidContainerIDWhere ( rfList.get ( 0 ).getRfidContainerID () );// RFID载体ID
                rfidcontainer.setRfidCode ( "" );
                rfidcontainer.setUpdateUser ( userId );// 更新者
                rfidcontainer.setUpdateTime ( new Date () );// 更新时间
                rfidcontainer.setVersion ( rfList.get ( 0 ).getVersion ().add ( BigDecimal.ONE ) );// 版本号
                rfidcontainerDao.updateNonQuery ( rfidcontainer );

                rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setRfidContainerID ( UUID.randomUUID ().toString () );// RFID载体ID
                rfidcontainer.setToolShelfID ( null );// ToolShelfID
                rfidcontainer.setRfidCode ( rfidString );// RFID标签ID
                rfidcontainer.setRfidReCount ( BigDecimal.ZERO );// RFID重用次数
                rfidcontainer.setLaserIdentificationCode ( null );// 激光识别码
                rfidcontainer.setBandType ( IConstant.BAND_TYPE_0 );// 绑定类型
                rfidcontainer.setQueryType ( IConstant.QUERY_TYPE_1 );// 查询方式
                rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
                rfidcontainer.setUpdateUser ( userId );// 更新者
                rfidcontainer.setUpdateTime ( new Date () );// 更新时间
                rfidcontainer.setSystemLogUser ( userId );// 操作人
                rfidcontainer.setVersion ( BigDecimal.ZERO );// 版本号
                rfidcontainerDao.insert ( rfidcontainer );
            }
        } else {
            rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidContainerID ( UUID.randomUUID ().toString () );// RFID载体ID
            rfidcontainer.setToolShelfID ( null );// ToolShelfID
            rfidcontainer.setRfidCode ( rfidString );// RFID标签ID
            rfidcontainer.setRfidReCount ( BigDecimal.ZERO );// RFID重用次数
            rfidcontainer.setLaserIdentificationCode ( null );// 激光识别码
            rfidcontainer.setBandType ( IConstant.BAND_TYPE_0 );// 绑定类型
            rfidcontainer.setQueryType ( IConstant.QUERY_TYPE_1 );// 查询方式
            rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
            rfidcontainer.setUpdateUser ( userId );// 更新者
            rfidcontainer.setUpdateTime ( new Date () );// 更新时间
            rfidcontainer.setSystemLogUser ( userId );// 操作人
            rfidcontainer.setVersion ( BigDecimal.ZERO );// 版本号
            rfidcontainerDao.insert ( rfidcontainer );
        }
    }

    /**
     * 刀具报废
     *
     * @param map CustomerID    用户id(String)
     *            RfidString       报废标签(String)
     *            HandSetId      手持机id(String)
     *            gruantId         授权人Id(String)
     *            BusinessCode  流程名[C0XS0XX](String)
     * @return
     * @throws Exception
     */
    @Override
    public int savetoolDelete(Map<String, Object> map) throws Exception {
        int reVal = 0;
        String customerId = map.get ( "CustomerID" ) + "";// 用户id
        String rfidString = map.get ( "RfidString" ) + "";// 报废标签
        String BusinessCode = map.get ( "BusinessCode" ) + "";//执行业务流程
        String handId = map.get ( "HandSetId" ) + "";
        String gruantId = map.get ( "gruantId" ) + "";
        //依据刀具入库编码取得刀具流转信息

        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( rfidString );
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        if (rfidcontainerList.size () < 1) {
            return reVal;
        }
        String rfidContainerID = rfidcontainerList.get ( 0 ).getRfidContainerID ();
        // 取得刀具流转信息
        Tooltransfer tt = new Tooltransfer ();
        tt.setRfidContainerID ( rfidContainerID );
        tt.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
        if (ttList.size () < 1) {
            return reVal;
        }
        // 取得当前刀具的最后执行业务流程
        Business business = new Business ();
        business.setBusinessCode ( BusinessCode );
        List<Business> businessList = (List<Business>) businessDao.searchByList ( business );
        business = businessList.get ( 0 );
        Businessflowlnk businessflowlnks = new Businessflowlnk ();
        businessflowlnks.setBusinessID ( business.getBusinessID () );
        List<Businessflowlnk> list1 = (List<Businessflowlnk>) businessflowlnkDao.searchByList ( businessflowlnks );

        // 下一个流程
        String businessFlowLnkID = list1.get ( 0 ).getBusinessFlowLnkID ();

        List<Toolwholelifecycle> twlList = new ArrayList<Toolwholelifecycle> ();
        Toolwholelifecycle toolwholelifecycle = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory> ();
        Tooltransferhistory tth = null;
        for (Tooltransfer tooltransfer : ttList) {
            // 记录生命周期
            toolwholelifecycle = new Toolwholelifecycle ();
            toolwholelifecycle.setBusinessFlowLnkID ( businessFlowLnkID );
            toolwholelifecycle.setHandSetID ( handId );
            // 取得刀具信息
            Tool tool = new Tool ();
            tool.setToolID ( tooltransfer.getToolID () );
            List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
            if (toolList != null) {
                tool = toolList.get ( 0 );
                toolwholelifecycle.setToolCode ( tool.getToolCode () );
                toolwholelifecycle.setToolName ( tool.getToolName () );
            }
            toolwholelifecycle.setKnifeInventoryCode ( tooltransfer.getKnifeInventoryCode () );
            toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
            toolwholelifecycle.setCreateTime ( new Date () );
            toolwholelifecycle.setUpdateTime ( new Date () );
            toolwholelifecycle.setCreateUser ( customerId );
            toolwholelifecycle.setUpdateUser ( customerId );
            toolwholelifecycle.setVersion ( BigDecimal.ZERO );
            String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue ( IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, customerId );
            toolwholelifecycle.setToolWholeLifecycleID ( toolWholeLifecycleID );
            twlList.add ( toolwholelifecycle );

            //记录刀具报废状态
            Tooltransfer updateTooltransfer = new Tooltransfer ();
            updateTooltransfer.setKnifeInventoryCodeWhere ( tooltransfer.getKnifeInventoryCode () );
            updateTooltransfer.setRfidContainerIDWhere ( rfidContainerID );
            updateTooltransfer.setDelFlag ( IConstant.DEL_FLAG_0 );
            updateTooltransfer.setBusinessFlowLnkID ( businessFlowLnkID );
            updateTooltransfer.setConfirmedUser ( gruantId ); //授权人
            updateTooltransfer.setToolState ( IConstant.TOOL_STATE_0 );//断刀
            updateTooltransfer.setStockState ( IConstant.STOCK_STATE_1 );
            updateTooltransfer.setUpdateTime ( new Date () );// 更新时间
            updateTooltransfer.setUpdateUser ( customerId );// 更新者
            updateTooltransfer.setVersion ( tooltransfer.getVersion ().add ( BigDecimal.ONE ) );// 版本号
            reVal += tooltransferDao.updateNonQuery ( updateTooltransfer );

            // 刀具流转履历
            tth = new Tooltransferhistory ();
            tth.setToolTransferHistoryID ( NextKeyValue.getNextkeyvalue ( IConstant.TOOLTRANSFERHISTORY, IConstant.TOOLTRANSFERHISTORYID, customerId ) );
            tth.setRfidContainerID ( businessFlowLnkID ); // RFID载体ID
            tth.setKnifeInventoryCode ( tooltransfer.getKnifeInventoryCode () );// 刀具入库编码
            tth.setToolID ( tooltransfer.getToolID () );// 刀具ID
            tth.setToolProcuredID ( tooltransfer.getProcuredBatch () );// 采购ID
            tth.setBusinessFlowLnkID ( tooltransfer.getBusinessFlowLnkID () );// 最后执行业务流程(刀具安上)
            tth.setToolDurable ( tooltransfer.getToolDurable () );// 耐用度
            tth.setToolSharpennum ( tooltransfer.getToolDurable () );// 可使用(刃磨)次数
            tth.setToolSharpenCriterion ( tooltransfer.getToolSharpenCriterion () );// 复磨标准
            tth.setToolLength ( tooltransfer.getToolLength () );// 刀具长度
            tth.setToolSharpenLength ( tooltransfer.getToolSharpenLength () );// 可刃磨长度
            tth.setUsageCounter ( tooltransfer.getUsageCounter () );// 已使用(刃磨)次数
            tth.setToolGrindingLength ( tooltransfer.getToolGrindingLength () );// 刀具已刃磨长度
            tth.setInstallationState ( tooltransfer.getInstallationState () );// 刀具安装合成刀状态(0未安装1已安装2卸下9其他)
            tth.setStockState ( IConstant.STOCK_STATE_1 );//报废
            tth.setConfirmedUser ( gruantId );//授权人
            tth.setoutUser ( tooltransfer.getUpdateUser () );// 转出人
            tth.setinUser ( gruantId );// 接收人
            tth.setUpdateTime ( new Date () );// 更新时间
            tth.setUpdateUser ( customerId );// 更新者
            tth.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
            tth.setCreateTime ( new Date () );// 创建时间
            tth.setCreateUser ( customerId );// 创建者
            tth.setVersion ( BigDecimal.ZERO );// 版本号
            tthList.add ( tth );

        }

        if (tthList.size () > 0)
            tooltransferhistoryDao.insertBatchDefined ( tthList );
        if (twlList.size () > 0)
            toolwholelifecycleDao.insertBatchs ( twlList );

        return reVal;
    }

    /**
     * 新旧RFID交换(分盒)
     *
     * @param map newRfid              新的RFID(String)
     *            oldRfid               旧的RFID(String)
     *            tempNumbe      要交换的数量(String)
     *            userId                用户Id(String)
     *            BusinessCode  流程名[C0XS0XX](String)
     * @return
     * @throws Exception
     */
    @Override
    public Boolean saveSplitBoxTool(Map map) throws Exception {
        int reVal = 0;
        String newRfidString = map.get ( "newRfid" ).toString ();// 新RFID
        String oldRfidString = map.get ( "oldRfid" ).toString ();// 旧RFID
        String tempNumber = map.get ( "tempNumbe" ).toString ();// 分盒数量
        String userId = map.get ( "userId" ).toString ();//用户Id
        //   String BusinessCode = map.get("BusinessCode").toString(); //流程编码
        // 载体表(old)
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( oldRfidString );
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        rfidcontainer = (Rfidcontainer) rfidcontainerDao.searchByList ( rfidcontainer ).get ( 0 );
        String oldContainerID = rfidcontainer.getRfidContainerID ();
        // 查询方式(0库存1流转)
        String stateOld = rfidcontainer.getQueryType ();

        // 载体表(new)
        rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setRfidCode ( newRfidString );
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        rfidcontainer = (Rfidcontainer) rfidcontainerDao.searchByList ( rfidcontainer ).get ( 0 );
        String newContainerID = rfidcontainer.getRfidContainerID ();

        List<String> kicList = new ArrayList<String> ();
        List<Tooltransfer> ttList1 = new ArrayList<Tooltransfer> ();
        Tooltransfer tt1 = null;
        List<Tooltransfer> ttList = new ArrayList<Tooltransfer> ();
        Tooltransferhistory tth = null;
        List<Tooltransferhistory> tthList = new ArrayList<Tooltransferhistory> ();
        List<String> toolknife = new ArrayList<String> ();
        Rfidcontainer rfidcontainer2 = null;
        // 最后流程
     /*   Vbusiness bVbusiness = new Vbusiness();
        bVbusiness.setBusinessCode(BusinessCode);
        bVbusiness = (Vbusiness) vbusinessDao.searchByList(bVbusiness).get(0);
        String businessFlowLnkId = bVbusiness.getBusinessFlowLnkID();
*/
        // 0：新库 1：流转
        if (IConstant.STRING_0.equals ( stateOld )) {
            rfidcontainer2 = new Rfidcontainer ();
            rfidcontainer2.setRfidContainerIDWhere ( newContainerID );
            rfidcontainer2.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            rfidcontainer2.setQueryType ( IConstant.QUERY_TYPE_0 );
            rfidcontainerDao.updateNonQuery ( rfidcontainer2 );

            // 新刀出库
            Knifeinventory knifeinventory = new Knifeinventory ();
            knifeinventory.setRfidContainerIDWhere ( oldContainerID );
            knifeinventory.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            knifeinventory.setRfidContainerID ( newContainerID );
            knifeinventory.setVersion ( BigDecimal.ONE ); //自动加1
            knifeinventory.setUpdateTime ( new Date () );
            knifeinventory.setUpdateUser ( userId );
            knifeinventory.setRowCount ( Integer.parseInt ( tempNumber ) );
            reVal = knifeinventoryDao.updateNonQuerySplistBox ( knifeinventory );
        } else {// 流转刀具
            rfidcontainer2 = new Rfidcontainer ();
            rfidcontainer2.setRfidContainerIDWhere ( newContainerID );
            rfidcontainer2.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            rfidcontainer2.setQueryType ( IConstant.QUERY_TYPE_1 );
            rfidcontainerDao.updateNonQuery ( rfidcontainer2 );
            tt1 = new Tooltransfer ();
            tt1.setRfidContainerID ( oldContainerID );
            tt1.setDelFlag ( IConstant.DEL_FLAG_0 );
            tt1.setRfidContainerID ( newContainerID );
            tt1.setStaIndex ( 0 );
            tt1.setRowCount ( Integer.parseInt ( tempNumber ) );
            ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt1 );
            tt1 = new Tooltransfer ();
            tt1.setRfidContainerIDWhere ( oldContainerID );
            tt1.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            tt1.setRfidContainerID ( newContainerID );
            tt1.setVersion ( BigDecimal.ONE );//自动加1
            tt1.setRowCount ( Integer.parseInt ( tempNumber ) );
            tt1.setUpdateUser ( userId );
            tt1.setUpdateTime ( new Date () );
            for (Tooltransfer tt : ttList) {
                kicList.add ( tt.getKnifeInventoryCode () );
            }
            if (kicList.size () > 0) {
                // 修改刀具流转履历
                Map<String, Object> map2 = new HashMap<String, Object> ();
                map2.put ( "userId", userId );
                map2.put ( "newRfid", newContainerID );
                map2.put ( "list", kicList );
                tooltransferhistoryDao.updateByList ( map2 );
            }
            reVal = tooltransferDao.updateNonQuerySplistBox ( tt1 );
        }
        if (reVal > 0)
            return true;
        else
            return false;
    }

    /**
     * 取得报废盒子
     *
     * @param rfidString
     * @return 0 空盒
     * 1. 合成刀具
     * 2. 已报废的单品刀具
     * 3. 辅具
     * 4. 配套
     * 5. 设备
     * 6.没有报废的刀具
     * @throws Exception
     */
    @Override
    public String checkIsHasDiscard(String rfidString, String userid) throws Exception {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        rfidcontainer.setRfidCode ( rfidString );
        //查询RFID载体
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        if (rfList.size () < 1) {
            updateAndInsertRFID ( rfidString, userid );
            rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        }
        //载体ID
        String rfidContainerId = rfList.get ( 0 ).getRfidContainerID ();
        //查询rfid是不是合成刀具
        Synthesisknife sk = new Synthesisknife ();
        sk.setrFID ( rfidContainerId );
        List<Synthesisknife> skList = (List<Synthesisknife>) synthesisknifeDao.searchByList ( sk );
        if (skList.size () > 0) {
            return RETURN_ONE;
        }
        if (IConstant.STSATIC_TWO.equals ( rfList.get ( 0 ).getQueryType () )) {//设备
            Equipment em = new Equipment ();
            em.setDelFlag ( IConstant.DEL_FLAG_0 );
            em.setRfidContainerID ( rfList.get ( 0 ).getRfidContainerID () );
            List<Equipment> emList = (List<Equipment>) equipmentDao.searchByList ( em );
            if (emList.size () > 0) {
                return RETURN_FIVE;
            }
        }
        //初始化的单品刀具
        Tooltransfer tt = new Tooltransfer ();
        tt.setRfidContainerID ( rfidContainerId );
        tt.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
        if (ttList.size () > 0) {
            Tool tool = new Tool ();
            tool.setToolID ( ttList.get ( 0 ).getToolID () );
            tool.setDelFlag ( IConstant.DEL_FLAG_0 );
            tool = (Tool) toolDao.searchByList ( tool ).get ( 0 );
            //9其他
            if (RETURN_ZERO.equals ( tool.getToolType () ) && RETURN_ONE.equals ( ttList.get ( 0 ).getStockState () )) {  //0刀具 并且是报废刀具
                return RETURN_TWO;
            } else if (RETURN_ONE.equals ( tool.getToolType () )) {// 1辅具
                return RETURN_THREE;
            } else if (RETURN_TWO.equals ( tool.getToolType () )) {//2配套
                return RETURN_FOUR;
            } else {
                return IConstant.STRING_6;
            }
        } else {
            return RETURN_ZERO;
        }

    }

    /**
     * 查询已流转中辅具的刀具编码
     *
     * @param rfidString
     * @return
     * @throws SQLException
     */
    @Override
    public String getHelpToolInfo(String rfidString) throws SQLException {
        return tooltransferDao.getHelpToolCode ( rfidString ) + "";
    }

    /**
     * 取得区分值
     *
     * @param entity DelFlag(String)  删除区分     0
     *               LanguageCode  语言编码    01
     *               ComListType     区分类型    StockState
     *               ComListValue    区分值       1
     * @return
     * @throws SQLException
     */
    @Override
    public String getComListText(Comlist entity) throws SQLException {
        return comlistDao.getComListText ( entity ) + "";
    }

    /* * ******     Tyy  2015年4月7日 10:40:50     end          ********  */

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> ChangePassword(Customer customer, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            // 更新失败! 进行数据排他验证
            Customer entity = new Customer ();
            entity.setCustomerID ( customer.getCustomerIDWhere () );
            entity.setUpdateTime ( customer.getUpdateTimeWhere () );
            entity.setUpdateUser ( customer.getUpdateUserWhere () );
            entity.setVersion ( customer.getVersionWhere () );
            List<Customer> list = (List<Customer>) customerDao.searchByList ( entity );
            if (list == null || list.size () == 0) {
                entity = new Customer ();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode ( IConstant.WMSG0009 );
                entity.setRetErrFlag ( true );
                rtn.put ( "error", entity );
                rtn.put ( "data", null );
                return rtn;
            }
            // 更新用户成功
            customerDao.updateNonQuery ( customer );
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0005, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
            return rtn;
        } catch (SQLException e) {
            Customer entity = new Customer ();
            //错误消息：数据库操作异常，更新失败!
            entity.setMessageCode ( IConstant.EMSG0006 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> checkChangePasswordInput(Map<String, Object> param, String langCode, String langValue, String customerID, int checkType) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            // 页面输入项目验证
            Map<String, String> map = new HashMap<String, String> ();
            Customer customer = new Customer ();
            String OldPassWord = "";
            String NewPassWord = "";
            String NewPassWordCheck = "";

            Customer entity = new Customer ();
            entity.setCustomerID ( customerID );
            List<Customer> list = (List<Customer>) customerDao.searchByList ( entity );

            if (list == null || list.size () == 0) {
                map.put ( "DIVOldPassWord", "查无此用户" );
                return rtn;
            } else {
                entity = list.get ( 0 );
            }
            //验证原密码
            if (StringUtils.isEmpty ( param.get ( "DIVOldPassWord" ).toString () )) {// 如果密码未输入
                map.put ( "DIVOldPassWord", "请输入原密码" );
            } else if (param.get ( "DIVOldPassWord" ).toString ().length () < 6) { // 密码不可以小于6位
                map.put ( "DIVOldPassWord", MessageReSource.getMessageBox ( IConstant.WMSG0014, langCode, langValue ) );
            } else {
                OldPassWord = param.get ( "DIVOldPassWord" ).toString ();
                if (!Ctl.md5 ( OldPassWord ).equals ( entity.getUserPass () )) {
                    map.put ( "DIVOldPassWord", "原密码输入不正确" );
                }
            }
            //验证新密码
            if (StringUtils.isEmpty ( param.get ( "DIVNewPassWord" ).toString () )) {// 如果密码未输入
                map.put ( "DIVNewPassWord", "请输入新密码" );
            } else if (param.get ( "DIVNewPassWord" ).toString ().length () < 6) { // 密码不可以小于6位
                map.put ( "DIVNewPassWord", MessageReSource.getMessageBox ( IConstant.WMSG0014, langCode, langValue ) );
            } else {
                NewPassWord = param.get ( "DIVNewPassWord" ).toString ();
            }
            //验证新密码2
            if (StringUtils.isEmpty ( param.get ( "DIVNewPassWordCheck" ).toString () )) {// 如果密码未输入
                map.put ( "DIVNewPassWordCheck", "" );
            } else if (param.get ( "DIVNewPassWordCheck" ).toString ().length () < 6) { // 密码不可以小于5位
                map.put ( "DIVNewPassWordCheck", MessageReSource.getMessageBox ( IConstant.WMSG0014, langCode, langValue ) );
            } else {
                NewPassWordCheck = param.get ( "DIVNewPassWordCheck" ).toString ();
                if (!NewPassWordCheck.equals ( NewPassWord )) {
                    map.put ( "DIVNewPassWordCheck", "与新密码首次输入不同" );
                }
            }
            if (checkType == 1 && map.size () <= 0) {

                customer.setUserPass ( Ctl.md5 ( NewPassWord ) );
                customer.setCustomerIDWhere ( customerID );
                customer.setUpdateTime ( new Date () );
                customer.setUpdateTimeWhere ( entity.getUpdateTime () );
                customer.setUpdateUser ( customerID );
                customer.setUpdateUserWhere ( entity.getUpdateUser () );
                customer.setVersion ( entity.getVersion ().add ( BigDecimal.ONE ) );
                customer.setVersionWhere ( entity.getVersion () );
                rtn.put ( "data", customer );
                rtn.put ( "status", IConstant.RESULT_CODE_0 );
                return rtn;
            } else if (map.size () > 0) {
                rtn.put ( "message", map );
                rtn.put ( "data", null );
                rtn.put ( "status", IConstant.RESULT_CODE_2 );
                return rtn;
            }


        } catch (SQLException e) {
            Customer entity = new Customer ();
            //错误消息：数据库操作异常，查询失败!
            entity.setMessageCode ( IConstant.EMSG0004 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
        return rtn;
    }

    @Override
    public List<String> checkList(List<String> parsm) {
        List<String> reVal = new ArrayList<String> ();
        for (String rifd : parsm) {
            if (rifd != null) {
                reVal.add ( rifd );
            }
        }
        return reVal;
    }

    /**
     * 扫描要放入刀具的容器
     *
     * @param rfidString,userID
     * @return 0:非容器
     * 1:正常容器
     * 2:报废容器
     * 3:空容器
     * @throws Exception
     */
    @Override
    public String getToolsContainerByRfid(String rfidString, String userID) throws Exception {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        rfidcontainer.setRfidCode ( rfidString );
        //查询RFID载体
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        if (rfList.size () > 0) {
            //载体ID
            if (!RETURN_FIVE.equals ( rfList.get ( 0 ).getQueryType () )) {
                return RETURN_ZERO;
            }
            String rfidContainerId = rfList.get ( 0 ).getRfidContainerID ();
            Tooltransfer tt = new Tooltransfer ();
            tt.setRfidContainerID ( rfidContainerId );
            List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
            if (ttList.size () > 0) {
                String state = ttList.get ( 0 ).getStockState ();
                if (RETURN_ONE.equals ( state )) {
                    return RETURN_TWO;
                } else {
                    return RETURN_ONE;
                }
            } else {
                return RETURN_THREE;
            }
        } else {
            rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRfidContainerID ( UUID.randomUUID ().toString () );// RFID载体ID
            rfidcontainer.setToolShelfID ( null );// ToolShelfID
            rfidcontainer.setRfidCode ( rfidString );// RFID标签ID
            rfidcontainer.setRfidReCount ( BigDecimal.ZERO );// RFID重用次数
            rfidcontainer.setLaserIdentificationCode ( null );// 激光识别码
            rfidcontainer.setBandType ( IConstant.STSATIC_THREE );// 绑定类型
            rfidcontainer.setQueryType ( IConstant.QUERY_TYPE_1 );// 查询方式
            rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );// 删除区分
            rfidcontainer.setUpdateUser ( userID );// 更新者
            rfidcontainer.setUpdateTime ( new Date () );// 更新时间
            rfidcontainer.setSystemLogUser ( userID );// 操作人
            rfidcontainer.setVersion ( BigDecimal.ZERO );// 版本号
            rfidcontainerDao.insert ( rfidcontainer );
        }

        return RETURN_THREE;
    }

    @Override
    public String getrfidContainerIdByRfid(String rfidString) throws Exception {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        rfidcontainer.setRfidCode ( rfidString );
        //查询RFID载体
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
        if (rfList.size () > 0) {
            return rfList.get ( 0 ).getRfidContainerID ();
        } else {
            return RETURN_ZERO;
        }
    }

    /**
     * @param rfidString
     * @return
     * @throws Exception
     */
    @Override
    public String getToolStateByRfid(String rfidString) throws Exception {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
        rfidcontainer.setRfidCode ( rfidString );
        //查询RFID载体
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );

        String rfidContainerId = rfList.get ( 0 ).getRfidContainerID ();
        Tooltransfer tt = new Tooltransfer ();
        tt.setRfidContainerID ( rfidContainerId );
        List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
        return ttList.get ( 0 ).getToolThisState ();
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getRfidContainerIDByRfidCode(Rfidcontainer entity) throws Exception {
        List<Rfidcontainer> reList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( entity );
        if (reList.size () < 1) {
            //没有RIFD载体
            return null;
        } else {
            return reList.get ( 0 ).getRfidContainerID ();
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public Rfidcontainer getRfidContainerByRfidCode(Rfidcontainer entity) throws Exception {
        List<Rfidcontainer> reList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( entity );
        if (reList.size () < 1) {
            //没有RIFD载体
            return null;
        } else {
            return reList.get ( 0 );
        }

    }

    @Override
    public String getisHasInit(Customer customer) throws Exception {
        List<Customer> reList = (List<Customer>) customerDao.searchByList ( customer );
        if (reList != null && reList.size () > 0) {
            return reList.get ( 0 ).getRfidContainerID ();
        }
        return null;
    }

    @Override
    public Rfidcontainer checkRFIDType(String rfidCode) throws Exception {
        Rfidcontainer entity = new Rfidcontainer ();
        Rfidcontainer reval = new Rfidcontainer ();
        entity.setRfidCode ( rfidCode );
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Rfidcontainer> reList = rfidcontainerDao.checkRFIDType ( entity );
        if (reList.size () > 0) {
            reval = reList.get ( 0 );
            if (IConstant.STRING_1.equals ( reval.getQueryType () )) {
                //单品刀具
                Knifeinventory kv = new Knifeinventory ();
                kv.setDelFlag ( IConstant.DEL_FLAG_0 );
                kv.setRfidContainerID ( reval.getRfidContainerID () );
                List<Knifeinventory> reKV = (List<Knifeinventory>) knifeinventoryDao.searchByList ( kv );
                if (reKV == null || reKV.size () < 1) {
                    //旧刀
                    reval.setDelFlagWhere ( IConstant.DEL_FLAG_1 );
                } else {
                    //新刀
                    reval.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
                }
            }

        }
        return reval;

    }

    @Override
    public Object innsetGruant(Authorization auth) throws SQLException {
        //授权ID
        auth.setAuthorizationID ( UUIDgen.getId () );
        //授权时间
        auth.setAuthorizedTime ( new Date () );
        auth.setUpdateTime ( new Date () );
        auth.setCreateTime ( new Date () );
        auth.setUpdateUser ( auth.getCreateUserID () );
        return authorizationDao.insert ( auth );
    }

    @Override
    public Map<String, String> processControlBussinesCode(Map<String, String> param) throws Exception {
        Map<String, String> reVal = new HashMap<String, String> ();
        StringBuilder stringBuilder = new StringBuilder ();
        String gruantUserID = param.get ( "gruantUserID" );
        //当前流程编码
        String nextBusiness = param.get ( "businessCode" );
        //RFID标签
        Onoff onoff = null;
        String rfidCode = param.get ( "rfidCode" );
        //要执行的流程
        String thisBusiness = null;
        String toolCode = null;

        Rfidcontainer entity = new Rfidcontainer ();
        entity.setRfidCode ( rfidCode );
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        Rfidcontainer rfidcontainer = getRfidContainerByRfidCode ( entity );
        if (rfidcontainer == null) {
            return null;
        } else {
            //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
            String queryType = rfidcontainer.getQueryType ();
            //RFID载体ID
            String rfidContainerID = rfidcontainer.getRfidContainerID ();
            Tooltransfer tt = new Tooltransfer ();
            tt.setRfidContainerID ( rfidContainerID );
            tt.setDelFlag ( IConstant.DEL_FLAG_0 );
            if (IConstant.STRING_1.equals ( queryType ) || IConstant.STRING_6.equals ( queryType )) {
                stringBuilder.append ( "当前刀具只能执行" );
                //一、单品刀
                Knifeinventory kni = new Knifeinventory ();
                kni.setDelFlag ( IConstant.DEL_FLAG_0 );
                kni.setRfidContainerID ( rfidContainerID );
                List<Knifeinventory> reKni = (List<Knifeinventory>) knifeinventoryDao.searchByList ( kni );
                if (reKni == null || reKni.size () < 1) {
                    List<Tooltransfer> reTools = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
                    if (reTools == null || reTools.size () < 1) {
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_9 );
                    } else {
                        //2)流转旧刀
                        tt = reTools.get ( 0 );
                        thisBusiness = tt.getBusinessFlowLnkID ();
                        reVal.put ( "ToolID", tt.getToolID () );
                        //库存状态(0正常1报废2返厂3封存4.流转9其他)
                        String stockState = tt.getStockState ();
                        //刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他)10.已出厂修磨 11.厂外待涂层)
                        String toolState = tt.getToolState ();
                        if (IConstant.STRING_1.equals ( stockState )) {
                            //报废刀具
                            if (IConstant.C01S016.equals ( nextBusiness )) {
                                //正常流程
                                reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                            } else {
                                reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                                stringBuilder.append ( IConstant.C01S016_TEXT );
                            }
                        } else if (IConstant.STRING_4.equals ( stockState )) {
                            //流转中
                            if (IConstant.STRING_3.equals ( toolState )) {
                                //待分拣
                                if (IConstant.C01S010.equals ( nextBusiness )) {
                                    if (gruantUserID == null) {
                                        //授权 TODO
                                        //热套刀具换下的旧刀在安上
                                        onoff = new Onoff ();
                                        onoff.setOnOffCode ( "C01S010_002Activity" );
                                        List<Onoff> onOff = (List<Onoff>) onoffDao.searchByList ( onoff );
                                        // 0为打开，1为关闭
                                        if (IConstant.BAND_TYPE_1.equals ( onOff.get ( 0 ).getOnOffState ().toString () )) {
                                            reVal.put ( IConstant.STATE_CODE, IConstant.BAND_TYPE_0 );
                                        } else {
                                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_1 );
                                        }
                                    } else {
                                        Tool t = new Tool ();
                                        t.setToolID ( tt.getToolID () );
                                        Tool tool = (Tool) toolDao.searchByPrimaryKey ( t );
                                        reVal.put ( "toolCode", tool.getToolCode () );
                                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                    }
                                } else if (IConstant.C01S018.equals ( nextBusiness ) || IConstant.C01S019.equals ( nextBusiness )) {
                                    //正常流程
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                                    stringBuilder.append ( IConstant.C01S018_TEXT + "," + IConstant.C01S019_TEXT );
                                }
                            } else if (IConstant.STRING_4.equals ( toolState )) {
                                //4待换装
                                if (IConstant.C01S010.equals ( nextBusiness )) {
                                    //正常流程
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                } else if (IConstant.C01S018.equals ( nextBusiness )) {
                                        Tool t = new Tool ();
                                        t.setToolID ( tt.getToolID () );
                                        Tool tool = (Tool) toolDao.searchByPrimaryKey ( t );
                                        reVal.put ( "toolCode", tool.getToolCode () );
                                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                                    stringBuilder.append ( IConstant.C01S010_TEXT );
                                }
                            } else if (IConstant.STRING_5.equals ( toolState )) {
                                //5到寿
                                if (IConstant.C01S005.equals ( nextBusiness ) || IConstant.C01S016.equals ( nextBusiness )) {
                                    //正常流程
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                                    stringBuilder.append ( IConstant.C01S005_TEXT + "," + IConstant.C01S016_TEXT );
                                }
                            } else if (IConstant.STRING_6.equals ( toolState )) {
                                //6厂内待刃磨
                                if (IConstant.C01S018.equals ( nextBusiness )) {
                                    //正常流程
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                } else if (IConstant.C01S014.equals ( nextBusiness )) {
                                    if (gruantUserID == null) {
                                        //授权 TODO

                                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_1 );
                                    } else {
                                        Tool t = new Tool ();
                                        t.setToolID ( tt.getToolID () );
                                        Tool tool = (Tool) toolDao.searchByPrimaryKey ( t );
                                        reVal.put ( "toolCode", tool.getToolCode () );
                                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                    }
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                                    stringBuilder.append ( IConstant.C01S018_TEXT );
                                }
                            } else if (IConstant.STRING_7.equals ( toolState )) {
                                //7厂外待刃磨
                                if (IConstant.C01S019.equals ( nextBusiness ) || IConstant.C01S014.equals ( nextBusiness )) {
                                    //正常流程
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                                    stringBuilder.append ( IConstant.C01S019_TEXT );
                                }
                            } else if (IConstant.STRING_8.equals ( toolState )) {
                                //8刃磨完毕   只能走刀具绑定
                                if (IConstant.C01S019.equals ( nextBusiness )) {
                                    //正常流程
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                } else if (IConstant.C01S010.equals ( nextBusiness )) {
                                    if (gruantUserID == null) {
                                        //授权
                                        onoff = new Onoff ();
                                        //厂外待涂层直接可以换装开关
                                        onoff.setOnOffCode ( "C01S010_000Activity" );
                                        List<Onoff> onOff = (List<Onoff>) onoffDao.searchByList ( onoff );
                                        // 0为打开，1为关闭
                                        if (IConstant.BAND_TYPE_1.equals ( onOff.get ( 0 ).getOnOffState ().toString () )) {
                                            reVal.put ( IConstant.STATE_CODE, IConstant.BAND_TYPE_0 );
                                        } else {
                                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_1 );
                                        }
                                    }
                                } else if (IConstant.C01S018.equals ( nextBusiness )) {
                                    if (gruantUserID == null) {
                                        //授权
                                        onoff = new Onoff ();
                                        //热套刀具换下的旧刀在安上
                                        onoff.setOnOffCode ( "C01S018_002Activity" );
                                        List<Onoff> onOff = (List<Onoff>) onoffDao.searchByList ( onoff );
                                        // 0为打开，1为关闭
                                        if (IConstant.BAND_TYPE_1.equals ( onOff.get ( 0 ).getOnOffState ().toString () )) {
                                            reVal.put ( IConstant.STATE_CODE, IConstant.BAND_TYPE_0 );
                                        } else {
                                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_1 );
                                        }
                                    } else {
                                        Tool t = new Tool ();
                                        t.setToolID ( tt.getToolID () );
                                        Tool tool = (Tool) toolDao.searchByPrimaryKey ( t );
                                        reVal.put ( "toolCode", tool.getToolCode () );
                                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                    }
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                                    stringBuilder.append ( IConstant.C01S019_TEXT + "或批量出厂" );
                                }
                            } else if (IConstant.STRING_9.equals ( toolState )) {
                                //,9其他
                                reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                            } else if (IConstant.STRING_10.equals ( toolState )) {
                                //10.已出厂修磨
                                if (IConstant.C01S020.equals ( nextBusiness )) {
                                    //正常流程
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                                    stringBuilder.append ( IConstant.C01S020_TEXT );
                                }
                            } else if (IConstant.STRING_11.equals ( toolState )) {
                                // 11.厂外待涂层
                                if (IConstant.C01S019.equals ( nextBusiness )) {
                                    //正常流程
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                                    stringBuilder.append ( IConstant.C01S019_TEXT );
                                }
                            } else {
                                System.out.println ( "当前刀具没有刀具状态-toolState" );
                            }
                        } else {
                            System.out.println ( "当前刀具没有库存状态-stockState" );
                        }
                    }
                } else {
                    //1)库存新刀
                    if (IConstant.C01S003.equals ( nextBusiness ) || IConstant.C01S004.equals ( nextBusiness )) {
                        //正常
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                    } else {
                        //不正常
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                        //当前刀具只能执行以下流程
                        stringBuilder.append ( IConstant.C01S003_TEXT + "," + IConstant.C01S004_TEXT );
                    }
                }
            } else if (IConstant.STRING_2.equals ( queryType )) {
                stringBuilder.append ( "当前合成刀具只能执行" );
                //合成刀具
                List<Tooltransfer> reTools = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
                if (reTools == null || reTools.size () < 1) {
                    //未找到刀具信息
                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_9 );
                } else {
                    thisBusiness = reTools.get ( 0 ).getBusinessFlowLnkID ();
                    String rfidConnerID = reTools.get ( 0 ).getRfidContainerID ();
                    Synthesisknife sk = new Synthesisknife ();
                    sk.setrFID ( rfidConnerID );
                    List<Synthesisknife> skList = (List<Synthesisknife>) synthesisknifeDao.searchByList ( sk );
                    if (skList != null && skList.size () > 0) {
                        toolCode = skList.get ( 0 ).getSynthesisParametersCode ();
                    }

                    if (IConstant.C01S010.equals ( thisBusiness )) {
                        //刀具换装
                        if (IConstant.C01S010.equals ( nextBusiness )) {
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                            if (gruantUserID == null) {
                                //授权 TODO
                                onoff = new Onoff ();
                                //换装后再次换装
                                onoff.setOnOffCode ( "C01S010_001Activity" );
                                List<Onoff> onOff = (List<Onoff>) onoffDao.searchByList ( onoff );
                                // 0为打开，1为关闭
                                if (onOff.size () > 0 && IConstant.BAND_TYPE_1.equals ( onOff.get ( 0 ).getOnOffState ().toString () )) {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.BAND_TYPE_0 );
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_1 );
                                }

                            } else {
                                reVal.put ( "toolCode", toolCode );
                                reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                            }
                        } else if (IConstant.C01S011.equals ( nextBusiness ) || IConstant.C03S001.equals ( nextBusiness )) {
                            //正常流程
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                        } else {
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                            stringBuilder.append ( IConstant.C01S011_TEXT );
                        }
                    } else if (IConstant.C01S013.equals ( thisBusiness )) {
                        //卸下设备
                        if (IConstant.C01S011.equals ( nextBusiness )) {
                            if (gruantUserID == null) {
                                //授权 TODO
                                onoff = new Onoff ();
                                //换装后再次换装
                                onoff.setOnOffCode ( "C01S013_003Activity" );
                                List<Onoff> onOff = (List<Onoff>) onoffDao.searchByList ( onoff );
                                // 0为打开，1为关闭
                                if (IConstant.BAND_TYPE_1.equals ( onOff.get ( 0 ).getOnOffState ().toString () )) {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.BAND_TYPE_0 );
                                } else {
                                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_1 );
                                }
                            } else {
                                reVal.put ( "toolCode", toolCode );
                                reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                            }
                        } else if (IConstant.C01S010.equals ( nextBusiness ) || IConstant.C03S001.equals ( nextBusiness ) || IConstant.C01S006.equals ( nextBusiness )) {
                            //正常流程
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                        } else {
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                            stringBuilder.setLength(0);
                            stringBuilder.append("当前设备已卸下");
                        }
                    } else if (IConstant.C01S006.equals ( thisBusiness )) {
                        //刀具卸下辅具
                        if (IConstant.C01S007.equals ( nextBusiness )) {
                            //正常流程
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                        } else {
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                            stringBuilder.append ( IConstant.C01S007_TEXT );
                        }
                    } else if (IConstant.C01S007.equals ( thisBusiness )) {
                        //刀具安上辅具
                        if (IConstant.C01S011.equals ( nextBusiness )) {
                            //正常流程
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                        } else {
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                            stringBuilder.append ( IConstant.C01S011_TEXT );
                        }
                    } else if (IConstant.C01S011.equals ( thisBusiness )) {
                        //卸下安上设备
                        if (IConstant.C01S013.equals ( nextBusiness ) || IConstant.C03S001.equals ( nextBusiness )) {
                            //正常流程
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                        } else {
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                            stringBuilder.append ( IConstant.C01S013_TEXT );
                        }
                        //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
                    } else if (IConstant.C03S001.equals ( thisBusiness )) {
                        //初始化
                        if(IConstant.C01S013.equals ( nextBusiness )){
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                            stringBuilder.append ( IConstant.C01S011_TEXT );
                        }else{
                            //正常流程
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                        }
                    }
                    //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
                    //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
                    else if (IConstant.C01S017.equals ( thisBusiness )) {
                        if(IConstant.C01S013.equals ( nextBusiness )){
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                            stringBuilder.append ( IConstant.C01S011_TEXT );
                        }else{
                            //正常流程
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                        }

                    }
                    else if (IConstant.C01S018.equals ( thisBusiness )) {
                        if(IConstant.C01S013.equals ( nextBusiness )){
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                            stringBuilder.append ( IConstant.C01S011_TEXT );
                        }else{
                            //正常流程
                            reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                        }
                    }
                    else if (IConstant.C01S019.equals ( thisBusiness )) {

                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                        stringBuilder.append ( IConstant.C01S017_TEXT );
                    }
                    else if (IConstant.C01S008.equals ( thisBusiness )){

                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                        stringBuilder.append ( IConstant.C01S009_TEXT );
                    }
                    else if (IConstant.C01S009.equals ( thisBusiness )) {

                        if (IConstant.C01S011.equals(nextBusiness)) {

                            //正常流程
                            reVal.put(IConstant.STATE_CODE, IConstant.STRING_0);
                        } else {

                            reVal.put(IConstant.STATE_CODE, IConstant.STRING_2);
                            stringBuilder.append(IConstant.C01S011_TEXT);
                        }
                    }

                    //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
                    else {
                        System.out.println ( "当前刀具没有流程状态-BusinessFlowLnkID---" + thisBusiness );
                    }
                }
            } else if (IConstant.STRING_5.equals ( queryType )) {
                //5容器  TODO 怎么管理
                stringBuilder.append ( "当前容器" );
                Containercarrier ctn = new Containercarrier ();
                ctn.setRfidContainerID ( rfidcontainer.getRfidContainerID () );
                ctn.setDelFlag ( IConstant.DEL_FLAG_0 );
                List<Containercarrier> reList = (List<Containercarrier>) containercarrierDao.searchByList ( ctn );
                if (reList == null || reList.size () < 1) {
                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_1 );
                    stringBuilder.append ( "未找到" );
                }
                //0备用刀，1一次性报废 2待分拣容器 3厂内待刃磨 4厂外待刃磨 5刃磨完毕 6刃磨报废 7待涂层 8库房报废 9报废容器）
                String carrierType = reList.get ( 0 ).getContainerCarrierType ();
                if (IConstant.STRING_0.equals ( carrierType ) || IConstant.STRING_6.equals ( carrierType ) || IConstant.STRING_7.equals ( carrierType ) || IConstant.STRING_8.equals ( carrierType ) || IConstant.STRING_9.equals ( carrierType )) {
                    //0备用刀  6刃磨报废  7待涂层 8库房报废 9其他
                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_1 );
                    stringBuilder.append ( "非流转容器，请勿执行此容器" );
                } else if (IConstant.STRING_1.equals ( carrierType )) {
                    //  1一次性报废
                    if (IConstant.C01S016.equals ( nextBusiness ) || IConstant.C01S010.equals ( nextBusiness )) {
                        //正常流程
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                    } else {
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                        stringBuilder.append ( "不能执行此流程" );
                    }
                } else if (IConstant.STRING_2.equals ( carrierType )) {
                    // 2待分拣容器
                    if (IConstant.C01S014.equals ( nextBusiness ) || IConstant.C01S010.equals ( nextBusiness )) {
                        //正常流程
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                    } else {
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                        stringBuilder.append ( "不能执行此流程" );
                    }
                } else if (IConstant.STRING_3.equals ( carrierType )) {
                    // 3厂内待刃磨
                    if (IConstant.C01S018.equals ( nextBusiness ) || IConstant.C01S027.equals ( nextBusiness )) {
                        //正常流程
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                    } else {
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                        stringBuilder.append ( "不能执行此流程" );
                    }
                } else if (IConstant.STRING_4.equals ( carrierType )) {
                    //  4厂外待刃磨
                    if (IConstant.C01S014.equals ( nextBusiness ) || IConstant.C01S019.equals ( nextBusiness )) {
                        //正常流程
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                    } else {
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                        stringBuilder.append ( "不能执行此流程" );
                    }
                } else if (IConstant.STRING_1.equals ( carrierType )) {
                    // 5刃磨完毕
                    if (IConstant.C01S027.equals ( nextBusiness )) {
                        //正常流程
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_0 );
                    } else {
                        reVal.put ( IConstant.STATE_CODE, IConstant.STRING_2 );
                        stringBuilder.append ( "不能执行此流程" );
                    }
                } else {
                    reVal.put ( IConstant.STATE_CODE, IConstant.STRING_9 );
                    stringBuilder.append ( "非流转容器，请勿执行此容器" );
                }
            } else {
                //不在流程中的标签
                reVal.put ( IConstant.STATE_CODE, IConstant.STRING_9 );
            }
        }
        reVal.put ( IConstant.STATE_MSG, stringBuilder.toString () );
        return reVal;
    }

    @Override
    public String getSynthesisToolCode(String synthesisParametersCode) throws Exception {
        Synthesisparameters synthesisparameters = new Synthesisparameters ();
        synthesisparameters.setSynthesisParametersCode ( synthesisParametersCode );
        synthesisparameters.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Synthesisparameters> reval = (List<Synthesisparameters>) synthesisparametersDao.searchByList ( synthesisparameters );
        if (reval == null || reval.size () < 1) {
            return null;
        } else {
            return reval.get ( 0 ).getSynthesisParametersID ();

        }
    }

    @Override
    public List<Parts> getPartsList(Parts parts) throws SQLException {
        return (List<Parts>) partsDao.searchByList ( parts );
    }

    @Override
    public List<Formulas> getFormulasList(Formulas formulas) throws SQLException {

        return (List<Formulas>) formulasDao.searchByList ( formulas );
    }

    @Override
    public String getToolIDByToolCode(String toolCode) throws Exception {
        Tool t = new Tool ();
        t.setToolCode ( toolCode );
        List<Tool> tools = toolDao.getToolIDByToolCode ( t );
        if (tools == null || tools.size () < 1) {
            return null;
        }
        return tools.get ( 0 ).getToolID ();
    }

    @Override
    public int getContainerTypeByRfidContainer(Containercarrier cc) throws Exception {
        return containercarrierDao.searchByCount ( cc );
    }

    @Override
    public int delRfidCodeIsNullByToolType(Map<String, Object> param) {
        int reVal = 0;
        //  标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器)
        String toolType = (String) param.get ( "toolType" );
        List<String> rfidCodes = (List<String>) param.get ( "rfidCodes" );
        if (rfidCodes == null || rfidCodes.size () < 1) {
            return reVal;
        }
        try {
            if (IConstant.STRING_0.equals ( toolType )) {
                //0库位标签
                reVal += knifeinventoryDao.deleteByRfidCodeList ( rfidCodes );
            } else if (IConstant.STRING_1.equals ( toolType )) {
                //1单品刀
                reVal += knifeinventoryDao.deleteByRfidCodeList ( rfidCodes );
                reVal += tooltransferDao.deleteByRfidCodeList ( rfidCodes );
            } else if (IConstant.STRING_2.equals ( toolType )) {
                //2合成刀具
                reVal += synthesisknifeDao.deleteBatchByRfidCodeList ( rfidCodes );
                reVal += tooltransferDao.deleteByRfidCodeList ( rfidCodes );
            } else if (IConstant.STRING_3.equals ( toolType )) {
                //3员工卡
                reVal += customerDao.updateBatchByRFIdLists ( rfidCodes );
            } else if (IConstant.STRING_4.equals ( toolType )) {
                //4设备
                reVal += equipmentDao.deleteBatchByRfidCodeList ( rfidCodes );
            } else if (IConstant.STRING_5.equals ( toolType )) {
                //5容器
                reVal += tooltransferDao.deleteByRfidCodeList ( rfidCodes );
            } else {
                return reVal;
            }
            //rfid载体清空
            if (reVal > 0) {
                reVal += rfidcontainerDao.deleteByRfidCodeList ( rfidCodes );
            }
        } catch (SQLException e) {
            System.out.println ( "CommonServiceImpl.java -- delRfidCodeIsNullByToolType ----" + e.toString () );
            reVal = 0;
        }

        return reVal;
    }

    // 2017/09/18 王冉 追加↓↓↓　dazhong@YMSC
    @Override
    public Map<String, Object> delRfidCodeIsNull(Map<String, Object> param) {
        Map<String, Object> ret = new HashMap<String, Object>();

        List<String> rfidCodes = (List<String>) param.get ( "rfidCodes" );
        if (rfidCodes == null || rfidCodes.size () < 1) {
            ret.put("status",IConstant.STRING_1);
            ret.put("message","请扫描标签");
            return ret;
        }
        try {
            for(int i = 0;i < rfidCodes.size();i++){
                Rfidcontainer rfidEntity = new Rfidcontainer();
                rfidEntity.setRfidCode(rfidCodes.get(i));
                List<Rfidcontainer> rfidcontainerList = rfidcontainerDao
                        .searchByList2(rfidEntity);

                Rfidcontainer rfidcontainer = rfidcontainerList.get(0);
                // 根据载体ID查询合成刀具信息
                Synthesisknife skentity = new Synthesisknife();
                skentity.setrFID(rfidcontainer.getRfidContainerID());

                Synthesisknife reVal = synthesisknifeDao.getSynthesisknife(skentity);
                // 一体刀
                if("4".equals(reVal.getCreateType())){
                    // 已出厂不可清空
                    if ("7".equals(reVal.getLoadState())) {
                        ret.put("status",IConstant.STRING_1);
                        ret.put("message","该刀具已出厂，不可清空");
                        return ret;
                    }

                    // 未卸下 ,未修磨的一体刀不可清空
                    if ("1".equals(reVal.getLoadState())
                            || "4".equals(reVal.getLoadState()) || "10".equals(reVal.getLoadState()) || "12".equals(reVal.getLoadState())) {

                    } else {
                        ret.put("status",IConstant.STRING_1);
                        ret.put("message","不可清空未卸下或未修磨的一体刀");
                        return ret;

                    }

                    // 根据合成刀具码查询对应刀具信息
                    List<Tool> toolList = toolDao.searchToolInfoBySpcode(reVal.getSynthesisParametersCode());

                    // 根据材料号查询流转统计表数据
                    TooltransferTotal tstEntity = new TooltransferTotal();
                    tstEntity.setToolCode(toolList.get(0).getToolCode());
                    List<TooltransferTotal> tst = tooltransferDao.searchList(tstEntity);

                    if (null != tst) {

                        // 根据材料号查询刀具参数信息
                        Tool toolEntity = new Tool();
                        toolEntity.setToolCode(toolList.get(0).getToolCode());
                        // 根据刀具码查询刀具信息
                        List<Tool> toolInfo = toolDao
                                .searchBitInputInfo(toolEntity);
                        // 卸下后清空的场合
                        if ("1".equals(reVal.getLoadState())) {
                            // 减待修磨
                            // 厂外的场合 减厂外待刃磨
                            if("1".equals(toolInfo.get(0).getToolGrinding())){
                                // 新厂外待修磨 = 当前厂外待刃磨数量-修磨数量
                                tstEntity.setStayExternalGrindingSum(tst.get(0)
                                        .getStayExternalGrindingSum().subtract(BigDecimal.ONE));
                                // 厂内涂层或 厂内修磨 减厂内待修磨
                            }else{
                                // 新厂外待修磨 = 当前厂外待刃磨数量-修磨数量
                                tstEntity.setGrindingFactorySnum(tst.get(0)
                                        .getGrindingFactorySnum().subtract(BigDecimal.ONE));
                            }


                            // 修磨后清空的场合
                        } else if("4".equals(reVal.getLoadState()) || "10".equals(reVal.getLoadState())){

                            // 刀具修磨类型为厂外涂层- 厂外待刃磨
                            if("2".equals(toolInfo.get(0).getToolGrinding())){
                                // 新厂外待修磨 = 当前厂外待刃磨数量-修磨数量
                                tstEntity.setStayExternalGrindingSum(tst.get(0)
                                        .getStayExternalGrindingSum().subtract(BigDecimal.ONE));
                                // 刀具修磨类型为厂内修磨或厂外修磨 - 备刀
                            }else{
                                // 新厂备刀数
                                tstEntity.setSpareKnifeSum(tst.get(0)
                                        .getSpareKnifeSum().subtract(BigDecimal.ONE));
                            }

                            //回厂后清空的场合
                        }else if("8".equals(reVal.getLoadState())){
                            // 新备刀数
                            tstEntity.setSpareKnifeSum(tst.get(0)
                                    .getSpareKnifeSum().subtract(BigDecimal.ONE));

                            //单品绑定后清空的场合
                        }else {
                            // 新备刀数
                            tstEntity.setSpareKnifeSum(tst.get(0)
                                    .getSpareKnifeSum().add(BigDecimal.ONE));
                            // 新备刀数
                            tstEntity.setProductionLineSum(tst.get(0)
                                    .getProductionLineSum().subtract(BigDecimal.ONE));
                        }

                        // 更新流转统计表数据
                        vsynthesisconditionDao.updateTooltransferTotal(tstEntity);
                    }

                    // 只单品绑定的一体刀 删除刀具加工信息,车间加工量汇总信息、刃磨记录
                    if ("12".equals(reVal.getLoadState())) {
                        Toolsmachining ts = new Toolsmachining();
                        ts.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                        toolsmachiningDao.delete(ts);
                        Synthesistoolsmachining stm = new Synthesistoolsmachining();
                        stm.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                        synthesistoolsmachiningDao.delete(stm);
                        Toolnoticehistory th = new Toolnoticehistory();
                        th.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                        toolnoticehistoryDao.delete(th);
                    }

                }else{
                    if ("6".equals(reVal.getLoadState())) {
                        ret.put("status",IConstant.STRING_1);
                        ret.put("message","当前刀具已拆分，不可清空标签");
                        return ret;
                    }

                    Rfidcontainer rfBean = new Rfidcontainer();
                    rfBean.setRfidCode(rfidCodes.get(i));

                    // 查询已经有的合成刀具信息
                    List<String> rfidList = new ArrayList<String>();
                    rfidList.add(rfidCodes.get(i));
                    List<Synthesisknife> skList = synthesisknifeDao.findskListByRfidList(rfidList);
                    if (skList.size() > 0) {
                        Map<String, Object> map2 = new HashMap<String, Object>();
                        map2.put("delFlag", IConstant.DEL_FLAG_1);
                        map2.put("userId", param.get("customerID"));
                        map2.put("updateTime", new Date());
                        map2.put("list", rfidList);
                        // 删除流转中的数据
                        tooltransferDao.updateBatchDeFlagByRfid(map2);
                        Synthesisknife sk1 = null;
                        // 删除合成刀库中的数据
                        for (Synthesisknife sk : skList) {
                            // 合成刀库
                            sk1 = new Synthesisknife();
                            sk1.setDelFlag(IConstant.DEL_FLAG_1);
                            sk1.setUpdateUser(param.get("customerID").toString());
                            sk1.setSynthesisParametersCodeWhere(sk
                                    .getSynthesisParametersCode());
                            sk1.setSynthesisParametersNumberWhere(sk
                                    .getSynthesisParametersNumber());
                            synthesisknifeDao.updateNonQuery(sk1);
                        }
                    }

                    // 查询刀具参数
                    List<Synthesiscutterlocation> syList = synthesiscutterlocationDao
                            .searchSynthesiscutterlocationBySpCode(reVal.getSynthesisParametersCode());
                    for (int j = 0; j < syList.size(); j++) {
                        // 根据材料号查询流转统计表数据
                        TooltransferTotal tstEntity = new TooltransferTotal();
                        tstEntity.setToolCode(syList.get(
                                j).getToolCode());
                        List<TooltransferTotal> tst = tooltransferDao.searchList(tstEntity);
                        if (tst.size() > 0) {
                            // 更新条件-刀具材料号
                            //tstEntity.setToolCode(syList.get(i).getToolCode());
                            tstEntity.setUpdateUser(param.get("customerID").toString());
                            // 组装数量
                            tstEntity.setProductionLineSum(tst.get(0).getProductionLineSum().
                                    subtract(BigDecimal.valueOf(Integer.valueOf(syList.get(j).getToolCount()))));


                            // 更新流转统计表数据
                            vsynthesisconditionDao.updateTooltransferTotal(tstEntity);
                        }
                    }

                }


            }

            synthesisknifeDao.deleteBatchByRfidCodeList ( rfidCodes );
            knifeinventoryDao.deleteByRfidCodeList ( rfidCodes );
            tooltransferDao.deleteByRfidCodeList ( rfidCodes );
            rfidcontainerDao.deleteByRfidCodeList ( rfidCodes );

        } catch (Exception e) {
            System.out.println ( "CommonServiceImpl.java -- delRfidCodeIsNullByToolType ----" + e.toString () );

        }
        ret.put("status",IConstant.STRING_0);
        return ret;
    }
    // 2017/09/18 王冉 追加↑↑↑　dazhong@YMSC


    @Override
    public Tool getToolsByID(String toolID) throws SQLException {
        Tool tool = new Tool ();
        tool.setToolID ( toolID );
        return (Tool) toolDao.searchByPrimaryKey ( tool );

    }


}