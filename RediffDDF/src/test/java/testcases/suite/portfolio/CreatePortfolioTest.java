package testcases.suite.portfolio;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.qtpselenium.core.dataproviders.TestDataProviders;
import com.qtpselenium.core.keywords.ApplicationKeywords;
import com.qtpselenium.core.util.TestDataUtil;

import com.qtpselenium.core.util.Xls_Reader;
// number of sheets
// Running the tests optionally
// Implementing multiple test suites
// browser

import testcases.base.TestBase;

public class CreatePortfolioTest extends TestBase{
	
	//@Test(dataProvider = "getData")
	@Test(dataProvider = "portFolioSuite", dataProviderClass = TestDataProviders.class)
	public void createPortFolio(ITestContext context,Map<String,String> data) throws InterruptedException {
		app.log(data.toString());
		if( new TestDataUtil().isSkip(testName, xls) || data.get("Runmode").equals("N") ) 
			app.skip();
		
		//app.openBrowser(data.get("Browser"));
		app.openBrowser((String)context.getCurrentXmlTest().getParameter("browser"));
		app.log("Opened the browser chrome. Navigating to the login page");
		// log - opening the browser Chrome
		app.navigate(app.getProperty("env")+"_url");
		app.defaultLogin();
		app.click("createportfolio_button_css");
		app.clear("portfolio_name_textbox_id");
		app.type("portfolio_name_textbox_id",data.get("PortfolioName"));
		app.click("submit_portfolio_button_id");
		app.takeScreenShot();
		app.assertAll();
		
		/*
		WebDriver  driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://portfolio.rediff.com/portfolio-login");
		// validate title
		String title = driver.getTitle();
		Assert.assertEquals(title, "Indian stock markets: Login to Portfolio");
		driver.findElement(By.id("useremail")).sendKeys("ashishthakur1983");
		driver.findElement(By.id("userpass")).sendKeys("pass@1234");
		driver.findElement(By.id("userpass")).sendKeys(Keys.ENTER);
		// validate if the present on the web page
		driver.findElement(By.id("createPortfolio")).click();
		driver.findElement(By.id("create")).clear();
		driver.findElement(By.id("create")).sendKeys("CoreFramework");
		driver.findElement(By.id("createPortfolioButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropDown = driver.findElement(By.id("portfolioid"));
		wait.until(ExpectedConditions.elementToBeClickable(dropDown));
		// 1 sec -  page starts refreshes -  wait till the page loads
		// wait for the page to load
		Thread.sleep(10000);
		Select s = new Select(dropDown);
		String selectedOption = s.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOption, "CoreFramework");
		*/
	}
	/*
	@DataProvider
	public Object[][] getData(){
		//return new TestDataUtil().getData(xls, testName);
		return new TestDataUtil().getTestData(xls,"Data", testName);
	}
	*/
	
		

}
