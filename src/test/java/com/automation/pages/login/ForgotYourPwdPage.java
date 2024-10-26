package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class ForgotYourPwdPage extends BasePage{
	
	@FindBy(xpath="//*[@id=\"un\"]") WebElement unameForgotPwdEle;
	@FindBy(name="continue") WebElement conTinueEle;
	@FindBy(xpath="//*[@id=\"forgotPassForm\"]/div/p[1]") WebElement msgElement;

	public ForgotYourPwdPage(WebDriver driver) {
		
		super(driver);
	}
	
	public void enterUserNameForgotPwd(String data) {
		
		enterText(unameForgotPwdEle, data, "username");
	}

	public WebDriver clickContinue (WebDriver driver) {
		
		clickElement (conTinueEle, "Continue button");
		
		return driver;
	}
	
	public String getTextFromCheckYourEmailEle() {
		
		waitForVisibility(msgElement, 30, "Check your email message");		
		String data= getTextFromElement(msgElement, "Check your email message");
		System.out.println("text on error msg-==="+data);
		return data;
		
	}
	
}
