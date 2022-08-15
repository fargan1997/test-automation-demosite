package demosite_shop;

import static org.testng.Assert.assertEquals;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNG_demo {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String URL = "https://demosite.appvance.com";
		driver.get(URL);
	}
		
	@Test(priority = 1)
	public void choose4DifferentsItems()
	{
		clickElement(driver, "/html/body/div[2]/div/div/div/div[2]/div[1]/div/div[1]/a/span\r\n");
		clickElement(driver, "//*[@id=\"add-to-cart-button\"]\r\n");
		goToHome(driver);
		clickElement(driver, "/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/a/span\r\n");
		clickElement(driver, "//*[@id=\"add-to-cart-button\"]\r\n");
		goToHome(driver);
		clickElement(driver, "/html/body/div[2]/div/div/div/div[2]/div[4]/div/div[1]/a/span\r\n");
		clickElement(driver, "//*[@id=\"add-to-cart-button\"]\r\n");
		goToHome(driver);
		clickElement(driver, "/html/body/div[2]/div/div/div/div[2]/div[3]/div/div[1]/a/span\r\n");
		clickElement(driver, "//*[@id=\"add-to-cart-button\"]\r\n");
	}
	
	@Test(priority = 2)
	public void changeQuantity()
	{
		writeElement(driver, "//*[@id=\"order_line_items_attributes_0_quantity\"]", "5");
	}
	
	@Test(priority = 3)
	public void clickUpdateButton()
	{
		clickElement(driver, "//*[@id=\"update-button\"]");
	}
	
	@Test(priority = 4)
	public void clickOnCheckout()
	{
		clickElement(driver, "//*[@id=\"checkout-link\"]");
	}
	
	@Test(priority = 5)
	public void clickOnInputEmail()
	{
		writeElement(driver, "//*[@id=\"spree_user_email\"]", "prueba_07@example.com");
	}
	
	@Test(priority = 6)
	public void writePassword()
	{
		writeElement(driver, "//*[@id=\"spree_user_password\"]", "rodri97");
		writeElement(driver, "//*[@id=\"spree_user_password_confirmation\"]", "rodri97");
		clickElement(driver, "//*[@id=\"new_spree_user\"]/div/p/input");
	}
	
	@Test(priority = 7)
	public void completeAdressForm()
	{
		writeElement(driver, "//*[@id=\"order_bill_address_attributes_firstname\"]", "Rodrigo");
		writeElement(driver, "//*[@id=\"order_bill_address_attributes_lastname\"]", "Munoz");
		writeElement(driver, "//*[@id=\"order_bill_address_attributes_address1\"]", "Av. de los robles");
		writeElement(driver, "//*[@id=\"order_bill_address_attributes_address2\"]", "Col. Villa Jacarandas");
		writeElement(driver, "//*[@id=\"order_bill_address_attributes_city\"]", "Torreon");
		selectElement(driver, "//*[@id=\"order_bill_address_attributes_country_id\"]", "United States of America");
		selectElement(driver, "//*[@id=\"order_bill_address_attributes_state_id\"]", "Alaska");
		writeElement(driver, "//*[@id=\"order_bill_address_attributes_zipcode\"]", "99786");
		writeElement(driver, "//*[@id=\"order_bill_address_attributes_phone\"]", "8711612772");
		clickElement(driver, "//*[@id=\"checkout_form_address\"]/div[3]/input");
	}
	
	@Test(priority = 8)
	public void completeDeliveryForm()
	{
		clickElement(driver, "//*[@id=\"checkout_form_delivery\"]/div[2]/input");
	}
	
	@Test(priority = 9)
	public void completePaymentForm()
	{
		writeElement(driver, "//*[@id=\"name_on_card_2\"]", "Rodrigo Munoz");
		WebElement cardNumber = driver.findElement(By.xpath("//input[@id=\"card_number\"]"));
		cardNumber.sendKeys("4263");
		cardNumber.sendKeys("9826");
		cardNumber.sendKeys("4026");
		cardNumber.sendKeys("9299");
		WebElement expirationNumber = driver.findElement(By.xpath("//*[@id=\"card_expiry\"]"));
		expirationNumber.sendKeys("02");
		expirationNumber.sendKeys("23");
		writeElement(driver, "//*[@id=\"card_code\"]", "837");
		clickElement(driver, "//*[@id=\"checkout_form_payment\"]/div[2]/input");
	}
	
	@Test(priority = 10)
	public void validatePurchase()
	{
		clickElement(driver, "//*[@id=\"checkout_form_confirm\"]/div[2]/input");
		clickElement(driver, "//*[@id=\"order_payments_attributes__payment_method_id_3\"]");
		clickElement(driver, "//*[@id=\"checkout_form_payment\"]/div[2]/input");
	}
	@Test(priority = 11)
	public void wait2sec()
	{
		try
		{
			Thread.sleep(2000);
		}catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	//Methods
	public static void writeElement (WebDriver driver, String xpath, String text)
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(text);
	}
	
	public static void clickElement (WebDriver driver, String xpath)
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
	}
	
	public static void selectElement (WebDriver driver, String xpath, String value)
	{
		Select select = new Select (driver.findElement(By.xpath(xpath)));
		select.selectByVisibleText(value);
	}
	
	public static void goToHome (WebDriver driver)
	{
		clickElement(driver, "//li[@id=\"home-link\"]");
	}
}
