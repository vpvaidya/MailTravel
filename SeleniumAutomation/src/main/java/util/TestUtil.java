package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class TestUtil extends base.TestBase{

	public static long IMPLICIT_WAIT = 20;
	public static long PAGE_LOAD_TIMEOUT =30;

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void selectDropDown(By locator, String type, String value) {

		Select select = new Select(getElement(locator));
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibleText":
			select.selectByVisibleText(value);
			break;

		default:
			System.out.println("Please pass the correct dropdown selection criteria..");
			break;
		}
	}
	
}
