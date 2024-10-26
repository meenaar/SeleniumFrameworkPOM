package com.automation.pages.base;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.base.BaseTest;
import com.automation.utility.Constants;
import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.PropertiesUtility;

public class BasePage {

	protected WebDriver driver;
	//private WebDriverWait wait = null;

	protected Logger mylog = LogManager.getLogger(BaseTest.class);
	protected ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();
	
	protected String username =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
	protected String password =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");
	protected String Account_Name =PropertiesUtility.readDataFromPropertyFile(Constants.CREATEACCOUNT_PROPERTIES,"Account_Name");
	protected String Type =PropertiesUtility.readDataFromPropertyFile(Constants.CREATEACCOUNT_PROPERTIES,"Type");
	protected String Customer_Priority =PropertiesUtility.readDataFromPropertyFile(Constants.CREATEACCOUNT_PROPERTIES,"Customer_Priority");

		public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterText(WebElement ele, String data, String objectName) {

		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			mylog.info("data is entered in the " + objectName);
			extentReportUtility.reportTestInfo("data is entered in the " + objectName);
		} else {
			mylog.error(objectName + " textbox is not diplayed");
			extentReportUtility.reportTestFailed(objectName + " textbox is not diplayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {

			ele.click();
			mylog.info(objectName + " is clicked");
			extentReportUtility.reportTestInfo(objectName + " is clicked");
		} else {
			mylog.error(objectName + " is not clicked");
			extentReportUtility.reportTestFailed(objectName + " is not clicked");
		}

	}
		
	public String getTextFromElement(WebElement ele, String objectName) {
		
		String data =null;
		if (ele.isDisplayed()) {	
			data = ele.getText();
			mylog.info("text is extracted from the " + objectName);
			extentReportUtility.reportTestInfo("text is extracted from the " + objectName);
		} else {
			mylog.error(objectName + " text is not extracted");
			extentReportUtility.reportTestFailed(objectName + " textbox is not extracted");
		}
		return data;
	}
	
	
	// ******************************* Select element reusable methods starts*****************************************
	
	public void selectElement(WebElement ele,String objectName) {
		if(!ele.isSelected()) {
			ele.click();
			mylog.info(objectName+" is selected");
			extentReportUtility.reportTestInfo(objectName+" is selected");
		}
		else{
			mylog.error(objectName+" is already selected");
			extentReportUtility.reportTestFailed(objectName+" is already selected");
		}
	}
	public void selectByValue (WebElement ele, String value) {
	
		Select select = new Select(ele);
		select.selectByValue(value);		
	}
	
	public void selectByVisibleText (WebElement ele, String value) {
		
		Select select = new Select(ele);
		select.selectByVisibleText(value);		
	}
	
	// ******************************* Select element reusable methods ends*****************************************
	
	
	
	// ******************************* Wait element reusable methods starts*****************************************
	
	public void waitForVisibility(WebElement ele, long timeInSec, String ObjectName) {
		
		mylog.info("Waiting for visibility of "+ ObjectName+" for maximum of "+ timeInSec+ "sec");
		
		extentReportUtility.reportTestInfo("Waiting for visibility of "+ ObjectName+" for maximum of "+ timeInSec+ "sec");
		
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void waitForAlertToPresent(long timeInSec, String ObjectName) {
		
		mylog.info("Waiting for visibility of "+ ObjectName+" for maximum of "+ timeInSec+ "sec");
		
		extentReportUtility.reportTestInfo("Waiting for visibility of "+ ObjectName+" for maximum of "+ timeInSec+ "sec");
	
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		
		wait.until(ExpectedConditions.alertIsPresent());		
	}
	
	public void waitForElementToBeClickable(WebElement ele, long timeInSec, String ObjectName) {
		
		mylog.info("Waiting for "+ ObjectName+" to be clickable for maximum of "+ timeInSec+ "sec");
		
		extentReportUtility.reportTestInfo("Waiting for "+ ObjectName+" to be clickable for maximum of "+ timeInSec+ "sec");
		
		
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		
		wait.until(ExpectedConditions.elementToBeClickable(ele));		
	}
	
	public void waitForViTextToBePresentInElement(WebElement ele, long timeInSec, String text, String ObjectName) {
		
		mylog.info("Waiting for visibility of "+ ObjectName+" for maximum of "+ timeInSec+ "sec");
		
		extentReportUtility.reportTestInfo("Waiting for visibility of "+ ObjectName+" for maximum of "+ timeInSec+ "sec");
		
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		
		wait.until(ExpectedConditions.textToBePresentInElement(ele, text));		
	}

	// ******************************* Wait element reusable methods ends*****************************************
	
	
	// *******************************Alert reusable methods starts*****************************************
	
	public Alert switchToAlert() {
		
		waitForAlertToPresent(30, "error loginalert box");
		Alert alert = driver.switchTo().alert();
		mylog.info("switched to an alert");
		return alert;
		
	}
	
	public String getAlertText(Alert alert, String objectName) {
		
		mylog.info("extracting text in the " + objectName + " alert");
		String text = alert.getText();
		mylog.info("text is extracted from alert box is==" + text);
		return text;
		
	}
	
	public void acceptAlert(Alert alert) {
		
		alert.accept();
		mylog.info("Alert Accepted");
	
	}
	
	public void cancelAlert(Alert alert) {
		
		alert.dismiss();
		mylog.info("Alert cancelled");
	
	}

	// *******************************Alert reusable methods ends*****************************************
	
	
	public void verifyDropDownListValues (List <WebElement> ele, String[] expectedList) {

		int matchCount=0;		
		if (ele.size() ==  expectedList.length)			
		{			
			for (WebElement options:ele) {
				
				mylog.info("dropdown values :"+ options.getText());
				extentReportUtility.reportTestInfo("dropdown values :"+ options.getText());
				
				for (int i=0; i<expectedList.length; i++) {	
					if (expectedList[i].equals(options.getText())) {					
						matchCount +=1;						
					}					
				}
			}
		}
		Assert.assertEquals(matchCount, expectedList.length);		
	}
	
}
