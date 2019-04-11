package preloved.base;

import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstanceCreation {

	public WebDriver driver;

	// @BeforeMethod
	public WebDriver generateDriverInstance() {

		ResourceBundle config = ResourceBundle.getBundle("config", Locale.US);

		if (config.getString("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		else if (config.getString("browser").equalsIgnoreCase("firefox"))

		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if (config.getString("browser").equalsIgnoreCase("ie"))

		{

			WebDriverManager.iedriver().setup();

			driver = new InternetExplorerDriver();
			
			

		}

		else {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.get(config.getString("appUrl"));

		return driver;
	}

	// @AfterMethod
	public void closeDriver(WebDriver driver) {

		driver.quit();

	}
	public void BrowserInvoke(WebDriver driver) {

		WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.preloved.co.uk/");
		driver.findElement(By.xpath("//*[@data-test-element='header-join']")).click();

	}

}
