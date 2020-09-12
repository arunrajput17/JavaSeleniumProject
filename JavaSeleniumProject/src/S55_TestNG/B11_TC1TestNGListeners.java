package S55_TestNG;
/*
 * Listeners:
 * 
 * Types of Listeners:
 * 1. IAnnotationTransformer ,
   2. IAnnotationTransformer2 ,
   3. IConfigurable ,
   4. IConfigurationListener ,
   5. IExecutionListener,
   6. IHookable ,
   7. IInvokedMethodListener ,
   8. IInvokedMethodListener2 ,
   9. IMethodInterceptor ,
   10. IReporter,
   11. ISuiteListener,
   12. ITestListener .
   
   
   ITestListener has following methods:

    OnStart- OnStart method is called when any Test starts.
    onTestSuccess- onTestSuccess method is called on the success of any Test.
    onTestFailure- onTestFailure method is called on the failure of any Test.
    onTestSkipped- onTestSkipped method is called on skipped of any Test.
    onTestFailedButWithinSuccessPercentage- method is called each time Test fails but is within success percentage.
    onFinish- onFinish method is called after all Tests are executed.
 * 
 * How to use Listeners
 * -- One way is this by using @Listeners annotation (commented to see second method)
 * -- Another way is by defining in the testngB11Listener2ndMethod.xml file
 */

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//-----------------One way is this by using @Listeners annotation-------------------- 
//@Listeners(S55_TestNG.B11_TC2TestNGCustomListeners.class)		// This parameter is used to call Custom listener class
public class B11_TC1TestNGListeners {
	
	
	@Test
	void test1()
	{
		System.out.println("This is test 1..............");
		Assert.assertEquals("A", "A");
	}
	
	
	@Test
	void test2()
	{
		System.out.println("This is test 2 ...............");
		Assert.assertEquals("A", "B");
	}
	
	
	@Test
	void test3()
	{
		System.out.println("This is test 3 ...............");
		throw new SkipException("This is skip exception.....");
	}
	

}
