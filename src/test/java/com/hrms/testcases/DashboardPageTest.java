package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class DashboardPageTest extends CommonMethods{
	//Test case to validate 'Welcome Admin' element
	
	@Test (groups="regression1")
	public void welcome() {
		LoginPage login = new LoginPage();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		//verify if 'Welcome Admin' is presented
	
		DashboardPageElements dB=new DashboardPageElements();
		dB.welcomeLnk.isDisplayed();
		String expected="Welcome Admin";
		Assert.assertEquals(dB.welcomeLnk.getText(), expected);
	}
	
		@Test (groups="regression1")	
		public void validationEmpHasAdded() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		
		login.login("Admin", "Syntax@123");
		jsClick(dashboard.pimLnk);
		jsClick(dashboard.addEmp);
		sendText(dashboard.firstN, "DeRamirus");
		sendText(dashboard.middleN, "Jr");
		sendText(dashboard.lastN, "Ostap");
		jsClick(dashboard.SaveBtn);
		Assert.assertTrue(dashboard.empAddedName.isDisplayed(), "Employee name is NOT displayed");
	}	
}


