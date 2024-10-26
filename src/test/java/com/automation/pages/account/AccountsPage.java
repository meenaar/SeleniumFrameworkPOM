package com.automation.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class AccountsPage extends BasePage {

	@FindBy(name="new") WebElement newElement;
	@FindBy(xpath=("//a[text()='Create New View']")) WebElement createNewViewEle;
	
	public AccountsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	public WebDriver clickNewEleToCreateAccount (WebDriver driver) {
			
			waitForVisibility(newElement, 30, "New Button");
			
			clickElement(newElement, "New Button");
			
			return driver;			
	}
	
	public WebDriver clickCreateNewView (WebDriver driver) {
		
		waitForVisibility(createNewViewEle, 30, "Create New View link ");
		
		clickElement(createNewViewEle, "Create New View link ");
		
		return driver;
	}
}
