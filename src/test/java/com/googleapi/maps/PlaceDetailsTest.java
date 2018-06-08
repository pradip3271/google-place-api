package com.googleapi.maps;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.RestServices;
import static org.hamcrest.Matchers.equalTo;

public class PlaceDetailsTest extends BaseTest {
	
	@Test
	public void placeDetails() {
		// Search place and extract place id
		Response response = RestServices.searchPlaceReturnJson(reqSpecification);		
		JsonPath jp = new JsonPath(response.asString());
		String placeId = jp.get("results[0].place_id");
		
		// Place details request and verify
		response = RestServices.getPlaceDetailsJson( reqSpecification, placeId );
		
		jp = new JsonPath(response.asString());
		
		response.then().
		body("status", equalTo("OK")).and().
		body("result.address_components[0].long_name", equalTo("Sydney")).and(). 
		body("result.address_components[0].short_name", equalTo("Sydney")).and(). 
		body("result.formatted_address", equalTo("Sydney NSW, Australia"));

		System.out.println(response.asString());
	}
	
}
