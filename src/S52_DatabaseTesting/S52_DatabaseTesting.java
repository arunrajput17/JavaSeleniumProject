package S52_DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 1) Create Connection
// 2) Create Statement
// 3) Execute statement
// 4) Close connection

public class S52_DatabaseTesting {

	public static void main(String[] args) throws SQLException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Day Shift\\Selenium_Prequisites\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/");
		
		
		// 1) Create a Connection
		
		//Oracle database connection
//		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pdborc1","hr","hr");
		
		// SQL Connection
		Connection con = DriverManager.getConnection("jdbc:sqlserver://ACROLAP32\\SQLEXPRESS:1433; databaseName=sample; user=sa;password=acro");
		
		
		// 2) Create a query/statement
		Statement stmt = con.createStatement();
		
		System.out.println("Start");
//		String r="insert into tblEmployee values ('Carlos','Male',1000,'Italy',1)";
//		String r = "update tblEmployee set Gender='Female' where Name='Carlos'";
//		String r = "delete tblEmployee where Name='Carlos'";
		
//		String s = "select ID, Name, Gender  from tblEmployee";	// select query is two way

		
		
		// 3) execute statement/query
//		stmt.execute(r);	// use this with insert, update, delete
		
//		ResultSet rs = stmt.executeQuery(s); 	// use this with select query
//		
//		while (rs.next())
//		{
//			int eid=rs.getInt("ID");
//			String ename=rs.getString("Name");
//			String egender=rs.getString("Gender");
//			
//			
//			System.out.println(eid+"      "+ename+"       "+egender);
//		}
		
		
		// Testing login through database values
		
		String loginDataset = "Select username, password from tblUsers";
		
		ResultSet ld = stmt.executeQuery(loginDataset);
		
		while (ld.next())
		{
			String uname = ld.getString("username");
			String pswd = ld.getString("password");
			
//			System.out.println(uname +"    "+ pswd);
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(pswd);
			driver.findElement(By.name("submit")).click();
			
			if (driver.getTitle().equals("Login: Mercury Tours"))
			{
				System.out.println("Test case is passed");
			}
			else
			{
				System.out.println("Test case is Failed");
			}
			driver.findElement(By.linkText("Home")).click();
		}
		driver.close();
		
		
		// 4) Close connection
		con.close();
		
		System.out.println("Program is completed");
		
	}

}
