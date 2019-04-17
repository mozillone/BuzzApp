package ApiTestCases;

import java.io.FileNotFoundException;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import Base.TestBase;
import groovy.json.JsonException;
import junit.framework.Assert;

public class Dummy_Test_Api extends TestBase{

	public Dummy_Test_Api() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void httpPost() throws JsonException,InterruptedException {
			
		//Initializing Rest API's URL
		String APIUrl = "http://{API URL}";
			
		//Initializing payload or API body
		String APIBody = "{API Body}"; //e.g.- "{\"key1\":\"value1\",\"key2\":\"value2\"}"
					
		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
			
		//Setting API's body
		builder.setBody(APIBody);
			
		//Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");
			
		RequestSpecification requestSpec = builder.build();

		//Making post request with authentication, leave blank in case there are no credentials- basic("","")
		Response response = given().authentication().preemptive().basic()
					.spec(requestSpec).when().post(APIUrl);
		JSONObject JSONResponseBody = new JSONObject();

		//Fetching the desired value of a parameter
		String result = JSONResponseBody.toJSONString();
			
		//Asserting that result of Norway is Oslo
		Assert.assertEquals(result, "{expectedValue}");

		}

	
}
