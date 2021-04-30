package StepDefinations;
import static io.restassured.RestAssured.*;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestStep {
	Response resp;
	@Given("^: user sets base API request \"([^\"]*)\"$")
	public void user_sets_base_API_request(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    RestAssured.baseURI =arg1;
	}

	@When("^: user sends Api request to get  all the countries$")
	public void user_sends_Api_request_to_get_all_the_countries() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   resp = RestAssured.given().contentType("application/json").get("/rest/v2/all");
	}

	@Then("^: Validate the statuscode \"([^\"]*)\"$")
	public void validate_the_statuscode(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(resp.statusCode());
	    Assert.assertEquals(200,resp.statusCode());
	    //System.out.println(resp.getBody().asString());
	    // printing names 
	    System.out.println(resp.jsonPath().getString("name"));
	    //printing capitals
	    System.out.println(resp.jsonPath().getString("capital"));

	}

}
