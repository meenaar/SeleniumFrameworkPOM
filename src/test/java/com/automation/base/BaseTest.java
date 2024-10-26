package com.automation.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.utility.Constants;
import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.PropertiesUtility;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver = null;
	//private WebDriverWait wait = null;
	
	protected Logger mylog = LogManager.getLogger(BaseTest.class);
	protected ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();
	
	
	@BeforeMethod
	@Parameters ("browsername")
	public void setUpBeforeMethod(@Optional ("chrome") String name) throws InterruptedException {
		
		mylog.info("*******************setUpBeforeMethod*********************");
		launchBrowser(name);
		String url =PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"url");
		gotoUrl(url);
	}
	
	@AfterMethod 
	public void tearDownAfterMethod() {
	
		closeDriver();	
		mylog.info("*******************tearDownAfterTestMethod*********************");
	
	}
		
	public static void launchBrowser (String browserName) {		
	
		switch (browserName.toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default: 
			break;
		}
	}
	
	public static void gotoUrl(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);		
	}
	
	public static void closeDriver() {
		driver.close();
	}
	
	public void takeScreenshot(String filepath) {
		
		TakesScreenshot screenCapture=(TakesScreenshot)driver;
		File src= screenCapture.getScreenshotAs(OutputType.FILE);
		File destFile=new File(filepath);
		
		try {
			Files.copy(src, destFile);
			mylog.info("screen captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mylog.error("problem occured during screenshot taking");
		}
		
	}
	
	
	
	
}
