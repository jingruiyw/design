//package com.book.mall.thread.test;
//
//import com.book.mall.thread.model.SMSModel;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * ClassName: ExcelUtil
// * Description:
// * date: 2020/4/27 8:27 下午
// *
// * @author: Jingrui
// * @since JDK 1.8
// */
//public class ExcelUtil {
//
//
//    private String mFilePath;
//
//    //保存源文件内容
//    void setFilePath(String filePath) {
//        mFilePath = filePath;
//    }
//
//    private static final String SUFFIX_2003 = ".xls";
//    private static final String SUFFIX_2007 = ".xlsx";
//
//    public Workbook initWorkBook() throws IOException {
//        File file = new File(mFilePath);
//        InputStream is = new FileInputStream(file);
//
//        Workbook workbook = null;
//        //根据后缀，得到不同的Workbook子类，即HSSFWorkbook或XSSFWorkbook
//        if (mFilePath.endsWith(SUFFIX_2003)) {
//            workbook = new HSSFWorkbook(is);
//        } else if (mFilePath.endsWith(SUFFIX_2007)) {
//            workbook = new XSSFWorkbook(is);
//        }
//
//        return workbook;
//    }
//
//    public void parseWorkbook(Workbook workbook, List<SMSModel> smsModels) {
//        int numOfSheet = workbook.getNumberOfSheets();
//
//        //依次解析每一个Sheet
//        for (int i = 0; i < numOfSheet; ++i) {
//            Sheet sheet = workbook.getSheetAt(i);
//            parseSheet(sheet, smsModels);
//        }
//    }
//
//    //保存需要调用的ApnModel中的方法
//
//    private void parseSheet(Sheet sheet, List<SMSModel> smsModels) {
//        Row row;
//
//        int count = 0;
//
//        //利用迭代器，取出每一个Row
//        Iterator<Row> iterator = sheet.iterator();
//        while(iterator.hasNext()) {
//            row = iterator.next();
//
//            //由于第一行是标题，因此这里单独处理
//            if (count == 0) {
//                mUsedMethod = new ArrayList<>();
//                parseRowAndFindMethod(row);
//            } else {
//                //其它行都在这里处理
//                parseRowAndFillData(row, smsModels);
//            }
//
//            ++count;
//        }
//    }
//
//    private void parseRowAndFindMethod(Row row) {
//        //利用parseRow处理每一行，得到每个cell中的String
//        List<String> rst = parseRow(row);
//
//        String methodName;
//        try {
//            //根据String得到需要调用的ApnModel中的方法
//            //由于自己在ApnModel中定义的方法均是类似setMcc、setMnc等
//            //因此才在一开始，将标题栏中每一项大写
//            for (String str : rst) {
//                methodName = "set" + str;
//                //反射拿到method
//                mUsedMethod.add(ApnModel.class.getDeclaredMethod(methodName, String.class));
//            }
//        } catch (NoSuchMethodException e) {
//            System.out.println(e.toString());
//        }
//
//
//
//}
