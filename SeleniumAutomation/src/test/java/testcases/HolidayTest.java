package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AccommodationPage;
import pages.HolidayPage;
import pages.HomePage;
import pages.LeadContactDetailsPage;
import pages.PassengerDetailsPage;
import pages.ProductListPage;

public class HolidayTest extends TestBase {

	HomePage homepage;
	ProductListPage productlistpage;
	HolidayPage holidaypage;

	@BeforeMethod
	public void setUp() {

		try {
			System.out.println("Application started sucessfully ");
			initialization();
			homepage = new HomePage();
			productlistpage = new ProductListPage();
			holidaypage = new HolidayPage();
			homepage.agreedProceedCookies();
			String expectedPageTitle = homepage.validatePageTitle();
			Assert.assertTrue(expectedPageTitle.contains("Home Page | Mail Travel"));
			homepage.enterSerach(prop.getProperty("search"));
			homepage.clickSearchButton();

			productlistpage.clickMoreInfoProduct();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void verifyHolidayTest()  {

		try {
			boolean isTelNumber = holidaypage.verifyTelephoneIsDisplay();
			
			Assert.assertTrue(isTelNumber);
			boolean isPrice = holidaypage.verifyPriceIsDisplay();
			Assert.assertTrue(isPrice);
			boolean isDayPresent = holidaypage.verifyDayIsDisplay();
			Assert.assertTrue(isDayPresent);
			holidaypage.clickBookOnlineButton();
			holidaypage.clickOnContinueButton();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {
		try {
			closingbrowser();
			System.out.println("Application run complated sucessfully and browser closed");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
