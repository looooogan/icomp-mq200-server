package com.icomp.v01b09.b09s002.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.dao.ToolReplaceDao;
import com.icomp.entity.base.*;
import com.icomp.v01b09.b09s002.business.B09S002Business;

import java.util.List;
import java.util.Map;

/**
 * 合成刀具参数
 *
 * @author Taoyy
 * @ClassName: B01S003Action
 * @date 2014-8-12 下午04:15:17
 */
public class B09S002Action extends IcompAction {
    private static final long serialVersionUID = 7255161566182210074L;
    private B09S002Business b09s002Business;

    public void setB09s002Business(B09S002Business b09s002Business) {
        this.b09s002Business = b09s002Business;
    }

    /**
     * 页面初始化
     *
     * @return String
     * @title initb03S003
     */
    @SuppressWarnings("unchecked")
    public String initb09S002() {
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            Map<String, Object> param = super.param();
            if ("list".equals(param.get("opt"))) {
                // 查询
                Map<String, Object> map = this.b09s002Business.getList(param, langCode, langValue);
                super.ajaxReturn(map);
                return null;
            } else {
                // 设置页面初始化值
                // 语言列表
                List<Languagetable> langList = (List<Languagetable>) super.session("langList");
                super.assign("LanguageCodeList", langList);
                super.assign("DelFlag", IConstant.DEL_FLAG_0); // 删除区分-检索初始值
                // 删除区分
                super.assign("DelFlagList", b09s002Business.getComList(IConstant.DEL_FLAG, langCode, langValue));
                // 是否工艺试验
                super.assign("TechnicalTest", b09s002Business.getComList(IConstant.TECHNICAL_TEST, langCode, langValue));

                //合成刀位置
                super.assign("CutterType", b09s002Business.getComList(IConstant.CUTTER_TYPE, langCode, langValue));

                // 组成类型
                super.assign("CreateType", b09s002Business.getComList(IConstant.CREATE_TYPE, langCode, langValue));
                // 取得页面grid显示项目列表
                super.session("gridcol", b09s002Business.getGridColmun("B09S002", ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue));
                return SUCCESS;
            }
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/B09S002.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B09S002", ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 取得合成刀具参数
     *
     * @return
     */
    public String synthesisInfo() {
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b09s002Business.synthesisInfo(param, langCode, langValue);
            Synthesisparameters s = (Synthesisparameters)ret.get("data");
            ret.put("LocationList", b09s002Business.synthesisLocationInfo(param, langCode, langValue));
            List<Synthesiscutterlocation> synList = ( List<Synthesiscutterlocation>)b09s002Business.synthesisLocationInfo(param, langCode, langValue);
            s.setCutterType(synList.get(0).getCutterType());
            ret.clear();
            ret.put("data",s);
            ret.put("LocationList",synList);
            super.ajaxReturn(ret);
            return null;
        } catch (BusinessException ex) {
            ex.printStackTrace();
            ApplicationException.setApplicationException(getResponse(), "/synthesisInfo.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "synthesisInfo", ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 新建合成刀具参数
     *
     * @return
     */
    public String synthesisAdd() {
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            Map<String, Object> param = super.param();
            // 添加 新建合成刀具参数
            Map<String, Object> ret = this.b09s002Business.synthesisAdd(param, getSavePath(), getUploadFileName(), getUpload(), langCode, ((Customer) super.session("Customer")).getCustomerID(), langValue);

            if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            // 记录新建成功日志
            CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(), "synthesisAdd", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session("Customer")).getCustomerID(), ret.get("message").toString());
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/synthesisAdd.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "synthesisAdd", ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 编辑合成刀具参数
     *
     * @return
     */
    public String synthesisEdit() {
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b09s002Business.synthesisEdit(param, getSavePath(), getUploadFileName(), getUpload(), ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue);

            if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            // 记录编辑成功日志
            CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(), "synthesisEdit", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session("Customer")).getCustomerID(), ret.get("message").toString());
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/synthesisEdit.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "synthesisEdit", ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 删除合成刀具参数
     *
     * @return
     */
    public String synthesisDelete() {
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            Map<String, Object> param = super.param();
            // 删除
            Map<String, Object> ret = this.b09s002Business.synthesisDelete(param, langCode, ((Customer) super.session("Customer")).getCustomerID(), langValue);

            if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            // 记录删除成功日志
            CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(), "synthesisDelete", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session("Customer")).getCustomerID(), ret.get("message").toString());
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/synthesisDelete.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "synthesisDelete", ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }
}
