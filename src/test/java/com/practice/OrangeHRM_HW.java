package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;

public class OrangeHRM_HW extends CommonMethods{

	Properties prop;

	@BeforeMethod
	public void setUp() {
		System.setProperty("Chrome", "https://opensource-demo.orangehrmlive.com");
	}
	
	
	@Test
	public void read()  {
		String filePath=System.getProperty("user.dir")+"/src/test/java/com/practice/OrangeHRM.properties";
		
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
		
		String userN=prop.getProperty("UserName");
		String pwd=prop.getProperty("Password");
	
		driver.findElement(By.id("txtUsername")).sendKeys(userN);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='OrangeHRM']")).isDisplayed(), "ORANGEHRM TEXT IS NOT DISPLAYED");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
