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

public class PassengerDetailsTest extends TestBase {

	HomePage homepage;
	ProductListPage productlistpage;
	HolidayPage holidaypage;
	AccommodationPage accommodationpage;
	PassengerDetailsPage passengerdetailspage;

	@BeforeMethod
	public void setUp() {
		try {

			System.out.println("Application started sucessfully ");
			initialization();
			homepage = new HomePage();
			productlistpage = new ProductListPage();
			holidaypage = new HolidayPage();
			accommodationpage = new AccommodationPage();
			passengerdetailspage = new PassengerDetailsPage();

			homepage.agreedProceedCookies();
			String expectedPageTitle = homepage.validatePageTitle();
			Assert.assertTrue(expectedPageTitle.contains("Home Page | Mail Travel"));
			homepage.enterSerach(prop.getProperty("search"));
			homepage.clickSearchButton();

			productlistpage.clickMoreInfoProduct();

			boolean isTelNumber = holidaypage.verifyTelephoneIsDisplay();
			Assert.assertTrue(isTelNumber);
			boolean isDayPresent = holidaypage.verifyDayIsDisplay();
			Assert.assertTrue(isDayPresent);
			boolean isPrice = holidaypage.verifyPriceIsDisplay();
			Assert.assertTrue(isPrice);
			

			holidaypage.clickBookOnlineButton();
			holidaypage.clickOnContinueButton();

			accommodationpage.selectDoubleAccommodation(prop.getProperty("doubleroom"));
			accommodationpage.clickDoubleRoomAndContinue();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	@Test
	public void verifyPassengerDetailsTest ()   {
		try {
			
			passengerdetailspage.passengerAdults1Title(prop.getProperty("adult1title"));
			passengerdetailspage.passengerAdults1Name(prop.getProperty("adult1first"),prop.getProperty("adult1last"));
			passengerdetailspage.passengerAdults1DOB(prop.getProperty("adult1date"),prop.getProperty("adult1month"),prop.getProperty("adult1year"));
			passengerdetailspage.passengerAdults2Title(prop.getProperty("adult2title"));
			passengerdetailspage.passengerAdults2Name(prop.getProperty("adult2first"),prop.getProperty("adult2last"));
			passengerdetailspage.passengerAdults2DOB(prop.getProperty("adult2date"),prop.getProperty("adult2month"),prop.getProperty("adult2year"));

			
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
