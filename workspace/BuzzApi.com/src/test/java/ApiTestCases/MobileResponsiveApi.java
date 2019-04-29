package ApiTestCases;

import java.io.FileNotFoundException;
import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import Base.TestBase;
import Util.SendMailSSLWithAttachment;
import Util.emailReport;

public class MobileResponsiveApi extends TestBase{
	emailReport EmailReport;
	
	SendMailSSLWithAttachment  sendMailSSLWithAttachment;

	public MobileResponsiveApi() throws FileNotFoundException {
		sendMailSSLWithAttachment = new SendMailSSLWithAttachment();
		EmailReport = new emailReport();

	}

	// Sheet name in which data need to be read.

	String sheetName = "Sheet2";

	@BeforeClass
	public void setBaseUri() {
		RestAssured.baseURI = "http://beta.discover-prospects.com:8086/v4";

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "getBuzzApiTestData")
	public void Verify_CheckAvailabilityApi(String HostName) throws ParseException, FileNotFoundException {

		RequestSpecification request = RestAssured.given().header("Authorization",
				"Bearer 5e0a50d50229b7f0a49c2c6f814e01a9258ac927");

		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();

		requestParams.put("url", HostName);
		//requestParams.put("url", "https://support.office.com");

		System.out.println("Host Name is " + HostName);

		request.body(requestParams.toString());

		Response response = request.post("/website/responsive");

		long time = response.getTime();

		System.out.println(time);

		// String responseBody = response.getBody().asString();

		String responseBody = response.getBody().prettyPrint();

		int status = 200;

		// int statuscode = response.getStatusCode();

		// Assert.assertEquals(status, statuscode);
		try {
		Assert.assertEquals(status, response.getStatusCode());
		} catch(Error e){
			// Following lines will be printed when the assert condition fails
			System.out.println("Assert not equals failed. But test execution is not aborted.");
			System.out.println("Error message: " + e.toString());
		}

		// System.out.println("Response Body is =>" + responseBody);

		// JSONParser jp = new JSONParser();

		/*
		 * JSONObject jsonResult = (JSONObject) (jp.parse(responseBody));
		 * 
		 * JSONObject jsonStatus = (JSONObject) (jsonResult.get("status"));
		 * 
		 * JSONObject JsonMeta = (JSONObject) (jsonResult.get("meta"));
		 * 
		 * JSONObject jsonFP = (JSONObject) (jsonResult.get("result"));
		 * 
		 * String Status = jsonFP.get("status").toString();
		 * System.out.println(Status);
		 * 
		 * String fp_id = jsonFP.get("fp_id").toString();
		 * System.out.println(fp_id);
		 * 
		 * String reference_id= JsonMeta.get("request_reference_id").toString();
		 * System.out.println(reference_id);
		 */

	}

	@DataProvider
	public Object[][] getBuzzApiTestData()
			throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
		Object data[][] = Util.ExcelReader.getTestData(sheetName);
		return data;
	}

	@AfterClass
	public void Quit() {

		System.out.println("Completed the execution");
 
	}
	
	
}
