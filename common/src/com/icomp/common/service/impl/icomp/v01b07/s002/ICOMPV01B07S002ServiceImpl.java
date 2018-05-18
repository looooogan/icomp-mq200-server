package com.icomp.common.service.impl.icomp.v01b07.s002;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b07.s002.ICOMPV01B07S002Service;
import com.icomp.dao.SubToolAvgToolSharpennumDao;
import com.icomp.dao.SubToolProcessAmountDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.VinventoryalarmDao;
import com.icomp.dao.VtoolalarmparamDao;
import com.icomp.dao.VtoolshertoolDao;
import com.icomp.entity.base.SubToolAvgToolSharpennum;
import com.icomp.entity.base.SubToolProcessAmount;
import com.icomp.entity.base.Vinventoryalarm;
import com.icomp.entity.base.Vtoolalarmparam;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存异常报警SERVICE实现类
 *
 * @author Licc
 * @ClassName: ICOMPV01B07S002ServiceImpl
 * @date 2014-8-20 下午04:20:08
 */
@SuppressWarnings("unchecked")
public class ICOMPV01B07S002ServiceImpl extends BaseService implements ICOMPV01B07S002Service {
    private VinventoryalarmDao vinventoryalarmDao;
    private VtoolalarmparamDao vtoolalarmparamDao;
    private TooltransferDao tooltransferDao;
    private ToolDao toolDao;
    private VtoolshertoolDao vtoolshertoolDao;

    public void setVtoolshertoolDao(VtoolshertoolDao vtoolshertoolDao) {
        this.vtoolshertoolDao = vtoolshertoolDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    public void setVtoolalarmparamDao(VtoolalarmparamDao vtoolalarmparamDao) {
        this.vtoolalarmparamDao = vtoolalarmparamDao;
    }

    public void setVinventoryalarmDao(VinventoryalarmDao vinventoryalarmDao) {
        this.vinventoryalarmDao = vinventoryalarmDao;
    }

    private SubToolProcessAmountDao subToolProcessAmountDao;

    public void setSubToolProcessAmountDao(SubToolProcessAmountDao subToolProcessAmountDao) {
        this.subToolProcessAmountDao = subToolProcessAmountDao;
    }

    private SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao;

    public void setSubToolAvgToolSharpennumDao(SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao) {
        this.subToolAvgToolSharpennumDao = subToolAvgToolSharpennumDao;
    }

    public Map<String, Object> getInventoryCountList(Vinventoryalarm entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            //ToolCode模糊查询
            List<Vinventoryalarm> list = (List<Vinventoryalarm>) vinventoryalarmDao.searchByList_F ( entity );
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
                Collections.sort ( resultList );
                int total = vinventoryalarmDao.searchByCount_F ( entity );
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

        }
        return rtn;
    }

    @Override
    public Map<String, Object> getLists(Vtoolalarmparam entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            //查询类型（0:新刀库，1:备刀库）
            String pVentoryType = entity.getDelFlag ();
            List<Vtoolalarmparam> list = null;
            if (IConstant.STRING_0.equals ( pVentoryType )) {
                //0:新刀库
                list = vtoolalarmparamDao.searchNewVentoryList ( entity );
            } else {
                //  1:备刀库
                list = vtoolalarmparamDao.searchTooltreantList ( entity );
            }

            if (list.size () <= 0) {
                list = new ArrayList<> ();
                Vtoolalarmparam vtoolalarmparam = new Vtoolalarmparam ();
                vtoolalarmparam.setMessageCode ( IConstant.EMSG0001 );
                vtoolalarmparam.setRetErrFlag ( true );
                list.add ( vtoolalarmparam );
                rtn.put ( "status", IConstant.RESULT_CODE_1 );//条数为0
                rtn.put ( "rows", null );
                rtn.put ( "error", list );

            } else {
                for (Vtoolalarmparam vn : list) {
                   //刀具类型
                    vn.setToolConsumetype ( vn.getToolCode().substring ( 0, 1 ) );
                    //预警线数量
                    vn.setExpandSpace4 ( vn.getStandard () + "~" + vn.getCstandard () );
                    //差额数量
                    String lessStr = vn.getExpandSpace1 ();
                    if (StringUtils.isEmpty ( lessStr )) {
                        lessStr = IConstant.STRING_0;
                    }
                    if (StringUtils.isEmpty ( vn.getExpandSpace2 () )) {
                        vn.setExpandSpace2 (IConstant.STRING_0);
                    }
                    int lessZero = Integer.parseInt ( lessStr);
                    if (lessZero < 0) {
                        vn.setCstandard ( new BigDecimal ( lessStr ));
                    } else {
                        vn.setCstandard ( new BigDecimal ( vn.getExpandSpace2 () ) );
                    }
                    //预警类型
                    vn.setExpandSpace3 (pVentoryType );
                }
                int total = 0;
                if (IConstant.STRING_0.equals ( pVentoryType )) {
                    //0:新刀库
                    total = vtoolalarmparamDao.searchNewVentoryCount ( entity );
                } else {
                    //  1:备刀库
                    total = vtoolalarmparamDao.searchTooltreantCount ( entity );
                }
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );
            }

        } catch (SQLException e) {
            List<Vtoolalarmparam> list = new ArrayList<Vtoolalarmparam> ();
            Vtoolalarmparam vtoolalarmparam = new Vtoolalarmparam ();
            vtoolalarmparam.setMessageCode ( IConstant.EMSG0004 );
            vtoolalarmparam.setRetErrFlag ( true );
            vtoolalarmparam.setExceMessage ( e.getMessage () );
            list.add ( vtoolalarmparam );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
        return rtn;
    }

    @Override
    public String getNumber() {
        int total = 0;
        try {
            Vtoolalarmparam vtool = new Vtoolalarmparam ();
            vtool.setDelFlag ( IConstant.DEL_FLAG_0 );
            total = vtoolalarmparamDao.searchByCount ( vtool );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return String.valueOf ( total );
    }
}
