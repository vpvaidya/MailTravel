package RestAPI;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseApi;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GetRequest extends TestBaseApi {

	@BeforeClass
	public void getAllEmployeeDetails() {
		try {
			// Specify Base URI
			RestAssured.baseURI = prop.getProperty("baseuri");

			// Request Object
			httpRequest = RestAssured.given();

			// Response Object
			response = httpRequest.request(Method.GET, "/employees");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Check Response Body
	@Test
	void checkResponseBody() {
		try {
			String responseBody = response.getBody().asString();
			System.out.println("Request Body is: " + responseBody);
			Assert.assertTrue(responseBody != null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Status Code Validation
	@Test
	void checkStatusCode() {
		try {
			int statusCode = response.statusCode();
			System.out.println("Status Code is: " + statusCode);
			Assert.assertEquals(statusCode, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Status Line Validation
	@Test
	void checkStatusLine() {

		try {
			String statusLine = response.getStatusLine();
			System.out.println("Status line is: " + statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Response Time Validation
	@Test
	void checkResponseTime() {

		try {
			long responseTime = response.getTime();
			System.out.println("Response Time is: " + responseTime);
			if (responseTime > 2000) {
				Assert.assertTrue(responseTime < 2000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Server Type Validation
	@Test
	void checkserverType() {

		try {
			String serverType = response.header("Server");
			System.out.println("Server Type is: " + serverType);
			Assert.assertEquals(serverType, "nginx");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Content Type Validation
	@Test
	void checkcontentType() {

		try {
			String contentType = response.header("Content-Type");
			System.out.println("Content Type is: " + contentType);
			Assert.assertEquals(contentType, "application/json");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Content Encoding Validation
	@Test
	void checkcontentEncoding() {
		try {
			String contentEncoding = response.header("Content-Encoding");
			System.out.println("Content Encoding is: " + contentEncoding);
			Assert.assertEquals(contentEncoding, "gzip");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	void checkcontentLength() {
		try {
			String contentLength = response.header("Content-Length");
			System.out.println("Content Length is: " + contentLength);
			
			if(Integer.parseInt(contentLength)<200)
			Assert.assertTrue(Integer.parseInt(contentLength)>200);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@AfterClass
	void tearDown()
	{
		System.out.println("Test Execuation done for Get method All Employee..");
		
	}

}
