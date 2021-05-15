package StepDefinations;

import org.apache.log4j.Logger;
import org.testng.Assert;

import Utility.ReusableMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class countryCodeSteps {
	public static Logger log = Logger.getLogger(countryCodeSteps.class);
	public static Response resp;
	
	@Given("^Set GET API endpoint \"([^\"]*)\"\"([^\"]*)\"$")
	public void set_GET_API_endpoint(String arg1, String arg2) throws Throwable {
		String URL = arg1+arg2;
	    RestAssured.baseURI =URL;
	    resp = ReusableMethods.getMethod(URL);
	    log.info("Given url" +URL);
	    log.info("response based on name " +resp.getBody().asString());
	  
	}

	@Then("^Validate  the statuscode (\\d+)$")
	public void validate_the_statuscode(int arg1) throws Throwable {
		int code = resp.statusCode();
	     System.out.println("Statuscode  :" +code);
	     Assert.assertEquals(code, arg1);
	}

	@Then("^Validate the capital \"([^\"]*)\"$")
	public void validate_the_capital(String arg1) throws Throwable {
		String Capital = resp.jsonPath().getString("capital").replaceAll("\\[", "").replaceAll("\\]", "");
	    System.out.println("Capital :" +Capital);
	    Assert.assertEquals(Capital, arg1);
	}

	

}
