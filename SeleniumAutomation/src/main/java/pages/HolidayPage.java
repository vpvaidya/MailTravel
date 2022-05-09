package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBase;
import util.TestUtil;

public class HolidayPage extends TestBase {

	private By telephoneNumber = By.xpath("//a[@id='supplier-phone']");
	private By bookOnline = By.cssSelector(
			"button[name='enterbookingflow'] div[class='nbf_fancyimg_pms_add_button nbf_fg_pms_button_text nbf_bg_pms_button nbf_fg_pms_button_text ']");
	private By continueButton = By.xpath(".//div[contains(text(),'Continue')]");
	private By getPriceText = By.id("tour-price");
	private By day = By.xpath(".//ul[@id='itinerary-month-wrap']//li");

	public boolean verifyTelephoneIsDisplay() {

		WebElement telNum = driver.findElement(telephoneNumber);

		if (telNum.isDisplayed()) {
			return true;

		} else
			return false;

	}

	public boolean verifyPriceIsDisplay() {

		WebElement isPrice = driver.findElement(getPriceText);

		if (isPrice.isDisplayed()) {
			return true;

		} else

			return false;

	}

	public boolean verifyDayIsDisplay() {

		List<WebElement> isDay = driver.findElements(day);
		int countDays = isDay.size();

		if (countDays == 10) {
			return true;

		} else

			return false;

	}

	public void clickBookOnlineButton() {

		try {
			driver.findElement(bookOnline).click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void clickOnContinueButton() {

		try {
			driver.findElement(continueButton).click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
