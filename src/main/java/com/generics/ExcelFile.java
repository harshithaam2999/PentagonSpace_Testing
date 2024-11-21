package com.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFile
{
	public String toreadDataFromPropertyFile(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fs=new FileInputStream("src\\main\\java\\com\\generics\\ExcelFile.java");
		Workbook workbook=WorkbookFactory.create(fs);
		String testdata=workbook.getSheet(sheet).getRow(row).getCell(cell).toString();
		return testdata;
		
	
		
	}
}
