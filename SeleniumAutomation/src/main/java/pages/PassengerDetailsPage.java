package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import util.TestUtil;

public class PassengerDetailsPage extends TestBase {

	TestUtil testutil;
	private By adultFirst1 = By.id("pax-a-first-1");
	private By adultLast1 = By.id("pax-a-last-1");
	private By adultFirst2 = By.id("pax-a-first-2");
	private By adultLast2 = By.id("pax-a-last-2");
	private By title1 = By.id("pax-a-title-1");
	private By title2 = By.id("pax-a-title-2");

	private By dobd1 = By.id("pax-a-dobd-1");
	private By dobm1 = By.id("pax-a-dobm-1");
	private By doby1 = By.id("pax-a-doby-1");

	private By dobd2 = By.id("pax-a-dobd-2");
	private By dobm2 = By.id("pax-a-dobm-2");
	private By doby2 = By.id("pax-a-doby-2");

	public PassengerDetailsPage passengerAdults1Title(String adult1title) {
		try {
			testutil = new TestUtil();
			testutil.selectDropDown(title1, "visibleText", adult1title);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new PassengerDetailsPage();
	}

	public PassengerDetailsPage passengerAdults1Name(String first1name, String last1name) {
		try {
			driver.findElement(adultFirst1).clear();
			driver.findElement(adultFirst1).sendKeys(first1name);
			driver.findElement(adultLast1).clear();
			driver.findElement(adultLast1).sendKeys(last1name);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new PassengerDetailsPage();
	}

	public PassengerDetailsPage passengerAdults1DOB(String adult1date, String adult1month, String adult1year) {
		try {
			testutil.selectDropDown(dobd1, "visibleText", adult1date);
			testutil.selectDropDown(dobm1, "visibleText", adult1month);
			testutil.selectDropDown(doby1, "visibleText", adult1year);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new PassengerDetailsPage();
	}

	public PassengerDetailsPage passengerAdults2Title(String adult2title) {
		try {
			testutil = new TestUtil();
			testutil.selectDropDown(title2, "visibleText", adult2title);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new PassengerDetailsPage();
	}

	public PassengerDetailsPage passengerAdults2Name(String first2name, String last2name) {
		try {
			driver.findElement(adultFirst2).clear();
			driver.findElement(adultFirst2).sendKeys(first2name);
			driver.findElement(adultLast2).clear();
			driver.findElement(adultLast2).sendKeys(last2name);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new PassengerDetailsPage();
	}

	public PassengerDetailsPage passengerAdults2DOB(String adult2date, String adult2month, String adult2year) {
		try {
			testutil.selectDropDown(dobd2, "visibleText", adult2date);
			testutil.selectDropDown(dobm2, "visibleText", adult2month);
			testutil.selectDropDown(doby2, "visibleText", adult2year);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new PassengerDetailsPage();
	}

}
