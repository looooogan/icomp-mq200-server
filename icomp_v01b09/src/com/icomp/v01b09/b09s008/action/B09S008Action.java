package com.icomp.v01b09.b09s008.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b09.b09s008.business.B09S008Business;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * 回厂入库查询Action
 *
 * @author Sj
 * @ClassName: B09S007Action
 * @date 2017-7-12 下午04:13:27
 */
public class B09S008Action extends IcompAction {
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    private static final long serialVersionUID = 1L;
    private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateFormat excelNameFormatter = new SimpleDateFormat("yyyyMMdd");
    /**
     * 修复通知单查询Business
     */
    private B09S008Business b09s008Business;

    public void setB09s008Business(B09S008Business b09s008Business) {
        this.b09s008Business = b09s008Business;
    }

    /**
     * 页面初始化
     *
     * @return String
     * @title initb09s008
     */
    public String initb09S008() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            if ("list".equals ( param.get ( "opt" ) )) {
                //  修复通知单查询列表
                Map<String, Object> list = this.b09s008Business.getList ( param, langCode, langValue, 1 );
                super.ajaxReturn ( list );
                return null;
            } else {

                // 初始化页面下拉列表默认值
                super.assign ( "Merchants", "" );
                //取得下拉列表列表
                Map<String, Object> list = this.b09s008Business.getPageSelList ( langCode, langValue );
                super.assign ( "MerchantsesList", list.get ( "merchantsesList" ) );
                // 取得页面grid显示项目列表
                super.session ( "gridcol", b09s008Business.getGridColmun ( "B03S002", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
                return SUCCESS;
            }
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B09S008.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B09S008", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 新建厂外通知单
     *
     * @return String
     * @title initb09s008
     */
    public String outFactoryAdd() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            if ("add".equals ( param.get ( "opt" ) )) {
                //  修复通知单查询列表
                Map<String, Object> list = this.b09s008Business.outFactoryAdd ( param, langCode, langValue );
                super.ajaxReturn ( list );
                return null;
            }
            // 取得页面grid显示项目列表
            super.session ( "gridcol", b09s008Business.getGridColmun ( "B09S008", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B09S008.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B09S008", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    //	显示编辑Div内容
    public String outInfo() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();

            // 2017/08/26 宋健 变更↓↓↓　dazhong@YMSC
            String opt = param.get("opt").toString();
            if("find".equals(opt)){
                //	查询待编辑内容
                Map<String, Object> ret = this.b09s008Business.outInfo ( param, langCode, langValue );
                super.ajaxReturn ( ret );
            }else {
                //	查询详细内容
                Map<String, Object> ret = this.b09s008Business.outListInfo ( param, langCode, langValue );
                super.ajaxReturn ( ret );
            }
            // 2017/08/26 宋健 变更↑↑↑　dazhong@YMSC
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/userInfo.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userInfo", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }

    }

    public String outFactoryEdit() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();
            //			查询待编辑内容
            Map<String, Object> list = this.b09s008Business.outFactoryEdit ( param, langCode, langValue, ((Customer) super.session ( "Customer" )).getCustomerID (), ((Customer) super.session ( "Customer" )).getUserName() );
            super.ajaxReturn ( list );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/userInfo.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userInfo", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }

    }

    private String noticeNo;
    private String dateStar;
    private String dateEnd;
    private String outstatus;
    private String grindingName;
    private String operator;
    private String numberGrinding;
    private String materialNum;
    private String outReason;

    private InputStream excelStream;
    private String excelFileName;

    public InputStream getExcelStream() {
        return excelStream;
    }

    public void setExcelStream(InputStream excelStream) {
        this.excelStream = excelStream;
    }

    public String getExcelFileName() {
        return excelFileName;
    }

    public void setExcelFileName(String excelFileName) {
        this.excelFileName = excelFileName;
    }

    public String getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getDateStar() {
        return dateStar;
    }

    public void setDateStar(String dateStar) {
        this.dateStar = dateStar;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getOutstatus() {
        return outstatus;
    }

    public void setOutstatus(String outstatus) {
        this.outstatus = outstatus;
    }

    public String getGrindingName() {
        return grindingName;
    }

    public void setGrindingName(String grindingName) {
        this.grindingName = grindingName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNumberGrinding() {
        return numberGrinding;
    }

    public void setNumberGrinding(String numberGrinding) {
        this.numberGrinding = numberGrinding;
    }

    public String getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(String materialNum) {
        this.materialNum = materialNum;
    }

    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }
}
