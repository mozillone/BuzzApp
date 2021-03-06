package ApiTestCases;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import Base.TestBase;

public class Auto_Suggestion_Location_Api extends TestBase{
	
	String APIBody = "{API Body}";

	public Auto_Suggestion_Location_Api() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void Verify_Auto_Suggestion_Location_Api() throws ParseException{
		
		
		
		RestAssured.baseURI = "http://beta.discover-prospects.com:8086/v4/autosuggest";

		RequestSpecification request = RestAssured.given().header("Authorization",
				"Bearer 5e0a50d50229b7f0a49c2c6f814e01a9258ac927");

		request.header("Content-Type", "application/json"); 

		JSONObject requestParams = new JSONObject(); 
		
		requestParams.put("keyword", "manitoba"); 
		
		requestParams.put("country_code", "ca"); 
		
		/*JSONObject jo = new JSONObject();
		
		jo.put("location_type","postal");
		jo.put("location_type", "locality");
		jo.put("location_type", "region");*/
		
//		ArrayList<String>  list= new ArrayList<String>();
		String[] stringArray = {"postal","locality","region"};
		@SuppressWarnings("rawtypes")
		List<String> stringList = new ArrayList(Arrays.asList(stringArray));
		
		//JSONArray arrayObj = new JSONArray();
//		list.add("postal");
//		
//		list.add("locality");
//		
//		list.add("region");
		
//		list.add(["postal","locality","region"]);
		
		
//		requestParams.put( "location_type",new JSONArray());
		requestParams.put( "location_type",stringList); 
		
		request.body(requestParams.toString()); 

		Response response = request.post("/locations"); 
		
		long responsetime = response.getTime();
		
		System.out.println("Response Time is: "+responsetime); 
		
		String responseBody = response.getBody().asString(); 
		
		System.out.println(requestParams); 
		
		System.out.println(responseBody); 

}
}
