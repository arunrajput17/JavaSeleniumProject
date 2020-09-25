package S44_DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class C3_RegistrationDDT {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/");
		
		System.out.println("Start");
		
		
		//Getting data from EXCEL
		
		FileInputStream file = new FileInputStream("D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles\\Registration44.xlsx");
		
		//Get the workbook instance for XLS file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//Get number of rows
		int rowCount = sheet.getLastRowNum();
		System.out.println("No. of rows : "+rowCount);
		
		
		for(int row=1; row<=rowCount; row++)
		{
			XSSFRow currentRow =sheet.getRow(row);
			
			String first_name = currentRow.getCell(0).getStringCellValue();
			String last_name = currentRow.getCell(1).getStringCellValue();
			String Phone = currentRow.getCell(2).getStringCellValue();
			String Email = currentRow.getCell(3).getStringCellValue();
			String Address = currentRow.getCell(4).getStringCellValue();
			String City = currentRow.getCell(5).getStringCellValue();
			String state = currentRow.getCell(6).getStringCellValue();
			String Postal_code = currentRow.getCell(7).getStringCellValue();
			String Country = currentRow.getCell(8).getStringCellValue();
			String User_name = currentRow.getCell(9).getStringCellValue();
			String Password = currentRow.getCell(10).getStringCellValue();
			
			
			// Registration process
			driver.findElement(By.linkText("REGISTER")).click();
			
			//Entering Contact information
			driver.findElement(By.name("firstName")).sendKeys(first_name);
			driver.findElement(By.name("lastName")).sendKeys(last_name);
			driver.findElement(By.name("phone")).sendKeys(Phone);
			driver.findElement(By.name("userName")).sendKeys(Email);
			
			//Entering Mailing Information
			driver.findElement(By.name("address1")).sendKeys(Address);
			driver.findElement(By.name("city")).sendKeys(City);
			driver.findElement(By.name("state")).sendKeys(state);
			driver.findElement(By.name("postalCode")).sendKeys(Postal_code);
			
			//Country selection
			Select dropCountry = new Select(driver.findElement(By.name("country")));
			dropCountry.selectByVisibleText(Country);
			
			// Entering User Information
			driver.findElement(By.name("email")).sendKeys(User_name);
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.name("confirmPassword")).sendKeys(Password);
			
			//Submitting Form
			driver.findElement(By.name("submit")).click();
			
			
			if(driver.getPageSource().contains("Thank you for registering"))
			{
				System.out.println("Registration complete for "+ row + " record");
			}
			else
			{
				System.out.println("Registration Failed for "+ row + " record");
			}
			
		}
		
		System.out.println("Data Driven Test completed");
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
		
		file.close();

	}

}
