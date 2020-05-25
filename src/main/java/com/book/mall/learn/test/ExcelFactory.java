//package com.book.mall.thread.test;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//
//import java.util.List;
//
///**
// * ClassName: ExcelFactory
// * Description:
// * date: 2020/4/27 8:40 下午
// *
// * @author: Jingrui
// * @since JDK 1.8
// */
//public class ExcelFactory {
//
//    import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//
//import java.util.List;
//    /**
//     * Excel 工厂类，负责 Workbook 的生成和解析
//     *
//     * @author calmer
//     * @since 2018/12/5 11:19
//     */
//    /**
//     * 构造 Workbook 对象，具体实例化哪种对象由 type 参数指定
//     *
//     * @param data 要导出的数据
//     * @param type Excel 生成方式
//     * @return 对应 type 的工作簿实例对象
//     * @throws Exception 反射生成对象时出现的异常
//     *                   <li>InstantiationException</li>
//     *                   <li>IllegalAccessException</li>
//     *                   <li>InstantiationException</li>
//     */
//    public static Workbook createExcel(List data, String type)
//            throws Exception {
//        //根据 type 参数生成工作簿实例对象
//        Workbook workbook = (Workbook) Class.forName(type).newInstance();
//        //这里还可以指定 sheet 的名字
//        //Sheet sheet = workbook.createSheet("sheetName");
//        Sheet sheet = workbook.createSheet();
//        // 限定列数
//        int cols = 10;
//        int rows = data.size() / cols;
//        int index = 0;
//        for (int rowNum = 0; rowNum < rows; rowNum++) {
//            Row row = sheet.createRow(rowNum);
//            for (int colNum = 0; colNum < cols; colNum++) {
//                Cell cell = row.createCell(colNum);
//                cell.setCellValue(data.get(index++).toString());
//            }
//        }
//        return workbook;
//    }
//
//}
