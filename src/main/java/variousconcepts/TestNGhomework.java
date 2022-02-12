package variousconcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGhomework {
	
	WebDriver driver;
	String browser;
	String url;
	
	//storing element using By class

	By USERNAME_FIELD= By.xpath("//input[@id='username']");
	By PASSWORD_FIELD=By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD=By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By CUSTOMER_MENU_FIELD=By.xpath("//span[contains(text(),'Customers')]");
	By ADD_CUSTOMER_MENU_FIELD=By.xpath("//a[contains(text(),'Add Customer')]");
	By CONTACT_HEADER_FIELD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By FULL_NAME_FIELD=By.xpath("//*[@id=\"account\"]");
	By COMPANY_DROPDOWN_FIELD=By.xpath("//*[@id=\"cid\"]");
	//By COMPANY_DROPDOWN_FIELD=By.xpath("//select[@id=cid]");
	By EMAIL_FIELD=By.xpath("//*[@id=\"email\"]");
	By PHONE_FIELD=By.xpath("//*[@id=\"phone\"]");
	By ADDRESS_FIELD=By.xpath("//*[@id=\"address\"]");
	By CITY_FIELD=By.xpath("//*[@id=\"city\"]");
	By STATE_REGION_FIELD=By.xpath("//*[@id=\"state\"]");
	By ZIP_POSTALCODE_FIELD=By.xpath("//*[@id=\"zip\"]");
	By COUNTRY_DROPDOWN_FIELD=By.xpath("//*[@id=\"select2-country-container\"]");
	By SAVE_BUTTON_FIELD=By.xpath("//*[@id=\"submit\"]");
	//By CUSTOMERS_LIST_FIELD=By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a");
	
	//Login Data
	String Username="demo@techfios.com";
	String Password="abc123";
	
	//Test Data
	String FullName="David nancy";
	String Company="Techfios";
	String email="nancy@gmail.com";
	String phone="123-789-9078";
	String address="340 lane";
	String City="allen";
	String State="Texas";
	String Zipcode="23458";
	String Country="United States";
	
	@BeforeClass
	public void readconfig() {
		try {
			InputStream input=new FileInputStream("src\\main\\java\\config\\config.properties");
			Properties prop=new Properties();
			prop.load(input);
			browser=prop.getProperty("browser");
			url=prop.getProperty("url");
		}catch(IOException e) {
		e.printStackTrace();	
		}
	}
	
	@BeforeMethod
	
	public void init() {
		if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
			 driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","driver\\gecko.exe");
		}
	//System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");	
		 //driver=new ChromeDriver();
		 driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		
	}

		
		
	

	@Test(priority=1)
	public void LoginTest() {
		
	//	By USERNAME_FIELD= By.xpath("//input[@id='username']");
	//	By PASSWORD_FIELD=By.xpath("//input[@id='password']");
	//	By SIGNIN_BUTTON_FIELD=By.xpath("/html/body/div/div/div/form/div[3]/button");
	//    By DASHBOARD_HEADER_FIELD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	//	By CUSTOMER_MENU_FIELD=By.xpath("//span[contains(text(),'Customers')]");
	//	By ADD_CUSTOMER_MENU_FIELD=By.xpath("//a[contains(text(),'Add Customer')]");
		
		driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		String actual=driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		Assert.assertEquals(actual,"Dashboard","Wrong Page");
	}
		@Test(priority=2)
		public void AddcontactTest() {
			

			driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
			driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
			driver.findElement(SIGNIN_BUTTON_FIELD).click();
			String actual=driver.findElement(DASHBOARD_HEADER_FIELD).getText();
			Assert.assertEquals(actual,"Dashboard","Wrong Page");	
		
		
			
		driver.findElement(CUSTOMER_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		
		//By CONTACT_HEADER_FIELD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		String actualcontact=driver.findElement(CONTACT_HEADER_FIELD).getText();
		Assert.assertEquals(actualcontact,"Contacts","Wrong Page");
		
	//	By FULL_NAME_FIELD=By.xpath("//*[@id=\"account\"]");
	//	By COMPANY_FIELD=By.xpath("//*[@id=\"cid\"]");
	//	By EMAIL_FIELD=By.xpath("//*[@id=\"email\"]");
	//	By PHONE_FIELD=By.xpath("//*[@id=\"phone\"]");
	//	By ADDRESS_FIELD=By.xpath("//*[@id=\"address\"]");
	//	By CITY_FIELD=By.xpath("//*[@id=\"city\"]");
	//	By STATE_REGION_FIELD=By.xpath("//*[@id=\"state\"]");
	//	By ZIP_POSTALCODE_FIELD=By.xpath("//*[@id=\"zip\"]");
		//By COUNTRY_DROPDOWN_FIELD=By.xpath("//*[@id=\"select2-country-container\"]"); 
		
		//By SAVE_BUTTON_FIELD=By.xpath("//*[@id=\"submit\"]");
		Random rnd=new Random();
		int generatedNumber=rnd.nextInt(999);
		
		
		
		
		driver.findElement(FULL_NAME_FIELD).sendKeys(FullName+generatedNumber );
		
   
    
		//selectFromDropdown(driver.findElement(COMPANY_DROPDOWN_FIELD),Company);
		
		driver.findElement(EMAIL_FIELD).sendKeys(generatedNumber + email);
		driver.findElement(PHONE_FIELD).sendKeys(phone +""+ generatedNumber);
		driver.findElement(ADDRESS_FIELD).sendKeys(address);
		driver.findElement(CITY_FIELD).sendKeys(City);
		driver.findElement(STATE_REGION_FIELD).sendKeys(State);
		driver.findElement(ZIP_POSTALCODE_FIELD).sendKeys(Zipcode);
		
		//Select sele=new Select(driver.findElement(COUNTRY_DROPDOWN_FIELD));
	//sele.selectByVisibleText(Country);
		
		//driver.findElement(COUNTRY_DROPDOWN_FIELD).sendKeys("United States");
	selectFromDropdown(driver.findElement(COUNTRY_DROPDOWN_FIELD),Country);
	
		driver.findElement(SAVE_BUTTON_FIELD).click();
		driver.navigate().back();
		//driver.findElement(CUSTOMERS_LIST_FIELD).click();
		
	
	}

private void selectFromDropdown(WebElement dropdownElement, String VisibleText) {
		// TODO Auto-generated method 
	  Select sel=new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
	     sel.selectByVisibleText(Company);
	
}
	 
		// TODO Auto-generated method stub
		
	
//	@AfterMethod
  public void teardown() {
		
	 driver.close();
	 driver.quit();
	  
	}
}
