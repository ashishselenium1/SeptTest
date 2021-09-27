package testcases.suite.portfolio;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.core.dataproviders.TestDataProviders;
import com.qtpselenium.core.keywords.ApplicationKeywords;
import com.qtpselenium.core.util.TestDataUtil;
import com.qtpselenium.core.util.Xls_Reader;

import testcases.base.TestBase;

public class DeletePortfolioTest extends TestBase{
	
	@Test(dataProvider = "portFolioSuite", dataProviderClass = TestDataProviders.class)
	public void deletePortFolio(ITestContext context,Map<String,String> data) throws InterruptedException {
		app.log(data.toString());
		if( new TestDataUtil().isSkip(testName, xls) || data.get("Runmode").equals("N") ) 
			app.skip();
		
		//app.openBrowser(data.get("Browser"));
		app.openBrowser((String)context.getCurrentXmlTest().getParameter("browser"));
		app.log("Opened the browser chrome. Navigating to the login page");
		// log - opening the browser Chrome
		app.navigate(app.getProperty("env")+"_url");
		app.defaultLogin();
     	app.assertAll();
	}
	/*
	@DataProvider
	public Object[][] getData(){
		return new TestDataUtil().getTestData(xls,"Data", testName);
	}
	*/
}
