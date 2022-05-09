package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import util.TestUtil;

public class AccommodationPage extends TestBase {

	TestUtil testutil;
	private By getAccPrice = By.xpath(".//div[@class='nbf_tpl_pms_totalprice_js heading-sm']");
	private By selectDoubleRoomAndContinue = By.cssSelector(".nbf_fancy_nbf_tpl_pms_book_room.nbf_fg_pms_button_text");
	private By selectDouble = By.id("room-1673573-numselect");

	public String selectDoubleAccommodation(String doubleRoom) {
		String accumdationTotal = null;
		try {
			
			testutil = new TestUtil();
			testutil.selectDropDown(selectDouble, "visibleText", doubleRoom);
			Thread.sleep(3000);
			  accumdationTotal = driver.findElement(getAccPrice).getText();
			 System.out.println("Total Accumdation Price :" + accumdationTotal);
		

		} catch (Exception e) {
			e.printStackTrace();

		}

		return accumdationTotal;
	}

/*	public String accumdationPrintTotal() {
		String accumdationTotal = driver.findElement(getAccPrice).getText();
		System.out.println("Total Accumdation Price :" + accumdationTotal);
		return accumdationTotal;

	}*/

	public void clickDoubleRoomAndContinue() {

		try {
			driver.findElement(selectDoubleRoomAndContinue).click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
