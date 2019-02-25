package ApiTestCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class MobileResponsiveApi {
	
	public MobileResponsiveApi() {
		
	}
	String sheetName = "Sheet1";
	
	
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
		
		//String responseBody = response.getBody().asString();
		
		String responseBody = response.getBody().prettyPrint();
		
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
		
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		 XSSFSheet sheet = workbook.createSheet("student Details"); 
		 Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
	        data.put("1", new Object[]{ "ID", "NAME", "LASTNAME" }); 
	        data.put("2", new Object[]{ 1, "Pankaj", "Kumar" }); 
	        data.put("3", new Object[]{ 2, "Prakashni", "Yadav" }); 
	        data.put("4", new Object[]{ 3, "Ayan", "Mondal" }); 
	        data.put("5", new Object[]{ 4, "Virat", "kohli" }); 
	        
	        Set<String> keyset = data.keySet(); 
	        int rownum = 0; 
	        for (String key : keyset) { 
	            // this creates a new row in the sheet 
	            Row row = sheet.createRow(rownum++); 
	            Object[] objArr = data.get(key); 
	            int cellnum = 0; 
	            for (Object obj : objArr) { 
	                // this line creates a cell in the next column of that row 
	                Cell cell = row.createCell(cellnum++); 
	                if (obj instanceof String) 
	                    cell.setCellValue((String)obj); 
	                else if (obj instanceof Integer) 
	                    cell.setCellValue((Integer)obj); 
	            } 
	        } 
	        try { 
	            // this Writes the workbook gfgcontribute 
	            FileOutputStream out = new FileOutputStream(new File("gfgcontribute.xlsx")); 
	            workbook.write(out); 
	            out.close(); 
	            System.out.println("gfgcontribute.xlsx written successfully on disk."); 
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	    } 
	
	@DataProvider
	public Object[][] getBuzzApiTestData() throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
		Object data[][] = Util.ExcelReader.getTestData(sheetName);
		return data;
	}
}


