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

public class Domain_Details_Api extends TestBase{

	public Domain_Details_Api() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void Verify_Domain_Details_Api() throws ParseException{
		RestAssured.baseURI = "http://beta.discover-prospects.com:8086/v4/domain";

		RequestSpecification request = RestAssured.given().header("Authorization",
				"Bearer 5e0a50d50229b7f0a49c2c6f814e01a9258ac927");

		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject(); 
		
		requestParams.put("domain", "zoeskitchen.com"); 
		
		//requestParams.put("country_code", "us");
		
		request.body(requestParams.toString()); 

		Response response = request.post("/details");
		
		long responsetime = response.getTime();
		
		System.out.println("Response Time is: "+responsetime);
		
		String responseBody = response.getBody().asString();
		
		System.out.println(requestParams);
		
		//*******************************************************
		JSONParser jp = new JSONParser();
		
        JSONObject jsonResult = (JSONObject) (jp.parse(responseBody));
 
       // System.out.println(jsonResult);
        
        System.out.println("Status : "+jsonResult.get("status"));
        
        JSONObject jsonData = (JSONObject) (jsonResult.get("data"));
        
        JSONObject jsonMeta = (JSONObject) (jsonResult.get("meta"));
        
        System.out.println("Request Rferenceid :"+jsonMeta.get("request_reference_id"));
        
        System.out.println("Domain :"+jsonMeta.get("domain"));
        
        //System.out.println(jsonFP);
        
        System.out.println("Name Server:"+jsonData.get("name_servers"));
        
        JSONObject jsonReg = (JSONObject) (jsonData.get("registration"));
        
        //System.out.println(jsonReg);
        
        System.out.println("Created Date : "+jsonReg.get("createdDate"));
        System.out.println("RegistrarName : "+jsonReg.get("registrarName"));
        System.out.println("ExpiresDate : "+jsonReg.get("expiresDate"));
        System.out.println("UpdatedDate : "+jsonReg.get("updatedDate"));
        System.out.println("Registrant : "+jsonReg.get("registrant"));
        
        
        
//        JSONObject jsonStat = (JSONObject) (jsonResult.get("status"));
        
         
        
        //JSONObject jsonStatus = (JSONObject) (jsonResult.get("status"));
        
        //String Status = jsonStatus.get("status").toString();
		//System.out.println("Status is: "+Status);
        
         //{status:{Key:123,Key:safdsda}}
        //****************************************************************************

		
		//System.out.println("Response Body is =>" + responseBody);
		
		/*JSONParser jp = new JSONParser();

		JSONObject jsonData = (JSONObject) (jp.parse(responseBody));
		
		System.out.println("Data is: "+jsonData);
		
		JSONObject jsonName_Servers = (JSONObject) (jsonData.get("name_servers"));
		
		System.out.println(jsonName_Servers);*/
		
		/*JSONObject jsonResult = (JSONObject) (jp.parse(responseBody));
		
		JSONObject jsonData = (JSONObject) (jsonResult.get("data"));

		JSONObject JsonMeta = (JSONObject) (jsonResult.get("meta"));

		JSONObject jsonFP = (JSONObject) (jsonResult.get("result"));
		
		String data = jsonFP.get("data").toString();
		System.out.println("Data is: "+data);
		
		String Status = jsonFP.get("status").toString();
		System.out.println("Status is: "+Status);
		
		String fp_id = jsonFP.get("fp_id").toString();
		System.out.println("Fp_Id is: " +fp_id);
		
	    String  reference_id= JsonMeta.get("request_reference_id").toString();
		System.out.println("Request Reference Id is: "+reference_id);*/
		

	}
	
	

}
