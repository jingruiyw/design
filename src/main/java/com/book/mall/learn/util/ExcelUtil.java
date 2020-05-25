//package com.book.mall.thread.util;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.streaming.SXSSFCell;
//import org.apache.poi.xssf.streaming.SXSSFRow;
//import org.apache.poi.xssf.streaming.SXSSFSheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.util.CollectionUtils;
//
//import java.io.InputStream;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.Executor;
//import java.util.concurrent.Executors;
//
//import static org.apache.poi.ss.usermodel.HorizontalAlignment.*;
//
//public class ExcelUtil {
//
//    private final static String excel2003L = ".xls";
//
//    private final static String excel2007U = ".xlsx";
//
//    /**
//     * 获取excel所有数据
//     *
//     * @param in
//     * @param fileName
//     * @return
//     * @throws Exception
//     */
//    public static List<Map<String, String>> getExcelList(InputStream in, String fileName) throws Exception {
//        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//        Workbook work = getWorkbook(in, fileName);
//        if (null == work || work.getSheetAt(0) == null) {
//            throw new Exception("上传Excel中第一个Sheet为空");
//        }
//        Sheet sheet = work.getSheetAt(0);
//        list.addAll(getExcelListBySheet(sheet));
//        return list;
//    }
//
//    private static List<Map<String, String>> getExcelListBySheet(Sheet sheet) {
//        List<Map<String, String>> rows = new ArrayList<Map<String, String>>();
//        Row fristRow = sheet.getRow(0);
//        Row row = null;
//        Cell cell = null;
//        List<String> values = null;
//        int lastRowNum = sheet.getLastRowNum();
//        for (int i = 1; i <= lastRowNum; i++) {
//            row = sheet.getRow(i);
//            if (row == null) {
//                break;
//            }
//            values = Lists.newArrayList();
//            for (int j = 0; j < row.getLastCellNum(); j++) {
//                cell = row.getCell(j);
//                values.add(getCellValue(cell));
//            }
//            if (CollectionUtils.isEmpty(values)) {
//                break;
//            }
//            Map<String, String> rowMap = convertRowToMap(fristRow, values);
//            if (rowMap != null) {
//                rows.add(rowMap);
//            }
//        }
//        return rows;
//    }
//
//    private static Map<String, String> convertRowToMap(Row fristRow, List<String> values) {
//        Map<String, String> rowMap = Maps.newLinkedHashMap();
//        for (int i = 0; i < values.size(); i++) {
//            String name = fristRow.getCell(i).toString();
//            String value = values.get(i);
//            if (StringUtils.isBlank(value) || StringUtils.isBlank(name)) {
//                continue;
//            }
//            rowMap.put(name.trim(), value.trim());
//        }
//        return rowMap;
//    }
//
//
//    public static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
//        Workbook wb = null;
//        String fileType = fileName.substring(fileName.lastIndexOf("."));
//        if (excel2003L.equals(fileType)) {
//            wb = new HSSFWorkbook(inStr); // 2003-
//        } else if (excel2007U.equals(fileType)) {
//            wb = new XSSFWorkbook(inStr); // 2007+
//        } else {
//            throw new Exception("解析的文件格式有误！");
//        }
//        return wb;
//    }
//
//
//    /**
//     * string 2 int
//     *
//     * @param str
//     * @return
//     * @author zhaicl
//     * @date 2016年9月11日 上午11:17:03
//     */
//    @SuppressWarnings("unused")
//    private static Integer stringToInt(String str) {
//        if (StringUtils.isEmpty(str)) {
//            return null;
//        }
//        if (str != null && str.contains(".")) {
//            str = str.substring(0, str.indexOf("."));
//        }
//        return NumberUtils.toInt(str);
//    }
//
//
//    public static String getCellValue(Cell cell) {
//        String value = "";
//        if (cell == null) {
//            return value;
//        }
//        cell.setCellType(Cell.CELL_TYPE_STRING);
//        switch (cell.getCellType()) {
//            case Cell.CELL_TYPE_STRING:
//                value = cell.getRichStringCellValue().getString();
//                break;
//            case Cell.CELL_TYPE_NUMERIC:
//                value = String.valueOf(cell.getNumericCellValue());
//                break;
//            case Cell.CELL_TYPE_BOOLEAN:
//                value = String.valueOf(cell.getBooleanCellValue());
//                break;
//            case Cell.CELL_TYPE_BLANK:
//                value = "";
//                break;
//            default:
//                break;
//        }
//        if (value == null || value.equals("")) {
//            return "";
//        }
//        return value.trim();
//    }
//
//    /**
//     * 对象集合转化为Excel
//     *
//     * @param objects 需要转化为Excel的对象
//     * @param fields  需要转化的字段
//     * @param titles  每一列的标题
//     * @return
//     */
//    public static HSSFWorkbook List2Excel(List objects, String[] fields, String[] titles) throws NoSuchMethodException,
//            InvocationTargetException, IllegalAccessException {
//        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFSheet sheet = wb.createSheet();
//        HSSFRow row = sheet.createRow(0);
//        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(GENERAL);
//        for (int i = 0; i < titles.length; i++) {
//            HSSFCell cell = row.createCell(i);
//            cell.setCellValue(titles[i]);
//            cell.setCellStyle(style);
////            sheet.autoSizeColumn(i);
//        }
//        for (int i = 0; i < objects.size(); i++) {
//            row = sheet.createRow(i + 1);
//            Object obj = objects.get(i);
//            Class classType = obj.getClass();
//            int cellIndex = 0;
//            for (String field : fields) {
//                String firstLetter = field.substring(0, 1).toUpperCase();
//                String getMethodName = "get" + firstLetter + field.substring(1);
//                Method getMethod = classType.getMethod(getMethodName, new Class[]{});
//                Object value = getMethod.invoke(obj, new Object[]{});
//                row.createCell(cellIndex).setCellValue(value == null ? "" : value.toString());
//                cellIndex++;
//            }
//        }
//        return wb;
//    }
//
//    /**
//     * 对象集合转化为Excel 2007 版本
//     *
//     * @param objects 需要转化为Excel的对象
//     * @param fields  需要转化的字段
//     * @param titles  每一列的标题
//     * @return
//     */
//    public static SXSSFWorkbook List2BigExcel(List objects, String[] fields, String[] titles) throws NoSuchMethodException,
//            InvocationTargetException, IllegalAccessException {
//        SXSSFWorkbook wb = new SXSSFWorkbook();
//        SXSSFSheet sheet = wb.createSheet();
//        SXSSFRow row = sheet.createRow(0);
//        CellStyle style = wb.createCellStyle();
//        style.setAlignment(GENERAL);
//        for (int i = 0; i < titles.length; i++) {
//            SXSSFCell cell = row.createCell(i);
//            cell.setCellValue(titles[i]);
//            cell.setCellStyle(style);
//        }
//        for (int i = 0; i < objects.size(); i++) {
//            row = sheet.createRow(i + 1);
//            Object obj = objects.get(i);
//            Class classType = obj.getClass();
//            int cellIndex = 0;
//            for (String field : fields) {
//                String firstLetter = field.substring(0, 1).toUpperCase();
//                String getMethodName = "get" + firstLetter + field.substring(1);
//                Method getMethod = classType.getMethod(getMethodName, new Class[]{});
//                Object value = getMethod.invoke(obj, new Object[]{});
//                row.createCell(cellIndex).setCellValue(value == null ? "" : value.toString());
//                cellIndex++;
//            }
//        }
//        return wb;
//    }
//
//
//    public static HSSFWorkbook getSXSSFWorkbookByPageThread(List objects, String[] fields, String[] title) {
//
//        HSSFWorkbook wb = new HSSFWorkbook();
//        int pageNum = (objects.size() + 1) / PER_SHEET_LIMIT;
//        int lastCount = (objects.size() + 1) % PER_SHEET_LIMIT;
//        CellStyle style = wb.createCellStyle();
//        int sheet = lastCount == 0 ? pageNum : pageNum + 1;
//        CountDownLatch downLatch = new CountDownLatch(sheet);
//        Executor executor = Executors.newFixedThreadPool(sheet);
//        for (int c = 0; c <= pageNum; c++) {
//            int rowNum = PER_SHEET_LIMIT;
//            if (c == pageNum) {
//                if (lastCount == 0) {
//                    continue;
//                }
//                rowNum = lastCount;
//            }
//            Sheet mySheet = wb.createSheet("page" + c);
//            executor.execute(new PageTask(downLatch, mySheet, title, fields, style, rowNum, objects));
//        }
//        try {
//            downLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return wb;
//    }
//
//
//    public static final int PER_SHEET_LIMIT = 60000;
//
//}
