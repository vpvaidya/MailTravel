package pages;

import org.openqa.selenium.By;

import base.TestBase;

public class LeadContactDetailsPage extends TestBase {

	private By contactName = By.id("contact-name");
	private By contactMobile = By.id("contact-mobile");
	private By contactEamil = By.id("contact-email");
	private By contactAddress1 = By.id("contact-address1");
	private By contactAddress2 = By.id("contact-address2");
	private By contactCity = By.id("contact-city");
	private By contactPostcode = By.id("contact-postcode");
	private By continueButon = By.cssSelector(".nbf_fancy_paxButton.nbf_fg_pms_button_text");
	private By getTotalPrice = By
			.xpath("(//div[@class='nbf_grid_item nbf_w20 nbf_tpl_pms_room_colheading txt-end'])[2]");

	public LeadContactDetailsPage passengerContactDetails(String contactname, String contactmobile,
			String contacteamil) {
		try {
			driver.findElement(contactName).clear();
			driver.findElement(contactName).sendKeys(contactname);
			driver.findElement(contactMobile).clear();
			driver.findElement(contactMobile).sendKeys(contactmobile);
			driver.findElement(contactEamil).clear();
			driver.findElement(contactEamil).sendKeys(contacteamil);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new LeadContactDetailsPage();

	}

	public String passengerAddressDetails(String contactaddress1, String contactaddress2,
			String contactcity, String contactpostcode) {
		
		String totalAccumdation = null;
		try {
			driver.findElement(contactAddress1).clear();
			driver.findElement(contactAddress1).sendKeys(contactaddress1);
			driver.findElement(contactAddress2).clear();
			driver.findElement(contactAddress2).sendKeys(contactaddress2);
			driver.findElement(contactCity).clear();
			driver.findElement(contactCity).sendKeys(contactcity);
			driver.findElement(contactPostcode).clear();
			driver.findElement(contactPostcode).sendKeys(contactpostcode);
			driver.findElement(continueButon).click();
			 totalAccumdation = driver.findElement(getTotalPrice).getText();
			System.out.println("Compare Total Price :" + totalAccumdation);
           // AccommodationPage accommodationpage = new AccommodationPage();
          //accommodationpage.accumdationPrintTotal();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return  totalAccumdation;
	}
	

}
