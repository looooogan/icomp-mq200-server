package com.icomp.common.timer;

import com.icomp.common.constant.IConstant;
import com.icomp.dao.ScrapDao;
import com.icomp.dao.ToolDao;
import com.icomp.entity.base.Scrap;
import com.icomp.entity.base.Tool;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.math.BigDecimal;
import java.util.List;

/**
 * 定时取得刃磨次数
 */
public class AutoToolsNumbers extends QuartzJobBean {
    private Logger logger = Logger.getLogger ( AutoToolsNumbers.class );
    //刀具参数
    private ToolDao toolDao;
    //报废表
    private ScrapDao scrapDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setScrapDao(ScrapDao scrapDao) {
        this.scrapDao = scrapDao;
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
    public void getAutoToolsNumbers() {
        Tool tool = null;
        try {
            //钻头-去报废表中查询（总刃磨次数/个数）
            List<Scrap> scraps = scrapDao.usageCounterGroupToolCode ();
            BigDecimal ugerun = null;
            for (Scrap sc : scraps) {
                tool = new Tool ();
                ugerun = sc.getUsageCounter ();
                if (ugerun == null) {
                    continue;
                }
                // where
                tool.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
                tool.setToolCodeWhere ( sc.getMessageCode () );
                tool.setToolIDWhere ( sc.getToolID () );
                tool.setToolConsumetypeWhere ( IConstant.STRING_0 );
                tool.setToolNumber ( getUpNumber ( ugerun ) );
                toolDao.updateNonQuery ( tool );
            }
        } catch (Exception e) {
            logger.error ( "AutoToolsNumbers-getAutoToolsNumbers--" + e.toString () );
        }
    }

    /**
     * 小数点大于0则个位加1
     *
     * @param ugerun
     * @return
     */
    private static BigDecimal getUpNumber(BigDecimal ugerun) {
        String str = String.valueOf ( ugerun.floatValue () );
        int pointPro = Integer.parseInt ( str.split ( "\\." )[0] );
        int pointNext = Integer.parseInt ( str.split ( "\\." )[1] );
        if (pointNext > 0) {
            pointPro += 1;
        }
        return new BigDecimal ( pointPro );
    }
}