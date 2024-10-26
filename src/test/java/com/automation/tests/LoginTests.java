package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.pages.login.ForgotYourPwdPage;
import com.automation.base.BaseTest;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

@Listeners(com.automation.utility.SalesforceListenerUtility.class)

public class LoginTests extends BaseTest{
	
	protected String username =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
	protected String password =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");

	
	@Test
	public void TC1SalesforceLogin_BlankPwd() throws InterruptedException {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword("");
		
		mylog.info("login blank pwd test completed");
		extentReportUtility.reportTestInfo("login blank pwd test completed");
		
	}
	
	@Test
	public void TC2SalesforceLoginValid() throws InterruptedException {
	
		String expectedData = "Getting Started";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		driver = loginpage.clickLoginButton(driver);
		
		HomePage homepage = new HomePage(driver);
		String actualData = homepage.getTextFromHomePageHeader2text();
		
		Assert.assertEquals(actualData, expectedData);
		
		mylog.info("valid login test completed");
		extentReportUtility.reportTestInfo("valid login test completed");

	}
	@Test
	public void TC3ValidateRememberMe() throws InterruptedException {
		
		String expectedData = username;
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);	
		loginpage.clickRememberMeCheckbox();

		driver = loginpage.clickLoginButton(driver);
		
		HomePage homepage = new HomePage(driver);
		homepage.clickUserMenuEle();
		driver = homepage.clickLogoutLink(driver);
				
		loginpage.isLoginPage();
		String actualData = loginpage.getTextFromUserNameField();
		Assert.assertEquals(actualData, expectedData);
		
	}

	@Test
	public void TC4A_ForgotPassword() throws InterruptedException {
		
		String expectedTextMsg = "We’ve sent you an email with a link to finish resetting your password.";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickForgotPwdLink(driver);
		
		ForgotYourPwdPage forgotpage = new ForgotYourPwdPage(driver);
		forgotpage.enterUserNameForgotPwd(username);
		forgotpage.clickContinue(driver);
		String actualTextMsg = forgotpage.getTextFromCheckYourEmailEle();
			
		Assert.assertEquals(actualTextMsg, expectedTextMsg);

	}
	
	@Test
	public void TC4B_ValidateLoginErrorMsg() throws InterruptedException {
		
		String expectedError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName("123");
		loginpage.enterPassword("22131");
		loginpage.clickLoginButton(driver);
		String actualError = loginpage.getTextFromInvalidLoginErrorMsg();
		
		Assert.assertEquals(actualError, expectedError);
	
	}
		
}
