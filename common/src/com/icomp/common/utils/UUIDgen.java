package com.icomp.common.utils;

import java.util.Date;
import java.util.UUID;

/**
 * ID生成类
 *
 * @author tyy
 */
public class UUIDgen {
    /**
     * 生成ID号
     *
     * @return
     */
    public static String getId() {
        return UUID.randomUUID ().toString ().replace ( "-", "" );
    }

    public static String getTimes() {
        return new Date ().getTime () + "";
    }

}
