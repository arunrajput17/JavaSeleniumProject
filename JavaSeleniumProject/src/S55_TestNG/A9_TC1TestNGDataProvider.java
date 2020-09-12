package S55_TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * Data Provider :
 * - Apart from Parameters, there is another way to achieve parameterization which is by using DataProvider in TestNG
 * - DataProviders are used for Data driven testing which means same test case can be run with different set of data.
 * It is very powerful feature of TestNG and effectively used during framework development. There are few points you
 * should know about data provider
 * - It marks a methods for supplying the data to other methods.
 * - Annotated methods return an array of Object i.e. two dimensional array Object[][].
 * - DataProvider can have a name, and it will be used in other methods by using its name
 * - DataProvider can be implemented in same class or different class
 * - A DataProvider is a method annotated with @DataProvider 
 */

public class A9_TC1TestNGDataProvider {
	
	@Test(dataProvider="LoginDataProvider")
	public void loginTest(String email, String pwd)
	{
		System.out.println(email+"-------"+pwd);
		
	}
	
	
	
	// DataProvider method
	@DataProvider(name="LoginDataProvider")
	public Object[][] getData()
	{
		Object[][] data = {{"abc@gmail.com","abc"},{"xyz@gamil.com","xyz"},{"mno@gmail.com","mno"}};
		return data;
	}
	
	
	
	// This methods Dataprovider is in another class i.e. A9_TC2TestNGCustomDataProvider
	@Test(dataProvider="NamePhoneProvider", dataProviderClass=A9_TC2TestNGCustomDataProvider.class)
	public void  namePhoneTest(String name, String phone) 
	{
		System.out.println(name + "*******"+ phone);
	}

}
