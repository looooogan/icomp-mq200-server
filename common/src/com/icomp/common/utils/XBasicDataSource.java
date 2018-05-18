package com.icomp.common.utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author TYY
 * @className XBasicDataSource
 * @date 2016/8/17 13:49
 */
public class XBasicDataSource extends BasicDataSource {
    @Override
    public synchronized void close() throws SQLException {
         System.out.println("......输出数据源Driver的url："+DriverManager.getDriver(url));
        DriverManager.deregisterDriver ( DriverManager.getDriver ( url ) );
        super.close ();
    }
}

