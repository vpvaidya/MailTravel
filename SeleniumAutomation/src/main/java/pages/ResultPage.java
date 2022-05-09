package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.TestBase;

public class ResultPage extends TestBase {

	private By acceptCookies = By.id("onetrust-accept-btn-handler");
	private By searchTextBox = By.id("searchtext_freetext_search_form");
	private By clickSearchButton = By.xpath("(.//div[@class='nbf_button'])[1]");
	private By firstElementInfo = By.id("iterator_4_product_custom_more-info-button");
	private By telephoneNumber = By.xpath("//a[@id='supplier-phone']");
	private By bookOnline = By.cssSelector(
			"button[name='enterbookingflow'] div[class='nbf_fancyimg_pms_add_button nbf_fg_pms_button_text nbf_bg_pms_button nbf_fg_pms_button_text ']");
	private By continueButton = By.xpath(".//div[contains(text(),'Continue')]");
	private By selectRoomAndContinue = By.xpath(".//div[contains(text(),'Select your rooms and continue')]");
	private By selectRoomAndContinue1 = By.cssSelector(".nbf_fancy_nbf_tpl_pms_book_room.nbf_fg_pms_button_text");

	private By titleOne = By.id("pax-a-title-1");
	private By adultFirst1 = By.id("pax-a-first-1");
	private By adultLast1 = By.id("pax-a-last-1");
	private By dobd1 = By.id("pax-a-dobd-1");
	private By dobm1 = By.id("pax-a-dobm-1");
	private By doby1 = By.id("pax-a-doby-1");

	private By titleTwo = By.id("pax-a-title-2");
	private By adultFirst2 = By.id("pax-a-first-2");
	private By adultLast2 = By.id("pax-a-last-2");
	private By dobd2 = By.id("pax-a-dobd-2");
	private By dobm2 = By.id("pax-a-dobm-2");
	private By doby2 = By.id("pax-a-doby-2");

	private By contactName = By.id("contact-name");
	private By contactMobile = By.id("contact-mobile");
	private By contactEamil = By.id("contact-email");
	private By contactaddress1 = By.id("contact-address1");
	private By contactaddress2 = By.id("contact-address2");
	private By contactCity = By.id("contact-city");
	private By contactPostcode = By.id("contact-postcode");
	private By continueButon = By.cssSelector(".nbf_fancy_paxButton.nbf_fg_pms_button_text");
	private By getPriceText = By.id("tour-price");
	private By getDays = By.id("itinerary-month-wrap");
	private By getAccPrice = By.xpath(".//div[@class='nbf_tpl_pms_totalprice_js heading-sm']");
	private By getTotalPrice = By.xpath("(//div[@class='nbf_grid_item nbf_w20 nbf_tpl_pms_room_colheading txt-end'])[2]");

/*	public void passengerAddressDetails() {
		// Select titleTwo = new Select(driver.findElement(By.id("titleTwo")));
		// titleTwo.selectByVisibleText("3");
		driver.findElement(contactName).clear();
		driver.findElement(contactName).sendKeys("Dinesh Vaidya");
		driver.findElement(contactMobile).clear();
		driver.findElement(contactMobile).sendKeys("7459372690");

		driver.findElement(contactEamil).clear();
		driver.findElement(contactEamil).sendKeys("dim.vaidya1@gmail.com");
		driver.findElement(contactaddress1).clear();
		driver.findElement(contactaddress1).sendKeys("580 Staten house");
		driver.findElement(contactaddress2).clear();
		driver.findElement(contactaddress2).sendKeys("Sainbury");
		driver.findElement(contactCity).clear();
		driver.findElement(contactCity).sendKeys("Milton Keynes");
		driver.findElement(contactPostcode).clear();
		driver.findElement(contactPostcode).sendKeys("MK93DB");
		driver.findElement(continueButon).click();
		String totalAccumdation = driver.findElement(getTotalPrice).getText();
		System.out.println("Compare Total Price :" +totalAccumdation);
	}

	public void passengerDetails() {
		Select titleOne = new Select(driver.findElement(By.id("pax-a-title-1")));
		titleOne.selectByVisibleText("Mr");
		driver.findElement(adultFirst1).clear();
		driver.findElement(adultFirst1).sendKeys("Dinesh");
		driver.findElement(adultLast1).clear();
		driver.findElement(adultLast1).sendKeys("Vaidya");
		Select dobD = new Select(driver.findElement(By.id("pax-a-dobd-1")));
		dobD.selectByVisibleText("1");
		Select dobM = new Select(driver.findElement(By.id("pax-a-dobm-1")));
		dobM.selectByVisibleText("January");
		Select dobY = new Select(driver.findElement(By.id("pax-a-doby-1")));
		dobY.selectByVisibleText("1992");
	}

	public void passengerDetails1() throws InterruptedException {
		Select titleTwo = new Select(driver.findElement(By.id("pax-a-title-2")));
		titleTwo.selectByVisibleText("Miss");
		driver.findElement(adultFirst2).clear();
		driver.findElement(adultFirst2).sendKeys("Vihaan");
		driver.findElement(adultLast2).clear();
		driver.findElement(adultLast2).sendKeys("More");
		Select dobD1 = new Select(driver.findElement(By.id("pax-a-dobd-2")));
		dobD1.selectByVisibleText("13");
		Select dobM1 = new Select(driver.findElement(By.id("pax-a-dobm-2")));
		dobM1.selectByVisibleText("October");
		Select dobY1 = new Select(driver.findElement(By.id("pax-a-doby-2")));
		dobY1.selectByVisibleText("2000");
		Thread.sleep(1000);
	}

	/*public void agreedProceedCookies() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(acceptCookies).click();
		

	}*/

/*	public void verifyPageTitle() throws InterruptedException {
		String expectedPageTitle = driver.getTitle();
		System.out.println(expectedPageTitle);

		Assert.assertTrue(expectedPageTitle.contains("Home Page | Mail Travel"));
		driver.findElement(searchTextBox).clear();
		driver.findElement(searchTextBox).sendKeys("India");
		driver.findElement(clickSearchButton).click();
		//Thread.sleep(3000);
		//driver.findElement(firstElementInfo).click();

	}*/
	
	

	/*public boolean verifyDaysPriceTelephoneIsDisplay() {

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

	public void clickBookOnline() throws InterruptedException {
		driver.findElement(bookOnline).click();
		Thread.sleep(1000);
		driver.findElement(continueButton).click();
		Thread.sleep(1000);
	}

	public void selectDouble() throws InterruptedException {
		Select Webelement = new Select(driver.findElement(By.id("room-1673573-numselect")));
		Webelement.selectByVisibleText("1");
		Thread.sleep(3000);
		String accumdationTotal = driver.findElement(getAccPrice).getText();
		System.out.println("Total AccumdationPrice :" + accumdationTotal);
		driver.findElement(selectRoomAndContinue1).click();
		Thread.sleep(2000);

	}*/

}
