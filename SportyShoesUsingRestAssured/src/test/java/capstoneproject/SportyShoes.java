package capstoneproject;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SportyShoes extends TestBase {
	
	HashMap<String, String> map = new HashMap<String, String>();
	Response response;
	JsonPath jsonPath;
	
	@Test(priority = 0)
	public void createPayLoad() {
		map.put("id", "101");
		map.put("image", "image_url");
		map.put("name", "SampleShoe");
		map.put("category", "Running");
		map.put("size", "9");
		map.put("price", "1000");
		RestAssured.baseURI = "http://localhost:9010/";
		RestAssured.basePath = "add-shoe";
		logger.info("Payload created");
	}
	
	@Test(priority = 1)
	public void RetriveAllProdList() {
		RestAssured
			.given()
				.contentType("application/json")
			.when()
				.get("http://localhost:9010/get-shoes")
			.then()
				.statusCode(200)
				.log().all();
		
		logger.info("The list of all products in the store is retrived.");
		}
	
	@Test(priority = 2)
	public void RetriveAllRegUsersList() {
		RestAssured
			.given()
				.contentType("application/json")
			.when()
				.get("http://localhost:9010/get-users")
			.then()
				.statusCode(200)
				.log().all();
		
		logger.info("The list of all registered users in the store is retrived.");
		}
	
	@Test(priority = 3)
	public void AddTheProduct() {
		
		RestAssured
	        .given()
	            .contentType("application/json")
	            .body(map)
	        .when()
	        	.post("http://localhost:9010/add-shoe?id=101&image=image_url&name=SampleShoe&category=Running&sizes=9&price=1000")
	        .then()
	        	.statusCode(200)
	            .log().all();

	    logger.info("The new product is added to the list.");
	}

}
