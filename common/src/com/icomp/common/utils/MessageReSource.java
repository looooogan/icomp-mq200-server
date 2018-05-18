package com.icomp.common.utils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import static java.text.MessageFormat.format;

public class MessageReSource {

    /**
     * 通过语言及消息ID取得对应提示消息
     *
     * @param msgID
     * @param local
     * @param langValue
     * @return
     */
    public static String getMessageBox(String msgID, String local, String langValue) {
        local = "01";
        langValue = "zh_CN";
        Map<String, String> message = getPageLabelText(IConstant.GET_TYPE_MSG, langValue, null, msgID);
        if (message == null || message.size() == 0) {//查询失败
            throw new BusinessException(IConstant.EMSG0002, local, langValue);
        }
        return message.get(msgID);
    }

    /**
     * 通过语言及消息ID取得对应提示消息
     *
     * @param msgID
     * @param local
     * @param langValue
     * @return
     */
    public static String getMessageBox(String msgID, String local, String langValue, String... msgText) {
        Map<String, String> message = getPageLabelText(IConstant.GET_TYPE_MSG, langValue, null, msgID);
        if (message == null || message.size() == 0) {//查询失败
            throw new BusinessException(IConstant.EMSG0002, local, langValue);
        }
        return format(message.get(msgID), msgText);
    }

    /**
     * 取得页面文本内容
     *
     * @param getType  取得类型
     * @param langCode 语言Code
     * @param pageID   页面ID
     * @param paraName 项目ID(未指定时则全取)
     * @return 页面文本内容
     */
    private static Map<String, String> getPageLabelText(String getType, String langCode, String pageID, String paraName) {
        //作成页面文本文件名
        String fileName = "language-" + getType;
        String[] codes = langCode.split("_");
        Map<String, String> map = new HashMap<String, String>();
        Locale locale = new Locale(codes[0], codes.length > 1 ? codes[1] : StringUtils.EMPTY);
        ResourceBundle bundle = ResourceBundle.getBundle(fileName, locale);
        for (String key : bundle.keySet()) {
            if (!StringUtils.isEmpty(paraName)) {
                if (StringUtils.equals(key, paraName)) {
                    map.put(key, bundle.getString(key));
                }
            } else {
                map.put(key, bundle.getString(key));
            }
        }
        return map;
    }
}
