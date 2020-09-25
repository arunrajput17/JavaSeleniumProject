package S55_TestNG;
/*
 * - Dependency Tests in TestNG
 * 			This method will only execute if dependent method is passed otherwise skipped
 * 
 * - AlwaysRun property
 * 			This method will always execute even though the dependent method is failed
 */


import org.testng.Assert;
import org.testng.annotations.Test;

public class A5_TC1TestNGDependencyAlwaysRun {
	
	
	@Test
	void startCar()
	{
		System.out.println("Car Started....");
//		Assert.fail();
	}
	
	
	@Test(dependsOnMethods= {"startCar"})	//This method depends on startCar method passed
	void driveCar()
	{
		System.out.println("Car Driving....");
//		Assert.fail();
	}
	
	
	@Test(dependsOnMethods= {"driveCar"})	//This method depends on driveCar method passed
	void stopCar()
	{
		System.out.println("Car Stopped....");
		Assert.fail();
	}
	
	
	@Test(dependsOnMethods= {"driveCar","stopCar"}, alwaysRun=true)		//This method depends on both driveCar & stopCar method passed
	void parkCar()														// This method will always run even dependent are fail
	{
		System.out.println("Car Parked....");
	}

}
