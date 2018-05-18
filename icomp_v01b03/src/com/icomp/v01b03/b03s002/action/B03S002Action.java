package com.icomp.v01b03.b03s002.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Merchants;
import com.icomp.entity.base.Outsidefactory;
import com.icomp.v01b03.b03s002.business.B03S002Business;

import org.apache.cxf.common.util.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 修复通知单查询Action
 *
 * @author Taoyy
 * @ClassName: B03S002Action
 * @date 2014-8-12 下午04:13:27
 */
public class B03S002Action extends IcompAction {
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    private static final long serialVersionUID = 1L;
    private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateFormat excelNameFormatter = new SimpleDateFormat("yyyyMMdd");
    /**
     * 修复通知单查询Business
     */
    private B03S002Business b03s002Business;

    public void setB03s002Business(B03S002Business b03s002Business) {
        this.b03s002Business = b03s002Business;
    }

    /**
     * 页面初始化
     *
     * @return String
     * @title initb03S002
     */
    public String initb03S002() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            if ("list".equals ( param.get ( "opt" ) )) {
                //  修复通知单查询列表
                Map<String, Object> list = this.b03s002Business.getList ( param, langCode, langValue, 1 );
                super.ajaxReturn ( list );
                return null;
            } else {

                // 初始化页面下拉列表默认值
                super.assign ( "Merchants", "" );
                //取得下拉列表列表
                Map<String, Object> list = this.b03s002Business.getPageSelList ( langCode, langValue );
                super.assign ( "MerchantsesList", list.get ( "merchantsesList" ) );
                // 取得页面grid显示项目列表
                super.session ( "gridcol", b03s002Business.getGridColmun ( "B03S002", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
                return SUCCESS;
            }
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B03S002.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B03S002", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 新建厂外通知单
     *
     * @return String
     * @title initb03S002
     */
    public String outFactoryAdd() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            // 参数
            Map<String, Object> param = super.param ();
            if ("add".equals ( param.get ( "opt" ) )) {
                //  修复通知单查询列表
                Map<String, Object> list = this.b03s002Business.outFactoryAdd ( param, langCode, langValue );
                super.ajaxReturn ( list );
                return null;
            }
            // 取得页面grid显示项目列表
            super.session ( "gridcol", b03s002Business.getGridColmun ( "B03S002", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B03S002.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B03S002", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    //	显示编辑Div内容
    public String outInfo() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();
            //			查询待编辑内容
            Map<String, Object> ret = this.b03s002Business.outInfo ( param, langCode, langValue );
            super.ajaxReturn ( ret );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/userInfo.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userInfo", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }

    }

    public String outFactoryEdit() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();
            //			查询待编辑内容
            Map<String, Object> list = this.b03s002Business.outFactoryEdit ( param, langCode, langValue, ((Customer) super.session ( "Customer" )).getCustomerID () );
            super.ajaxReturn ( list );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/userInfo.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userInfo", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }

    }

    //	excel下载

    public String exportExcel() {
        Map<String, Object> param = new HashMap<String, Object> ();

        param.put ( "noticeNo", noticeNo );
        param.put ( "dateStar", dateStar );
        param.put ( "dateEnd", dateEnd );
        param.put ( "outstatus", outstatus );
        param.put ( "grindingName", grindingName );
        param.put ( "operator", operator );
        param.put ( "numberGrinding", numberGrinding );

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

            cells.setCellValue ( "通知单号" );
            cells = rows.createCell ( 1 );
            if ("".equals ( noticeNo )) {
                cells.setCellValue ( "-" );
            } else {
                cells.setCellValue ( noticeNo );
            }
            cells = rows.createCell ( 2 );
            cells.setCellValue ( "状态" );
            cells = rows.createCell ( 3 );
            if ("".equals ( outstatus )) {
                cells.setCellValue ( "-" );
            } else if (IConstant.STRING_0.equals ( outstatus )) {
                cells.setCellValue ( "待出厂" );
            } else if (IConstant.STRING_1.equals ( outstatus )) {
                cells.setCellValue ( "已出厂" );
            } else {
                cells.setCellValue ( "已送回" );
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
            cells.setCellValue ( "修磨厂家名称" );
            cells = rows.createCell ( 7 );
            if ("".equals ( grindingName )) {
                cells.setCellValue ( "-" );
            } else {
                Map<String, Object> list = this.b03s002Business.getPageSelList ( "", "" );
                List<Merchants> mesList = (List<Merchants>) list.get ( "merchantsesList" );
                for (Merchants meus : mesList) {
                    if (grindingName.equals ( meus.getMerchantsID () )) {
                        cells.setCellValue ( meus.getMerchantsName () );
                        break;
                    } else {
                        cells.setCellValue ( "-" );

                    }
                }
            }
            cells = rows.createCell ( 8 );
            cells.setCellValue ( "经办人" );
            cells = rows.createCell ( 9 );
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
            cell.setCellValue ( "通知单号" );//写入内容
            cell.setCellStyle ( style );

            cell = row.createCell ( 1 );//同上
            cell.setCellValue ( "材料号" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 2 );//同上
            cell.setCellValue ( "状态" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 3 );
            cell.setCellValue ( "修磨厂家名称(或编码)" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 4 );
            cell.setCellValue ( "修磨数量" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 5 );
            cell.setCellValue ( "时间" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 6 );
            cell.setCellValue ( "经办人" );
            cell.setCellStyle ( style );

            cell = row.createCell ( 7 );
            cell.setCellValue ( "详细/备注" );
            cell.setCellStyle ( style );

            Map<String, Object> list = new HashMap<String, Object> ();
            try {
                list = this.b03s002Business.getList ( param, "", "", 2 );
                if (list == null && list.size () < 0) {
                    list = new HashMap<String, Object> ();
                }
            } catch (Exception e1) {
                System.out.println ( "ecxel导出异常" );
            }

            List<Outsidefactory> outslist = (List<Outsidefactory>) list.get ( "rows" );
            if (outslist == null) {
                outslist = new ArrayList<Outsidefactory> ();
            }

            //循环,将下面几行的数据取出来放入这个sheet中
            for (int i = 0; i < outslist.size (); i++) {
                Outsidefactory outsidefactory = outslist.get ( i );
                row = sheet.createRow ( i + 4 );
                //row.createCell(0).setCellValue("");
                cell = row.createCell ( 0 );//通知单号
                if ("".equals ( outsidefactory.getOrderNum () ) || outsidefactory.getOrderNum () == null) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( outsidefactory.getOrderNum () );
                }
                cell = row.createCell ( 1 );//材料号
                if ("".equals ( outsidefactory.getMaterialNum () ) || outsidefactory.getMaterialNum () == null) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( outsidefactory.getMaterialNum () );
                }
                cell = row.createCell ( 2 );//状态
                if (IConstant.STRING_0.equals ( outsidefactory.getRepairState () )) {
                    cell.setCellValue ( "待出厂" );
                } else if (IConstant.STRING_1.equals ( outsidefactory.getRepairState () )) {
                    cell.setCellValue ( "已出厂" );
                } else {
                    cell.setCellValue ( "已送回" );
                }

                cell = row.createCell ( 3 );//修磨厂家名称(或编码)
                if ("".equals ( outsidefactory.getMerchantsID () ) || outsidefactory.getMerchantsID () == null) {
                    cell.setCellValue ( "-" );
                } else {

                    cell.setCellValue ( outsidefactory.getMerchantsID () );
                }
                cell = row.createCell ( 4 );//修磨数量
                if ("".equals ( outsidefactory.getNumberGrinding () ) || outsidefactory.getNumberGrinding () == null) {
                    cell.setCellValue ( IConstant.STRING_0 );
                } else {
                    cell.setCellValue ( String.valueOf ( outsidefactory.getNumberGrinding () ) );
                }

                cell = row.createCell ( 5 );//时间
                if ("".equals ( outsidefactory.getManufactureDate () ) || outsidefactory.getManufactureDate () == null) {
                    cell.setCellValue ( new Date () );
                } else {
                    cell.setCellValue ( Ctl.dateFormat ( outsidefactory.getManufactureDate (), "yyyy-MM-dd" ) );
                }

                cell = row.createCell ( 6 );//经办人
                if ("".equals ( outsidefactory.getApprover () ) || outsidefactory.getApprover () == null) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( outsidefactory.getApprover () );
                }

                cell = row.createCell ( 7 );//详情
                if ("".equals ( outsidefactory.getNote () ) || outsidefactory.getNote () == null) {
                    cell.setCellValue ( "-" );
                } else {
                    cell.setCellValue ( outsidefactory.getNote () );
                }


            }
            ByteArrayOutputStream os = new ByteArrayOutputStream ();

            wb.write ( os );
            os.close ();
            byte[] fileContent = os.toByteArray ();
            ByteArrayInputStream is = new ByteArrayInputStream ( fileContent );
            excelStream = is;
            excelFileName = "厂外修磨通知查询表.xls";
            excelFileName = new String ( excelFileName.getBytes ( "gb2312" ), "iso8859-1" );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B03S002.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B03S002", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        } catch (IOException e) {
            System.out.println ( "写入流异常" );
        }
        return "exportExcels";

    }
    
    //	excel下载打印版

    public String exportExcelPrint() {
        Map<String, Object> param = new HashMap<String, Object> ();

        param.put ( "noticeNo", noticeNo );
        param.put ( "dateStar", dateStar );
        param.put ( "dateEnd", dateEnd );
        param.put ( "outstatus", outstatus );
        param.put ( "grindingName", grindingName );
        param.put ( "operator", operator );
        param.put ( "numberGrinding", numberGrinding );

        String globalFont = "宋体";//字体如果改变，sheet的ColumnWidth需要跟着调整
        try {
            HSSFWorkbook wb = new HSSFWorkbook ();//创建一个工作间
            HSSFSheet sheet = wb.createSheet ( "物资出门单" );//创建一个sheet
            sheet.setDisplayGridlines(false);
            sheet.setColumnWidth(0, 3000);
            sheet.setColumnWidth(1, 6550);
            sheet.setColumnWidth(2, 6550);
            sheet.setColumnWidth(3, 4050);
            sheet.setColumnWidth(4, 3200);
            sheet.addMergedRegion ( new CellRangeAddress ( 0, 0, 0, 4 ) );//合并前5列
            
            //前八行每一行都有自己单独的样式，防止以后修改
            //第一行
            HSSFCellStyle tittleStyle = wb.createCellStyle ();//标题样式
            HSSFFont font = wb.createFont();
            
            font.setFontName(globalFont);
            font.setBold(true);
            font.setFontHeightInPoints((short) 18);//设置字体大小
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            tittleStyle.setFont(font);
            tittleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
            tittleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            HSSFRow rowss = sheet.createRow ( 0 );//创建第一行
            rowss.setHeight((short)600);
            HSSFCell cellss = rowss.createCell ( 0 );
            cellss.setCellValue ( "物资出门单" );
            cellss.setCellStyle ( tittleStyle );
            
            //第二行
            sheet.addMergedRegion ( new CellRangeAddress ( 1, 1, 0, 4 ) );//合并前5列
            HSSFCellStyle style2th = wb.createCellStyle ();//第二行样式
            HSSFFont font2th = wb.createFont();
            
            font2th.setFontName(globalFont);
            font2th.setFontHeightInPoints((short) 12);//设置字体大小
            style2th.setFont(font2th);
            style2th.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平左对齐
            style2th.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            style2th.setBorderBottom(CellStyle.BORDER_HAIR);
            style2th.setWrapText(true);
            HSSFRow rows2 = sheet.createRow ( 1 );//创建第2行
            rows2.setHeight((short)600);
            HSSFCell cell20 = rows2.createCell ( 0 );
			StringBuilder grindingBuilder = new StringBuilder("物资运往单位：");
			if (!StringUtils.isEmpty(grindingName)) {
				Map<String, Object> list = this.b03s002Business.getPageSelList("", "");
				List<Merchants> mesList = (List<Merchants>) list.get("merchantsesList");
				for (Merchants meus : mesList) {
					if (grindingName.equals(meus.getMerchantsID())) {
						if (meus.getMerchantsName() != null) {
							grindingBuilder.append(meus.getMerchantsName());
						}
						break;
					}
				}
			}

			cell20.setCellValue(grindingBuilder.toString());
			cell20.setCellStyle(style2th);
			HSSFCell cell21 = rows2.createCell(1);
			cell21.setCellStyle(style2th);
			HSSFCell cell22 = rows2.createCell(2);
			cell22.setCellStyle(style2th);
			HSSFCell cell23 = rows2.createCell(3);
			cell23.setCellStyle(style2th);
			HSSFCell cell24 = rows2.createCell(4);
			cell24.setCellStyle(style2th);

			// 第三行
            sheet.addMergedRegion ( new CellRangeAddress ( 2, 2, 0, 4 ) );//合并前5列
            HSSFCellStyle style3th = wb.createCellStyle ();//第三行样式
            HSSFFont font3th = wb.createFont();
            
            font3th.setFontName(globalFont);
            font3th.setFontHeightInPoints((short) 12);//设置字体大小
            style3th.setFont(font3th);
            style3th.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平左对齐
            style3th.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            //thirdStyle.setBorderBottom(CellStyle.BORDER_DASHED);
            style3th.setBorderBottom(CellStyle.BORDER_HAIR);
            HSSFRow rows3 = sheet.createRow ( 2 );//创建第3行
            rows3.setHeight((short)600);
            HSSFCell cell30 = rows3.createCell ( 0 );
            cell30.setCellValue ( "出门时间："+formatter.format(new Date()));
            cell30.setCellStyle ( style3th );
            HSSFCell cell31 = rows3.createCell ( 1 );
            cell31.setCellStyle ( style3th );
            HSSFCell cell32 = rows3.createCell ( 2 );
            cell32.setCellStyle ( style3th );
            HSSFCell cell33 = rows3.createCell ( 3 );
            cell33.setCellStyle ( style3th );
            HSSFCell cell34 = rows3.createCell ( 4 );
            cell34.setCellStyle ( style3th );
            
            //第四行
            sheet.addMergedRegion ( new CellRangeAddress ( 3, 3, 0, 4 ) );//合并前5列
            HSSFCellStyle style4th = wb.createCellStyle ();//第四行样式
            HSSFFont font4th = wb.createFont();
            
            font4th.setFontName(globalFont);
            font4th.setFontHeightInPoints((short) 12);//设置字体大小
            style4th.setFont(font4th);
            style4th.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平左对齐
            style4th.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            style4th.setBorderBottom(CellStyle.BORDER_HAIR);
            HSSFRow rows4 = sheet.createRow ( 3 );//创建第4行
            rows4.setHeight((short)600);
            
            HSSFCell cell40 = rows4.createCell ( 0 );
            cell40.setCellValue ("出厂门：227号门");
            cell40.setCellStyle ( style4th );
            HSSFCell cell41 = rows4.createCell ( 1 );
            cell41.setCellStyle ( style4th );
            HSSFCell cell42 = rows4.createCell ( 2 );
            cell42.setCellStyle ( style4th );
            HSSFCell cell43 = rows4.createCell ( 3 );
            cell43.setCellStyle ( style4th );
            HSSFCell cell44 = rows4.createCell ( 4 );
            cell44.setCellStyle ( style4th );
            
            //第五行
            sheet.addMergedRegion ( new CellRangeAddress ( 4, 4, 0, 4 ) );//合并前5列
            HSSFCellStyle style5th = wb.createCellStyle ();
            HSSFFont font5th = wb.createFont();
            
            font5th.setFontName(globalFont);
            font5th.setFontHeightInPoints((short) 12);//设置字体大小
            style5th.setFont(font5th);
            style5th.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平左对齐
            style5th.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            style5th.setBorderBottom(CellStyle.BORDER_HAIR);
            HSSFRow rows5 = sheet.createRow ( 4 );//创建第5行
            rows5.setHeight((short)600);
            
            HSSFCell cell50 = rows5.createCell ( 0 );
            StringBuilder outReasonBuilder = new StringBuilder("出门原因：");
			if (!StringUtils.isEmpty(outReason)) {
				outReasonBuilder.append(outReason);
			}
            cell50.setCellValue (outReasonBuilder.toString());
            cell50.setCellStyle ( style5th );
            HSSFCell cell51 = rows5.createCell ( 1 );
            cell51.setCellStyle ( style5th );
            HSSFCell cell52 = rows5.createCell ( 2 );
            cell52.setCellStyle ( style5th );
            HSSFCell cell53 = rows5.createCell ( 3 );
            cell53.setCellStyle ( style5th );
            HSSFCell cell54 = rows5.createCell ( 4 );
            cell54.setCellStyle ( style5th );
            
            //第六行
            sheet.addMergedRegion ( new CellRangeAddress ( 5, 5, 0, 4 ) );//合并前5列
            HSSFCellStyle style6th = wb.createCellStyle ();
            HSSFFont font6th = wb.createFont();
            
            font6th.setFontName(globalFont);
            font6th.setFontHeightInPoints((short) 12);//设置字体大小
            style6th.setFont(font6th);
            style6th.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平左对齐
            style6th.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            style6th.setBorderBottom(CellStyle.BORDER_HAIR);
            HSSFRow rows6 = sheet.createRow ( 5 );//创建第6行
            rows6.setHeight((short)600);
            
            HSSFCell cell60 = rows6.createCell ( 0 );
            cell60.setCellValue ("车牌号：吉A");
            cell60.setCellStyle ( style6th );
            HSSFCell cell61 = rows6.createCell ( 1 );
            cell61.setCellStyle ( style6th );
            HSSFCell cell62 = rows6.createCell ( 2 );
            cell62.setCellStyle ( style6th );
            HSSFCell cell63 = rows6.createCell ( 3 );
            cell63.setCellStyle ( style6th );
            HSSFCell cell64 = rows6.createCell ( 4 );
            cell64.setCellStyle ( style6th );
            
            //第七行空行
			HSSFCellStyle divisionStyle = wb.createCellStyle();//分割行样式
			HSSFFont divisionFont = wb.createFont();

			divisionFont.setFontName(globalFont);
			divisionFont.setFontHeightInPoints((short) 12);// 设置字体大小
			divisionStyle.setFont(divisionFont);
			divisionStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平左对齐
			divisionStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中

			HSSFRow rows7 = sheet.createRow(6);// 创建第7行
			rows7.setHeight((short) 300);

			HSSFCell cell70 = rows7.createCell(0);
			cell70.setCellStyle(divisionStyle);
			HSSFCell cell71 = rows7.createCell(1);
			cell71.setCellStyle(divisionStyle);
			HSSFCell cell72 = rows7.createCell(2);
			cell72.setCellStyle(divisionStyle);
			HSSFCell cell73 = rows7.createCell(3);
			cell73.setCellStyle(divisionStyle);
			HSSFCell cell74 = rows7.createCell(4);
			cell74.setCellStyle(divisionStyle);         
            
            //table
            //第八行表头
            //headerFirstStyle表头第一格样式
            HSSFCellStyle headerFirstStyle = wb.createCellStyle ();
            HSSFFont headerFirstFont = wb.createFont();
            
            headerFirstFont.setFontName(globalFont);
            headerFirstFont.setFontHeightInPoints((short) 12);//设置字体大小
            headerFirstStyle.setFont(headerFirstFont);
            headerFirstStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
            headerFirstStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            headerFirstStyle.setBorderLeft(CellStyle.BORDER_THICK);
            headerFirstStyle.setBorderBottom(CellStyle.BORDER_HAIR);
            headerFirstStyle.setBorderRight(CellStyle.BORDER_HAIR);
            headerFirstStyle.setBorderTop(CellStyle.BORDER_DOUBLE);
            
            //表头中间格样式
			HSSFCellStyle style8th = wb.createCellStyle();
            HSSFFont font8th = wb.createFont();
            
            font8th.setFontName(globalFont);
            font8th.setFontHeightInPoints((short) 12);//设置字体大小
            style8th.setFont(font8th);
            style8th.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
            style8th.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            style8th.setBorderTop(CellStyle.BORDER_DOUBLE);
            style8th.setBorderBottom(CellStyle.BORDER_HAIR);
            style8th.setBorderLeft(CellStyle.BORDER_HAIR);
            style8th.setBorderRight(CellStyle.BORDER_HAIR);
            
            //headerFirstStyle表头最后一格样式
			HSSFCellStyle headerLastStyle = wb.createCellStyle();
            HSSFFont headerLastFont = wb.createFont();
            
            headerLastFont.setFontName(globalFont);
            headerLastFont.setFontHeightInPoints((short) 12);//设置字体大小
            headerLastStyle.setFont(headerLastFont);
            headerLastStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
            headerLastStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            headerLastStyle.setBorderLeft(CellStyle.BORDER_HAIR);
            headerLastStyle.setBorderBottom(CellStyle.BORDER_HAIR);
            headerLastStyle.setBorderRight(CellStyle.BORDER_DOUBLE);
            headerLastStyle.setBorderTop(CellStyle.BORDER_DOUBLE);
            
			HSSFRow rows8 = sheet.createRow(7);// 创建第8行
			rows8.setHeight((short) 400);

			HSSFCell cell80 = rows8.createCell(0);
			cell80.setCellValue("序号");
			cell80.setCellStyle(headerFirstStyle);
			HSSFCell cell81 = rows8.createCell(1);
			cell81.setCellValue("名称");
			cell81.setCellStyle(style8th);
			HSSFCell cell82 = rows8.createCell(2);
			cell82.setCellValue("型号");
			cell82.setCellStyle(style8th);
			HSSFCell cell83 = rows8.createCell(3);
			cell83.setCellValue("数量 （件）");
			cell83.setCellStyle(style8th);
			HSSFCell cell84 = rows8.createCell(4);
			cell84.setCellValue("备注");
			cell84.setCellStyle(headerLastStyle);
            
            //data
            //firstDataStyle第一列数据样式
            HSSFCellStyle firstDataStyle = wb.createCellStyle ();
            HSSFFont firstDataFont = wb.createFont();
            
            firstDataFont.setFontName(globalFont);
            firstDataFont.setFontHeightInPoints((short) 12);//设置字体大小
            firstDataStyle.setFont(firstDataFont);
            firstDataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
            firstDataStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            firstDataStyle.setBorderLeft(CellStyle.BORDER_THICK);
            firstDataStyle.setBorderBottom(CellStyle.BORDER_HAIR);
            firstDataStyle.setBorderRight(CellStyle.BORDER_HAIR);
            firstDataStyle.setBorderTop(CellStyle.BORDER_HAIR);
            
           //middleDataStyle中间数据样式
            HSSFCellStyle middleDataStyle = wb.createCellStyle ();
            HSSFFont middleDataFont = wb.createFont();
            
            middleDataFont.setFontName(globalFont);
            middleDataFont.setFontHeightInPoints((short) 12);//设置字体大小
            middleDataStyle.setFont(middleDataFont);
            middleDataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
            middleDataStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            middleDataStyle.setBorderLeft(CellStyle.BORDER_HAIR);
            middleDataStyle.setBorderBottom(CellStyle.BORDER_HAIR);
            middleDataStyle.setBorderRight(CellStyle.BORDER_HAIR);
            middleDataStyle.setBorderTop(CellStyle.BORDER_HAIR);
            
            //lastDataStyle最后一列数据样式
            HSSFCellStyle lastDataStyle = wb.createCellStyle ();
            HSSFFont lastDataFont = wb.createFont();
            
			lastDataFont.setFontName(globalFont);
			lastDataFont.setFontHeightInPoints((short) 12);// 设置字体大小
			lastDataStyle.setFont(lastDataFont);
			lastDataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
			lastDataStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			lastDataStyle.setBorderLeft(CellStyle.BORDER_HAIR);
			lastDataStyle.setBorderBottom(CellStyle.BORDER_HAIR);
			lastDataStyle.setBorderRight(CellStyle.BORDER_DOUBLE);
			lastDataStyle.setBorderTop(CellStyle.BORDER_HAIR);
            
            //获取数据
            Map<String, Object> dataMap = null;
            try {
            	dataMap = this.b03s002Business.getList ( param, "", "", 2 );
            } catch (Exception e1) {
                System.out.println ( "ecxel导出异常" );
            }
            List<Outsidefactory> outList = null;
			if (dataMap != null && dataMap.size() > 0) {
				outList = (List<Outsidefactory>) dataMap.get ( "rows" );

			}
            if (outList == null) {
            	outList = new ArrayList<Outsidefactory> ();
            }
            
            //开始创建数据表格
			int startRowN = 8;
			for (int i = 0; i < outList.size(); i++) {
				Outsidefactory outsidefactory = outList.get(i);
				HSSFRow dataRow = sheet.createRow(startRowN + i);// 创建数据行
				dataRow.setHeight((short) 400);
				HSSFCell cell0 = dataRow.createCell(0);
				cell0.setCellValue(i + 1);
				cell0.setCellStyle(firstDataStyle);
				
				HSSFCell cell1 = dataRow.createCell(1);
				
				if (!StringUtils.isEmpty(outsidefactory.getToolName())) {
					cell1.setCellValue(outsidefactory.getToolName());
				}
				cell1.setCellStyle(middleDataStyle);
				
				HSSFCell cell2 = dataRow.createCell(2);
				if (!StringUtils.isEmpty(outsidefactory.getMaterialNum())) {
					cell2.setCellValue(outsidefactory.getMaterialNum());
				}
				cell2.setCellStyle(middleDataStyle);
				
				HSSFCell cell3 = dataRow.createCell(3);
				
				if (!StringUtils.isEmpty(outsidefactory.getNumberGrinding())) {
					cell3.setCellValue(outsidefactory.getNumberGrinding());
				}
				cell3.setCellStyle(middleDataStyle);
				
				HSSFCell cell4 = dataRow.createCell(4);
				cell4.setCellStyle(lastDataStyle);
			}
			//计算数据填充完毕时的起始行数
			int dataEndRow = startRowN + outList.size();
			
            //数据表内追加空行
            //firstBlankStyle空行第一列数据样式
            HSSFCellStyle firstBlankStyle = wb.createCellStyle ();
            HSSFFont firstBlankFont = wb.createFont();
            
            firstBlankFont.setFontName(globalFont);
            firstBlankFont.setFontHeightInPoints((short) 12);//设置字体大小
            firstBlankStyle.setFont(firstBlankFont);
            firstBlankStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
            firstBlankStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            firstBlankStyle.setBorderLeft(CellStyle.BORDER_THICK);
            firstBlankStyle.setBorderBottom(CellStyle.BORDER_DOUBLE);
            firstBlankStyle.setBorderRight(CellStyle.BORDER_HAIR);
            firstBlankStyle.setBorderTop(CellStyle.BORDER_HAIR);
            
           //middleBlankStyle空行中间样式
            HSSFCellStyle middleBlankStyle = wb.createCellStyle ();
            HSSFFont middleBlankFont = wb.createFont();
            
            middleBlankFont.setFontName(globalFont);
            middleBlankFont.setFontHeightInPoints((short) 12);//设置字体大小
            middleBlankStyle.setFont(middleBlankFont);
            middleBlankStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
            middleBlankStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            middleBlankStyle.setBorderLeft(CellStyle.BORDER_HAIR);
            middleBlankStyle.setBorderBottom(CellStyle.BORDER_DOUBLE);
            middleBlankStyle.setBorderRight(CellStyle.BORDER_HAIR);
            middleBlankStyle.setBorderTop(CellStyle.BORDER_HAIR);
            
            //lastBlankStyle空行最后一列数据样式
            HSSFCellStyle lastBlankStyle = wb.createCellStyle ();
            HSSFFont lastBlankFont = wb.createFont();
            
            lastBlankFont.setFontName(globalFont);
            lastBlankFont.setFontHeightInPoints((short) 12);// 设置字体大小
			lastBlankStyle.setFont(lastBlankFont);
			lastBlankStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
			lastBlankStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			lastBlankStyle.setBorderLeft(CellStyle.BORDER_HAIR);
			lastBlankStyle.setBorderBottom(CellStyle.BORDER_DOUBLE);
			lastBlankStyle.setBorderRight(CellStyle.BORDER_DOUBLE);
			lastBlankStyle.setBorderTop(CellStyle.BORDER_HAIR);
			
			HSSFRow blankRow = sheet.createRow(dataEndRow);// 创建空行
			blankRow.setHeight((short) 400);
			HSSFCell cell0 = blankRow.createCell(0);
			cell0.setCellStyle(firstBlankStyle);
			
			HSSFCell cell1 = blankRow.createCell(1);
			cell1.setCellStyle(middleBlankStyle);
			
			HSSFCell cell2 = blankRow.createCell(2);
			cell2.setCellStyle(middleBlankStyle);
			
			HSSFCell cell3 = blankRow.createCell(3);
			cell3.setCellStyle(middleBlankStyle);
			
			HSSFCell cell4 = blankRow.createCell(4);
			cell4.setCellStyle(lastBlankStyle);
			
			//数据表结束的分割行
			HSSFRow divisionRow = sheet.createRow(dataEndRow + 1);// 创建空行
			divisionRow.setHeight((short) 200);
			
			HSSFCell dCell0 = divisionRow.createCell(0);
			dCell0.setCellStyle(divisionStyle);
			
			HSSFCell dCell1 = divisionRow.createCell(1);
			dCell1.setCellStyle(divisionStyle);
			
			HSSFCell dCell2 = divisionRow.createCell(2);
			dCell2.setCellStyle(divisionStyle);
			
			HSSFCell dCell3 = divisionRow.createCell(3);
			dCell3.setCellStyle(divisionStyle);
			
			HSSFCell dCell4 = divisionRow.createCell(4);
			dCell4.setCellStyle(divisionStyle);
            
            //末尾落款信息
			int infoStartRowN = dataEndRow + 2;
			
            //经办人、审核人行
			sheet.addMergedRegion(new CellRangeAddress(infoStartRowN, infoStartRowN, 2, 3));// 审核人合并2,3
			HSSFCellStyle auditStyle = wb.createCellStyle();
			HSSFFont auditFont = wb.createFont();

			auditFont.setFontName(globalFont);
			auditFont.setFontHeightInPoints((short) 12);// 设置字体大小
			auditStyle.setFont(auditFont);
			auditStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平左对齐
			auditStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			
			HSSFCellStyle auditCenterStyle = wb.createCellStyle();
			HSSFFont auditCenterFont = wb.createFont();

			auditCenterFont.setFontName(globalFont);
			auditCenterFont.setFontHeightInPoints((short) 12);// 设置字体大小
			auditCenterStyle.setFont(auditCenterFont);
			auditCenterStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平左对齐
			auditCenterStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			
			HSSFRow auditRow = sheet.createRow(infoStartRowN);
			auditRow.setHeight((short) 450);
			
			HSSFCell aCell0 = auditRow.createCell(0);
			aCell0.setCellValue("经办人：");
			aCell0.setCellStyle(auditStyle);
			HSSFCell aCell1 = auditRow.createCell(1);
			aCell1.setCellStyle(auditStyle);
			
			HSSFCell aCell2 = auditRow.createCell(2);
			aCell2.setCellValue("审核人：");
			aCell2.setCellStyle(auditCenterStyle);
			HSSFCell aCell3 = auditRow.createCell(3);
			aCell3.setCellStyle(auditStyle);
			
			HSSFRow checkRow = sheet.createRow(infoStartRowN + 1);
			checkRow.setHeight((short) 450);

			HSSFCell cCell0 = checkRow.createCell(0);
			cCell0.setCellValue("维修物资返回后验证人：");
			cCell0.setCellStyle(auditStyle);
			HSSFCell cCell1 = checkRow.createCell(1);
			cCell1.setCellStyle(auditStyle);
			HSSFCell cCell2 = checkRow.createCell(2);
			cCell2.setCellStyle(auditCenterStyle);
			HSSFCell cCell3 = checkRow.createCell(3);
			cCell3.setCellStyle(auditStyle);
			HSSFCell cCell4 = checkRow.createCell(4);
			cCell4.setCellStyle(auditStyle);
			
			//备注行
			sheet.addMergedRegion(new CellRangeAddress(infoStartRowN + 2, infoStartRowN + 3, 0, 4));
			HSSFRow noteRow = sheet.createRow(infoStartRowN + 2);
			noteRow.setHeight((short) 650);

			HSSFCell nCell0 = noteRow.createCell(0);
			nCell0.setCellValue("备注：凡是外委维修的物资返回后需要在出门单上签字进行消账。");
			nCell0.setCellStyle(auditStyle);
			
			//出门证编号
			HSSFCellStyle outNumberStyle = wb.createCellStyle();
			HSSFFont outNumberFont = wb.createFont();

			outNumberFont.setFontName(globalFont);
			outNumberFont.setFontHeightInPoints((short) 12);// 设置字体大小
			outNumberStyle.setFont(outNumberFont);
			outNumberStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
			outNumberStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);// 垂直底部对齐
			HSSFRow outNumberRow = sheet.createRow(infoStartRowN + 4);
			outNumberRow.setHeight((short) 450);

			HSSFCell oCell0 = outNumberRow.createCell(2);
			oCell0.setCellValue("出门证编号：");
			oCell0.setCellStyle(outNumberStyle);			
			
            ByteArrayOutputStream os = new ByteArrayOutputStream ();
            wb.write ( os );
            os.close ();
            byte[] fileContent = os.toByteArray ();
            ByteArrayInputStream is = new ByteArrayInputStream ( fileContent );
            excelStream = is;
            StringBuilder fileNameBuilder = new StringBuilder("物资出门申请单");
            fileNameBuilder.append(excelNameFormatter.format(new Date())).append(".xls");
            excelFileName = fileNameBuilder.toString();
            excelFileName = new String ( excelFileName.getBytes ( "gb2312" ), "iso8859-1" );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B03S002.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B03S002", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        } catch (IOException e) {
            System.out.println ( "写入流异常" );
        }
        return "exportExcels";

    }

    private String noticeNo;
    private String dateStar;
    private String dateEnd;
    private String outstatus;
    private String grindingName;
    private String operator;
    private String numberGrinding;
    private String materialNum;
    private String outReason;

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

    public String getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
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

    public String getOutstatus() {
        return outstatus;
    }

    public void setOutstatus(String outstatus) {
        this.outstatus = outstatus;
    }

    public String getGrindingName() {
        return grindingName;
    }

    public void setGrindingName(String grindingName) {
        this.grindingName = grindingName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNumberGrinding() {
        return numberGrinding;
    }

    public void setNumberGrinding(String numberGrinding) {
        this.numberGrinding = numberGrinding;
    }

    public String getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(String materialNum) {
        this.materialNum = materialNum;
    }

	public String getOutReason() {
		return outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}
}
