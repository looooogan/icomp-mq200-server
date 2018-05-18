package com.icomp.common.timer;

import com.icomp.common.constant.IConstant;
import com.icomp.common.sap.SAPTools;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToolspriceDao;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolsprice;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时取得平均价格
 */
public class GetAvgToolsPrices extends QuartzJobBean {
    private Logger logger = Logger.getLogger ( GetAvgToolsPrices.class );
            //刀具参数
    private ToolDao toolDao;
    //平均价格
    private ToolspriceDao toolspriceDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setToolspriceDao(ToolspriceDao toolspriceDao) {
        this.toolspriceDao = toolspriceDao;
    }

    /**
     * 要调度的具体任务
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    }

    /**
     * 统计日报基本数据
     */
    public void getSapPrice() {
        Tool tool = new Tool ();
        List<String> toolIDs = new ArrayList<> ();
        List<Toolsprice> tss = new ArrayList<> ();
        Toolsprice ts = null;
        tool.setDelFlag ( IConstant.DEL_FLAG_0 );
        try {
            //1.查询刀具表
            List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
            for (Tool t : toolList) {
                ts = new Toolsprice ();
                ts.setToolID ( t.getToolID () );
                ts.setToolCode ( t.getToolCode () );
                //2.查询单价
                ts.setAvgPrices ( new BigDecimal ( SAPTools.getPriceFromSAP ( t.getToolCode () ) ) );
                toolIDs.add ( t.getToolID () );
                tss.add ( ts );
            }
            if (toolIDs.size () > 0) {
                //3.按时ToolID删除原来的信息
                toolspriceDao.deleteAllByID ( toolIDs );
            }
            if (tss.size () > 0) {
                //4.批量新增到表中
                toolspriceDao.insertBatchs ( tss );
            }
        } catch (Exception e) {
            logger.error ( "GetAvgToolsPrices-getSapPrice--" + e.toString () );
        }


    }
}