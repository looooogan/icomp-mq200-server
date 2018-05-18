package com.icomp.common.service.impl.icomp.v01c01.s023;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s023.ICOMPV01C01S023Service;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.VquerytoollistDao;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vquerytoollist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ICOMPV01C01S023ServiceImpl extends BaseService implements ICOMPV01C01S023Service {

    private VquerytoollistDao vquerytoollistDao;
    private RfidcontainerDao rfidcontainerDao;
    private KnifeinventoryDao knifeinventoryDao;
    private ToolDao toolDao;
    private TooltransferDao tooltransferDao;

    public void setVquerytoollistDao(VquerytoollistDao vquerytoollistDao) {
        this.vquerytoollistDao = vquerytoollistDao;
    }

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    /**
     * 刀具信息快速查询
     *
     * @param entity
     * @return
     * @throws Exception C01S023Respons
     * @title getToolInfo
     */
    @SuppressWarnings("unchecked")
    public List<Vquerytoollist> getToolInfo(Vquerytoollist entity) {
        String RFIDString = entity.getRfidCode();
        String toolCode = null;
        try {

            if (RFIDString != null && !"".equals(RFIDString)) {
                toolCode = getToolCodeByRFIDString(RFIDString);
            }
            if (toolCode != null && !"".equals(toolCode)) {
                entity.setToolCode(toolCode);
                entity.setlblCode(null);
                entity.setRfidCode(null);
            }

            // 取得当前扫描刀具数据
            List<Vquerytoollist> list = (List<Vquerytoollist>) vquerytoollistDao.searchByQueryList(entity);
            if (list == null || list.size() <= 0) {
                list = new ArrayList<Vquerytoollist>();
                Vquerytoollist vquerytoollist = new Vquerytoollist();
                if (null != entity.getRfidCode()) {
                    //当前扫描的RFID未绑定刀具
                    vquerytoollist.setMessageCode(IConstant.WMSG0143); //rfid
                } else {
                    // 您所查询的库位码或者刀具编码不存在
                    vquerytoollist.setMessageCode(IConstant.WMSG0150);//
                }
                vquerytoollist.setRetErrFlag(true);
                list.add(vquerytoollist);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vquerytoollist> list = new ArrayList<Vquerytoollist>();
            Vquerytoollist vquerytoollist = new Vquerytoollist();
            vquerytoollist.setMessageCode(IConstant.EMSG0004);
            vquerytoollist.setRetErrFlag(true);
            vquerytoollist.setExceMessage(e.getMessage());
            list.add(vquerytoollist);
            return list;
        }
    }

    /**
     * 根据RFID查询对应的刀具编码
     * (只支持单品刀具)
     *
     * @param RFIDString
     * @return
     */
    public String getToolCodeByRFIDString(String RFIDString) throws SQLException {
        //查询RFID载体
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        rfidcontainer.setRfidCode(RFIDString);
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        List<Rfidcontainer> rfList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
        if (rfList.size() > 0) {
            //载体ID
            String rfidContainerId = rfList.get(0).getRfidContainerID();
            //查询rfid是不是单品刀具
            Knifeinventory ki = new Knifeinventory();
            ki.setRfidContainerID(rfidContainerId);
            List<Knifeinventory> kiList = (List<Knifeinventory>) knifeinventoryDao.searchByList(ki);
            if (kiList.size() > 0) {
                Tool tool = new Tool();
                tool.setToolID(kiList.get(0).getToolID());
                //  tool.setDelFlag(IConstant.DEL_FLAG_0);
                List<Tool> tools = (List<Tool>) toolDao.searchByList(tool);
                if (tools.size() > 0)
                    return tools.get(0).getToolCode();
            }

            //初始化的单品刀具
            Tooltransfer tt = new Tooltransfer();
            tt.setRfidContainerID(rfidContainerId);
            List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList(tt);
            if (ttList.size() > 0) {
                Tool tool = new Tool();
                tool.setToolID(ttList.get(0).getToolID());
                tool.setDelFlag(IConstant.DEL_FLAG_0);
                List<Tool> tools = (List<Tool>) toolDao.searchByList(tool);
                if (tools.size() > 0)
                    return tools.get(0).getToolCode();
            }
        }
        return null;
    }

}
