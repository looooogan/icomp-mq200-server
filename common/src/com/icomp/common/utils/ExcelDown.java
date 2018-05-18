package com.icomp.common.utils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.sap.SAPTools;
import com.icomp.entity.base.Werkzeugeanforderun;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelDown {
    /**
     * //	 * POI:解析Excel文件中的数据并把每行数据封装成一个实体
     * //	 * @param fis 文件输入流
     * //	 * @return List<EmployeeInfo> Excel中数据封装实体的集合
     * //
     */

    public static List<Werkzeugeanforderun> importEmployeeByPoi(InputStream fis) {

        List<Werkzeugeanforderun> infos = new ArrayList<Werkzeugeanforderun> ();
        Werkzeugeanforderun werkzeugeanforderun = null;

        try {
            //创建Excel工作薄

            XSSFWorkbook xwb = new XSSFWorkbook ( fis );

            //			//得到第一个工作表

            XSSFSheet sheet = xwb.getSheetAt ( 0 );

            XSSFRow row = null;

            //
            //			//遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
            for (int i = 0; i < xwb.getNumberOfSheets (); i++) {
                //   System.out.println ( xwb.getNumberOfSheets () );
                sheet = xwb.getSheetAt ( i );
                //				//遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数
                for (int j = 3; j <= sheet.getPhysicalNumberOfRows (); j++) {
                    row = sheet.getRow ( j );
                    werkzeugeanforderun = new Werkzeugeanforderun ();

                    //此方法调用getCellValue(HSSFCell cell)对解析出来的数据进行判断，并做相应的处理
                    //					if(ExcelDown.getCellValue(row.getCell(0)) != null && !"".equals(ExcelDown.getCellValue(row.getCell(0)))) {
                    //						werkzeugeanforderun.setWerkID(new BigDecimal(ExcelDown.getCellValue(row.getCell(0))));
                    //					}
                    if (ExcelDown.getCellValue ( row.getCell ( 0 ) ) == null || "".equals ( ExcelDown.getCellValue ( row.getCell ( 0 ) ) )) {
                        break;
                    } else {

                        String tMaterialNr = ExcelDown.getCellValue ( row.getCell ( 0 ) );
                        if (StringUtils.isEmpty ( tMaterialNr )) {
                            continue;
                        }
                        String demandCode = ExcelDown.getCellValue ( row.getCell ( 12 ) );
                        if (StringUtils.isEmpty ( demandCode )) {
                            continue;
                        }
                        werkzeugeanforderun.setDemandCode ( SAPTools.getAllOrderNO ( demandCode ) );
                        werkzeugeanforderun.setMaterialNr ( tMaterialNr );
                        werkzeugeanforderun.setBestellBezeichnung ( ExcelDown.getCellValue ( row.getCell ( 1 ) ) );
                        String mengestr = String.valueOf ( row.getCell ( 2 ) );
                        werkzeugeanforderun.setMenge ( new BigDecimal ( mengestr ) );
                        werkzeugeanforderun.setEinheit ( ExcelDown.getCellValue ( row.getCell ( 3 ) ) );
                        werkzeugeanforderun.setUnitPreis ( ExcelDown.getCellValue ( row.getCell ( 4 ) ) );
                        werkzeugeanforderun.setBetrag ( ExcelDown.getCellValue ( row.getCell ( 5 ) ) );
                        werkzeugeanforderun.setLieferant ( ExcelDown.getCellValue ( row.getCell ( 6 ) ) );
                        werkzeugeanforderun.setEinsAtzort ( ExcelDown.getCellValue ( row.getCell ( 7 ) ) );
                        werkzeugeanforderun.setLiefertermin ( ExcelDown.getCellValue ( row.getCell ( 8 ) ) );
                        werkzeugeanforderun.setSubjectCode ( ExcelDown.getCellValue ( row.getCell ( 9 ) ) );

                        String expensc = String.valueOf ( row.getCell ( 10 ) );
                        if ("0005".equals ( expensc )) {
                            werkzeugeanforderun.setExpenseCode ( ExcelDown.getCellValue ( row.getCell ( 10 ) ) );
                        } else {
                            continue;
                        }

                        if (row.getCell ( 11 ) == null) {
                            werkzeugeanforderun.setNotes ( "无" );
                        } else {
                            werkzeugeanforderun.setNotes ( ExcelDown.getCellValue ( row.getCell ( 11 ) ) );
                        }

                        String datess = String.valueOf ( getCellValue ( row.getCell ( 13 ) ) );
                        if (StringUtils.isEmpty ( datess )) {
                            continue;
                        }
                        werkzeugeanforderun.setTypingDate ( DateFormatUtil.converToDate ( datess, 0 ) );

                        werkzeugeanforderun.setDelFlag ( IConstant.DEL_FLAG_0 );
                        werkzeugeanforderun.setCreateUser ( "1111" );
                        werkzeugeanforderun.setCreateTime ( new Date () );
                        werkzeugeanforderun.setUpdateTime ( new Date () );
                        infos.add ( werkzeugeanforderun );
                    }
                }
                //
            }

        } catch (IOException e) {
            e.printStackTrace ();
        }

        return infos;
    }

    //判断从Excel文件中解析出来数据的格式
    private static String getCellValue(XSSFCell cell) {
        String value = null;
        //简单的查检列类型
        switch (cell.getCellType ()) {
            case XSSFCell.CELL_TYPE_STRING://字符串
                value = cell.getRichStringCellValue ().getString ();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC://数字
                if (DateUtil.isCellDateFormatted ( cell )) {
                    Date theDate = cell.getDateCellValue ();
                    DateFormat formater = new SimpleDateFormat ( "yyyy-MM-dd" );
                    value = formater.format ( theDate );
                } else {
                    value = NumberToTextConverter.toText ( cell.getNumericCellValue () );
                }
                break;
            case XSSFCell.CELL_TYPE_BLANK:
                value = "";
                break;
            case XSSFCell.CELL_TYPE_FORMULA:
                value = String.valueOf ( cell.getCellFormula () );
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN://boolean型值
                value = String.valueOf ( cell.getBooleanCellValue () );
                break;
            case XSSFCell.CELL_TYPE_ERROR:
                value = String.valueOf ( cell.getErrorCellValue () );
                break;
            default:
                break;
        }
        return value;
    }

    //
    //	public String getNewFileName()
    //	{
    //		Date date=new Date();
    //		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
    //		return sd.format(date);
    //	}
    //	public void reloadFileData(){
    //		this.file = null;
    //		this.fileFileName = null;
    //		this.fileContentType = null;
    //	}

    /**
     * 路径分隔符替换
     *
     * @param classPath ("\\", "/")
     * @return boolean
     */
    public static String replacePath(String classPath) {
        String rootPath = "";
        String reVal = "";
        try {
            // linux下
            if ("/".equals ( File.separator )) {
                classPath = classPath.replace ( "\\", "/" );
            }
            rootPath = classPath.substring ( 0, classPath.indexOf ( "/WEB-INF/classes" ) );
            String[] strings = rootPath.split ( "/" );
            reVal = rootPath.split ( strings[strings.length - 1] )[0];
        } catch (Exception e) {
            return "";
        }
        return reVal;
    }
}
