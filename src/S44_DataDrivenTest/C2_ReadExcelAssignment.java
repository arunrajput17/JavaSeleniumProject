package S44_DataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class C2_ReadExcelAssignment {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles\\Registration44.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("No. of rows : "+rowCount);
		
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("No. of columns : "+ colCount);
		
		
		for (int i=0; i<=rowCount; i++ )
		{
			XSSFRow currentRow = sheet.getRow(i);
			for(int j=0; j<colCount; j++)
			{
				String value = currentRow.getCell(j).toString();
				System.out.print(value +"          ");
			}
			System.out.println(" ");
		}
		
		
		
		
		

	}

}
