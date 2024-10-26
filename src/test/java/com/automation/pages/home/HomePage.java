package com.automation.pages.home;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath="//h2[text()='Getting Started']") WebElement homePageHeader;
	@FindBy(xpath="//*[@id=\"userNav\"]") WebElement userMenuEle;
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a") List <WebElement> userMenuListEle;
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[5]") WebElement logoutLink;
	@FindBy(xpath="//*[@id=\"Account_Tab\"]/a") WebElement tabAccLinkEle;
	
	@FindBy(xpath="//*[@id=\"Opportunity_Tab\"]/a") WebElement tabOppLinkEle;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getTextFromHomePageHeader2text() {
		
		waitForViTextToBePresentInElement(homePageHeader, 60,"Getting Started","Getting Started Home page header");
		String data= getTextFromElement(homePageHeader, "Getting Started Home page header");
		System.out.println("text on home page==="+data);
		return data;
	}
	
	public void clickUserMenuEle () {
		
		waitForVisibility(userMenuEle, 30, "User Menu dropdown");
		
		clickElement(userMenuEle, "User Menu dropdown");
		
	}
	
	public WebDriver clickLogoutLink(WebDriver driver) {
		
		waitForVisibility(logoutLink, 30, "Logout option from user menu");
		
		clickElement(logoutLink, "Logout option from User Menu");
		
		return driver;
	}
	
	public List <WebElement> getUserMenuDropDownValues() {
		
		return userMenuListEle;
	
	}
	
	public WebDriver clickAccountTabLink(WebDriver driver) {
		
		waitForVisibility(tabAccLinkEle,30, "Accounts Tab");
		
		clickElement(tabAccLinkEle, "Accounts Tab");
		
		return driver;
	}
	
	public WebDriver clickOpportunityTabLink(WebDriver driver) {
		
		waitForVisibility(tabOppLinkEle,30, "Opportunity Tab");
		
		clickElement(tabOppLinkEle, "Opportunity Tab");
		
		return driver;
	}

}
