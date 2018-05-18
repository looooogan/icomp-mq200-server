package com.icomp.v01b01.b01s001.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Storagerecord;
import com.icomp.v01b01.b01s001.business.B01S001Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 入库信息查询Action
 *
 * @author Taoyy
 * @ClassName: B01S001Action
 * @date 2014-8-12 下午02:31:34
 */
public class B01S001Action extends IcompAction {

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 7255161566182210074L;
    /**
     * 入库信息查询BUSINESS
     */
    private  B01S001Business b01s001Business;

    public void setB01s001Business(B01S001Business b01s001Business) {
        this.b01s001Business = b01s001Business;
    }

    /**
     * 初始化入库信息查询页面
     *
     * @return String
     * @title initb01S001
     */
    public String initb01S001() {


        try {
//            Map<String, Object> list2= new HashMap<String, Object>();
            // 语言实体类
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            // 参数
            Map<String, Object> param = super.param();

            if ("list".equals(param.get("opt"))) {
                // 入库信息查询列表
                Map<String, Object> list1 = this.b01s001Business.getList(param, langCode, langValue,1);
                    super.ajaxReturn(list1);
                    return null;
            }
            // 取得页面grid显示项目列表

            super.session("gridcol", b01s001Business.getGridColmun(
                    "B01S001", ((Customer) super.session("Customer"))
                            .getCustomerID(), langCode, langValue));
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B01S001.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B01S001", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        }
    }
    public String show() {
        try {
            // 语言实体类
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            // 参数
            Map<String, Object> param = super.param();
            if ("list".equals(param.get("opt"))) {
                // 入库信息查询列表
                Map<String, Object> list1 = this.b01s001Business.getList(param, langCode, langValue,1);
                super.ajaxReturn(list1);
                return null;
            }
            // 取得页面grid显示项目列表
            super.session("gridcol", b01s001Business.getGridColmun(
                    "B01S001", ((Customer) super.session("Customer"))
                            .getCustomerID(), langCode, langValue));
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B01S001.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B01S001", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        }
    }

    //	excel下载

    public String exportExcel() {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ToolConsumetype", toolConsumetype);
        param.put("DateStar", dateStar);
        param.put("DateEnd", dateEnd);
        param.put("SysteCode", systeCode);
        param.put("KnifeInventory", knifeInventory);
        param.put("ProcuredBatch", procuredBatch);
        param.put("UserName",userName);
        try {
            HSSFWorkbook wb = new HSSFWorkbook();//创建一个工作间
            HSSFSheet sheet = wb.createSheet("sheet1");//创建一个sheet
            HSSFCellStyle style = wb.createCellStyle();//居中
            sheet.addMergedRegion(new CellRangeAddress(0,0, 0, 9));//合并单元格
            HSSFRow rows = sheet.createRow(0);//创建一行
            HSSFCell cells = rows.createCell(0);//创建这行的第一个元素.从1开始
            cells.setCellValue("检索：");
            cells.setCellStyle(style);

            HSSFRow rowss = sheet.createRow(1);//创建第二行
            HSSFCell cellss = rowss.createCell(0);//创建这行的第一个元素.从0开始
            cellss.setCellValue("刀具类型");
            cellss=rowss.createCell(1);
            if ("".equals(toolConsumetype)){
                cellss.setCellValue("-");
            }else {
                cellss.setCellValue(toolConsumetype);
            }
            cellss = rowss.createCell(2);
            cellss.setCellValue("材料号");
            cellss=rowss.createCell(3);
            if ("".equals(systeCode)){
                cellss.setCellValue("-");
            }else {
                cellss.setCellValue(systeCode);
            }
            cellss = rowss.createCell(4);
            cellss.setCellValue("库存状态");
            cellss=rowss.createCell(5);
            if ("".equals(knifeInventory)){
                cellss.setCellValue("-");
            }else {
                cellss.setCellValue("新刀");
            }
            cellss = rowss.createCell(6);
            cellss.setCellValue("订单号");
            cellss=rowss.createCell(7);
            if ("".equals(procuredBatch)){
                cellss.setCellValue("-");
            }else {
                cellss.setCellValue(procuredBatch);
            }
            cellss = rowss.createCell(8);
            cellss.setCellValue("入库时间");
            cellss=rowss.createCell(9);
            if ("".equals(dateStar)&&"".equals(dateEnd)){
                cellss.setCellValue("-");
            }else {
                cellss.setCellValue(dateStar+"--"+dateEnd);
            }
            cellss = rowss.createCell(10);
            cellss.setCellValue("库管员");
            cellss=rowss.createCell(11);
            if ("".equals(userName)){
                cellss.setCellValue("-");
            }else {
                cellss.setCellValue(userName);
            }
            HSSFRow rowd = sheet.createRow(2);//创建三行
            HSSFCell celld = rowd.createCell(0);//创建这行的第1个元素.从1开始
            sheet.addMergedRegion(new CellRangeAddress(2,2, 0, 9));//合并单元格
            celld.setCellValue("详细");//写入内容

            HSSFRow row = sheet.createRow(3);//创建三行
            HSSFCell cell = row.createCell(0);//创建这行的第1个元素.从1开始
            cell.setCellValue("订单号");//写入内容
            cell.setCellStyle(style);

            cell = row.createCell(1);//同上
            cell.setCellValue("刀具类别");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("材料号");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("库存状态");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("库管员");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("入库数量");
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue("入库时间");
            cell.setCellStyle(style);
            Map<String, Object> list = new HashMap<String, Object>();
            try {
                list = this.b01s001Business.getList(param, "", "",2);
                if (list == null && list.size() < 0) {
                    list = new HashMap<String, Object>();
                }
            } catch (Exception e1) {
                System.out.println("ecxel导出异常");
            }
            List<Storagerecord> vkList = (List<Storagerecord>) list.get("rows");
            if (vkList == null) {
                vkList = new ArrayList<Storagerecord>();

            }
            //循环,将下面几行的数据取出来放入这个sheet中
            for (int i = 0; i < vkList.size(); i++) {
                Storagerecord stenty = vkList.get(i);
                row = sheet.createRow(i + 4);
//row.createCell(0).setCellValue();
                cell = row.createCell(0);
                if ("".equals(stenty.getToolsOrdeNO())||stenty.getToolsOrdeNO()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(stenty.getToolsOrdeNO());//订单号
                }


                cell = row.createCell(1);//刀具类别
                if("".equals(stenty.getStorageType())){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(stenty.getStorageType());
                }
                cell = row.createCell(2);
                if (stenty.getToolCode()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(stenty.getToolCode());//材料号
                }


                cell = row.createCell(3);//库存状态
                if("".equals(stenty.getStorageState())){
                    cell.setCellValue("新刀");
                }else {
                    cell.setCellValue("新刀");
                }

                cell = row.createCell(4);
                if ("".equals(stenty.getCreateUser())||stenty.getCreateUser()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(stenty.getCreateUser());//库管员
                }

                cell = row.createCell(5);
                if ("".equals(stenty.getStorageNum())||stenty.getStorageNum()==null){
                    cell.setCellValue("-");
                }else{
                    cell.setCellValue(String.valueOf(stenty.getStorageNum()));
                }

                cell = row.createCell(6);
                String date = Ctl.dateFormat(stenty.getCreateTime(), "yyyy-MM-dd");
                if ("".equals(date)||date==null){
                    cell.setCellValue(new Date());
                }else {
                    cell.setCellValue(date);
                }

            }
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            wb.write(os);
            os.close();
            byte[] fileContent = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
            excelStream = is;
            excelFileName = "入库查询信息表.xls";
            excelFileName = new String(excelFileName.getBytes("gb2312"),
                    "iso8859-1");
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B01S001.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B01S001", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        } catch (IOException e) {
            System.out.println("写入流异常");
        }
        return "exportExcels";

    }

    private String toolConsumetype;
    private String dateStar;
    private String dateEnd;
    private String systeCode;
    private String knifeInventory;
    private String procuredBatch;
    private String userName;

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public String getToolConsumetype() {
        return toolConsumetype;
    }

    public void setToolConsumetype(String toolConsumetype) {
        this.toolConsumetype = toolConsumetype;
    }

    public String getDateStar() {
        return dateStar;
    }

    public void setDateStar(String dateStar) {
        this.dateStar = dateStar;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getSysteCode() {
        return systeCode;
    }

    public void setSysteCode(String systeCode) {
        this.systeCode = systeCode;
    }

    public String getKnifeInventory() {
        return knifeInventory;
    }

    public void setKnifeInventory(String knifeInventory) {
        this.knifeInventory = knifeInventory;
    }

    public String getProcuredBatch() {
        return procuredBatch;
    }

    public void setProcuredBatch(String procuredBatch) {
        this.procuredBatch = procuredBatch;
    }

    private InputStream excelStream;  //输出流变量

    private String excelFileName; //下载文件名

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
}
