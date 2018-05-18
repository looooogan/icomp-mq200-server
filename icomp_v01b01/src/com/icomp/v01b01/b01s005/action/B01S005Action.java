package com.icomp.v01b01.b01s005.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vapplyuser;
import com.icomp.entity.base.Vreplacement;
import com.icomp.v01b01.b01s005.business.B01S005Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 补领/申领信息查询
 *
 * @author Taoyy
 * @ClassName: B01S005Action
 * @date 2014-8-12 下午04:21:51
 */
public class B01S005Action extends IcompAction {
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 7255161566182210074L;
    /**
     * 申请信息查询BUSINESS
     */
    private B01S005Business b01s005Business;

    public void setB01s005Business(B01S005Business b01s005Business) {
        this.b01s005Business = b01s005Business;
    }

    /**
     * 页面初始化
     *
     * @return String
     * @title initb01S005
     */
    public String initb01S005() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();

            //参数
            Map<String, Object> param = super.param();
            System.out.println(param);
            if ("list".equals(param.get("opt"))) {
                //申请信息列表
                Map<String, Object> list = this.b01s005Business.getList(param, langCode, langValue,1);
                super.ajaxReturn(list);
                return null;
            }else{
                total = this.b01s005Business.getNumber();
                // 初始化页面下拉列表默认值
                super.assign("department","");
                //取得下拉列表列表
                Map<String,Object> list = this.b01s005Business.getPageSelList(langCode, langValue);
                super.assign("DepartmentList",list.get("DepartmentList"));
//                super.assign("vapplyList",list.get("Vreplacement"));
                Map<String,Object> userList = this.b01s005Business.getUserList(langCode, langValue);
                super.assign("UserLists",userList.get("UserList"));
                // 取得页面grid显示项目列表
                super.session("gridcol", b01s005Business.getGridColmun("B01S005", ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue));
                return SUCCESS;
            }

        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B01S005.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B01S005", ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 新建
     *
     * @return String
     * @title initb01S005
     */
    public String replacementAdd() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            //参数
            Map<String, Object> param = super.param();

                //申请信息列表
                Map<String, Object> ret = this.b01s005Business.replacementAdd(param, langCode, langValue,((Customer) super.session("Customer")).getCustomerID());

                if ((ret.get("message") != null)) {
                    super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
                    return null;
                } else {
                    super.ajaxReturn(ret);
                }
            // 取得页面grid显示项目列表
            super.session("gridcol", b01s005Business.getGridColmun("B01S005", ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue));
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B01S005.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B01S005", ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 编辑
     * @return
     */
  public String replacementEdit() {
      try {
          String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
          String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
          Map<String, Object> param = super.param();

          Map<String, Object> ret = this.b01s005Business.replacementEdit(param, langCode, langValue,((Customer) super.session("Customer")).getCustomerID() );
          if (ret.get("message") != null

                  && !"-2".equals(ret.get("status").toString())) {
              super.ajaxReturn(null, null, ret.get("message"), Integer
                      .parseInt(ret.get("status").toString()));
              return null;
          } else {
              super.ajaxReturn(ret);
          }

          return null;
      } catch (BusinessException ex) {
          ApplicationException.setApplicationException(getResponse(),
                  "/replacementEdit.action", IConstant.RESULT_CODE_1, ex, this
                          .getClass().getName(), "replacementEdit",
                  ((Customer) super.session("Customer")).getCustomerID());
          return null;
      }
  }

    public String replacementInfo() {
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b01s005Business.printItemInfo(param, langCode,langValue);
            super.ajaxReturn(ret);
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/printItemInfo.action", IConstant.RESULT_CODE_1, ex, this
                            .getClass().getName(), "printItemInfo",
                    ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }
//    部门用户联动
    public  String replacementLink(){
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            // 根据用户选择的机构ID，取得 相应的部门及职务列表
            Map<String, Object> param = super.param();
            String cuID = param.get("departmentID").toString();
                List<Vapplyuser> vapplyList = b01s005Business.getVapplyuser(cuID, IConstant.DEL_FLAG_0, langCode, langValue,1);
                super.assign("vapplyList", vapplyList);
                super.ajaxReturn(vapplyList, null, vapplyList.get(0).getMessageCode()==null?0:-2, null );
            // 取得流程工序中间表
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/prossAndBuss.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "prossAndBuss",
                    ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }


    private String systeCode;
    private String reissueReason;
    private String dstars;
    private String dends;
    private String receiveDepartment;
    private String applyPerson;
    private String operator;
    private String returnStatus;
    private String excelFileName;
    private InputStream excelStream;

    public String getSysteCode() {
        return systeCode;
    }

