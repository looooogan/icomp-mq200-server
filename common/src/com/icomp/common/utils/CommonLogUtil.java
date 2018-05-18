/*
 * 日志管理共通
 * 生成时间    : 2014/07/07 15:50:36
 */
package com.icomp.common.utils;

import com.icomp.dao.UserdetailDao;
import com.icomp.entity.base.Userdetail;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Date;

/*
 *  日志管理共通 日志信息保存下列内容	
 *	system_Log_ID                           
 *	语言编码                                
 *	日志内容                                
 *	日志分类(0手持机1智能管理平台3系统日志)          
 *	日志级别(0正常1警告2错误9其他)          
 *	产生时间                                
 *	操作人                                  
 *	删除区分(0有效1删除)                    
 *	更新者                                  
 *	更新时间                                
 *	版本号0        
 *  作成者：杨作庆
 *  作成时间:2014-07-08 17:14                         
*/
public class CommonLogUtil {
    private static final Logger logger = Logger.getLogger ( CommonLogUtil.class );
    private static UserdetailDao dao;

    public void setDao(UserdetailDao dao) {
        this.dao = dao;
    }

    /**
     * 保存手持机操作日志
     *
     * @param local     语言编码
     * @param className 功能ID
     * @param logLevel  日志级别
     * @param userID    登录用户ID
     * @param logString 日志内容
     *                  作成者：杨作庆
     *                  作成时间:2014-07-08 17:14
     */
    public static void saveHandLog(String local, String className, String methodName, String logType, String logLevel, String userID, String logString) {

    }

    /**
     * 保存网站操作日志
     *
     * @param local     语言编码
     * @param className 功能ID
     * @param logLevel  日志级别
     * @param userID    登录用户ID
     * @param logString 日志内容
     *                  作成者：杨作庆
     *                  作成时间:2014-07-08 17:14
     */
    public static void saveBrowsLog(String local, String className, String methodName, String logType, String logLevel, String userID, String logString) {
        String userCode = null;
        String realName = null;
        //如果用户名为空,则返回false
        if (!StringUtils.isEmpty ( userID )) {
           // ApplicationContext ctx = new ClassPathXmlApplicationContext ( "com/icomp/config/configdao.xml" );
          //  UserdetailDao dao = new UserdetailDaoImpl ();
           // UserdetailDao dao = (UserdetailDao) ctx.getBean ( "userdetailDao" );
            try {
                Userdetail reUser = dao.searchByPrimaryID (userID);
                if (reUser != null) {
                    userCode = reUser.getUserName ();
                    realName = reUser.getCreateUser ();
                }
            } catch (SQLException e) {
            }
        logger.info (
                "\n ------------------------------------BEGEN--------------------------------------------------"+
                "\n class : " + className +
                " \n method : " + methodName +
                " \n message : " + logString +
                "\n userID : " + userID +
                "\n userCode : " + userCode+
                "\n realName : " + realName+
                "\n time : " + DateFormatUtil.dateToString ( new Date (), 1 )  +
                 "\n------------------------------------ END --------------------------------------------------") ;
        }
    }
}
