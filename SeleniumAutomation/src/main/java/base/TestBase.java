package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() throws UnreachableBrowserException {

		try {
			String browserName = prop.getProperty("browser");

			if (browserName.contains("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browserName.contains("IE")) {
				WebDriverManager.iedriver().setup();

				driver = new InternetExplorerDriver();

			} else if (browserName.contains("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browserName.contains("EDGE")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			}

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void closingbrowser() {
		try {
			driver.close();
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
