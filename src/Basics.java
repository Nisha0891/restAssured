import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String gestResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("")
		.when().get()
		.then().log().all().statusCode(200).extract().response().asString();
		JsonPath js1 = new JsonPath(gestResponse);
		String placeId = js1.getString("");
		Assert.assertEquals(placeId, "abc");
		
	}

}
