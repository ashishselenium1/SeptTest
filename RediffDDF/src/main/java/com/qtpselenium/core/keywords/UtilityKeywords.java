package com.qtpselenium.core.keywords;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;
//generic, validation, utility , application dep

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qtpselenium.core.reports.ExtentManager;

public class UtilityKeywords {
	
	WebDriver driver;
	Properties prop;
	SoftAssert softAssert;
	ExtentReports rep;
	ExtentTest test;

	// central function to extract element
	// check the presence of element
	// check the visibility
	
	public WebElement getElement(String locatorKey) {
		//WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebDriverWait wait  = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		}catch(Exception e) {
			// not present/visible
			// Put the critical failure in reports
			reportFailure("Element not found "+ locatorKey,true);
		}
		
		
		WebElement e = driver.findElement(getLocator(locatorKey));
		return e;
	}
	
	public By getLocator(String locatorKey) {
		if(locatorKey.endsWith("_id"))
			return By.id(getProperty(locatorKey));
		else if(locatorKey.endsWith("_xpath"))
			return By.xpath(getProperty(locatorKey));
		else if(locatorKey.endsWith("_css"))
			return By.cssSelector(getProperty(locatorKey));
		else 
			return By.name(getProperty(locatorKey));
		
	}
	// stop - true  - stop the program after reporting failure
	// stop - false - report the failure but not stop the program
	public void reportFailure(String failureMsg, boolean stop) {
		// take the screenshot of the page and store in reports
		takeScreenShot();
		// report the failure
		test.log(Status.FAIL, failureMsg);// extent reports
		softAssert.fail(failureMsg);// testng
		if(stop)
			assertAll();
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	
	public void assertAll() {
		softAssert.assertAll();
	}
	
	public void flush() {
		rep.flush();
	}
	
	public void log(String message) {
		System.out.println(message);
		test.log(Status.INFO, message);
	}
	
	public void takeScreenShot() {
		// fileName of the screenshot
			Date d=new Date();
			String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
				// take screenshot
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try {
					// store screenshot in screenshots folder
					FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
					//put screenshot file in reports
				    test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void skip() {
		// skip in extent reports
		test.log(Status.SKIP, "Skipping test as Runmode is N");
		// skip in testng
		throw new SkipException("Skipping test as Runmode is N");
	}
	

}
