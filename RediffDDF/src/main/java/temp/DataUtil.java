package temp;

import java.util.HashMap;
import java.util.Map;

import com.qtpselenium.core.util.Xls_Reader;

public class DataUtil {

	public static void main(String[] args) {
		
		
		String path = System.getProperty("user.dir")+"//xls//Data.xlsx";
		Xls_Reader xls = new Xls_Reader(path);
		int rows = xls.getRowCount("Create Portfolio Test");
		int cols = xls.getColumnCount("Create Portfolio Test");
		System.out.println("Total rows "+rows);
		Object data[][] = new Object[rows][1];
		int index=0;
		Map<String,String> map=null;
		for(int rNum=2;rNum<=rows;rNum++) {
			System.out.println("Row Number --------- "+ rNum);
			// Step 1 -  Form a map and put data in the map
			map = new HashMap<String, String>();
			//put data in the map
		    for(int cNum=0;cNum<cols;cNum++) {
		    	String key=xls.getCellData("Create Portfolio Test", cNum, 1);
		    	String value=xls.getCellData("Create Portfolio Test", cNum, rNum);
		    	//System.out.println(key+" --- "+value);
		    	map.put(key, value);
		    }
		    // map is ready
		    System.out.println(map);
			// Step 2 -  Add the map in the Object array
		    data[index][0]=map;
		    index++;
		}

	}

}
