package com.qtpselenium.core.keywords;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericKeywords extends UtilityKeywords{

   public void openBrowser(String browserName) {
		log("Opening browser "+browserName);
		
		if(getProperty("gridRun").equals("N")) {
			if(browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Whizdom Trainings\\drivers\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browserName.equals("Mozilla"))
				driver=new FirefoxDriver();
			else if(browserName.equals("Edge"))
				driver=new EdgeDriver();
		}else {
			// all tests will reach here parallely
			// grid implementation - DesiredCapabilities
			DesiredCapabilities cap=new DesiredCapabilities();
			if(browserName.equals("Mozilla")){
				cap.setBrowserName("firefox");
				cap.setJavascriptEnabled(true);
				cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				
			}else if(browserName.equals("Chrome")){
				 cap.setBrowserName("chrome");
				 cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			}
			
			try {
				// hit the hub
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
			} catch (Exception e) {
			  e.printStackTrace();
			}
		}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	public void navigate(String urlKey) {
		log("Navigating to URL "+urlKey);
		driver.get(prop.getProperty(urlKey));
	}
	
	public void click(String locatorKey) {
		log("Clicking on "+locatorKey);
		getElement(locatorKey).click();
	}
	
	public void clear(String locatorKey) {
		log("Clearing textfield "+locatorKey);
		getElement(locatorKey).clear();
	}
	
	public void type(String locatorKey,String data) {
		log("Typing in textfield "+locatorKey+". Data "+data);
		getElement(locatorKey).sendKeys(data);
	}
	
	public void enter(String locatorKey, Keys key) {
		getElement(locatorKey).sendKeys(key);
	}
	
	public void quit() {
		if(driver!=null)
			driver.quit();
	}
}
