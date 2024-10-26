package com.automation.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

@Listeners(com.automation.utility.SalesforceListenerUtility.class)


public class UserMenuOptionsTests extends BaseTest{

	protected String username =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
	protected String password =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");

	
	@Test
	public void TC5_UserMenuDropDown () throws InterruptedException {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);	
		driver = loginpage.clickLoginButton(driver);
		
		HomePage homepage = new HomePage(driver);
		homepage.clickUserMenuEle();
		
		Thread.sleep(2000);
		
		String expMenuItems[]= {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
		
		List <WebElement> userMenuListEle = homepage.getUserMenuDropDownValues();		
		homepage.verifyDropDownListValues (userMenuListEle, expMenuItems);	
	}
	
	
	@Test
	public void TC9_LogoutSalesForce() throws InterruptedException {
	
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);	
		driver = loginpage.clickLoginButton(driver);
		
		HomePage homepage = new HomePage(driver);
		homepage.clickUserMenuEle();
		homepage.clickLogoutLink(driver);
	}
	
	
}
