package temp;

import java.io.FileInputStream;
import java.util.Properties;

public class Readingprop {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username_textbox"));


	}

}
