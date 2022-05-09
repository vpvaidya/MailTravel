package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBaseApi {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static Properties prop;
	
	public TestBaseApi() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
