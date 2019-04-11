package ApiTestCases;

import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import Base.TestBase;

public class Check_Availability_Api extends TestBase{

	public Check_Availability_Api() throws FileNotFoundException {
		super();
		
	}
	@SuppressWarnings("unchecked")
	@Test
	public void Verify_CheckAvailabilityApi() throws ParseException{
		RestAssured.baseURI = "http://beta.discover-prospects.com:8086/v4/listing";

		RequestSpecification request = RestAssured.given().header("Authorization",
				"Bearer 5e0a50d50229b7f0a49c2c6f814e01a9258ac927");

		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();
		
		requestParams.put("hostname", "www.pizzahut.com");
		
		requestParams.put("country_code", "us");
		
		request.body(requestParams.toString());

		Response response = request.post("/checkavaialability");
		
		long responsetime = response.getTime();
		
		System.out.println("Response Time is: "+responsetime);
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body is =>" + responseBody);
		
		JSONParser jp = new JSONParser();

		JSONObject jsonResult = (JSONObject) (jp.parse(responseBody));
		
		JSONObject jsonStatus = (JSONObject) (jsonResult.get("status"));

		JSONObject JsonMeta = (JSONObject) (jsonResult.get("meta"));

		JSONObject jsonFP = (JSONObject) (jsonResult.get("result"));
		
		String Status = jsonFP.get("status").toString();
		System.out.println("Status is: "+Status);
		
		String fp_id = jsonFP.get("fp_id").toString();
		System.out.println("Fp_Id is: " +fp_id);
		
		String  reference_id= JsonMeta.get("request_reference_id").toString();
		System.out.println("Request Reference Id is: "+reference_id);
		
		

	}
	
	

}
