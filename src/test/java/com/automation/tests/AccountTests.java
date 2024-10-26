package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.account.AccountDetailsPage;
import com.automation.pages.account.AccountsCreateNewViewsPage;
import com.automation.pages.account.AccountsPage;
import com.automation.pages.account.AccountsViewsPage;
import com.automation.pages.account.NewAccountPage;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

@Listeners(com.automation.utility.SalesforceListenerUtility.class)

public class AccountTests extends BaseTest{
	
	
	protected String username =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
	protected String password =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");
	protected String Account_Name =PropertiesUtility.readDataFromPropertyFile(Constants.CREATEACCOUNT_PROPERTIES,"Account_Name");
	protected String Type =PropertiesUtility.readDataFromPropertyFile(Constants.CREATEACCOUNT_PROPERTIES,"Type");
	protected String Customer_Priority =PropertiesUtility.readDataFromPropertyFile(Constants.CREATEACCOUNT_PROPERTIES,"Customer_Priority");

	@Test	
	public void TC10_CreateAccount() throws InterruptedException {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		driver = loginpage.clickLoginButton(driver);
		
		HomePage homepage = new HomePage(driver);
		driver= homepage.clickAccountTabLink(driver);
		
		AccountsPage accpage = new AccountsPage(driver);
		driver = accpage.clickNewEleToCreateAccount(driver);
				
		NewAccountPage newaccpage = new NewAccountPage(driver);
		newaccpage.enterAccountName();
		newaccpage.selectTypeFromDropDown();
		newaccpage.selectCustomerPriorityFromDropDown();
		driver = newaccpage.clickSaveButton(driver);
		
		AccountDetailsPage accdetailpage = new AccountDetailsPage(driver);
		String actualAccName = accdetailpage.getTextFromAccountNameField();
		String actualType = accdetailpage.getSelectedValueFromTypeDropDown();
		String actualCustPri = accdetailpage.getSelectedValueFromCustomerPriorityDropDown();
		
		Assert.assertEquals(Account_Name, actualAccName);
		Assert.assertEquals(Type, actualType);
		Assert.assertEquals(Customer_Priority, actualCustPri);

	}

	@Test
	public void TC11Accounts_CreateNewView() {
		
		String viewName = "v10";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		driver = loginpage.clickLoginButton(driver);
		
		HomePage homepage = new HomePage(driver);
		driver= homepage.clickAccountTabLink(driver);
				
		AccountsPage accpage = new AccountsPage(driver);
		driver = accpage.clickCreateNewView(driver);
		
		AccountsCreateNewViewsPage accNewViewpage = new AccountsCreateNewViewsPage(driver);
		
		accNewViewpage.enterViewName(viewName);
		accNewViewpage.enterUniqueViewName();
		String actualCreatedView="";
	
		driver = accNewViewpage.clickSaveOnNewViewAccount(driver);
		AccountsViewsPage createdviewpage = new AccountsViewsPage(driver);
		actualCreatedView = createdviewpage.getSelectedOptionValueFromViewDd();
		
		Assert.assertEquals(viewName, actualCreatedView);
	}
}
