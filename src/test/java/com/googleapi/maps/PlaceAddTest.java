package com.googleapi.maps;
import org.junit.Test;

import io.restassured.response.Response;
import utils.RestServices;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

public class PlaceAddTest extends BaseTest{
	
	@Test
	public void postRequest() throws IOException {
				
		Response response = RestServices.addPlaceReturnJson(reqSpecification);
		
		response.then().statusCode(200).and(). 
		body("status", equalTo("OK"));
	}

}
