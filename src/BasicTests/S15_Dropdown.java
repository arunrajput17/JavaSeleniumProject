package BasicTests;
//Dropdown list


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class S15_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");

		
		System.out.println("Start");
		
		
		// 1) Select an option
//		WebElement eleContact = driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-9']"));
//		Select drpContact =new Select(eleContact);
		
		//		OR
		Select drpContact = new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-9']")));
		
		
		// 2) Select value by visible text
		drpContact.selectByVisibleText("Morning");
		Thread.sleep(2000);
		
		// 3) Select by index number
		drpContact.selectByIndex(2);
		Thread.sleep(2000);
		
		// 4) # Select by value
		drpContact.selectByValue("Radio-2");
		
		// 5) Count how many options present
		List<WebElement> allOptions = drpContact.getOptions();
		System.out.println(allOptions.size());
		
		// 6) Capture options from drop down and print
		for(WebElement i : allOptions)
		{
			System.out.println(i.getText());
		}
		
		
		// 7) Multiple select in dropdown example (It will not work for this site)
//		System.out.println(drpContact.isMultiple());
		if (drpContact.isMultiple())
		{
			drpContact.deselectByIndex(1);
			drpContact.deselectByIndex(2);
		}
		else
		{
			System.out.println("Multiple selection not allowed for this Dropdown");
		}
		
		
		
		
		// -----> Another way using Send keys this is used when Select not work. We are entering through key bord
		driver.findElement(By.cssSelector("select#RESULT_RadioButton-9")).click();
		driver.findElement(By.cssSelector("select#RESULT_RadioButton-9")).sendKeys("Morning");
		driver.findElement(By.cssSelector("select#RESULT_RadioButton-9")).sendKeys(Keys.ENTER);
		
		
		
		// Dropdown options are sorted or not
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		WebElement eleAnimal = driver.findElement(By.xpath("//select[@id='animals']"));
		Select selAnimal = new Select(eleAnimal);
		
		List originalAnimalList = new ArrayList();
		List tempList = new ArrayList();
		
		List <WebElement> options = selAnimal.getOptions();
		
		for (WebElement e : options)
		{
			originalAnimalList.add(e.getText());	// all option are in this originalList
			tempList.add(e.getText());	// (2) adding in temp list which we sort separately and compare with original
			
		}
		System.out.println("Original list values are: "+originalAnimalList);
		
		
//		tempList = originalAnimalList; // if this is on comparison is giving sorted (1)
		
		System.out.println("Before sorting Temporary list values are : "+tempList);
		
		
		Collections.sort(tempList);
		System.out.println("After sorting Temporary list values are : "+tempList);
		System.out.println("After sorting Original list values are : "+originalAnimalList);
		
		// it will not find the difference and say sorted which is incorrect. happens due to we 
		//assigned the value of original to templist and original also get changed on changing templist
		if(originalAnimalList == tempList)
		{
			System.out.println("Dropdown is sorted");
		}
		else
		{
			System.out.println("Dropdown is not sorted");
		}
		
		
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.close();

	}

}
