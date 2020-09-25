package S27to34_MouseKeyboardActions;
//Mouse Action Methods:
//clickAndHold() : Clicks (without releasing) at the current mouse location
//contextClick() : performs a context click at the current mouse location 
//doubleClick() : performs a double click at current mouse location
//dragAndDrop(source, target) :Performs click and hold at the location of the source element, moves to the location of the target
//				element, then releases the mouse
//dragAndDropBy(source, x-offset, y-offset) : Performs click and hold at the location of the source element, moves by given offset,
//				then releases the mouse
//moveToElement(toElement): Moves the mouse to the middle of the element. Parameters: toElement - element to move
//release() : Releases the depressed left mouse button at the current mouse location.



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class S27_MouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println("Start");
		
		// Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		//Moving cursor Admin --> User Management --> Users
		Actions act = new Actions(driver);		// created object of actions class
		
		WebElement admin = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
		WebElement usermg = driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
		WebElement users = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]"));
		Thread.sleep(3000);
		
		// 1) Mouse Hover
		act.moveToElement(admin).build().perform();		// mouse hover to admin tab
		act.moveToElement(usermg).build().perform(); 	// mouse hover to User Management tab
		
		act.moveToElement(users).click().build().perform(); 	// mouse hover to user and click the element 
		
		//----------------OR reducing line by this code----------------
//		act.moveToElement(admin).moveToElement(usermg).moveToElement(users).click().build().perform();
		
		System.out.println("Mouseover completed");
		
		Thread.sleep(5000);
		System.out.println("End");
		driver.quit();
		
		
	}

}
