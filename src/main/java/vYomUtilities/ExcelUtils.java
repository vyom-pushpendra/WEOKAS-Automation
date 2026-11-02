package vYomUtilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {

    public static String getCellData(String filePath,
                                     String sheetName,
                                     int rowNum,
                                     int colNum) {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            String value = sheet.getRow(rowNum)
                               .getCell(colNum)
                               .getStringCellValue();

            wb.close();
            return value;

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}