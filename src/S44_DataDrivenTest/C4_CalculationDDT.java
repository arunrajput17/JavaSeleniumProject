package S44_DataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class C4_CalculationDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		System.out.println("Start");
		
		FileInputStream file = new FileInputStream("D:\\Day Shift\\Selenium Practice\\JEx\\First\\JavaSeleniumProject\\TestFiles\\Caldata44.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("No. of rows : "+rowCount);
		
		
		for(int i=1; i<=rowCount; i++)
		{
			XSSFRow currentRow = sheet.getRow(i);
			
			// 1st way
			XSSFCell principlecell = currentRow.getCell(0);
			int princ = (int)principlecell.getNumericCellValue();
			
			// 2nd way
			int rateofinterest = (int)currentRow.getCell(1).getNumericCellValue();
			
			XSSFCell period = currentRow.getCell(2);
			int per = (int)period.getNumericCellValue();
			
			XSSFCell Frequency = currentRow.getCell(3);
			String Freq = Frequency.getStringCellValue();
			
			XSSFCell MaturityValue = currentRow.getCell(4);
			int Exp_mvalue = (int)MaturityValue.getNumericCellValue();
			
			
			// Send keys is designed to send only String values not int So we need to convert it into string
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
			
			Select periodCombo = new Select(driver.findElement(By.id("tenurePeriod")));
			periodCombo.selectByVisibleText("year(s)");
			
			Select frequency = new Select(driver.findElement(By.id("frequency")));
			frequency.selectByVisibleText(Freq);
			
			//Click on Calculate
			WebElement calButelement = driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]/img"));
			//Explicit Wait
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(calButelement));
			
			calButelement.click();
			
			
			// Get Maturity Value
			String actual_mvalue =driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();
			
			
//			 Integer to String is Integer.parseInt(StringValue)
			
			if (Double.parseDouble(actual_mvalue)  == Exp_mvalue)	// Convert String to Double
			{
				System.out.println("Test is passed");
			}
			else
			{
				System.out.println("Test is Failed");
			}
			
			
			// Click on clear
			driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]/img")).click();
			
		}

		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();
		file.close();

	}

}
