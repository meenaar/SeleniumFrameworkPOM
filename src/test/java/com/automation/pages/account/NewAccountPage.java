package com.automation.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class NewAccountPage extends BasePage{

	
	@FindBy(id="acc2") WebElement accNameEle;
	@FindBy(xpath=("//*[@id=\"acc6\"]")) WebElement typeDropDownEle;	
	@FindBy(xpath=("//*[@id=\"00Nak000005IRi2\"]")) WebElement customerPriorityEle;
	@FindBy(name="save") WebElement saveElement;
	
	public NewAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void enterAccountName() {
		
		enterText(accNameEle, Account_Name, "Accounts Name text ");
	}

	public void selectTypeFromDropDown() {
		
		selectByValue (typeDropDownEle, Type);
	}
	
	public void selectCustomerPriorityFromDropDown() {
		
		selectByValue (customerPriorityEle, Customer_Priority);
	}

	public WebDriver clickSaveButton (WebDriver driver) {
		
		waitForElementToBeClickable(saveElement, 30, "Save Button");
		
		clickElement(saveElement, "Save Button");
		
		return driver;
	}
	

}
