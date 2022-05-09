package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import junit.framework.Assert;
import pages.AccommodationPage;
import pages.HolidayPage;
import pages.HomePage;
import pages.LeadContactDetailsPage;
import pages.PassengerDetailsPage;
import pages.ProductListPage;

public class ProductListTest extends TestBase {

	HomePage homepage;
	ProductListPage productlistpage;

	@BeforeMethod
	public void setUp() {
		try {

			System.out.println("Application started sucessfully ");
			initialization();
			homepage = new HomePage();
			productlistpage = new ProductListPage();

			homepage.agreedProceedCookies();
			String expectedPageTitle = homepage.validatePageTitle();
			Assert.assertTrue(expectedPageTitle.contains("Home Page | Mail Travel"));
			homepage.enterSerach(prop.getProperty("search"));
			homepage.clickSearchButton();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

	@Test
	public void verifyProductListTest() throws InterruptedException {

		try {
			productlistpage.clickMoreInfoProduct();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {
		try {

			closingbrowser();
			System.out.println("Application run completed sucessfully and browser closed");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
