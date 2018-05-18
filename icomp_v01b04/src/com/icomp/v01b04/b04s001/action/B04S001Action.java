package com.icomp.v01b04.b04s001.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.DateFormatUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Synthesistoolsmachininginfo;
import com.icomp.v01b04.b04s001.business.B04S001Business;
import com.icomp.v01b04.b04s003.business.B04S003Business;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
 * 工作量查询Action
 *
 * @author Taoyy
 * @ClassName: B01S001Action
 * @date 2014-8-12 下午02:31:34
 */
public class B04S001Action extends IcompAction {

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 7255161566182210074L;
    /**
     * 工作量查询BUSINESS
     */
    private B04S001Business b04s001Business;

    public void setB04s001Business(B04S001Business b04s001Business) {
        this.b04s001Business = b04s001Business;
    }

    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * 加工量异常报警BUSINESS
     */
    private B04S003Business b04s003Business;

    public void setB04s003Business(B04S003Business b04s003Business) {
        this.b04s003Business = b04s003Business;
    }

    /**
     * 初始化工作量查询页面
     *
     * @return String
     * @title initb01S001
     */
    @SuppressWarnings("unchecked")
    public String initb04S001() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            if ("list".equals ( param.get ( "opt" ) )) {
                // 加工量异常报警
                Map<String, Object> list = this.b04s001Business.getList ( param, langCode, langValue );
                super.ajaxReturn ( list );
                return null;
            } else {
                //      total =IConstant.STRING_0;

                super.assign ( "AssemblyLineID", "" );
                super.assign ( "ProcessID", "" );
                super.assign ( "PartsID", "" );
                super.assign ( "EquipmentID", "" );
                super.assign ( "AxleID", "" );

                Map<String, Object> list = this.b04s003Business.getPageSelList ( langCode, langValue );
                super.assign ( "AssemblyLineList", list.get ( "AssemblyLineList" ) );
                super.assign ( "ProcessList", list.get ( "ProcessList" ) );
                super.assign ( "EquipmentList", list.get ( "EquipmentList" ) );
                super.assign ( "PartsList", list.get ( "PartsList" ) );
                super.assign ( "AxleLineList", list.get ( "AxleLineList" ) );
            }
            // 取得页面grid显示项目列表
            super.session ( "gridcol", b04s001Business.getGridColmun ( "B04S003", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B04S003.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B04S003", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }
    //	excel下载

    public String exportExcel() {
        Map<String, Object> param = super.param ();

        //	合成刀具编码
        String systeToolCode = (String) param.get ( "toolCode" );
        //卸下时间段
        String dateStar = (String) param.get ( "dstar" );
        String dateEnd = (String) param.get ( "dend" );
        if (StringUtils.isEmpty ( dateStar )) {
            dateStar = "";
        }
        if (StringUtils.isEmpty ( dateEnd )) {
            dateEnd = "";
        }
        //卸下原因
        String removeReason = (String) param.get ( "removeReason" );

        try {
            HSSFWorkbook wb = new HSSFWorkbook ();//创建一个工作间
            HSSFSheet sheet = wb.createSheet ( "sheet1" );//创建一个sheet
            sheet.addMergedRegion ( new CellRangeAddress ( 0, 0, 0, 11 ) );//合并单元格
            HSSFCellStyle style = wb.createCellStyle ();//居中

            HSSFRow rowss = sheet.createRow ( 0 );//创建第一行
            HSSFCell cellss = rowss.createCell ( 0 );
            cellss.setCellValue ( "检索：" );
            cellss.setCellStyle ( style );

            HSSFRow rows = sheet.createRow ( 1 );//创建第二行
            HSSFCell cells = rows.createCell ( 0 );//创建这行的第一个元素.从0开始

            cells.setCellValue ( "合成刀具编码:" );
            cells = rows.createCell ( 1 );
            if ("".equals ( systeToolCode )) {
                cells.setCellValue ( "-" );
            } else {
                cells.setCellValue ( systeToolCode );
            }
            cells = rows.createCell ( 2 );
            cells.setCellValue ( "卸下原因:" );
            cells = rows.createCell ( 3 );
            if ("".equals ( removeReason )) {
                cells.setCellValue ( "-" );
            } else if (IConstant.STRING_0.equals ( removeReason )) {
                cells.setCellValue ( "正常卸下" );
            } else if (IConstant.STRING_1.equals ( removeReason )) {
                cells.setCellValue ( "加工尺寸不满足" );
            } else if (IConstant.STRING_2.equals ( removeReason )) {
                cells.setCellValue ( "表面质量不满足" );
            } else if (IConstant.STRING_3.equals ( removeReason )) {
                cells.setCellValue ( "报废" );
            } else {
                cells.setCellValue ( "其他" );
            }
            cells = rows.createCell ( 4 );

            cells.setCellValue ( "卸下时间段:" );
            cells = rows.createCell ( 5 );
            if ("".equals ( dateStar ) && "".equals ( dateEnd )) {
                cells.setCellValue ( "-" );
            } else {
                cells.setCellValue ( dateStar + "--" + dateEnd );
            }
            HSSFRow rowsd = sheet.createRow ( 2 );//创建第三行
            HSSFCell cellsd = rowsd.createCell ( 0 );//创建这行的第一个元素.从0开始
            sheet.addMergedRegion ( new CellRangeAddress ( 2, 2, 0, 11 ) );//合并单元格
            cellsd.setCellValue ( "详细" );
            cellsd.setCellStyle ( style );

            HSSFRow row = sheet.createRow ( 3 );//创建一行
            HSSFCell cell = row.createCell ( 0 );//创建这行的第一个元素.从0开始
            cell.setCellValue ( "合成刀编码" );//写入内容
            cell.setCellStyle ( style );

            cell = row.createCell ( 1 );//同上
            cell.setCellValue ( "合成刀编号" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 2 );
            cell.setCellValue ( "加工设备" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 3 );
            cell.setCellValue ( "轴编号" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 4 );
            cell.setCellValue ( "零部件" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 5 );
            cell.setCellValue ( "安上时间" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 6 );
            cell.setCellValue ( "安上者" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 7 );
            cell.setCellValue ( "卸下时间" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 8 );
            cell.setCellValue ( "卸下者" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 9 );
            cell.setCellValue ( "卸下原因" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 10 );
            cell.setCellValue ( "额定数量" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 11 );
            cell.setCellValue ( "实际加工数量" );
            cell.setCellStyle ( style );

            Map<String, Object> list = new HashMap<String, Object> ();
            try {
                param.put ( "ecxel", "1" );
                list = this.b04s001Business.getList ( param, "", "" );
                if (list == null || list.size () < 0) {
                    list = new HashMap<String, Object> ();
                }
            } catch (Exception e1) {
                System.out.println ( "ecxel导出异常" );
            }
            List<Synthesistoolsmachininginfo> vlsList = (List<Synthesistoolsmachininginfo>) list.get ( "rows" );
            if (vlsList == null) {
                vlsList = new ArrayList<Synthesistoolsmachininginfo> ();
            }

            //循环,将下面几行的数据取出来放入这个sheet中
            for (int i = 0; i < vlsList.size (); i++) {
                Synthesistoolsmachininginfo stm = vlsList.get ( i );
                row = sheet.createRow ( i + 4 );
                //row.createCell(0).setCellValue("");
                //合成刀编码
                cell = row.createCell ( 0 );
                cell.setCellValue ( stm.getSynthesisParametersCode () );
                //合成刀编号
                cell = row.createCell ( 1 );
                if (StringUtils.isEmpty ( stm.getSynthesisParametersNumber () )) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( stm.getSynthesisParametersNumber () );
                }
                //加工设备
                cell = row.createCell ( 2 );
                if (StringUtils.isEmpty ( stm.getEquipmentName () )) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( stm.getEquipmentName () );
                }
                //轴编号
                cell = row.createCell ( 3 );
                if (StringUtils.isEmpty ( stm.getAxleName () )) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( stm.getAxleName () );
                }
                //零部件
                cell = row.createCell ( 4 );
                if (StringUtils.isEmpty ( stm.getPartsName () )) {
                    cell.setCellValue ( "-");
                } else {
                    cell.setCellValue ( stm.getPartsName () );
                }
                //安上时间
                cell = row.createCell ( 5 );
                if (StringUtils.isEmpty ( stm.getCreateTime () + "" )) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( DateFormatUtil.dateToString ( stm.getCreateTime (), 1 ) );
                }
                //安上者
                cell = row.createCell ( 6 );
                if (StringUtils.isEmpty ( stm.getCreateUser () )) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( stm.getCreateUser () );
                }
                //卸下时间
                cell = row.createCell ( 7 );
                if (StringUtils.isEmpty ( stm.getOuterTime () + "" )) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( stm.getOuterTime () );
                }
                //卸下者
                cell = row.createCell ( 8 );
                if (StringUtils.isEmpty ( stm.getOuterUser () )) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( stm.getOuterUser () );
                }
                //卸下原因
                cell = row.createCell ( 9 );
                String res = stm.getRemoveReason ();
                if (StringUtils.isEmpty ( res )) {
                    cell.setCellValue ( "-" );
                } else {
                    if (IConstant.STRING_0.equals ( res )) {
                        cell.setCellValue ( "正常卸下" );
                    } else if (IConstant.STRING_1.equals ( res )) {
                        cell.setCellValue ( "加工尺寸不满足" );
                    } else if (IConstant.STRING_2.equals ( res )) {
                        cell.setCellValue ( "表面质量不满足" );
                    } else if (IConstant.STRING_3.equals ( res )) {
                        cell.setCellValue ( "报废" );
                    } else {
                        cell.setCellValue ( "其他" );
                    }
                }
                //额定数量
                cell = row.createCell ( 10 );
                if (StringUtils.isEmpty ( stm.getToolDurable () )) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( stm.getToolDurable () );
                }
                //实际加工数量
                cell = row.createCell ( 11);
                if (StringUtils.isEmpty ( stm.getProcessAmount () + "" )) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( stm.getProcessAmount () + "" );
                }
            }
            ByteArrayOutputStream os = new ByteArrayOutputStream ();

            wb.write ( os );
            os.close ();
            byte[] fileContent = os.toByteArray ();
            ByteArrayInputStream is = new ByteArrayInputStream ( fileContent );
            excelStream = is;
            excelFileName = "换刀记录查询表.xls";
            excelFileName = new String ( excelFileName.getBytes ( "gb2312" ), "iso8859-1" );
            is.close ();
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B04S001.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B04S001", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        } catch (IOException e) {
            System.out.println ( "写入流异常" );
        }
        return "exportExcels";

    }

    private InputStream excelStream;
    private String excelFileName;

    public InputStream getExcelStream() {
        return excelStream;
    }

    public void setExcelStream(InputStream excelStream) {
        this.excelStream = excelStream;
    }

    public String getExcelFileName() {
        return excelFileName;
    }

    public void setExcelFileName(String excelFileName) {
        this.excelFileName = excelFileName;
    }
}
