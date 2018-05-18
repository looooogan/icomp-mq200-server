package com.icomp.common.service;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Authorization;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Formulas;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vbusiness;
import com.icomp.entity.base.Vcustomer;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vequipment;
import com.icomp.entity.base.Vgetpositioncapability;
import com.icomp.entity.base.Vgetsynthesisexperience;
import com.icomp.entity.base.Vinventoryalarm;
import com.icomp.entity.base.Vposition;
import com.icomp.entity.base.Vprocess;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 系统初始化Service
 *
 * @author yzq
 */
public interface CommonService {

    /**
     * 取得系统默认语言
     *
     * @return 默认语言编码
     */
    public Languagetable getSystemDefaultLanguage();

    /**
     * 取得系统语言列表
     *
     * @return 默认语言编码
     */
    public List<Languagetable> getSystemListLanguage();

    /**
     * 取得页面文本内容
     *
     * @param getType  取得类型
     * @param langCode 语言Code
     * @param pageID   页面ID
     * @param paraName 项目ID(未指定时则全取)
     * @return 页面文本内容
     */
    public Map<String, String> getPageLabelText(String getType, String langCode, String pageID, String paraName);

    /**
     * 取得系统区分列表
     *
     * @param entity 查询条件
     * @return
     */
    public List<Comlist> getComList(Comlist entity);

    /**
     * 取得Android端页面项目属性
     *
     * @return
     */
    public List<Displayeditemconfiguration> getContorllList(String langCode, String pageID, String itemType);

    /**
     * 取得组织结构信息列表
     *
     * @param entity 查询条件
     */
    public List<Vagency> getVagency(Vagency entity);

    /**
     * 取得组织结构信息列表
     *
     * @param entity 查询条件
     */
    public List<Vdepartment> getVdepartment(Vdepartment entity);

    /**
     * 取得组织结构信息列表
     *
     * @param entity 查询条件
     */
    public List<Vposition> getVposition(Vposition entity);

    /**
     * 取得流水线信息列表
     *
     * @param entity 查询条件
     */
    public List<Assemblyline> getAssemblyLine(Assemblyline entity);

    /**
     * 取得工序信息列表
     *
     * @param entity 查询条件
     */
    public List<Vprocess> getProcess(Vprocess entity);

    /**
     * 取得设备信息列表
     *
     * @param entity 查询条件
     */
    public List<Vequipment> getEquipment(Vequipment entity);

    /**
     * 取得流程名列表
     *
     * @param entity 查询条件
     */
    public List<Vbusiness> getBusiness(Vbusiness entity);

    /**
     * 取得页面grid显示项目列表
     *
     * @param pageID
     * @param langCode
     * @param itemType 项目类别(0手持机1平台2打印项目)
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> getGridColmun(String pageID, String langCode, String itemType);

    /**
     * 刀具业务流程验证
     *
     * @param rfidString 当前扫描的rfid标签
     * @return
     */
    public Map<String, Object> checkToolStauts(String rfidString, String flowName, String langCode);

    /**
     * 刀具业务流程验证（盘点）
     *
     * @param rfidString 当前扫描的rfid标签
     * @return
     */
    public Map<String, Object> checkToolStautspd(String rfidString, String flowName, String langCode);

    /**
     * 取得用户列表
     *
     * @param entity
     * @return List<Vcustomer>
     * @title getVcustomer
     */
    public List<Vcustomer> getVcustomer(Vcustomer entity);

    /**
     * 库存异常报警列表
     */
    public Map<String, Object> getInventoryCountList(Vinventoryalarm entity);

    /* ***********Tyy  2014年11月29日 10:42:23     Start  ************ */

    /**
     * 查询是否RFID是否绑定 如果没有绑定刚绑定
     *
     * @param rfidString
     */
    public Map<String, Object> checkIsHasRfid(String rfidString, String userID);

    /**
     * 获取库管的领刀人权限
     *
     * @param entity
     * @return List<Vgetpositioncapability>
     * @title getPositionCapability
     */
    public List<Vgetpositioncapability> getPositionCapability(Vgetpositioncapability entity);

    /**
     * 根据RFID判断是刀具的属性
     *
     * @param: rfidString
     * @return: "0"-该RFID没有初始化,"1"- 合成刀具,"2"- 单品刀具,"3"- 辅具,"4"- 配套 "5"- 设备
     */
    String getToolsTypeByRfid(String rfidString) throws SQLException;

    /**
     * 根据RFID获取当前走过的流程
     *
     * @return
     * @throws SQLException
     */
    public List<Vgetsynthesisexperience> getSynthesisHistory(String rfidString) throws SQLException;

    /**
     * 根据用户ID取得对应的姓名
     *
     * @param userId
     * @return
     * @throws SQLException
     */
    public String getUserName(String userId) throws SQLException;

    /**
     * 根据RFID查询是否绑定激光码
     *
     * @param rfidString
     * @return 0:rfid, 1:激光码,2工具盘
     * @throws SQLException
     */
    public String getBandType(String rfidString) throws SQLException;

    /**
     * 更新和增加RFIDConterner
     * 如果有则更新,如果没有则增加
     *
     * @param rfidString //rfid
     * @param userId     //用户id
     * @throws SQLException
     */
    public void updateAndInsertRFID(String rfidString, String userId) throws SQLException;

