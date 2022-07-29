package Mytests;

import java.io.FileReader;
import java.io.IOException;
import org.testng.annotations.Test;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
public class TestVagrant {
  @Test
  public void f() throws IOException, ParseException {
	  int foreigncount=0;
	  int wicketkeeprcount=0;
	  JSONParser jp=new JSONParser();   								//creating the JSON Parser obejct to parse/read the JSON
     FileReader reader=new FileReader("src\\main\\resources\\data\\payload.json");
          Object obj=  jp.parse(reader);  								//parsed Json file to Object type
          JSONObject jsonobject=(JSONObject) obj;  						//converting Object type to JSONObject
          JSONArray jsonarray=(JSONArray) jsonobject.get("player");  	//Fetching the payers Json Objects in JSON ARRAY
         // String arr[]=new String[jsonarray.size()];
           for(int i=0;i<jsonarray.size();i++) {                     	 //Iterating over each JSON Object of Player .
        	   JSONObject player=(JSONObject) jsonarray.get(i);       	 //Fetching each JSON object on the basis of index
        	   String country=(String) player.get("country");          	 // Fetching country detail form Player object
        	   String wicketkeeper=(String) player.get("role");        	 // Fetching country detail form Player object 
        	   //System.out.println(country);	
        	   if(!(country.equals("India"))) {
        		   foreigncount++;
        	   }
        	   if(wicketkeeper.equals("Wicket-keeper")) {
        		   
				wicketkeeprcount++;
        	   }
           }
           System.out.println("number of foreign player= "+ foreigncount);     
           System.out.println("number of wicket keeper= "+ wicketkeeprcount);
           Assert.assertEquals(4, foreigncount);
           Assert.assertTrue(foreigncount>0);
          
          
  }
  
}
