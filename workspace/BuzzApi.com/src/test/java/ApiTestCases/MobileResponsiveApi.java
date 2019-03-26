package ApiTestCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class MobileResponsiveApi {
	
	public MobileResponsiveApi() {
		
	}
	String sheetName = "Sheet2";
	
	
	@BeforeClass
	public void setBaseUri () {
		RestAssured.baseURI = "http://beta.discover-prospects.com:8086/v4";
		
	}
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "getBuzzApiTestData")
	public void Verify_CheckAvailabilityApi(String HostName) throws ParseException, FileNotFoundException{
		

		RequestSpecification request = RestAssured.given().header("Authorization",
				"Bearer 5e0a50d50229b7f0a49c2c6f814e01a9258ac927");

		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();
		
		requestParams.put("url", HostName);
		
		System.out.println("Host Name is " +HostName);
		
		request.body(requestParams.toString());

		Response response = request.post("/website/responsive");
		
		long time = response.getTime();
		
		System.out.println(time);
		
		//String responseBody = response.getBody().asString();
		
		String responseBody = response.getBody().prettyPrint();
		
		int status = 200;
		
		//int statuscode = response.getStatusCode();
		
		
		//Assert.assertEquals(status, statuscode);
		

		Assert.assertEquals(status,response.getStatusCode());
		
		
		//System.out.println("Response Body is =>" + responseBody);
		
		//JSONParser jp = new JSONParser();

		/*JSONObject jsonResult = (JSONObject) (jp.parse(responseBody));
		
		JSONObject jsonStatus = (JSONObject) (jsonResult.get("status"));

		JSONObject JsonMeta = (JSONObject) (jsonResult.get("meta"));

		JSONObject jsonFP = (JSONObject) (jsonResult.get("result"));
		
		String Status = jsonFP.get("status").toString();
		System.out.println(Status);
		
		String fp_id = jsonFP.get("fp_id").toString();
		System.out.println(fp_id);
		
		String  reference_id= JsonMeta.get("request_reference_id").toString();
		System.out.println(reference_id);*/
		
	}

		
	
	
	@DataProvider
	public Object[][] getBuzzApiTestData() throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
		Object data[][] = Util.ExcelReader.getTestData(sheetName);
		return data;
	}


@AfterClass
public void Quit() {
	
	System.out.println("Completed the execution");
	
}
}

