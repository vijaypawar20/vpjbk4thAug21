package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserPage {
	WebDriver driver=null;
	Workbook wb;
	FileInputStream fis=null;
	FileOutputStream fos=null;
	public String readExcel(String filename,String sheet,int row,int column){
		DataFormatter df=new DataFormatter();
		try {
			fis=new FileInputStream(filename);
			wb=WorkbookFactory.create(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sh=(Sheet) wb.getSheet(sheet);
		Cell cell=sh.getRow(row).getCell(column);
		return df.formatCellValue(cell);
		
	}
	public void writeExcel(){
		
		
	}
	
	public void readUserByPoi(){
		String uname=readExcel("jbkexcel.xls","login",0,0);
		String pass=readExcel("jbkexcel.xls","login",0,1);
		System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Selenium%20Softwares/Offline%20Website/index.html");
		
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(uname);
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("//span[text()='Users']")).click();;
	}
	
	}


