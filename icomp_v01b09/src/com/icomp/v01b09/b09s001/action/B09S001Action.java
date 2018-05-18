package com.icomp.v01b09.b09s001.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vlibrarycode;
import com.icomp.v01b09.b09s001.business.B09S001Business;

import java.util.List;
import java.util.Map;

/**
 * 刀具参数页面Action
 *
 * @author cyn
 * @ClassName: B01S001Action
 * @date 2014-8-12 下午02:31:34
 */
public class B09S001Action extends IcompAction {

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 7255161566182210074L;

    private B09S001Business b09s001Business;

    public void setB09s001Business(B09S001Business b09s001Business) {
        this.b09s001Business = b09s001Business;
    }

    /**
     * 初始化刀具参数页面
     *
     * @return String
     * @title initb01S001
     */
    public String initb09S001() {
        try {
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            Map<String, Object> param = super.param ();

            if ("list".equals ( param.get ( "opt" ) )) {
                // 设置页面初始化值

                Map<String, Object> list = b09s001Business.getList ( param, langCode, langValue );
                super.ajaxReturn ( list );
                return null;
            } else {
                List<Vlibrarycode> listVlib = b09s001Business.getVLibraryCodeList ( param, langValue );

                super.assign ( "LibraryCodeList", listVlib );
                super.assign ( "ToolTypeList", b09s001Business.getComList ( IConstant.TOOL_TYPE, langCode, langValue ) );
                super.assign ( "ToolConsumeTypeList", b09s001Business.getComList ( IConstant.TOOL_CONSUME_TYPE, langCode, langValue ) );
                super.assign ( "DelFlag", IConstant.DEL_FLAG_0 ); // 删除区分-检索初始值
                super.assign ( "DelFlagList", b09s001Business.getComList ( IConstant.DEL_FLAG, langCode, langValue ) ); // 删除区分
                // 取得页面grid显示项目列表
                super.session ( "gridcol", b09s001Business.getGridColmun ( "B09S001", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
                return SUCCESS;
            }
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B09S001.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B08S001", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 新建刀具参数信息
     *
     * @return
     */

    public String toolAdd() {
        try {
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            Map<String, Object> param = super.param ();
            Map<String, Object> ret = this.b09s001Business.toolAdd ( param, getSavePath (), getUploadFileName (), getUpload (), langValue, ((Customer) super.session ( "Customer" )).getCustomerID (), langCode );
            if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
                super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
                return null;
            } else {
                super.ajaxReturn ( ret );
            }
            //记录新建成功日志
            CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "userAdd", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
            return null;
        } catch (BusinessException ex) {
            ex.printStackTrace ();
            return null;
        }
    }

    public String toolInfo() {
        try {
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            Map<String, Object> param = super.param ();
            Map<String, Object> ret = this.b09s001Business.toolInfo ( param, langCode, langValue );
            super.ajaxReturn ( ret );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/toolInfo.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "toolInfo", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    public String toolEdit() {
        try {
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            Map<String, Object> param = super.param ();
            Map<String, Object> ret = this.b09s001Business.toolEdit ( param, getSavePath (), getUploadFileName (), getUpload (), langValue, ((Customer) super.session ( "Customer" )).getCustomerID (), langCode );

            if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
                super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
            } else {
                super.ajaxReturn ( ret );
            }
            //记录编辑成功日志
            CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "toolEdit", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/toolEdit.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "toolEdit", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 删除刀具参数
     *
     * @return
     */
    public String toolDelete() {
        try {
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            Map<String, Object> param = super.param ();
            //删除
            Map<String, Object> ret = this.b09s001Business.toolDelete ( param, langValue, ((Customer) super.session ( "Customer" )).getCustomerID (), langCode );

            if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
                super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
                return null;
            } else {
                super.ajaxReturn ( ret );
            }
            // 记录删除成功日志
            CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "printEditDelete", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/printEditDelete.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "printEditDelete", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }
}
