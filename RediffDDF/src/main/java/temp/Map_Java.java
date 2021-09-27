package temp;

import java.util.HashMap;
import java.util.Map;



public class Map_Java {

	public static void main(String[] args) {
		Map<String,String> m = new HashMap<String,String>();
		m.put("key", "value");		
		m.put("username", "itsthakur");
		m.put("place", "India");
		System.out.println(m.get("username"));
		System.out.println(m.size());
				

	}

}
