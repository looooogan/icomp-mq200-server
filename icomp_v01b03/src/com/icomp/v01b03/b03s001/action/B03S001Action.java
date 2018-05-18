package com.icomp.v01b03.b03s001.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Userdetail;
import com.icomp.entity.base.Vtoolnoticehistory;
import com.icomp.v01b03.b03s001.business.B03S001Business;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 刃磨记录查询Action
 *
 * @author Taoyy
 * @ClassName: B01S001Action
 * @date 2014-8-12 下午02:31:34
 */
public class B03S001Action extends IcompAction {
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 7255161566182210074L;
    /**
     * 刃磨记录查询BUSINESS
     */
    private B03S001Business b03s001Business;

    public void setB03s001Business(B03S001Business b03s001Business) {
        this.b03s001Business = b03s001Business;
    }

    /**
     * 初始化刃磨记录查询页面
     *
     * @return String
     * @title initb01S001
     */
    public String initb03S001() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            if ("list".equals ( param.get ( "opt" ) )) {
                //  刃磨记录查询
                Map<String, Object> list = this.b03s001Business.getList ( param, langCode, langValue, 1 );
                super.ajaxReturn ( list );
                return null;
            }
            total = this.b03s001Business.getNumber ();
            // 取得页面grid显示项目列表
            super.session ( "gridcol", b03s001Business.getGridColmun ( "B03S001", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B03S001.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B03S001", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }
    //	excel下载

    public String exportExcel() {
        Map<String, Object> param = new HashMap<String, Object> ();
        param.put ( "ToolConsumetype", toolConsumetype );
        param.put ( "DateStar", dateStar );
        param.put ( "DateEnd", dateEnd );
        param.put ( "systeCode", systeCode );
        param.put ( "grindingCode", grindingCode );
        param.put ( "grindingStatus", grindingStatus );
        param.put ( "operator", operator );
        try {
            HSSFWorkbook wb = new HSSFWorkbook ();//创建一个工作间
            HSSFSheet sheet = wb.createSheet ( "sheet1" );//创建一个sheet
            sheet.addMergedRegion ( new CellRangeAddress ( 0, 0, 0, 9 ) );//合并单元格
            HSSFCellStyle style = wb.createCellStyle ();//居中

            HSSFRow rowss = sheet.createRow ( 0 );//创建第一行
            HSSFCell cellss = rowss.createCell ( 0 );
            cellss.setCellValue ( "检索：" );
            cellss.setCellStyle ( style );

            HSSFRow rows = sheet.createRow ( 1 );//创建第二行
            HSSFCell cells = rows.createCell ( 0 );//创建这行的第一个元素.从0开始

            cells.setCellValue ( "刀具类型" );
            cells = rows.createCell ( 1 );
            if ("".equals ( toolConsumetype )) {
                cells.setCellValue ( "-" );
            } else {
                cells.setCellValue ( toolConsumetype );
            }
            cells = rows.createCell ( 2 );
            cells.setCellValue ( "材料号" );
            cells = rows.createCell ( 3 );
            if ("".equals ( systeCode )) {
                cells.setCellValue ( "-" );
            } else {
                cells.setCellValue ( systeCode );
            }
            cells = rows.createCell ( 4 );

            cells.setCellValue ( "查询时间" );
            cells = rows.createCell ( 5 );
            if ("".equals ( dateStar ) && "".equals ( dateEnd )) {
                cells.setCellValue ( "-" );
            } else {
                cells.setCellValue ( dateStar + "--" + dateEnd );
            }
            cells = rows.createCell ( 6 );
            cells.setCellValue ( "刃磨设备编码" );
            cells = rows.createCell ( 7 );
            if ("".equals ( grindingCode )) {
                cells.setCellValue ( "-" );
            } else {
                cells.setCellValue ( grindingCode );
            }
            cells = rows.createCell ( 8 );
            cells.setCellValue ( "刃磨后状态" );
            cells = rows.createCell ( 9 );
            if ("".equals ( grindingStatus )) {
                cells.setCellValue ( "-" );
            } else if (IConstant.STRING_0.equals ( grindingStatus )) {
                cells.setCellValue ( "正常" );
            } else if (IConstant.STRING_1.equals ( grindingStatus )) {
                cells.setCellValue ( "报废" );
            } else {
                cells.setCellValue ( "其他" );
            }
            cells = rows.createCell ( 10 );
            cells.setCellValue ( "借用人" );
            cells = rows.createCell ( 11 );
            if ("".equals ( operator )) {
                cells.setCellValue ( "-" );
            } else {
                cells.setCellValue ( operator );
            }

            HSSFRow rowsd = sheet.createRow ( 2 );//创建第三行
            HSSFCell cellsd = rowsd.createCell ( 0 );//创建这行的第一个元素.从0开始
            sheet.addMergedRegion ( new CellRangeAddress ( 2, 2, 0, 9 ) );//合并单元格
            cellsd.setCellValue ( "详细" );
            cellsd.setCellStyle ( style );

            HSSFRow row = sheet.createRow ( 3 );//创建一行
            HSSFCell cell = row.createCell ( 0 );//创建这行的第一个元素.从0开始
            cell.setCellValue ( "刀具类型" );//写入内容
            cell.setCellStyle ( style );

            cell = row.createCell ( 1 );//同上
            cell.setCellValue ( "材料号" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 2 );
            cell.setCellValue ( "修磨时间" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 3 );
            cell.setCellValue ( "刃磨设备编码" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 4 );
            cell.setCellValue ( "刃磨数量" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 5 );
            cell.setCellValue ( "刃磨后状态" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 6 );
            cell.setCellValue ( "操作者" );
            cell.setCellStyle ( style );
            Map<String, Object> list = new HashMap<String, Object> ();
            try {
                list = this.b03s001Business.getList ( param, "", "", 2 );
                if (list == null && list.size () < 0) {
                    list = new HashMap<String, Object> ();
                }
            } catch (Exception e1) {
                System.out.println ( "ecxel导出异常" );
            }
            List<Vtoolnoticehistory> vlsList = (List<Vtoolnoticehistory>) list.get ( "rows" );
            if (vlsList == null) {
                vlsList = new ArrayList<Vtoolnoticehistory> ();
            }

            //循环,将下面几行的数据取出来放入这个sheet中
            for (int i = 0; i < vlsList.size (); i++) {
                Vtoolnoticehistory vtoolnoticehistory = vlsList.get ( i );
                row = sheet.createRow ( i + 4 );
                //row.createCell(0).setCellValue("");
                cell = row.createCell ( 0 );//刀具类型
                cell.setCellValue ( vtoolnoticehistory.getToolType () );

                cell = row.createCell ( 1 );//材料号
                if ("".equals ( vtoolnoticehistory.getSysteCode () ) || vtoolnoticehistory.getSysteCode () == null) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( vtoolnoticehistory.getSysteCode () );
                }

                cell = row.createCell ( 2 );//时间
                if ("".equals ( vtoolnoticehistory.getNoticeTime () ) || vtoolnoticehistory.getNoticeTime () == null) {
                    cell.setCellValue ( new Date () );
                } else {
                    cell.setCellValue ( Ctl.dateFormat ( vtoolnoticehistory.getNoticeTime (), "yyyy-MM-dd" ) );
                }

                cell = row.createCell ( 3 );//修磨设备编码
                if ("".equals ( vtoolnoticehistory.getEquipmentCode () ) || vtoolnoticehistory.getEquipmentCode () == null) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( vtoolnoticehistory.getEquipmentCode () );
                }

                cell = row.createCell ( 4 );//修磨数量
                if ("".equals ( vtoolnoticehistory.getNoticeCount () ) || vtoolnoticehistory.getNoticeCount () == null) {
                    cell.setCellValue ( IConstant.STRING_0 );
                } else {
                    cell.setCellValue ( String.valueOf ( vtoolnoticehistory.getNoticeCount () ) );
                }

                cell = row.createCell ( 5 );//修磨后状态0正常1报废
                String toolstat = String.valueOf ( vtoolnoticehistory.getRepairedBecause () );
                if (IConstant.STRING_0.equals ( toolstat )) {
                    cell.setCellValue ( "正常" );
                } else if (IConstant.STRING_1.equals ( toolstat )) {
                    cell.setCellValue ( "报废" );
                } else {
                    cell.setCellValue ( "其他" );
                }
                cell = row.createCell ( 6 );
                if ("".equals ( vtoolnoticehistory.getToolRepairNoticeUser () ) || vtoolnoticehistory.getToolRepairNoticeUser () == null) {
                    cell.setCellValue ( "-" );
                } else {
                    Userdetail user = new Userdetail ();
                    user.setCustomerID ( vtoolnoticehistory.getToolRepairNoticeUser () );
                    List<Userdetail> ulist = b03s001Business.getUser ( user );
                    cell.setCellValue ( ulist.get ( 0 ).getUserName () );//操作者
                }
            }
            ByteArrayOutputStream os = new ByteArrayOutputStream ();

            wb.write ( os );
            os.close ();
            byte[] fileContent = os.toByteArray ();
            ByteArrayInputStream is = new ByteArrayInputStream ( fileContent );
            excelStream = is;
            excelFileName = "厂内刃磨记录查询表.xls";
            excelFileName = new String ( excelFileName.getBytes ( "gb2312" ), "iso8859-1" );
            is.close ();
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B03S001.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B03S001", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        } catch (IOException e) {
            System.out.println ( "写入流异常" );
        }
        return "exportExcels";

    }

    private String toolConsumetype;
    private String dateStar;
    private String dateEnd;
    private String systeCode;
    private String grindingStatus;
    private String operator;
    private String excelFileName;
    private InputStream excelStream;
    private String grindingCode;

    public String getGrindingCode() {
        return grindingCode;
    }

    public void setGrindingCode(String grindingCode) {
        this.grindingCode = grindingCode;
    }

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

    public String getGrindingStatus() {
        return grindingStatus;
    }

    public void setGrindingStatus(String grindingStatus) {
        this.grindingStatus = grindingStatus;
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
}
