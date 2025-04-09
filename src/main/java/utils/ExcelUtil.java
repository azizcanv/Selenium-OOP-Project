package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;

public class ExcelUtil {
    private String filePath;

    public ExcelUtil(String filePath) {
        this.filePath = filePath;
    }

    public String readCell(int rowIndex, int colIndex) throws Exception {
        try (InputStream fis = getClass().getClassLoader().getResourceAsStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowIndex);
            return row.getCell(colIndex).getStringCellValue();
        }
    }
}
