package com.qtpselenium.core.keywords;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ValidationKeywords extends GenericKeywords{

	public void verifyTitle(String expectedTitleKey,boolean stop) {
		String expectedTitle = getProperty(expectedTitleKey);
		if(!expectedTitle.equals(driver.getTitle()))
			reportFailure("Titles did not match", stop);
			
	}
	
	public void verifyElementPresent(String locatorKey,boolean stop) {
		if(!isElementPresent(locatorKey))
			reportFailure("Element not found "+ locatorKey, stop);
	}
	
	// presence as well as visibility
	public boolean isElementPresent(String locatorKey) {
		//WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebDriverWait wait  = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
