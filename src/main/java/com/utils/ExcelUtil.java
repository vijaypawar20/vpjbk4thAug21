package com.utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	FileInputStream fis=null;
	FileOutputStream fos=null;
	Workbook wb=null;
	public void writeexcel(String filename,String sheet,String data,int row,int col){
				try {
					fis=new FileInputStream(filename);
					wb=WorkbookFactory.create(fis);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
			if(wb.getSheet(sheet)==null)
				wb.createSheet(sheet);
		Sheet sh=wb.getSheet(sheet);
		if(sh.getRow(row)==null)
			{
			sh.createRow(row);
			}
		if(sh.getRow(row).getCell(col)==null){
			sh.getRow(row).createCell(col);
		}
		sh.getRow(row).getCell(col).setCellValue(data);
		try{
			fos=new FileOutputStream(filename);
		wb.write(fos);
		wb.close();
		fos.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		}
		
		
		
	}


