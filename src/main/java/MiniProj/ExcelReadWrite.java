package MiniProj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.sdk.metrics.data.Data;

public class ExcelReadWrite {
	public static String book;
	public static XSSFWorkbook wb;
	public static String readExcel() throws IOException {
		
		// FileInputStream for reading the excel sheet
		// get the actual location of the excel file
		FileInputStream file = new FileInputStream("C:\\Users\\2303555\\OneDrive - Cognizant\\Desktop\\Eclipse codes\\Mini\\TestData\\data.xlsx");
		// creating the workbook
		wb = new XSSFWorkbook(file);
		
		// creating the sheet named 'Sheet1'
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		// setting the row index as 0
		XSSFRow row1 = sheet.getRow(0);
		
		// setting the column index as 0
		XSSFCell cell1 = row1.getCell(0);
		
		// converting the data to String
		book = cell1.toString();
		
		return book;
	}
	
	public static void writeExcel() throws IOException {
		FileOutputStream file = new FileOutputStream("C:\\Users\\2303555\\OneDrive - Cognizant\\Desktop\\Eclipse codes\\Mini\\TestData\\data.xlsx");
		
		XSSFSheet sheet = wb.createSheet();
		
		String values[] = new String[5];
		values = OnlineBookSearch.getName();
		
		String book1 = values[0];
		String book2 = values[1];
		String book3 = values[2];
		String book4 = values[3];
		String book5 = values[4];
		
		
			XSSFRow currentRow1 = sheet.createRow(0);
			XSSFRow currentRow2 = sheet.createRow(1);
			XSSFRow currentRow3 = sheet.createRow(2);
			XSSFRow currentRow4 = sheet.createRow(3);
			XSSFRow currentRow5 = sheet.createRow(4);
			for(int c=0;c<1;c++) {
				currentRow1.createCell(c).setCellValue(book1);
				currentRow2.createCell(c).setCellValue(book2);
				currentRow3.createCell(c).setCellValue(book3);
				currentRow4.createCell(c).setCellValue(book4);
				currentRow5.createCell(c).setCellValue(book5);
			}
		
		wb.write(file);
		wb.close();
		file.close();
		
	}
}









