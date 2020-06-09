package com.book.mall.learn.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * ClassName: ExcelTest
 * Description:
 * date: 2020/4/27 8:22 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ExcelTest {

    /**
     * 读取 Excel 数据并处理
     *
     * @param workbook 完整的 Workbook 对象
     */
    public static List<String> readExcel(Workbook workbook) {

        List<String> phoneNums = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        //获取总行数
        int rows = sheet.getPhysicalNumberOfRows();
        //去除表头，从第 1 行开始打印
        for (int i = 0; i < rows; i++) {
            Row row = sheet.getRow(i);
//            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            //获取总列数
            int cols = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                System.out.print(cell.getStringCellValue() + "\t");
                phoneNums.add(cell.getStringCellValue());
            }
            System.out.println();
        }
        return phoneNums;
    }


    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("/Users/jingrui/Desktop/jh_member.xlsx");
//        FileInputStream in = new FileInputStream("/Users/jingrui/Desktop/jr.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        List<String> phoneNums = readExcel(workbook);
        in.close();

    }

}