    public void setSysteCode(String systeCode) {
        this.systeCode = systeCode;
    }

    public String getReissueReason() {
        return reissueReason;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public void setReissueReason(String reissueReason) {
        this.reissueReason = reissueReason;
    }

    public String getDstars() {
        return dstars;
    }

    public void setDstars(String dstars) {
        this.dstars = dstars;
    }

    public String getDends() {
        return dends;
    }

    public void setDends(String dends) {
        this.dends = dends;
    }

    public String getReceiveDepartment() {
        return receiveDepartment;
    }

    public void setReceiveDepartment(String receiveDepartment) {
        this.receiveDepartment = receiveDepartment;
    }

    public String getApplyPerson() {
        return applyPerson;
    }

    public void setApplyPerson(String applyPerson) {
        this.applyPerson = applyPerson;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getExcelFileName() {
        return excelFileName;
    }

    public void setExcelFileName(String excelFileName) {
        this.excelFileName = excelFileName;
    }

    public InputStream getExcelStream() {
        return excelStream;
    }

    public void setExcelStream(InputStream excelStream) {
        this.excelStream = excelStream;
    }
    public String exportExcel() {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("systeCode", systeCode);
        param.put("reissueReason", reissueReason);
        param.put("dstar", dstars);
        param.put("dends", dends);
        param.put("receiveDepartment", receiveDepartment);
        param.put("applyPerson", applyPerson);
        param.put("operator", operator);
        param.put("returnStatus", returnStatus);
        try {
            HSSFWorkbook wb = new HSSFWorkbook();//创建一个工作间
            HSSFSheet sheet = wb.createSheet("sheet1");//创建一个sheet
            sheet.addMergedRegion(new CellRangeAddress(0,0, 0, 9));//合并单元格
            HSSFCellStyle style = wb.createCellStyle();//居中
            HSSFRow rowss = sheet.createRow(0);//创建第一行
            HSSFCell cellss = rowss.createCell(0);
            cellss.setCellValue("检索：");
            cellss.setCellStyle(style);

            HSSFRow rows = sheet.createRow(1);//创建第二行
            HSSFCell cells = rows.createCell(0);//创建这行的第一个元素.从0开始

            cells.setCellValue("材料号");
            cells=rows.createCell(1);
            if ("".equals(systeCode)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(systeCode);
            }
            cells =rows.createCell(2);
            cells.setCellValue("借用状态");
            cells=rows.createCell(3);
            if ("".equals(reissueReason)){
                cells.setCellValue("-");
            }else if ("0".equals(reissueReason)){
                cells.setCellValue("已归还-未到期");
            }else if ("1".equals(reissueReason)){
                cells.setCellValue("未归还-未到期");
            }else if ("2".equals(reissueReason)){
                cells.setCellValue("未归还-已到期");
            }
            cells =rows.createCell(4);
            cells.setCellValue("查询时间");
            cells=rows.createCell(5);
            if ("".equals(dstars)&&"".equals(dends)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(dstars+"--"+dends);
            }
            cells =rows.createCell(6);
            cells.setCellValue("领用部门");
            cells=rows.createCell(7);
            if ("".equals(receiveDepartment)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(receiveDepartment);
            }
            cells =rows.createCell(8);
            cells.setCellValue("经办人");
            cells=rows.createCell(9);
            if ("".equals(applyPerson)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(applyPerson);
            }
            cells =rows.createCell(10);
            cells.setCellValue("借用人");
            cells=rows.createCell(11);
            if ("".equals(operator)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(operator);
            }
            cells =rows.createCell(12);
            cells.setCellValue("补领原因");
            cells=rows.createCell(13);
            if ("".equals(returnStatus)){
                cells.setCellValue("-");
            }else if ("0".equals(returnStatus)) {
                cells.setCellValue("借用");
            }else if("1".equals(returnStatus)){
                cells.setCellValue("补充周转量");
            }else if("2".equals(returnStatus)){
                cells.setCellValue("特殊领用");
            }
            HSSFRow rowsd = sheet.createRow(2);//创建第三行
            HSSFCell cellsd = rowsd.createCell(0);//创建这行的第一个元素.从0开始
            sheet.addMergedRegion(new CellRangeAddress(2,2, 0, 9));//合并单元格
            cellsd.setCellValue("详细");
            cellsd.setCellStyle(style);

            HSSFRow row = sheet.createRow(3);//创建第四行
            HSSFCell cell = row.createCell(0);//创建这行的第一个元素.从0开始

            cell.setCellValue("补领单号");//写入内容
            cell.setCellStyle(style);

            cell = row.createCell(1);//同上
            cell.setCellValue("材料号");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("补领原因");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("时间");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("借用归还状态");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("借用周期(天)");
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue("申领人");
            cell.setCellStyle(style);

            cell = row.createCell(7);
            cell.setCellValue("刀具类型");
            cell.setCellStyle(style);


            cell = row.createCell(8);
            cell.setCellValue("借用数量");
            cell.setCellStyle(style);

            cell = row.createCell(9);
            cell.setCellValue("归还时间");
            cell.setCellStyle(style);

            Map<String, Object> list = new HashMap<String, Object>();
            try {
                list = this.b01s005Business.getList(param, "", "",2);
                if (list == null && list.size() < 0) {
                    list = new HashMap<String, Object>();
                }
            } catch (Exception e1) {
                System.out.println("ecxel导出异常");
            }
            List<Vreplacement> vrList = (List<Vreplacement>) list.get("rows");
            if (vrList == null) {
                vrList = new ArrayList<Vreplacement>();
            }


            //循环,将下面几行的数据取出来放入这个sheet中
            for (int i = 0; i < vrList.size(); i++) {
                Vreplacement vsystion = vrList.get(i);
                row = sheet.createRow(i + 4);

                cell = row.createCell(0);//补领单号
                if ("".equals(vsystion.getReplacementID())||vsystion.getReplacementID()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vsystion.getReplacementID());
                }


                cell = row.createCell(1);//材料号
                if ("".equals(vsystion.getToolCode())||vsystion.getToolCode()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vsystion.getToolCode());
                }

                cell = row.createCell(2);//补领原因
                if ("".equals(vsystion.getReplacementReason())||vsystion.getReplacementReason()==null){
                    cell.setCellValue(new Date());
                }else if ("0".equals(vsystion.getReplacementReason())) {
                    cell.setCellValue("借用");
                }else if("1".equals(vsystion.getReplacementReason())){
                    cell.setCellValue("补充周转量");
                }else if("2".equals(vsystion.getReplacementReason())){
                    cell.setCellValue("特殊领用");
                }


                cell = row.createCell(3);//时间
                if ("".equals(vsystion.getApplyTime())||vsystion.getApplyTime()==null){
                    cell.setCellValue("-");
                }else {
                    String date = Ctl.dateFormat(vsystion.getApplyTime(), "yyyy-MM-dd");
                    cell.setCellValue(date);
                }


                cell = row.createCell(4);//借用归还状态
                if ("".equals(vsystion.getStockState())||vsystion.getStockState()==null){
                    cell.setCellValue("-");
                }else if ("0".equals(vsystion.getStockState())){
                    cell.setCellValue("已归还-未到期");
                }else if ("1".equals(vsystion.getStockState())){
                    cell.setCellValue("未归还-未到期");
                }else if ("2".equals(vsystion.getStockState())){
                    cell.setCellValue("未归还-已到期");
                }


                cell = row.createCell(5);//借用周期
                if ("".equals(vsystion.getCycle())||vsystion.getCycle()==null){
                    cell.setCellValue(IConstant.STRING_0);
                }else {
                    cell.setCellValue(String.valueOf(vsystion.getCycle()));
                }
                cell = row.createCell(6);//申领人
                if ("".equals(vsystion.getApplyUser())||vsystion.getApplyUser()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vsystion.getApplyUser());
                }
                cell = row.createCell(7);//刀具类型
                if ("".equals(vsystion.getToolCode())||vsystion.getToolCode()==null){
                    cell.setCellValue("-");
                }else {
                    String  type = String.valueOf(vsystion.getToolCode().charAt(0));
                    cell.setCellValue(type);
                }
                cell = row.createCell(8);//借用数量
                if ("".equals(vsystion.getAppliedNumber())||vsystion.getAppliedNumber()==null){
                    cell.setCellValue(IConstant.STRING_0);
                }else {
                    cell.setCellValue(String.valueOf(vsystion.getAppliedNumber()));
                }

                cell = row.createCell(9);//归还时间
                if ("".equals(vsystion.getReturnTime())||vsystion.getReturnTime()==null){
                    cell.setCellValue("-");
                }else {
                    String date = Ctl.dateFormat(vsystion.getReturnTime(), "yyyy-MM-dd");
                    cell.setCellValue(date);
                }

            }
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            wb.write(os);
            os.close();
            byte[] fileContent = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
            excelStream = is;
            excelFileName = "补领信息查询.xls";
            excelFileName = new String(excelFileName.getBytes("gb2312"),
                    "iso8859-1");
            is.close();
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B03S001.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B03S001", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        } catch (IOException e) {
            System.out.println("写入流异常");
        }
        return "exportExcels";

    }
}
