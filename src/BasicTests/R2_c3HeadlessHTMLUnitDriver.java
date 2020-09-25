package BasicTests;

// HTMLUnitDriver in Selenium
// HtmlUnitDriver is the built in headless browser in selenium, HtmlUnitDriver is present in
// org.openqa.selenium.htmlunit package

// Unlike Headless Firefox, Chrome, with HTMLUnitDriver we just need to create a object for the 
// class to create a headless browser

// HTMLUnit is completely developed using java.

// htmlunit-driver-2.42.0-jar-with-dependencies.jar
// htmlunit-driver-2.42.0.jar
// https://github.com/SeleniumHQ/htmlunit-driver/releases

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class R2_c3HeadlessHTMLUnitDriver {

	public static void main(String[] args) {
		
		HtmlUnitDriver driver = new HtmlUnitDriver();
		
		driver.get("http://demo.nopcommerce.com/");
		
		System.out.println("The title of the page is : "+ driver.getTitle());
		System.out.println("The current URL of the page is : "+ driver.getCurrentUrl());
		

	}

}
