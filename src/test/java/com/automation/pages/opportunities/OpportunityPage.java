package com.automation.pages.opportunities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class OpportunityPage extends BasePage{
	
	
	@FindBy(xpath=("//*[@id='fcf']")) WebElement opportunityDdElem;
	@FindBy(xpath=("//*[@id='fcf']/option")) List<WebElement> oppMenuListEle;
	
	
	public OpportunityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void clickOpportunityDropDownEle () {
		
		waitForVisibility(opportunityDdElem, 30, "Opportunity Dropdown");
		
		clickElement(opportunityDdElem, "View Opportunity Dropdown");
		
	}
	
	public List <WebElement> getOpportunityDropDownValues() {		
		return oppMenuListEle;	
	}
	
	
	/*
	 * 		WebElement opportunityDdElem = driver.findElement(By.xpath("//*[@id='fcf']"));
		
		clickElement(opportunityDdElem, "View Opportunity Dropdown");
		
		List<WebElement> oppMenuListEle = driver.findElements(By.xpath("//*[@id='fcf']/option"));
		
		verifyDropDownListValues (oppMenuListEle, expectedOppList);
	 * 
	 * **/

}
