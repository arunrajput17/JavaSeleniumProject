package S61_PageObjectModelType1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	WebDriver driver;
	
	//--------------------Elements Locating-------------------------
	
	By regLink =By.linkText("REGISTER");
	By firstName = By.name("firstName");
	By lastName = By.name("lastName");
	By phone = By.name("phone");
	By email = By.name("userName");
	By address = By.name("address1");
	By city = By.name("city");
	By state = By.name("state");
	By postalCode = By.name("postalCode");
	By country = By.name("country");
	By userName = By.name("email");
	By password = By.name("password");
	By confirmPassword = By.name("confirmPassword");
	By registerBtn = By.name("submit");
	
	
	//----------------------Creating Methods for identification and action-------------------------
	
	public RegistrationPage(WebDriver d) 
	{
//		this.driver=driver;	// for this instead of d we need to pass driver as parameter.
		driver =d;
	}
	
	public void clickRegLink()
	{
		driver.findElement(regLink).click();
	}
	
	
	public void setFirstName(String fname)
	{
		driver.findElement(firstName).sendKeys(fname);
	}
	
	
	public void setlastName(String lname)
	{
		driver.findElement(lastName).sendKeys(lname);
	}
	
	
	public void setPhone(String ph)
	{
		driver.findElement(phone).sendKeys(ph);
	}
	
	
	public void setEmail(String mail)
	{
		driver.findElement(email).sendKeys(mail);
	}
	
	
	public void setAddress(String add)
	{
		driver.findElement(address).sendKeys(add);
	}
	
	
	public void setCity(String ci)
	{
		driver.findElement(city).sendKeys(ci);
	}
	
	
	public void setState(String st)
	{
		driver.findElement(state).sendKeys(st);
	}
	
	
	public void setPostalCode(String pc)
	{
		driver.findElement(postalCode).sendKeys(pc);
	}
	
	
	public void setCountry(String cn)
	{
		WebElement con =driver.findElement(country);
		Select drop = new Select(con);
		drop.selectByVisibleText(cn);
	}
	
	
	public void setUserName(String uname)
	{
		driver.findElement(userName).sendKeys(uname);
	}
	
	
	public void setPassword(String passwrd)
	{
		driver.findElement(password).sendKeys(passwrd);
	}
	
	
	public void setConfirmedPassword(String passwrdConf)
	{
		driver.findElement(confirmPassword).sendKeys(passwrdConf);
	}
	
	
	public void clickRegBtn()
	{
		driver.findElement(registerBtn).click();
	}
	
}
