package com.icomp.common.service.impl.icomp.v01c03.s003;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c03.s003.ICOMPV01C03S003Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.ComlistDao;
import com.icomp.dao.CustomerDao;
import com.icomp.dao.EquipmentDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.UserdetailDao;
import com.icomp.dao.VgetcustomerinfoDao;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Vgetcustomerinfo;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ICOMPV01C03S003ServiceImpl extends BaseService implements ICOMPV01C03S003Service {

    /* 系统区分Dao */
    private ComlistDao comlistDao;
    private CustomerDao customerDao;

    public void setVgetcustomerinfoDao(VgetcustomerinfoDao vgetcustomerinfoDao) {
        this.vgetcustomerinfoDao = vgetcustomerinfoDao;
    }

    private VgetcustomerinfoDao vgetcustomerinfoDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    private UserdetailDao userdetailDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 系统区分Dao 设定
     *
     * @param
     */
    public void setComlistDao(ComlistDao comlistDao) {
        this.comlistDao = comlistDao;
    }

    private EquipmentDao equipmentDao;

    public void setEquipmentDao(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    @Override
    public Map<String, Object> getEquipment(String value, String langCode) {
        Map<String, Object> ret = new HashMap<String, Object>();
        String equipmentType = value;
        try {
            Comlist comlist = new Comlist();
            comlist.setComListType(IConstant.EQUIPMENT_TYPES);
            List<Comlist> comlists = (List<Comlist>) comlistDao.searchByList(comlist);
            List<Comlist> comlists2 = new ArrayList<Comlist>();
            for (Comlist comlist2 : comlists) {
                if (IConstant.EQUIPMENT_TYPES_0.equals(comlist2.getComListValue()) || IConstant.EQUIPMENT_TYPES_1.equals(comlist2.getComListValue()) || IConstant.EQUIPMENT_TYPES_2.equals(comlist2.getComListValue())) {
                    comlists2.add(comlist2);
                }
            }
            ret.put("EquipmentTypes", comlists2);
            //根据设备类型取得设备列表
            Equipment equipment = new Equipment();
            equipment.setEquipmentType(equipmentType);
            equipment.setDelFlag(IConstant.DEL_FLAG_0);
            List<Equipment> equipmentList = (List<Equipment>) equipmentDao.searchByList(equipment);
            if (equipmentList == null || equipmentList.size() <= 0) {
                //系统支持的语言未找到相应数据!
                ret.put("MessageCode", IConstant.WMSG0243);
                ret.put("error", true);
                return ret;
            }
            ret.put("EquipmentList", equipmentList);
            ret.put("status", IConstant.RESULT_CODE_0);
            return ret;
        } catch (SQLException e) {
            ret.put("error", true);
            ret.put("MessageCode", IConstant.EMSG0004);
            return ret;
        }
    }

    @Override
    public Map<String, Object> saveEquipmentRfid(Equipment entity) {
        Map<String, Object> ret = new HashMap<String, Object>();
        try {
            String rfidID;
            //验证rfid 是否可用
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(entity.getRfidContainerID());
            List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            if (rfidcontainerList == null || rfidcontainerList.size() <= 0) {
                // 新建载体数据
                rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
                rfidcontainer.setQueryType(IConstant.STRING_2);
                rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
                rfidcontainer.setVersion(BigDecimal.ZERO);
                rfidcontainer.setUpdateTime(new Date());
                rfidcontainer.setUpdateUser(entity.getUpdateUser());
                rfidcontainer.setSystemLogUser(entity.getUpdateUser());
                rfidcontainer.setRfidReCount(BigDecimal.ONE);
                rfidID = NextKeyValue.getNextkeyvalue(IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID, entity.getUpdateUser());
                rfidcontainer.setRfidContainerID(rfidID);
                rfidcontainerDao.insert(rfidcontainer);
            } else {
                // 如果删除区分为无效
                rfidcontainer = rfidcontainerList.get(0);
                if (IConstant.DEL_FLAG_1.equals(rfidcontainer.getDelFlag())) {
                    rfidID = rfidcontainer.getRfidContainerID();
                    Rfidcontainer upRfidcontainer = new Rfidcontainer();
                    upRfidcontainer.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                    upRfidcontainer.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                    upRfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
                    rfidcontainerDao.updateNonQuery(upRfidcontainer);
                } else {
                    ret.put("error", true);
                    ret.put("MessageCode", IConstant.WMSG0147);
                    return ret;
                }
            }
            Equipment equipment = new Equipment();
            equipment.setRfidContainerID(rfidID);
            equipment.setEquipmentIDWhere(entity.getEquipmentID());
            equipmentDao.updateNonQuery(equipment);
            ret.put("status", IConstant.RESULT_CODE_0);
            ret.put("MessageCode", IConstant.CIMSG0091);//设备标签绑定成功!
            return ret;
        } catch (SQLException e) {
            ret.put("error", true);
            ret.put("MessageCode", IConstant.EMSG0004);
            return ret;
        }
    }

    @Override
    public Vgetcustomerinfo findMemberMsgByCard(Vgetcustomerinfo c) throws Exception {
        Vgetcustomerinfo reEntity = new Vgetcustomerinfo();
        // 根据载体ID或材料号查询信息
        List<Vgetcustomerinfo> reList = (List<Vgetcustomerinfo>) vgetcustomerinfoDao.searchByList(c);
        if (reList == null || reList.size() < 1) {
            reEntity.setRetErrFlag(true);
        } else {
            reEntity = reList.get(0);
        }
        return reEntity;
    }

    @Override
    public int submitEmployeeCardMsg(Map<String, Object> parMap) throws Exception {
        //RFidCode
        String rfidCode = (String) parMap.get("rfidCode");
        //用户iD
        String userID = (String) parMap.get("userID");
        //用户卡号
        String userCard = (String) parMap.get("userCard");
        //要绑定的用户ID
        String blindCustomerID = (String) parMap.get("blindCustomerID");
        //旧RFID载体
        String oldRfidConnerID = (String) parMap.get("oldRfidConnerID");
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        Customer c = new Customer();
        String rifdString = null;

        if (oldRfidConnerID != null) {
            //更新
              //RFID载体ID
            rfidcontainer.setRfidContainerIDWhere(oldRfidConnerID);
            rfidcontainer.setRfidContainerID(rifdString);
            //RFID标签ID
            rfidcontainer.setRfidCode(rfidCode);
            //RFID重用次数
            rfidcontainer.setRfidReCount(BigDecimal.ONE);
            //绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
            rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
            //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
            rfidcontainer.setQueryType(IConstant.KNIFE_INVENTORY_TYPE_3);
            //删除区分(0有效1删除)
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            rfidcontainer.setCreateTime(new Date());
            rfidcontainer.setUpdateTime(new Date());
            rfidcontainer.setCreateUser(userID);
            rfidcontainer.setUpdateUser(userID);
            //加入载体表
            rfidcontainerDao.updateNonQuery(rfidcontainer);


        } else {
            //新增
            rifdString = UUIDgen.getId();
            //RFID载体ID
            rfidcontainer.setRfidContainerID(rifdString);
            //RFID标签ID
            rfidcontainer.setRfidCode(rfidCode);
            //RFID重用次数
            rfidcontainer.setRfidReCount(BigDecimal.ONE);
            //绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
            rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
            //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
            rfidcontainer.setQueryType(IConstant.KNIFE_INVENTORY_TYPE_3);
            //删除区分(0有效1删除)
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            rfidcontainer.setCreateTime(new Date());
            rfidcontainer.setUpdateTime(new Date());
            rfidcontainer.setCreateUser(userID);
            rfidcontainer.setUpdateUser(userID);
            //加入载体表
            rfidcontainerDao.insert(rfidcontainer);

        }
        c.setCustomerIDWhere(blindCustomerID);
        c.setEmployeeCardWhere(userCard);
        c.setRfidContainerID(rifdString);
        c.setUpdateUser(userID);
        c.setUpdateTime(new Date());
        c.setCreateUser(userID);
        c.setUserErrFlag(IConstant.USER_ERR_FLAG_0);
        c.setCreateTime(new Date());
        c.setDelFlag(IConstant.DEL_FLAG_0);
        c.setUpdateUser(userID);
        c.setUpdateTime(new Date());
        return customerDao.updateNonQuery(c);
    }


}
