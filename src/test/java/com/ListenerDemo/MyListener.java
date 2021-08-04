package com.ListenerDemo;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{

WebDriver driver;
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test is failed"+result.getName());
	DemoTest.takeScreenshot(result.getName());
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	public void onFinish(ITestContext context) {
		System.out.println("after testcase run "+context.getPassedTests());
		System.out.println("after testcase run "+context.getFailedTests());
	}


	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	public void onStart(ITestContext context) {
		System.out.println("All tests are ready to run "+context.getOutputDirectory());
	}


	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped and test name is "+result.getName());
		
	}

	
	public void onTestStart(ITestResult result) {
		System.out.println("Test is started and name is== "+result.getName());
	
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test executed successfully and test name is "+result.getName());
		
	}

}
