package temp;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingJSON {

	public static void main(String[] args) {
        
        try {
        	JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir")+"//student.json"));
			System.out.println(json);
			String name =(String) json.get("name");
			System.out.println(name);
			String college =(String) json.get("college");
			System.out.println(college);
			JSONArray subject =(JSONArray) json.get("subject");
			System.out.println(subject);
			JSONArray scores =(JSONArray) json.get("scores");
			System.out.println(scores);
			
			for(int i=0;i<scores.size();i++) {
				JSONObject studentScore = (JSONObject)scores.get(i);
				System.out.println(studentScore);
				String subjectname =(String) studentScore.get("subjectname");
				String score =(String) studentScore.get("score");
				System.out.println(subjectname+" ---> "+score);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
