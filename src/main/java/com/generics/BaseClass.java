package com.generics;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	public WebDriver driver=null;
	Propertyfile p = new Propertyfile();
	WebDriverUtility w = new WebDriverUtility();
	
	@BeforeSuite
	public void beforesuiteconfi() {
		Reporter.log("Database connection started",true);
	}
	
	@AfterSuite
	public void aftersuiteconfi() {
		Reporter.log("Database connection flushed out",true);
	}
	
	@BeforeClass
	public void ToLaunchBrowser() throws IOException {
		String BROWSER=p.toreadDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			Reporter.log("Browser is launched",true);
			
			w.toMaximize(driver);
			Reporter.log("Browser is maximized",true);
			w.wait_tillpageloads(driver);
		}
			
	}
	@BeforeMethod
	public void NavigateToURL() throws IOException {
		String URL=p.toreadDataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("Browser is navigated to application",true);
		
	}
	
	@AfterMethod
	public void TocloseBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void aftersuiteconfi1() {
		Reporter.log("Database connection flushed out or removed",true);
	}
	
	
	
	
}
