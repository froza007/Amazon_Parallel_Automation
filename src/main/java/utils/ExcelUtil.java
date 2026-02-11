package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static String getSearchValue(String columnName){

        String value = "";

        try{

            FileInputStream fis =
                    new FileInputStream("testdata/SearchData.xlsx");

            Workbook workbook = new XSSFWorkbook(fis);

            // ALWAYS take first sheet (avoid sheet name error)
            Sheet sheet = workbook.getSheetAt(0);

            Row headerRow = sheet.getRow(0);

            int columnIndex = -1;

            for(int i=0;i<headerRow.getPhysicalNumberOfCells();i++){

                if(headerRow.getCell(i).toString()
                        .equalsIgnoreCase(columnName)){

                    columnIndex = i;
                    break;
                }
            }

            if(columnIndex != -1){

                Row dataRow = sheet.getRow(1);

                DataFormatter formatter = new DataFormatter();

                value = formatter.formatCellValue(
                        dataRow.getCell(columnIndex));
            }

            workbook.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return value;
    }
}
