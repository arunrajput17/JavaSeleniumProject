package S44_DataDrivenTest;
//Excel --> work books --> sheets --> row --> cell
//FileInputStream
//XSSFWorkBook
//XSSFSheet
//XSSFRow
//XSSFCell
/*
 * 
    Workbook: XSSFWorkbook and HSSFWorkbook classes implement this interface.
    XSSFWorkbook: Is a class representation of XLSX file.
    HSSFWorkbook: Is a class representation of XLS file.
    
    Sheet: XSSFSheet and HSSFSheet classes implement this interface.
    XSSFSheet: Is a class representing a sheet in an XLSX file.
    HSSFSheet: Is a class representing a sheet in an XLS file.
    
    Row: XSSFRow and HSSFRow classes implement this interface.
    XSSFRow: Is a class representing a row in the sheet of XLSX file.
    HSSFRow: Is a class representing a row in the sheet of XLS file.
    
    Cell: XSSFCell and HSSFCell classes implement this interface.
    XSSFCell: Is a class representing a cell in a row of XLSX file.
    HSSFCell: Is a class representing a cell in a row of XLS file.

 */

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;




public class C1_ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles\\data44.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");	//Providing sheet name
//		XSSFSheet sheet = workbook.getSheetAt(0);		// providing sheet index
		
		// Counting rows
		int rowCount =sheet.getLastRowNum();
		System.out.println("No. of rows : "+rowCount);
		
		// Column counting
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("No. of columns : "+colCount);
		
		// Read values from Excel sheet
		
		for (int i=0; i<=rowCount; i++)
		{
			XSSFRow currentRow = sheet.getRow(i);	// focus on current row	
			for (int j=0; j<colCount; j++)
			{
				String value =currentRow.getCell(j).toString();	// read the value from cell
				System.out.print(value+"       ");
			}
			System.out.println("");
		}	
	}

}
