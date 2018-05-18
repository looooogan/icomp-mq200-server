package com.icomp.common.timer;

import com.icomp.common.constant.IConstant;
import com.icomp.common.emails.EmailEntity;
import com.icomp.common.utils.DateFormatUtil;
import com.icomp.common.utils.MailUtil;
import com.icomp.dao.VtoolalarmparamDao;
import com.icomp.dao.VtoolsmachiningDao;
import com.icomp.dao.WarningDao;
import com.icomp.entity.base.Vtoolalarmparam;
import com.icomp.entity.base.Vtoolsmachining;
import com.icomp.entity.base.Warning;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 定时任务页，在本页配置定时任务。
 */
public class SendSAutoEmail extends QuartzJobBean {

    private Logger logger = Logger.getLogger ( SendSAutoEmail.class );

    //报警设置表
    private WarningDao warningDao;
    //刀具加工信息表
    private VtoolsmachiningDao vtoolsmachiningDao;
    //库存异常报警表
    private VtoolalarmparamDao vtoolalarmparamDao;

    public void setVtoolalarmparamDao(VtoolalarmparamDao vtoolalarmparamDao) {
        this.vtoolalarmparamDao = vtoolalarmparamDao;
    }

    public void setVtoolsmachiningDao(VtoolsmachiningDao vtoolsmachiningDao) {
        this.vtoolsmachiningDao = vtoolsmachiningDao;
    }

    public void setWarningDao(WarningDao warningDao) {
        this.warningDao = warningDao;
    }

