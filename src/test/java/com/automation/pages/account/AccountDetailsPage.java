package com.automation.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class AccountDetailsPage extends BasePage{

	@FindBy(className="topName") WebElement accName_Saved;
	@FindBy(xpath=("//*[@id=\"acc6_ileinner\"]")) WebElement typeSaved;
	@FindBy(xpath=("//*[@id=\"00Nak000005IRi2_ileinner\"]")) WebElement custPrioritySaved;
	
	public AccountDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getTextFromAccountNameField() {
		
		waitForViTextToBePresentInElement(accName_Saved, 30, Account_Name, "Account Name");
		String data = getTextFromElement(accName_Saved, "Entered Account Name");
		return data;
	}
	
	public String getSelectedValueFromTypeDropDown() {
		
		waitForViTextToBePresentInElement(typeSaved, 30, Type, "Type");
		String data = getTextFromElement(typeSaved, "Type");
		return data;
	}
	
	public String getSelectedValueFromCustomerPriorityDropDown() {
		
		waitForViTextToBePresentInElement(custPrioritySaved, 30, Customer_Priority, "Customer Priority");
		String data = getTextFromElement(custPrioritySaved, "Customer Priority");
		return data;
	}

	
	/**
	 * 		//extract displayed new Account Name to verify
			WebElement accName_Saved = driver.findElement(By.className("topName"));
			mylog.info("New Account Name is :" + accName_Saved.getText());
			
			//extract displayed new Account Type to verify
			WebElement typeSaved = driver.findElement(By.xpath("//*[@id=\"acc6_ileinner\"]"));
			mylog.info("Type is  : "+typeSaved.getText()); 
			
			//extract displayed Customer Priority to verify
			WebElement custPrioritySaved = driver.findElement(By.xpath("//*[@id=\"00Nak000005IRi2_ileinner\"]"));
			mylog.info("Customer Priority is  : "+custPrioritySaved.getText()); 
		
	 * 
	 * */

	
}

