package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.TestBase;
import util.TestUtil;

public class HomePage extends TestBase {
	private By acceptCookies = By.id("onetrust-accept-btn-handler");
	private By searchTextBox = By.id("searchtext_freetext_search_form");
	private By clickSearchButton = By.xpath("(.//div[@class='nbf_button'])[1]");

	public void agreedProceedCookies() throws InterruptedException {

		Thread.sleep(3000);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.findElement(acceptCookies).click();

	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public HomePage enterSerach(String searchText) {
		try {
			driver.findElement(searchTextBox).clear();
			driver.findElement(searchTextBox).sendKeys(searchText);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new HomePage();
	}

	public void clickSearchButton() {

		try {
			driver.findElement(clickSearchButton).click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
