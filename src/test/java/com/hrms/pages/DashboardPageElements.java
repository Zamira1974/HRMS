package com.hrms.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{

	@FindBy(linkText = "Leave")
	public WebElement leaveLnk;

	@FindBy(linkText = "Leave List")
	public WebElement leaveList;

	@FindBy(linkText = "PIM")
	public WebElement pimLnk;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;
	
	@FindBy(id="firstName")
	public WebElement firstN;
	
	@FindBy(id="middleName")
	public WebElement middleN;
	
	@FindBy(id="lastName")
	public WebElement lastN;
	
	@FindBy(id="employeeId")
	public WebElement empId;
	
	@FindBy(id="btnSave")
	public WebElement SaveBtn;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement empAddedName;
	
	@FindBy (xpath="//*[@id='welcome']")
	public WebElement welcomeLnk;

	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void navigateToLeaveList() {
		jsClick(leaveLnk);
		jsClick(leaveList);
	}
	
	public void navigateToAddEmployee() {
		jsClick(pimLnk);
		jsClick(addEmp);
	}
}	
	
