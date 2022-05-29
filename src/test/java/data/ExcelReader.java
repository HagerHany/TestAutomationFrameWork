package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExcelReader {
    static FileInputStream fis=null;

    public FileInputStream getFis() {

        String filepath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserInfo.xlsx";
        File srcFile = new File(filepath);
        try {
            fis=new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR OCCURRED IN READING EXCEL FILE");
        }
        return fis;
    }

    public Object[][] getExcelData() throws IOException {
        fis= getFis();
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows= (sheet.getLastRowNum()+1);
       // System.out.println(TotalNumberOfRows);
        int TotalNumberOfCols=5;
        String [][] excelDataArray= new String[TotalNumberOfRows][TotalNumberOfCols];

        for (int i = 0; i < TotalNumberOfRows; i++) {
            for (int j = 0; j < TotalNumberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                excelDataArray[i][j]=row.getCell(j).toString();
            }
        }
        wb.close();
        //System.out.println(excelDataArray[0][0]);

        return excelDataArray;

    }
}
