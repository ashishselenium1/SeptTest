package testcases.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qtpselenium.core.keywords.ApplicationKeywords;
import com.qtpselenium.core.util.Xls_Reader;
/*
1) Read the JSON Files
2) Read the data from JSON Files
3) How to have different test suites in testng.xml and running from maven
4) How to run testng programatically + JSON  ->  run tests on multiple browsers


1) Implement more tests and test suites
2) Run tests on grid and test suites
3) Run with Jenkins/GITHUB
*/
public class TestBase {
	public ApplicationKeywords app;
	public String testName;
	public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//xls//Data.xlsx");

	
	@BeforeTest
	public void befTest(ITestContext context) {
		System.out.println("@BeforeTest");
		testName=context.getCurrentXmlTest().getName();
		System.out.println("Test Name is "+testName);

	}
	
	@BeforeMethod
	public void init() {
		// prop file to be init
    	// init the reports
		app = new ApplicationKeywords(testName);	
			
	}
	
	
	@AfterMethod
	public void quit() {
		if(app!=null) {
			app.flush();
		}
	}
	
	@AfterTest
	public void endSession() {
		if(app!=null) 
		app.quit();
	}
}
