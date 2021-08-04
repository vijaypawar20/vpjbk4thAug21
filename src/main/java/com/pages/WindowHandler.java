package com.pages;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandler {
	WebDriver driver=null;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("file:///D:/Selenium%20Softwares/Offline%20Website/index.html");
		driver.get("file:///D:/Selenium%20Softwares/Offline%20Website/pages/examples/dashboard.html");
		
	}
	@Test
	public void handleWindows() throws InterruptedException{
	String mainwindow=driver.getWindowHandle();
	ArrayList<WebElement> childwindows=(ArrayList<WebElement>) driver.findElements(By.xpath("//a[@class='small-box-footer']"));
	for(WebElement e:childwindows){
		System.out.println("clicking all windows");
		e.click();
		Thread.sleep(300);
	}
	Set<String> child=driver.getWindowHandles();
	for(String s:child){
		System.out.println(driver.switchTo().window(s).getTitle());
		String cwtitle=driver.switchTo().window(s).getTitle();
		//if(s.contains(cwtitle))
			//driver.close();
	}
	
		
	}

}
