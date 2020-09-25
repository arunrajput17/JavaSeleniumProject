package S44_DataDrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class C6_ReadExcelusingIterator {

	public static void main(String[] args) throws IOException {
		
		String path = "D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles\\data44.xlsx";
		
		File filePath = new File(path);
		if (!filePath.exists())
		{
			System.out.println("nvalid Path , File Not Exist");
			
		}
		
		
		FileInputStream file = new FileInputStream(filePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		// Iterator
		Iterator<Row> rows = sheet.rowIterator();
		int cellCounter = 0;
		
		while (rows.hasNext())
		{
			Row row = rows.next();
			
			Iterator<Cell> cells = row.cellIterator();
			cellCounter = 1;
			while (cells.hasNext())
			{
				Cell cell = cells.next();
				if(cell.getCellType() == CellType.STRING)
				{
					String Value = cell.getStringCellValue();
					System.out.print(Value+"        ");
				}
				else if (cell.getCellType() == CellType.NUMERIC)
				{
					double val = cell.getNumericCellValue();
					System.out.print(val+"-------");
				}
					cellCounter++;
			}
			System.out.println("  ");
		}
		
		

	}

}
