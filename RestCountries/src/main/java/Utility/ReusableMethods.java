package Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReusableMethods {
private static Response resp;
	
	public static Response getMethod(String givenURL) {
		RestAssured.baseURI = givenURL;
		resp =  RestAssured.given().contentType("application/json").get();
		return resp;
	}

}