    /**
     * 要调度的具体任务
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    }

    //定时刷新token
    public void znrwdb() {
        try {
            System.out.println ( "定时执行发送邮件--" + DateFormatUtil.dateToString ( new Date (), 1 ) );
            //当前状态(0启动，1停用)
            List<Warning> listwanning = warningDao.searchListByUse ();
            for (Warning wm : listwanning) {
                //邮件
                String emailAss = wm.getCreateUser ();
                if (!StringUtils.isEmpty ( emailAss )) {
                    EmailEntity mail = new EmailEntity ();
                    // 阿里smtp smtp.mxhichina.com
                    mail.setHost ( IConstant.SEND_EMAIL_SMTP );
                    // 发件人邮箱
                    mail.setSender ( IConstant.SEND_EMAIL_SENDER );
                    // 登录账号,一般都是和邮箱名一样吧
                    mail.setUsername ( IConstant.SEND_EMAIL_SENDER );
                    // 发件人邮箱的登录密码与授权密码相同
                    mail.setPassword ( IConstant.SEND_EMAIL_PASSWORD );
                    // 接收人邮箱
                    mail.setReceiver ( emailAss );
                    String date = DateFormatUtil.dateToString ( new Date (), 0 );
                    //功能（0加工异常预警，1库存量预警）
                    if (IConstant.STRING_0.equals ( wm.getWarningFunction () )) {
                        // 主题
                        mail.setSubject ( "加工异常预警" + date );
                        String sendHtml = getSendAddEmailMessage ( wm );
                        if (null == sendHtml) {
                            continue;
                        }
                        mail.setMessage ( sendHtml );// 内容
                        new MailUtil ().send ( mail );
                    } else if (IConstant.STRING_1.equals ( wm.getWarningFunction () )) {
                        //1库存量预警
                        // 主题
                        mail.setSubject ( "库存量预警-新刀库" + date );
                        String sendHtml = getSendEmailMessage ( wm, 1 );
                        if (!StringUtils.isEmpty ( sendHtml )) {
                            mail.setMessage ( sendHtml );// 内容
                            new MailUtil ().send ( mail );
                        }
                        mail.setSubject ( "库存量预警-备刀库" + date );
                        sendHtml = getSendEmailMessage ( wm, 2 );
                        if (!StringUtils.isEmpty ( sendHtml )) {
                            mail.setMessage ( sendHtml );// 内容
                            new MailUtil ().send ( mail );
                        }
                    } else {
                        System.out.println ( "没有此报警功能--（0加工异常预警，1库存量预警）当前为--" + wm.getWarningFunction () );
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    /**
     * 查询新刀库存异常信息
     *
     * @param wm
     * @return
     */
    private String getSendEmailMessage(Warning wm, int state) throws SQLException {
        //查询库存新刀异常信息
        List<Vtoolalarmparam> list = null;
        if (1 == state) {
            list = vtoolalarmparamDao.searchNewVentoryList ( new Vtoolalarmparam () );
        } else {
            list = vtoolalarmparamDao.searchTooltreantList ( new Vtoolalarmparam () );
        }

        if (list == null || list.size () < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder ();
        sb.append ( " <b>" + wm.getCustomerID () + "</b> <br/>" );
        sb.append ( " <b>您好！</b>" );
        if (1 == state) {
            sb.append ( "<p>以下是库存新刀异常报警的内容</p><br>" );
        } else {
            sb.append ( "<p>以下是备刀库异常报警的内容</p><br>" );
        }
        sb.append ( " <span><b>当前产生" + list.size () + "条</span>" );
        sb.append ( "<table width=\"700\" border=\"1\" bordercolor=\"gray\" cellspacing=\"0\"><tr><th>预警类型</th><th>材料号</th><th>当前库存数量</th><th>预警线数量</th><th>差额数量</th></tr>" );
        for (Vtoolalarmparam v : list) {
            //差额数量
            String lessStr = v.getExpandSpace1 ();
            if (StringUtils.isEmpty ( lessStr )) {
                lessStr = IConstant.STRING_0;
            }
            if (StringUtils.isEmpty ( v.getExpandSpace2 () )) {
                v.setExpandSpace2 ( IConstant.STRING_0 );
            }
            int lessZero = Integer.parseInt ( lessStr );
            if (lessZero > 0) {
                lessStr = v.getExpandSpace2 ();
            }
            sb.append ( "<tr ><td > 新刀库</td >" );
            sb.append ( "<td >" + v.getToolCode () + " </td >" );
            sb.append ( "<td >" + v.getKnifelnventoryNumber () + " </td >" );
            sb.append ( "<td >" + v.getStandard () + "~" + v.getCstandard () + " </td >" );
            sb.append ( "<td > " + lessStr + "</td ></tr >" );
        }
        sb.append ( "</table><br>" );
        sb.append ( "<p>具体详见<a href=\"http://10.226.65.2:80/icomp/login.action\">管理平台中-预警管理模块</a></p>" );
        sb.append ( "<p>自动发送，请勿回复邮件。</p><p>爱康普刀具管理系统</p><p>" + DateFormatUtil.dateToString ( new Date (), 1 ) + "</p>" );

        return sb.toString ();
    }

    /**
     * 查询加工异常信息（24小时之内的）
     *
     * @return
     */
    private String getSendAddEmailMessage(Warning warning) throws SQLException {
        //查询24小时内的加工异常报警信息
        /**
         *  设置检索条件
         */

        Vtoolsmachining entity = new Vtoolsmachining ();
        String dateEndStr = DateFormatUtil.dateToString ( new Date (), 1 );
        String dateStarStr = DateFormatUtil.getThisDateAddParamNum ( -1 ) + " " + dateEndStr.split ( " " )[1];

        entity.setDateStar ( DateFormatUtil.converToDate ( dateStarStr, 1 ) );
        entity.setDateEnd ( DateFormatUtil.converToDate ( dateEndStr, 1 ) );
        List<Vtoolsmachining> list = vtoolsmachiningDao.searchByList1 ( entity );
        if (list == null || list.size () < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder ();
        sb.append ( " <b>" + warning.getCustomerID () + "</b> <br/>" );
        sb.append ( " <b>您好！</b>" );
        sb.append ( "<p>以下是24小时内合成刀具加工异常报警的内容</p><br/>" );
        sb.append ( " <span><b>当前产生" + list.size () + "条 目前总计" + vtoolsmachiningDao.searchByCount ( new Vtoolsmachining () ) + "条</b></span>" );
        sb.append ( "<table width=\"700\" border=\"1\" bordercolor=\"gray\" cellspacing=\"0\"><tr><th>生产线</th><th>合成刀</th><th>加工设备</th><th>零部件</th><th>操作者</th><th>额定数量</th><th>实际加工数量</th></tr>" );
        for (Vtoolsmachining v : list) {
            sb.append ( "<tr ><td > " + v.getAssemblyLineName () + "</td >" );
            sb.append ( "<td >" + v.getToolCode () + " </td >" );
            sb.append ( "<td >" + v.getEquipmentName () + " </td >" );
            sb.append ( "<td >" + v.getPartsName () + " </td >" );
            sb.append ( "<td >" + v.getOuterUser () + " </td >" );
            sb.append ( "<td >" + v.getToolDurable () + " </td >" );
            sb.append ( "<td > " + v.getProcessAmount () + "</td ></tr >" );
        }
        sb.append ( "</table><br>" );
        sb.append ( "<p>具体详见<a href=\"http://10.226.65.2:80/icomp/login.action\">管理平台中-预警管理模块</a></p>" );
        sb.append ( "<p>自动发送，请勿回复邮件。</p><p>爱康普刀具管理系统</p><p>" + DateFormatUtil.dateToString ( new Date (), 1 ) + "</p>" );

        return sb.toString ();
    }

}


