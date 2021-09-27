package com.qtpselenium.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class SimpleRunnerExample {

	public static void main(String[] args) {
	    List<XmlSuite> allSuites = new ArrayList<XmlSuite>();// all the suites
	    TestNG testNg = new TestNG();
	    testNg.setXmlSuites(allSuites);
		
	    XmlSuite suite =new XmlSuite();// 1 suite
	    suite.setName("Smoke Suite");
	    List<XmlTest> testCases = new ArrayList<XmlTest>();
	    suite.setTests(testCases);
	    
	    XmlTest test = new XmlTest(suite);// test case
	    test.setName("Create Portfolio Test");
	    
	    List<XmlClass> testClasses = new ArrayList<XmlClass>();
	    XmlClass xmlClass=  new XmlClass();
	    xmlClass.setName("testcases.suite.portfolio.CreatePortfolioTest");
	    testClasses.add(xmlClass);
	    
	    test.setXmlClasses(testClasses);
	    testCases.add(test);
	    allSuites.add(suite);
	    testNg.run();
	    // all test cases under suite
	    Map<String,String> testParameters;
	}

}
