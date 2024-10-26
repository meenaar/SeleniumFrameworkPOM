package com.automation.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.pages.base.BasePage;

public class AccountsViewsPage extends BasePage{

	
@FindBy(xpath=("//select[@name='fcf']")) WebElement viewListDropDownEle;
	
	
	public AccountsViewsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getSelectedOptionValueFromViewDd() {
		
		Select select = new Select(viewListDropDownEle);		
		String data = select.getFirstSelectedOption().getText();
		return data;
	}

}
