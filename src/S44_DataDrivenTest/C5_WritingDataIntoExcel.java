package S44_DataDrivenTest;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class C5_WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		// This staement will create the new file in the directory
		FileOutputStream file = new FileOutputStream("D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles\\Writing44.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		
		System.out.println("Writing Excel Started");
		
		for (int i=0; i<=5; i++)
		{
			XSSFRow currentRow = sheet.createRow(i);
			for (int j=0; j<3; j++)
			{
				currentRow.createCell(j).setCellValue("xyz"+i+j);
			}
			
		}
		
		workbook.write(file);
		file.close();
		
		System.out.println(" Writing Excel finished");

	}

}
