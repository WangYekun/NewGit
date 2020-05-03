import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/3 22:31
 * @description 读入文件
 */
public class PoiReadTest {

    private static final String PATH = "D:\\git\\spring-study\\spring-study\\spring-module\\poi-excel";

    @Test
    public void Poi03Read() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(PATH + File.separator + "test03.xls");
        // 1. 得到一个工作簿03
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        // 2. 得到一个表
        HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
        // 3. 得到行
        HSSFRow row = sheetAt.getRow(0);
        // 4. 得到列
        HSSFCell cell = row.getCell(1);
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);
        fileInputStream.close();
    }

    @Test
    public void Poi07Read() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(PATH + File.separator + "test07.xlsx");
        // 1. 得到一个工作簿03
        Workbook hssfWorkbook = new XSSFWorkbook(fileInputStream);
        // 2. 得到一个表
        Sheet sheetAt = hssfWorkbook.getSheetAt(0);
        // 3. 得到行
        Row row = sheetAt.getRow(0);
        // 4. 得到列
        Cell cell = row.getCell(1);
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);
        fileInputStream.close();
    }

    @Test
    public void Poi07ReadType() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(PATH + File.separator + "test07.xlsx");
        // 1. 得到一个工作簿03
        Workbook hssfWorkbook = new XSSFWorkbook(fileInputStream);
        // 2. 得到一个表
        Sheet sheetAt = hssfWorkbook.getSheetAt(0);
        // 3. 得到行
        Row row = sheetAt.getRow(0);
        if (row != null) {
            int physicalNumberOfCells = row.getPhysicalNumberOfCells();
            for (int rowNum = 0; rowNum < physicalNumberOfCells; rowNum++) {
                Cell cell = row.getCell(rowNum);
                if (cell != null) {
                    int cellType = cell.getCellType();
                    String stringCellValue = cell.getStringCellValue();
                    System.out.print(stringCellValue + "|");
                }
            }
        }
    }

    @Test
    public void testCellType() throws Exception {

        // 获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH + "/明细表.xls");
        // 创建一个工作簿
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        // 获取标题内容
        Row rowTitle = sheet.getRow(0);
        if (rowTitle != null) {
            // 重点
            int rowCount = rowTitle.getPhysicalNumberOfCells(); // 获取列的数量
            for (int cellNum = 0; cellNum < rowCount; cellNum++) {
                Cell cell = rowTitle.getCell(cellNum);
                if (cell != null) {
                    int cellType = cell.getCellType();
                    String cellValue = cell.getStringCellValue();
                    System.out.print(cellValue + " | ");
                }
            }
            System.out.println();
        }

        // 获取表中内容
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row rowData = sheet.getRow(rowNum);
            if (rowData != null) {
                // 读取列
                assert rowTitle != null;
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                    System.out.print("[" + (rowNum + 1) + "-" + (cellNum + 1) + "]");

                    Cell cell = rowData.getCell(cellNum);
                    // 匹配列的数据类型
                    if (cell != null) {
                        int cellType = cell.getCellType();
                        String cellValue = "";
                        switch (cellType) {
                            case HSSFCell.CELL_TYPE_STRING: // 字符串
                                System.out.print("【String】");
                                cellValue = cell.getStringCellValue();
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN: // 布尔
                                System.out.print("【BOOLEAN】");
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_BLANK: // 空
                                System.out.print("【BLANK】");
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                                System.out.print("【UMERIC】");
                                if (HSSFDateUtil.isCellDateFormatted(cell)) { // 日期
                                    System.out.print("【日期】");
                                    Date date = cell.getDateCellValue();
                                    cellValue = new DateTime(date).toString();
                                } else {
                                    // 不是日期格式，防止数字过长
                                    System.out.print("【装换为字符串输出】");
                                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                System.out.print("【数据类型错误】");
                                break;
                        }
                        System.out.println(cellValue);
                    }
                }
            }
        }
        fileInputStream.close();
    }

    @Test
    public void testFormula() throws Exception {

        FileInputStream fileInputStream = new FileInputStream(PATH + "/公式.xls");
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(4);
        Cell cell = row.getCell(0);

        // 拿到计算公式
        FormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);

        // 输出单元格的内容
        int cellType = cell.getCellType();
        switch (cellType) {
            case (Cell.CELL_TYPE_FORMULA): // 公式
                String formula = cell.getCellFormula();
                System.out.println(formula); // SUM(A2:A4)

                // 计算
                CellValue evaluate = formulaEvaluator.evaluate(cell);
                String cellValue = evaluate.formatAsString();
                System.out.println(cellValue); // 1188.0
                break;
        }
    }

}
