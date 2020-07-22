package com.genetech.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Author: Dreamer-1
 * Date: 2019-03-01
 * Time: 10:21
 * Description: 读取Excel内容
 */
public class ExcelReaderUtil<T> {

 //   private static Logger logger = Logger.getLogger(ExcelReaderUtil.class.getName()); // 日志打印类

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * @param inputStream 读取文件的输入流
     * @param fileType 文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    public  Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }

    /**
     * 读取Excel文件内容
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public  List<T> readExcel(String fileName,Class<T> clazz) {

        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 获取Excel文件
            File excelFile = new File(fileName);
            if (!excelFile.exists()) {
               // logger.warning("指定的Excel文件不存在！");
                return null;
            }

            // 获取Excel工作簿
            inputStream = new FileInputStream(excelFile);
            workbook = getWorkbook(inputStream, fileType);
            // 读取excel中的数据
            List<T> resultDataList = parseExcel(workbook, clazz);

            return resultDataList;
        } catch (Exception e) {
            e.printStackTrace();
           // logger.warning("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                //logger.warning("关闭数据流出错！错误信息：" + e.getMessage());
                return null;
            }
        }
    }

    /**
     * 解析Excel数据
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private List parseExcel(Workbook workbook, Class clazz) throws InstantiationException, IllegalAccessException, ParseException {
        List resultDataList = new ArrayList<>();
        // 解析sheet
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            if (null == firstRow) {
                //logger.warning("解析Excel失败，在第一行没有读取到任何数据！");
            }

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();

            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (null == row) {
                    continue;
                }
                Object resultData = convertRowToData(firstRow,row,clazz);
                if (null == resultData) {
                   // logger.warning("第 " + row.getRowNum() + "行数据不合法，已忽略！");
                    continue;
                }
                resultDataList.add(resultData);
            }
        }

        return resultDataList;
    }

    /**
     * 将单元格内容转换为字符串
     * @param cell
     * @return
     */
    private Object convertCellValueToString(Cell cell) {
        if(cell==null){
            return null;
        }
        Object returnValue = null;
       switch (cell.getCellType()) {//枚举类的switch
           case NUMERIC:   //数字
               Double doubleValue = cell.getNumericCellValue();
               BigDecimal bigDecimal = new BigDecimal(doubleValue);
               returnValue = bigDecimal;
               break;
           case STRING:    //字符串
               returnValue = cell.getStringCellValue();
               break;
           case BOOLEAN:   //布尔
               Boolean booleanValue = cell.getBooleanCellValue();
               returnValue = booleanValue;
               break;
           case BLANK:     // 空值
               break;
           case FORMULA:   // 公式
               returnValue = cell.getCellFormula();
               break;
           case ERROR:     // 故障
               break;
           default:
               break;
       }
        return returnValue;
    }

    /**
     * 提取每一行中需要的数据，构造成为一个结果数据对象
     *
     * 当该行中有单元格的数据为空或不合法时，忽略该行的数据
     *
     * @param row 行数据
     * @return 解析后的行数据对象，行数据错误时返回null
     */
    private Object convertRowToData(Row firstRow, Row row,Class clazz) throws IllegalAccessException, InstantiationException, ParseException {
        Object obj = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        //System.out.print("============================="+fields.length+"ffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            fields[i].setAccessible(true);
            System.out.print(fieldName);
            for (int j = 0; j < fields.length; j++) {
                Cell cell = row.getCell(j);
                String cellName = getCellName(j,firstRow);
                if(cellName == null || cellName == ""){
                    continue;
                }
                if(cellName.equals(fieldName)){
                    Object cellContent = convertCellValueToString(cell);
                    if(cellContent == null){
                        continue;
                    }
                    //假如说，这个字段是应该是String 那无论怎样都给他塞String类型的值！防止出現有些字段應該是String卻解析出來示number
                    if(fields[i].getGenericType().toString().contains("java.lang.String")){
                        fields[i].set(obj,convertCellValueToString(cell).toString());
                        continue;
                    }
                    fields[i].set(obj,convertCellValueToString(cell));
                }
            }
        }

        return obj;
    }
    
    //根据所在列获取这一列的名称
    private String getCellName(Integer columnNum,Row firstRow){
        Cell cell = firstRow.getCell(columnNum);
        if(cell == null){
            return null;
        }
        String cellName = convertCellValueToString(cell).toString();
        return cellName;
    }

}