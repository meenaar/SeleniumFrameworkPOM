package com.automation.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class AccountsCreateNewViewsPage extends BasePage{

	
	@FindBy(id="fname") WebElement viewNameEle;
	@FindBy(id="devname") WebElement viewUniNameEle;
	@FindBy(xpath=("//input[@type='submit' and @name='save']")) WebElement saveElement;
	
	
	public AccountsCreateNewViewsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterViewName(String viewName) {
		
		enterText(viewNameEle,viewName, "View Name ");
	}

	public void enterUniqueViewName() {
		
		enterText(viewUniNameEle,"uni12" , "View Unique Name ");
	}
	
	public WebDriver clickSaveOnNewViewAccount (WebDriver driver) {
		
		waitForVisibility(saveElement, 30, "Save Button");
		
		clickElement(saveElement, "Save Button");
		
		return driver;		
	}

}
