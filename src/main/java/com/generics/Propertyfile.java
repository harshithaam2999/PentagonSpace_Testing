package com.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertyfile
{
	public String toreadDataFromPropertyFile(String value) throws IOException 
	{
		FileInputStream fs=new FileInputStream("src\\main\\java\\com\\generics\\Properties.java");
		Properties prop=new Properties();
		prop.load(fs);
		String URL=prop.getProperty("url");
		String BROWSER=prop.getProperty("browser");
		return value;
	
		
		
	}
}
