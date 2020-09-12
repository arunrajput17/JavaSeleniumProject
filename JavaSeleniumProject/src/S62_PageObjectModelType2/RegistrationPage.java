package S62_PageObjectModelType2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	WebDriver driver;
	
	//--------------------Elements locating and identification-------------------------
	
	@FindBy(how=How.LINK_TEXT, using="REGISTER")
	WebElement regLink;
	
//	@FindBy(linkText="REGISTER")
//	WebElement regLink;
	
	
	@FindBy(how=How.NAME, using="firstName")	// SYNTAX 1
	WebElement firstName;
	
//	@FindBy(name="firstName")					// SYNTAX 2
//	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="userName")
	WebElement email;
	
	@FindBy(name="address1")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="postalCode")
	WebElement postalCode;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name="submit")
	WebElement registerBtn;
	
	
	

	
	
	//----------------------Creating Methods-------------------------
	
	public RegistrationPage(WebDriver d) 
	{
//		this.driver=driver;	// for this instead of d we need to pass driver as parameter.
		driver =d;
		PageFactory.initElements(d, this);		// additional method
	}
	
	public void clickRegLink()
	{
		regLink.click();
	}
	
	
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	
	public void setlastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	
	public void setPhone(String ph)
	{
		phone.sendKeys(ph);
	}
	
	
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	
	
	public void setCity(String ci)
	{
		city.sendKeys(ci);
	}
	
	
	public void setState(String st)
	{
		state.sendKeys(st);
	}
	
	
	public void setPostalCode(String pc)
	{
		postalCode.sendKeys(pc);
	}
	
	
	public void setCountry(String cn)
	{

		Select drop = new Select(country);
		drop.selectByVisibleText(cn);
	}
	
	
	public void setUserName(String uname)
	{
		userName.sendKeys(uname);
	}
	
	
	public void setPassword(String passwrd)
	{
		password.sendKeys(passwrd);
	}
	
	
	public void setConfirmedPassword(String passwrdConf)
	{
		confirmPassword.sendKeys(passwrdConf);
	}
	
	
	public void clickRegBtn()
	{
		registerBtn.click();
	}
	
}
