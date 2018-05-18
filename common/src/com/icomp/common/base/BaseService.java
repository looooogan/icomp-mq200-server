package com.icomp.common.base;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.icomp.common.constant.IConstant;
import com.icomp.entity.base.Vinventoryalarm;

public class BaseService {

    /**
     * 参数验证是否为数字
     *
     * @param paramStr
     * @return
     */
    public boolean checkOutNum(String paramStr) {
        boolean ret = false;
        String regEx = "[\\d]+(\\.[\\d]+)?";
        if (Pattern.matches(regEx, paramStr)) {
            ret = true;
        }
        regEx = "[0-9]*";
        if (Pattern.matches(regEx, paramStr)) {
            ret = true;
        }
        return ret;

    }

    /**
     * 参数验证是否年
     *
     * @param paramStr
     * @return
     */
    public boolean checkOutYear(String paramStr) {
        boolean ret = false;
        // /(19[\d][\d]|20[\d][\d])/ 2000-2099年的验证
        String regEx = "(20[\\d][\\d])";
        if (Pattern.matches(regEx, paramStr)) {
            ret = true;
        }
        return ret;

    }

    /**
     * 参数验证是否为数字
     * 1~99位数字
     *
     * @param paramStr
     * @return
     */
    public boolean isPositiveInteger(String paramStr) {
        boolean ret = false;
        String regEx = "[1-9]{1}[0-9]{0,99}";
        if (Pattern.matches(regEx, paramStr)) {
            ret = true;
        }
        regEx = "[0]{1}";
        if (Pattern.matches(regEx, paramStr)) {
            ret = true;
        }
        return ret;

    }

    /**
     * 手机号验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean ret = false;
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        ret = m.matches();
        return ret;
    }

    /**
     * 电话号码验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isPhone(String str) {
        Pattern p1 = null, p2 = null;
        Matcher m = null;
        boolean ret = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            ret = m.matches();
        } else {
            m = p2.matcher(str);
            ret = m.matches();
        }
        return ret;
    }

    /**
     * 在途计划告警
     * 逾期天数
     *
     * @param theyTime
     * @return String
     * @title getTheyStatus
     */
    public String getTheyDays(SimpleDateFormat sf, String theyTime) {
        long theyDays;
        try {

            //当前时间
            long currentTime = (long) System.currentTimeMillis();
            // 一天的秒数
            long daytime = Long.parseLong(IConstant.DAYS_MILLI_SECOND);
            //预计到货时间
            long theTime = (long) sf.parse(theyTime).getTime();
            //逾期天数 = (当前时间 - 预计到货时间)/一天的秒数
            theyDays = ((currentTime - theTime) / daytime);
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
        return theyDays + "";
    }

    /**
     * 是否到报警阶段 报警阶段 = |(库存量+流转量+在途计划量 ) - 最小周转量|/最小周转量 > 告警参数
     *
     * @param v
     * @param v
     * @return boolean
     * @title getAlertValue
     */
    public boolean getAlertValue(Vinventoryalarm v) {
        boolean ret = false;

        if (v.getToolTurnover() == null) {
            v.setToolTurnover(BigDecimal.ONE);//刀具周转量
        }

        if (v.getPassageCount() == null) {
            v.setPassageCount(BigDecimal.ZERO);// 在途量
        }
        // ((库存量+流转量+在途计划量 ) - 最小周转量)/最小周转量 > 告警参数
        int d1 = (v.getInventoryCount().intValue() + v.getPassageCount().intValue() + v.getTransferCount().intValue()) - v.getToolTurnover().intValue();
        int d2 = v.getToolTurnover().intValue();//最小周转量
        if (d1 < 0 && d2 != 0) {
            if (Math.abs(d1) / d2 > (Double.parseDouble(v.getToolAlarmRatio()) / 100)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * 库存异常告警
     * 设置当前状态
     *
     * @param v
     * @return String
     * @title getThisStatusString
     */
    public String getThisStatusString(Vinventoryalarm v) {
        if (getAlertValue(v)) {
            return IConstant.INVENTORY_ALERT_0;//告警
        } else {
            return IConstant.INVENTORY_ALERT_1;//不告警
        }
    }




}
