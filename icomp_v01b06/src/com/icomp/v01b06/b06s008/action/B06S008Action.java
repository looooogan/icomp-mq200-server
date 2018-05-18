package com.icomp.v01b06.b06s008.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.CapitalTakes;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b06.b06s008.business.B06S008Business;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * 刀具资金占用情况分析Action
 *
 * @author Taoyy
 * @ClassName: B06S008Action
 * @date 2014-8-22 上午09:05:25
 */

public class B06S008Action extends IcompAction {
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 7255161566182210074L;
    /**
     * 刀具资金占用情况分析BUSINESS
     */
    private B06S008Business b06s008Business;

    public void setB06s008Business(B06S008Business b06s008Business) {
        this.b06s008Business = b06s008Business;
    }

    /**
     * 初始化刀具资金占用情况分析页面
     *
     * @return String
     * @title initb01S008
     */
    public String initb06S008() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            if ("list".equals ( param.get ( "opt" ) )) {
                // 刀具资金占用情况分析列表
                Map<String, Object> list = this.b06s008Business.getList ( param, langCode, langValue );
                super.ajaxReturn ( list );
                return null;
            } else {
                total = this.b06s008Business.getNumber ();
                // 取得页面grid显示项目列表
                super.session ( "gridcol", b06s008Business.getGridColmun ( "B06S008", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
            }
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B06S008.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B06S008", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return NONE;
        }
    }

    /**
     * 刀具资金占用情况分析统计
     *
     * @return String
     * @title statistics_b06S002
     */
    public String statistics_b06S008() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            if ("list".equals ( param.get ( "opt" ) )) {
                Double dou = 0.0, dou1 = 0.0, dou2 = 0.0, dou3 = 0.0, dou4 = 0.0, dou5 = 0.0,  dou7 = 0.0,  dou8 = 0.0, dou6 = 0.0;

                // 刀具资金占用情况分析列表
                Map<String, Object> list = this.b06s008Business.getLists ( param, langCode, langValue );
                DecimalFormat df = new DecimalFormat ( "######0.0000" );
                for (CapitalTakes ca : (List<CapitalTakes>) list.get ( "rows" )) {

                    //（厂内）
                    if (StringUtils.isEmpty ( ca.getNumberDevices () ))
                        ca.setNumberDevices ( IConstant.DEL_FLAG_0 );
                    dou += Double.parseDouble ( ca.getNumberDevices () );
                    if("-".equals(ca.getNumberDevices ())){
                        dou += Double.parseDouble ("0");
                    }else{
                        dou += Double.parseDouble ( ca.getNumberDevices () );
                    }
                    //厂外
                    if (StringUtils.isEmpty ( ca.getNumberDevices1 () ))
                        ca.setNumberDevices1 ( IConstant.DEL_FLAG_0 );
                    //dou1 += Double.parseDouble ( ca.getNumberDevices1 () );
                    if("-".equals(ca.getNumberDevices1 ())){
                        dou1 += Double.parseDouble ("0");
                    }else{
                        dou1 += Double.parseDouble ( ca.getNumberDevices1 () );
                    }
//                    //（待送回）
//                    if (StringUtils.isEmpty ( ca.getNumberDevices2 () ))
//                        ca.setNumberDevices2 ( IConstant.DEL_FLAG_0 );
//                    dou2 += Double.parseDouble ( ca.getNumberDevices2 () );
                    //（厂外修磨）
                    if (StringUtils.isEmpty ( ca.getNumberDevices3 () ))
                        ca.setNumberDevices3 ( IConstant.DEL_FLAG_0 );
                    //dou3 += Double.parseDouble ( ca.getNumberDevices3 () );
                    if("-".equals(ca.getNumberDevices3 ())){
                        dou3 += Double.parseDouble ("0");
                    }else{
                        dou3 += Double.parseDouble ( ca.getNumberDevices3 () );
                    }
                    //（库房）
                    if (StringUtils.isEmpty ( ca.getNumberDevices4 () ))
                        ca.setNumberDevices4 ( IConstant.DEL_FLAG_0 );
                    //dou4 += Double.parseDouble ( ca.getNumberDevices4 () );
                    if("-".equals(ca.getNumberDevices4 ())){
                        dou4 += Double.parseDouble ("0");
                    }else{
                        dou4 += Double.parseDouble ( ca.getNumberDevices4 () );
                    }

                    //（备刀库）
                    if (StringUtils.isEmpty ( ca.getNumberDevices5 () ))
                        ca.setNumberDevices5 ( IConstant.DEL_FLAG_0 );
                    //dou5 += Double.parseDouble ( ca.getNumberDevices5 () );
                    if("-".equals(ca.getNumberDevices5 ())){
                        dou5 += Double.parseDouble ("0");
                    }else{
                        dou5 += Double.parseDouble ( ca.getNumberDevices5 () );
                    }
//                    //（报废）
//                    if (StringUtils.isEmpty ( ca.getNumberDevices6 () )) {
//                        ca.setNumberDevices6 ( IConstant.DEL_FLAG_0 );
//                    }
                    //dou6 += Double.parseDouble ( ca.getNumberDevices6 () );
                    //生产线
                    if (StringUtils.isEmpty ( ca.getExpandSpace1 () ))
                        ca.setExpandSpace1 ( IConstant.DEL_FLAG_0 );
                    //dou7 += Double.parseDouble ( ca.getExpandSpace1 () );
                    if("-".equals(ca.getExpandSpace1 ())){
                        dou7 += Double.parseDouble ("0");
                    }else{
                        dou7 += Double.parseDouble ( ca.getExpandSpace1 () );
                    }
//                    //待报废
//                    if (StringUtils.isEmpty ( ca.getExpandSpace2 () ))
//                        ca.setExpandSpace1 ( IConstant.DEL_FLAG_0 );
//                    dou8 += Double.parseDouble ( ca.getExpandSpace2 () );

                }
                super.ajaxReturn (df.format ( dou ) + "," +df.format ( dou1 ) + "," + df.format ( dou2 ) + "," + df.format ( dou3 ) + "," + df.format ( dou4) + "," + df.format ( dou5 ) + "," + df.format ( dou6 ) + "," + df.format ( dou7 ) + "," + df.format ( dou8 ) );
                return null;
            } return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B06S008.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B06S008", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return NONE;
        }
    }
}
