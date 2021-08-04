package com.ListenerDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(MyListener.class)
public class DemoTest {
	public static WebDriver driver;
	public static void takeScreenshot(String name){
		SimpleDateFormat df=new SimpleDateFormat("ddMMyyyyhhmmss");
		String date=df.format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)DemoTest.driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"/Screenshot/"+name+date+".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//
//	@Test
//	public void testcase01()
//	{
//		System.out.println("hello world TC pass");
//		Assert.assertEquals(true, true);
//	}
//	
//	@Test
//	public void testcase02()
//	{
//		System.out.println("hello world TC failed");
//		Assert.assertEquals(true, false);
//	}
	
//	@Test
//	public void testcase03()
//	{
//		System.out.println("hello world TC skipped");
//		throw new SkipException("TC skip");
//	}
	public static Logger log=Logger.getLogger(DemoTest.class);
	@Test
	public void screenShot(){
			
		log.info("Hello..opening browser with title");
		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Selenium%20Softwares/Offline%20Website/index.html");
		
		
		WebElement uname=driver.findElement(By.xpath("//*[@id=\"email\"]"));
			uname.sendKeys("kiran@gmail.com");
			WebElement pass=driver.findElement(By.xpath("//*[@id=\"password\"]"));
			pass.sendKeys("123456");
			WebElement button=driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
			button.click();
			String aclMsg=driver.getTitle();
			System.out.println("Check actual title of next page"+aclMsg);
			String expMsg="JavaByKiran | Dashboard";
			log.info("verifying title..");
			
			Assert.assertEquals(aclMsg, expMsg);
		}
	@Test
	public void screen(){
		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Selenium%20Softwares/Offline%20Website/index.html");
		
		
		WebElement uname=driver.findElement(By.xpath("//*[@id=\"email\"]"));
			uname.sendKeys("kiran@gmail.com");
			WebElement pass=driver.findElement(By.xpath("//*[@id=\"password\"]"));
			pass.sendKeys("123456");
			WebElement button=driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
			button.click();
			String aclMsg=driver.getTitle();
			System.out.println("Check actual title of next page"+aclMsg);
			String expMsg="JavaByKiran | Log in";
			
			Assert.assertEquals(aclMsg, expMsg);
	}
	}


