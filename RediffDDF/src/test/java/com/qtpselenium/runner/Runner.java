package com.qtpselenium.runner;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		TestNGRunner testNG = new TestNGRunner(1);
		testNG.createSuite("Smoke Suite", false);
		
		testNG.addTest("Create Portfolio Test");
		testNG.addTestParameter("browser", "Chrome");
		List<String> includedMethods = new ArrayList<String>();
		testNG.addTestClass("testcases.suite.portfolio.CreatePortfolioTest", includedMethods);


		testNG.addTest("Add Stock Test");
		includedMethods = new ArrayList<String>();
		testNG.addTestClass("testcases.suite.stock.AddStockTest", includedMethods);

		testNG.run();

	}

}
