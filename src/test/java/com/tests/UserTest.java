package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.pages.UserPage;
import com.utils.ExcelUtil;
public class UserTest {
	UserPage up=new UserPage();
	WebDriver driver=null;
	ExcelUtil eu=new ExcelUtil();
	int row=1;
	@Test
	public void verifyuserbypoi(){
		
		up.readUserByPoi();
		
	}
	@Test
	public void writefromUsertoExcel() throws Exception{
		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Selenium%20Softwares/Offline%20Website/pages/examples/dashboard.html");
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		if(row==1){
		List<WebElement> headers=driver.findElements(By.xpath("//th"));
		for(WebElement header:headers){
			String text=header.getText();
			eu.writeexcel("test1.xlsx", "user1", text, 0, headers.indexOf(header));
		}
		row++;
	}

}}
