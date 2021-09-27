package com.qtpselenium.runner;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONRunner {

	public static void main(String[] args) {
		// read the json and to invoke TestNGRunner
		
		try {
			TestNGRunner testNG = new TestNGRunner(1);
			String jsonFilePath = System.getProperty("user.dir")+"//runners//smoke_suite.json";
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(new FileReader(jsonFilePath));
			JSONObject testSuite = (JSONObject)json.get("testsuite");
			String name = (String)testSuite.get("name");
			testNG.createSuite(name, false);

			JSONArray browsers = (JSONArray)testSuite.get("browsers");
			System.out.println(name);
			System.out.println(browsers);
			for(int bId=0;bId<browsers.size();bId++) {
				JSONArray testCases = (JSONArray)testSuite.get("testcases");
				String browser = (String)browsers.get(bId);
				System.out.println("--------------browser "+browser);
				for(int tcID=0;tcID<testCases.size();tcID++) {
					JSONObject testCase = (JSONObject)testCases.get(tcID);
					String testName = (String)testCase.get("testname")+" - "+ browser;
					String className = (String)testCase.get("classname");
					System.out.println(testName +" --- "+ className);
					testNG.addTest(testName);
					testNG.addTestParameter("browser", browser);
					List<String> includedMethods = new ArrayList<String>();
					testNG.addTestClass(className, includedMethods);
				}
			}
			
			testNG.run();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
