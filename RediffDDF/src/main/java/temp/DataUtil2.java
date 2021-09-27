package temp;

import java.util.HashMap;
import java.util.Map;

import com.qtpselenium.core.util.Xls_Reader;

public class DataUtil2 {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir")+"//xls//Data.xlsx";
		Xls_Reader xls = new Xls_Reader(path);
		String testName="Delete Portfolio Test";
		String sheetName="Data";
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
		
		
		

	}

}