    /**
     * 刀具报废
     *
     * @param map CustomerID    用户id(String)
     *            RfidString       报废标签(String)
     *            HandSetId      手持机id(String)
     *            gruantId         授权人Id(String)
     *            BusinessCode  流程名[C0XS0XX](String)
     * @return int   >0 成功  < 1 失败
     * @title savetoolDelete
     */
    public int savetoolDelete(Map<String, Object> map) throws Exception;

    /**
     * 新旧RFID交换(分盒)
     *
     * @param map newRfid              新的RFID(String)
     *            oldRfid               旧的RFID(String)
     *            tempNumbe      要交换的数量(String)
     *            userId                用户Id(String)
     *            BusinessCode  流程名[C0XS0XX](String)
     * @return true 成功   false 失败
     * @throws Exception
     */
    public Boolean saveSplitBoxTool(Map map) throws Exception;

    /**
     * 取得报废盒子
     *
     * @param rfidString
     * @return 0 空盒
     * 1. 合成刀具
     * 2. 已报废的单品刀具
     * 3. 辅具
     * 4. 配套
     * 5. 设备
     * @throws Exception
     */
    public String checkIsHasDiscard(String rfidString, String userId) throws Exception;

    /**
     * 查询已流转中辅具的刀具编码
     *
     * @param rfidString
     * @return toolCode
     * @throws SQLException
     */
    public String getHelpToolInfo(String rfidString) throws SQLException;

    /**
     * 取得ComListText
     *
     * @param entity DelFlag(String)  删除区分     0
     *               LanguageCode  语言编码    01
     *               ComListType     区分类型    StockState
     *               ComListValue    区分值       1
     * @return ComListText    区分文本
     * @throws SQLException
     */
    public String getComListText(Comlist entity) throws SQLException;

    /* * *********Tyy  2015年4月8日 13:47:43     End  ************ */

    Map<String, Object> ChangePassword(Customer entity, String langCode, String langValue);

    Map<String, Object> checkChangePasswordInput(Map<String, Object> param, String langCode, String langValue, String customerID, int i);

    List<String> checkList(List<String> parsm);

    /**
     * 扫描要放入刀具的容器
     *
     * @param rfidString
     * @return 0:非容器
     * 1:正常容器
     * 2:报废容器
     * 3:空容器
     * @throws Exception
     */
    String getToolsContainerByRfid(String rfidString, String userid) throws Exception;

    /**
     * 根据RFID取得载体id
     *
     * @param rfidString
     * @return
     * @throws Exception
     */
    String getrfidContainerIdByRfid(String rfidString) throws Exception;

    /**
     * 根据RFID查询对应的部门
     *
     * @param rfidString
     * @return 0:库房
     * 1:对刀室
     * 2.刃磨室
     * 3.车间
     * @throws Exception
     */
    String getToolStateByRfid(String rfidString) throws Exception;

    /**
     * 按照RFIDCode查詢RFID载体
     *
     * @param entity
     * @return
     */
    String getRfidContainerIDByRfidCode(Rfidcontainer entity) throws Exception;

    Rfidcontainer getRfidContainerByRfidCode(Rfidcontainer entity) throws Exception;

    /**
     * 查询该员工是否初始化
     *
     * @param customer
     * @return
     * @throws Exception
     */
    String getisHasInit(Customer customer) throws Exception;

    /**
     * 根据RFIDCode查询对应的类类型
     *
     * @param rfidCode
     * @return Rfidcontainer
     * null 未初始化
     * queryType标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
     * @throws Exception
     */
    Rfidcontainer checkRFIDType(String rfidCode) throws Exception;

    /**
     * 授权记录插入
     *
     * @param authorization authorizationUserID    授权人ID,
     *                      authorizedReason    授权原因,
     *                      tooltype    刀具类型（0单品，1合成刀具）,
     *                      toolCode    材料号或合成刀具编码,
     *                      BusinessCode  业务流程编码（C03S002）,
     *                      CreateUserID 创建人,
     *                      note  备注（情况简介）,
     * @return
     * @throws SQLException
     */
    Object innsetGruant(Authorization authorization) throws SQLException;

    /**
     * 流程控制共同
     *
     * @param param businessCode  当前流程（C01S001）,
     *              rfidCode  rfid标签（E0000000000）,
     *              gruantUserID  授权人ID
     * @return IConstant.STATE_CODE
     * 0 正常流程
     * 1.需要授权
     * 2.不能执行当前流程
     * 9.未知错误
     */
    Map<String, String> processControlBussinesCode(Map<String, String> param) throws Exception;

    String getSynthesisToolCode(String synthesisParametersCode) throws Exception;

    List<Parts> getPartsList(Parts parts) throws SQLException;

    List<Formulas> getFormulasList(Formulas formulas) throws SQLException;

    /**
     * 根据材料号查询刀具ID
     *
     * @param toolCode
     * @return
     * @throws SQLException
     */
    String getToolIDByToolCode(String toolCode) throws Exception;

    /**
     * 根据RFID载体查询相应容器的数量
     *
     * @param cc
     * @return
     * @throws Exception
     */
    int getContainerTypeByRfidContainer(Containercarrier cc) throws Exception;

    /**
     * 清空当前扫描的标签信息
     *
     * @param map
     * @return
     */
    int delRfidCodeIsNullByToolType(Map<String, Object> map);

    // 2017/09/12 王冉 追加↓↓↓　dazhong@YMSC
    Map<String, Object> delRfidCodeIsNull(Map<String, Object> map);
    // 2017/09/12 王冉 追加↑↑↑　dazhong@YMSC

    Tool getToolsByID(String toolID)throws SQLException;

}
