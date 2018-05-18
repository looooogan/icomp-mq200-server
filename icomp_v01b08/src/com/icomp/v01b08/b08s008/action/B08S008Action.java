package com.icomp.v01b08.b08s008.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s008.business.B08S008Business;

import java.util.List;
import java.util.Map;

public class B08S008Action extends IcompAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 工序配置Business
     */
    private B08S008Business business;

    public void setBusiness(B08S008Business business) {
        this.business = business;
    }

    /**
     * 工序配置初始化Action
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public String initb08S008() {

        // 下拉列表值取得
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode(); // 语言编码
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue(); // 语言值
            Map<String, Object> param = super.param();
            if ("list".equals(param.get("opt"))) {
                // 设置页面初始化值

                Map<String, Object> list = this.business.getList(param, langCode, langValue);
                super.ajaxReturn(list);
                return null;
            } else {
                super.assign("DelFlagList", business.getComList(
                        IConstant.DEL_FLAG, langCode, langValue)); // 删除区分
                List<Languagetable> langList = (List<Languagetable>) super
                        .session("langList");
                super.assign("LanguageCodeList", langList);// 语言列表

                // 取得页面grid显示项目列表
                super.session("gridcol", business.getGridColmun(
                        "B08S008", ((Customer) super.session("Customer"))
                                .getCustomerID(), langCode, langValue));
                return SUCCESS;
            }
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B08S008.action", IConstant.RESULT_CODE_1, ex, this
                            .getClass().getName(), "B08S008", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        }

    }

    /**
     * 删除工序配置信息
     *
     * @return
     */
    public String processDelete() {
        try {
            String langValue = ((Languagetable) super.session("Languagetable"))
                    .getLanguageValue(); // 语言编码
            String langCode = ((Languagetable) super.session("Languagetable"))
                    .getLanguageCode(); // 语言值
            Map<String, Object> param = super.param();
            // 删除工序配置
            Map<String, Object> ret = this.business.processDelete(param,
                    langValue, ((Customer) super.session("Customer"))
                            .getCustomerID(), langCode);
            if (ret.get("message") != null
                    && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer
                        .parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            // 记录删除成功日志
            CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
                    "processDelete", IConstant.SYSTEM_LOG_FLAG_1,
                    IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
                            .session("Customer")).getCustomerID(), ret.get(
                            "message").toString());
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/processDelete.action", IConstant.RESULT_CODE_1, ex, this
                            .getClass().getName(), "processDelete",
                    ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 新建工序信息
     *
     * @return
     */
    public String processAdd() {
        try {
            String langValue = ((Languagetable) super.session("Languagetable"))
                    .getLanguageValue(); // 语言编码
            String langCode = ((Languagetable) super.session("Languagetable"))
                    .getLanguageCode(); // 语言值
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.business.processAdd(param,
                    langValue, ((Customer) super.session("Customer"))
                            .getCustomerID(), langCode);

            if (ret.get("message") != null
                    && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer
                        .parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            // 记录新建成功日志
            CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
                    "processAdd", IConstant.SYSTEM_LOG_FLAG_1,
                    IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
                            .session("Customer")).getCustomerID(), ret.get(
                            "message").toString());
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/processAdd.action", IConstant.RESULT_CODE_1, ex, this
                            .getClass().getName(), "processAdd",
                    ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 取得工序信息
     *
     * @return
     */
    public String processInfo() {
        try {
            String langValue = ((Languagetable) super.session("Languagetable"))
                    .getLanguageValue(); // 语言编码
            String langCode = ((Languagetable) super.session("Languagetable"))
                    .getLanguageCode(); // 语言值
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.business.processInfo(param,
                    langCode, langValue);
            super.ajaxReturn(ret);
            return null;

        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/processInfo.action", IConstant.RESULT_CODE_1, ex, this
                            .getClass().getName(), "processInfo",
                    ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 编辑工序信息
     *
     * @return
     */
    public String processEdit() {
        try {
            String langValue = ((Languagetable) super.session("Languagetable"))
                    .getLanguageValue(); // 语言编码
            String langCode = ((Languagetable) super.session("Languagetable"))
                    .getLanguageCode(); // 语言值
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.business.processEdit(param,
                    langValue, ((Customer) super.session("Customer"))
                            .getCustomerID(), langCode);
            if (ret.get("message") != null
                    && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer
                        .parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            // 记录编辑成功日志
            CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
                    "processEdit", IConstant.SYSTEM_LOG_FLAG_1,
                    IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
                            .session("Customer")).getCustomerID(), ret.get(
                            "message").toString());
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/processEdit.action", IConstant.RESULT_CODE_1, ex, this
                            .getClass().getName(), "processEdit",
                    ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

}
