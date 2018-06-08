package utils;

import java.util.Properties;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestServices {
	
	static Properties properties;
	
	static {
	
		properties = Helper.loadResourceProperties("./src/test/resources/endpoints.properties");
	}
	
	public static Response searchPlaceReturnJson( RequestSpecification req ) {
		
		String endpoint = properties.getProperty("PLACE-SEARCH") + "/json";
		
		return req.given().param("location", "-33.8670522,151.1957362").
				param("radius", "500").
				when().get(endpoint);
		
	}
	
	public static Response addPlaceReturnJson( RequestSpecification req ) {
		
		String endpoint = properties.getProperty("PLACE-ADD") + "/json";
		
		String addPlaceJsonString = Helper.GenerateStringFromResource("./src/test/resources/addPlace.json");
		
		return req.body(addPlaceJsonString).when().post(endpoint);
		
	}
	
	public static Response deletePlaceReturnJson( RequestSpecification req, String placeId ) {
		
		String endpoint = properties.getProperty("PLACE-DELETE") + "/json";
		
		return req.body("{\n" + 
				"  \"place_id\": \""+placeId+"\"\n" + 
				"}").
				when().post(endpoint);
		
	}
	

	public static Response getPlaceDetailsJson( RequestSpecification req, String placeId ) {
		
		String endpoint = properties.getProperty("PLACE-DETAILS") + "/json";
		
		return req.given().param("placeid", placeId).
				when().get(endpoint);
	}

	public static Response getPlacePhoto(RequestSpecification req, String photoReference) {
		
		String endpoint = properties.getProperty("PLACE-PHOTO");
		
		return req.given(). 
				param("maxwidth", "400"). 
				param("photoreference", photoReference). 
				when().get(endpoint);
	}
	

}
