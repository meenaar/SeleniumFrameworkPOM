package com.automation.pages.login;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(id="username") WebElement usernameEle;
	@FindBy(id="password") WebElement pwdElement;
	@FindBy(id="Login") WebElement loginElement;
	@FindBy(xpath="//*[@id=\"error\"]") WebElement errorMsgEle;
	@FindBy(id="forgot_password_link") WebElement forgotPwdEle;
	@FindBy(xpath="//*[@id=\"rememberUn\"]") WebElement rememberMe;
	@FindBy(xpath="//*[@id=\"idcard-identity\"]") WebElement uNameRemembered;
	@FindBy(xpath="//*[@id=\"idcard-identity\"]") WebElement unameLoginPage;
			
			
	public LoginPage(WebDriver driver) {
		
		//PageFactory.initElements(driver, this);
		super(driver);
	}
	
	public void enterUserName(String data) {
		
		enterText(usernameEle, data, "username");
	}

	public void enterPassword (String data) {
		
		enterText(pwdElement, data, "password");
	}
	
	public WebDriver clickLoginButton (WebDriver driver) {
		
		clickElement (loginElement, "Login button");
		
		return driver;
	}
	
	public String getTextFromInvalidLoginErrorMsg() {
		
		waitForVisibility(errorMsgEle, 30, "Wrong password error message");		
		String data= getTextFromElement(errorMsgEle, "Invalid login error msg");
		System.out.println("text on error msg-==="+data);
		return data;
		
	}
	
	public void isLoginPage() throws InterruptedException {
		
		Thread.sleep(4000);
	
		if (uNameRemembered.isDisplayed())
		{
			mylog.info("login page displayed");
		}
		
	}
	
	public WebDriver clickForgotPwdLink(WebDriver driver) {
		
		waitForVisibility(forgotPwdEle, 30, "Forgot your password");
		
		clickElement(forgotPwdEle, "Forgot your password");
		
		return driver;
	}
	
	public void clickRememberMeCheckbox() {
		
		clickElement(rememberMe, "Remember Me checkbox ");
		
	}
	
	public String getTextFromUserNameField() {
	
		waitForViTextToBePresentInElement(uNameRemembered, 30, username, "username");
		String data = getTextFromElement(uNameRemembered, "Remembered user name");
		return data;
	}
	
}
