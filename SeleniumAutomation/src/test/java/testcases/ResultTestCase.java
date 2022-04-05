package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import base.TestBase;
import pages.ResultPage;

public class ResultTestCase extends TestBase {
	
	ResultPage resultScreen;

	@BeforeMethod
	public void setup() {
		
		System.out.println("My application started sucessfully ");
		initialization();
		resultScreen = new ResultPage();

	}

	@Test
	public void testResult() throws InterruptedException {

		resultScreen.agreedProceedCookies();
		resultScreen.selectLanguageRegion();
		resultScreen.searchWordUsingSearchBox();
		resultScreen.resultPageDetails();
		resultScreen.resultSortedByDate();
		resultScreen.clickArticleCheckbox();
		resultScreen.eachArticleDisplayLink();

	}

	
	@AfterMethod
	public void tearDown() {
		closingbrowser();
		System.out.println("My application run sucessfully and browser closed ");
	}

}
