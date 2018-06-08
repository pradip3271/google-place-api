package com.googleapi.maps;


import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.RestServices;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

public class PlaceSearchTest extends BaseTest {
	
	// Place search and verify name, place id and server
	@Test
	public void placeSearch() throws IOException {
		
		Response response = RestServices.searchPlaceReturnJson(reqSpecification);
		response.
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			body("results[0].name", equalTo("Sydney")).and(). 
			body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and(). 
			header("server", "scaffolding on HTTPServer2");
						
		

	}

}
