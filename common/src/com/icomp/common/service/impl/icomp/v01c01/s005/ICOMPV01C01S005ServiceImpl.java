package com.icomp.common.service.impl.icomp.v01c01.s005;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s005.ICOMPV01C01S005Service;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.ScrapDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.entity.base.Scrap;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Toolwholelifecycle;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 报废-Service实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S005ServiceImpl
 * @date 2016-2-25 上午11:01:21
 */
@Transactional
public class ICOMPV01C01S005ServiceImpl extends BaseService implements ICOMPV01C01S005Service {

    /**
     * 报废dao
     */
    private ScrapDao scrapDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    private TooltransferDao tooltransferDao;

    public void setScrapDao(ScrapDao scrapDao) {
        this.scrapDao = scrapDao;
    }
    
    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
		this.knifeinventoryDao = knifeinventoryDao;
	}
    
    private ToolwholelifecycleDao toolwholelifecycleDao;

	public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
		this.toolwholelifecycleDao = toolwholelifecycleDao;
	}

	@Override
    public int saveScrap(Scrap entity, Tooltransfer tt) throws Exception {
        Scrap scrap = new Scrap();
        try {
            // 更新刀具流转表
            tooltransferDao.updateNonQuery(tt);

            // 报废ID
            scrap.setScrapID(UUIDgen.getId());
            // 刀具类型
            scrap.setToolType(entity.getToolType());
            // 流程
            scrap.setBusinessID(IConstant.C01S005);
            // 材料号
            scrap.setMaterial(entity.getMaterial());
            scrap.setUsageCounter ( entity.getUsageCounter () );
            // 刀具ID
            scrap.setToolID(entity.getToolID());
            // 报废原因
            scrap.setScrapCause(entity.getScrapCause());
            // 报废数量
            scrap.setScrapNumber(BigDecimal.ONE);
            // 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
            scrap.setScrapState(entity.getScrapState());
            // 报废时间
            scrap.setScrapTime(new Date());
            // 授权人
            scrap.setAuthorizationID(entity.getAuthorizationID());
            // 创建者
            scrap.setCreateUser(entity.getCreateUser());
            // 创建时间
            scrap.setCreateTime(new Date());
            // 更新者
            scrap.setUpdateUser(entity.getCreateUser());
            // 更新时间
            scrap.setUpdateTime(new Date());
            // 插入报废表
            scrapDao.insert(scrap);
            
            //查询刀具入库编码
            String knifeInventoryCode = null;
            Tooltransfer tt1 = new Tooltransfer();
            tt1.setRfidContainerID(tt.getRfidContainerIDWhere());
            List<Tooltransfer> ttList2 = (List<Tooltransfer>) tooltransferDao.searchByList(tt);
            if (ttList2.size()>0) {
    			knifeInventoryCode = ttList2.get(0).getKnifeInventoryCode();
    		}
            
            //建立生命周期
    		Toolwholelifecycle twl = new Toolwholelifecycle();
    		// 刀具全生命周期id
    		twl.setToolWholeLifecycleID(UUIDgen.getId());
    		// 刀具入库编码
    		if (knifeInventoryCode!=null) {
    			twl.setKnifeInventoryCode(knifeInventoryCode);
    		}else {
    			twl.setKnifeInventoryCode("");
    		}
    		// 流程id
    		twl.setBusinessFlowLnkID(IConstant.C01S005);
    		// 手持机id
    		twl.setHandSetID(tt.getExpandSpace1());
    		// 刀具id
    		twl.setToolID(tt.getToolIDWhere());
    		//零部件id
    		twl.setPartsID("");
            //加工数量
    		twl.setProcessAmount("0");
            //删除区分(0有效1删除)
    		twl.setDelFlag(IConstant.DEL_FLAG_0);
            //更新时间
    		twl.setUpdateTime(new Date());
            //更新者
    		twl.setUpdateUser(entity.getCreateUser());
            //创建时间
    		twl.setCreateTime(new Date());
            //创建者
    		twl.setCreateUser(entity.getCreateUser());
            //刃磨次数
    		twl.setVersion(BigDecimal.ZERO);
    		toolwholelifecycleDao.insert(twl);

            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Tooltransfer> getToolMsg(Tooltransfer entiry) throws Exception {
        return tooltransferDao.getToolMsg(entiry);
    }

    @Override
    public int updateTooltransfer(Tooltransfer entiry) throws Exception {
        return tooltransferDao.updateNonQuery(entiry);
    }


}
