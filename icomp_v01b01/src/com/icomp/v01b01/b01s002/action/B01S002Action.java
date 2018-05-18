package com.icomp.v01b01.b01s002.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vtoollibraryhistory;
import com.icomp.v01b01.b01s002.business.B01S002Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出库信息查询Action
 *
 * @author Taoyy
 * @ClassName: B01S002Action
 * @date 2014-8-12 下午04:13:27
 */
public class B01S002Action extends IcompAction {
    private String tola;

    public String getTola() {
        return tola;
    }

    public void setTola(String tola) {
        this.tola = tola;
    }

    private static final long serialVersionUID = 1L;
    /**
     * 出库信息查询Business
     */
    private B01S002Business b01s002Business;

    public void setB01s002Business(B01S002Business b01s002Business) {
        this.b01s002Business = b01s002Business;
    }

    /**
     * 页面初始化
     *
     * @return String
     * @title initb01S002
     */
    public String initb01S002() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            // 参数
            Map<String, Object> param = super.param();
            if ("list".equals(param.get("opt"))) {
                //  出库信息列表
                Map<String, Object> list = this.b01s002Business.getList(param, langCode, langValue, 1);
                super.ajaxReturn(list);
                return null;
            }
            tola = this.b01s002Business.getnumber();
            // 取得页面grid显示项目列表
            super.session("gridcol", b01s002Business.getGridColmun(
                    "B01S002", ((Customer) super.session("Customer"))
                            .getCustomerID(), langCode, langValue));
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B01S002.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B01S002", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        }
    }

    public String exportExcel() {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ToolConsumetype", toolConsumetype);
        param.put("dstar", dateStar);
        param.put("dend", dateEnd);
        param.put("systeCode", systeCode);
        param.put("libraryMember", libraryMember);
        param.put("deliveryReason1", deliveryReason1);
        param.put("deliveryReason", deliveryReason);
        param.put("usePerson", usePerson);
        try {
            HSSFWorkbook wb = new HSSFWorkbook();//创建一个工作间
            HSSFSheet sheet = wb.createSheet("sheet1");//创建一个sheet
            HSSFCellStyle style = wb.createCellStyle();//居中
            sheet.addMergedRegion(new CellRangeAddress(0,0, 0, 9));//合并单元格
            HSSFRow rows = sheet.createRow(0);//创建一行
            HSSFCell cells = rows.createCell(0);//
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
            cellss.setCellValue("出库原因");
            cellss=rowss.createCell(5);
            if ("".equals(deliveryReason)){
                cellss.setCellValue("-");
            } else  if (IConstant.STRING_0.equals(deliveryReason)) {
                cellss.setCellValue("换领出库");
            } else if (IConstant.STRING_1.equals(deliveryReason)) {
                cellss.setCellValue("补领出库");
            }
            cellss = rowss.createCell(6);
            cellss.setCellValue("补领原因");
            cellss=rowss.createCell(7);
            if ("".equals(deliveryReason1)){
                cellss.setCellValue("-");
            }else  if (IConstant.STRING_0.equals(deliveryReason1)) {
                cellss.setCellValue("借用");
            } else if (IConstant.STRING_1.equals(deliveryReason1)) {
                cellss.setCellValue("补充周转量");
            } else if (IConstant.STRING_2.equals(deliveryReason1)) {
                cellss.setCellValue("特殊领用");
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
            if ("".equals(libraryMember)){
                cellss.setCellValue("-");
            }else {
                cellss.setCellValue(libraryMember);
            }
            cellss = rowss.createCell(12);
            cellss.setCellValue("领用人");
            cellss=rowss.createCell(13);
            if ("".equals(usePerson)){
                cellss.setCellValue("-");
            }else {
                cellss.setCellValue(usePerson);
            }


            HSSFRow rowd = sheet.createRow(2);//创建三行
            HSSFCell celld = rowd.createCell(0);//创建这行的第1个元素.从1开始
            sheet.addMergedRegion(new CellRangeAddress(2,2, 0, 9));//合并单元格
            celld.setCellValue("详细");//写入内容







            HSSFRow row = sheet.createRow(3);//创建一行
            HSSFCell cell = row.createCell(0);//创建这行的第一个元素.从0开始
            cell.setCellValue("刀具类型");//写入内容
            cell.setCellStyle(style);

            cell = row.createCell(1);//同上
            cell.setCellValue("材料号");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("出库时间");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("库管员");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("出库数量");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("领用人");
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue("出库原因");
            cell.setCellStyle(style);

            cell = row.createCell(7);
            cell.setCellValue("补领原因");
            cell.setCellStyle(style);
            Map<String, Object> list = new HashMap<String, Object>();
            //按条件查出所需求的list
            try {
                list = this.b01s002Business.getList(param, "", "", 2);
                if (list == null && list.size() < 0) {
                    list = new HashMap<String, Object>();
                }
            } catch (Exception e1) {
                System.out.println("ecxel导出异常");
            }
            List<Vtoollibraryhistory> vlhList = (List<Vtoollibraryhistory>) list.get("rows");
            if (vlhList == null) {
                vlhList = new ArrayList<Vtoollibraryhistory>();
            }
            //循环,将下面几行的数据取出来放入这个sheet中
            for (int i = 0; i < vlhList.size(); i++) {
                Vtoollibraryhistory vtoollibraryhistory = vlhList.get(i);
                row = sheet.createRow(i + 4);
                //row.createCell(0).setCellValue("");
                cell = row.createCell(0);//刀具类型
                if ("".equals(vtoollibraryhistory.getToolType()) || vtoollibraryhistory.getToolType() == null) {
                    cell.setCellValue("-");
                }else{
                    cell.setCellValue(vtoollibraryhistory.getToolType());
                }

                cell = row.createCell(1);//材料号
                if ("".equals(vtoollibraryhistory.getToolCode()) || vtoollibraryhistory.getToolCode() == null) {
                    cell.setCellValue("-");
                } else {
                    cell.setCellValue(vtoollibraryhistory.getToolCode());
                }

                cell = row.createCell(2);//出库时间
                String date = Ctl.dateFormat(vtoollibraryhistory.getReceiveTime(), "yyyy-MM-dd");
                if ("".equals(date) || date == null) {
                    cell.setCellValue("-");
                } else {
                    cell.setCellValue(date);
                }

                cell = row.createCell(3);//库管员
                if ("".equals(vtoollibraryhistory.getLibraryUser()) || vtoollibraryhistory.getLibraryUser() == null) {
                    cell.setCellValue("-");
                } else {
                    cell.setCellValue(vtoollibraryhistory.getLibraryUser());
                }

                cell = row.createCell(4);//出库数量
                if ("".equals(vtoollibraryhistory.getReceiveCount()) || vtoollibraryhistory.getReceiveCount() == null) {
                    cell.setCellValue("-");
                } else {
                    cell.setCellValue(vtoollibraryhistory.getReceiveCount().toString());
                }

                cell = row.createCell(5);//领用人
                if ("".equals(vtoollibraryhistory.getReceiveUser()) || vtoollibraryhistory.getReceiveUser() == null) {
                    cell.setCellValue("-");
                } else {
                    cell.setCellValue(String.valueOf(vtoollibraryhistory.getReceiveUser()));
                }

                cell = row.createCell(6);// 出库原因
                if (IConstant.STRING_0.equals(vtoollibraryhistory.getLibraryCause())) {
                    cell.setCellValue("换领出库");
                } else if (IConstant.STRING_1.equals(vtoollibraryhistory.getLibraryCause())) {
                    cell.setCellValue("补领出库");
                } else {
                    cell.setCellValue("其他");
                }
                cell = row.createCell(7);//补领原因0借用1补充周转量2特殊领用
                if (IConstant.STRING_0.equals(vtoollibraryhistory.getReplacementReason())) {
                    cell.setCellValue("借用");
                } else if (IConstant.STRING_1.equals(vtoollibraryhistory.getReplacementReason())) {
                    cell.setCellValue("补充周转量");
                } else if (IConstant.STRING_2.equals(vtoollibraryhistory.getReplacementReason())) {
                    cell.setCellValue("特殊领用");
                } else {
                    cell.setCellValue("其他");
                }
            }
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            wb.write(os);
            os.close();
            byte[] fileContent = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
            excelStream = is;
            excelFileName = "出库信息查询表.xls";
            excelFileName = new String(excelFileName.getBytes("gb2312"),
                    "iso8859-1");
        } catch (IOException e) {
            System.out.println("写入流异常");
        }
        return "exportExcels";

    }

    private String toolConsumetype;
    private String dateStar;
    private String dateEnd;
    private String systeCode;
    private String usePerson;
    private String libraryMember;
    private String deliveryReason1;
    private String deliveryReason;
    private InputStream excelStream;
    private String excelFileName;

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

    public String getDeliveryReason() {
        return deliveryReason;
    }

    public void setDeliveryReason(String deliveryReason) {
        this.deliveryReason = deliveryReason;
    }

    public String getDeliveryReason1() {
        return deliveryReason1;
    }

    public void setDeliveryReason1(String deliveryReason1) {
        this.deliveryReason1 = deliveryReason1;
    }

    public String getLibraryMember() {
        return libraryMember;
    }

    public void setLibraryMember(String libraryMember) {
        this.libraryMember = libraryMember;
    }

    public String getUsePerson() {
        return usePerson;
    }

    public void setUsePerson(String usePerson) {
        this.usePerson = usePerson;
    }

    public String getSysteCode() {
        return systeCode;
    }

    public void setSysteCode(String systeCode) {
        this.systeCode = systeCode;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDateStar() {
        return dateStar;
    }

    public void setDateStar(String dateStar) {
        this.dateStar = dateStar;
    }

    public String getToolConsumetype() {
        return toolConsumetype;
    }

    public void setToolConsumetype(String toolConsumetype) {
        this.toolConsumetype = toolConsumetype;
    }
}
