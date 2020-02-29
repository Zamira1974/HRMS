package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class MyPropFileReading {
	Properties prop;
	
	@Test
	public void read()  {
		String filePath=System.getProperty("user.dir")+"/src/test/java/com/practice/MyPropFile.properties";
		
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String value1=prop.getProperty("userName");
		System.out.println(value1);
		
		String value2=prop.getProperty("password");
		System.out.println(value2);
		
		String value3=prop.getProperty("address");
		System.out.println(value3);
		
	}
}
