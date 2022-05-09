package pages;

import org.openqa.selenium.By;

import base.TestBase;

public class ProductListPage extends TestBase {

	//private By firstElementInfo = By.id("iterator_4_product_custom_more-info-button"); 
	private By firstElementInfo = By.xpath("(//span[.='11 Days - Classic Escorted Tours'])[1]/parent::*/following-sibling::*/button[.='More info']");
	public void clickMoreInfoProduct()

	{
		try {
			driver.findElement(firstElementInfo).click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
