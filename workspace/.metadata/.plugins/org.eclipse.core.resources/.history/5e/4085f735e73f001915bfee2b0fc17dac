package ApiTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.specification.RequestSpecification;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetJsonResponseTest {

   @BeforeClass
   public void setBaseUri () {

     RestAssured.baseURI = "http://beta.discover-prospects.com:8086/v4";
     
   }
   
   @Test
   public void test01()  {
    // Response res  = given ().param ("query", "Churchgate Station")
	   io.restassured.specification.RequestSpecification request = RestAssured.given ().header("Authorization",
				"Bearer 5e0a50d50229b7f0a49c2c6f814e01a9258ac927");
	   Response res  = given ().param ("url", "www.pizzahut.com")
			   
     //.param ("url", "www.pizzahut.com")
     .when()
     .get ("/website/responsive")
     .then()
     .contentType(ContentType.JSON)
     .extract().response();


     System.out.println (res.asString ());

   }

}