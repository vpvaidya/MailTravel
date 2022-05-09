package RestAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseApi;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.RestUtil;

public class PostRequest extends TestBaseApi {

	String empName = RestUtil.empName();
	String empSalary = RestUtil.empSalary();
	String empAge = RestUtil.empAge();

	@BeforeClass
	public void createANewEmployeeTest() throws InterruptedException {

		// Specify Base URI
		RestAssured.baseURI = prop.getProperty("baseuri");
		// Request Object
		httpRequest = RestAssured.given();

		// Request payload sending along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", "");
		requestParams.put("employee_name", empName);
		requestParams.put("employee_salary", empSalary);
		requestParams.put("employee_age", empAge);
		requestParams.put("profile_image", "");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		// Response Object
		response = httpRequest.request(Method.POST, "/create");
		// Thread.sleep(5000);

	}

	@Test
	void checkResonseBody() {

		try {
			// capturing response body to perform the other validations
			String responseBody = response.getBody().asString();
			System.out.println("Request Body is: " + responseBody);

			Assert.assertEquals(responseBody.contains(empName), true);
			Assert.assertEquals(responseBody.contains(empSalary), true);
			Assert.assertEquals(responseBody.contains(empAge), true);

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

	@AfterClass
	void tearDown() {
		System.out.println("Test Execuation done for Post Method Employee validation.. ");

	}

}
