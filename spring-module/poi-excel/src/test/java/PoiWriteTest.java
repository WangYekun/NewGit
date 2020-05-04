import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/3 22:31
 * @description 写入文件
 */
public class PoiWriteTest {

    private static final String PATH = "D:\\git\\spring-study\\spring-study\\spring-module\\poi-excel";

    @Test
    public void Poi03Write() throws Exception {
        // 1. 创建一个工作簿03
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        // 2. 创建表
        HSSFSheet sheet = hssfWorkbook.createSheet("这是03版本表格名字");
        // 3. 创建行
        HSSFRow row1 = sheet.createRow(0);
        // 4. 创建列(单元格)
        HSSFCell cell11 = row1.createCell(0);
        // 5. 创建列名
        cell11.setCellValue("第一行");
        HSSFCell cell12 = row1.createCell(1);
        cell12.setCellValue("第一行数据");
        HSSFRow row2 = sheet.createRow(1);
        HSSFCell cell21 = row2.createCell(0);
        cell21.setCellValue("第二行");
        HSSFCell cell22 = row2.createCell(1);
        cell22.setCellValue("第二行数据");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + File.separator + "test03.xls");
        hssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("输出03版成功");
    }

    @Test
    public void Poi07Write() throws Exception {
        // 1. 创建一个工作簿03
        XSSFWorkbook xssfSheets = new XSSFWorkbook();
        // 2. 创建表
        XSSFSheet sheet = xssfSheets.createSheet("这是07版本表格名字");
        // 3. 创建行
        XSSFRow row1 = sheet.createRow(0);
        // 4. 创建列(单元格)
        XSSFCell cell11 = row1.createCell(0);
        // 5. 创建列名
        cell11.setCellValue("第一行");
        XSSFCell cell12 = row1.createCell(1);
        cell12.setCellValue("第一行数据");
        XSSFRow row2 = sheet.createRow(1);
        XSSFCell cell21 = row2.createCell(0);
        cell21.setCellValue("第二行");
        XSSFCell cell22 = row2.createCell(1);
        cell22.setCellValue("第二行数据");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + File.separator + "test07.xlsx");
        xssfSheets.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("输出07版成功");
    }

    @Test
    public void Poi03BigDataWrite() throws Exception {
        long startTime = System.currentTimeMillis();
        // 1. 创建一个工作簿03
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        // 2. 创建表
        HSSFSheet sheet = hssfWorkbook.createSheet("这是03版本大表格名字");
        for (int rowNum = 0; rowNum < 65535; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 50; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + File.separator + "test03BigData.xls");
        hssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println((double) endTime - startTime);

    }

    @Test
    public void Poi07BigDataWrite() throws Exception {
        long startTime = System.currentTimeMillis();
        // 1. 创建一个工作簿03
        XSSFWorkbook xssfSheets = new XSSFWorkbook();
        // 2. 创建表
        XSSFSheet sheet = xssfSheets.createSheet("这是07版本大表格名字");
        for (int rowNum = 0; rowNum < 65537; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + File.separator + "test07BigData.xlsx");
        xssfSheets.write(fileOutputStream);
        fileOutputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println((double) endTime - startTime);

    }

    @Test
    public void PoiBigDataSuperWrite() throws Exception {
        long startTime = System.currentTimeMillis();
        // 1. 创建一个工作簿03
        SXSSFWorkbook xssfSheets = new SXSSFWorkbook();
        // 2. 创建表
        Sheet sheet = xssfSheets.createSheet("这是07版本大表格名字");
        for (int rowNum = 0; rowNum < 65537; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + File.separator + "PoiBigDataSuperWrite.xlsx");
        xssfSheets.write(fileOutputStream);
        fileOutputStream.close();
        xssfSheets.dispose();
        long endTime = System.currentTimeMillis();
        System.out.println((double) endTime - startTime);

    }
}
