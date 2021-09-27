package com.qtpselenium.core.dataproviders;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.qtpselenium.core.util.JSONDataUtil;
import com.qtpselenium.core.util.TestDataUtil;
import com.qtpselenium.core.util.Xls_Reader;

public class TestDataProviders {
	public static Xls_Reader profolioSuiteXLS = new Xls_Reader(System.getProperty("user.dir")+"//xls//Data.xlsx");
    public static String portfolio_suite_json=System.getProperty("user.dir")+"//json//portfolio_suite.json";
	
	  // Portfolio Suite
	  @DataProvider(name="portFolioSuite")
	  public static Object[][] portFolioSuite(ITestContext context) {
		  
		  String testName=context.getCurrentXmlTest().getName().split(" - ")[0];
		  System.out.println("Data Provider test name "+testName);
		  //return new TestDataUtil().getTestData(profolioSuiteXLS,"Data", testName);
		  return new JSONDataUtil().getTestData(portfolio_suite_json, testName);
	  }


}
