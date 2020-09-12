package S55_TestNG;

import org.testng.annotations.DataProvider;

public class A9_TC2TestNGCustomDataProvider {
	
	// DataProvider method
	@DataProvider(name="NamePhoneProvider")
	public Object[][] getData()
	{
		Object[][] data = {{"Mike","111"},{"Tim","7856768"},{"James","007"}};
		return data;
	}

}
