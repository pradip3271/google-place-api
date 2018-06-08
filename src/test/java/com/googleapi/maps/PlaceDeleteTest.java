package com.googleapi.maps;
import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.RestServices;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

public class PlaceDeleteTest extends BaseTest{
	
	@Test
	public void createAndDeletePlace() throws IOException {
		
		
		// Create place
		Response response = RestServices.addPlaceReturnJson(reqSpecification);
		
		System.out.println(response.asString());
		
		// Extract place id from response
		JsonPath js = new JsonPath(response.asString());
		String placeId = js.get("place_id");
		
		// Delete the place and verify status code 200
		response = RestServices.deletePlaceReturnJson(reqSpecification, placeId);	
		response.then().body("status", equalTo("OK"));
		
	}

}
