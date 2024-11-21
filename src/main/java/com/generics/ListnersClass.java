package com.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersClass implements ITestListener
{ 
	
    public WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
	    System.out.println(MethodName+"--start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
	    System.out.println(MethodName+"--sucess");
		
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName +"--Failure");
		WebDriverUtility w = new WebDriverUtility();
		JavaUtility j = new JavaUtility();
		String screenshot = MethodName+j.toFetchDateAndTime();
		try {
			w.toperformScreenshotOnWebpage(driver,screenshot);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
	    System.out.println(MethodName+"skipped");
		
	
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution started");
				
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution Completed");
		
	}
       
}