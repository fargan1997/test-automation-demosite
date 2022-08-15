package demosite_shop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class demosite_main {
	
	
	
	public static void main(String[] args) {
		
		//Setup driver
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String URL = "https://demosite.appvance.com";
		driver.get(URL);
		
		//Choose 4 different items from 1 Brands and 1 from category
		//1
		clickElement(driver, "/html/body/div[2]/div/div/div/div[2]/div[1]/div/div[1]/a/span\r\n");
		clickElement(driver, "//*[@id=\"add-to-cart-button\"]\r\n");
		goToHome(driver);
		//2
		clickElement(driver, "/html/body/div[2]/div/div/div/div[2]/div[2]/div/div[1]/a/span\r\n");
		clickElement(driver, "//*[@id=\"add-to-cart-button\"]\r\n");
		goToHome(driver);
		//3
		clickElement(driver, "/html/body/div[2]/div/div/div/div[2]/div[4]/div/div[1]/a/span\r\n");
		clickElement(driver, "//*[@id=\"add-to-cart-button\"]\r\n");
		goToHome(driver);
		//4
		clickElement(driver, "/html/body/div[2]/div/div/div/div[2]/div[3]/div/div[1]/a/span\r\n");
		clickElement(driver, "//*[@id=\"add-to-cart-button\"]\r\n");
		
		//Change the Quantity
		writeElement(driver, "//*[@id=\"order_line_items_attributes_0_quantity\"]", "5");
		
		//Click on Update button 
		clickElement(driver, "//*[@id=\"update-button\"]");
		
		//Click on checkout
		clickElement(driver, "//*[@id=\"checkout-link\"]");
		
		//Click on input email
		writeElement(driver, "//*[@id=\"spree_user_email\"]", "prueba_02@example.com");
		//Write a password
		writeElement(driver, "//*[@id=\"spree_user_password\"]", "rodri97");
		writeElement(driver, "//*[@id=\"spree_user_password_confirmation\"]", "rodri97");
		clickElement(driver, "//*[@id=\"new_spree_user\"]/div/p/input");
		
		//Complete Adress form
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
		
		//Complete Delivery form
		clickElement(driver, "//*[@id=\"checkout_form_delivery\"]/div[2]/input");
		
		//Complete Payment form
		writeElement(driver, "//*[@id=\"name_on_card_2\"]", "Rodrigo Munoz");
		//writeElement(driver, "//input[@id=\"card_number\"]", "4263982640269299");
		//writeElement(driver, "//*[@id=\"card_expiry\"]", "022023");
		//Input card number
		WebElement cardNumber = driver.findElement(By.xpath("//input[@id=\"card_number\"]"));
		cardNumber.sendKeys("4263");
		cardNumber.sendKeys("9826");
		cardNumber.sendKeys("4026");
		cardNumber.sendKeys("9299");
		//Input Expiration number
		WebElement expirationNumber = driver.findElement(By.xpath("//*[@id=\"card_expiry\"]"));
		expirationNumber.sendKeys("02");
		expirationNumber.sendKeys("23");
		writeElement(driver, "//*[@id=\"card_code\"]", "837");
		clickElement(driver, "//*[@id=\"checkout_form_payment\"]/div[2]/input");
		//Validated the purchase was complete
		clickElement(driver, "//*[@id=\"checkout_form_confirm\"]/div[2]/input");
		clickElement(driver, "//*[@id=\"order_payments_attributes__payment_method_id_3\"]");
		clickElement(driver, "//*[@id=\"checkout_form_payment\"]/div[2]/input");
		
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
