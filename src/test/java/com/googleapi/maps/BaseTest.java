package com.googleapi.maps;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	
	static RequestSpecification reqSpecification;
	
	@BeforeClass
	public static void init() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("./src/test/resources/env.properties");
		prop.load(fis);
		
		RestAssured.baseURI = prop.getProperty("HOST");
		
		reqSpecification = RestAssured.given(). 
				queryParam("key", prop.getProperty("KEY"));
	}
	


}
