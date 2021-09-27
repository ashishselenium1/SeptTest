package com.qtpselenium.core.util;

import java.util.HashMap;
import java.util.Map;

public class TestDataUtil {
	
	public Object[][] getData(Xls_Reader xls,String sheetName){
		
		int rows = xls.getRowCount(sheetName);
		int cols = xls.getColumnCount(sheetName);
		System.out.println("Total rows "+rows);
		Object data[][] = new Object[rows-1][1];
		int index=0;
		Map<String,String> map=null;
		for(int rNum=2;rNum<=rows;rNum++) {
			System.out.println("Row Number --------- "+ rNum);
			// Step 1 -  Form a map and put data in the map
			map = new HashMap<String, String>();
			//put data in the map
		    for(int cNum=0;cNum<cols;cNum++) {
		    	String key=xls.getCellData(sheetName, cNum, 1);
		    	String value=xls.getCellData(sheetName, cNum, rNum);
		    	//System.out.println(key+" --- "+value);
		    	map.put(key, value);
		    }
		    // map is ready
		    System.out.println(map);
			// Step 2 -  Add the map in the Object array
		    data[index][0]=map;
		    index++;
		}
		return data;
	}
	
	public Object[][]  getTestData(Xls_Reader xls,String sheetName,String testName) {
		//String path = System.getProperty("user.dir")+"//xls//Data.xlsx";
		//Xls_Reader xls = new Xls_Reader(path);
		//String testName="Delete Portfolio Test";
		//String sheetName="Data";
		// find the row num on which test is lying
		int testStartRowNum=1;
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testName)) {
			testStartRowNum++;
		}
		
		System.out.println("Test starts from row number "+ testStartRowNum);
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		// find total rows in the test
		int totalRows = 0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+totalRows).equals("")) {
			totalRows++;
		}
		System.out.println("Total rows are "+totalRows );
		// find total cols in the test
		int totalCols=0;
		while(!xls.getCellData(sheetName, totalCols, colStartRowNum).equals("")) {
			totalCols++;
		}
		System.out.println("Total cols are "+totalCols );
		Object data[][] = new Object[totalRows][1];
		int index=0;
		// put the data in map and put map in Object[][]
		Map<String,String> map=null;

		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+totalRows;rNum++) {
			System.out.println("------");
			map = new HashMap<String, String>();
			for(int cNum=0;cNum<totalCols;cNum++) {
				String key = xls.getCellData(sheetName, cNum, colStartRowNum);
				String value = xls.getCellData(sheetName, cNum, rNum);
				System.out.println(key+"---"+value);
				map.put(key, value);
			}
			System.out.println(map);
			data[index][0]=map;
			index++;
		}
		
		return data;
		
	}
	// true  - N
	// false - Y
	public boolean isSkip(String testName,Xls_Reader xls) {
		for(int i=2;i<=xls.getRowCount("TestCases");i++) {
			String testCase=xls.getCellData("TestCases", "Test Cases", i);
			if(testCase.equals(testName)) {
				String runmode = xls.getCellData("TestCases", "Runmode", i);
				if(runmode.equals("Y"))
					return false;
				else
					return true;
			}
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	

}
