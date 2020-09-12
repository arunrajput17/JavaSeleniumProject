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
 */

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class B11_TC2TestNGCustomListeners implements ITestListener{
	
	//This belongs to ITestListener and will execute before starting of Test set/batch
	public void onStart(ITestContext arg) 
	{
		System.out.println("Starts test execution.........."+ arg.getName());		
	}
	
	
	//This belongs to ITestListener and will execute after completion of Test set/batch
	public void onFinish(ITestContext arg) 
	{
		System.out.println("Finish test execution.........."+ arg.getName());		
	}
	
	
	//This belongs to ITestListener and will execute before the main Test i.e. @Test
	public void onTestStart(ITestResult arg) 
	{
		System.out.println("Starts test .........."+ arg.getName());	
	}
	

	//This belongs to ITestListener and will execute when a Test is skipped
	public void onTestSkipped(ITestResult arg) 
	{
		System.out.println("Skipped test .........."+ arg.getName());
	}
	
	
	//This belongs to ITestListener and will execute when a Test is Passed
	public void onTestSuccess(ITestResult arg) 
	{
		System.out.println("Passed test .........."+ arg.getName());
	}
	
	
	//This belongs to ITestListener and will execute when a Test is failed
	public void onTestFailure(ITestResult arg) 
	{
		System.out.println("Failed test .........."+ arg.getName());
	}
	
	
	
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


}
