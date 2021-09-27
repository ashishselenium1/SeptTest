package com.qtpselenium.core.keywords;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.core.reports.ExtentManager;

public class ApplicationKeywords extends ValidationKeywords{
	
	public ApplicationKeywords(String testName) {
		// init the prop file
		prop = new Properties();
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// init the soft assert
		softAssert = new SoftAssert();
		// init the reports
		rep = ExtentManager.getReport(System.getProperty("user.dir")+"\\reports\\");
		test = rep.createTest(testName);
		
		
	}

    public void defaultLogin() {
    	log("Log in with default ID");
		//verifyTitle("login_page_title",false);
		//Assert.assertTrue(app.verifyTitle("login_page_title"), "Titles did not match");
		type("username_textbox_xpath",getProperty(getProperty("env")+"_app_username"));
		type("password_textbox_id", getProperty(getProperty("env")+"_app_password"));
		enter("password_textbox_id", Keys.ENTER);
		//Assert.assertTrue(app.isElementPresent("createportfolio_button_css"), "Element not found - createportfolio_button_css");
		verifyElementPresent("createportfolio_button_css",true);
		log("Login Success");
	}
    
    
    public void buyStock() {
    	
    }

	
}
