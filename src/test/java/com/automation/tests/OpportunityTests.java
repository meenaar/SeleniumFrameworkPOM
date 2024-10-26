package com.automation.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.pages.opportunities.OpportunityPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;


@Listeners(com.automation.utility.SalesforceListenerUtility.class)

@Test
public class OpportunityTests extends BaseTest{

	protected String username =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
	protected String password =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");
	
	public void TC15_VerifyOpportunitiesDropDown() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		driver = loginpage.clickLoginButton(driver);
						
		String[] expectedOppList = {"All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities","New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities", "Won"};
		
		
		HomePage homepage = new HomePage(driver);
		driver= homepage.clickOpportunityTabLink(driver);
				
		OpportunityPage opppage = new OpportunityPage(driver);
		opppage.clickOpportunityDropDownEle();
		
		opppage.verifyDropDownListValues (opppage.getOpportunityDropDownValues(), expectedOppList);
	}

}
