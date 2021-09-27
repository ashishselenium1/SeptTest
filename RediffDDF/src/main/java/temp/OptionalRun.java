package temp;

import com.qtpselenium.core.util.Xls_Reader;

public class OptionalRun {

	public static void main(String[] args) {
		
		String testName="Create Portfolio Test";
		String path = System.getProperty("user.dir")+"//xls//Data.xlsx";
		Xls_Reader xls =new Xls_Reader(path);
		
		for(int i=2;i<=xls.getRowCount("TestCases");i++) {
			String testCase=xls.getCellData("TestCases", "Test Cases", i);
			if(testCase.equals(testName)) {
				String runmode = xls.getCellData("TestCases", "Runmode", i);
				System.out.println(runmode);
				break;
			}
		}
		
		
		

		
		
		
		
	}

}
