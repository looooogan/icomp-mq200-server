package com.icomp.common.action;

import com.icomp.common.business.CommonBusiness;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vgrantlist;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 系统共通Action
 *
 * @author yzq
 */
public class CommonAction extends IcompAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private CommonBusiness business;

    public void setBusiness(CommonBusiness business) {
        this.business = business;
    }

    /**
     * 系统初始化Action
     *
     * @return 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    public String initialization() {
        try {
            // 取得系统默认语言
            Languagetable entity = business.getSystemDefaultLanguage ();
            // 保存系统默认语言
            super.session ( "Languagetable", entity );
            // 保存页面样式语言编码
            super.session ( "languageCode", entity.getLanguageValue () );
            // 取得页面文本内容
            Map<String, String> labels = business.getPageLabelText ( IConstant.GET_TYPE_UI, entity.getLanguageCode (), IConstant.ICOMPV01B00_B00S000, null, entity.getLanguageValue () );
            // 保存页面文本信息
            super.session ( "lang", labels );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/error.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "initialization", "system" );
            return null;
        }
        return SUCCESS;
    }

    /**
     * 用户登录Action
     *
     * @return 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    public String login() {
        try {
            Customer entity = (Customer) super.session ( "Customer" );
            if (entity == null) {
                entity = new Customer ();
            }
            // 系统语言种类
            //   String lang = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            //  String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String lang = "01";
            String langValue = "zh_CN";
            // 取得用户菜单信息及权限列表
            List<Vgrantlist> list = business.getUserGrant ( lang, entity.getUserName (), langValue );
            // 保存用户权限信息
            if (list == null) {
                list = new ArrayList<> ();
            }
            super.session ( "CustomerGrant", list );
            // 加载系统支持语言列表
            List<Languagetable> langList = business.getSystemListLanguage ( lang, langValue );
            super.session ( "langList", langList );
            // 设置显示语言
            super.session ( "local", lang );
            // 保存页面分页条数
            super.session ( "rowsize", IConstant.ROWSIZE );
            // 记录登录成功日志
            CommonLogUtil.saveBrowsLog ( lang, this.getClass ().getName (), "login", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, entity.getCustomerID (), MessageReSource.getMessageBox ( IConstant.IMSG0002, lang, langValue ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/initialization.action", IConstant.RESULT_CODE_3, ex, this.getClass ().getName (), "login", "system" );
            return null;
        }
        return SUCCESS;
    }

    /**
     * 系统初始化页面Action
     *
     * @return 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    public String init() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            // 库存异常报警列表
            if ("list".equals ( param.get ( "opt" ) )) {
                Map<String, Object> list = this.business.getList ( param, langCode, langValue );
                super.ajaxReturn ( list );
                return null;
            }
            // 取得页面grid显示项目列表
            super.session ( "gridcol", business.getGridColmun ( "init", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/init.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "init", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 系统初始化页面Action
     *
     * @return 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    public String ChangePassword() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            Map<String, Object> ret = business.ChangePassword ( param, ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue );

            if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
                super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
                return null;
            } else {
                super.ajaxReturn ( ret );
            }
            //记录编辑成功日志
            CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "ChangePassword", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/ChangePassword.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "checkLogin", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 更换系统显示语言Action
     *
     * @return 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    public String editLanguage() {
        try {
            Map<String, Object> param = super.param ();
            // 设定页面默认显示语言
            String language = param.get ( "language" ).toString ();
            String langValue = param.get ( "langValue" ).toString ();
            Customer entity = (Customer) super.session ( "Customer" );
            // 取得用户菜单信息及权限列表
            List<Vgrantlist> list = business.getUserGrant ( language, entity.getUserName (), langValue );
            // 保存用户权限信息
            super.session ( "CustomerGrant", list );
            // 设置显示语言
            super.session ( "local", language );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/initialization.action", IConstant.RESULT_CODE_3, ex, this.getClass ().getName (), "editLanguage", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
        return SUCCESS;
    }

    /**
     * 登录用户验证Action
     *
     * @return 作成者：杨作庆 作成时间:2014-07-08 17:14
     */
    public String checkInput() {
        try {
            // 系统语言种类
            String lang = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            Map<String, Object> param = super.param ();
            if (StringUtils.isEmpty ( param.get ( "UserName" ).toString () )) {
                if (StringUtils.isEmpty ( param.get ( "UserPass" ).toString () )) {
                    ajaxReturn ( IConstant.RESULT_CODE_3, "/login.action", IConstant.RESULT_CODE_3, MessageReSource.getMessageBox ( IConstant.WMSG0004, lang, langValue ) );
                    return null;
                } else {
                    ajaxReturn ( IConstant.RESULT_CODE_1, "/login.action", IConstant.RESULT_CODE_1, MessageReSource.getMessageBox ( IConstant.WMSG0001, lang, langValue ) );
                    return null;
                }
            } else {
                if (StringUtils.isEmpty ( param.get ( "UserPass" ).toString () )) {
                    ajaxReturn ( IConstant.RESULT_CODE_2, "/login.action", IConstant.RESULT_CODE_2, MessageReSource.getMessageBox ( IConstant.WMSG0002, lang, langValue ) );
                    return null;
                }
            }
            Customer entity = business.login ( param, lang, langValue );
            // 保存登录用户信息
            super.session ( "Customer", entity );
            // 登录成功
            ajaxReturn ( IConstant.RESULT_CODE_0, "/login.action", IConstant.RESULT_CODE_0 );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/initialization.action", IConstant.RESULT_CODE_3, ex, this.getClass ().getName (), "checkInput", "system" );
            return null;
        }
        return null;
    }
}
