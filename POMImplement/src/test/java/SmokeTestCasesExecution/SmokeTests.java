package SmokeTestCasesExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import preloved.base.DriverInstanceCreation;

import com.excel.utility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmokeTests {
	
	WebDriver driver;
	
	
	
	
	//registration successfull
	@Test
	  public void TC1() throws Exception {
		  
		// WebDriverManager.chromedriver().setup();
		 // driver = new ChromeDriver();
			
	WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("https://www.preloved.co.uk/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@data-test-element='header-join']")).click();
		  
			Xls_Reader reader = new Xls_Reader("C:\\Users\\Hamd.Mehfooz\\eclipse-workspace\\preloved.xlsx");
			int rowCount = reader.getRowCount("Sheet1"); // get row count
			int rowNum = 2;

			String fullname = reader.getCellData("Sheet1", "FullName", rowNum); // fullname
			System.out.println("The fullname is :" + fullname);
			String screenname = reader.getCellData("Sheet1", "ScreenName", rowNum); // screen name
			System.out.println("The screen name is :" + screenname);
			String address = reader.getCellData("Sheet1", "FullAddress", rowNum); // full address
			System.out.println("The full address :" + address);
			String town = reader.getCellData("Sheet1", "Town", rowNum); // town
			System.out.println("The town is :" + town);
			String postcode = reader.getCellData("Sheet1", "Postcode", rowNum); // post code
			System.out.println("The post code is :" + postcode);
			String county = reader.getCellData("Sheet1", "County", rowNum); // county
			System.out.println("The county is :" + county);
			String email = reader.getCellData("Sheet1", "Email", rowNum); // mail
			System.out.println("The  mail is :" + email);
			String telephone = reader.getCellData("Sheet1", "Telephone", rowNum); // telephone
			System.out.println("The telephone is :" + telephone);
			String password = reader.getCellData("Sheet1", "Password", rowNum); // password
			System.out.println("The password is :" + password);
			String confirmpassword = reader.getCellData("Sheet1", "ConfirmPassword", rowNum); // confirm password
			System.out.println("The confirm password is :" + confirmpassword);
			

			// fetching all test fields
			driver.findElement(By.xpath("//*[@class='input--stroked'and @id ='title']")).click();// DROPDOWN button
			Thread.sleep(5000);
			driver.findElement(By.xpath("//option[text()='Mrs']")).click();//click on dropdown
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='fullName']")).sendKeys(fullname);//fullname
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='screenName']")).sendKeys(screenname);//screename
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address);// address
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='town']")).sendKeys(town); // town
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='county']")).sendKeys(county);// county
			Thread.sleep(2000);
			//scroll down so that it can easily find elements
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys(postcode); // postcode
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"countryCode\"]")).click();//country dropdown
			Thread.sleep(5000);
			driver.findElement(By.xpath("//option[text()='PAKISTAN']")).click();//click on dropdown
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email); // confirm password
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='showEmail']")).click();//email checkbox
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@name='TelephoneType']")).click();//telephone DROPDOWN button
			Thread.sleep(5000);
			driver.findElement(By.xpath("//option[text()='Daytime']")).click();//click on drop down
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='telephone']")).sendKeys(telephone); // telephone  number typed
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='showTelephone']")).click();//check box of telephone
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password); //password
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='passwordVal']")).sendKeys(confirmpassword); // confirm password
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(By.xpath("//*[@id='unsubscribed0']")).click();//RADIO BUTTON OF YES & NO
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tandc\"]")).click();//terms and privacy checkbox
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='pl-register-joinbutton']")).click();//join button
			Thread.sleep(2000);

			WebElement facebook = driver.findElement(By.xpath("//*[@id=\"pl-myaccount\"]/h1"));
			String actual = facebook.getText();
			System.out.println("Actual Result is: " + actual); // print actual result
			reader.setCellData("Sheet1", "Actual", rowNum, actual);
			String act = reader.getCellData("Sheet1", "Actual", rowNum);
			String expected = reader.getCellData("Sheet1", "Expected", rowNum);
			System.out.println("Expected Result is: " + expected); // print expected result
			System.out.println("This is Test Case: " + (rowNum - 1));
			String pass = "pass";
			String fail = "fail";
			if (expected.equals(act)) {
				reader.setCellData("Sheet1", "Status", rowNum, pass);
				System.out.println("The test is " + pass);
			} else {
				reader.setCellData("Sheet1", "Status", rowNum, fail);
				System.out.println("The test is " + fail);

			}
	  }
	  
	  //register even with telephone
	 @Test
	  public void TC2() throws Exception {
		  
		  Xls_Reader reader = new Xls_Reader("C:\\Users\\Hamd.Mehfooz\\eclipse-workspace\\preloved.xlsx");
			int rowCount = reader.getRowCount("Sheet1"); // get row count
			int rowNum = 3;

			String fullname = reader.getCellData("Sheet1", "FullName", rowNum); // fullname
			System.out.println("The fullname is :" + fullname);
			String screenname = reader.getCellData("Sheet1", "ScreenName", rowNum); // screen name
			System.out.println("The screen name is :" + screenname);
			String address = reader.getCellData("Sheet1", "FullAddress", rowNum); // full address
			System.out.println("The full address :" + address);
			String town = reader.getCellData("Sheet1", "Town", rowNum); // town
			System.out.println("The town is :" + town);
			String postcode = reader.getCellData("Sheet1", "Postcode", rowNum); // post code
			System.out.println("The post code is :" + postcode);
			String county = reader.getCellData("Sheet1", "County", rowNum); // county
			System.out.println("The county is :" + county);
			String email = reader.getCellData("Sheet1", "Email", rowNum); // mail
			System.out.println("The  mail is :" + email);
			String telephone = reader.getCellData("Sheet1", "Telephone", rowNum); // telephone
			System.out.println("The telephone is :" + telephone);
			String password = reader.getCellData("Sheet1", "Password", rowNum); // password
			System.out.println("The password is :" + password);
			String confirmpassword = reader.getCellData("Sheet1", "ConfirmPassword", rowNum); // confirm password
			System.out.println("The confirm password is :" + confirmpassword);
			

			// fetching all test fields
			driver.findElement(By.xpath("//*[@class='input--stroked'and @id ='title']")).click();// DROPDOWN button
			Thread.sleep(5000);
			driver.findElement(By.xpath("//option[text()='Mrs']")).click();//click on dropdown
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='fullName']")).sendKeys(fullname);//fullname
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='screenName']")).sendKeys(screenname);//screename
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address);// address
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='town']")).sendKeys(town); // town
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='county']")).sendKeys(county);// county
			Thread.sleep(2000);
			//scroll down so that it can easily find elements
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys(postcode); // postcode
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"countryCode\"]")).click();//country dropdown
			Thread.sleep(5000);
			driver.findElement(By.xpath("//option[text()='PAKISTAN']")).click();//click on dropdown
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email); // confirm password
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='showEmail']")).click();//email checkbox
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@name='TelephoneType']")).click();//telephone DROPDOWN button
			Thread.sleep(5000);
			driver.findElement(By.xpath("//option[text()='Daytime']")).click();//click on drop down
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='telephone']")).sendKeys(telephone); // telephone  number typed
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='showTelephone']")).click();//check box of telephone
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password); //password
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='passwordVal']")).sendKeys(confirmpassword); // confirm password
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");
			driver.findElement(By.xpath("//*[@id='unsubscribed0']")).click();//RADIO BUTTON OF YES & NO
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tandc\"]")).click();//terms and privacy checkbox
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='pl-register-joinbutton']")).click();//join button
			Thread.sleep(2000);

			WebElement facebook = driver.findElement(By.xpath("//*[@id=\"pl-myaccount\"]/h1"));
			String actual = facebook.getText();
			System.out.println("Actual Result is: " + actual); // print actual result
			reader.setCellData("Sheet1", "Actual", rowNum, actual);
			String act = reader.getCellData("Sheet1", "Actual", rowNum);
			String expected = reader.getCellData("Sheet1", "Expected", rowNum);
			System.out.println("Expected Result is: " + expected); // print expected result
			System.out.println("This is Test Case: " + (rowNum - 1));
			String pass = "pass";
			String fail = "fail";
			if (expected.equals(act)) {
				reader.setCellData("Sheet1", "Status", rowNum, pass);
				System.out.println("The test is " + pass);
			} else {
				reader.setCellData("Sheet1", "Status", rowNum, fail);
				System.out.println("The test is " + fail);

			}
	  }
	

	 @BeforeMethod
	public void invoke() {
		 DriverInstanceCreation inv=new DriverInstanceCreation();
		inv.BrowserInvoke(driver);
	}
	 
	 @AfterMethod
	 public void close() {
		 DriverInstanceCreation clo=new DriverInstanceCreation();
			clo.closeDriver(driver);
	 }
}
