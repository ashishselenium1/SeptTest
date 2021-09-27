package temp;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONDataUtil {
	
	
	public Object[][] getTestData(String jsonFilePath,String testName)  {
		//String path=System.getProperty("user.dir")+"//json//portfolio_suite.json";
		//String testName="Create Portfolio Test";
		Object[][] data=null;
		try {
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(new FileReader(jsonFilePath));
			JSONArray testCases = (JSONArray)json.get("testcases");
			for(int tcid=0;tcid<testCases.size();tcid++){
				JSONObject testCase = (JSONObject)testCases.get(tcid);
				String name = (String)testCase.get("testname");
				if(name.equals(testName)) {
				    System.out.println(name);
				    System.out.println(testCase);
				    JSONArray datasets = (JSONArray)testCase.get("testdatasets");
				    data = new Object[datasets.size()][1];
				    HashMap<String,String> map = null;
				    for(int dSetId=0;dSetId<datasets.size();dSetId++) {// new row of data
				    	map = new HashMap<String,String>();
				    	JSONObject testDataSet = (JSONObject)datasets.get(dSetId);
				    	//System.out.println(testDataSet);
				    	JSONArray testData = (JSONArray)testDataSet.get("data");
				    	System.out.println(testData);
				    	
				    	for(int dId=0;dId<testData.size();dId++) {
				    		JSONObject tData = (JSONObject)testData.get(dId);
				    		String key = (String)tData.get("parametername");
				    		String value = (String)tData.get("parametervalue");
				    		System.out.println(key+" ---- "+value);
				    		map.put(key, value);
				    	}
				    	System.out.println(map);
				    	data[dSetId][0]=map;
				    	System.out.println("----------------");
				    }
				}	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return data;
	}
	// true - N
	// false - Y
	
	public boolean isSkip(String path, String testName) {
		return false;
	}

}
