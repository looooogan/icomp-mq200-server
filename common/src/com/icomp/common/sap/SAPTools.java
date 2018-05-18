package com.icomp.common.sap;

import com.icomp.common.constant.IConstant;
import com.icomp.common.utils.UUIDgen;
import com.icomp.entity.base.Toolprocured;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TYY
 * @className SAPTools
 * @date 2016/8/31 9:17
 */
public class SAPTools {

    /**
     * 根据材料号查询对应的平均价-调用SAP
     *
     * @param toolCode
     * @return
     */
    public static Double getPriceFromSAP(String toolCode) {
        try {
            if (toolCode == null) {
                return 0.0;
            }
            JCoFunction function = null;
            JCoDestination destination = SAPConn.connect ();
            //调用ZGE_CTM_11函数
            function = destination.getRepository ().getFunction ( "ZGE_CTM_11" );
            //将当前传入的值赋予各个参数
            function.getImportParameterList ().setValue ( "MATERIAL", toolCode );

            JCoParameterList price = function.getExportParameterList ();
            function.execute ( destination );
            //平均价
            String avgPrice = price.getString ( "VERPR" );
            return Double.parseDouble ( avgPrice );
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return 0.0;
    }

    /**
     * 根据根据订单号查询订单详情
     *
     * @param purchaseOrder
     * @return
     */
    public static List<Toolprocured> getPoFromSAP(String purchaseOrder) {
        List<Toolprocured> tplist = new ArrayList<> ();
        JCoFunction function = null;
        JCoDestination destination = SAPConn.connect ();
        if (StringUtils.isEmpty ( purchaseOrder )) {
            return tplist;
        }
        try {
            //调用ZRFC_GET_REMAIN_SUM函数
            function = destination.getRepository ().getFunction ( "BAPI_PO_GETDETAIL" );
            //将当前传入的值赋予各个参数
            function.getImportParameterList ().setValue ( "PURCHASEORDER", purchaseOrder );
            function.getImportParameterList ().setValue ( "HISTORY", "X" );
            // 取PO_ITEMS信息
            JCoTable P_TABLE = function.getTableParameterList ().getTable ( "PO_ITEMS" );
            // 取P_HEADER_DELIV信息(到货数量)
            JCoTable P_HEADER_DELIV = function.getTableParameterList ().getTable ( "PO_ITEM_HISTORY_TOTALS" );
            // 取PO_HEADER信息
            JCoStructure P_HEADER = function.getExportParameterList ().getStructure ( "PO_HEADER" );

            //执行
            function.execute ( destination );
            Map<String, Integer> map = new HashMap<> ();
            Toolprocured tp = null;
            //         System.out.println ( P_TABLE.toString () );
            for (int i = 0; i < P_HEADER_DELIV.getNumRows (); i++) {
                P_HEADER_DELIV.setRow ( i );
                map.put ( P_HEADER_DELIV.getString ( "PO_ITEM" ), P_HEADER_DELIV.getInt ( "DELIV_QTY" ) );
            }
            for (int i = 0; i < P_TABLE.getNumRows (); i++) {
                P_TABLE.setRow ( i );
                tp = new Toolprocured ();
                tp.setToolProcuredID ( UUIDgen.getId () );
                //订单号
                tp.setToolsOrdeNO ( P_TABLE.getString ( "PO_NUMBER" ) );
                //采购批次
                tp.setProcuredBatch ( P_TABLE.getString ( "PREQ_NO" ) );
                //采购日期
                tp.setProcuredTime ( P_HEADER.getString ( "CREATED_ON" ) );
                //采购单价
                tp.setUnitPrice ( P_TABLE.getString ( "NET_PRICE" ) );
                //采购者
                tp.setProcuredUser ( P_HEADER.getString ( "SALES_PERS" ) );
                //采购数量
                String procuredCount = P_TABLE.getString ( "QUANTITY" );
                if (StringUtils.isEmpty ( procuredCount )) {
                    tp.setProcuredCount ( BigDecimal.ZERO );
                    tp.setProcuredNumber ( BigDecimal.ZERO );
                } else {
                    tp.setProcuredCount ( new BigDecimal ( procuredCount ) );
                    tp.setProcuredNumber ( new BigDecimal ( procuredCount ) );
                }
                //材料号
                String toolCode = P_TABLE.getString ( "MATERIAL" );
                //采购类型(0新采购1外委图层2外委复磨9其他)
                if ("X".equalsIgnoreCase ( toolCode.substring ( toolCode.length () - 1, toolCode.length () ) )) {
                    //2外委复磨
                    tp.setToolCode ( toolCode.substring ( 0, toolCode.length () - 1 ) );
                    tp.setProcuredType ( IConstant.PROCURED_TYPE_2 );
                } else if ("T".equalsIgnoreCase ( toolCode.substring ( toolCode.length () - 1, toolCode.length () ) )) {
                    //1外委图层
                    tp.setToolCode ( toolCode.substring ( 0, toolCode.length () - 1 ) );
                    tp.setProcuredType ( IConstant.PROCURED_TYPE_1 );
                } else {
                    //0新采购
                    tp.setProcuredType ( IConstant.PROCURED_TYPE_0 );
                    tp.setToolCode ( toolCode );
                }
                String key = P_TABLE.getString ( "PO_ITEM" );
                tp.setExpandSpace1 ( map.get ( key ) + "" );
                tp.setExpandSpace2 ( P_TABLE.getString ( "PREQ_NO" ) );
                tp.setDelFlag ( IConstant.DEL_FLAG_0 );
                tp.setCreateTime ( new Date () );
                tp.setUpdateTime ( new Date () );
                tplist.add ( tp );
            }
             /*  System.out.println ( P_HEADER.toString () );
            System.out.println ( "--------P_HEADER----------BEGEN-----------------------------" );
            System.out.println ( "供应商代码----" + P_HEADER.getString ( "VENDOR" ) );
            System.out.println ( "供应商名称----" + P_HEADER.getString ( "VEND_NAME" ) );
            System.out.println ( "--------P_HEADER----------END-----------------------------" );*/
        } catch (Exception e) {
            e.printStackTrace ();
            System.out.println ( "getPoFromSAP--" + e.toString () );
            tplist = new ArrayList<> ();
        }
        return tplist;
    }

    /**
     * 根据需求单号查询订单号
     *
     * @param number
     * @return
     */
    public static String getOrderNoByMumber(String number) {
        JCoFunction function = null;
        String orderNo = null;
        JCoDestination destination = SAPConn.connect ();
        if (StringUtils.isEmpty ( number )) {
            return orderNo;
        }
        //
        number = getAllOrderNO ( number );
        try {
            //调用ZRFC_GET_REMAIN_SUM函数
            function = destination.getRepository ().getFunction ( "BAPI_PR_GETDETAIL" );
            //将当前传入的值赋予各个参数
            function.getImportParameterList ().setValue ( "NUMBER", number );
            JCoTable PRITEM = function.getTableParameterList ().getTable ( "PRITEM" );
            //执行
            function.execute ( destination );
            //     System.out.println ( "PRITEM---" + PRITEM.toString () );
            if (PRITEM.getNumRows () < 1) {
                return orderNo;
            }
            for (int i = 0; i < PRITEM.getNumRows (); i++) {
                PRITEM.setRow ( i );
                //一个需求单号只能对应 一个订单号
                orderNo = PRITEM.getString ( "PO_NUMBER" );
                if (!StringUtils.isEmpty ( orderNo )) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return orderNo;
    }

    /**
     * 补全位数
     *
     * @param mubers
     * @return
     */
    public static String getAllOrderNO(String mubers) {
        if (mubers == null) {
            return null;
        }
        int lengs = mubers.length ();
        if (lengs == 8) {
            mubers = "00" + mubers;
        } else if (lengs == 9) {
            mubers = "0" + mubers;
        } else if (lengs == 7) {
            mubers = "000" + mubers;
        }
        return mubers;
    }

    public static void main(String[] args) {
  /* List<Toolprocured> tplist = getPoFromSAP ( "8001754044" );
        for (Toolprocured tp : tplist) {
            System.out.println ( "订单号----" + tp.getToolsOrdeNO () );
            System.out.println ( "材料号----" + tp.getToolCode () );
            System.out.println ( "到货数量----" + tp.getExpandSpace1 () );
            System.out.println ( "需求号----" + tp.getExpandSpace2 () );
            System.out.println ( "****************************************************************************" );
        }*/
        System.out.println ( System.getProperty ( "os.name" ) );
  /*      String tplist = getOrderNoByMumber ( "0050065684" );

        System.out.println ( "****************************************************************************" );

        System.out.println ( "订单 号---" + tplist );*/
    }

}
