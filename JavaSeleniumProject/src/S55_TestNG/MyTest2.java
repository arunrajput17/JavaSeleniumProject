package S55_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest2 {
	
	@Test

	public  void testlogin() {
		// Inside Selenium Code
		String title ="XRM";
		//Assert.assertEquals(title, "XRM");
		Assert.assertTrue(title.equals("XRM"));
	}

}
