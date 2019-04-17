package ApiTestCases;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import Base.TestBase;

public class TestApp extends TestBase{

	public TestApp() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public void postExample()
	{
	String myJson = "{\"name\":\"Jimi Hendrix\"}";
    	RestAssured.baseURI  = "http://127.0.0.1:5984/restassured";	

    	
    	Response r = given()
    	.contentType("application/json").
    	body("{\"name\":\"Jimi Hendrix\"}").
        when().
        post("");

    	String body = r.getBody().asString();
    	System.out.println(body);

	}
	

}
