package Build001;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Generic_Utils_Excel.ExcelUtils;
import com.PomPages.Flight;

public class makemytrip {

WebDriver driver;
	
	@BeforeSuite
	public void SetupSuite()
	{
		
		System.out.println("setting up test suite");
	}
	
	
	@BeforeTest
	public void opens_Browser()
	{
		//opening browser
		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		if(driver !=null)
		{
			
			System.out.println("Browser opened succesfully");
		}
		
	}
	
	
	@BeforeClass
	public void pageloading() throws Throwable
	{
		//loading the page
		ExcelUtils ex=new ExcelUtils();
		
		driver.get(ex.getcelldata("Sheet1",1,0));
		
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		String expected="MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		
		String Actual=driver.getTitle();
		
		Assert.assertEquals(Actual, expected,"Login page not loaded succesfully");
	}
	@DataProvider(name="location")
	public Object[][] sathvika()
	{
		Object[][] arr= {
				{"hyd","del"}
		};
		return arr;
	}
	@Test(priority=1, dataProvider="location")
	public void booking(String from,String to) throws InterruptedException
	{
		Flight f=new Flight(driver);
		f.bookflight(from,to);
	}
	@AfterMethod
	public void loggingout()
	{
		driver.manage().window().minimize();
	}
	
	@AfterClass
	public void pagecleanup()
	{
		driver.manage().deleteAllCookies();
		System.out.println("All cookies deleted Succesfully");
	}
	
	@AfterTest
	public void closing_browser()
	{
		if(driver !=null)
		{
			driver.quit();
			System.out.println("Firefox Browser closed succesfully");
		}
	}
	
	@AfterSuite
	public void ClosingSuite()
	{
		System.out.println("Closing test suite");
	}
}
