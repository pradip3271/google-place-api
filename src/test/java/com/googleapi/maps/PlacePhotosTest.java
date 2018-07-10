package com.googleapi.maps;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.RestServices;

public class PlacePhotosTest extends BaseTest {
	
	@Test
	public void placePhotos() {
		
		// Get placeId from place search
		Response resp = RestServices.searchPlaceReturnJson(reqSpecification);
		JsonPath jp = new JsonPath(resp.asString());
		String placeId = jp.get("results[0].place_id");
		
		System.out.println(placeId);
		
		// Get photo reference from place details
		resp = RestServices.getPlaceDetailsJson(reqSpecification, placeId);
		jp = new JsonPath(resp.asString());
		String photoReference = jp.get("result.photos[0].photo_reference");
		System.out.println(photoReference);
		
		// Get place photo and verify
		resp = RestServices.getPlacePhoto(reqSpecification, photoReference);
		resp.then().statusCode(200).and(). 
		header("Content-Type", "image/jpeg");
	}
	

}
