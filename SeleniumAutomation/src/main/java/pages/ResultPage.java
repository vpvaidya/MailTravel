package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.TestBase;

public class ResultPage extends TestBase {

	private By iframe = By.xpath(".//iframe[@class='truste_popframe']");
	private By agreedProceedButton = By.xpath(".//a[contains(text(),'Agree and Proceed')]");
	private By search = By.xpath(".//span[contains(text(),'Search')]");
	private By searchText = By.xpath(".//input[@form='coveo-dummy-form']");
	private By listElement = By.xpath(".//div[@id='magic-box-suggestion-0']/div");
	private By searchList = By.xpath(".//*[@class='CoveoQuerySummary']");
	private By date = By.xpath(".//*[@aria-label='Sort by Date in descending order']");
	private By articleCheckbox = By.xpath(".//*[@data-title='Content Type']/ul[1]/li[1]");
	private By clickRegion = By.cssSelector("nav[aria-label='Location Selector'] button");
	private By selectRegion = By.xpath("//span[contains(text(),'Americas')]");
	private By selectUS = By.xpath("//a[@href='/en-US']");

	public void agreedProceedCookies() {

		WebElement iframeElement = driver.findElement(iframe);

		driver.switchTo().frame(iframeElement);
		driver.findElement(agreedProceedButton).click();
		driver.switchTo().defaultContent();

	}

	public void selectLanguageRegion() {
		driver.findElement(clickRegion).click();
		driver.findElement(selectRegion).click();
		driver.findElement(selectUS).click();

	}

	public void searchWordUsingSearchBox() {
		driver.findElement(search).click();
		driver.findElement(searchText).sendKeys("IFRS 17");

		List<WebElement> ls = driver.findElements(listElement);

		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getText());
			if (ls.get(i).getText().contains("IFRS 17 implementation can be tough!")) {
				ls.get(i).click();
				break;
			}
		}
	}

	public void resultSortedByDate() {

		if (driver.findElement(date).isSelected()) {
			System.out.println("The results are sorted by Date");
		} else {
			System.out.println("The results is not sorted by Date");
			driver.findElement(date).click();
		}
	}

	public void clickArticleCheckbox() throws InterruptedException {

		driver.findElement(articleCheckbox).click();
		Thread.sleep(3000);
	}

	public void resultPageDetails() {

		String resultsText = driver.findElement(searchList).getText();

		if (resultsText.contains("IFRS 17")) {

			System.out.println(" The results contains the string IFRS 17");
		}

	}

	public void eachArticleDisplayLink() throws InterruptedException {

		while (true) {
			WebElement nextArrow = driver.findElement(By.xpath(".//*[@class='img-fluid coveo-pager-next-icon-svg']"));
			nextArrow.click();
			Thread.sleep(5000);
			List<WebElement> allLinks = driver
					.findElements(By.xpath(".//*[@class='CoveoFieldValue wtw-listing-result-uri']"));

			for (WebElement specificlink : allLinks) {
				Assert.assertTrue(specificlink.getText().startsWith("https://www.wtwco.com/en-US/"));

			}

			try {

				nextArrow = driver.findElement(By.xpath(".//img[@class='img-fluid coveo-pager-next-icon-svg']"));

			} catch (Exception e) {
				System.out.println("*******No More Link Present!");
				break;
			}

		}

	}

}
